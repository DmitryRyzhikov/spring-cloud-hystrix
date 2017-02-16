### Relevant Articles:
- [A Guide to Spring Cloud Netflix – Hystrix](http://www.baeldung.com/spring-cloud-netflix-hystrix)
- [Hystrix project](https://github.com/Netflix/Hystrix)
- [How to use Hystrix](https://github.com/Netflix/Hystrix/wiki/How-To-Use)

# TABLE of CONTENTS
*[PRODUCER](#PRODUCER)

# PRODUCER
* To run producer
    - Run maven target: rest-producer [spring-boot:run]
* To check that producer is working


    curl http://localhost:9090/greeting/Cid
        Expected output:
    Hello Cid!

# CONSUMER HYSTRIX
Consumer is the service that should access working producer via RestTemplate. Works via Hystrix - that
mean that in case if PRODUCER will not be available, Hystrix fallback method will work.

@EnableCircuitBreaker - will scan classpath for @HystrixCommand annotated methods.

* To run consumer
    - Run maven target: rest-consumer [spring-boot:run]
* To check that consumer is working type in browser:



    http://localhost:8080/get-greeting/Cid
    curl http://localhost:8080/get-greeting/Cid

    Expected output:
    Hello Cid!
* To check that Hystrix fallback is working - shut down PRODUCER and type in browser. Insted of greeting to Cid,
greeting to user will be shown.


    http://localhost:8080/get-greeting/Cid

    Expected output:
    Hello User!
* If we will start producer again, consumer will show greeting to Cid.

# CONSUMER HYSTRIX+FEIGN
This consumer uses Feign instead of rest template.
* To run consumer
    - Run maven target: feign-rest-consumer [spring-boot:run]
* To check that consumer is working:


    curl http://localhost:8082/get-greeting/Cid
* To check that Hystrix fallback is working - shut down PRODUCER and type in browser. Insted of greeting to Cid,
greeting to user will be shown.


# ENABLE HYSTRIX DASHBOARD
* Add dependencies


        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
            <version>1.1.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>1.4.0.RELEASE</version>
        </dependency>
* Add annotation @EnableHystrixDashboard on configuration of application to monitor
* To get access to [hystix dashboard](http://localhost:8080/hystrix)
* Single Hystrix App: http://hystrix-app:port/hystrix.stream, for example for consumers above:

http://localhost:8080/hystrix.stream
http://localhost:8082/hystrix.stream


