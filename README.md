# 🔍 AI-Powered Java Code Review System

> Combines static AST analysis with LLM-powered reasoning to detect bugs, security vulnerabilities, and code quality issues — then generates refactored code with plain-English explanations.

![Java](https://img.shields.io/badge/Java-23-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1?style=flat-square&logo=mysql&logoColor=white)
![LangChain4j](https://img.shields.io/badge/LangChain4j-Latest-1C3C3C?style=flat-square)
![Gemini](https://img.shields.io/badge/Gemini-2.5_Flash-4285F4?style=flat-square&logo=google&logoColor=white)

---

## 🧠 Pipeline Overview

```text
Java Source Code
       │
       ▼
JavaParser (AST) ──► Cyclomatic Complexity · Naming Violations · Empty Catch Blocks
       │
       ▼
LangChain4j + Gemini API
 ├── [1] Bug Detection
 ├── [2] Security Scanning
 └── [3] Quality Scoring (0–100)
       │
       ▼
Score Merger
overallScore = (100 - bugPenalty)×0.3 + (100 - secPenalty)×0.3 + qualityScore×0.4
       │
       ▼
Refactoring Engine (4th AI pipeline) ──► Corrected code + fix explanations
       │
       ▼
MySQL (full session persisted)
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 23 |
| Static Analysis | JavaParser (Visitor pattern) |
| AI Integration | LangChain4j + Google Gemini `gemini-2.5-flash` |
| Database | MySQL 8.0 via JDBC `PreparedStatement` |
| Build | Maven 3.9+ |

---

## 🚀 Setup

### Prerequisites
- Java 23+, Maven 3.9+, MySQL 8.0+
- Gemini API key → [aistudio.google.com](https://aistudio.google.com/app/apikey)

### Environment Variables
```bash
GEMINI_API_KEY=your_api_key_here
DB_URL=jdbc:mysql://localhost:3306/codereview
DB_USER=root
DB_PASSWORD=your_password
```

### Database
```sql
CREATE DATABASE codereview;
USE codereview;

CREATE TABLE review_sessions (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    reviewed_at    BIGINT NOT NULL,
    code_reviewed  TEXT NOT NULL,
    bugs           INT,
    sec_issues     INT,
    quality_score  INT,
    overall_score  INT,
    bug_report     TEXT,
    sec_report     TEXT,
    quality_report TEXT
);
```

### Run
```bash
mvn clean compile
mvn exec:java "-Dexec.mainClass=com.codereview.App"
```

---
