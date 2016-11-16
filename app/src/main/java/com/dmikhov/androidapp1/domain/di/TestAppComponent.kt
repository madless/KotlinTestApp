package com.dmikhov.androidapp1.domain.di

/**
 * Created by dmikhov on 16.11.2016.
 */

import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(ManagerModule::class, RepositoryModule::class, MockServerApiModule::class))
@Singleton interface TestAppComponent: BaseAppComponent