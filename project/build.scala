import sbt._
import Keys._
import sbtrelease._
import xerial.sbt.Sonatype._

object NagoyakaJavaTestBuild extends Build {
  import Dependencies._

  private def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  lazy val buildSettings = Seq(
    ReleasePlugin.releaseSettings,
    sonatypeSettings
  ).flatten ++ Seq(
    scalaVersion := "2.11.5",
    resolvers += Opts.resolver.sonatypeReleases,
    scalacOptions ++= (
      "-deprecation" ::
      "-unchecked" ::
      "-Xlint" ::
      "-language:existentials" ::
      "-language:higherKinds" ::
      "-language:implicitConversions" ::
      "-Ywarn-unused" ::
      "-Ywarn-unused-import" ::
      Nil
    ),
    libraryDependencies ++= Seq(
      scalaz % "test",
      scalacheck % "test"
    ),
    organization := "com.github.pocketberserker",
    homepage := Some(url("https://github.com/pocketberserker/nagoyaka-java-test")),
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php"))
  )

  lazy val nagoyaka = Project(
    id = "nagoyaka-java-test",
    base = file("."),
    settings = buildSettings
  )

  object Dependencies {

    val scalacheck = "org.scalacheck" %% "scalacheck" % "1.12.1"
    val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.0"
  }
}
