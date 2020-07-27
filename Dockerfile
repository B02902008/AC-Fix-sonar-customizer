FROM sonarqube:8.4.1-community
MAINTAINER Chen, Hong-Wun from SELab in Department of CSIE, NTU
ADD sonar-customize.sh /opt/sonarqube
ADD build/libs/sonar-customizer-1.0.jar /opt/sonarqube/lib/common/
WORKDIR /opt/sonarqube
RUN ["/bin/sh", "sonar-customize.sh"]
