package task02.tolerantsafety

import task02.tolerantsafety.LevelType.{OTHER, SAFELY_DECREASE, SAFELY_INCREASE}


enum LevelType extends java.lang.Enum[LevelType]:
  case SAFELY_DECREASE, OTHER, SAFELY_INCREASE

@main
def main(): Unit = {

  def isLevelSafe(lvl: Seq[Int]): Boolean = {

    val slidingDiff = lvl.sliding(2).flatMap {
      case Seq(a, b) => Some(a - b)
      case _ => None
    }

    val diffTypes = slidingDiff.map {
      case d if d >= -3 && d <= -1 => SAFELY_DECREASE
      case d if d >= 1 && d <= 3 => SAFELY_INCREASE
      case _ => OTHER
    }.toSet

    diffTypes.equals(Set(SAFELY_DECREASE)) || diffTypes.equals(Set(SAFELY_INCREASE))

  }

  def isTolerantLevelSafe(lvl: Seq[Int]):Boolean = {
    lvl.indices.map(i =>
      val (left, right) = lvl.splitAt(i)
      left ++ right.tail
    ).exists(isLevelSafe)
  }

  val result = io.Source.stdin.getLines
    .map(line => line.split("\\h+"))
    .map(strArr => strArr.map(_.toInt))
    .map(_.toSeq)
    .count(l => isLevelSafe(l) || isTolerantLevelSafe(l))

  println(result)

}

