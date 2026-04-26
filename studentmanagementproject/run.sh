#!/bin/bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.student.management.system.Main"