package com.example.data.di

import com.example.data.remote.datasource.ProductRemoteDataSource
import com.example.data.remote.datasource.ProductServerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindRemoteDataSource(impl: ProductServerDataSource): ProductRemoteDataSource
}
