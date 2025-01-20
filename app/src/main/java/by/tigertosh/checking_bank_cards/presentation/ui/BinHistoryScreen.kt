package by.tigertosh.checking_bank_cards.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import by.tigertosh.checking_bank_cards.R
import by.tigertosh.checking_bank_cards.domain.model.BinHistory
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinHistoryViewModel

@Composable
fun BinHistoryScreen(
    onBack: () -> Unit,
    viewModel: BinHistoryViewModel = viewModel()
) {
    val binHistory by viewModel.binHistory.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = onBack,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = stringResource(R.string.back))
        }

        Text(
            text = stringResource(R.string.query_history),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(binHistory) { item ->
                BinHistoryItem(item)
            }
        }
    }
}

@Composable
fun BinHistoryItem(binHistory: BinHistory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {}
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.bin, binHistory.bin),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(R.string.bank, binHistory.bankName ?: "-"),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(
                    R.string.country,
                    binHistory.countryName ?: "-",
                    binHistory.countryEmoji ?: ""
                ),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(R.string.type_card, binHistory.type ?: "-"),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}