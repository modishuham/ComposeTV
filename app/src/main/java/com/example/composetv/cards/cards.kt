package com.example.composetv.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import coil.compose.AsyncImage
import com.example.composetv.model.Movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun PortraitCard(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier.size(300.dp, 180.dp),
        shape = CardDefaults.shape(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = movie.Images[0],
            contentDescription = movie.Title
        )
    }
}

@Preview(showSystemUi = true, device = Devices.TV_1080p)
@Composable
fun Preview() {
   // PortraitCard()
}