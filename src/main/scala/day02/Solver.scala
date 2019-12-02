package day02

import common.PuzzleInput

object Solver extends App {

  val input = PuzzleInput.readIntegerSequenceFromFile("day02/input1.txt")

  // Once you have a working computer, the first step is to restore the gravity assist program (your puzzle input)
  // to the "1202 program alarm" state it had just before the last computer caught fire.
  // To do this, before running the program, replace position 1 with the value 12 and
  // replace position 2 with the value 2. What value is left at position 0 after the program halts?

  val state = scala.collection.mutable.Seq.from(input)
  state(1) = 12
  state(2) = 2

  println(IntcodeProcessor.compute(state))

  // "With terminology out of the way, we're ready to proceed.
  // To complete the gravity assist, you need to determine what pair of inputs produces the output 19690720."

  def computeWithInputs(noun: Int, verb: Int): Int = {
    val state = scala.collection.mutable.Seq.from(input)
    state(1) = noun
    state(2) = verb

    IntcodeProcessor.compute(state)
  }

  case class Result(noun: Int, verb: Int, output: Int)

  val target = 19690720

  val result = (for {
    noun <- 0 until 99
    verb <- 0 until 99
  } yield Result(noun, verb, computeWithInputs(noun, verb))).filter(r => r.output == target).head

  println(s"Getting output $target for ${result.noun} and ${result.verb}: ${100 * result.noun + result.verb}")

}
