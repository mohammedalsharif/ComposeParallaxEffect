package com.example.composeparallaxeffect.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FixedScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeparallaxeffect.R
import com.example.composeparallaxeffect.data.Explore
import com.example.composeparallaxeffect.data.TopRated
import com.example.composeparallaxeffect.ui.theme.Black50
import com.example.composeparallaxeffect.ui.theme.TextWhite

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreSection(list: List<Explore>) {

    val pagerState = rememberPagerState()


    Column(modifier = Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.size(40.dp))

        HeadingTextComponent(
            value = "Explore".uppercase(),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        TextComponent(
            value = "Discover your next dream destination",
            fontColor = Color.LightGray,
            textSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        HorizontalPager(
            pageCount = list.size,
            state = pagerState,
            contentPadding = PaddingValues(16.dp)
        ) {

            val scrollOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction

            ExploreItemComponent(list[it], scrollOffset)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ExploreSectionPreview() {
    ExploreSection(
        list = listOf(
            Explore(title = "Santorini", subTitle = "Greece", R.drawable.pic1)
        )
    )
}

@Composable
fun ExploreItemComponent(
    item: Explore,
    scrollX: Float,
    modifier: Modifier = Modifier,
) {

    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(16.dp)
    ) {
        BoxWithConstraints {

            Image(
                painter = painterResource(id = item.imgId),
                contentDescription = "",
                modifier = modifier.aspectRatio(0.7f, true),
                alignment = BiasAlignment(scrollX, 0f),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .aspectRatio(0.7f)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0xCC000000)
                            ),
                            startY = 900f,
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {

                HeadingTextComponent(item.title)

                TextComponent(item.subTitle)

            }


        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopRatedSection(list: List<TopRated>) {
    val pagerState = rememberPagerState()
    Column(modifier = Modifier.fillMaxWidth()) {
        HeadingTextComponent(
            value = "Top Rated",
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            textSize = 20.sp
        )
        HorizontalPager(
            pageCount = list.size,
            state = pagerState,
            contentPadding = PaddingValues(top = 16.dp, bottom = 80.dp, start = 16.dp, end = 16.dp)

        ) {

            val scrollOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
            TopRatedItem(scrollOffset, list[it])
        }

    }


}

@Preview(showBackground = true)
@Composable
fun TopRatedSectionPreview() {
    TopRatedSection(list = listOf(TopRated(title = "Cappadocia", subTitle = "Turkey", R.drawable.pic4)))
}

@Composable
fun TopRatedItem(scrollX: Float, item: TopRated) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(30.dp),

        ) {

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = item.imgId),
                contentScale = FixedScale(2.5f),
                contentDescription = "",
                alignment = BiasAlignment(scrollX, 0f)
                )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .matchParentSize()
                    .background(Black50)
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    HeadingTextComponent(item.title, textSize = 28.sp)
                    TextComponent(item.subTitle)
                }
            }
        }
    }
}



@Composable
fun HeadingTextComponent(
    value: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 32.sp,
    color: Color = Color.White,
) {
    Text(
        text = value,
        modifier = modifier,
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun TextComponent(value: String, fontColor: Color = TextWhite, textSize: TextUnit = 20.sp, modifier: Modifier = Modifier) {
    Text(
        text = value,
        fontSize = textSize,
        color = fontColor,
        modifier = modifier,
        fontWeight = FontWeight.Light
    )
}


