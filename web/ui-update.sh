#!/usr/bin/env bash

WEB_ID=web_1_738419406
PROJECT_FOLDER=/Users/vitaliizinchenko/work/projects/GS/FTS/article/demo
XAP_FOLDER=/Users/vitaliizinchenko/work/projects/GS/CLI/xap-premium/xap-dist/target/package/product

yes | cp -i $PROJECT_FOLDER/web/src/main/webapp/WEB-INF/pages/* $XAP_FOLDER/work/processing-units/$WEB_ID/WEB-INF/pages
yes | cp -i $PROJECT_FOLDER/web/src/main/webapp/WEB-INF/js/* $XAP_FOLDER/work/processing-units/$WEB_ID/WEB-INF/js
yes | cp -i $PROJECT_FOLDER/web/src/main/webapp/WEB-INF/css/* $XAP_FOLDER/work/processing-units/$WEB_ID/WEB-INF/css