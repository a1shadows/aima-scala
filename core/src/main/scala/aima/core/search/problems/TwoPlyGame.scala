package aima.core.search.problems

import aima.core.search.adversarial.{Game, UtilityValue}

/**
  * @author Aditya Lahiri
  */
sealed trait MinimaxPlayer
case object PlayerMAX extends MinimaxPlayer
case object PlayerMIN extends MinimaxPlayer

final case class MinimaxState(stateNumber: Int) extends AnyVal

sealed trait MinimaxAction
case object NoAction                              extends MinimaxAction
final case class MoveToState(state: MinimaxState) extends MinimaxAction

object TwoPlyGame extends Game[MinimaxPlayer, MinimaxState, MinimaxAction] {

  def initialState: MinimaxState = MinimaxState(0)

  def getPlayer(state: MinimaxState): MinimaxPlayer = state.stateNumber match {
    case 0 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 => PlayerMAX
    case 1 | 2 | 3                                => PlayerMIN
  }

  def getActions(state: MinimaxState): List[MinimaxAction] = state.stateNumber match {
    case 0                                    => List(MoveToState(MinimaxState(1)), MoveToState(MinimaxState(2)), MoveToState(MinimaxState(3)))
    case 1                                    => List(MoveToState(MinimaxState(4)), MoveToState(MinimaxState(5)), MoveToState(MinimaxState(6)))
    case 2                                    => List(MoveToState(MinimaxState(7)), MoveToState(MinimaxState(8)), MoveToState(MinimaxState(9)))
    case 3                                    => List(MoveToState(MinimaxState(10)), MoveToState(MinimaxState(11)), MoveToState(MinimaxState(12)))
    case 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 => List()
  }

  def result(state: MinimaxState, action: MinimaxAction): MinimaxState = action match {
    case NoAction              => state
    case MoveToState(newState) => newState
  }

  def isTerminalState(state: MinimaxState): Boolean = state.stateNumber match {
    case 0 | 1 | 2 | 3                        => false
    case 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 => true

  }

  def getUtility(state: MinimaxState, player: MinimaxPlayer): UtilityValue = state.stateNumber match {
    case 4  => UtilityValue(3)
    case 5  => UtilityValue(12)
    case 6  => UtilityValue(8)
    case 7  => UtilityValue(2)
    case 8  => UtilityValue(4)
    case 9  => UtilityValue(6)
    case 10 => UtilityValue(14)
    case 11 => UtilityValue(5)
    case 12 => UtilityValue(2)
  }

}
