# OOPs_Assignment_3

In this project I solved the problem which is :

Create a User Management System.

Application
--------------
2 Types of Users:
a) Customer
b) Admins


Acceptance Criteria (Demo) :
1. Create a Main class under `org.knoldus.bootstarp` and perform following operator.
a. Create two User [Customer and Admin]
b. List all user
c. Update UserName of Admin
d. Delete Customer

So, according to above problem I created  following scala file:-

*A Trait class(dc.scala) in data folder to implement the abstract methods:-
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

*A service scala class(UserService) in a module(service) it extends the ds trait to override all the 			methods according to need.

*Four Model scala class in model folder :
		User.scala, 
		Admin.scala, 
		Customer.scala, 
		Role.scala, 
			where:
				-User.scala is an abstract class and parent class of both Admin and 						Customer.

				-Admin and customer both are case classes.

				-Role.scala is object class extend 					 Enumration to give the certain 				
				 choices

*A Main class in the MAin folder to run the methods.  				


			 
