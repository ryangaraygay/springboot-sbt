# springboot-sbt
example/demo springboot project using sbt (simple build tool)

* used spring initializer to get started with an application (web, actuator, jpa - though only used web so far) - http://start.spring.io/
there is only Maven/Gradle projects and will use sbt so just chose Maven
* unzip the zip file generated from the initializer (resulting in demo folder)
* added sbt files (removed Maven pom to keep it clean)
* added controller and test
* added swagger

then go inside "demo" folder (cd demo)
sbt clean update compile 'runMain demo.DemoApplication'

you should now be able to view the swagger json by accessing
http://localhost:8080/v2/api-docs

view resources from
http://localhost:8080/swagger-resources

or use the UI to explore the APIs
http://localhost:8080/swagger-ui.html
