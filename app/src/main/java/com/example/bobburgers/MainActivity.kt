package com.example.bobburgers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.model.mapper.RelativeMapper
import com.example.bobburgers.model.mapper.character.CharacterMapper
import com.example.bobburgers.model.remote.BobRepo
import com.example.bobburgers.model.remote.RetrofitClass
import com.example.bobburgers.ui.theme.BobBurgersTheme
import com.example.bobburgers.view.homescreen.CharCard2
import com.example.bobburgers.view.homescreen.HomeScreen
import com.example.bobburgers.view.homescreen.HomeScreenState
import com.example.bobburgers.viewmodel.BobViewModel

//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            BobBurgersTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}



class MainActivity : ComponentActivity() {

    private val bobViewModel by viewModels<BobViewModel> {
        val service = RetrofitClass.getApiService()
        val mapper = CharacterMapper(RelativeMapper())
        val repo = BobRepo(service, mapper)
        BobViewModel.VMlFactory(repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println(list)
        println("HERE")
        setContent {
            val result = bobViewModel.getCharacters()
            val homeState by bobViewModel.homeState.collectAsState()
            println("HOMESCREEN STATE : $homeState")
            println(result)


            BobBurgersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(homeState)
                }
            }
        }
    }
}

@Composable
fun Navigation(homeState:HomeScreenState) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen") {
        composable("characters/{id}") {
            val id = it.arguments?.getString("id")
            id?.let { it1 -> CharCard(id = it1, navigate = {}, character = homeState.characters.get((it1.toInt()))) }
            if (id != null) {
                CharCard(id = id, navigate = {navController.navigate("home_screen")},
                    character = homeState.characters[(id.toInt()+1)])

            }
        }
        composable("home_screen") {
            BobBurgersApp(homeState, navController)
        }
    }
}
@Composable
fun BobBurgersApp(characters: HomeScreenState, navController: NavController){
    HomeScreen(characters, navController = navController)
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BobBurgersTheme {
        Greeting("Android")
    }
}



@Composable
fun CharCard( id:String, navigate: ()->Unit, character: Bobcharacter) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp))
    {
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
                Text(text = "Job: ${character.occupation}")
                Text(text = "pronoun: ${character.gender}")
                Text(text = "First Appeared in: ${character.firstEpisode}")
                Button(onClick = { navigate()}) {
                    Text(text = "Home")

                }
            }
        }
    }
}
