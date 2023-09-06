package com.compose.testApp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.testApp.ui.theme.MyTestAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    createBizCard()
                }
            }
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun createBizCard(){
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp)
            .shadow(ambientColor = Color.Blue, elevation = 6.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
         ) {
            Column (modifier = Modifier
                .width(500.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                createImageProfile()
            }
            Divider(thickness = 1.dp)
            createInfo()
            portfolioButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun content(){
    Box (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){

        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }

    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){item ->
            Card(modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
                shape = RectangleShape) {
                Row (modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)){
                    createImageProfile(modifier = Modifier.size(100.dp))
                    Column (modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)){
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A greate project", style = MaterialTheme.typography.bodyMedium)

                    }
                }
                }

            }

        }
    }


@Composable
private fun portfolioButton() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Button(
        onClick = {
            buttonClickState.value = !buttonClickState.value
            Log.d("Clicked", "createBizCard: Click")
        },
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )

    ) {

        Text(
            text = "Portfolio" )
    }
    if(buttonClickState.value){
        content()
    }else{
        Box {

        }
    }
}

@Composable
private fun createInfo() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Miles P.", style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )


        Text(
            text = "Android Compose Prog.",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "@theMile compose", modifier = Modifier.padding(3.dp),
            color = MaterialTheme.colorScheme.primary
        )

    }
}

@Composable
private fun createImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = Color.Black
    ) {
        Image(
            painterResource(R.drawable.profileimage), "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    MyTestAppComposeTheme {
        Greeting("Android")
    }
}