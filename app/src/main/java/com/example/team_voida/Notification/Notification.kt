package com.example.team_voida.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.team_voida.R
import com.example.team_voida.ui.theme.NotifyBlock

// 모든 페이지에 설정되는 상단 알림바 모듈화 컴포저블
@Composable
fun Notification(
    text: String
){
    Text(
        modifier = Modifier
            .padding(
                start = 10.dp,
                top = 30.dp,
                end = 10.dp,
                bottom = 10.dp
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = NotifyBlock)
            .padding(15.dp)
        ,
        text = text,
        color = Color.Black,
        style = TextStyle(
            color = Color.Black,
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_light))
        )
    )
}