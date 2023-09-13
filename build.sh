#!/bin/bash

rm -rf target/
./mvnw -Pnative clean native:compile