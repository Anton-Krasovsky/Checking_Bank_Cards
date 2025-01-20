package by.tigertosh.checking_bank_cards.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import by.tigertosh.checking_bank_cards.R
import by.tigertosh.checking_bank_cards.domain.model.BinResponse

@Composable
fun CardInfoContainer(binResponse: BinResponse?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_bank),
                            contentDescription = stringResource(
                                R.string.e_bank
                            )
                        )
                        Text(
                            text = stringResource(R.string.e_bank).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.bank?.name ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = binResponse?.bank?.city ?: "-",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = binResponse?.bank?.phone ?: "-",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_card_brand),
                            contentDescription = stringResource(R.string.e_brand)
                        )
                        Text(
                            text = stringResource(R.string.e_brand).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.brand ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_network),
                            contentDescription = stringResource(R.string.e_scheme_network)
                        )
                        Text(
                            text = stringResource(R.string.e_scheme_network).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.scheme ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_type_card),
                            contentDescription = stringResource(R.string.e_type)
                        )
                        Text(
                            text = stringResource(R.string.e_type).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.type ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_country),
                            contentDescription = stringResource(R.string.e_country)
                        )
                        Text(
                            text = stringResource(R.string.e_country).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.country?.name ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "(${binResponse?.country?.latitude ?: "-"}, " +
                                    "${binResponse?.country?.longitude ?: "-"})",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_number_card),
                            contentDescription = stringResource(R.string.e_card_number)
                        )
                        Text(
                            text = stringResource(R.string.e_card_number).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "LENGTH: ${binResponse?.number?.length ?: "-"}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "LUHN: ${if (binResponse?.number?.luhn == true) "YES" else "NO"}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_prepair),
                            contentDescription = stringResource(R.string.e_prepaid)
                        )
                        Text(
                            text = stringResource(R.string.e_prepaid).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (binResponse?.prepaid == true) "Yes" else "No",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Box {
                    Column {
                        Icon(
                            painterResource(R.drawable.ic_currency),
                            contentDescription = stringResource(R.string.e_currency)
                        )
                        Text(
                            text = stringResource(R.string.e_currency).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = binResponse?.country?.currency ?: "-",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
