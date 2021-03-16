package org.knoldus.service

import org.knoldus.database.UserDatabase
import org.knoldus.model.{User, UserType}
import org.knoldus.repository.dao.Dao
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.collection.mutable.ListBuffer

class UserServiceUnitTest extends AsyncFlatSpec{
  val mockedUserDatabase: Dao[User] = mock(classOf[UserDatabase])
  val userService = new UserService(mockedUserDatabase)
  val user: User = User(java.util.UUID.randomUUID(), "Yash", UserType.Admin)

  it should "create a new user in database and return true" in{
    when(mockedUserDatabase.createUser(user)) thenReturn true
    val result  = userService.createNewUser(user)
    assert(result)
  }

  it should "not create a new user in database and return false" in{
    when(mockedUserDatabase.createUser(user)) thenReturn true
    val result :Boolean = userService.createNewUser(User(java.util.UUID.randomUUID(),"",UserType.Customer))
    assert(!result)
  }

  it should "return a ListBuffer containg all the user it may be empty" in {
    when(mockedUserDatabase.listAllUser()) thenReturn List()
    val resultList = userService.getAllUser()
    assert(resultList.isEmpty)
  }

  it should "update an existing user with new user" in{
    val newUser = User(java.util.UUID.randomUUID(), "Sindhu bhai", UserType.Customer)
    when(mockedUserDatabase.updateUser(user,newUser)) thenReturn true
    assert(userService.updateUser(user,newUser))
  }


  it should "not update user with new user" in{
    when(mockedUserDatabase.updateUser(user,user)) thenReturn false
    assert(!userService.updateUser(user,user))
  }

  it should "update the name of an existing user" in{
    val newName:String = "Yatendra"
    when(mockedUserDatabase.updateUserName(user,newName)) thenReturn true
    assert(userService.updateUserName(user,newName))
  }

  it should "not update the name of an existing user" in{
    val newName:String = ""
    when(mockedUserDatabase.updateUserName(user,newName)) thenReturn false
    assert(!userService.updateUserName(user,newName))
  }

  it should "update the category of an existing user" in{
    val category = UserType.Customer
    when(mockedUserDatabase.updateUserCategory(user,category)) thenReturn true
    assert(userService.updateUserCategory(user,category))
  }

  it should "not update the category of an existing user" in{
    val category = UserType.Admin
    when(mockedUserDatabase.updateUserCategory(user,category)) thenReturn false
    assert(!userService.updateUserCategory(user,category))
  }

  it should "delete an existing user" in{
    when(mockedUserDatabase.deleteUser(user)) thenReturn true
    assert(userService.deleteUser(user))
  }

  it should "not be able to delete an user" in{
    val newUser = User(java.util.UUID.randomUUID(), "Sindhu bhai", UserType.Customer)
    when(mockedUserDatabase.deleteUser(newUser)) thenReturn false
    assert(!userService.deleteUser(newUser))
  }
}
