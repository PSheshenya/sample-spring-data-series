# sample-spring-data-rest

## Overview
Spring Data REST is built on top of the Spring Data project and makes it easy to build hypermedia-driven REST web services that connect to Spring Data repositories – all using [HAL](http://stateless.co/hal_specification.html) as the driving hypermedia type

## Spring Data REST
Selected dependencies
DevTools [Core] - Spring Boot Development Tools
Actuator [Ops] - Production ready features to help you monitor and manage your application
Web [Web] - Servlet web application with Spring MVC and Tomcat
Lombok [Core] - Java annotation library which helps to reduce boilerplate code and code faster
Rest Repositories [Web] - Exposing Spring Data repositories over REST via Spring Data REST
H2 [SQL] - H2 database (with embedded support)
JPA [SQL] - Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate
Validation [Core] - JSR-303 validation infrastructure (already included with web)


### Examples

* POST Create entity
```
curl -v -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Test", "email" : "test@test.com" }' http://localhost:8080/foos
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /foos HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 47
>
* upload completely sent off: 47 out of 47 bytes
< HTTP/1.1 201
HTTP/1.1 201
< Location: http://localhost:8080/foos/4
Location: http://localhost:8080/foos/4
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 14 Apr 2019 21:21:33 GMT
Date: Sun, 14 Apr 2019 21:21:33 GMT

<
{
  "name" : "Test",
  "email" : "test@test.com",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/foos/4"
    },
    "foo" : {
      "href" : "http://localhost:8080/foos/4"
    }
  }
* Connection #0 to host localhost left intact
```
The returned content type is “application/hal+json“. HAL is a simple format that gives a consistent and easy way to hyperlink between resources in your API. 
The header also automatically contains the Location header, which is the address we can use to access the newly created entity.

* GET & SEARCH entity
 http://localhost:8080/foos/search/findByName?name=Second
```
{
  "_embedded" : {
    "foos" : [ {
      "name" : "Second",
      "email" : "s@ggg.com",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/foos/2"
        },
        "foo" : {
          "href" : "http://localhost:8080/foos/2"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/foos/search/findByName?name=Second"
    }
  }
}
```


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validating Form Input](https://spring.io/guides/gs/validating-form-input/)

