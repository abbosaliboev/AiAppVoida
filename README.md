
# Inclusive Shopping App for the Visually Impaired (English/Korean)

<img src = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Jira_Logo.svg/2560px-Jira_Logo.svg.png" width = "120" heigth = "30">
5월 22일 이후의 모든 문서 및 협업 관리는 <b>'Jira'</b>를 통해 이루어집니다.<br>
Jira 계정이 없거나, Jira 팀 멤버로 초대받지 못한 경우 아래 사이트에 접속이 불가합니다.<br>
Vodia의 Jira 사이트 접근을 원하시면 Jira 구글 계정을 만드신 후, <br>해당 계정의 이메일 주소를 rlaxodud7737@naver.com으로 보내주시길 바랍니다.<br>
Vodia_Jira : https://hoogdle.atlassian.net/jira/software/projects/SCRUM/list<br>

## Youtube Video

https://youtu.be/hl-KizmJ2p4?si=1UIRuFi_2NkYQvY8

## 📱 Overview

This project aims to develop an Android shopping application tailored specifically for **visually impaired users**. Unlike most shopping apps that are designed for non-disabled individuals, our application integrates features and design elements that enhance accessibility through a simplified and screen reader–friendly interface.

## 🎯 Key Features

- **Custom UI/UX** for visually impaired users
  - Clean, minimal design optimized for screen readers
  - Logical component placement for intuitive navigation

- **Voice Notification Popup**
  - Inform users of the current page context with a top-aligned popup

- **Zoom Functionality**
  - Supports low-vision users with screen magnification options

- **Voice Search**
  - Easily find products using voice commands

- **Information Summarization**
  - Summarizes essential product details while removing ads and irrelevant content

- **High Contrast Theme**
  - Enhances readability with distinct, contrasting colors

- **AI-Powered Product Description (VLM)**
  - Utilizes Vision-Language Models (e.g. Qwen2.5-VL, CogVLM) to convert product images into readable text for screen readers

## 🛠 Tech Stack

- **Frontend**: Kotlin (Android)
  - UI library: Jetpack Compose
- **Backend**: Django (Python)
  - REST API development
  - User management, product data, AI-based summarization
- **AI Integration**:
  - Vision-Language Models (VLM)
  - OCR if required for enhancement

## 🧪 Future Work

- Fine-tune existing VLMs or integrate advanced OCR techniques
- Expand multi-language support
- Optimize performance for slower devices

## 📋 Scrum & Documentation

