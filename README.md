
# ShapeTool SOAP Web Service

## 📌 Overview
ShapeTool is a SOAP-based web service built using **Spring Boot**.  
It provides operations to calculate the **area of different geometric shapes** such as circles and more.

This project follows a **contract-first approach**, meaning the service is designed using **XSD (XML Schema)** and **WSDL** before implementation.

---

## ⚙️ Technologies Used
- Java
- Spring Boot
- Spring Web Services (Spring-WS)
- SOAP (XML-based messaging)
- WSDL (Web Service Definition Language)
- XSD (XML Schema Definition)
- Maven

---

## 📁 Project Structure
```

src/main/java
└── com.asefu.asefu
├── AsefuApplication.java
├── config
│     └── WebServiceConfig.java
├── endpoint
│     └── ShapeEndpoint.java

src/main/resources
├── application.properties
├── ShapeTool.wsdl
└── schemas
└── shapes.xsd

````

---

## 📐 Features
- Calculate **circle area**
- SOAP request/response handling
- XML-based communication
- Contract-first service design

---


## 🔗 Endpoint

http://localhost:8080/ws

