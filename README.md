# 🍔 Konki Burger

**Konki Burger** es un ecosistema de aplicaciones diseñado para la gestión de una hamburguesería y la experiencia de usuarioEntity en diferentes plataformas.  
El sistema incluye módulos web y móviles para cubrir tanto la parte administrativa como la del cliente.

---

## 📂 Módulos del proyecto

- **Administración (Web – PC):**  
  Aplicación basada en **Struts2**, destinada a la gestión de productos, pedidos y usuarioEntities.

- **Usuario (Web – PC):**  
  Aplicación desarrollada con **Spring Boot + Angular**, enfocada en la interacción del cliente: navegación de menú, pedidos y gestión de cuenta.

- **Usuario (Móvil):**  
  Aplicación Android para clientes (tecnología pendiente de definir: **Java / Kotlin / Flutter**).

- **Administración (Móvil):**  
  Aplicación Android para administradores (tecnología pendiente de definir: **Java / Kotlin / Flutter**).

---

## 🛠️ Tecnologías utilizadas

- **Backend:** Struts2, Spring Boot  
- **Frontend Web:** Angular  
- **Móvil:** Android (Java / Kotlin / Flutter – en evaluación)  
- **Base de datos:** MySQL

---

## 🗄️ Base de datos

La aplicación utilizará **MySQL** como sistema de gestión de base de datos.  
Se almacenará información clave para el funcionamiento de la hamburguesería, incluyendo:  

- **Usuarios:** datos de clientes y administradores, credenciales, direcciones y preferencias.  
- **Productos:** hamburguesas, bebidas, complementos y categorías del menú.  
- **Pedidos:** detalles de pedidos realizados, estado, fecha y método de pago.  
- **Facturas:** generación y almacenamiento de facturas asociadas a los pedidos.  
- **Inventario:** control de stock de ingredientes y productos disponibles.  

---

## 🚀 Despliegue y ejecución

### 🔹 Backend (Spring Boot)
1. Clonar el repositorio y acceder al módulo correspondiente.  
   ```bash
   git clone https://github.com/JuanCarlos92/Konki_buguer.git
   cd konki-burger/backend-spring
   ```
2. Compilar y ejecutar con Maven o Gradle:  
   ```bash
   ./mvnw spring-boot:run
   ```
   o  
   ```bash
   ./gradlew bootRun
   ```
3. La API quedará disponible en:  
   ```
   http://localhost:8080
   ```

### 🔹 Administración Web (Struts2)
1. Acceder al módulo Struts2:  
   ```bash
   cd konki-burger/admin-struts2
   ```
2. Construir y desplegar en un servidor de aplicaciones (ej. Tomcat).  
3. Acceder vía navegador en:  
   ```
   http://localhost:8080/admin
   ```

### 🔹 Frontend Web (Angular)
1. Acceder al módulo Angular:  
   ```bash
   cd konki-burger/frontend-angular
   ```
2. Instalar dependencias:  
   ```bash
   npm install
   ```
3. Ejecutar en modo desarrollo:  
   ```bash
   ng serve
   ```
4. Aplicación disponible en:  
   ```
   http://localhost:4200
   ```

### 🔹 Aplicaciones móviles (Android)
*(En fase de definición, instrucciones se añadirán cuando se elija la tecnología: **Java / Kotlin / Flutter**).*

---

## 🎯 Objetivo

Desarrollar una solución integral que integre la administración interna con la experiencia de compra del cliente, optimizando procesos de gestión y mejorando la accesibilidad en diferentes plataformas.

---

## 📌 Estado del proyecto

🚧 En desarrollo  
Actualmente en fase de diseño y definición de la arquitectura de los módulos principales.

