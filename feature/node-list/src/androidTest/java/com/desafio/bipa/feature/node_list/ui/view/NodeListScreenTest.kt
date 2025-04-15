package com.desafio.bipa.feature.node_list.ui.view

import androidx.activity.ComponentActivity
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import com.desafio.bipa.feature.node_list.model.NodeUi
import org.junit.Rule
import org.junit.Test

class NodeListScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun whenNodeListScreenIsDisplayed_shouldDisplayCorrectTitle() {
        composeTestRule.setContent {
            NodeListScreen(
                items = listOf(),
                isRefreshing = false,
                onEvent = {},
                snackbarHostState = SnackbarHostState()
            )
        }

        composeTestRule.onNodeWithText("Nodes").assertExists()
    }

    @Test
    fun whenNodeListScreenHasItems_shouldDisplayCorrectItemsAmount() {
        composeTestRule.setContent {
            NodeListScreen(
                items = listOf(
                    NodeUi(
                        publicKey = "publicKey1",
                        alias = "alias1",
                        channels = 10,
                        capacity = "capacity",
                        firstSeen = "firstSeen",
                        updatedAt = "updatedAt",
                        city = null,
                        country = null
                    ), NodeUi(
                        publicKey = "publicKey2",
                        alias = "alias2",
                        channels = 10,
                        capacity = "capacity",
                        firstSeen = "firstSeen",
                        updatedAt = "updatedAt",
                        city = null,
                        country = null
                    )
                ),
                isRefreshing = true,
                onEvent = {},
                snackbarHostState = SnackbarHostState()
            )
        }

        composeTestRule.onAllNodesWithTag("NodeItem").assertCountEquals(2)
    }
}