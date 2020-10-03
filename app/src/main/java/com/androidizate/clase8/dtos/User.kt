package com.androidizate.clase8.dtos

/**
 * Created by andres.oller on 18/08/17.
 */
class User {
    var id: Long = 0L
    var name: String = ""
    var username: String = ""
    var email: String = ""
    var address: Address = Address()
    var phone: String = ""
    var website: String = ""
    var company: Company = Company()
}