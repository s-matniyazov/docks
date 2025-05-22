# Base64 Haqida To‘liq Ma’lumot

## Base64 Nima?
Base64 – bu ikkilik (binary) ma'lumotlarni faqat ASCII belgilaridan iborat bo‘lgan matnga aylantirish uchun ishlatiladigan kodlash usuli. Asosan, internet orqali xavfsiz va muammosiz ma'lumot uzatish, shifrlash va saqlash uchun qo‘llaniladi.

## Base64 Kelib Chiqishi
Base64 kodlash usuli dastlab elektron pochta protokollari (MIME - Multipurpose Internet Mail Extensions) uchun ishlab chiqilgan. MIME orqali ikkilik fayllarni (rasmlar, hujjatlar) matn shaklida jo‘natish kerak bo‘lganida Base64 dan foydalanilgan. Hozirda esa, bu kodlash usuli JWT (JSON Web Token), URL kodlash, ma'lumotlar bazalarida shifrlash, hamda boshqa ko‘plab sohalarda ishlatiladi.

## Base64 Ishlash Mexanizmi
Base64 kodlash jarayoni quyidagi bosqichlardan iborat:
1. **Ma'lumotlarni 6-bitli bo‘laklarga ajratish:**
  - Kompyuterlar ma'lumotlarni odatda 8-bit (1 bayt) shaklida saqlaydi.
  - Base64 esa har bir baytni 6-bitli bo‘laklarga ajratib kodlaydi.
2. **Kodlash uchun ASCII belgilaridan foydalanish:**
  - Har bir 6-bitli bo‘lakni maxsus Base64 jadvalidagi mos harf yoki belgi bilan almashtiradi.
3. **To‘ldiruvchi belgilardan foydalanish (`=`):**
  - Agar ma'lumot uzunligi 3 baytga bo‘linmasa, oxirida `=` belgisi bilan to‘ldiriladi.

### Base64 Kodlash Jadvali
Base64 64 ta belgidan iborat jadvalga asoslanadi:

| Belgilar | Diapazon |
|----------|---------|
| A-Z      | 0-25    |
| a-z      | 26-51   |
| 0-9      | 52-61   |
| + /      | 62-63   |
| =        | To‘ldiruvchi belgi |

### Misol
**Matn:** `Man`

1. **ASCII kodga aylantirish:**
  - `M` = 77 (01001101)
  - `a` = 97 (01100001)
  - `n` = 110 (01101110)
2. **6-bitli bo‘laklarga ajratish:**
  - `010011` `010110` `000101` `101110`
3. **Base64 belgilariga o‘girish:**
  - `010011` → `T`
  - `010110` → `W`
  - `000101` → `F`
  - `101110` → `u`

**Natija:** `TWFu`

## Base64 ning Afzalliklari va Kamchiliklari

### Afzalliklari:
- **ASCII formatida ma'lumot uzatish imkoniyati:** Internet orqali binar ma'lumotlarni matn sifatida jo‘natish qulay bo‘ladi.
- **Muammosiz kodlash va dekodlash:** Deyarli barcha dasturlash tillarida Base64 funksiyalari mavjud.
- **Shifrlash bilan bog‘liq foydalanish:** JWT, HTTP Basic Authentication va XML shifrlash jarayonlarida qo‘llaniladi.

### Kamchiliklari:
- **Fayl hajmini oshiradi:** Har 3 bayt ma'lumot 4 ta Base64 belgiga kodlanadi, ya'ni hajmi taxminan 33% ga oshadi.
- **Shifrlash emas:** Base64 faqat kodlash usuli bo‘lib, xavfsizlikni ta'minlamaydi.

## Base64 ning Amaliy Qo‘llanilishi
- **Elektron pochta orqali fayllarni yuborish (MIME kodlash).**
- **JWT (JSON Web Token) da ma'lumotlarni kodlash.**
- **URL-kodlash va HTTP autentifikatsiyada foydalanish.**
- **XML va JSON ma'lumotlarini shifrlash.**

## Base64 va Boshqa Kodlash Usullari Taqqoslash
| Xususiyat | Base64 | HEX | UTF-8 |
|-----------|--------|-----|------|
| Hajm oshishi | 33% | 100% | O‘zgaruvchan |
| O‘qish qulayligi | O‘rta | Yuqori | Yuqori |
| Internet uchun moslik | Yuqori | Past | Yuqori |
| ASCII bilan mosligi | Ha | Yo‘q | Ha |

## Xulosa
Base64 – bu matn kodlash usuli bo‘lib, ikkilik ma'lumotlarni ASCII formatida saqlash va uzatishga imkon beradi. U shifrlash uchun mo‘ljallanmagan bo‘lsa ham, ko‘plab zamonaviy dasturiy ta’minotlarda keng qo‘llaniladi. Ammo, hajmni oshirishi sababli, ma'lumotni uzatishdan oldin ushbu omilni hisobga olish kerak.

