(ns stockcache2.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [stockcache2.core-test]
   [stockcache2.common-test]))

(enable-console-print!)

(doo-tests 'stockcache2.core-test
           'stockcache2.common-test)
