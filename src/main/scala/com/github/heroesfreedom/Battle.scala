package com.github.heroesfreedom

import com.github.heroesfreedom.BattleError._

case class Battle[H <: Hero] private[Battle] (players: Set[H], id: Long) {
  val field = Array.ofDim[Int](10, 10)

}

object Battle {
  def apply[H <: Hero](id: Long, players: Set[H]): Either[BattleError, Battle[H]] =
    if (players.size < 2) Left(AtLeastTwoPlayersShouldBeSpecified) else Right(new Battle(players, id))
}


trait BattleError
object BattleError {
  case object AtLeastTwoPlayersShouldBeSpecified extends BattleError
}


trait Hero {
  val name: String
  val level: Int
  val attack: Int
  val army: Set[ArmyUnit]
}
case class Player(name: String, level: Int, attack: Int, army: Set[ArmyUnit]) extends Hero
case class InvisibleEnemy(attack: Int, army: Set[ArmyUnit]) extends Hero {
  override val name = this.getClass.getSimpleName
  override val level = 0
}

case class ArmyUnit(t: ArmyUnitType, amount: Int)


trait ArmyUnitType {
  val initiative: Int
}
object ArmyUnitType {
  case object PoorWarrior extends ArmyUnitType{
    override val initiative = 15
  }
  case object Slave extends ArmyUnitType {
    override val initiative = 10
  }
}