(ns weekdaycalculator.web
  (:use compojure.core, ring.adapter.jetty, weekdaycalculator.core)
  (:require [compojure.route :as route]))

(defroutes main-routes
  (GET ["/parse/:datestring" :datestring #".*"] [datestring]
    (str "<h1> The date for " datestring " is " (calculate-day-of-week datestring) "</h1>"))
  (route/not-found "<h1>Page not found</h1>"))

(run-jetty main-routes {:port 1234})