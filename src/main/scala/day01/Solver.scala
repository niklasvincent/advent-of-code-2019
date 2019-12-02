package day01

import java.io.File

import scala.io.Source

object Solver extends App {

  val f = new File(getClass.getClassLoader.getResource("day01/input1.txt").getPath)

  def fuelRequired(mass: Int): Int = {
    Math.round(mass / 3) - 2
  }

  def fuelRequiredIncludingFuel(mass: Int): Int = {
    def series(fuel: Seq[Int]): Seq[Int] = {
      val additionalFuel = fuelRequired(fuel.last)

      if (additionalFuel < 0 || additionalFuel == 0) {
        return fuel
      }

      series(fuel :+ additionalFuel)
    }

    series(Seq(fuelRequired(mass))).sum
  }

  val totalFuelRequired = Source.fromFile(f).getLines().map(l => l.toInt).map(fuelRequired).sum

  val totalFuelRequiredIncludingFuel= Source.fromFile(f).getLines().map(l => l.toInt).map(fuelRequiredIncludingFuel).sum

  println(s"Total fuel required is $totalFuelRequired")

  println(s"Total fuel required (including fuel) is $totalFuelRequiredIncludingFuel")

}
