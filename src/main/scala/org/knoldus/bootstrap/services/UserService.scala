package org.knoldus.bootstrap.services

import org.knoldus.bootstrap.data.ds
import org.knoldus.bootstrap.model.{Admin, Customer, Role, User}

import java.util.UUID

class UserService extends ds{
  override def createUser(obj: Admin): Boolean = {
      if(!map.contains(obj.id.toString)) {
        list = list ::: List(obj)
        map += (obj.id.toString -> obj)
        return true
      }
      false
  }


  override def getUUID(obj: Admin): UUID ={
    obj.id
  }

  override def getUser(obj: Admin): String ={
    obj.toString
  }

  override def getUser(id: UUID): User ={
    if(map.contains(id.toString)){
      map(id.toString)
    }
    else{
      println("id is not valid")
      null
    }
  }
  override def createUser(obj: Customer): Boolean ={
    if(!map.contains(obj.id.toString)) {
      list = list ::: List(obj)
      map += (obj.id.toString -> obj)
      return true
    }
    false
  }

  override def getUUID(obj: Customer): UUID ={
    obj.id
  }

  override def getUser(obj: Customer): String ={
    obj.toString
  }

  override def listAllUser(): Unit  = {
    for(element <- list) println(element)
  }

  override def updateNameOfAnUser(id: UUID, uName: String): Unit = {
    getUser(id) match {
      case admin: Admin =>{
        val new_object:Admin = Admin(admin.id, uName, admin.email,admin.category)
        list = list.filter(_ != getUser(id))
        map -= id.toString
        createUser(new_object)
      }
      case customer: Customer =>{
        val new_object:Customer = Customer(customer.id, uName, customer.email,customer.category)
        createUser(new_object)
        list = list.filter(_ != getUser(id))
        map -= id.toString
        createUser(new_object)
      }
    }
  }

  override def deleteAnUser(id: UUID): Unit = {
    list = list.filter(_ != getUser(id))
    map -= id.toString
  }
}
