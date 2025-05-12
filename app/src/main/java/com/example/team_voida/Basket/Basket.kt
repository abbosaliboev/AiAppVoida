package com.example.team_voida.Basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.ui.theme.BasketPaymentColor
import com.example.team_voida.ui.theme.Selected
import com.example.team_voida.ui.theme.TextColor
import com.example.team_voida.ui.theme.TextLittleDark

@Composable
fun Basket(){
    val scrollState = rememberScrollState()
    val cartNum = remember { mutableStateOf(0)}


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)

    ){
        Notification("장바구니 화면입니다. 아래에 장바구니에 담긴 상품을 확인하고, 오른쪽 하단의 결제하기 버튼으로 상품을 구매하세요.")
        BasketCartNum(cartNum)
        Spacer(Modifier.height(15.dp))
        BasketItemArrange(basketSample)
    }
    BasketPaymentButton(
        price = "120,000 원"
    )
}

@Composable
fun BasketCartNum(
    cartNum: MutableState<Int>
){
    Row (
        modifier = Modifier
            .semantics(mergeDescendants = true){
                text = AnnotatedString("현재 장바구니에는 ${cartNum.value} 개의 상품이 담겨 있습니다.")
            }
            .fillMaxWidth()
            .padding(20.dp),

    ) {
        Text(
            modifier = Modifier,

            textAlign = TextAlign.Center,
            text = "Cart",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Spacer(Modifier.width(7.dp))
        Text(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(
                    color = Selected
                )
                .width(30.dp)
                .height(30.dp)
                .offset(
                    y = 5.dp
                )
            ,
            textAlign = TextAlign.Center,
            text = cartNum.value.toString(),
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
    }
}

@Composable
fun BasketItem(
    img: String,
    name: String,
    option: String,
    num: Int,
    price: String
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
    ){
        Image(
            painter = rememberAsyncImagePainter(img),
            contentDescription = "",
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .border(
                    width = 4.dp,
                    shape = RoundedCornerShape(14.dp),
                    color = Color.White
                )
                .shadow(elevation = 15.dp, shape = RoundedCornerShape(15.dp))
        )

        Column (
            modifier = Modifier
                .padding(
                    start = 10.dp
                )
                .fillMaxHeight()
        ){
            Row (
                modifier = Modifier
            ){

                // product name
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(9f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text = name,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        fontSize = 16.sp
                    ),
                )

                // del button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.5f)
                        .height(32.dp)

                    ,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonColors(
                        contentColor = Color.Transparent,
                        containerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(R.drawable.basket_del),
                        contentDescription = "",
                        modifier = Modifier
//                            .width(30.dp)
//                            .height(30.dp)
                    )
                }
                Spacer(Modifier.width(10.dp))
            }

            Spacer(Modifier.height(20.dp))

            // price row
            Row (
                modifier = Modifier
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(9f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text =
                        if(option == "null"){
                            "옵션 없음"
                        } else {
                            option
                        }
                    ,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                        fontSize = 16.sp
                    ),
                )
            }
            Spacer(Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(
                        end = 10.dp
                    )
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(9f)
                        .offset(
                            y = 5.dp
                        ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text = price,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 18.sp
                    ),
                )
                Row (
                    modifier = Modifier
                ){
                    Button(
                        modifier = Modifier
                            .size(30.dp),
                        onClick = {},
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Image(
                            painter = painterResource( R.drawable.basket_sub),
                            contentDescription = ""
                        )
                    }
                    Spacer(Modifier.width(5.dp))
                    Text(
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(5.dp)
                            )
                            .background(
                                color = Selected
                            )
                            .width(30.dp)
                            .height(30.dp)
                            .offset(
                                y = 5.dp
                            ),
                        text = num.toString(),
                        color = TextLittleDark,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                            fontSize = 16.sp
                        ),
                    )
                    Spacer(Modifier.width(5.dp))
                    Button(
                        modifier = Modifier
                            .size(30.dp),
                        onClick = {},
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Image(
                            painter = painterResource( R.drawable.basket_add),
                            contentDescription = ""
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun BasketItemArrange(
    basketItems: List<BasketProduct>
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ){
        basketItems.forEachIndexed { index, item ->
            BasketItem(
                img = item.img,
                name = item.name,
                option = item.option,
                num = item.num,
                price = item.price
            )
        }
    }
}

@Composable
fun BasketPaymentButton(
    price: String
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = BasketPaymentColor
            )
    ){
        Text(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(5.dp)
                )
                .height(30.dp)
                ,
            text = price,
            color = TextLittleDark,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                fontSize = 16.sp
            ),
        )
    }
}