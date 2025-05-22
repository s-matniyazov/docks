# TCP/IP Protokollar To'plami

## TCP/IP Nima?
TCP/IP (Transmission Control Protocol / Internet Protocol) – bu kompyuter tarmoqlarida ma'lumotlarni uzatish uchun ishlatiladigan asosiy protokollar to‘plamidir. U internet va lokal tarmoqlarda keng qo‘llaniladi.

## TCP/IP Arxitekturasi
TCP/IP to‘plami **4 ta asosiy** qatlamdan iborat:

1. **Tarmoq interfeysi (Network Interface)**
  - Fizik va ma'lumot bog‘lash darajasidagi uzatishlarni boshqaradi.
  - Ethernet, Wi-Fi, DSL kabi texnologiyalarni qo‘llab-quvvatlaydi.

2. **Internet qatlami (Internet Layer)**
  - Ma'lumotlarni bir tarmoqdan boshqasiga yo‘naltirishni boshqaradi.
  - **IP (Internet Protocol)** asosiy protokol bo‘lib, manzilga yetkazish uchun ishlatiladi.
  - ICMP (ping kabi diagnostika vositalari) va ARP (manzillarni tarmoq interfeysi bilan bog‘lash) ham shu qismga kiradi.

3. **Transport qatlami (Transport Layer)**
  - Ma'lumotlar ishonchli yoki ishonchsiz tarzda uzatilishini ta'minlaydi.
  - **TCP (Transmission Control Protocol)** – ishonchli ulanishlarni ta’minlaydi, ma'lumotlar butunligini saqlaydi.
  - **UDP (User Datagram Protocol)** – tezkor, ammo ishonchsiz ma'lumot uzatish uchun ishlatiladi.

4. **Ilova qatlami (Application Layer)**
  - Tizimdagi dasturlar foydalanadigan protokollarni o‘z ichiga oladi.
  - HTTP/HTTPS (veb), FTP (fayl uzatish), SMTP/POP3/IMAP (elektron pochta), DNS (domen nomlarini IP manzillarga bog‘lash) shular jumlasidandir.

## IP (Internet Protocol)
IP (Internet Protocol) – bu tarmoq orqali paketlarni manzilga yetkazish uchun ishlatiladigan asosiy protokol.
IP ning asosiy vazifalari:
- **Manzillash**: Har bir qurilmaga noyob IP manzilni tayinlash.
- **Yo‘naltirish (Routing)**: Paketlarni kerakli yo‘nalish bo‘ylab yetkazish.
- **Fragmentatsiya va yig‘ish**: Katta ma'lumotlarni mayda paketlarga bo‘lish va qabul qiluvchi tomonda qayta yig‘ish.

IP ning ikki asosiy versiyasi mavjud:
1. **IPv4**: 32-bitli manzillash, masalan, `192.168.1.1`.
2. **IPv6**: 128-bitli manzillash, masalan, `2001:db8::ff00:42:8329`.

IPv6 IPv4 ga nisbatan ko‘proq manzillar maydonini ta’minlaydi va xavfsizlikni oshiradi.

## TCP (Transmission Control Protocol)
TCP – transport qatlami protokoli bo‘lib, ma'lumotlarning ishonchli yetkazilishini ta’minlaydi.
TCP ning asosiy xususiyatlari:
- **Ulanishga yo‘naltirilganlik**: TCP ikki tomonlama ulanish o‘rnatadi.
- **Ma'lumotlarni ketma-ket yetkazish**: Paketlarning noto‘g‘ri tartibda yetib kelishining oldini oladi.
- **Qayta uzatish**: Yo‘qolgan paketlar avtomatik qayta yuboriladi.
- **Flow Control**: Tarmoqning ortiqcha yuklanishining oldini oladi.

### TCP Ishlash Mexanizmi
TCP ma'lumotlarni **segmentlarga** bo‘lib uzatadi va quyidagi bosqichlarni amalga oshiradi:

1. **Ulanish o‘rnatish (Three-Way Handshake)**
  - Mijoz (Client) serverga **SYN** xabarini yuboradi.
  - Server **SYN-ACK** javobini qaytaradi.
  - Mijoz **ACK** yuboradi va ulanish o‘rnatiladi.

2. **Ma'lumot uzatish**
  - TCP segmentlarini jo‘natadi, qabul qiluvchi ularni tasdiqlaydi.
  - Agar segment yo‘qolsa, qayta yuborish amalga oshiriladi.

3. **Ulanishni yopish (Four-Way Handshake)**
  - Mijoz **FIN** yuboradi.
  - Server **ACK** qaytaradi.
  - Server ham **FIN** yuboradi.
  - Mijoz **ACK** qaytaradi va ulanish yopiladi.

## UDP (User Datagram Protocol) Ishlash Mexanizmi
UDP – transport qatlami protokoli bo‘lib, ma'lumotlarni tezkor va minimal kechikish bilan uzatish uchun ishlatiladi. UDP ishonchsiz, chunki u paketlar yetkazilganligini tekshirmaydi va ularni qayta yubormaydi.

### UDP ning asosiy xususiyatlari:
- **Ulanishsiz protokol** – Oldindan ulanish o‘rnatish talab etilmaydi.
- **Ishonchsiz** – Paketlar yo‘qolishi yoki tartibda kelmasligi mumkin.
- **Tezkorlik** – Qo‘shimcha nazorat mexanizmlari yo‘qligi sababli tezroq ishlaydi.
- **Kamroq tarmoq yuklanishi** – Kontrollar kamligi sababli tarmoqdan kam foydalanadi.

### UDP Ishlash Bosqichlari
1. Dastur UDP orqali ma'lumotni **datagram** shaklida jo‘natadi.
2. Paketlar tarmoq orqali qabul qiluvchi tomonning IP va portiga yo‘naltiriladi.
3. Qabul qiluvchi tomon o‘z portida ma’lumotni qabul qiladi.
4. Agar paket yo‘qolsa yoki buzilsa, UDP uni qayta yubormaydi.

### UDP Ishlatish Sohaari
- **VoIP (Voice over IP)** – Real vaqt rejimidagi ovozli qo‘ng‘iroqlar.
- **Video Streaming** – YouTube, Netflix kabi platformalarda video uzatish.
- **Onlayn o‘yinlar** – Past kechikish talab qiluvchi multiplayer o‘yinlar.
- **DNS so‘rovlari** – Tezkor javob talab qiluvchi domen nomlari tizimi.

## TCP va UDP farqlari

| Xususiyat | TCP | UDP |
|-----------|-----|-----|
| Ulanish turi | Ulanishga yo‘naltirilgan | Ulanishsiz |
| Ishonchlilik | Ishonchli, qayta uzatish mavjud | Ishonchsiz, yo‘qolgan paketlar tiklanmaydi |
| Paket tartibi | Tartib bilan yetkaziladi | Tartib kafolatlanmaydi |
| Ishlash tezligi | Sekinroq, chunki qo‘shimcha boshqaruv paketlari bor | Tezroq, chunki qo‘shimcha boshqaruv yo‘q |
| Qo‘llanishi | Veb, elektron pochta, fayl uzatish | Ovoz, video striming, real-vaqt o‘yinlar |

## Xulosa
TCP va UDP tarmoq protokollari bo‘lib, har biri turli maqsadlarda ishlatiladi. TCP ishonchli va ketma-ket yetkazish talab qilinadigan holatlarda qo‘llaniladi, UDP esa real vaqt tizimlarida tezlikni oshirish uchun ishlatiladi.

