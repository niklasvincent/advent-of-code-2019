package day02

object IntcodeProcessor {

  sealed trait Operator
  case object Addition extends Operator
  case object Multiplication extends Operator
  case object Finished extends Operator
  case object Unknown extends Operator

  case class Operation(operator: Operator, first: Int, second: Int, target: Int)

  object Operation {
    def apply(values: scala.collection.mutable.Seq[Int], position: Int): Operation = {
      values(position) match {
        case 1 => Operation(Addition, values(position + 1), values(position + 2), values(position + 3))
        case 2 => Operation(Multiplication, values(position + 1), values(position + 2), values(position + 3))
        case 99 => Operation(Finished, 0, 0, 0)
        case _ => Operation(Unknown, 0, 0, 0)
      }
    }
  }

  def process(values: scala.collection.mutable.Seq[Int], position: Int): scala.collection.mutable.Seq[Int] = {
    Operation(values, position) match {
      case Operation(Addition, first, second, target) =>
        values(target) = values(first) + values(second)
        process(values, position + 4)
      case Operation(Multiplication, first, second, target) =>
        values(target) = values(first) * values(second)
        process(values, position + 4)
      case Operation(Finished, _, _, _) => values
      case Operation(Unknown, _, _, _) => values
    }
  }

  def compute(values: scala.collection.mutable.Seq[Int]): Int = {
    process(scala.collection.mutable.Seq.from(values), 0).head
  }

}
