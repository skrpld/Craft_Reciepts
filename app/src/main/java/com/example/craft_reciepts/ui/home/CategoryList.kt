package com.example.craft_reciepts.ui.home

import NavigationViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.craft_reciepts.ui.detail.ItemInformation
import com.example.craft_reciepts.R

@Composable
fun CategoryList(viewModel: NavigationViewModel) {
    val currentPath = viewModel.currentPath

    if (viewModel.item.containsKey(currentPath)) {
        ItemInformation(viewModel = viewModel)
        return
    }

    val categories = viewModel.categories[currentPath] ?: return

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(8.dp)
                    .clickable { viewModel.navigateTo(category.title) }
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Category Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(category.image),
                        contentDescription = "Category Icon",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = category.title,
                        fontSize = 36.sp,
                        lineHeight = 42.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}