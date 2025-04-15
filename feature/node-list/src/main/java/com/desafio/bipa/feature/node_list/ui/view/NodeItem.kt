package com.desafio.bipa.feature.node_list.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desafio.bipa.core.design_system.BipaLightningTheme

@Composable
internal fun NodeItem(
    modifier: Modifier = Modifier,
    publicKey: String,
    alias: String,
    channels: Long,
    capacity: String,
    firstSeen: String,
    updatedAt: String,
    city: String?,
    country: String?
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Key, contentDescription = "Public Key")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .testTag("PublicKey"),
                    text = publicKey,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Badge, contentDescription = "Alias")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier
                        .basicMarquee()
                        .padding(start = 6.dp)
                        .testTag("Alias"),
                    text = alias
                )
            }

            HorizontalDivider()

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Hub, contentDescription = "Channels")
                Spacer(modifier = Modifier.width(4.dp))
                Text(modifier = Modifier.testTag("Channels"), text = channels.toString())
            }

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Money, contentDescription = "Capacity")
                Spacer(modifier = Modifier.width(4.dp))
                Text(modifier = Modifier.testTag("Capacity"), text = capacity)
            }

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.AccessTime, contentDescription = "First seen")
                Spacer(modifier = Modifier.width(4.dp))
                Text(modifier = Modifier.testTag("FirstSeen"), text = firstSeen)
            }

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Update, contentDescription = "Updated At")
                Spacer(modifier = Modifier.width(4.dp))
                Text(modifier = Modifier.testTag("UpdatedAt"), text = updatedAt)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Icon(Icons.Default.Public, contentDescription = "Location")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.testTag("Location"),
                        text = "${city ?: "Unknown"}, ${country ?: "Unknown"}",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NodeItemPreview() {
    BipaLightningTheme {
        NodeItem(
            publicKey = "03864ef025fde8fb587d989186ce6a4a186895ee44a926bfc370e2c366597a3f8f",
            alias = "ACINQ",
            channels = 2474,
            capacity = "0.70451829444 BTC",
            firstSeen = "11/06/2019",
            updatedAt = "20/06/2022",
            city = "São Paulo",
            country = "Brasil"
        )
    }
}
