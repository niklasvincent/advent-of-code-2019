package day01

import common.PuzzleInput

object Solver extends App {

  /*
   * Fuel required to launch a given module is based on its mass.
   * Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
   */
  def fuelRequired(mass: Int): Int = {
    Math.round(mass / 3) - 2
  }

  /*
   * For each module mass, calculate its fuel and add it to the total.
   * Then, treat the fuel amount you just calculated as the input mass and repeat the process,
   * continuing until a fuel requirement is zero or negative.
   *
   * For example:
   *
   * At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2).
   * 216 then requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel.
   * So, the total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
   *
   * The fuel required by a module of mass 100756 and its fuel is:
   * 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
   *
   */
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

  val input: Seq[Int] = PuzzleInput.readIntegersFromFile("day01/input1.txt")

  val totalFuelRequired = input.map(fuelRequired).sum

  val totalFuelRequiredIncludingFuel= input.map(fuelRequiredIncludingFuel).sum

  println(s"Total fuel required is $totalFuelRequired")

  println(s"Total fuel required (including fuel) is $totalFuelRequiredIncludingFuel")

}
