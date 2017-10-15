import com.typesafe.config.ConfigFactory

import scala.util.{Failure, Success, Try}

val btVersion: String = Try(ConfigFactory.load.getString("version")) match {
  case Success(ver) => ver
  case Failure(_)   => "0.1.0"
}

name         := "frontend-ui"
version      := btVersion
scalaVersion := "2.11.11"
organization := "com.cjww-dev.libs"

val templateImports = Seq("play.api.mvc._", "play.api.data._", "play.api.i18n._", "play.api.templates.PlayMagic._", "com.cjwwdev.views._")

lazy val root = (project in file("."))
  .enablePlugins(SbtTwirl)
  .settings(TwirlKeys.templateImports ++= templateImports)

val codeDep: Seq[ModuleID] = Seq(
  "com.typesafe.play" % "play_2.11" % "2.5.16",
  "org.jsoup"         % "jsoup"     % "1.10.3"     % Test
)

libraryDependencies ++= codeDep

resolvers += "cjww-dev" at "http://dl.bintray.com/cjww-development/releases"

bintrayOrganization                  := Some("cjww-development")
bintrayReleaseOnPublish in ThisBuild := true
bintrayRepository                    := "releases"
bintrayOmitLicense                   := true
    