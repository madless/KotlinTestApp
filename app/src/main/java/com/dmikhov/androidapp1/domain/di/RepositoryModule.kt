package com.dmikhov.androidapp1.domain.di

import com.dmikhov.androidapp1.domain.repository.CloudRepository
import com.dmikhov.androidapp1.domain.repository.LocalRepository
import com.dmikhov.androidapp1.domain.repository.abs.ICloudRepository
import com.dmikhov.androidapp1.domain.repository.abs.ILocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dmikhov on 16.11.2016.
 */
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideLocalRepository() : ILocalRepository = LocalRepository()

    @Provides
    @Singleton
    fun provideCloudRepository() : ICloudRepository = CloudRepository()
}
