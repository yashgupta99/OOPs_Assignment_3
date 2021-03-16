package org.knoldus.model

object UserType extends Enumeration {
  type Roley = Value
  val Customer: UserType.Value = Value("CUSTOMER")
  val Admin: UserType.Value = Value("ADMIN")
}
