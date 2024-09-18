package com.example.composetv.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.example.composetv.DataProvider
import com.example.composetv.cards.PortraitCard
import com.example.composetv.model.Item
import com.example.composetv.model.Movie
import com.example.composetv.utils.createInitialFocusRestorerModifiers

@Composable
fun HomeScreen(
    navController: NavController,
    onItemSelected: (Movie) -> Unit = {},
    context: Context = LocalContext.current
) {
    val itemList = DataProvider.getHomeData(context)
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentPadding = PaddingValues(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        state = scrollState
    ) {
        itemsIndexed(itemList) { row, section ->
            Section(
                row,
                navController,
                item = section,
                onItemSelected = onItemSelected
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Section(
    row: Int,
    navController: NavController,
    item: Item,
    onItemSelected: (Movie) -> Unit = {}
) {

    val (lazyRow, firstItem) = remember {
        FocusRequester.createRefs()
    }

    val scrollState = rememberLazyListState()

    Text(
        text = item.title,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(start = 20.dp),
        color = Color.White
    )
    Spacer(modifier = Modifier.height(20.dp))
    LazyRow(
        modifier = Modifier
            .focusRequester(lazyRow)
            .focusRestorer {
                firstItem
            },
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        state = scrollState
    ) {
        itemsIndexed(item.movies) { index, movie ->

            val itemModifier = if (index == 0) {
                Modifier.focusRequester(firstItem)
            } else {
                Modifier
            }
            PortraitCard(
                modifier = itemModifier,
                movie = movie,
                onClick = {
                    lazyRow.saveFocusedChild()
                    onItemSelected(movie)
                    navController.navigate(
                        DetailScreenRoute(
                            name = movie.Title,
                            image = movie.Images[0],
                        )
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true, device = Devices.TV_1080p)
@Composable
fun Preview() {
    HomeScreen(navController = rememberNavController())
}