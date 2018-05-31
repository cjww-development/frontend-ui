import com.typesafe.config.ConfigFactory

import scala.util.{Failure, Success, Try}

val libraryName = "frontend-ui"

val btVersion: String = Try(ConfigFactory.load.getString("version")) match {
  case Success(ver) => ver
  case Failure(_)   => "0.1.0"
}

val templateImports = Seq("play.api.mvc._", "play.api.data._", "play.api.i18n._", "play.api.templates.PlayMagic._", "com.cjwwdev.views._")

val codeDep: Seq[ModuleID] = Seq("com.typesafe.play" % "play_2.12" % "2.6.15")

lazy val root = Project(libraryName, file("."))
  .enablePlugins(SbtTwirl)
  .settings(
    TwirlKeys.templateImports            ++= templateImports,
    version                              :=  btVersion,
    scalaVersion                         :=  "2.12.6",
    organization                         :=  "com.cjww-dev.libs",
    resolvers                            +=  "cjww-dev" at "http://dl.bintray.com/cjww-development/releases",
    libraryDependencies                  ++= codeDep,
    bintrayOrganization                  :=  Some("cjww-development"),
    bintrayReleaseOnPublish in ThisBuild :=  true,
    bintrayRepository                    :=  "releases",
    bintrayOmitLicense                   :=  true
  )
