package com.yulmaso.navigationanimationbug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.yulmaso.navigationanimationbug.ui.theme.NavigationAnimationBugTheme

@Composable
fun SimpleScreen(
    title: String,
    description: String? = null,
    onNavigateBack: (() -> Unit)? = null,
    onNavigateNext: (() -> Unit)? = null,
) {
    Scaffold(
        topBar = {
            if (onNavigateBack != null) {
                IconButton(onClick = onNavigateBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        },
        bottomBar = {
            if (description != null) {
                Text(
                    text = description,
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                        vertical = 16.dp
                    )
                )
            }
        }
    ) { contentPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Text(
                text = title,
                fontSize = TextUnit(20f, TextUnitType.Sp)
            )
            if (onNavigateNext != null) {
                Button(
                    onClick = onNavigateNext
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NavigationAnimationBugTheme {
        SimpleScreen(
            title = "Test screen",
            description = "twoiejrlskndf",
            onNavigateBack = {},
            onNavigateNext = {}
        )
    }
}