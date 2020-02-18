package scalacheck.magnolia

import magnolia._
import mercator.Monadic
import org.scalacheck._

trait MagnoliaDerivation {

  type Typeclass[T] = Arbitrary[T]

  def combine[T](caseClass: CaseClass[Arbitrary, T]): Arbitrary[T] =
    Arbitrary(Gen.lzy(caseClass.constructMonadic(_.typeclass.arbitrary)))

  def dispatch[T](sealedTrait: SealedTrait[Arbitrary, T]): Arbitrary[T] =
    Arbitrary(Gen.oneOf(sealedTrait.subtypes.map(_.typeclass.arbitrary)).flatMap(identity))

  implicit def monadicForGen: Monadic[Gen] = new Monadic[Gen] {
    def flatMap[A, B](from: Gen[A])(fn: A => Gen[B]): Gen[B] = from.flatMap(fn)
    def point[A](value: A): Gen[A] = Gen.const(value)
    def map[A, B](from: Gen[A])(fn: A => B): Gen[B] = from.map(fn)
  }
}
