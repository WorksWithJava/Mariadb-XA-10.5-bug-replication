#!/bin/bash

mvn clean package
java -jar ./target/xa_stress_tester.jar --spring.profiles.active=insert
