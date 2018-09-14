package com.artrak.sskey.newOld

import io.reactivex.Observable


class SearchRepositoryGeneral(val apiService: ApiServiceGeneral) {

    fun getHome(): Observable<Result> {
        return apiService.home()
    }

    fun postLogin(login: LoggingIn): Observable<Result> {
        return apiService.login(login)
    }

    fun getListPass(): Observable<PasswordsList>{
        return apiService.passwords()
    }
}