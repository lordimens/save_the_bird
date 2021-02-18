FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact

WORKDIR /artifact

RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization:token" https://api.github.com/repos/lordimens/save_the_bird/actions/artifacts/41155741/zip --output game.zip

RUN unzip game.zip

CMD ["java", "-jar", "CHROME_DINO-1.0-SNAPSHOT.jar"]