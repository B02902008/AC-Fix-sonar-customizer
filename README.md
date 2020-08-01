# SonarQube Customizer

###### Author: Chen, Hong-Wun

###### Organization: SELab in Department of CSIE, NTU

---

This project is a submodule of AC-Fix.

This project customizes SonarQube web server to serve AC-Fix.

## System Requirement

- JDK 11
- Docker

## Customization

1. Overwrite default SecurityServletFilter
2. Hide header-navigation, footer, homepage link, and scroll bar

## Build Project

Build command: ```./gradlew clean build```

## Options

Default to allow client from ```localhost:4200``` to load SonarQube content to iframe.

Set the following properties to allow client from desired origin.

- ```acfix.client.host```: Set this properties to ```*``` to allow all
- ```acfix.client.port```
