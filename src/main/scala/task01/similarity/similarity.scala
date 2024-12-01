package task01.similarity

@main
def main(): Unit = {

  val (left, right) = io.Source.stdin.getLines
    .map(line => line.split("\\h+"))
    .map(strArr => strArr.map(_.toInt))
    .map(intArr => (intArr(0), intArr(1)))
    .toSeq
    .unzip

  assert(left.size == right.size)

  val leftHist = histogram(left)
  val rightHist = histogram(right)

  val result = leftHist
    .map((number, count) => number * count * rightHist(number))
    .sum

  println(result)

}

def histogram(s: Seq[Int]): Map[Int, Int] = {
  s.groupMapReduce(identity)(_ => 1)(_ + _)
    .withDefault(_ => 0)
}


