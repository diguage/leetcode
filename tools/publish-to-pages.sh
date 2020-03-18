#!/usr/bin/env bash

cd ..

mvn clean package

git switch gh-pages

rm -rf images assets index.html *.svg

mv target/docs/html/* .

cd tools

./fix-toc.py

cd ..

git add *.html assets/ images/ *.svg

git commit -am "`date +"%Y-%m-%d %H:%M:%S"`"

git push -f origin gh-pages

git switch master

cd tools