- 📊 [Scrum Sheet](https://docs.google.com/spreadsheets/d/19OcmqpZHZYK2h3bqwkBScsr7RUosSOpt8s8sTrfmmuk/edit?usp=sharing)
- 📂 Additional documents and Scrum meeting logs can be found in the `documentation` branch of this repository.

## 📄 License

This project is licensed under the MIT License.  
You are free to use, modify, and distribute this software for personal or commercial purposes, as long as the original license and copyright notice are included.

See the [LICENSE](./LICENSE) file for more details.


## 👨‍💻 Team Members

| Name                    | Department            | Role       | Contact                      |
|-------------------------|------------------------|------------|------------------------------|
| Jiang Haozheng         | Software Engineering   | Backend  | jhz190402522@gmail.com       |
| Abbos Aliboev           | Software Engineering   | UI/UX, Frontend | ali@chungbuk.ac.kr           |
| Namsraijalbuu Bilguun   | Software Engineering   | Backend | bekunee0@gmail.com           |
| Kim Taeyoung            | Software Engineering   | Team Leader, Frontend| rlaxodud7737@naver.com       |


# 🛍️ Voida Shop – Accessibility-Focused UI/UX Design

This repository contains the UI/UX design of **Voida Shop**, a mobile shopping application tailored for **visually impaired users**.  
Our goal is to create a clean, accessible, and user-friendly interface that enables everyone to easily interact with online shopping platforms.

**Branch:** `hw_aliboev`  
**Tool:** Figma  
**Focus:** Accessibility, Minimalism, Inclusivity

---

![Login Page](PNG/Login.png)

Mana siz yuborgan eski README bo‘yicha **yangilangan versiyasi** — hozirgi holatga moslab yozilgan. Unda barcha tugagan sahifalar ko‘rsatilgan, faqat **delivery** va **history** sahifalari qolgan, shuningdek yangi sahifalarning skrinshotlari ham qo‘shilgan:

---

# 🛍️ Visually Impaired Shopping App

---

## ✅ Completed Pages

- **Login Page**
- **Create Account Page**   
  ![Login Page](PNG/Login.png)


- **Profile Page**  
  ![Profile Page](PNG/profile.png)


- **Shop Page**  
  ![Shop Page](PNG/shop.png)


- **Search Page**
- **Search Results Page**
- **Filter Page**  
  ![Search Page](PNG/search.png)


- **Product Page**
- **Product Sale Page** 
  ![Product Page](PNG/products.png)
  <br/>


- **Cart Page**
- **Add to Cart Options Page (Color & Size)**  
- **Payment Page**  
  ![Cart Page](PNG/cart.png)
  ![Payment Page](PNG/payment.png)


- **Reviews Page**  
  ![Reviews Page](PNG/review.png)


---

## 🚧 In Progress

- **Delivery Page**
- **Order History Page**

---

## 📌 Notes

- Most core pages are completed and functional.
- Accessibility features (e.g. screen reader-friendly texts) are integrated in every page.
- Only **Delivery** and **Order History** pages are left to implement.
- Feedback and contributions are always welcome!

---


## 👤 Author

**Abbos Aliboev**  
Computer Science student Chungbuk National University  
Focusing on accessible technology and inclusive design

---

## 🔗 Our Figma Design Link

[Figma Design – Accessibility Login Page](https://www.figma.com/design/Ie71gRLhdyWucS0VDOREHh/Voida----Online-Store-UI-Mobile-App-Design?m=auto&t=eldecDiM1ZFkUBGd-6)

---


## 🚀 Getting Started

### Prerequisites

- Android Studio
- Python 3.9+
- Django 4.x
- Git


# 시각 장애인을 위한 온라인 쇼핑 애플리케이션

## 📱 개요

본 프로젝트는 **시각 장애인**을 위해 특별히 설계된 안드로이드 쇼핑 애플리케이션을 개발하는 것을 목표로 합니다. 기존 쇼핑 앱들은 비장애인을 중심으로 디자인되어 있어 시각 장애인에게는 접근성이 떨어집니다. 이에 따라 본 앱은 간결하고 스크린 리더에 최적화된 사용자 인터페이스와 기능들을 제공합니다.

## 🎯 주요 기능

- **시각 장애인 맞춤 UI/UX**
  - 복잡하지 않고 깔끔한 디자인
  - 스크린 리더에 최적화된 컴포넌트 배치

- **상단 알림 팝업**
  - 현재 페이지 정보를 상단 고정 팝업으로 음성 안내

- **화면 확대 기능**
  - 저시력 사용자를 위한 확대 기능 제공

- **음성 검색 기능**
  - 음성으로 상품을 검색할 수 있는 기능

- **정보 요약 기능**
  - 광고 및 불필요한 정보 제거 후 핵심 정보만 제공

- **고대비 테마**
  - 명확한 시인성을 위한 고대비 색상 제공

- **AI 기반 이미지 설명 기능 (VLM)**
  - 상품 이미지를 Vision-Language Model (예: Qwen2.5-VL, CogVLM)을 통해 텍스트로 변환하여 스크린 리더가 읽을 수 있도록 지원

## 🛠 기술 스택

- **프론트엔드**: Kotlin (Android)
  - UI 프레임워크: Jetpack Compose
- **백엔드**: Django (Python)
  - REST API 개발
  - 사용자, 상품, 요약 정보 관리
- **AI 연동**:
  - Vision-Language Model (VLM)
  - 필요시 OCR 기술 보완

## 🧪 향후 개발 방향

- VLM 성능 개선 및 OCR 기술 추가
- 다국어 지원 확장
- 저사양 기기 최적화

## 📋 스크럼 및 문서

- 📊 [스크럼 시트 바로가기](https://docs.google.com/spreadsheets/d/19OcmqpZHZYK2h3bqwkBScsr7RUosSOpt8s8sTrfmmuk/edit?usp=sharing)
- 📂 스크럼 회의록 및 기타 문서는 `documentation` 브랜치에서 확인하실 수 있습니다.

## 📄 라이선스

이 프로젝트는 MIT 라이선스로 배포됩니다.  
원 저작권 및 라이선스 고지를 포함하는 한, 개인 또는 상업적 목적으로 자유롭게 사용, 수정, 배포할 수 있습니다.

자세한 내용은 [LICENSE](./LICENSE) 파일을 참고해주세요.

## 👨‍💻 팀원 소개

| 이름                     | 소속 학과           | 역할       | 연락처                          |
|--------------------------|---------------------|------------|---------------------------------|
| Jiang Haozheng          | 소프트웨어학부 (3학년) | 백엔드     | jhz190402522@gmail.com         |
| Abbos Aliboev           | 소프트웨어학부 (3학년) | UI/UX / 프론트엔드    | ali@chungbuk.ac.kr             |
| Namsraijalbuu Bilguun   | 소프트웨어학부 (3학년) | 백엔드     | bekunee0@gmail.com             |
| 김태영                  | 소프트웨어학부 (3학년) | 팀장 / 프론트엔드 | rlaxodud7737@naver.com         |


## 🚀 시작하기

### 필수 조건

- Android Studio 설치
- Python 3.9 이상
- Django 4.x
- Git

### 클라이언트 실행

```bash
git clone https://github.com/your-repo/shopping-accessibility-app.git
cd android-client
Android Studio로 열기

