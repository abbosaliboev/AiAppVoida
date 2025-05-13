package com.example.team_voida.Categories

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.team_voida.Basket.ComposableLifecycle
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.ui.theme.TextLittleDark


//1. 식품
//2. 술
//3. 생활
//4. 스포츠,레저,캠핑
//5. 반려동물
//6. 뷰티
//7. 패션

@Composable
fun Categories(
    navController: NavController,
    homeNavFlag: MutableState<Boolean>
){
    ComposableLifecycle { source, event ->
        if (event == Lifecycle.Event.ON_PAUSE) {
            Log.e("123","on_pause")
        } else if(event == Lifecycle.Event.ON_STOP){
            homeNavFlag.value = true
            Log.e("123","on_stop")
        } else if(event == Lifecycle.Event.ON_DESTROY){
            Log.e("123","on_destroy")
        } else if(event == Lifecycle.Event.ON_CREATE){
            Log.e("123","on_create")
        } else if(event == Lifecycle.Event.ON_START){
            Log.e("123","on_start")
            homeNavFlag.value = false
        } else if(event == Lifecycle.Event.ON_RESUME){
            Log.e("123","on_resume")
            homeNavFlag.value = false
        }
    }

    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)

    ){
        Notification("카테고리 페이지입니다. 아래에 목록에서 원하는 상품 목록을 선택해주세요.")
        CategoryColumn(cateList)
    }
}

@Composable
fun CategoryTitle(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 23.dp
                ),
            textAlign = TextAlign.Center,
            text = "All Categories",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
            )
        )
    }
}


@Composable
fun CategoryColumn(
    categoryList: List<CategoryItem>
){
    Column(
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp
            )
    ){
        categoryList.forEachIndexed { index, item ->
            CategoryRow(item)
            Spacer(Modifier.height(10.dp))
        }
        Spacer(Modifier.height(20.dp))
    }
}
@Composable
fun CategoryRow(
    categoryItem: CategoryItem
){
    Button (
        contentPadding = PaddingValues(0.dp),
        colors = ButtonColors(
            contentColor = Color.Transparent,
            containerColor = Color.White,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.White
        ),
        onClick = {},
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .shadow(
                elevation = 10.dp
            )

    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(9f)
            ){
                Image(
                    modifier = Modifier
                        .size(
                            width = 70.dp,
                            height = 70.dp
                        )
                        .padding(
                            top = 5.dp,
                            bottom = 5.dp
                        )
                    ,
                    painter = rememberAsyncImagePainter(categoryItem.img),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            top = 23.dp
                        ),
                    textAlign = TextAlign.Center,
                    text = categoryItem.name,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )

            }
            Image(
                modifier = Modifier
                    .padding(
                        top = 30.dp,
                        end = 15.dp
                    )
                    .fillMaxSize()
                    .weight(1f)
                    .size(8.dp)
                    ,
                painter = painterResource(R.drawable.basket_down),
                contentDescription = "",
            )
        }

    }
}