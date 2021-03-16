package org.knoldus.database

import org.knoldus.model.{User, UserType}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.collection.mutable.ListBuffer

class UserDatabaseTest extends AsyncFlatSpec {

  val userDatabase = new UserDatabase
  val user: User = User(java.util.UUID.randomUUID(), "Yash", UserType.Admin)
  it should "create the new User" in{
    val result: Boolean = userDatabase.createUser(user)
    assert(result)
  }

  it should "not create the new User because it already exist" in{
    val result: Boolean = userDatabase.createUser(user)
    assert(!result)
  }

  it should "return the ListBuffer contains all the users" in{
    val resultList:List[User] = userDatabase.listAllUser()
    assert(resultList.nonEmpty)
  }

  it should "update the existing user with new user" in{
    userDatabase.createUser(user)
    val newUser :User = User(java.util.UUID.randomUUID(),"Honey Sing",UserType.Customer)
    userDatabase.updateUser(user,newUser)
    val users :List[User] = userDatabase.listAllUser()
    assert(users.contains(newUser))
  }

  it should "not update the user with new user" in{
    userDatabase.createUser(user)
    val newUser1 :User = User(java.util.UUID.randomUUID(),"Honey Sing",UserType.Customer)
    val newUser2 :User = User(java.util.UUID.randomUUID(),"Sing",UserType.Customer)
    userDatabase.updateUser(newUser1,newUser2)
    val users :List[User] = userDatabase.listAllUser()
    assert(!users.contains(newUser2))
  }

  it should "update the name of an existing user" in{
    userDatabase.createUser(user)
    userDatabase.updateUserName(user,"Yash Gupta")
    val temp : User = userDatabase.getUserById(user.id)
    assert(temp.name == "Yash Gupta")
  }

  it should "update the category of an existing user" in {
    userDatabase.createUser(user)
    userDatabase.updateUserCategory(user,UserType.Customer)
    val temp : User = userDatabase.getUserById(user.id)
    assert(temp.category == UserType.Customer)
  }

  it should "delete the existing user from the database" in{
    userDatabase.createUser(user)
    userDatabase.deleteUser(user)
    assert(!userDatabase.listAllUser().contains(user))
  }
}
