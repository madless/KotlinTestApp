package com.dmikhov.androidapp1.domain.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by dmikhov on 15.11.2016.
 */
@Component(modules = arrayOf(ManagerModule::class, RepositoryModule::class, HerokuServerApiModule::class))
@Singleton interface AppComponent: BaseAppComponent
