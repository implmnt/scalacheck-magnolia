addSbtPlugin("org.scalameta"             % "sbt-scalafmt"    % "2.4.0")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.1.12")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "2.4.11")
addSbtPlugin("org.xerial.sbt"            % "sbt-sonatype"    % "3.9.2")
addSbtPlugin("com.jsuereth"              % "sbt-pgp"         % "2.0.1")

resolvers += Resolver.sonatypeRepo("public")
