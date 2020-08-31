#!/bin/sh
mvn clean package && docker build -t it.salt/pr_salt_1 .
docker rm -f pr_salt_1 || true && docker run -d -p 8080:8080 -p 4848:4848 --name pr_salt_1 it.salt/pr_salt_1 
