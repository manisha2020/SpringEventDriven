# SpringEventDriven
1. Git Clone to clone git project
2. Import Project in your IDE
3. Java Build Path check JRE version should be 8 
4. Install RabbitMQ using below steps 
5. Run MessageProducer application first its producer 
6. Run Hotelbooking project as Spring boot app which is consumer
7. Test rest api http://localhost:8080/roomsthymeleaf
8. H2 DB :http://localhost:8080/h2-console/login.jsp

 Installing RabbitMQ on Mac
https://brew.sh
Any other OS insatllation refer --> https://www.rabbitmq.com/download.html
brew update
brew install rabbitmq
if you get below error :
error: Not a valid ref: refs/remotes/origin/master fatal: ambiguous argument 'refs/remotes/origin/master':

run 
rm -fr $(brew --repo homebrew/core)  # because you can't `brew untap homebrew/core`
brew tap homebrew/core

brew update
brew install rabbitmq

export PATH=$PATH:/usr/local/sbin

rabbitmq-server

http://localhost:15672/#/

username password is guest

Upon Successful execution you can see message is consumed....

2021-05-30 02:17:40.304  INFO 36651 --- [    container-1] c.h.async.RoomCleanerListener            : ROOM 201:EASTWING needs to be cleaned
