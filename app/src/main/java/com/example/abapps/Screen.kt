package com.example.abapps

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun card(){
    Scaffold (
        topBar = {
            TopAppBar({ Text(text = stringResource(id = R.string.app_name)) },Modifier.height(30.dp)) }){
LazyColumn(modifier = Modifier.fillMaxWidth(),contentPadding = PaddingValues(16.dp)){
    items(100){item->
        myCard()

    }
}
    }
}
@Composable
fun myCard(){
    var numOfLike = remember { mutableStateOf(0) }
    var numOfFav = remember { mutableStateOf(0) }
    var numOfShare = remember { mutableStateOf(0)}
    Card (
        Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(8.dp), shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row (horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.padding(15.dp)){
                Image(painter = painterResource(id = R.drawable.konan), contentDescription = "backgroundImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp,
                            Color.Gray, CircleShape
                        ))

                Column (modifier = Modifier.padding(10.dp,12.dp,0.dp,0.dp)){
                    Text(text = "Eman Magdy", style = TextStyle(fontSize =15.sp, fontFamily = FontFamily.Serif))
                    Text(text = "@aymanmjdyabwjbl", style = TextStyle(fontSize =10.sp, fontFamily = FontFamily.Default))
                }
                Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color.White), border = BorderStroke(2.dp,
                    Color(0xEE85CEF0)
                ), shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .height(55.dp)
                        .padding(10.dp, 10.dp, 0.dp, 10.dp)
                        .width(100.dp)
                ) {
                    Text(text = " hello ", color = Color(0xEE85CEF0))
                }

            }
            Image(painter = painterResource(id = R.drawable.konan2), contentDescription ="contentDes",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(50.dp)))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(10.dp)){
                Image(painter = painterResource(id = R.drawable.konan), contentDescription ="contentDes",
                    modifier = Modifier
                        .height(75.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp)))

                Image(painter = painterResource(id = R.drawable.konan), contentDescription ="contentDes",
                    modifier = Modifier
                        .height(75.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp)))

                Image(painter = painterResource(id = R.drawable.konan), contentDescription ="contentDes",
                    modifier = Modifier
                        .height(75.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp)))
            }
         Text(
             text = " loren iosum dolor sit amet ,consetetur ",
             Modifier.padding(10.dp, 8.dp, 10.dp, 8.dp),
             style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Serif)
         )
         Row(Modifier.padding(8.dp),horizontalArrangement = Arrangement.spacedBy(20.dp)){
             Text(text = "10/11/2020", color = Color.Red)
             Image(modifier = Modifier.clickable {numOfShare.value++}, imageVector = Icons.Default.Share, contentDescription = "any")
             Text(text = numOfShare.value.toString())
             Image(modifier = Modifier.clickable {numOfFav.value++}, imageVector = Icons.Default.Favorite, contentDescription = "any")
             Text(text = numOfFav.value.toString())
             Image(modifier = Modifier.clickable {numOfLike.value++}, imageVector = Icons.Default.ThumbUp, contentDescription = "any")
             Text(text = numOfLike.value.toString())
         }
            
        }


    }
}