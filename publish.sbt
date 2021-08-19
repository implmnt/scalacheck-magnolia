import xerial.sbt.Sonatype._

publishTo := sonatypePublishTo.value
publishMavenStyle := true
sonatypeProjectHosting := Some(GitHubHosting("implmnt", "scalacheck-magnolia", "georgy.davityan@gmail.com"))
