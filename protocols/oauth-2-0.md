# OAuth 2.0 Haqida To'liq Ma'lumot

## OAuth 2.0 Nima?
OAuth 2.0 – bu ochiq autentifikatsiya va avtorizatsiya protokoli bo‘lib, uchinchi tomon xizmatlariga foydalanuvchining login va parolini oshkor qilmasdan resurslarga kirish imkoniyatini beradi.

## OAuth 2.0 Asosiy Xususiyatlari
- **Token asosida avtorizatsiya** – Kirish uchun foydalanuvchi ma’lumotlari o‘rniga access token ishlatiladi.
- **Moslashuvchanlik** – Har xil turdagi xizmatlar va tizimlar bilan ishlash uchun mo‘ljallangan.
- **Xavfsizlik** – OAuth 2.0 yordamida foydalanuvchi ma’lumotlari xavfsiz saqlanadi.
- **Uchinchi tomon ilovalar bilan ishlash** – Ilovalar foydalanuvchilarning akkauntiga to‘g‘ridan-to‘g‘ri kirish huquqisiz xizmatlardan foydalanishi mumkin.

## OAuth 2.0 Ishlash Mexanizmi
OAuth 2.0 quyidagi asosiy komponentlardan iborat:
- **Resource Owner (Resurs egasi)** – OAuth orqali avtorizatsiya qilingan foydalanuvchi.
- **Client (Mijoz)** – Foydalanuvchi resurslariga kirishga harakat qilayotgan uchinchi tomon ilova.
- **Authorization Server (Avtorizatsiya serveri)** – Foydalanuvchini autentifikatsiya qiladi va access token taqdim etadi.
- **Resource Server (Resurs serveri)** – OAuth token bilan himoyalangan ma’lumotlarga ega bo‘lgan server.

## OAuth 2.0 Grant Turlari
### 1. **Authorization Code Grant**
Ushbu grant turi veb-ilovalar uchun mo‘ljallangan bo‘lib, mijoz dasturi foydalanuvchini OAuth serveriga yo‘naltiradi va avtorizatsiya kodi oladi.

**Ishlash tartibi:**
1. Mijoz dasturi foydalanuvchini avtorizatsiya serveriga yuboradi.
2. Foydalanuvchi login va parolni kiritadi va ruxsat beradi.
3. Avtorizatsiya serveri mijoz dasturiga avtorizatsiya kodini yuboradi.
4. Mijoz dasturi ushbu koddan foydalanib access token oladi.

### 2. **Implicit Grant**
Bu tur ko‘pincha JavaScript asosidagi veb-ilovalar uchun ishlatiladi. Unda mijoz dasturi bevosita access token oladi.

### 3. **Client Credentials Grant**
Bu grant serverlar orasidagi o‘zaro aloqada ishlatiladi. Foydalanuvchi ishtirok etmaydi, serverlar o‘z mijoz identifikatori va maxfiy kalitidan foydalanadi.

### 4. **Password Grant**
Foydalanuvchi login va parolini mijoz dasturiga kiritadi va dastur ushbu ma’lumotlardan foydalanib access token oladi.

### 5. **Refresh Token**
Access token muddati tugaganda, yangi token olish uchun ishlatiladigan mexanizm.

## OAuth 2.0 Pod Kapoti Ostida
1. **JSON Web Token (JWT)** – Token ma’lumotlarni himoyalash uchun ishlatiladi.
2. **HTTPS orqali xavfsizlik** – OAuth 2.0 tokenlarni faqat HTTPS orqali uzatishni tavsiya qiladi.
3. **Token muddati va yangilanishi** – Tokenlar ma’lum vaqt davomida amal qiladi va refresh token orqali yangilanadi.
4. **Scope mexanizmi** – Token qaysi resurslarga kirish huquqiga ega ekanligini aniqlaydi.

## OAuth 2.0 dan Foydalanish Misoli (Spring Security bilan)

### 1. **Spring Security konfiguratsiyasi**
```java
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("client-id")
            .secret("client-secret")
            .authorizedGrantTypes("authorization_code", "refresh_token", "password")
            .scopes("read", "write");
    }
}
```

### 2. **Foydalanuvchini autentifikatsiya qilish**
```java
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/public").permitAll()
            .antMatchers("/secure").authenticated();
    }
}
```

### 3. **Access Token olish**
```bash
POST /oauth/token
Content-Type: application/x-www-form-urlencoded

client_id=client-id&client_secret=client-secret&grant_type=password&username=user&password=pass
```

### 4. **Himoyalangan resursga kirish**
```bash
GET /secure
Authorization: Bearer ACCESS_TOKEN
```

## OAuth 2.0 va JWT
Ko‘pincha OAuth 2.0 token sifatida JWT dan foydalanadi. JWT tarkibi quyidagicha bo‘ladi:
```json
{
  "alg": "HS256",
  "typ": "JWT"
}.
{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}.
[signature]
```

## OAuth 2.0 va OpenID Connect
OAuth 2.0 identifikatsiya uchun ishlatilmaydi, faqat avtorizatsiya uchun. Agar foydalanuvchini ham autentifikatsiya qilish kerak bo‘lsa, OpenID Connect (OIDC) ishlatiladi.

## OAuth 2.0 va API Xavfsizligi
1. **HTTPS majburiy** – Ma’lumotlarni shifrlash uchun.
2. **Token muddati cheklangan** – Maxsus vaqt o‘tganidan keyin yangilanishi kerak.
3. **Scope mexanizmi** – Token qaysi resurslarga kirish huquqiga ega ekanligini nazorat qilish.

## Xulosa
OAuth 2.0 – bu zamonaviy veb-ilovalar va mikroxizmatlar uchun xavfsiz avtorizatsiya protokoli. U orqali xizmatlar uchinchi tomon ilovalariga foydalanuvchi ma’lumotlarini oshkor qilmasdan ruxsat berishi mumkin. OAuth 2.0 JWT bilan birga ishlatilganda tezkor va samarali autentifikatsiya va avtorizatsiya mexanizmini yaratish mumkin.

