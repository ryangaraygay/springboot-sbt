import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._
import de.johoop.findbugs4sbt.FindBugs._
import de.johoop.jacoco4sbt.JacocoPlugin.jacoco

organization := "com.example"

name := "demo"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.4"

crossPaths := false

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Maven" at "http://oss.jfrog.org/artifactory/oss-snapshot-local/",
  "Spring Repo" at "https://repo.spring.io/libs-release",
  "JCenter" at "https://jcenter.bintray.com"
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test->default",
  "junit" % "junit-dep" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.springframework.boot" % "spring-boot" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-autoconfigure" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.2.5.RELEASE",
  "org.springframework" % "spring-test" % "4.1.6.RELEASE",
  "io.springfox" % "springfox-core" % "2.0.4-SNAPSHOT",
  "io.springfox" % "springfox-spi" % "2.0.4-SNAPSHOT",
  "io.springfox" % "springfox-spring-web" % "2.0.4-SNAPSHOT",
  "io.springfox" % "springfox-swagger2" % "2.0.4-SNAPSHOT",
  "io.springfox" % "springfox-swagger-ui" % "2.0.4-SNAPSHOT",
  "org.hibernate" % "hibernate-core" % "4.3.8.Final",
  "org.hibernate.javax.persistence" 	% "hibernate-jpa-2.0-api" 		% "1.0.1.Final",
  "org.hibernate" % "hibernate-c3p0" % "4.3.8.Final",
  "mysql" % "mysql-connector-java" % "5.1.6"
)

// Test settings
testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

// Coverage settings
seq(jacoco.settings : _*)

jacoco.reportTitle in jacoco.Config := "Template Project Coverage Report"

jacoco.excludes in jacoco.Config := Seq("edu.uci.ics.*")

// Other settings
net.virtualvoid.sbt.graph.Plugin.graphSettings

unmanagedResourceDirectories in Compile <+= (sourceDirectory in Compile)(_ / "java")

findbugsSettings

//Debian related packaging settings
packageArchetype.java_server

packageDescription in Linux := "Demo"

maintainer in Linux := "FirstName LastName <FistName.LastName@agilone.com>"

packageSummary in Linux := "Serves as a demonstration on setting up projects"

daemonUser in Linux := "demo"

daemonGroup in Linux := "demo"
