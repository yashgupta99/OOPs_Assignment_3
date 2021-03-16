package org.knoldus.service

import org.knoldus.database.UserDatabase
import org.knoldus.model.{User, UserType}
import org.knoldus.repository.dao.Dao
import org.scalatest.flatspec.AsyncFlatSpec

class UserServiceIntegrationTest extends AsyncFlatSpec{
  val data_access_object: Dao[User] = new UserDatabase
  val userService = new UserService(data_access_object)
  val user1: User = User(java.util.UUID.randomUUID(), "Yash", UserType.Admin)

  it should "create/add new user in database and return true" in{
    val result:Boolean = userService.createNewUser(user1)
    assert(result)
  }

  it should "not create/add new user in database and return false beacuase it already exist" in{
    val result:Boolean = userService.createNewUser(user1)
    assert(!result)
  }

  it should "return a List which contains all users" in{
    val userList = userService.getAllUser()
    assert(userList.nonEmpty)
  }

  it should "update an existing user with new user" in{
    userService.createNewUser(user1)
    val newUser = User(java.util.UUID.randomUUID(),"Honey Singh",UserType.Customer)
    userService.updateUser(user1,newUser)
    assert(!userService.getAllUser().contains(user1))
    assert(userService.getAllUser().contains(newUser))
  }

  it should "update the name of an existing user" in{
    userService.createNewUser(user1)
    userService.updateUserName(user1,"Kuldeepak")
    val updateUser:User = userService.getById(user1.id)
    assert(updateUser.name == "Kuldeepak")
  }

  it should "update the category of an existing user" in{
    userService.createNewUser(user1)
    userService.updateUserCategory(user1,UserType.Customer)
    val updateUser:User = userService.getById(user1.id)
    assert(updateUser.category == UserType.Customer)
  }

  it should "delete an existing user" in{
    userService.createNewUser(user1)
    userService.deleteUser(user1)
    val userList = userService.getAllUser()
    assert(!userList.contains(user1))
  }
  /*
  userService.createNewUser(user2)
  userService.createNewUser(user3)
  userService.createNewUser(user4)
  */

}
