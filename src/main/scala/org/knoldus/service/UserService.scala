package org.knoldus.service

import org.knoldus.model.{User, UserType}
import org.knoldus.repository.dao.Dao

import java.util.UUID
import scala.collection.mutable.ListBuffer

class UserService(userDatabase: Dao[User]){
  def createNewUser(user: User): Boolean = {
    if(user.id != null && user.name.nonEmpty && UserType.values.contains(user.category)){
      userDatabase.createUser(user)
    }
    else false
  }

  def getAllUser(): List[User] ={
    userDatabase.listAllUser()
  }

  def updateUser(oldUser : User, newUser : User):Boolean ={
    if(oldUser != newUser){
      userDatabase.updateUser(oldUser,newUser)
    }
    else false
  }

  def updateUserName(user : User, newName : String):Boolean ={
    if(user.name != newName && newName.nonEmpty){
      userDatabase.updateUserName(user,newName)
    }
    else {
      false
    }
  }

  def updateUserCategory(user:User , newCategory : UserType.Value): Boolean ={
    if(user.category != newCategory && UserType.values.contains(newCategory)){
      userDatabase.updateUserCategory(user , newCategory)
    }
    else false
  }

  def deleteUser(user : User) : Boolean={
    if(userDatabase.deleteUser(user)) true
    else false
  }

  def getById(id:UUID): User ={
    userDatabase.getUserById(id)
  }
}
