package org.knoldus.repository.dao

import org.knoldus.model.UserType

import java.util.UUID
import scala.collection.mutable.ListBuffer

trait Dao[T] {

  def createUser(obj : T) : Boolean

  def listAllUser():ListBuffer[T]

  def updateUser(oldObject: T, newObject:T): Boolean

  def deleteUser(obj : T) : Boolean

  def updateUserName(obj : T , newName : String) : Boolean

  def updateUserCategory(obj :T , newCategory :UserType.Value) : Boolean

}
