#!/usr/bin/env bash

base_path=$(cd $(dirname $BASH_SOURCE) && pwd)

fonts_path=$(cd ${base_path}/.. && pwd)/fonts

case "$(uname -s)" in

  Darwin)
    # Do something under Mac OS X platform
    # https://apple.stackexchange.com/a/240382
    target_path=$HOME/Library/Fonts
    ;;

  Linux)
    # Do something under GNU/Linux platform
    target_path=$HOME/.fonts
    ;;

  CYGWIN*|MINGW32*|MSYS*|MINGW*)
    echo 'MS Windows'
    ;;

  *)
    echo 'Other OS'
    ;;
esac

if [ -z "${target_path}" ]
then
  echo "\$target_path is empty."
  exit 1;
fi

if [ ! -d "${target_path}" ]; then
  echo "mkdir ${target_path}"
  mkdir -p $target_path
fi

for ffile in `ls ${fonts_path}`;
do
  if [[ ! -f "${target_path}/${ffile}" ]]; then
    echo "install $ffile"
    cp "${fonts_path}/${ffile}" "${target_path}/${ffile}"
  fi
done

## Config font for BlockDiagram
blockdiagrc=${HOME}/.blockdiagrc

if [[ -f "${target_path}/SourceHanSerifSC-Regular.otf" ]]; then
  if [[ ! -f "${blockdiagrc}" ]]; then
    echo "create file: ${blockdiagrc}"
    touch ${blockdiagrc}
  fi
fi

if ! grep -q "seqdiag" "${blockdiagrc}"; then
  echo "config font for seqdiag."
  echo -e "\n[seqdiag]\nfontpath = ${target_path}/SourceHanSerifSC-Regular.otf" >> ${blockdiagrc}
fi

if ! grep -q "blockdiag" "${blockdiagrc}"; then
  echo "config font for blockdiag."
  echo -e "\n[blockdiag]\nfontpath = ${target_path}/SourceHanSerifSC-Regular.otf" >> ${blockdiagrc}
fi

if ! grep -q "actdiag" "${blockdiagrc}"; then
  echo "config font for actdiag."
  echo -e "\n[actdiag]\nfontpath = ${target_path}/SourceHanSerifSC-Regular.otf" >> ${blockdiagrc}
fi

if ! grep -q "nwdiag" "${blockdiagrc}"; then
  echo "config font for nwdiag."
  echo -e "\n[nwdiag]\nfontpath = ${target_path}/SourceHanSerifSC-Regular.otf" >> ${blockdiagrc}
fi
