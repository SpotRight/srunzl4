import com.spotright.sbt._

lazy val root =
  (project in file(".")).
  settings(spotright.settings: _*).
  settings(
    name := "srunlz4",
    version := "1.0",
    libraryDependencies ++= Seq(
      "net.jpountz.lz4" % "lz4" % "1.3.0"
    )
  )
