package by.tigertosh.checking_bank_cards.data.di

import by.tigertosh.checking_bank_cards.data.repository.BinHistoryRepositoryImpl
import by.tigertosh.checking_bank_cards.domain.repository.BinHistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBinHistoryRepository(
        binHistoryRepositoryImpl: BinHistoryRepositoryImpl
    ): BinHistoryRepository
}