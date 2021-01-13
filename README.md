# bytework-test
ServeByte Service provider-Food, Laundary, Pharmacy and Grosary

Setup Procedure
1. Download the ip and clone using git clone https://github.com/philipafemikhe/bytework-test.git
2. This will clone both the Spring Boot Api (servbyte) and the Angular frontend(Servbyte-frontend)

API
====
3. Open the servbyte (Spring Boot) Api in your prefered aditor eg intellij
4. Open Pom.xml, right click and re-import maven dependencies
Note

In the application.properties file, the server port number is 8070 and other connection parameters are provided herein

If you desire to change the port number, you can do so but the port number must tally with the one defined in the Angular services

Angular
=====
CD to the angular folder and run ng serve and it will run on port 4200

API access Points

http://localhost:8080/api/vendor/create  creates food vendor

http://localhost:8080/api/signup   creates a general account account where account type specifies whether you are a service provider, Customer or Transporter
http://localhost:8080/api/vendor/all  get list of vendors
http://localhost:8080/api/vendor/meal/add/1  Add meal toprovider Meal list
http://localhost:8080/api/customer  get list of customers

