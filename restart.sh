#!/usr/bin/env bash

# XAP_HOME="/Users/vitaliizinchenko/apps/gigaspaces-xap-enterprise-12.0.0-ga-b16000/bin"
XAP_HOME="/Users/vitaliizinchenko/work/projects/GS/CLI/xap-premium/xap-dist/target/package/product/bin"

mvn clean install

"$XAP_HOME/gs.sh" undeploy web

"$XAP_HOME/gs.sh" deploy /Users/vitaliizinchenko/work/projects/GS/FTS/article/full-text-search-demo/web/target/web.war