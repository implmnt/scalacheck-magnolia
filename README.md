# scalacheck-magnolia
Derivation of [scalacheck](https://github.com/rickynils/scalacheck) Arbitrary on [magnolia](https://github.com/propensive/magnolia)

[![Build Status](https://travis-ci.org/implmnt/scalacheck-magnolia.svg?branch=master)](https://travis-ci.org/implmnt/scalacheck-magnolia)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/im.plmnt/scalacheck-magnolia_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/im.plmnt/scalacheck-magnolia_2.12)

## Usage

Add to your `build.sbt`
```scala
libraryDependencies += "im.plmnt" %% "scalacheck-magnolia" % "0.1.0"
```

Can be used for case classes and/or sealed traits
```scala
sealed trait Foo
case class Bar(str: String, bool: Boolean) extends Foo
case object Baz extends Foo
```

For automatically derivation, import the content of `im.plmnt.scalacheck.magnolia.auto`
```scala
import im.plmnt.scalacheck.magnolia.auto._

forAll { foo: Foo =>
// Ensure foo has the required property
}

forAll { bar: Bar =>
// Ensure bar has the required property
}
```

For semi-automatically derivation use `im.plmnt.scalacheck.magnolia.semiauto`
```scala
import im.plmnt.scalacheck.magnolia.semiauto._

implicit val arbitraryForFoo: Arbitrary[Foo] = deriveMagnoliaArbitrary[Foo]

forAll { foo: Foo =>
// Ensure foo has the required property
}
```