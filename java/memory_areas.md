# Java Memory Area

Java dasturlari ishga tushirilganda, JVM (Java Virtual Machine) xotirani turli qismlarga ajratadi. Java xotira sohasi beshta asosiy qismdan iborat:

1. **Heap Area**
2. **Method Area**
3. **JVM Stack**
4. **Native Method Stack**
5. **PC (Program Counter) Registers**

---

## 1. Heap Area
**Heap Area** – bu eng katta xotira sohasi bo‘lib, barcha obyektlar va ma’lumotlar dinamik ravishda yaratiladi. JVM ushbu xotirani avtomatik ravishda boshqaradi va **Garbage Collector (GC)** orqali foydalanilmayotgan obyektlarni tozalaydi.

### Heapning asosiy qismlari:
- **Young Generation**
    - **Eden Space** – yangi obyektlar shu yerda yaratiladi.
    - **Survivor Spaces (S0, S1)** – GC tomonidan omon qolgan obyektlar shu joyga o‘tkaziladi.
- **Old Generation (Tenured Space)** – uzoq yashaydigan obyektlar saqlanadi.
- **Metaspace** – class metadata va boshqa JVM ma’lumotlari saqlanadi.


## 2. Method Area
**Method Area** – JVM ning doimiy ma’lumotlar saqlanadigan xotira sohasi. Bu hududda quyidagi ma’lumotlar saqlanadi:
- Class ma’lumotlari (Field, Method va Static o‘zgaruvchilar)
- Runtime Constant Pool (String Pool va boshqa konstantalar)
- Method bytecode

**Java 8 versiyasidan boshlab** Method Area **Metaspace** bilan almashtirilgan va u endi operatsion tizim tomonidan boshqariladi.


## 3. JVM Stack
**JVM Stack** har bir ishga tushirilgan tanga (thread) uchun yaratiladigan stack bo‘lib, metod chaqiruvlari va mahalliy o‘zgaruvchilarni saqlaydi.

Har bir metod chaqirilganda **Stack Frame** hosil bo‘ladi va quyidagi ma’lumotlarni o‘z ichiga oladi:
- Mahalliy o‘zgaruvchilar
- Operatsiya steki
- Metodning qaytish manzili

Agar stack cheklangan o‘lchamdan oshib ketsa, **StackOverflowError** yuzaga keladi.


## 4. Native Method Stack
**Native Method Stack** – bu **Java Native Interface (JNI)** orqali ishlaydigan mahalliy (C/C++) kodlarni saqlash uchun ishlatiladigan maxsus xotira hududi.

Agar **native method stack** haddan tashqari to‘lib ketsa, **OutOfMemoryError** sodir bo‘lishi mumkin.


## 5. PC Registers
**PC (Program Counter) Registers** – har bir ishga tushirilgan tanga (thread) uchun yaratiladigan maxsus register bo‘lib, joriy bajarilayotgan buyruqning manzilini saqlaydi.

Agar metod **native method** bo‘lsa, PC registerda **aniq manzil yo‘q** bo‘ladi.

---

## Xulosa
Java dasturining ishlash jarayonida xotira quyidagi qismlarga bo‘linadi:
1. **Heap Area** – obyektlar uchun asosiy xotira.
2. **Method Area** – class va metod ma’lumotlarini saqlaydi.
3. **JVM Stack** – metod chaqiruvlarini va mahalliy o‘zgaruvchilarni saqlaydi.
4. **Native Method Stack** – Java’dan tashqarida ishlaydigan kodlarni qo‘llab-quvvatlaydi.
5. **PC Registers** – joriy bajarilayotgan bayt-kodni kuzatadi.

Ushbu xotira tuzilmalari **JVM ishlash samaradorligini** ta’minlashda muhim rol o‘ynaydi. Har bir qismining to‘g‘ri boshqarilishi dastur barqarorligi va tezkor ishlashiga yordam beradi.

