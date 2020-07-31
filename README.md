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

Build command: ```./gradlew build```

Default to allow client from ```localhost:4200``` to load SonarQube content to iFrame.

Add ```-PAC_FIX_HOST=[HOST]``` and ```-PAC_FIX_CLIENT_PORT=[PORT]``` to allow desired origin.

## Build Docker Image

Build command: ```./gradlew buildDockerImage```

This will build a Docker image with tag ```ac-fix/ac-fix-sonarqube:1.0```

Run the image with command like:

```docker volume create ACFixSonarData```

```docker run -d -p 9000:9000 -v ACFixSonarData:/opt/sonarqube/data [IMAGE ID]```