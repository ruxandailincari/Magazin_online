# E-Shop Full Stack
A modern, end-to-end e-commerce application built with Spring Boot and React . This project features secure JWT authentication, role-based access control (RBAC), real-time messaging and Redis caching.

## Overview
A complete online store solution allowing customers to browse products, manage a shopping cart and place orders, while administrators can manage inventory and view analytics. The system integrates real-time chat between customers and admins using Firebase Firestore.
Link: https://shop-ruxanda.netlify.app/

## Key Features
- Secure Authentication:
  - JWT-based stateless authentication
  - Role-Based Access Control (Admin vs. Customer)
  - Password hashing with BCrypt
- Performance Optimization: Redis Caching
- Real-Time Communication:
  - Live Chat: Customer-Admin messaging with unread notifications
  - Firebase Integration: Real-time sync using Firestore
- Modern Frontend:
  - React + Vite: Fast development and build
  - TanStack Query: Efficient server-state management and cache invalidation
  - Tailwind CSS: Responsive and modern UI
- DevOps & Documentation
  - Docker: Multi-stage builds for optimized images
  - Swagger: Auto-generated API documentation

##  Tech Stack
-	Backend: Spring Boot, Java, Spring Security, Spring Data JPA 
-	Database: PostgreSQL, Flyway 
-	Cache: Redis
-	Frontend: React, Vite, Tailwind CSS, TanStack Query
-	Real-Time: Firebase Firestore
-	Docs: Swagger 
-	Deployment: Docker, Netlify,  Render, Neon, UpStash
