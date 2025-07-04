
# Midas Core – JPMorgan Chase Software Engineering Job Simulation (Forage)

This repository contains my completed solution for the **Midas Core** project, part of the [JPMorgan Chase Software Engineering Virtual Experience Program](https://www.theforage.com/) on Forage.

> 🔧 I forked the base repository and completed all backend engineering tasks with hands-on learning and technical guidance. Every feature was implemented by me to understand real-world backend systems using Java, Kafka, Spring Boot, and REST APIs.

---

## 🚀 Project Overview

Midas Core is a Spring Boot-based microservice that simulates a banking backend system. It listens for incoming transactions from a Kafka topic, updates user balances in a database, and exposes a REST endpoint to query balances.

---

## 📦 Features

- ✅ Kafka Consumer using `@KafkaListener`
- ✅ Persist transaction data using Spring Data JPA (H2 in-memory DB)
- ✅ Create and update user balance records
- ✅ Expose a RESTful API: `/balance?userId=X`
- ✅ Integrate with external Incentive API for reward logic
- ✅ Use of application.yml for clean configuration management

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Apache Kafka
- H2 Database
- REST APIs (Spring MVC)
- Spring Data JPA

---

## 📂 How to Run

1. Ensure Kafka and Incentive API are running
2. Run `MidasCoreApplication.java` from your IDE or terminal
3. Use the endpoint:  
   `http://localhost:33400/balance?userId=1`

---

## 🧠 What I Learned

- Event-driven architecture using Kafka
- REST API design and data serialization
- Entity-repository-service-controller pattern in Spring Boot
- Real-world debugging and configuration
- Clean code architecture and microservice principles

---

## 📌 Disclaimer

This project was completed as part of the **JPMorgan Chase Software Engineering Job Simulation** on [Forage](https://www.theforage.com/).  
It is for **educational purposes only** and is not affiliated with JPMorgan Chase & Co. in any official capacity.

---

## 📫 Contact

Feel free to reach out if you’d like to collaborate or discuss backend engineering:

**LinkedIn**: [linkedin.com/in/Roopashree.R](https://www.linkedin.com/in/roopashree-rangaswamy/)  
**Email**: roopashree.r2004@gmail.com
