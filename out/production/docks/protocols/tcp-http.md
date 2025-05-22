# TCP va HTTP Xabarlarini Yuborish Tartibi

## 1. TCP (Transmission Control Protocol) Xabarlari
TCP – bu ishonchli, bog‘langan transport protokoli bo‘lib, ma’lumotlarni segmentlarga bo‘lib yuboradi va qabul qiladi. Quyida TCP xabarlarini yuborish jarayoni bayon etiladi:

### 1.1. TCP Aloqa O‘rnatish (Three-Way Handshake)
TCP bog‘lanish o‘rnatish uchun quyidagi bosqichlarni bajaradi:
1. **SYN (Synchronize)**: Mijoz (Client) serverga bog‘lanish so‘rovi bilan SYN xabarini yuboradi.
2. **SYN-ACK (Synchronize-Acknowledge)**: Server SYN so‘rovini qabul qilib, javoban SYN-ACK yuboradi.
3. **ACK (Acknowledge)**: Mijoz SYN-ACK ni tasdiqlab, ACK xabarini yuboradi. Shu bilan bog‘lanish o‘rnatiladi.

### 1.2. Ma’lumot Uzatish
- TCP ma’lumotlarni kichik segmentlarga bo‘lib yuboradi.
- Har bir segment raqamlanadi va qabul qiluvchi tomonda yig‘iladi.
- Agar segment yetib bormasa yoki buzilsa, TCP uni qayta yuboradi (retransmission).

### 1.3. TCP Aloqani Yopish (Four-Way Handshake)
TCP aloqa yopilishi uchun quyidagi bosqichlar bajariladi:
1. Mijoz FIN xabarini yuboradi.
2. Server ACK bilan tasdiqlaydi.
3. Server FIN xabarini yuboradi.
4. Mijoz ACK bilan tasdiqlaydi va aloqa yopiladi.

---

## 2. HTTP (HyperText Transfer Protocol) Xabarlari
HTTP – bu yuqori darajadagi protokol bo‘lib, TCP ustida ishlaydi va mijoz-server o‘rtasida ma’lumot almashinuvini ta’minlaydi.

### 2.1. HTTP So‘rovining Tuzilishi
HTTP so‘rovi quyidagi tarkibiy qismlardan iborat bo‘ladi:
```
GET /index.html HTTP/1.1
Host: example.com
User-Agent: Mozilla/5.0
Accept: text/html
```
- **So‘rov turi** (GET, POST, PUT, DELETE)
- **URL yo‘li** (/index.html)
- **Protokol versiyasi** (HTTP/1.1)
- **Sarlavhalar (Headers)** (Host, User-Agent, Accept)
- **Tana (Body)** (faqat POST va PUT uchun)

### 2.2. HTTP Javobi
HTTP javobi quyidagi tarkibiy qismlardan iborat bo‘ladi:
```
HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 1234

<html>...</html>
```
- **Status kodi** (200 OK, 404 Not Found, 500 Internal Server Error)
- **Sarlavhalar** (Content-Type, Content-Length)
- **Javob tanasi (Body)** (HTML yoki JSON ma’lumotlari)

### 2.3. HTTP Ishlash Bosqichlari
1. **Mijoz TCP bog‘lanish o‘rnatadi** (3-way handshake).
2. **HTTP so‘rovini yuboradi** (GET, POST, PUT, DELETE va boshqalar).
3. **Server HTTP javobini yuboradi**.
4. **Mijoz ma’lumotni qabul qilib, ko‘rsatadi**.
5. **TCP aloqasi yopiladi yoki davom etadi (Keep-Alive bo‘lsa).**

---

## 3. TCP vs HTTP
| Xususiyat | TCP | HTTP |
|-----------|-----|------|
| Darajasi | Transport | Ilova |
| Ishlash mexanizmi | Bog‘langan, ishonchli | Bog‘lanmagan, soddaroq |
| Ma’lumot almashish | Segment asosida | Sarlavha + body |
| Qo‘llanilishi | Har qanday tarmoq dasturlari | Veb-brauzerlar, API-lar |

Bu hujjat TCP va HTTP xabarlarining qanday yuborilishi haqida to‘liq tushuncha beradi.

