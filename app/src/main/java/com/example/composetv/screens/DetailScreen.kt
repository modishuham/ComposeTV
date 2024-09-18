package com.example.composetv.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.example.composetv.ui.theme.Pink40
import com.example.composetv.ui.theme.Purple40
import com.example.composetv.ui.theme.Purple80

@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    image: String?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name ?: "",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(30.dp)
            )

            AsyncImage(
                modifier = Modifier
                    .height(300.dp)
                    .aspectRatio(16f / 9f)
                    .background(color = Pink40),
                contentScale = ContentScale.Crop,
                model = image,
                contentDescription = name
            )
        }
    }
}

@Preview(showSystemUi = true, device = Devices.TV_1080p)
@Composable
fun DetailPreview() {
    DetailScreen(
        navController = rememberNavController(),
        name = "Avengers",
        image = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxNjc1NjI0NV5BMl5BanBnXkFtZTgwNzA0NzY0ODE@._V1_SY1000_CR0,0,1497,1000_AL_.jpg"
    )
}