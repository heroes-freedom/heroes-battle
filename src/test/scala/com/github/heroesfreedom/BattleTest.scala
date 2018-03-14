package com.github.heroesfreedom

import com.github.heroesfreedom.ArmyUnitType.{PoorWarrior, Slave}
import org.scalatest.{FlatSpec, Matchers}

import scala.util.Left


class BattleTest extends FlatSpec with Matchers {
  val playerFreeFly = Player("FreeFly", 1, 5, Set(ArmyUnit(Slave, 5)))
  val playerEnemy = InvisibleEnemy(1, Set(ArmyUnit(PoorWarrior, 3)))


  "Battle " should  "return error when less than two players passed" in {
    Battle(1, Set[Player]()) should be (Left(BattleError.AtLeastTwoPlayersShouldBeSpecified))
    Battle(1, Set(playerFreeFly)) should be (Left(BattleError.AtLeastTwoPlayersShouldBeSpecified))
  }

  it should  "not throw an exception when at least two players specified" in {
    Battle(1, Set(playerFreeFly, playerEnemy)).isLeft should be (false)
  }
}
