package im.plmnt.scalacheck.magnolia

import magnolia._
import org.scalacheck.Arbitrary

object semiauto extends MagnoliaDerivation {
  def deriveMagnoliaArbitrary[T]: Arbitrary[T] = macro Magnolia.gen[T]
}
