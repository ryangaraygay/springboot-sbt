import sbt._
import Keys._

object B extends Build
{
  lazy val root =
    Project("root", file("."))
      .configs( IntegrationTest )
      .settings( Defaults.itSettings : _*)
      .settings( libraryDependencies += specs )

  lazy val specs = "org.scala-tools.testing" % "specs_2.9.1" % "1.6.9" % "it,test"
}