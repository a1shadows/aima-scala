package aima.core.search.problems

import aima.core.adversarial.{Game, UtilityValue}

/**
  * @author Aditya Lahiri
  */
sealed abstract class Player {
  def name: String
}

final case class PlayerA(name: String) extends Player
final case class PlayerB(name: String) extends Player
final case class PlayerC(name: String) extends Player

sealed trait Action
case object NoAction                   extends Action
final case class MoveToState(s: State) extends Action

object TwoPlyGame {}
