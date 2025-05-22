# Java String Pool

## 1. String Pool nima?
Java'da **String Pool** – bu **Heap** xotirasining maxsus qismi bo‘lib, unda **String literal** obyektlari saqlanadi. **String intern mechanism** yordamida Java takroriy stringlarni oldini olish va xotira sarfini optimallashtirish uchun String Pool-dan foydalanadi.

## 2. String Pool qanday ishlaydi?
- Har safar yangi **String literal** yaratganda, JVM avval **String Pool** ni tekshiradi.
- Agar **bir xil qiymatga ega String** mavjud bo‘lsa, yangi obyekt yaratmaydi, balki mavjud string obyektini qaytaradi.
- Agar string **String Pool** da mavjud bo‘lmasa, u **Heap** xotirasida yaratiladi va **String Pool** ga qo‘shiladi.

### Misol:
```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2); // true, chunki ikkalasi ham String Pool'ni ishlatadi
```

## 3. `new String()` orqali obyekt yaratish
Agar `new String("Hello")` kabi konstruktor orqali string yaratilsa, **Heap** xotirasida yangi obyekt yaratiladi va u **String Pool** ga qo‘shilmaydi.

```java
String s1 = new String("Hello");
String s2 = "Hello";
System.out.println(s1 == s2); // false, chunki s1 Heap'da, s2 esa String Pool'da
```

## 4. `intern()` metodi
Agar **Heap** da yaratilgan **String obyektini** **String Pool** ga qo‘shmoqchi bo‘lsak, `intern()` metodidan foydalanamiz.

```java
String s1 = new String("Hello");
String s2 = s1.intern();
String s3 = "Hello";
System.out.println(s2 == s3); // true, chunki ikkalasi ham String Pool'da
```

## 5. String Pool afzalliklari
✔ **Xotira tejash** – bir xil qiymatli stringlar qayta foydalaniladi.
✔ **Tezkor ishlash** – stringlarni taqqoslash (`==`) tezroq bo‘ladi, chunki obyekt xotira manzili bo‘yicha solishtiriladi.

## 6. Xulosa
- **String Pool** Java tomonidan xotira sarfini optimallashtirish uchun ishlatiladi.
- **String literal** obyektlari avtomatik ravishda String Pool'ga tushadi.
- **`new String()`** ishlatilsa, obyekt Heap'da yaratiladi va avtomatik String Pool'ga tushmaydi.
- **`intern()`** orqali String Pool ga qo‘shish mumkin.

Bu usuldan foydalanish Java dasturlarining samaradorligini oshirishga yordam beradi!

