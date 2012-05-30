(ns boomer.views.welcome
  (:require [boomer.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core]
        [hiccup.core]))

(defpartial hello [person]
    [:p "Hello " person])

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to boomer"]))


(defpage "/my-page" []
  (html
    [:h1 "This is my first test page"]))


(defpage "/hello" []
  (hello "Onno"))

