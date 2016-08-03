#!/bin/bash
docker build -t dev-test --build-arg repo=$1 docker
