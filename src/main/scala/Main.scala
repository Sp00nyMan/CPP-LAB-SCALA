import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val array = List[Int](4, 3, 2, 12, 17, 23, 22, 146, 7, 9, 17)
    println(getStartIndex(array))
    println(array)
  }

  def findSecondFromBase(stack: mutable.Stack[Int]): Int = {
    require(stack.size >= 2)
    stack.toArray.apply(stack.size - 2)
    //stack.zipWithIndex.find(elem => elem._1 == stack.size - 2).get._2
  }
  @scala.annotation.tailrec
  def findSecondFromBaseTailRec(stack: mutable.Stack[Int]): Int = {
    require(stack.size >= 2)
    if (stack.size == 2)
      stack.top
    else
      findSecondFromBaseTailRec(stack.tail)
  }

  def getStartIndex(array: List[Int]): Int = {
    val lengths = ArrayBuffer.fill(array.length)(0)
    for (i <- 1 until array.length) {
      if (array(i - 1) < array(i))
        lengths(i) = lengths(i - 1) + 1
    }
    lengths.indexOf(lengths.max) - lengths.max
  }
  def getStartIndexTailRec(array: List[Int]): Int = {
    val lengths = ArrayBuffer.fill(array.length)(1)
    longestSeqTailRec( array, 1, lengths)
    lengths.indexOf(lengths.max) - lengths.max + 1
  }
  @scala.annotation.tailrec
  def longestSeqTailRec(array: List[Int], i: Int, lengths: ArrayBuffer[Int]): Unit = {
    if(i < array.length) {
      if (array(i - 1) < array(i))
        lengths(i) = lengths(i - 1) + 1
      longestSeqTailRec(array, i + 1, lengths)
    }
  }

  def invertString(string: String): String = {
    string.reverse
  }
  def invertStringTailRec(string: String): String = {
    if (string.length == 1)
      string.charAt(0).toString
    else
      string.charAt(string.length - 1) + invertStringTailRec(string.substring(0, string.length - 1))
  }

  def isPrime(num: Int): Boolean = !(2 to num / 2).exists(x => num % x == 0)
  def getOnlyPrime(array: List[Int]): List[Int] = {
    require(array.forall(elem => elem >= 2))
    array.filter(num => isPrime(num))
  }
  //http://www.cs.sjsu.edu/faculty/pearce/modules/lectures/scala/lists/index.htm
  def getOnlyPrimeTailRec(array: List[Int]): List[Int] = {
    if(array == Nil)
      Nil
    else
      if (isPrime(array.head))
        array.head :: getOnlyPrimeTailRec(array.tail)
      else
        getOnlyPrimeTailRec(array.tail)
  }

  def getOnlyPositive(array: List[Int]): List[Int] = array.filter(elem => elem >= 0)
  def getOnlyPositiveTailRec(array: List[Int]): List[Int] = {
    require(array != Nil)
    if (array.head >= 0)
      array.head :: getOnlyPositiveTailRec(array.tail)
    else
      getOnlyPositiveTailRec(array.tail)
  }
}