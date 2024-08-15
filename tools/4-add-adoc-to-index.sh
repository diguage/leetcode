#!/usr/bin/env bash

for file in *.adoc
do
  filename=$(basename -- "$file")
  # https://stackoverflow.com/a/57158235
  if ! grep -q $filename "index.adoc"; then
    echo "$filename"
    # https://unix.stackexchange.com/a/99351
    echo -e "// include::${filename}[leveloffset=+1]\n" >> ./index.adoc
  fi
done
