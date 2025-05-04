package com.example.team_voida.Start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.team_voida.R
import com.example.team_voida.ui.theme.ButtonBlue
import com.example.team_voida.ui.theme.TextColor
import com.example.team_voida.ui.theme.TextLittleDark
import com.example.team_voida.ui.theme.TextWhite

@Composable
fun Start(
    navController: NavController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.height(150.dp))
        Image(
            modifier = Modifier
                .size(150.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = "Voida 로고, 아래의 시작하기 버튼을 눌러주세요."
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Voida Shop",
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = TextColor,
                fontSize = 55.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )
        )
        Spacer(Modifier.height(30.dp))
        Text(
            modifier = Modifier.width(300.dp),
            lineHeight = 25.sp,
            text = "시각 장애인을 위한 스크린 리더기 쇼핑앱입니다. 아래의 '계정 생성하기' 버튼을 눌러 회원가입을 진행해주세요. 이미 계정이 있으시다면, 최하단의 버튼을 클릭해 로그인 해주세요!",
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = TextColor,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            )
        )
        Spacer(Modifier.height(140.dp))
        Button(
            shape = RectangleShape,
            modifier = Modifier
                .width(300.dp)
                .height(65.dp)
                .clip(shape = RoundedCornerShape(15.dp)),
            onClick = {
                navController.navigate("createAccount")
            },
            colors = ButtonColors(
                containerColor = ButtonBlue,
                contentColor = TextWhite,
                disabledContentColor = TextWhite,
                disabledContainerColor = ButtonBlue
            )
        ) {
            Text(
                text = "계정 생성하기",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = TextWhite,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular))
                )
            )
        }
        Spacer(Modifier.height(15.dp))
        Row (
            modifier = Modifier
                .clickable {
                    navController.navigate("login")
                }
        ){
            Text(
                modifier = Modifier
                    .width(200.dp),
                text = "이미 계정이 있으신가요?\n로그인하여 쇼핑몰에 접속하세요!",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = TextLittleDark,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular))
                )
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                painter = painterResource(R.drawable.arrow_button),
                contentDescription = "로그인 하러가기 버튼",
                tint = Color.Unspecified
            )
        }
    }
}