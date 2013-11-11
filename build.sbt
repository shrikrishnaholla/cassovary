name := "cassovary"

version := "3.0.0"

organization := "com.twitter"

scalaVersion := "2.9.2"

retrieveManaged := true

resolvers += "Twitter Maven Repo" at "http://maven.twttr.com"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) =>
        "com.twitter" % "ostrich_2.10" % "9.1.0"
    case _ => "com.twitter" % "ostrich" % "4.8.0"
  }
}
 
libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) =>
        "com.twitter" % "util-core_2.10" % "6.6.0"
    case _ => "com.twitter" % "util-core_2.9.2" % "6.6.0"
  }
}
 
libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) =>
        "com.google.guava" % "guava" % "14.0.1" withSources()
    case _ => "com.google.guava" % "guava" % "11.0.2" withSources()
  }
}
 
libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) =>
        "it.unimi.dsi" % "fastutil" % "6.5.2" % "provided"
    case _ => "it.unimi.dsi" % "fastutil" % "6.4.4" % "provided"
  }
}

libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) => 
        "com.twitter" % "util-logging_2.10" % "6.6.0"
    case _ => "com.twitter" % "util-logging_2.9.2" % "6.6.0"
  }
}
 
libraryDependencies += "org.mockito" % "mockito-all" % "1.8.5" % "test" withSources()

libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) => 
        "org.scala-tools.testing" % "specs_2.10" % "1.6.9" % "test" withSources()
    case _ => "org.scala-tools.testing" % "specs_2.9.1" % "1.6.9" % "test" withSources()
  }
}

libraryDependencies <+= scalaVersion { sv =>
  val scalaVersionRegex = "(\\d+)\\.(\\d+).*".r
  sv match {
    case scalaVersionRegex(major, minor) if major.toInt > 2 || (major == "2" && minor.toInt >= 10) => 
        "com.typesafe.akka" % "akka-actor-tests_2.10" % "2.1.0"
    case _ => "com.typesafe.akka" % "akka-actor-tests" % "2.0.5"
  }
}

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://twitter.com/cassovary</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
      <comments>A business-friendly OSS license</comments>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:twitter/cassovary.git</url>
    <connection>scm:git:git@github.com:twitter/cassovary.git</connection>
  </scm>
  <developers>
    <developer><id>pankaj</id><name>Pankaj Gupta</name><url>https://twitter.com/pankaj</url></developer>
    <developer><id>dongwang218</id><name>Dong Wang</name><url>https://twitter.com/dongwang218</url></developer>
    <developer><id>tao</id><name>Tao Tao</name><url>https://twitter.com/tao</url></developer>
    <developer><id>johnsirois</id><name>John Sirois</name><url>https://twitter.com/johnsirois</url></developer>
    <developer><id>aneeshs</id><name>Aneesh Sharma</name><url>https://twitter.com/aneeshs</url></developer>
    <developer><id>ashishgoel</id><name>Ashish Goel</name><url>https://twitter.com/ashishgoel</url></developer>
    <developer><id>4ad</id><name>Mengqiu Wang</name><url>https://twitter.com/4ad</url></developer>
    <developer><id>ningliang</id><name>Ning Liang</name><url>https://twitter.com/ningliang</url></developer>
    <developer><id>ajeet</id><name>Ajeet Grewal</name><url>https://twitter.com/ajeet</url></developer>
  </developers>)