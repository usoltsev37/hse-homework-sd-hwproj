#!/usr/bin/env bash

sudo docker stop app-db
sudo docker rm app-db
sudo docker rmi hwproj-db
sudo docker build -t hwproj-db .
sudo docker run --entrypoint "/bin/bash" -it --name app-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d hwproj-db
sudo docker start app-db