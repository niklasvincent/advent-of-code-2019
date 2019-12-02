package common

import java.io.File

import scala.io.Source

object PuzzleInput {

  def readIntegersFromFile(filename: String): Seq[Int] = {
    val f = new File(getClass.getClassLoader.getResource(filename).getPath)

    Source.fromFile(f).getLines().map(l => l.toInt).toSeq
  }

  def readIntegerSequenceFromFile(filename: String): Seq[Int] = {
    val f = new File(getClass.getClassLoader.getResource(filename).getPath)

    Source.fromFile(f).getLines().map(l => l.split(",").map(c => c.toInt)).toSeq.head
  }

}
