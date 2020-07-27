# SonarQube Customizer

###### Author: Chen, Hong-Wun

###### Organization: SELab in Department of CSIE, NTU

---

This project is a submodule of AC-Fix.

This project customizes SonarQube web server to serve AC-Fix.

## Customization

1. Overwrite default SecurityServletFilter
2. Hide header-navigation, footer, and scroll bar

## Build Project

To build this project, JDK 11 is required.

Build command: ```./gradlew build```

## Build Docker Image

To build a Docker image, make sure you have installed Docker.

Build command: ```./gradlew buildDockerImage```