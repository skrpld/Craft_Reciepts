package com.example.craft_reciepts

import NavigationViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val viewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CategoryList(viewModel = viewModel)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.currentPath != "Main") {
            viewModel.navigateBack()
        } else {
            super.onBackPressed()
        }
    }
}

@Composable
fun CategoryList(viewModel: NavigationViewModel) {
    var categories = viewModel.categories[viewModel.currentPath] ?: return

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        items(categories!!.size) { index ->
            val category = categories[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(8.dp)
                    .clickable { viewModel.navigateTo(category.title)}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Category Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = category.image),
                        contentDescription = "Category Icon",
                    )
                    Text(
                        text = category.title,
                        fontSize = 36.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun ItemInformation(viewModel: NavigationViewModel) {
    var categories = viewModel.categories[viewModel.currentPath] ?: return

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        items(categories!!.size) { index ->
            val category = categories[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(8.dp)
                    .clickable { viewModel.navigateTo(category.title)}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Item Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = category.image),
                        contentDescription = "Category Icon",
                    )
                    Text(
                        text = category.title,
                        fontSize = 36.sp,
                    )
                }
            }
        }
    }
}