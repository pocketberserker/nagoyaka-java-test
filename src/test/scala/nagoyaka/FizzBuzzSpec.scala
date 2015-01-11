package nagoyaka

import org.scalacheck.Properties
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

object FizzBuzzSpec extends Properties("FizzBuzz") {

  val inverseInput = Gen.oneOf(
        Array("fizz"),
        Array("buzz" ),
        Array("fizz", "buzz"),
        Array("buzz", "fizz"),
        Array("fizz", "buzz", "fizz"),
        Array("fizz", "fizz"),
        Array("fizz", "fizz", "buzz")
      )

  property("inverse") = forAll (inverseInput) { (input: Array[String]) =>
    val actual =
      FizzBuzz.inverseFizzBuzz(input)
        .get()
        .map(FizzBuzz.toFizzBuzz(_))
        .filter(_ != null)
    actual sameElements input
  }
}
