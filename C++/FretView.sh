#!/bin/bash

#build scales
cd scales
make all

#build messages
cd ../messages
make all

#build instructions
cd ../instructions
make all

#build FretView
cd ../
make all
