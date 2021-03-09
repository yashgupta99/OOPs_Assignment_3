package org.knoldus.bootstrap.model

import java.util.UUID

 abstract class User(id       : UUID,
                    name     : String,
                    email    : String,
                    category : Role.Value) {

 }
