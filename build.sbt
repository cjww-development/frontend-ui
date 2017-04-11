import com.typesafe.config.ConfigFactory

import scala.util.{Failure, Success, Try}

val btVersion: String = {
  Try(ConfigFactory.load.getString("version")) match {
    case Success(ver) => ver
    case Failure(_) => "INVALID_RELEASE_VERSION"
  }
}

name := "frontend-ui"
version := btVersion
scalaVersion := "2.11.10"
organization := "com.cjww-dev.libs"

val codeDep: Seq[ModuleID] = Seq("com.typesafe.play" % "play_2.11" % "2.5.14")

libraryDependencies ++= codeDep

resolvers += "cjww-dev" at "http://dl.bintray.com/cjww-development/releases"

bintrayOrganization := Some("cjww-development")
bintrayReleaseOnPublish in ThisBuild := false
bintrayRepository := "releases"
bintrayOmitLicense := true
    