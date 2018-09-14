package com.artrak.sskey.newOld

import retrofit2.http.Body
import io.reactivex.Observable
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import java.net.CookieManager


interface ApiServiceGeneral {

    @retrofit2.http.GET("home")
    fun home(): Observable<Result>

    @retrofit2.http.POST("login")
    fun login(@Body login: LoggingIn): Observable<Result>

    @retrofit2.http.GET("user/passwords")
    fun passwords(): Observable<PasswordsList>





    /**
    * Companion object for the factory
    */
    companion object Factory {
        fun create(): ApiServiceGeneral {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("https://sskey.herokuapp.com/")
                    .client(OkHttpClient.Builder()
                            // this line is the important one:
                            .cookieJar(JavaNetCookieJar(CookieManager()))
                            .build())
                    .build()

            return retrofit.create(ApiServiceGeneral::class.java)
        }
    }

//    JavaNetCookieJar jncj = new JavaNetCookieJar(CookieHandler.getDefault());
//    OkHttpClient.Builder().cookieJar(jncj).build();
}