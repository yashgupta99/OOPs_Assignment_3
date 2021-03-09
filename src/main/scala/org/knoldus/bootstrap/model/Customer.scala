package org.knoldus.bootstrap.model

import java.util.UUID

case class Customer(
                     id       : UUID,
                     name     : String,
                     email    : String,
                     category : Role.Value
                   ) extends User(id ,name, email ,category)
