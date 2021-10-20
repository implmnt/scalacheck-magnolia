package tests

import scalacheck.magnolia.auto._
import scalacheck.magnolia.semiauto._
import minitest.SimpleTestSuite
import org.scalacheck.Arbitrary._
import org.scalacheck.Gen

object DerivationSuite extends SimpleTestSuite {

  sealed trait Tree
  case class Leaf(s: String, i: Int, b: Boolean) extends Tree
  case class Node(c: Tree, l: Long) extends Tree
  case object ConstLeaf extends Tree

  def arbitraryTree: Gen[Tree] =
    Gen.lzy(Gen.oneOf(arbitraryConstLeaf, arbitraryLeaf, arbitraryNode))

  def arbitraryLeaf: Gen[Leaf] =
    for {
      s <- arbitrary[String]
      i <- arbitrary[Int]
      b <- arbitrary[Boolean]
    } yield Leaf(s, i, b)

  def arbitraryNode: Gen[Node] =
    for {
      tree <- Gen.lzy(arbitraryTree)
      l    <- arbitrary[Long]
    } yield Node(tree, l)

  def arbitraryConstLeaf: Gen[ConstLeaf.type] =
    Gen.const(ConstLeaf)

  test("auto. for product") {
    compareArbitrary(arbitrary[Leaf], arbitraryLeaf)(assertEquals[Leaf])
  }

  test("auto. for recursive product") {
    compareArbitrary(arbitrary[Node], arbitraryNode)(assertEquals[Node])
  }

  test("auto. for coproduct") {
    compareArbitrary(arbitrary[Tree], arbitraryTree)(assertEquals[Tree])
  }

  test("semiauto. for product") {
    compareArbitrary(deriveMagnoliaArbitrary[Leaf].arbitrary, arbitraryLeaf)(assertEquals[Leaf])
  }

  test("semiauto. for coproduct") {
    compareArbitrary(deriveMagnoliaArbitrary[Tree].arbitrary, arbitraryTree)(assertEquals[Tree])
  }
}
