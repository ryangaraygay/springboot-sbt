# springboot-sbt
example/demo springboot project using sbt (simple build tool)
this is in NO way production ready
and assumes some understanding of springboot, sbt and swagger
rather this was my small experiment to get all of them to work together

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

Encountered Issues
* had issues with resolvers earlier - when I was using old versions of springfox - (cannot find symbols etc..) - release versions are in Maven repos otherwise you might need the resolvers mentioned in build.sbt
* initially when I accessed /v2/api-docs it was empty. It was because in SwaggerConfig.customImplementation a groupname was introduced (.groupName("greeting-api-group")), if there are groups then you need to access the api-docs with group querystring v2/api-docs?group=greeting-api-group
