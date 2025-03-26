# JSON Web Token (JWT) Haqida To'liq Ma'lumot

## JWT Nima?
JWT (JSON Web Token) – bu ma’lumotlarni xavfsiz tarzda o‘zaro uzatish uchun ochiq standart bo‘lib, u JSON formati asosida ishlaydi va ma’lumotlarni raqamli tarzda imzolash imkonini beradi.

## JWT Tuzilishi
JWT uchta qismdan iborat bo‘ladi:
1. **Header (Sarlavha)** – Algoritm va token turi haqida ma’lumot saqlaydi.
2. **Payload (Yuklama)** – Asosiy ma’lumotlar joylashgan qism.
3. **Signature (Imzo)** – Token yaxlitligini tekshirish va himoya qilish uchun ishlatiladi.

Har bir qism Base64URL formatida kodlanadi va nuqta (`.`) bilan ajratiladi:
```
HEADER.PAYLOAD.SIGNATURE
```

## JWT Ishlash Mexanizmi
1. **Foydalanuvchi tizimga kirish uchun login va parolni yuboradi.**
2. **Server foydalanuvchini tekshiradi va JWT yaratadi.**
3. **Foydalanuvchi keyingi so‘rovlarni JWT bilan yuboradi.**
4. **Server JWT ni tekshiradi va javob qaytaradi.**

## JWT Pod Kapoti Ostida (How JWT Works Internally)
1. **Header**: JSON obyekt bo‘lib, quyidagicha bo‘ladi:
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```
2. **Payload**: Bu qism foydalanuvchi ma’lumotlarini o‘z ichiga oladi:
```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}
```
3. **Signature**: Ma’lumotlarni tasdiqlash uchun HMACSHA256 algoritmi bilan imzolanadi:
```
HMACSHA256(
  base64UrlEncode(header) + "." + base64UrlEncode(payload), secret
)
```

## JWT ning Afzalliklari
- **Stateless** – Serverda seans ma’lumotlarini saqlash shart emas.
- **Yuqori ishlash tezligi** – Har bir so‘rovda autentifikatsiya kerak bo‘lsa ham tez ishlaydi.
- **Platformadan mustaqil** – JSON formatda ishlagani uchun har qanday texnologiyada qo‘llaniladi.

## JWT va Sessiya Farqi
| Xususiyat  | JWT  | Sessiya |
|------------|------|---------|
| Saqlash    | Mijozda (client-side) | Serverda (server-side) |
| Tezlik     | Yuqori | Pastroq |
| O‘zgartirish | O‘zgartirib bo‘lmaydi | O‘zgarishi mumkin |

## Spring Boot-da JWT Misol
JWT autentifikatsiyani Spring Security va JWT kutubxonasi yordamida amalga oshirish mumkin.

### 1. JWT Token Generatsiyasi
```java
public String generateToken(String username) {
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
            .signWith(SignatureAlgorithm.HS256, "mySecretKey")
            .compact();
}
```

### 2. JWT Tokenni Tekshirish
```java
public Claims parseToken(String token) {
    return Jwts.parser()
            .setSigningKey("mySecretKey")
            .parseClaimsJws(token)
            .getBody();
}
```

## Xulosa
JWT – bu xavfsiz va samarali autentifikatsiya mexanizmi bo‘lib, tizimda foydalanuvchilarni tekshirish uchun ishlatiladi. U tezkor, stateless va platformadan mustaqil bo‘lib, ko‘plab zamonaviy veb-xizmatlarda keng qo‘llaniladi.

