package com.example.team_voida.Start

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.ui.theme.TextLittleDark

@Composable
fun Guide(
    navController: NavController
){
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("1","2","3","4")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Notification("앱 사용 안내 페이지입니다. 중앙부 화면에서 어플리케이션 사용방법을 안내 받을 수 있습니다. 오른쪽 스와이프 제스쳐를 통해 다음 안내 메시지를 제공 받을 수 있습니다.")
        Spacer(Modifier.height(15.dp))
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title->
                Tab(
                    selected = tabIndex == index,
                    onClick = {}
                ) {

                }
            }

        }
        when(tabIndex){
            0 -> Guide1()
        }
    }
}


@Composable
fun Guide1(
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Box(){
            Image(

                painter = painterResource(R.drawable.guide1),
                contentDescription = ""
            )
            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .offset(
                        x = 45.dp,
                        y = 430.dp
                    )
                    .width(300.dp)
            ){
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "안녕하세요 Vodia 쇼핑입니다.",
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    )
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "본 어플리케이션은 시각 장애인을 위한 쇼핑앱으로, 스크린 리더기를 보다 편리하게 사용할 수 있게 디자인 되었습니다. 화면을 우측으로 스와이프 하여 보다 다양한 기능을 만나보세요.",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 25.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )
                Spacer(Modifier.height(35.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "우측으로 스와이프 →",
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )
            }
        }
    }
}








