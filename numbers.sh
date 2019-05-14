#!/usr/bin/env bash
if [ -n "$1" ]
then
  java -jar target/uberjar/numbers-0.1.0-standalone.jar $1 $0
else
  echo "Usage: $0 n # n between 1 and 1000"
fi
