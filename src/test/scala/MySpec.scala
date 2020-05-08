import Lab6._
import org.scalatest._

import scala.collection.mutable
class MySpec extends  FlatSpec{
  "findSecondFromBase() and findSecondFromBaseTailRec()" must "return second from base element" in
    {
      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      stack.push(3)
      stack.push(4)
      stack.push(5)
      stack.push(6)
      stack.push(7)
      stack.push(8)
      stack.push(9)
      assert(Main.findSecondFromBase(stack) == 2)
      assert(Main.findSecondFromBaseTailRec(stack) == 2)
    }

  it must "throw IllegalArgumentException if stack size is less than 2" in {
    val stack = new mutable.Stack[Int]
    stack.push(1)
    assertThrows[IllegalArgumentException]{
      Main.findSecondFromBase(stack)
    }
  }

  "invertString() and invertStringTailRec()"  must "return the same string reversed" in {
    val string = "Karim is the best anime girl ever!"
    assert(Main.invertString(string) == string.reverse)
    assert(Main.invertStringTailRec(string) == string.reverse)
  }

  "getOnlyPrime() and getOnlyPrimeTailRec()" must "return new array consisting only of prime numbers" in {
    val array = List[Int](2, 5, 6, 12, 213, 23, 22, 146, 7, 9, 17)
    assert(Main.getOnlyPrime(array) == List[Int](2, 5, 23, 7, 17))
    assert(Main.getOnlyPrimeTailRec(array) == List[Int](2, 5, 23, 7, 17))
  }
  "getStartIndex() and getStartIndexTailRec()" must "return index of longest ascending sequence in array" in {
    val array = List[Int](2, 1, 6, 4, 213, 23, 22, 146, 7, 9, 17)
    assert(Main.getStartIndex(array) == 8)
    assert(Main.getStartIndexTailRec(array) == 8)
  }
  "flipAndMulAndGetThird" must "reverse array, multiple each element by two and return the third element" in {
    val array = List[Int](4, 3, 2, 12, 17, 23, 22, 146, 7, 9, 17, 81)
    assert(flipAndMulAndGetThird(array) == 18)
  }
  "findMinUsingFold" must "return min element in array" in {
    val array = List[Int](4, 3, 2, 12, 17, 23, 22, 146, 7, 9, 17, 81)
    assert(findMinUsingFold(array) == 2)
  }
  "getOnlyFibonacci" must "return array with elements of origin array which are fibonacci numbers" in {
    val array = List[Int](4, 3, 2, 12, 17, 23, 22, 146, 7, 9, 17, 81)
    assert(getOnlyFibonacci(array) == List(3, 2))
  }
}
