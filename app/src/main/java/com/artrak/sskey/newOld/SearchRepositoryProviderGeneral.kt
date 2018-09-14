package com.artrak.sskey.newOld

object SearchRepositoryProviderGeneral {

    fun provideSearchRepositoryGeneral(): SearchRepositoryGeneral {
        return SearchRepositoryGeneral(ApiServiceGeneral.create())
    }
}