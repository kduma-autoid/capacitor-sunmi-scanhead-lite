#!/bin/sh

# Source: https://stackoverflow.com/a/1482133
dir=$( dirname -- "$( readlink -f -- "$0"; )"; )

# Source: https://stackoverflow.com/a/64390598
increment_version() {
  local delimiter=.
  local array=($(echo "$1" | tr $delimiter '\n'))
  array[$2]=$((array[$2]+1))
  if [ $2 -lt 2 ]; then array[2]=0; fi
  if [ $2 -lt 1 ]; then array[1]=0; fi
  echo $(local IFS=$delimiter ; echo "${array[*]}")
}

number=$(sed '3q;d' "${dir}/../example/config.yaml")
number=${number#*: }
((new_number=number+1))
echo "BUILD=$new_number"

version=$(sed '5q;d' "${dir}/../example/config.yaml")
version=${version#*: }

if [[ ${1:-2} -gt 2 ]]
then
  new_version=${version}
else
  new_version=$(increment_version ${version} ${1:-2})
fi
echo "VERSION=$new_version"

sed -e "3s/$number/$new_number/;5s/$version/$new_version/" "${dir}/../example/config.yaml" > "${dir}/../example/config.yaml.tmp" \
  && mv "${dir}/../example/config.yaml.tmp" "${dir}/../example/config.yaml"


