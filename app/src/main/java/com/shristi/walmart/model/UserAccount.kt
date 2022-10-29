package com.shristi.walmart.model

import java.io.Serializable

// We can use both Serializable and Parcelable. Parcelable is faster than Serializable.
// Parcelable is going to convert object to byte stream and pass the data between two activities.

data class UserAccount(var firstName:String? = "",
                       var lastName:String? = "" ,
                       var userEmail:String?,
                       var password:String?)
    : Serializable {

    override fun toString(): String {
        return "[$firstName , $lastName , $userEmail]"
    }

    override fun equals(user: Any?): Boolean {
        var ua:UserAccount  = user as UserAccount
        if (ua.userEmail.isNullOrEmpty() && ua.password.isNullOrEmpty()){
            return false
        }

        if (ua.userEmail.equals(this.userEmail) && ua.password.equals(this.password)){
            return true
        }
        return false
    }
}