addSbtPlugin("org.scalameta"             % "sbt-scalafmt"    % "2.5.1")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.1.16")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "2.4.13")
addSbtPlugin("org.xerial.sbt"            % "sbt-sonatype"    % "3.9.5")
addSbtPlugin("com.github.sbt"            % "sbt-pgp"         % "2.1.2")

resolvers += Resolver.sonatypeRepo("public")
