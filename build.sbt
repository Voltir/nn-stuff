val commonSettings = Seq(
  organization := "com.voltir",
  version := "0.1.0-SNAPSHOT",
  parallelExecution in Test := false,
  //fork in Test := true,
  scalacOptions ++= Seq(
    "-language:existentials",
    "-language:experimental.macros",
    "-Xfuture",
    "-Ypartial-unification"
  ),
  scalaVersion := "2.12.3",
  addCompilerPlugin(Dependencies.kindProjector),
  resolvers += Resolver.sonatypeRepo("releases"),
  resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
)

lazy val root = Project("nn", file("." + "nn"))
  .in(file("."))
  .aggregate(core, handwriting)
  .settings(commonSettings: _*)

lazy val core = (project in file("core"))
  .settings(name := "nn-core")
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.core,
    libraryDependencies += Dependencies.scalaReflect.value % "provided"
  )

lazy val handwriting = (project in file("handwriting"))
  .settings(name := "nn-handwriting")
  .settings(commonSettings: _*)
  .dependsOn(core)
