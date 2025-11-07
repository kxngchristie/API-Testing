# API-Testing 🚀

This project demonstrates API testing implementation using different approaches, including RestAssured and Retrofit for Trello API integration. Perfect for learning and practising API testing concepts! ✨

## Project Structure 📁

```
API-Testing/
└── src/  
    ├── main/java/
    │   ├── pojoClasses/models/                    # POJO Classes
    │   │   ├── Board.java                         # 📋 Board Model
    │   │   ├── LabelColours.java                  # 🎨 Label Colors Model
    │   │   ├── Prefs.java                         # ⚙️ Preferences Model
    │   │   └── SwitcherView.java                  # 👀 Switcher View Model
    │   └── services/
    │       └── TrelloApiService.java              # 🔌 Trello API Service Interface
    └── test/java/
        ├── BaseTest/
        │   └── BaseTest.java                      # 🏗️ Base Test Configuration
        ├── RestAssured/
        │   └── RestAssuredTrelloTests.java        # 🧪 RestAssured API Tests
        ├── Retrofit/
        │   └── RetrofitTrelloTests.java           # 🧪 Retrofit API Tests
        └── utilities/
            └── BoardSteps.java                    # 🔧 Board Testing Utilities
```

## Components 📝

#### POJO Models (`pojoClasses/models/`)
Files:
- `Board.java`
- `LabelColours.java`
- `Prefs.java`
- `SwitcherView.java`

Purpose:
- 📋 Define data models for Trello API responses
- 🔄 JSON serialisation/deserialisation
- 🏗️ Object mapping structure

---

#### API Service (`services/`)
Files:
- `TrelloApiService.java`

Purpose:
- 🔌 Define API endpoints interface
- 📡 Handle API communications
- 🔐 Manage authentication

---

#### Test Implementation (`test/java/`)
Files:
- `BaseTest.java`
- `RestAssuredTrelloTests.java`
- `RetrofitTrelloTests.java`
- `BoardSteps.java`

Purpose:
- 🧪 API endpoint testing
- ✅ Response validation
- 🔍 Different testing approaches comparison

## Key Features Covered 📚

1. API Testing Frameworks 🛠️
   - 🔧 RestAssured
   - 🔌 Retrofit
   - 🧪 Test Automation

2. Testing Concepts 📊
   - ✅ Response Validation
   - 🔐 Authentication
   - 📋 Data Modelling
   - 🔍 Test Assertions

3. Testing Practices 🎯
   - 🏗️ Base Test Setup
   - 🔄 Test Data Management
   - 📝 Test Documentation

## Requirements ⚙️

- ☕ Java JDK 8 or higher
- 🛠️ Maven
- 💻 Any Java IDE (IntelliJ IDEA recommended)
- 🔑 Trello API Key and Token

## Getting Started 🏁

1. 📥 Clone the repository
2. 📂 Navigate to the project directory
3. 🔑 Configure your Trello API credentials in `config.properties`
4. ⚡ Run `mvn clean install` to build the project
5. 🧪 Execute tests with `mvn test`

## Configuration 🔧

Update `src/main/resources/config.properties` with your Trello credentials:
```properties
trelloBoardsApiTestingKey=your_api_key
trelloBoardsApiTestingToken=your_api_token
```

Happy Coding and Testing! 💻🧪
