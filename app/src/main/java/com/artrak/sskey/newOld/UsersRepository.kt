package com.artrak.sskey.newOld

import com.google.gson.annotations.SerializedName

data class Result(var message: String)

data class CheckHome(var home: String)

data class LoggingIn(val email: String, val password: String)

data class User(
        @SerializedName("email") val email: String,
        @SerializedName("username") val username: String,
        @SerializedName("password") val password: String,
        @SerializedName("first_name") val first_name: String,
        @SerializedName("last_name") val last_name: String,
        @SerializedName("phone") val phone: String
)

//data class User(
//        var email: String,
//        var username: String,
//        var password: String,
//        var first_name: String,
//        var last_name: String,
//        var phone: String
//)

data class UserList(
        val passwords: List<User>
)

data class Password(
        @SerializedName("pass_id") val pass_id: String,
        @SerializedName("url") val url: String,
        @SerializedName("title") val title: String,
        @SerializedName("login") val login: String,
        @SerializedName("password") val password: String,
        @SerializedName("comment") val comment: String
)

data class PasswordsList(
        val passwords: List<Password>
)

data class DeleteUsersIdList (val users_ids: Int)

data class SearchUsersData(val user_data: String)

data class UpdateUserData(val email: String, val username: String, val first_name: String,
                          val last_name: String, val phone: String)

data class CreateNewPassword(val url: String, val title: String, val login: String,
                             val password: String, val comment: String)

data class SearchPassword(val condition: String)