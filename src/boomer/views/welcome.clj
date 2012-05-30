(ns boomer.views.welcome
  (:require [boomer.views.common :as common]
            [noir.content.getting-started]
            [noir.response :as resp])
  (:use [noir.core]
        [hiccup.core]
        [hiccup.page]
        [hiccup.form]))


(defpartial hello [person]
    [:p "Hello " person])


(defpartial layout [& content]
  (html5
    [:head
     [:title "Contact"]]
    [:body
     content]))

(defpartial form-field [description name & value]
  (html [:div
          (label name description)
          (text-field name value)]))


(defpartial user-fields [{:keys [firstname lastname]}]
  (form-field "First name: " "firstname")
  (form-field "Last name: " "lastname"))


(defpage "/welcome" []
         (common/layout
           [:p "Welcome to boomer"]))


(defpage "/my-page" []
  (html
    [:h1 "This is my first test page"]))


(defpage "/hello" []
  (hello "Onno"))


(defpage "/contact" {:as contact}
  (layout
    (form-to [:post "/mailer"]
             (user-fields contact)
             (submit-button "Submit"))))



