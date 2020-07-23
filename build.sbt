def silencer(name: String) =
  "com.github.ghik" %% s"silencer-$name" % "1.7.0" cross CrossVersion.full

inThisBuild(Seq(
  scalaVersion := "2.13.3",
  scalacOptions += "-Ymacro-annotations",
  libraryDependencies ++= Seq(
    silencer("lib") % Provided,
    compilerPlugin(silencer("plugin")),
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
  ),
))

val macros = project
val `silencer-bug` = project.in(file(".")).dependsOn(macros)
