(ns boomer.views.mailer
  (:use [noir.core]))


(defn valid? [{:keys [firstname lastname]}]
  true)

(defpage [:post "/mailer"] {:as user}
  (if (valid? user)
    (layout
      [:p "Sent mail!"])
    (render "/contact" user)))
