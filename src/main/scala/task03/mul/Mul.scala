package task03.mul


@main
def main(): Unit = {

  val rgxp = raw".*mul\((\d{1,3}),(\d{1,3})\)".r
//  val rgxp = raw"(?<!don't\(\).*)mul\((\d{1,3}),(\d{1,3})\)".r

  val matchIters = io.Source.stdin.getLines
    .map(rgxp.findAllIn)


  val mulResults = for mi <- matchIters
      mulMatch <- mi
    yield mi.group(1).toInt * mi.group(2).toInt

  println(mulResults.sum)

}
