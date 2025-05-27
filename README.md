# OrderService - Spring Boot Microservice

OrderService adalah aplikasi **microservice** berbasis Spring Boot yang dibangun dengan:
- Spring Boot 3.1.6
- Java 17
- PostgreSQL
- Spring IoC
- AOP (Aspect-Oriented Programming)
- Native SQL Query
- Java Stream API
- Pagination with DTO Wrapping
- Clean Architecture

---

## Fitur

- Tambah dan ambil data pesanan (Order).
- Filter pesanan dengan nilai transaksi tinggi.
- Logging otomatis via AOP.
- Pagination dengan response wrapper.
- Native SQL Query dengan streaming menggunakan Java Stream.

---

## Cara Menjalankan Aplikasi

### 1. Clone Repository
```bash
git clone https://github.com/username/orderservice.git
cd orderservice
```

### 2. Setup Database PostgreSQL
Buat database dengan nama `orders_db`.

```sql
CREATE DATABASE orders_db;
```

### 3. Update Konfigurasi
Buka `src/main/resources/application.properties`, ubah sesuai environment kamu:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/orders_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

### 4. Jalankan Aplikasi
```bash
./mvnw spring-boot:run
atau
menggunakan debug pada IDEA
```
