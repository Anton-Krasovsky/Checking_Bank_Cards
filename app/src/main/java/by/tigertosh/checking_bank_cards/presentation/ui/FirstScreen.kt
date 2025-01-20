package by.tigertosh.checking_bank_cards.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import by.tigertosh.checking_bank_cards.presentation.viewmodel.BinViewModel
import by.tigertosh.checking_bank_cards.R

@Composable
fun FirstScreen(
    onSubmit: (String) -> Unit,
    viewModel: BinViewModel = viewModel(),
    onHistoryClick: () -> Unit
) {
    val binResponse by viewModel.binResponse.collectAsState()
    val isError by viewModel.isError.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    var binInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .imePadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        CardInfoContainer(binResponse)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = binInput,
            onValueChange = { input ->
                val digitsOnly = input.text.replace(" ", "")

                if (digitsOnly.isEmpty()) {
                    binInput = TextFieldValue("")
                    viewModel.setError(false)
                    return@OutlinedTextField
                }

                if (digitsOnly.length <= 8) {
                    val formattedInput = digitsOnly.chunked(4).joinToString(" ")

                    val cursorPosition = input.selection.start
                    val adjustedCursorPosition = calculateCursorPosition(digitsOnly, cursorPosition)

                    binInput = TextFieldValue(
                        text = formattedInput,
                        selection = TextRange(adjustedCursorPosition)
                    )

                    if (digitsOnly.length in 6..8) {
                        viewModel.setError(false)
                    } else {
                        viewModel.setError(true)
                    }
                }
            },
            label = { Text(text = stringResource(R.string.enter_a_bin)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            isError = isError,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val bin = binInput.text.replace(" ", "")
                if (!isError && bin.isNotEmpty()) {
                    viewModel.fetchBinDetails(bin)
                    onSubmit(bin)
                }
            },
            enabled = !isError && binInput.text.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.search_card))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onHistoryClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.query_history))
        }
    }
}

private fun calculateCursorPosition(digitsOnly: String, currentCursorPosition: Int): Int {
    val spaceCount = digitsOnly.chunked(4).size - 1
    val newCursorPosition = currentCursorPosition + spaceCount
    return newCursorPosition.coerceAtMost(digitsOnly.length + spaceCount)
}


