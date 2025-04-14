package com.example.team_voida.CreateAccount

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R

@Composable
fun CreateAccount(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Notification(
            text = "계정생성 페이지입니다. 아래에 차례로 이메일, 비밀번호, 비밀번호 재입력, 전화번호를 입력 후, 하단의 '계정생성' 버튼을 눌러주세요."
        )
        Spacer(Modifier.height(25.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            text = "Create\nAccount",
            style = TextStyle(
                fontSize = 55.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
            )
        )

    }
}

// Todo
@Composable
fun CreateAccountTextField(){
    BasicTextField(
        // 필터 입력 후 Action에 대해 정의
        keyboardActions = KeyboardActions(
            // 예시)
            // 백엔드로 필터링 된 데이터 요청 함수
            // callFilter2Backend(input)

            // 선택된 페이지에 관한 데이터는 이 함수의 input 변수를 활용
            onDone = {
                Log.e("debug","working")

                // 유저의 입력값이 정수인 경우
                // 추가적으로 제공하는 데이터베이스보다 작은 값의 데이터를 요구하게 제한해야함(나중에)
                if(input.value.toIntOrNull() != null){
                    currentPage.value = input.value.toString()
                    dbTableSample.value = dbTableSample6

                }
            }
        ),
        value = if(isChanged == true && !isInputChanged.value){
            currentPage.value
        } else {
            input.value
        },
        onValueChange = {
            isInputChanged.value = true
            input.value = it
        },
        modifier = Modifier

            .clip(shape = RoundedCornerShape(15.dp,15.dp,15.dp,15.dp))

            .background(
                color = Color(216,224,227)
            )
            .width((43 + input.value.length*2).dp)
            .height(45.dp)

        ,
        singleLine = true,
        textStyle = TextStyle(
            color = TextColor,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 14.sp
        ),

        decorationBox = @Composable{ innerTextField ->
            TextFieldDefaults.DecorationBox(
                placeholder = {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "",
                        color = Color.LightGray,
                        style = TextStyle(
                            color = TitleColor,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontSize = 14.sp
                        ),
                    )
                },
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                enabled = true,
                innerTextField = innerTextField,
                value = input.value.toString(),
                interactionSource = interactionSource,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = TextColor,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                )
            )
        }
    )
}