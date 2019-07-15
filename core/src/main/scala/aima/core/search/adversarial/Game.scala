package aima.core.search.adversarial

final case class UtilityValue(value: Double) extends AnyVal

/**
  * @author Aditya Lahiri
  */
trait Game[PLAYER, STATE, ACTION] {
  def initialState: STATE
  def getPlayer(state: STATE): PLAYER
  def getActions(state: STATE): List[ACTION]
  def result(state: STATE, action: ACTION): STATE
  def getUtility(state: STATE, player: PLAYER): UtilityValue
}
