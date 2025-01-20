package by.tigertosh.checking_bank_cards.data.di

import android.content.Context
import androidx.room.Room
import by.tigertosh.checking_bank_cards.data.local.dao.BinHistoryDao
import by.tigertosh.checking_bank_cards.data.local.db.BinHistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BinHistoryDatabase {
        return Room.databaseBuilder(
            context,
            BinHistoryDatabase::class.java,
            "bin_history_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBinHistoryDao(database: BinHistoryDatabase): BinHistoryDao {
        return database.binHistoryDao()
    }
}