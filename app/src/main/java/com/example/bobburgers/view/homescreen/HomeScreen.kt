package com.example.bobburgers.view.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bobburgers.CharCard

@Composable
fun HomeScreen(
    characters: List<com.example.bobburgers.model.entity.Character>,
    cardClicked: (com.example.bobburgers.model.entity.Character) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(5.dp)) {
        items(items = characters, key = { chars -> chars.id }) { char ->
            CharCard(character = char)
        }
    }
}


@Composable
fun CharCard2(character: com.example.bobburgers.model.entity.Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
