package org.knoldus.bootstrap.main


import org.knoldus.bootstrap.model.{Admin, Customer, Role}
import org.knoldus.bootstrap.services.UserService

object Main extends UserService {
  def main(args: Array[String]): Unit = {
    val ob1: Admin    = Admin(java.util.UUID.randomUUID(), "Yashw", "yash.gupta@gmail.com",Role.Admin)
    val ob2: Admin    = Admin(java.util.UUID.randomUUID(), "Yash", "yash.wgupta@gmail.com",Role.Admin)
    val ob3: Customer = Customer(java.util.UUID.randomUUID(), "Yh", "ya.gupta@gmail.com",Role.Customer)
    val ob4: Customer = Customer(java.util.UUID.randomUUID(), "Yas", "ash.gupta@gmail.com",Role.Customer)
    val ob5: Customer = Customer(java.util.UUID.randomUUID(), "ash", "ash.gupta@gmail.com",Role.Customer)
    createUser(ob1) //Add user in the database
    createUser(ob2) //Add user in the database
    createUser(ob3) //Add user in the database
    createUser(ob3) //Add user in the database
    createUser(ob4) //Add user in the database
    createUser(ob5) //Add user in the database

    listAllUser() //print all user on the command line

    println("===========================")

    updateNameOfAnUser(ob1.id,"jassy") //update the username of an User

    listAllUser() //print updated list

    println("===============================")

    deleteAnUser(ob1.id) //delete an user

    listAllUser() //print updated list




  }
}
