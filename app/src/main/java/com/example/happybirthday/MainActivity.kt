package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                    // GreetingText(message = "Happy Birthday Allan", from = "from Emma!!!!")
                    // GreetingImage(message = "Happy Birthday Allan", from = "from Emma!!!!")
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String, from: String) {

    // Column, Row, and Box are composable functions that take composable 'content' as arguments
    // But.....it's very cumbersome (complicate) to use named parameter for the trailing lambda!!
//    Column (modifier = modifier,
//            content = {
//                Text(text = message, fontSize = 100.sp, lineHeight = 116.sp)
//                Text(text = from, fontSize = 36.sp)
//            })

    // Because the 'content' parameter is the LAST one in the function signature
    // and you pass its value as a lambda expression,
    // you can REMOVE the 'content' parameter:
    Column (modifier = modifier,
            verticalArrangement = Arrangement.Center
    ){
        Text(text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    // Jetpack Compose can access the resources defined in your Android project.
    // Resources can be accessed with resource IDs that are generated in your project's R class.
    val imageParty = painterResource(R.drawable.androidparty)
                        // R --> auto generated R class
                        // drawable --> subdirectory in res folder
                        // androidparty --> resource id (mostly same as filename)

    // Use Box layout to stack elements on top of one another.
    Box {
        Image(painter = imageParty,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F // changing opacity
        )
        GreetingText(message = message,
                    from = from,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
        )
    }

}



// The code you added to the BirthdayCardPreview() function with the @Preview annotation
// is only for previewing in the Design pane in Android Studio.
// These changes aren't reflected in the app!!!
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        // Composable functions can call other composable functions!
        // GreetingText(message = "Happy Birthday Allan", from = "from Emma!!!!")
        GreetingImage(message = "Happy Birthday Allan", from = "from Emma!")
    }
}