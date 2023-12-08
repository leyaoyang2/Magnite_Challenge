// val scala3Version = 
// val sparkVersion = "3.0.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "magnite",
    version := "0.1.0-SNAPSHOT",

    // scalaVersion := "2.12.18",
    // scalaVersion := "3.0.2",
    scalaVersion := "3.3.1",

    // libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.0",
    // libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.0" % Provided
    // libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.17.4",
    // libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1",
    // libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
    libraryDependencies ++= Seq(
  ("org.apache.spark" %% "spark-sql" % "3.2.0" % "provided").cross(CrossVersion.for3Use2_13)
)

  )

