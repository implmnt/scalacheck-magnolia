lazy val scala212 = "2.12.10"
lazy val scala213 = "2.13.1"

scalaVersion := scala213
organization := "im.plmnt"
name := "scalacheck-magnolia"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
homepage := Some(url("http://github.com/implmnt/scalacheck-magnolia"))

crossScalaVersions := List(scala212, scala213)
scalafmtOnCompile := true
testFrameworks += new TestFramework("minitest.runner.Framework")
