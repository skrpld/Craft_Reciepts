package com.example.craft_reciepts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.craft_reciepts.data.MainActivity2Data

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prevItem = intent.getStringExtra("Item1")
        val itemsData = MainActivity2Data()
        val categories = prevItem?.let { itemsData.itemsData[it] } ?: emptyList()

        setContent {
            val context = LocalContext.current

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
            ) {
                items(categories) { item ->
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(8.dp)
                        .clickable {
                            navigateToMainActivity3(context, item)
                        }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Background",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Row(){
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_foreground),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .fillMaxHeight()
                            )
                            Text(
                                item,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                fontSize = 52.sp
                            )
                        }
                    }
                }
            }
        }
    }

    fun navigateToMainActivity3 (context: Context, item: String) {
        val intent = Intent(context, MainActivity3::class.java)
        intent.putExtra("Item2", item)
        context.startActivity(intent)
    }
}