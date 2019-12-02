package day02

import org.specs2.mutable.Specification

class IntcodeProcessorTest extends Specification {

  IntcodeProcessor.process(scala.collection.mutable.Seq.from(Seq(1,9,10,3,2,3,11,0,99,30,40,50)), 0) mustEqual Seq(
        3500,9,10,70,
        2,3,11,0,
        99,
        30,40,50
  )

  IntcodeProcessor.process(scala.collection.mutable.Seq.from(Seq(1,0,0,0,99)), 0) mustEqual Seq(2,0,0,0,99)

  IntcodeProcessor.process(scala.collection.mutable.Seq.from(Seq(2,3,0,3,99)), 0) mustEqual Seq(2,3,0,6,99)

  IntcodeProcessor.process(scala.collection.mutable.Seq.from(Seq(2,4,4,5,99,0)), 0) mustEqual Seq(2,4,4,5,99,9801)

  IntcodeProcessor.process(scala.collection.mutable.Seq.from(Seq(1,1,1,4,99,5,6,0,99)), 0) mustEqual Seq(30,1,1,4,2,5,6,0,99)

}
