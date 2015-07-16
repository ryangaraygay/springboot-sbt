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
  "Spring Repo" at "https://repo.spring.io/libs-release"
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test->default",
  "junit" % "junit-dep" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.springframework.boot" % "spring-boot" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-autoconfigure" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.2.5.RELEASE",
  "org.springframework" % "spring-test" % "4.1.6.RELEASE"
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
