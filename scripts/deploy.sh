#!/bin/sh
sbt ++2.12.10 publishSigned sonatypeRelease
sbt ++2.13.1 publishSigned sonatypeRelease
