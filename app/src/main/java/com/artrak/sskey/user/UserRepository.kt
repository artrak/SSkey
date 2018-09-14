package com.artrak.sskey.user

data class CheckHome(var isHome: String)

data class LoggingIn(val email: String, val password: String)

data class CreateNewUser(val email: String, val username: String, val password: String,
                         val first_name: String, val last_name: String, val phone: String)

data class DeleteUsersIdList (val users_ids: Int)

data class SearchUsersData(val user_data: String)

data class UpdateUserData(val email: String, val username: String, val first_name: String,
                          val last_name: String, val phone: String)

data class CreateNewPassword(val url: String, val title: String, val login: String,
                             val password: String, val comment: String)

data class SearchPassword(val condition: String)