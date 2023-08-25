# spring-boot-microservices-sample
sample microservices with spring boot 3

#build common-library
mvn clean deploy -Drevision=1.0.0 -f pom.xml --settings settings.xml 

#build service
mvn spring-boot:build-image -DskipTests
