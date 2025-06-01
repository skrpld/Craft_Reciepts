package com.example.craft_reciepts

import NavigationViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight

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
