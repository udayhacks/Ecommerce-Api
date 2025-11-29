# High-Performance REST API with PostgreSQL + Redis + Docker

This project is a scalable REST backend designed to handle high traffic.  
It uses PostgreSQL for persistent storage and Redis for caching, sessions, and fast data access.

---

## 🚀 Features
- RESTful API design  
- PostgreSQL relational database  
- Redis caching layer  
- Dockerized services  
- Connection-pooling optimized  
- Production-ready architecture  
- Clean project structure  
- Scalable — supports load-balancing & horizontal scaling  

---

## 🧱 Architecture

Client → API → Service Layer → PostgreSQL + Redis

- PostgreSQL → main database storage
- Redis → caching of frequently accessed data
- API container connects to both

---

## 📦 Docker Setup

### Run all services:
```bash
docker-compose up -d
