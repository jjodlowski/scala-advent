package task04.xmas

@main
def main(): Unit = {

  val word = "XMAS"
  val wordReversed = word.reverse

  val wordRegexp = raw"XMAS".r
  val revWordRegexp = raw"SAMX".r

  //  io.Source.stdin.getLines
  //    .foreach(l => {
  //      print(s"$l ")
  //      println(s"${l.contains(word)} ${l.contains(wordReversed)}")
  //    })

  val lines = io.Source.stdin.getLines
    .toArray
    .map(str => str.toArray)

  val linesSize = lines.size
//  val linesLen = lines.map(_.size).foldLeft(0)(Math.max)

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

  //    lines.foreach(l => {
  //      print(s"$l ")
  //
  //      println(s"${wordRegexp.findAllIn(l).size + revWordRegexp.findAllIn(l).size}")
  //    })


}