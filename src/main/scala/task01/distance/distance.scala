package task01.distance

@main
def main(): Unit = {

  val (left, right) = io.Source.stdin.getLines
    .map(line => line.split("\\h+"))
    .map(strArr => strArr.map(Integer.valueOf))
//    .map(intArr => {
//      val left = intArr(0)
//      val right = intArr(1)
//      scala.math.abs(left - right)
//    })
    .map(intArr => (intArr(0), intArr(1)))
    .toSeq
    .unzip

  assert(left.size == right.size)

  val leftSorted = left.sorted
  val rightSorted = right.sorted

  val result = leftSorted.zip(rightSorted)
    .map(pair => scala.math.abs(pair._1 - pair._2))
    .sum

  println(result)

}

