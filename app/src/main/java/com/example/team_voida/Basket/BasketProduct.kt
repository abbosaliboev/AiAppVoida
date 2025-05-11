package com.example.team_voida.Basket

data class BasketProduct(
    val img: String,
    val name: String,
    val option: String,
    var num: Int,
    val price: String
)

val basketSample = BasketProduct(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/b5afa0d9-0d39-424a-b4aa-df14e290244e.jpg",
    name = "[Kurly's] 동물복지 백색 유정란 20구",
    option = "null",
    price = "9,180원",
    num = 2
)