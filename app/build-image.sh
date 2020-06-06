#!/usr/bin/env bash
# A build docker image with spring-boot maven goal
#./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=anyulled/capstone

# B build with Dockerfile
docker build -t anyulled/capstone:latest .

docker image ls

docker run --name capstone -p8080:8080 anyulled/capstone:latest
