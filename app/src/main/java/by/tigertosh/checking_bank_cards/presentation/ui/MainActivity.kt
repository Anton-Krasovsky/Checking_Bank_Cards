package by.tigertosh.checking_bank_cards.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinHistoryViewModel
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinViewModel
import by.tigertosh.checking_bank_cards.data.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val binViewModel: BinViewModel = viewModel()
            val binHistoryViewModel: BinHistoryViewModel = viewModel()

            AppNavHost(
                binViewModel = binViewModel,
                binHistoryViewModel = binHistoryViewModel
            )
        }
    }
}








