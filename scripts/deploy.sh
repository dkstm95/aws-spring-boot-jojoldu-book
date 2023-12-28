#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=aws-spring-boot-jojoldu-book

echo "> Copy Build file"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Check pid of current application"

CURRENT_PID=$(pgrep -fl $PROJECT_NAME | grep java | awk '{print $1}')

echo "> Pid of current application: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
	echo "> No current application"
else
	echo "> kill -15 $CURRENT_PID"
	kill -15 "$CURRENT_PID"
	sleep 5
fi

echo "> Deploy new application"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> Grant $JAR_NAME"

chmod +x "$JAR_NAME"

echo "> Execute $JAR_NAME"

nohup java -jar -Dspring.config.location=classpath:/application.yml,classpath:/application-real.yml,/home/ec2-user/app/application-oauth.yml,/home/ec2-user/app/application-real-db.yml -Dspring.profiles.active=real "$JAR_NAME" > $REPOSITORY/nohup.out 2>&1 &