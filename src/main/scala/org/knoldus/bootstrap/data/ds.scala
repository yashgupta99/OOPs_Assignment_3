package org.knoldus.bootstrap.data

import org.knoldus.bootstrap.model.{Admin, Customer, User}

import java.util.UUID

trait ds {
  var list: List[User] = List()

  var map:Map[String, User] = Map()

  def createUser(obj : Admin):Boolean

  def getUUID(obj : Admin):UUID

  def getUser(obj : Admin): String

  def getUser(id : UUID): User

  def createUser(obj : Customer):Boolean

  def getUUID(obj : Customer):UUID

  def getUser(obj : Customer): String

  def listAllUser():Unit

  def updateNameOfAnUser(id:UUID,uName:String)

  def deleteAnUser(id:UUID)
}
