package scalacheck.magnolia

import magnolia._
import mercator.cats._
import org.scalacheck._
import org.scalacheck.cats.implicits._

trait MagnoliaDerivation {

  type Typeclass[T] = Arbitrary[T]

  def combine[T](caseClass: CaseClass[Arbitrary, T]): Arbitrary[T] =
    Arbitrary(Gen.lzy(caseClass.constructMonadic(_.typeclass.arbitrary)))

  def dispatch[T](sealedTrait: SealedTrait[Arbitrary, T]): Arbitrary[T] =
    Arbitrary(Gen.oneOf(sealedTrait.subtypes.map(_.typeclass.arbitrary)).flatMap(identity))
}
