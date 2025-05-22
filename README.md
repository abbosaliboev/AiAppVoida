Scrum sheet는 아래의 URL에 접속하여 확인하실 수 있습니다.
https://docs.google.com/spreadsheets/d/19OcmqpZHZYK2h3bqwkBScsr7RUosSOpt8s8sTrfmmuk/edit?usp=sharing

Scrum 미팅일지 및 기타 문서들은 'documentation' 브랜치를 참고해주세요.

# Inclusive Shopping App for the Visually Impaired

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

- **One-Tap Payment**
  - Simplified checkout process with a single-tap payment feature

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


## 👨‍💻 Team Members

| Name                    | Department            | Role       | Contact                      |
|-------------------------|------------------------|------------|------------------------------|
| Jiang Haozheng         | Software Engineering   | Backend  | jhz190402522@gmail.com       |
| Abbos Aliboev           | Software Engineering   | UI/UX, Frontend | ali@chungbuk.ac.kr           |
| Namsraijalbuu Bilguun   | Software Engineering   | Backend | bekunee0@gmail.com           |
| Kim Taeyoung            | Software Engineering   | Team Leader, Frontend| rlaxodud7737@naver.com       |

## 🚀 Getting Started

### Prerequisites

- Android Studio
- Python 3.9+
- Django 4.x
- Git

### Setup (Client)

```bash
git clone https://github.com/your-repo/shopping-accessibility-app.git
cd android-client
open with Android Studio
