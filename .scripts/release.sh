#!/bin/sh

# Source: https://stackoverflow.com/a/1482133
dir=$( dirname -- "$( readlink -f -- "$0"; )"; )

if [ -z "$(cd "$dir/../" && git status --porcelain)" ]
then
  cd "$dir/../.scripts/" && ./bump_version.sh
  cd "$dir/../example/" && npm install && npm run build_no_increment
  cd "$dir/../" && npm install && npm run verify && npm run build
else
  echo "Working directory not clean. Please commit all changes before releasing."
fi