package com.desafio.bipa.feature.node_list.ui.view

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class NodeItemTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun whenNodeItemIsFilled_shouldDisplayCorrectAttributes() {
        composeTestRule.setContent {
            NodeItem(
                publicKey = "publicKey1",
                alias = "alias1",
                channels = 2280,
                capacity = "0,00065000 BTC",
                firstSeen = "11/06/2018 14:56",
                updatedAt = "16/04/2025 15:31",
                city = "New York",
                country = "United States"
            )
        }

        composeTestRule.onNodeWithText("publicKey1").assertExists()
        composeTestRule.onNodeWithText("alias1").assertExists()
        composeTestRule.onNodeWithText("2280").assertExists()
        composeTestRule.onNodeWithText("0,00065000 BTC").assertExists()
        composeTestRule.onNodeWithText("11/06/2018 14:56").assertExists()
        composeTestRule.onNodeWithText("16/04/2025 15:31").assertExists()
        composeTestRule.onNodeWithText("New York, United States").assertExists()
    }

    @Test
    fun whenNodeItemIsWithouCityFilled_shouldDisplayCorrectAttributes() {
        composeTestRule.setContent {
            NodeItem(
                publicKey = "publicKey1",
                alias = "alias1",
                channels = 2280,
                capacity = "0,00065000 BTC",
                firstSeen = "11/06/2018 14:56",
                updatedAt = "16/04/2025 15:31",
                city = null,
                country = "United States"
            )
        }

        composeTestRule.onNodeWithText("publicKey1").assertExists()
        composeTestRule.onNodeWithText("alias1").assertExists()
        composeTestRule.onNodeWithText("2280").assertExists()
        composeTestRule.onNodeWithText("0,00065000 BTC").assertExists()
        composeTestRule.onNodeWithText("11/06/2018 14:56").assertExists()
        composeTestRule.onNodeWithText("16/04/2025 15:31").assertExists()
        composeTestRule.onNodeWithText("Unknown, United States").assertExists()
    }

    @Test
    fun whenNodeItemIsWithouCityAndCountryFilled_shouldDisplayCorrectAttributes() {
        composeTestRule.setContent {
            NodeItem(
                publicKey = "publicKey1",
                alias = "alias1",
                channels = 2280,
                capacity = "0,00065000 BTC",
                firstSeen = "11/06/2018 14:56",
                updatedAt = "16/04/2025 15:31",
                city = null,
                country = null
            )
        }

        composeTestRule.onNodeWithText("publicKey1").assertExists()
        composeTestRule.onNodeWithText("alias1").assertExists()
        composeTestRule.onNodeWithText("2280").assertExists()
        composeTestRule.onNodeWithText("0,00065000 BTC").assertExists()
        composeTestRule.onNodeWithText("11/06/2018 14:56").assertExists()
        composeTestRule.onNodeWithText("16/04/2025 15:31").assertExists()
        composeTestRule.onNodeWithText("Unknown, Unknown").assertExists()
    }
}