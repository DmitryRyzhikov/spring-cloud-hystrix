### Relevant Articles:
- [A Guide to Spring Cloud Netflix – Hystrix](http://www.baeldung.com/spring-cloud-netflix-hystrix)

# PRODUCER
* To run producer
    - Run maven target: rest-producer [spring-boot:run]
* To check that producer is working


    curl http://localhost:9090/greeting/Cid
        Expected output:
    Hello Cid!

# CONSUMER
Consumer is the service that should access working producer via RestTemplate. Works via Hystrix - that
mean that in case if PRODUCER will not be available, Hystrix fallback method will work.

@EnableCircuitBreaker - will scan classpath for @HystrixCommand annotated methods.

* To run consumer
    - Run maven target: rest-consumer [spring-boot:run]
* To check that consumer is working type in browser:



    http://localhost:8080/get-greeting/Cid

    Expected output:
    Hello Cid!
* To check that Hystrix fallback is working - shut down PRODUCER and type in browser. Insted of greeting to Cid,
greeting to user will be shown.


    http://localhost:8080/get-greeting/Cid

    Expected output:
    Hello User!
* If we will start producer again, consumer will show greeting to Cid.
