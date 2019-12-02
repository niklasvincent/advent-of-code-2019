package day01

class SolverTest extends org.specs2.mutable.Specification {

  Solver.fuelRequired(12) mustEqual 2

  Solver.fuelRequired(14) mustEqual 2

  Solver.fuelRequired(1969) mustEqual 654

  Solver.fuelRequired(100756) mustEqual 33583

  Solver.fuelRequiredIncludingFuel(14) mustEqual 2

  Solver.fuelRequiredIncludingFuel(1969) mustEqual 966

  Solver.fuelRequiredIncludingFuel(100756) mustEqual 50346

}
