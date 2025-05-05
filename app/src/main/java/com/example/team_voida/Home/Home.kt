package com.example.team_voida.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.SearchBar
import com.example.team_voida.ui.theme.TextLittleDark

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