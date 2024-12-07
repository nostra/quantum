#!/bin/sh

make
echo "Running make upon change of md file"
fswatch -0 *.md | xargs -0 -I {} make
