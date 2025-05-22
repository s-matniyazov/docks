# SMTP (Simple Mail Transfer Protocol)

## SMTP Nima?
SMTP (Simple Mail Transfer Protocol) – bu elektron pochta xabarlarini jo‘natish va marshrutlash uchun ishlatiladigan standart Internet protokoli. U **TCP/IP** asosida ishlaydi va **port 25 (standart), 465 (SSL) yoki 587 (TLS)** orqali xabarlarni yuboradi.

## SMTP Ishlash Printsipi
SMTP elektron pochta serverlari o‘rtasida xabarlarni uzatish uchun ishlatiladi. Uning ishlash jarayoni quyidagi bosqichlarni o‘z ichiga oladi:

1. **Mijozdan serverga xabar yuborish** – Elektron pochta mijozlari (Outlook, Thunderbird) yoki veb-xizmatlar (Gmail, Yahoo) SMTP serverga xabar yuboradi.
2. **Serverdan serverga marshrutlash** – SMTP server qabul qiluvchi domenni aniqlaydi va xabarni tegishli pochta serveriga yetkazadi.
3. **Pochta qabul qiluvchi server tomonidan saqlanadi** – Qabul qiluvchi pochta serveri (IMAP/POP3) xabarni qabul qilib, uni foydalanuvchiga yetkazadi.

## SMTP Qanday Ishlaydi? (Pod kapotom)
SMTP quyidagi bosqichlarda ishlaydi:
1. **Ulanish bosqichi**
  - Mijoz SMTP serverga **TCP port 25, 465 yoki 587** orqali bog‘lanadi.
  - Server **220 xush kelibsiz** xabarini jo‘natadi.
  - Mijoz `EHLO` yoki `HELO` buyrug‘i bilan o‘zini tanishtiradi.

2. **Identifikatsiya va autentifikatsiya**
  - Agar server autentifikatsiya talab qilsa, mijoz `AUTH LOGIN`, `AUTH PLAIN` yoki `AUTH CRAM-MD5` buyrug‘lari bilan login va parolni yuboradi.
  - Agar TLS shifrlash ishlatilsa, mijoz `STARTTLS` buyrug‘ini jo‘natadi va xavfsiz ulanishni boshlaydi.

3. **Xabar jo‘natish jarayoni**
  - `MAIL FROM:` – Xat jo‘natuvchining manzili yuboriladi.
  - `RCPT TO:` – Xat kimga yuborilayotgani ko‘rsatiladi.
  - `DATA` – Xatning o‘zi (sarlavha va tanasi) yuboriladi.
  - `.` (nuqta) – Xabar tugaganligini bildiradi.

4. **Xabarni yetkazish**
  - Server jo‘natuvchi domeniga qarab **DNS so‘rovi** yuboradi va **MX (Mail Exchange) yozuvini** topadi.
  - Agar serverga yetib bo‘lmasa, SMTP server **queue (navbat)** ga qo‘yadi va yana qayta yuborishga harakat qiladi.
  - Agar server xabarni qabul qilsa, `250 OK` javobi yuboriladi.

5. **Aloqani tugatish**
  - Mijoz `QUIT` buyrug‘ini yuboradi va server bog‘lanishni yopadi.

## SMTP Buyruqlari
SMTP buyruqlari mijoz va server o‘rtasidagi aloqa uchun ishlatiladi.

| Buyruq  | Tavsif |
|---------|--------|
| `HELO`  | Server bilan bog‘lanish |
| `EHLO`  | HELO ning kengaytirilgan versiyasi |
| `MAIL FROM` | Xat jo‘natuvchi manzilni aniqlash |
| `RCPT TO` | Xat qabul qiluvchi manzilni aniqlash |
| `DATA`  | Xat tarkibini yuborish |
| `STARTTLS` | TLS shifrlashni boshlash |
| `QUIT`  | Ulanishni yopish |

## SMTP orqali Elektron Pochta Yuborish
### Linux da SMTP orqali pochta yuborish
```bash
sendmail user@example.com < message.txt
```

### Python orqali SMTP ulanishi
```python
import smtplib
from email.mime.text import MIMEText

msg = MIMEText("Salom, bu test xabar!")
msg['Subject'] = "Test"
msg['From'] = "sender@example.com"
msg['To'] = "receiver@example.com"

server = smtplib.SMTP('smtp.example.com', 587)
server.starttls()
server.login("sender@example.com", "parol")
server.sendmail("sender@example.com", "receiver@example.com", msg.as_string())
server.quit()
```

## SMTP Xavfsizligi
- **SPF (Sender Policy Framework)** – Foydalanuvchi IP-manzilining haqiqiyligini tekshiradi.
- **DKIM (DomainKeys Identified Mail)** – Elektron pochtani shifrlash orqali firibgarlikdan himoya qiladi.
- **DMARC (Domain-based Message Authentication, Reporting & Conformance)** – SPF va DKIM ni birgalikda qo‘llash orqali xabarlarni tekshiradi.
- **TLS/SSL** – Xabarlarni shifrlash va xavfsiz ulanishni ta’minlaydi.

## MyEmail@mysite.com dan Gmail.com ga xabar jo‘natish ketma-ketligi
1. **Mijoz SMTP serverga ulanadi** (`smtp.mysite.com`) – TCP port 587 yoki 465 orqali.
2. **SMTP autentifikatsiya bosqichi** (`AUTH LOGIN`) – Mijoz o‘z login va parolini yuboradi.
3. **Xabar jo‘natish buyruqlari bajariladi:**
  - `MAIL FROM: <myemail@mysite.com>`
  - `RCPT TO: <user@gmail.com>`
  - `DATA` va xabar tanasi yuboriladi.
4. **Mysite.com SMTP serveri DNS orqali Gmail MX yozuvlarini so‘raydi** va `smtp.gmail.com` ga ulanishni amalga oshiradi.
5. **Gmail SMTP serveri xabarni qabul qiladi va IMAP/POP3 orqali foydalanuvchiga yetkazadi.**
6. **Xabar yetkazilgani haqida SMTP server `250 OK` javobini qaytaradi.**

## Xulosa
SMTP elektron pochta xabarlarini uzatish uchun ishlatiladigan asosiy protokoldir. U TCP/IP tarmog‘ida ishlaydi va DNS bilan integratsiyalashgan holda qabul qiluvchi serverni aniqlaydi. Shuningdek, SPF, DKIM va DMARC kabi xavfsizlik mexanizmlari bilan himoyalanadi. Pochta serverlari o‘rtasida muhim aloqa vositasi bo‘lib, zamonaviy elektron pochta tizimlarining asosi hisoblanadi.

