package im.plmnt.scalacheck.magnolia

import magnolia._
import org.scalacheck.Arbitrary

object auto extends MagnoliaDerivation {
  implicit def magnoliaArbitrary[T]: Arbitrary[T] = macro Magnolia.gen[T]
}
