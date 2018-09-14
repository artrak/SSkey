package com.artrak.sskey.user

import retrofit2.Call

interface UserApi {

    @retrofit2.http.GET("home")
    fun home(): Call<CheckHome>
}