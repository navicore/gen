name := "gen"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++=
  Seq(
    "org.scalameta" %% "scalameta" % "1.6.0"
  )

mainClass in assembly := Some("onextent.gen.Main")

assemblyMergeStrategy in assembly := {
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("com",   "google", xs @ _*) => MergeStrategy.last
  case PathList("com",   "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("io",    "netty", xs @ _*) => MergeStrategy.last
  case PathList("org",   "slf4j", xs @ _*) => MergeStrategy.last
  case PathList("org",   "apache", xs @ _*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

