package com.example.composetv.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.Glow
import coil.compose.AsyncImage
import com.example.composetv.model.Movie
import com.example.composetv.ui.theme.Pink40
import com.example.composetv.ui.theme.Purple40

@Composable
fun PortraitCard(
    modifier: Modifier,
    movie: Movie? = null,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .size(300.dp, 180.dp),
        shape = CardDefaults.shape(RoundedCornerShape(10.dp)),
        glow = CardDefaults.glow(focusedGlow = Glow(elevationColor = Purple40, elevation = 100.dp)),
        scale = CardDefaults.scale(focusedScale = 1.08F),
        border = CardDefaults.border(
            focusedBorder = Border(
                border = BorderStroke(width = 4.dp, color = Color.White)
            )
        )
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = movie?.Images?.get(0),
            contentDescription = movie?.Title
        )
    }
}

@Preview(showSystemUi = true, device = Devices.TV_1080p)
@Composable
fun Preview() {
    PortraitCard(modifier = Modifier)
}