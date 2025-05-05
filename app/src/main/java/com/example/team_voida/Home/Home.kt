package com.example.team_voida.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.SearchBar
import com.example.team_voida.ui.theme.TextLittleDark
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

@Composable
fun Home(
    navController: NavController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Notification("홈 화면입니다. 실시간 인기 상품과 특가 상품을 만나볼 수 있습니다. 화면을 아래로 스크롤하여 다양한 이벤트 상품을 만나보세요!")
        HomeSearchBar(navController)
        HomePopularRanking(navController)
        HomeProducts()
    }
}

@Composable
fun HomeSearchBar(
    navController: NavController
){
    val resultInput = remember { mutableStateOf("") }
    Row(
        modifier = Modifier

    ){
        Text(
            modifier = Modifier
                .offset(
                    x = 15.dp,
                    y = 5.dp
                ),
            textAlign = TextAlign.Center,
            text = "Shop",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 35.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Spacer(Modifier.width(7.dp))
        SearchBar(
            navController = navController,
            resultInput = resultInput
        )
    }
}

@Composable
fun HomePopularRanking(
    navController: NavController
){
    Column {
        HomeBar(
            navController = navController,
            title = "실시간 인기"
        )
    }
}


// Home Bar which represented repeatedly
@Composable
fun HomeBar(
    navController: NavController,
    title: String
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier,
//                    .offset(
//                        x = 15.dp,
//                        y = 5.dp
//                    ),
            textAlign = TextAlign.Center,
            text = title,
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Row (
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .clickable {
                    navController.navigate("")
                }
        ){
            Text(
                modifier = Modifier
                    .offset(
                        x = -10.dp,
                        y = 5.dp
                    ),

                textAlign = TextAlign.Center,
                text = "모두 보기",
                color = TextLittleDark,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                )
            )
            Icon(
                painter = painterResource(R.drawable.arrow_button),
                contentDescription = "모두 보기 버튼",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun HomeProducts(){

    var result: List<Popular>? = null

    runBlocking {
        val job = GlobalScope.launch {
            result = HomePopularCall()
        }
    }

    Thread.sleep(5000L)

    // debug
//    if(result != null){
//        Text(
//            text = result.toString()
//        )
//    }
    if(result != null){
        val tmpResult = result!![0]
        HomeCard(
            img = tmpResult.img,
            rank = tmpResult.rank,
            name = tmpResult.name,
            price = tmpResult.price,
            discount = tmpResult.discount
        )
//        result!!.forEachIndexed { index, popular ->
//
//        }
    }
}

@Composable
fun HomeCard(
    img: String,
    rank: String,
    name: String,
    price: String,
    discount: String
){
    Box(
        modifier = Modifier
            .shadow(elevation = 10.dp)
    ){
        Image(
            painter = painterResource(R.drawable.home_rec),
            contentDescription = "",
        )
        Image(
            modifier = Modifier
                .offset(
                    y = 8.dp
                )
                .clip(RoundedCornerShape(10.dp))
                .width(300.dp)
                .height(300.dp)
            ,
            painter = rememberAsyncImagePainter(img),
            contentDescription = name + "상품 이미지",
        )
        Text(
            modifier = Modifier
                .offset(
                    y = 45.dp
                ),
            textAlign = TextAlign.Center,
            text = name,
            color = Color.Black,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            )
        )
        Text(
            modifier = Modifier
                .offset(
                    y = 65.dp
                ),
            textAlign = TextAlign.Center,
            text = price,
            color = Color.Black,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
    }
}

