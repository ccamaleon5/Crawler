FROM openjdk:8

ARG artifact_id
ARG artifact_version

ENV artifact ${artifact_id}-${artifact_version}.jar

# Create app directory
WORKDIR /usr/src/app/${artifact_id}

# Install app dependencies
COPY target/${artifact} /usr/src/app/${artifact_id}/${artifact}
COPY websites.txt /usr/src/app/websites.txt

EXPOSE 8080

CMD ["sh", "-c", "java -jar ${artifact} /usr/src/app/websites.txt"]