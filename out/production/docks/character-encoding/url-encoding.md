# URL Encoding Haqida To'liq Ma'lumot

## URL Encoding Nima?
URL Encoding (yoki Percent-Encoding) — bu URL (Uniform Resource Locator) ichida ishlatilishi mumkin bo‘lmagan yoki maxsus ma’noga ega bo‘lgan belgilarni kodlash usuli. Bu usul, asosan, HTTP so‘rovlarida, veb-brauzerlarda va boshqa URL asosida ishlovchi tizimlarda ishlatiladi.

## URL Encoding Nima Uchun Kerak?
Ba’zi belgilar URL ichida maxsus ma’noga ega bo‘lib, ularni bevosita ishlatish noto‘g‘ri natijalarga olib kelishi mumkin. Masalan:
- `?` va `&` belgilari URL parametrlarini ajratish uchun ishlatiladi.
- `=` belgisi kalit-qiymat juftliklarini bog‘lash uchun qo‘llaniladi.
- Bo‘sh joy (space) belgilari ba’zan noto‘g‘ri interpretatsiya qilinishi mumkin.

Shuning uchun, ushbu belgilar URL Encoding orqali maxsus kodlar bilan almashtiriladi.

## URL Encoding Qanday Ishlaydi?
URL Encoding ASCII kodlash tizimidan foydalanadi. Har bir maxsus belgi `%` belgisi bilan boshlanuvchi ikki xonali o‘n oltilik (hexadecimal) kodga almashtiriladi.

### Eng Ko‘p Ishlatiladigan Kodlangan Belgilar:

| Belgi | URL Encoded |
|--------|-------------|
| Space  | `%20`       |
| !      | `%21`       |
| #      | `%23`       |
| $      | `%24`       |
| &      | `%26`       |
| +      | `%2B`       |
| /      | `%2F`       |
| :      | `%3A`       |
| =      | `%3D`       |
| ?      | `%3F`       |
| @      | `%40`       |

### Misol:
Agar biz quyidagi URL parametrlarini uzatmoqchi bo‘lsak:
```
https://example.com/search?query=hello world&lang=en
```
U holda bo‘sh joy (` `) `%20` bilan almashtirilishi kerak:
```
https://example.com/search?query=hello%20world&lang=en
```

## URL Encoding ning Amaliy Ishlatilishi
1. **HTTP GET so‘rovlarida**
  - URL orqali ma’lumot jo‘natishda ishlatiladi.
2. **Ma’lumotlar xavfsizligini ta’minlash**
  - Ba’zi maxsus belgilar noto‘g‘ri interpretatsiya qilinishining oldini oladi.
3. **Veb-formalardagi ma’lumotlarni kodlash**
  - Brauzer foydalanuvchi kiritgan ma’lumotlarni avtomatik ravishda kodlaydi.

## URL Decoding
Kodlangan URL’ni asl holatiga qaytarish jarayoni URL Decoding deb ataladi. Bu jarayon, odatda, veb-server yoki dasturlar tomonidan avtomatik ravishda bajariladi.

### Decoding Misoli:
Kodlangan URL:
```
https://example.com/page?name=John%20Doe
```
Decoding natijasi:
```
https://example.com/page?name=John Doe
```

## Xulosa
URL Encoding maxsus belgilarni xavfsiz tarzda URL ichida ishlatish imkonini beradi. Bu usul veb-ishlab chiqishda muhim rol o‘ynaydi va noto‘g‘ri interpretatsiya yoki xatoliklarning oldini olish uchun qo‘llaniladi.

