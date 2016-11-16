package com.dmikhov.androidapp1.domain.di

import com.dmikhov.androidapp1.domain.net.HerokuServerApi
import com.dmikhov.androidapp1.domain.net.ServerApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dmikhov on 16.11.2016.
 */
@Module
class HerokuServerApiModule {
    @Provides
    @Singleton
    fun provideHerokuServerApi(): ServerApi = HerokuServerApi()
}
