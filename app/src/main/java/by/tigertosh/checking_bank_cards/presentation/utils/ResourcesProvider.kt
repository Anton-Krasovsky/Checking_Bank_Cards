package by.tigertosh.checking_bank_cards.presentation.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourcesProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getString(resId: Int): String {
        return context.getString(resId)
    }
}