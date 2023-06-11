stop-docker:
	docker-compose down

start-docker:
	docker-compose up -d --build

clean:
	mvn clean

test:
	mvn test

run:
	mvn spring-boot:run

all: start-docker clean test run