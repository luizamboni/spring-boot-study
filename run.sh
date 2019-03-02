#!/bin/bash

docker-compose kill

docker-compose -f rm

docker-compose build

docker-compose up