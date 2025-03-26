# OpenID Connect (OIDC) Haqida To'liq Ma'lumot

## OpenID Connect (OIDC) Nima?
OpenID Connect (OIDC) – bu OAuth 2.0 asosida qurilgan autentifikatsiya protokoli bo‘lib, foydalanuvchilarni ishonchli ravishda autentifikatsiya qilish va ularning identifikatsiya ma’lumotlarini ilovalarga taqdim etish uchun mo‘ljallangan.

## OIDC Xususiyatlari
- **OAuth 2.0 ustiga qurilgan** – OIDC OAuth 2.0 standartidan foydalanib autentifikatsiyani amalga oshiradi.
- **JSON Web Token (JWT) ishlatadi** – Identifikatsiya ma’lumotlari JWT orqali saqlanadi va uzatiladi.
- **Single Sign-On (SSO) qo‘llab-quvvatlaydi** – Bitta tizimga kirish orqali bir nechta ilovalarga kirish imkonini beradi.
- **Tizimlararo autentifikatsiya** – Foydalanuvchilar biror veb-xizmat yoki ilovaga boshqa identifikatsiya provayderlari (Google, Facebook, Microsoft) orqali kirishi mumkin.
- **OAuth 2.0 dan farqi** – OAuth 2.0 autentifikatsiya uchun emas, balki avtorizatsiya uchun ishlatiladi, OIDC esa aynan foydalanuvchi autentifikatsiyasi uchun mo‘ljallangan.

## OIDC Ishlash Mexanizmi
OIDC autentifikatsiya jarayoni quyidagi bosqichlardan iborat:

1. **Mijoz (Client) foydalanuvchini autentifikatsiya qilish uchun Identifikatsiya Provayderiga (IdP) so‘rov yuboradi.**
2. **Foydalanuvchi IdP orqali autentifikatsiyadan o‘tadi (masalan, Google yoki Facebook orqali).**
3. **IdP foydalanuvchini tekshirib, unga identifikatsiya tokeni (ID Token) qaytaradi.**
4. **Mijoz tokenni tekshiradi va agar hammasi to‘g‘ri bo‘lsa, foydalanuvchiga tizimga kirish huquqini beradi.**

## OIDC Komponentlari
- **End-user (Foydalanuvchi)** – Identifikatsiya qilinadigan shaxs.
- **Relying Party (RP)** – Foydalanuvchi identifikatsiya qilinadigan ilova yoki xizmat.
- **OpenID Provider (IdP)** – Foydalanuvchini autentifikatsiya qiluvchi provayder (Google, Facebook va boshqalar).
- **ID Token** – Foydalanuvchi identifikatsiya ma’lumotlarini o‘z ichiga olgan JWT.
- **Access Token** – Resurslarga kirish uchun OAuth 2.0 tomonidan beriladigan token.
- **Authorization Endpoint** – Foydalanuvchini autentifikatsiya qilish uchun ishlatiladigan URL.
- **Token Endpoint** – Tokenlarni olish uchun ishlatiladigan URL.

## ID Token Nima?
ID Token – bu foydalanuvchini aniqlash uchun OpenID Provider tomonidan beriladigan JSON Web Token (JWT) bo‘lib, unda quyidagi ma’lumotlar bo‘ladi:
- **iss (issuer)** – Tokenni kim berganligi.
- **sub (subject)** – Foydalanuvchi IDsi.
- **aud (audience)** – Kimga mo‘ljallanganligi.
- **exp (expiration)** – Token muddati tugash vaqti.
- **iat (issued at)** – Token yaratilgan vaqti.

ID Token JSON Web Token (JWT) formatida bo‘lib, shifrlangan va imzolangan holda uzatiladi.

## OIDC Autentifikatsiya Turlari
OIDC bir nechta autentifikatsiya oqimlarini (flow) qo‘llab-quvvatlaydi:

1. **Authorization Code Flow** (Tavsiya etiladi):
  - Foydalanuvchi brauzer orqali provayderga yo‘naltiriladi.
  - Foydalanuvchi autentifikatsiyadan o‘tadi va authorization code oladi.
  - Mijoz authorization code ni token endpoint ga yuborib, ID Token va Access Token oladi.

2. **Implicit Flow** (Kamroq xavfsiz):
  - Brauzer orqali to‘g‘ridan-to‘g‘ri ID Token olinadi.
  - Access Token ham brauzer orqali olinadi.
  - Kamroq xavfsiz bo‘lgani sababli tavsiya etilmaydi.

3. **Hybrid Flow**:
  - Authorization Code va Implicit Flow kombinatsiyasi.
  - Mijoz ID Token va Access Token ni qisman brauzer orqali, qisman server orqali oladi.

## OIDC va OAuth 2.0 Farqlari
| Xususiyat | OAuth 2.0 | OIDC |
|-----------|----------|------|
| Maqsad | Avtorizatsiya | Autentifikatsiya |
| Token turi | Access Token | ID Token (JWT) |
| Qo‘shimcha ma’lumot | Yo‘q | Foydalanuvchi identifikatori (sub), email va boshqa ma’lumotlar |
| Single Sign-On (SSO) | Yo‘q | Ha |

## OIDC Ishlash Mexanizmi Pod Kapoti Ostida
1. **Mijoz provayderga HTTPS orqali so‘rov yuboradi.**
2. **OAuth 2.0 ishlatilgan holda autentifikatsiya amalga oshiriladi.**
3. **Foydalanuvchi tekshirilgach, provayder ID Token yaratadi.**
4. **Token JWT formatida imzolanadi va mijozga yuboriladi.**
5. **Mijoz tokenni verifikatsiya qilib, foydalanuvchining identifikatsiyasini tasdiqlaydi.**
6. **Mijoz token orqali API chaqiruvlarini amalga oshiradi.**

## Java Spring Boot da OIDC Implementatsiyasi

### 1. Spring Security orqali OIDC sozlash
Spring Boot ilovasida OIDC ni qo‘llash uchun `spring-security-oauth2-client` kutubxonasidan foydalanish mumkin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

### 2. `application.yml` faylida sozlash
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: YOUR_CLIENT_ID
            client-secret: YOUR_CLIENT_SECRET
            scope: openid, profile, email
```

### 3. OIDC bilan autentifikatsiya qilish
Spring Security orqali foydalanuvchini autentifikatsiya qilish uchun quyidagi koddan foydalanish mumkin:

```java
@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal OidcUser user) {
        return user.getClaims();
    }
}
```

## Xulosa
- **OIDC OAuth 2.0 ni kengaytirib, autentifikatsiya xizmatlarini taqdim etadi.**
- **Foydalanuvchi identifikatorlarini ID Token orqali taqdim etadi.**
- **JSON Web Token (JWT) asosida xavfsizlikni ta’minlaydi.**
- **Spring Boot kabi framework lar orqali oson implementatsiya qilish mumkin.**

