package com.example.bobburgers.view.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun HomeScreen(
    homeScreenState: HomeScreenState,
    navController: NavController
) {
    LazyColumn(modifier = Modifier.padding(5.dp)) {
        items(items = homeScreenState.characters, key = { chars -> chars.id }) { char ->
            CharCard2(character = char, navigate = { navController.navigate("characters/${char.id}") })
        }
    }
}

@Composable
fun CharCard2(character: com.example.bobburgers.model.entity.Bobcharacter, navigate: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navigate()
                println("Card has been CLICKED")
            }
            .padding(5.dp)
    ) {
        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 10.dp
                )
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(145.dp)
            )
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Text(text = character.name)
                Text(text = "First appeared in: ${character.firstEpisode}")
                Text(text = "Job ${character.occupation}")
                Text(text = "Gender ${character.gender}")
            }
        }
    }
}

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
