# Task Manager – Spring Boot Microservices CI/CD Pipeline

This project demonstrates an **end-to-end CI/CD pipeline** for a Spring Boot microservices architecture.

The main goal of this project is to automate the build and delivery process of multiple microservices using modern DevOps practices.

## Architecture
- API Gateway
- User Service
- Task Service
- PostgreSQL

## CI/CD Flow
git push → GitHub Webhook → Jenkins → Docker Build → Docker Hub

## Technologies
- Spring Boot
- Maven
- Docker & Docker Compose
- Jenkins
- GitHub Webhooks
- Ngrok
- Docker Hub

## Jenkins Pipeline Stages
- Checkout Code
- Build User Service Image
- Build Task Service Image
- Build API Gateway Image
- Login to Docker Hub
- Push Images to Docker Hub

## How to Run Locally
```bash
docker-compose up --build
