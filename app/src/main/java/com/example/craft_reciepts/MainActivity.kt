package com.example.craft_reciepts

import NavigationViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.craft_reciepts.ui.home.CategoryList

class MainActivity : ComponentActivity() {
    private val viewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryList(viewModel = viewModel)
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