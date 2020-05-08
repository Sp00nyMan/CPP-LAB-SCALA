object Lab6 {
  def main(args: Array[String]): Unit = {
    val array = List[Int](4, 3, 2, 12, 17, 23, 22, 146, 7, 9, 17, 81)
    println(getOnlyFibonacci(array))
  }

  def flipAndMulAndGetThird(array: List[Int]): Int = {
    require(array.length >= 3)
    array.reverse.map(_ * 2).apply(2)
  }

  def findMinUsingFold(array: List[Int]): Int = {
    require(array.nonEmpty)
    array.fold(array.head)((min, element) => math.min(min, element))
                          //min sets to math.min(min, element)
  }

  def getOnlyFibonacci(array: List[Int]): List[Int] = {
    require(array.nonEmpty)
    array.filter(e => isFibonacci(e))
  }

  //https://www.geeksforgeeks.org/check-number-fibonacci-number/
  def isFibonacci(num: Int): Boolean = isPerfectSquare(5 * math.pow(num, 2).toInt + 4) || isPerfectSquare(5 * math.pow(num, 2).toInt - 4)
  def isPerfectSquare(num: Int): Boolean = math.pow(math.sqrt(num).toInt, 2).toInt.equals(num)
}