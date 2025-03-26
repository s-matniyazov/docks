# HTTP/HTTPS haqida

## **HTTP (HyperText Transfer Protocol)**
Bu veb-sahifalarni yuklash va foydalanuvchilarga ko‘rsatish uchun ishlatiladigan asosiy protokol hisoblanadi. HTTP **stateless (holatsiz)** protokoldir, ya'ni har bir so‘rov va javob mustaqil bo‘lib, oldingi so‘rovlar haqida ma'lumot saqlamaydi.

### **HTTP qanday ishlaydi?**
1. **Foydalanuvchi brauzerga URL kiritadi** yoki sahifa ichidagi havolaga bosadi.
2. **Brauzer HTTP so‘rovini** (request) veb-serverga yuboradi.
3. **Server ushbu so‘rovni qayta ishlaydi** va unga javob qaytaradi (response).
4. **Brauzer serverdan kelgan javobni** tahlil qilib, foydalanuvchiga sahifani ko‘rsatadi.

### **HTTP metodlari**
HTTP so‘rovlari turli metodlardan foydalanadi:
- `GET` – Ma'lumot olish uchun ishlatiladi.
- `POST` – Serverga yangi ma'lumot jo‘natish uchun.
- `PUT` – Serverdagi mavjud ma'lumotni yangilash uchun.
- `DELETE` – Serverdagi ma'lumotni o‘chirish uchun.
- `PATCH` – Ma'lumotning bir qismini o‘zgartirish uchun.
- `HEAD` – `GET` bilan bir xil, lekin faqat javob sarlavhalarini oladi.
- `OPTIONS` – Server qo‘llab-quvvatlaydigan metodlarni ko‘rsatish uchun.

### **HTTP Status Kodlari**
- `2xx` – Muvaffaqiyatli bajarilgan (`200 OK`, `201 Created`).
- `3xx` – Yo‘naltirishlar (`301 Moved Permanently`, `302 Found`).
- `4xx` – Mijoz (foydalanuvchi) xatolari (`400 Bad Request`, `401 Unauthorized`, `404 Not Found`).
- `5xx` – Server xatolari (`500 Internal Server Error`, `502 Bad Gateway`).

---

## **HTTPS (HyperText Transfer Protocol Secure)**
Bu HTTP protokolining xavfsizroq versiyasi bo‘lib, **SSL/TLS (Secure Sockets Layer / Transport Layer Security)** yordamida shifrlangan aloqani ta’minlaydi.

### **HTTPS qanday ishlaydi?**
1. **Brauzer HTTPS so‘rovini yuboradi.**
2. **Server SSL/TLS sertifikatini taqdim etadi.**
3. **Brauzer sertifikatni tekshiradi va shifrlangan kanal yaratadi.**
4. **Server va brauzer shifrlangan aloqa orqali ma'lumot almashadi.**

### **HTTPS ning afzalliklari**
✅ **Shifrlangan ma'lumotlar** – Trafik shifrlangani sababli, uchinchi tomon uni o‘qiy olmaydi.
✅ **Haqiqiylik (Authenticity)** – SSL sertifikati veb-saytning haqiqiyligini tasdiqlaydi.
✅ **Ma'lumotlar butunligi (Integrity)** – So‘rov va javoblar o‘zgartirilmaganiga kafolat beradi.
✅ **SEO uchun foydali** – Google HTTPS ishlatadigan saytlarni yuqoriroq joylashishiga yordam beradi.

### **HTTP va HTTPS ning farqlari**
| Xususiyat  | HTTP | HTTPS |
|------------|------|-------|
| Xavfsizlik | Ochiq (shifrlanmagan) | SSL/TLS bilan shifrlangan |
| Port | 80 | 443 |
| Ishlash tezligi | HTTPS dan tezroq (lekin farq sezilarli emas) | Biroz sekinroq (shifrlash tufayli) |
| Ishlatish sohasi | Oddiy veb-saytlar | Banklar, e-tijorat, shaxsiy ma'lumotlar ishlatiladigan saytlar |

---

# **SSL/TLS haqida**

## **SSL/TLS nima?**
**SSL (Secure Sockets Layer)** va **TLS (Transport Layer Security)** – bu internet orqali ma’lumotlarni xavfsiz uzatish uchun ishlatiladigan kriptografik protokollar. **TLS – SSL ning yangi va xavfsizroq versiyasidir**, hozirda ko‘p hollarda aynan TLS ishlatiladi.

## **SSL va TLS ning vazifasi**
✅ **Shifrlash (Encryption)** – Ma’lumotlar shifrlanib uzatiladi, shuning uchun uchinchi tomon uni o‘qiy olmaydi.  
✅ **Haqiqiylik (Authentication)** – Foydalanuvchi va serverning haqiqiyligini tekshirib, "man-in-the-middle" hujumlarini oldini oladi.  
✅ **Ma’lumotlar butunligi (Integrity)** – Ma’lumotlar uzatilayotganda o‘zgartirilmaganligini kafolatlaydi.

## **SSL/TLS qanday ishlaydi?**
1️⃣ **Handshaking (aloqa o‘rnatish)**
- Brauzer serverga bog‘lanadi va TLS so‘rov yuboradi.
- Server javoban o‘zining **SSL/TLS sertifikati** ni yuboradi.
- Brauzer ushbu sertifikatni tekshiradi va shifrlash algoritmini kelishib oladi.

2️⃣ **Shifrlangan kanal yaratish**
- Sertifikat tekshirilgandan so‘ng, ikkala tomon maxfiy kalit yaratadi va almashadi.
- Bu kalit orqali barcha keyingi so‘rovlar **shifrlanadi**.

3️⃣ **Xavfsiz ma’lumot almashish**
- Endi brauzer va server o‘rtasidagi butun trafik shifrlangan holda uzatiladi.
- Hujumchilar bu ma’lumotlarni o‘qiy olmaydi.

## **SSL va TLS ning farqlari**
| Xususiyat  | SSL | TLS |
|------------|------|------|
| Ishga tushgan yili | 1995 | 1999 |
| Eng so‘nggi versiya | SSL 3.0 (1996) | TLS 1.3 (2018) |
| Xavfsizlik | Kamroq (hujumlarga moyil) | Kuchliroq |
| Ishlatilishi | Eskirgan, ishlatilmaydi | Hozirda qo‘llaniladi |

Hozir **SSL o‘rniga faqat TLS ishlatiladi**, chunki SSL’dagi zaifliklar uni ishlatishdan chiqardi.

## **TLS versiyalari**
- **TLS 1.0 (1999)** – SSL 3.0 ning yaxshilangan varianti, ammo eskirgan.
- **TLS 1.1 (2006)** – Kam ishlatiladi.
- **TLS 1.2 (2008)** – Hozir ko‘plab xizmatlar ishlatadi.
- **TLS 1.3 (2018)** – Eng yangi va xavfsiz versiya, yanada tezroq va samaraliroq.

## **Xulosa**
SSL eskirgan bo‘lsa ham, odamlar hali ham "SSL" terminini ishlatishadi, lekin **aslida hozir faqat TLS ishlatiladi**. Agar **HTTPS** ishlatmoqchi bo‘lsangiz, sayt **TLS sertifikati** bilan himoyalangan bo‘lishi kerak. **TLS 1.3 eng xavfsiz va tavsiya etilgan versiya hisoblanadi.**

