package com.dmikhov.androidapp1.domain.di

import com.dmikhov.androidapp1.domain.repository.RepositoryManager
import com.dmikhov.androidapp1.domain.repository.abs.ICloudRepository
import com.dmikhov.androidapp1.domain.repository.abs.ILocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dmikhov on 16.11.2016.
 */
@Module
class ManagerModule {
    @Provides
    @Singleton
    fun provideRepositoryManager(cloudRepository: ICloudRepository, localRepository: ILocalRepository)
            = RepositoryManager(cloudRepository, localRepository)
}
