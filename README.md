# 🛒 CartFlow

A modern Android Shopping Cart application built with **Jetpack Compose**, following **MVVM** and **Clean Architecture**. This project demonstrates modern Android development best practices, including Dependency Injection with Hilt, networking using Retrofit, reactive UI with StateFlow, and a scalable project structure.

---

## ✨ Features

- 🛍️ Dynamic shopping cart fetched from REST API
- 📦 Display cart items with product details
- 💰 Order summary with subtotal, discount & total
- 🎁 Discount percentage calculation
- 🏷️ Promo code UI
- 💳 Payment method selection
- ⚡ Loading, Success & Error UI states
- 🔄 StateFlow based state management
- 🎨 Material 3 UI with Jetpack Compose
- 📱 Clean Architecture + MVVM

---

## 📸 Screenshots

| Cart Screen | Payment Selection |
|-------------|-------------------|
| <img width="300" height="700" alt="Cart Screen" src="https://github.com/user-attachments/assets/c39969da-22e6-4665-ae96-78181db83e76" /> | <img width="300" height="700" alt="Payment Selection" src="https://github.com/user-attachments/assets/085afdd6-8771-485c-9683-51cc21753b59" /> |

---

## 🏗️ Architecture

This project follows **Clean Architecture** with the **MVVM** design pattern.

```
Presentation
      │
      ▼
   ViewModel
      │
      ▼
   Use Cases
      │
      ▼
Repository (Interface)
      │
      ▼
Repository Implementation
      │
      ▼
   Remote Data Source (Retrofit)
```

---

## 📂 Project Structure

```
com.codewithmandyal.shoppingcartsystemdesign
│
├── common
│   ├── CurrencyDecimalFormat.kt
│   ├── PaymentMethodsList.kt
│   └── PriceCalculation.kt
│
├── data
│   ├── dto
│   ├── local
│   ├── mapper
│   ├── remote
│   └── repository
│
├── di
│   └── AppModule.kt
│
├── domain
│   ├── models
│   ├── repository
│   └── useCase
│
├── presentation
│   ├── components
│   ├── navigation
│   ├── screens
│   └── ui
│
├── MainActivity.kt
└── MyApplication.kt
```

---

## 🛠️ Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- MVVM
- Clean Architecture
- Hilt
- Retrofit
- Gson
- Kotlin Coroutines
- StateFlow
- Coil
- Navigation Compose

---

## 🌐 API

This project uses the **DummyJSON API**.

### Endpoint

```http
GET https://dummyjson.com/carts/{id}
```

### Retrofit

```kotlin
@GET("carts/{id}")
suspend fun getCart(
    @Path("id") id: Int
): CartResponseDto
```

A random cart ID is generated to fetch different cart data from the API.

---

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/CartFlow.git
```

### Open the project

Open the project in **Android Studio**, sync Gradle, and run the application.

---

## 📚 Concepts Covered

- Clean Architecture
- MVVM Architecture
- Repository Pattern
- Use Cases
- Dependency Injection with Hilt
- Retrofit Networking
- DTO → Domain Mapping
- StateFlow
- UI State Management
- Kotlin Coroutines
- Extension Functions
- Jetpack Compose
- Material Design 3

---

## 👨‍💻 Author

**Anil Kumar**

Android Developer | Kotlin | Jetpack Compose | Clean Architecture

- LinkedIn: https://www.linkedin.com/in/anil-mandyal
- GitHub: https://github.com/code-with-anil-mandyal

---

## ⭐ If you found this project helpful, consider giving it a Star!
