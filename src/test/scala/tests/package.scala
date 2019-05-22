import org.scalacheck.Gen
import org.scalacheck.Gen.Parameters
import org.scalacheck.rng.Seed

package object tests {

  def compareArbitrary[A, Assertion](x: Gen[A], y: Gen[A])(test: (A, A) => Assertion): Unit = {
    val seed = Seed.random()
    listOf(x)(Parameters.default, seed)
      .zip(listOf(y)(Parameters.default, seed))
      .foreach(test.tupled)
  }

  private[tests] def listOf[A](g: Gen[A])(p: Parameters, seed: Seed): List[A] =
    List.tabulate(100)(_ => g(p, seed)).flatten
}
