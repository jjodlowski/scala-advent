package task04.xmas

@main
def main(): Unit = {

  val wordRegexp = raw"XMAS".r
  val revWordRegexp = raw"SAMX".r

  val lines = io.Source.stdin.getLines
    .toArray
    .map(str => str.toArray)

  val linesSize = lines.size

  val columns = lines.transpose

  val diagonals1 = lines.zipWithIndex
    .map((line, i) => (("#" * i) + line.mkString + ("#" * (linesSize-i))).toArray)
    .transpose

  val diagonals2 = lines.reverse.zipWithIndex
    .map((line, i) => (("#" * i) + line.mkString + ("#" * (linesSize-i))).toArray)
    .transpose

  def count(lines: Array[Array[Char]]): Int = {
    lines.map(l => {
      wordRegexp.findAllIn(ArrayCharSequence(l)).size +
        revWordRegexp.findAllIn(ArrayCharSequence(l)).size
    }).sum
  }

  println(count(lines) + count(columns) +
    count(diagonals1) + count(diagonals2))

}