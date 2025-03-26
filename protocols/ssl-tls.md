# SSL/TLS Haqida To'liq Ma'lumot

## SSL/TLS Nima?
SSL (Secure Sockets Layer) va TLS (Transport Layer Security) tarmoqlar orqali ma'lumotlarni shifrlash va xavfsiz uzatish uchun ishlatiladigan kriptografik protokollardir. TLS – SSL'ning rivojlangan versiyasi bo‘lib, zamonaviy veb-xavfsizlik standartidir.

## SSL va TLS Farqlari
| Xususiyat | SSL | TLS |
|-----------|-----|-----|
| Birinchi chiqarilgan yili | 1995 | 1999 |
| Eng so‘nggi versiya | SSL 3.0 | TLS 1.3 |
| Xavfsizlik | Kamroq xavfsiz | Yaxshiroq xavfsizlik |
| Ishlash tezligi | Sekinroq | Tezroq |
| Shifrlash algoritmlari | Kamroq zamonaviy | Zamonaviy algoritmlar |

## SSL/TLS Ishlash Mexanizmi
1. **Handshake (Qo‘l siqish jarayoni)**: Mijoz va server o‘zaro aloqa o‘rnatadi va shifrlash usulini kelishib oladi.
2. **Sertifikat tekshirish**: Server mijozga sertifikatni taqdim etadi va mijoz uni ishonchli ekanligini tekshiradi.
3. **Kalit almashish**: Asimmetrik shifrlash yordamida mijoz va server shifrlash uchun maxfiy kalit almashadi.
4. **Shifrlangan aloqa**: Kalitlar almashilganidan so‘ng, butun muloqot shifrlangan holda davom etadi.
5. **Aloqani yakunlash**: Aloqa tugagach, shifrlash mexanizmi bekor qilinadi.

## SSL/TLS Handshake Ketma-ketligi
1. Mijoz serverga "ClientHello" xabarini yuboradi.
2. Server "ServerHello" xabarini yuboradi va o‘zining sertifikatini jo‘natadi.
3. Mijoz sertifikatni tekshiradi va "Premaster Secret" yaratadi.
4. "Premaster Secret" serverga asimmetrik shifrlash orqali jo‘natiladi.
5. Server va mijoz "Session Key" hosil qilib, shifrlangan aloqani boshlaydi.

## SSL/TLS Sertifikatlari
Sertifikatlar **CA (Certificate Authority)** tomonidan tasdiqlanadi va veb-sayt xavfsiz ekanligini kafolatlaydi.

### Asosiy Sertifikat Turlari
- **DV (Domain Validation)** – Faqat domenni tasdiqlaydi.
- **OV (Organization Validation)** – Kompaniya haqida qo‘shimcha tekshiruvdan o‘tadi.
- **EV (Extended Validation)** – Eng yuqori darajadagi tekshiruv, yashil qulf belgisi bilan ko‘rsatiladi.

## SSL/TLS va HTTPS
**HTTPS (Hypertext Transfer Protocol Secure)** – bu **HTTP** ning SSL/TLS bilan himoyalangan versiyasidir. HTTPS foydalanuvchilar ma’lumotlarini xavfsiz saqlash va tranzaksiyalarni shifrlash uchun ishlatiladi.

## SSL/TLS Zaifliklari va Hujumlar
1. **Man-in-the-Middle (MitM)** – Tajovuzkor mijoz va server orasidagi aloqani buzishi mumkin.
2. **SSL Stripping** – HTTPS ulanishni oddiy HTTP ga o‘zgartirish orqali xakerlar foydalanuvchi ma’lumotlarini o‘g‘irlashi mumkin.
3. **BEAST Attack** – SSL 3.0 va eski TLS versiyalaridagi zaiflikdan foydalanish.
4. **Heartbleed** – OpenSSL'dagi xatolik tufayli shifrlangan ma’lumotlarni ochish imkoniyati.

## SSL/TLS-ni Ishlatish
### Java Spring Boot-da SSL/TLS sozlash
1. **SSL sertifikatini o‘rnatish**:
   ```properties
   server.port=8443
   server.ssl.key-store=classpath:keystore.p12
   server.ssl.key-store-password=parol
   server.ssl.key-store-type=PKCS12
   server.ssl.key-alias=myalias
   ```
2. **Spring Security bilan HTTPS majburiy qilish**:
   ```java
   @Configuration
   public class SecurityConfig {
       @Bean
       public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
           http.requiresChannel().anyRequest().requiresSecure();
           return http.build();
       }
   }
   ```

## Xulosa
SSL/TLS – bu zamonaviy veb-xavfsizlikning asosi bo‘lib, ma’lumotlarni shifrlash, sertifikatlar orqali autentifikatsiya qilish va xavfsiz aloqa o‘rnatish imkonini beradi. Zamonaviy veb-saytlar uchun **HTTPS** ishlatish talab qilinadi va eski SSL versiyalaridan voz kechish tavsiya etiladi.

