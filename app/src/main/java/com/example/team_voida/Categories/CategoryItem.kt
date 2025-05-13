package com.example.team_voida.Categories

data class CategoryItem(
    val img: String,
    val name: String,
    val subCategories: List<String>?
)

val cateFood = CategoryItem(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/4436fdec-039d-4683-b8f3-7ebf677ad190.jpg",
    name = "식품",
    subCategories = listOf("채소","과일·견과·쌀","수산·해산·건어물","정육·가공육·달걀","국·반찬·메인요리","간편식·밀키트·샐러드","면·양념·오일","건강식품")
)

val cateBeverage = CategoryItem(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/product/image/9cf5780e-81bc-46e0-bb3b-eed18a010194.jpg",
    name = "음료",
    subCategories = listOf("생수·음료","커피·차",)
)

val cateDesert = CategoryItem(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/product/image/5ab8a1a7-2370-44c9-aa40-8630f3967cb6.jpg",
    name = "간식",
    subCategories = listOf("간식·과자·떡","베이커리","유제품")
)

val cateAlcohol = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/546b466a-018d-46a2-9f7f-6814af156774/fd8ece17-ada3-4e41-b41b-8b22edbd2ecd.jpg",
    name = "술",
    subCategories = listOf("와인·위스키·데낄라","전통주")
)

val cateLife = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/9582c48a-da2d-4544-8885-65ddd6c10b78/26afaeb2-fe05-4656-a79c-4a8855c7a1b3.jpghttps://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/9582c48a-da2d-4544-8885-65ddd6c10b78/26afaeb2-fe05-4656-a79c-4a8855c7a1b3.jpg",
    name = "생활",
    subCategories = listOf("주방용품","생활용품","가전제품","가구·인테리어")
)

val cateBaby = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/680f5743-c8d8-40c9-a5d8-39ef3fe264f2/2bc10101-089e-4d37-9abe-29868341bda0.jpg",
    name = "유아동",
    subCategories = null
)

val cateSports = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/20250213/0dc42c26-aa4e-454f-acae-8800b173dba4.jpg",
    name = "스포츠·레저·캠핑",
    subCategories = null
)

val catePet = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/97805680-a6cc-437d-837f-4f7c39ef68fd/d89f3b43-e597-408c-8aea-efcdfdfffc43.jpg",
    name = "반려동물",
    subCategories = null
)

val cateBeauty = CategoryItem(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/product/image/0b82c777-fb7b-4b23-820b-0961326aea11.jpg",
    name = "뷰티",
    subCategories = listOf("럭셔리 뷰티","스킨케어·메이크업","헤어·바디·구강")
)

val cateFashion = CategoryItem(
    img = "https://3p-image.kurly.com/hdims/resize/%5E%3E360x%3E468/cropcenter/360x468/quality/85/src/files/c7fa465a-27e6-4fd9-ac32-ae7ba5324f74/f51491d9-c839-473a-bf58-bf3642e7e06a.jpg",
    name = "패션",
    subCategories = null
)

val cateList = listOf(cateFood, cateBeverage, cateDesert, cateAlcohol, cateLife, cateBaby, cateSports, catePet, cateBeauty, cateFashion)