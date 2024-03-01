package com.personal.animeshpandey.animefacts.View

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.personal.animeshpandey.animefacts.ViewModel.MainViewModel
import com.personal.animeshpandey.animefacts.R

@Composable
fun finalscreen() {
    val quoteviewmodel: MainViewModel = viewModel()
    Box{
        Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.background_anime), contentDescription = null, contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.6f), shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            quotescreen(quoteviewmodel)
            Button(onClick = { quoteviewmodel.fetchQuotes() }, colors = ButtonDefaults.buttonColors(
                Color.Red)) {
                Text("Refresh Quote")
            }
        }
    }

}

@Composable
fun quotescreen(quoteviewmodel: MainViewModel) {

    val viewstate by quoteviewmodel.publicquotestate

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Text(text = viewstate.recieved_quote.quote, fontSize = 32.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "-"+viewstate.recieved_quote.character+" ("+viewstate.recieved_quote.anime+")", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun tester(){
    finalscreen()
}
