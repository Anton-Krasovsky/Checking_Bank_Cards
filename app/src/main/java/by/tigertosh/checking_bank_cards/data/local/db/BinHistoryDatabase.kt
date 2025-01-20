package by.tigertosh.checking_bank_cards.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.tigertosh.checking_bank_cards.data.local.dao.BinHistoryDao
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity

@Database(entities = [BinHistoryEntity::class], version = 1, exportSchema = false)
abstract class BinHistoryDatabase : RoomDatabase() {
    abstract fun binHistoryDao(): BinHistoryDao
}