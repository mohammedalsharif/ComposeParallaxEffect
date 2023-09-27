package com.example.composeparallaxeffect.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeparallaxeffect.R
import com.example.composeparallaxeffect.data.Explore
import com.example.composeparallaxeffect.data.TopRated

@Composable
fun ParallaxScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ExploreSection(
            list = listOf(
                Explore(title = "Santorini", subTitle = "Greece", R.drawable.pic1),
                Explore(title = "Maldives", subTitle = "Archipelagic", R.drawable.pic2),
                Explore(title = "Cappadocia", subTitle = "Turkey", R.drawable.pic3),
            )
        )
        Spacer(modifier = Modifier.size(16.dp))

        TopRatedSection(
            list = listOf(
                TopRated(title = "Cappadocia", subTitle = "Turkey", R.drawable.pic4),
                TopRated(title = "Santori", subTitle = "Greece", R.drawable.pic1),
                TopRated(title = "Maldives", subTitle = "Archipelagic", R.drawable.pic6),
            )
        )
    }
}