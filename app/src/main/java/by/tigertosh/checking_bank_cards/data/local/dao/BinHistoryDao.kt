package by.tigertosh.checking_bank_cards.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BinHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinHistory(binHistory: BinHistoryEntity)

    @Query("SELECT * FROM bin_history ORDER BY timestamp DESC")
    fun getAllBinHistory(): Flow<List<BinHistoryEntity>>
}