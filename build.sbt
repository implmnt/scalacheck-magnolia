import xerial.sbt.Sonatype._

scalaVersion := "2.12.8"

organization := "im.plmnt"
name := "scalacheck-magnolia"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
homepage := Some(url("http://github.com/implmnt/scalacheck-magnolia"))

scalafmtOnCompile := true
testFrameworks += new TestFramework("minitest.runner.Framework")

useGpg := true
publishTo := sonatypePublishTo.value
publishMavenStyle := true
sonatypeProjectHosting := Some(GitHubHosting("implmnt", "scalacheck-magnolia", "georgy.davityan@gmail.com"))
