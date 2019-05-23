addSbtPlugin("org.scalameta"             % "sbt-scalafmt"    % "2.0.0")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "2.4.1")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.1.6")
addSbtPlugin("org.xerial.sbt"            % "sbt-sonatype"    % "2.3")
addSbtPlugin("com.jsuereth"              % "sbt-pgp"         % "1.1.0")

resolvers += Resolver.sonatypeRepo("public")
