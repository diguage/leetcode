#!/usr/bin/env bash

cd ..

mvn clean package

git switch gh-pages

rm -rf images assets index.html

mv target/docs/html/* .

git add *.html assets/ images/

git commit -am "`date +"%Y-%m-%d %H:%M:%S"`"

git push -f origin gh-pages

git switch master

cd tools
