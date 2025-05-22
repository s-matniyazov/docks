# UTF-16 Haqida To‘liq Ma’lumot

## UTF-16 Nima?
UTF-16 (16-bit Unicode Transformation Format) — bu Unicode belgilarini kodlash uchun ishlatiladigan o‘zgaruvchan uzunlikdagi 16-bit kodlash formati. U ko‘pgina zamonaviy tizimlar va dasturlar tomonidan ishlatiladi, ayniqsa Windows operatsion tizimlarida va Java platformasida keng qo‘llaniladi.

## UTF-16 Kelib Chiqishi
UTF-16 Unicode standartining dastlabki versiyalaridan biri bo‘lib, 1993-yilda Unicode 2.0 bilan joriy etilgan. Dastlab, 16-bitli kodlash har bir belgi uchun yetarli deb hisoblangan, ammo keyinchalik qo‘shimcha kod oralig‘iga ehtiyoj tug‘ilganda, UTF-16 kengaytirildi.

## UTF-16 Ishlash Mexanizmi
UTF-16 kodlash tizimi har bir belgini 16 bit (2 bayt) yoki 32 bit (4 bayt) bilan ifodalaydi:

1. **Basic Multilingual Plane (BMP)**: Unicode’dagi dastlabki 65,536 ta belgi (U+0000 dan U+FFFF gacha) oddiy 16-bitli (2 bayt) formatda saqlanadi.
2. **Supplementary Planes**: 65,536 dan yuqori bo‘lgan kod nuqtalari (U+10000 va undan yuqori) 4 baytlik "surrogate pair" texnikasi yordamida kodlanadi.

### Surrogate Pair (Ekilamchi juftlik)
Agar Unicode belgisi 16-bit diapazondan tashqarida bo‘lsa (U+10000 va undan yuqori), u ikki 16-bitli bo‘lak (surrogate pair) shaklida kodlanadi:
- Yuqori bo‘lak (high surrogate): U+D800 dan U+DBFF gacha
- Pastki bo‘lak (low surrogate): U+DC00 dan U+DFFF gacha

Misol:
- Unicode belgisi: `U+1F600` (😀)
- Surrogate pair ko‘rinishi: `U+D83D U+DE00`

## UTF-16 ning Afzalliklari va Kamchiliklari

### Afzalliklari:
- **Ko‘p tillarni qo‘llab-quvvatlaydi** – Unicode’dagi deyarli barcha belgilarni kodlay oladi.
- **Ko‘pgina tizimlarda qo‘llaniladi** – Windows, Java, .NET platformalarida asosiy kodlash usuli sifatida ishlatiladi.
- **Ma'lum belgilarga tezkor kirish** – Ko‘p hollarda belgilarni hisoblash UTF-8 ga qaraganda osonroq bo‘ladi.

### Kamchiliklari:
- **Hajmi kattaroq bo‘lishi mumkin** – ASCII belgilarini kodlashda UTF-8 dan kattaroq joy egallaydi.
- **Endianness muammosi** – Big-endian va Little-endian formatlari mavjud bo‘lib, ba'zan muvofiqlik muammolari paydo bo‘lishi mumkin.
- **Ba’zi tizimlar bilan mos emas** – UTF-8 global standart bo‘lib borgan sari UTF-16 kamroq qo‘llanilmoqda.

## UTF-16 va Boshqa Kodlash Formatlari Taqqoslanishi

| Xususiyat | UTF-16 | UTF-8 | UTF-32 |
|-----------|--------|-------|--------|
| Hajm | O‘rtacha (2 yoki 4 bayt) | O‘zgaruvchan (1-4 bayt) | Katta (4 bayt) |
| ASCII bilan moslik | Yo‘q | Ha | Yo‘q |
| Ko‘p tillarni qo‘llab-quvvatlash | Ha | Ha | Ha |
| Belgilarga tezkor kirish | O‘rtacha | Sekinroq | Tez |

## UTF-16 Amaliy Qo‘llanilishi
- **Windows operatsion tizimi**: Ichki kodlash formati sifatida ishlatiladi.
- **Java va .NET**: Standart String formati sifatida ishlatiladi.
- **XML va JSON formatlari**: Ba'zan UTF-16 kodlash bilan saqlanadi.

## Xulosa
UTF-16 — bu Unicode’ni kodlashning samarali usullaridan biri bo‘lib, ayniqsa Windows va Java platformalarida keng qo‘llaniladi. U o‘zgaruvchan uzunlikdagi formatga ega bo‘lib, ASCII belgilariga nisbatan hajmi kattaroq bo‘lsa-da, ko‘p tillarni qo‘llab-quvvatlash va samarali ishlash imkoniyatini taqdim etadi. Shu bilan birga, endianness muammolari va UTF-8 ning keng tarqalganligi sababli, hozirgi kunda ba'zi hollarda kamroq qo‘llanilmoqda.