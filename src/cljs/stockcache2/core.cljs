(ns stockcache2.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:data (range 0 256)}))

(defn root-component [app owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js { :style #js { :pointerEvents "none" :top "calc(50% - 250px)" :left "calc(50% - 150px)" :position "absolute" } }
        (reverse
          (map #(dom/div #js { :className "fade" :key (str "particle_" %) :style #js {

            :color (str "rgba(" (rand-int 256) "," (rand-int 256) "," (rand-int 256) "," 0.8 ")")
            :fontSize (str (/ % 1.2) "px")
            :textAlign "center"
            :position "absolute"
            :top (str (rand-int 300) "px")
            :left (str (rand-int 300) "px") } } "o") (:data app)))))))

(om/root
 root-component
 app-state
 {:target (js/document.getElementById "app")})
