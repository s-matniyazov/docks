# FTP (File Transfer Protocol)

## FTP Nima?
FTP (File Transfer Protocol) – bu fayllarni server va mijoz o‘rtasida uzatish uchun ishlatiladigan tarmoq protokoli. U TCP/IP protokollar to‘plamining bir qismi bo‘lib, **port 21** orqali ishlaydi.

## FTP Ishlash Printsipi
FTP mijoz va server o‘rtasidagi aloqani ta’minlaydi. U ikkita asosiy ulanish rejimiga ega:
1. **Nazorat kanali (Control Channel)** – Buyruqlar va javoblar almashinuvi uchun.
2. **Ma’lumot kanali (Data Channel)** – Fayllarni uzatish uchun.

## FTP Ishlash Turlari
FTP ikkita turda ishlaydi:
1. **Active Mode (Faol rejim)**
  - Mijoz serverga bog‘lanadi va server mijozning portiga ma’lumot yuboradi.
  - NAT (Network Address Translation) tufayli ba’zan firewall muammolari yuzaga kelishi mumkin.

2. **Passive Mode (Passiv rejim)**
  - Server mijozga qaysi portdan foydalanish kerakligini aytadi va mijoz ulanishni o‘rnatadi.
  - Bu rejim firewall bilan mos keladi va hozirgi kunda ko‘proq qo‘llaniladi.

## FTP va Firewall Muammolari
Firewall FTP ulanishiga ta’sir qilishi mumkin, ayniqsa **Active Mode** rejimida. Asosiy muammolar quyidagilar bo‘lishi mumkin:
- **Active Mode da mijozning ichki tarmoqda bo‘lishi** – Server mijozning ochiq portiga qayta bog‘lanishi kerak, lekin mijozning ichki tarmoq yoki NAT ortida bo‘lishi bu bog‘lanishga to‘sqinlik qilishi mumkin.
- **Dinamik portlar** – FTP **ma’lumot kanali** dinamik portlardan foydalanadi, bu esa firewall tomonidan bloklanishi mumkin.
- **FTP filtratsiyasi** – Ba’zi xavfsizlik devorlari FTP so‘rovlarini tekshiradi va ma’lum bir konfiguratsiya talab qiladi.
- **Passive Mode ishlamasligi** – Agar serverning **passiv rejimdagi portlari** firewall orqali ruxsat berilmagan bo‘lsa, ulanish muvaffaqiyatsiz bo‘lishi mumkin.

Firewall muammolarini hal qilish uchun quyidagilar tavsiya etiladi:
- **Passive Mode ishlatish** – NAT va firewall muammolarini kamaytiradi.
- **FTP serverda statik passiv portlar belgilash** – Firewallda ushbu portlarga ruxsat berish mumkin bo‘ladi.
- **FTP ALG (Application Layer Gateway) ni yoqish** – Ba’zi routerlar FTP ulanishlarini boshqarish uchun ushbu xususiyatga ega.

## FTP Buyruqlari
FTP mijoz va server o‘rtasidagi aloqa quyidagi buyruqlar yordamida amalga oshiriladi:

| Buyruq  | Tavsif |
|---------|--------|
| `USER`  | Foydalanuvchi nomini kiritish |
| `PASS`  | Parolni kiritish |
| `LIST`  | Joriy katalogni ko‘rsatish |
| `RETR`  | Faylni yuklab olish |
| `STOR`  | Faylni yuklash |
| `DELE`  | Faylni o‘chirish |
| `MKD`   | Yangi katalog yaratish |
| `CWD`   | Katalogni o‘zgartirish |
| `QUIT`  | Ulanishni yopish |

## FTP Xavfsizligi
FTP oddiy matn rejimida parollarni jo‘natishi sababli, xavfsizlik nuqtayi nazaridan kamchiliklarga ega. Shu sababli quyidagi xavfsiz alternativalar qo‘llaniladi:
- **FTPS (FTP Secure)** – TLS/SSL orqali shifrlangan FTP.
- **SFTP (SSH File Transfer Protocol)** – SSH ustida ishlaydigan xavfsiz fayl uzatish protokoli.

## FTP-dan Foydalanish
### Linux da FTP mijozidan foydalanish
```bash
ftp ftp.example.com
```
Foydalanuvchi nomi va parol kiritilgandan so‘ng, buyruqlar yordamida server bilan ishlash mumkin.

### Python orqali FTP ulanishi
```python
from ftplib import FTP

ftp = FTP('ftp.example.com')
ftp.login(user='username', passwd='password')
ftp.dir()
ftp.quit()
```

## Xulosa
FTP fayllarni server va mijoz o‘rtasida almashish uchun ishlatiladi. Biroq, u xavfsizlik nuqtayi nazaridan zaif bo‘lishi mumkin, shuning uchun FTPS yoki SFTP kabi xavfsiz protokollar ko‘proq qo‘llaniladi.

