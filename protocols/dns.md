# DNS (Domain Name System) Haqida To'liq Ma'lumot

## DNS Nima?
DNS (Domain Name System) – bu domen nomlarini IP-manzillarga tarjima qiluvchi tizim bo‘lib, internetning asosiy infratuzilmalaridan biridir. Bu tizim tufayli foydalanuvchilar domen nomlarini (masalan, `example.com`) kiritish orqali veb-saytlarga kira oladilar, IP-manzillarni eslab qolish shart emas.

## DNS Ishlash Mexanizmi
1. **Domen nomi kiritilishi**: Foydalanuvchi brauzerga `example.com` domen nomini kiritadi.
2. **DNS so‘rovi yuborilishi**: Brauzer DNS serverga so‘rov yuboradi va `example.com` domenining IP-manzilini so‘raydi.
3. **Keşni tekshirish**: Brauzer yoki operatsion tizim oldin so‘ralgan ma’lumotni keşda (cache) saqlagan bo‘lsa, u to‘g‘ridan-to‘g‘ri shu IP-manzilni ishlatadi.
4. **Root DNS serverga murojaat**: Agar kešda ma’lumot topilmasa, so‘rov DNS hierarxiyasi bo‘ylab yuqoriga, avval root DNS serverlariga yuboriladi.
5. **Top-Level Domain (TLD) server javobi**: Root DNS server `.com`, `.net`, `.org` kabi yuqori darajali domenlar uchun javobgar bo‘lgan TLD DNS serverga yo‘naltiradi.
6. **Authoritative DNS serverga murojaat**: TLD DNS server, o‘z navbatida, `example.com` ning authoritative DNS serveriga so‘rov yuboradi.
7. **IP-manzil olish**: Authoritative DNS server veb-saytning haqiqiy IP-manzilini qaytaradi.
8. **Brauzer sahifani yuklaydi**: Brauzer IP-manzilni olgandan so‘ng, unga HTTP yoki HTTPS so‘rovi yuboradi va veb-sahifani yuklaydi.

## DNS Tuzilishi
DNS bir nechta darajali serverlardan iborat:
- **Root DNS Serverlar**: Barcha yuqori darajali domenlarni boshqaradi.
- **TLD (Top-Level Domain) Serverlar**: Masalan, `.com`, `.net`, `.org` kabi domenlarni boshqaradi.
- **Authoritative DNS Serverlar**: Muayyan domen nomlariga tegishli IP-manzillarni saqlaydi.

## DNS Yozuvlari (Records)
DNS serverlarida turli xil yozuvlar mavjud:
- **A Record (Address Record)**: Domen nomini IPv4 manzilga bog‘laydi.
- **AAAA Record**: Domen nomini IPv6 manzilga bog‘laydi.
- **CNAME (Canonical Name Record)**: Bir domenni boshqasiga bog‘laydi (masalan, `www.example.com` -> `example.com`).
- **MX Record (Mail Exchange Record)**: Elektron pochta serverining manzilini belgilaydi.
- **TXT Record**: Har qanday matnli ma’lumotni saqlash uchun ishlatiladi, masalan SPF va DKIM tekshiruvlari uchun.

## DNS Cache va Uning Rolini
DNS so‘rovlarining har safar yuqori darajali serverlarga yuborilishi tarmoq yukini oshiradi. Shuning uchun DNS keşi ishlatiladi:
- **Brauzer cache**: Foydalanuvchining brauzerida vaqtincha saqlanadi.
- **Operatsion tizim cache**: DNS so‘rovlarini operatsion tizim darajasida saqlaydi.
- **ISP (Internet Service Provider) cache**: Internet provayderlarining DNS serverlarida keşlash jarayoni amalga oshiriladi.

## DNS Turlari
- **Recursive DNS Resolver**: Foydalanuvchidan kelgan so‘rovlarni iterativ ravishda hal qiladi.
- **Authoritative DNS Server**: Muayyan domen nomi uchun IP-manzillarni saqlaydi.
- **Forwarding DNS Server**: So‘rovlarni boshqa DNS serverga uzatadi.

## DNS va Xavfsizlik
DNS tizimi kiberxavfsizlik tahdidlariga duch kelishi mumkin:
- **DNS Spoofing (DNS Poisoning)**: Hujumchi DNS serverni buzib, noto‘g‘ri IP-manzilni qaytarishi mumkin.
- **DDoS hujumi**: Ko‘p sonli so‘rovlar yuborish orqali DNS serverni ishdan chiqarishga urinish.
- **DNSSEC (DNS Security Extensions)**: DNS so‘rovlarini autentifikatsiya qilish va ma’lumotlarni himoyalash uchun ishlatiladi.

## Xulosa
DNS internetning ajralmas qismi bo‘lib, foydalanuvchilar uchun domen nomlarini IP-manzillarga tarjima qilishni avtomatlashtiradi. DNS tizimi keşlash, xavfsizlik choralari va hierarxik tuzilish orqali samarali ishlaydi. DNS protokolining muhimligi va uni xavfsiz saqlash usullari internet infratuzilmasining barqaror ishlashiga katta hissa qo‘shadi.

