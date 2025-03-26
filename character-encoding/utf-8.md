# UTF-8 Haqida To'liq Ma'lumot

## UTF-8 Nima?
UTF-8 (8-bit Unicode Transformation Format) – bu Unicode belgilarini kodlash uchun eng keng tarqalgan standartlardan biridir. U o‘zgaruvchan uzunlikdagi kodlash tizimi bo‘lib, har bir belgi 1 dan 4 baytgacha o‘zgaruvchi uzunlikda ifodalanadi.

## UTF-8 Kelib Chiqishi
UTF-8 1993-yilda Ken Thompson va Rob Pike tomonidan ishlab chiqilgan. Uning asosiy maqsadi Unicode'ni samarali va ASCII bilan orqaga mos bo‘lgan tarzda kodlash edi.

## UTF-8 Ishlash Mexanizmi
UTF-8 har bir belgini 1 dan 4 baytgacha kodlaydi:
- **1 bayt** (7-bit ASCII) – 0xxxxxxx (0-127 oralig‘idagi belgilar)
- **2 bayt** – 110xxxxx 10xxxxxx
- **3 bayt** – 1110xxxx 10xxxxxx 10xxxxxx
- **4 bayt** – 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Misollar:
- **A (U+0041)** → `01000001` (1 bayt, ASCII bilan bir xil)
- **Б (U+0411)** → `11010000 10100001` (2 bayt)
- **€ (U+20AC)** → `11100010 10000010 10101100` (3 bayt)
- **𐍈 (U+10348)** → `11110000 10010000 10001101 10001000` (4 bayt)

## UTF-8 ning Afzalliklari
- **ASCII bilan moslik**: ASCII ning dastlabki 128 ta belgisi UTF-8 bilan bir xil.
- **Samaradorlik**: Ko‘pgina tillar uchun matnlarni saqlashda UTF-16 yoki UTF-32 ga nisbatan kamroq joy egallaydi.
- **Jahon standartiga aylangan**: Veb-sahifalar, fayllar va API lar uchun asosiy kodlash tizimi hisoblanadi.
- **Nozik xatolarga chidamlilik**: UTF-8 noto‘g‘ri kodlangan ma’lumotlarni oson aniqlash imkonini beradi.

## UTF-8 ning Amaliy Qo‘llanilishi
- **Veb-texnologiyalar**: HTML, XML, JSON kabi formatlarda kodlash uchun ishlatiladi.
- **Ma’lumotlar bazalari**: MySQL, PostgreSQL kabi bazalar UTF-8 ni qo‘llab-quvvatlaydi.
- **Dasturlash tillari**: Java, Python, JavaScript va boshqa ko‘plab tillar UTF-8 bilan ishlaydi.
- **Fayl tizimlari**: Linux va macOS tizimlari UTF-8 kodlashdan foydalanadi.

## UTF-8 va Boshqa Kodlash Tizimlari
| Kodlash turi | Bayt uzunligi | ASCII bilan moslik | Samaradorlik |
|-------------|--------------|------------------|-------------|
| ASCII      | 1 bayt       | Ha               | Juda yuqori |
| UTF-8      | 1-4 bayt     | Ha               | Yuqori |
| UTF-16     | 2 yoki 4 bayt| Yo‘q             | O‘rta |
| UTF-32     | 4 bayt       | Yo‘q             | Past |

## Xulosa
UTF-8 – bu Unicode kodlashning eng samarali, keng qo‘llaniladigan va ASCII bilan mos keladigan versiyasidir. U butun dunyo bo‘ylab matn kodlash standarti sifatida ishlatiladi va hozirgi zamon dasturlash hamda veb-texnologiyalarida asosiy rol o‘ynaydi.

