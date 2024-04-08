package com.example.composetv.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.example.composetv.cards.PortraitCard
import com.example.composetv.model.Item
import com.example.composetv.model.Movie

@Composable
fun Home(
    modifier: Modifier = Modifier,
    itemList: ArrayList<Item>,
    onItemSelected: (Movie) -> Unit = {}
) {
    TvLazyColumn(
        modifier = modifier.fillMaxSize().padding(start = 80.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        items(itemList) { section ->
            Section(section, onItemSelected = onItemSelected)
        }
    }
}

@Composable
fun Section(
    item: Item,
    modifier: Modifier = Modifier,
    onItemSelected: (Movie) -> Unit = {},
) {
    Text(
        text = item.title,
        style = MaterialTheme.typography.headlineSmall,
    )
    Spacer(modifier = Modifier.height(20.dp))
    TvLazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(item.movies) { movie ->
            PortraitCard(
                movie = movie,
                onClick = { onItemSelected(movie) }
            )
        }
    }
}

@Preview(showSystemUi = true, device = Devices.TV_1080p)
@Composable
fun Preview() {
    //Home()
}