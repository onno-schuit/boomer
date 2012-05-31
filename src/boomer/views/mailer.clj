(ns boomer.views.mailer
  (:require [clojurewerkz.mailer.core :as mailer])
  (:use [noir.core]
        [hiccup.core]
        [hiccup.page]))

(mailer/delivery-mode! :test)

(defn valid? [{:keys [firstname lastname]}]
  true)

(defn send-mail []
  (mailer/deliver-email {:from "Joe The Robot"
                         :to ["ops@megacorp.internal" "oncall@megacorp.internal"]
                         :subject "OMG everything is down!"}
                        "email/templates/warning.mustache"
                        {:name "Joe"
                         :host "host3.megacorp.internal"})
  (html [:p "Sent mail!"]))

(defpage [:post "/mailer"] {:as user}
  (if (valid? user)
    (send-mail)
    (render "/contact" user)))
