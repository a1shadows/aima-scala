package aima.core.environment.vacuum

import aima.core.agent.{Environment, Action, UnreliableActuator, Agent}
import aima.core.util.DefaultRandomness

/**
  * @author Shawn Garner
  */
class SuckerActuator(val agent: Agent) extends UnreliableActuator
  def act(action: Action, environment: Environment): Environment = {
    unreliably(environment) {
      environment.actuate(self, action)
    }
  }
}
class MoveActuator(val agent: Agent) extends UnreliableActuator
  def act(action: Action, environment: Environment): Environment = {
    unreliably(environment) {
      environment.actuate(self, action)
    }
  }
}