package by.tigertosh.checking_bank_cards.data.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.tigertosh.checking_bank_cards.data.local.entity.BinHistoryEntity
import by.tigertosh.checking_bank_cards.presentation.ui.BinHistoryScreen
import by.tigertosh.checking_bank_cards.presentation.ui.FirstScreen
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinHistoryViewModel
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinViewModel

@Composable
fun AppNavHost(
    binViewModel: BinViewModel,
    binHistoryViewModel: BinHistoryViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(
                onSubmit = { bin ->
                    val response = binViewModel.binResponse.value
                    if (response != null) {
                        binHistoryViewModel.saveBinHistory(
                            BinHistoryEntity(
                                bin = bin,
                                scheme = response.scheme,
                                type = response.type,
                                brand = response.brand,
                                bankName = response.bank?.name,
                                bankUrl = response.bank?.url,
                                bankPhone = response.bank?.phone,
                                bankCity = response.bank?.city,
                                countryName = response.country?.name,
                                countryEmoji = response.country?.emoji,
                                countryLatitude = response.country?.latitude,
                                countryLongitude = response.country?.longitude
                            )
                        )
                    }
                },
                viewModel = binViewModel,
                onHistoryClick = {
                    navController.navigate("history_screen")
                }
            )
        }

        composable("history_screen") {
            BinHistoryScreen(
                onBack = {
                    navController.navigateUp()
                },
                viewModel = binHistoryViewModel
            )
        }
    }
}