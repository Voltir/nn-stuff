import sbt._
import sbt.Keys._

object Dependencies {
  lazy val kindProjector = "org.spire-math" %% "kind-projector" % "0.9.3"

  import Def.setting

  lazy val common = Seq(
    "org.typelevel" %% "cats-core" % "1.0.0-RC1",
    "org.scalatest" %% "scalatest" % "3.0.4" % Test,
    "org.scalamock" %% "scalamock" % "4.0.0" % Test,
    "org.scalanlp" %% "breeze" % "0.13.2",
    "org.scalanlp" %% "breeze-natives" % "0.13.2",
    "org.scalanlp" %% "breeze-viz" % "0.13.2"
  )

  def scalaReflect = setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)

  lazy val core = common
}
