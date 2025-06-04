package com.example.craft_reciepts.ui.detail

import NavigationViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemInformation(viewModel: NavigationViewModel) {
    val currentItem = viewModel.item[viewModel.currentPath] ?: return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(currentItem.image),
                contentDescription = "Item Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = viewModel.currentPath,
                fontSize = 52.sp,
                lineHeight = 60.sp,
                fontWeight = FontWeight(700)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = currentItem.text,
                fontSize = 36.sp,
                lineHeight = 42.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { viewModel.navigateBack() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Back",
                    fontSize = 36.sp
                )
            }
        }
    }
}