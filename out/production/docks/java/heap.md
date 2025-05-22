# Java Heap Tuzilishi

## 1. Java Heap Overview
Java heap xotirasi JVM tomonidan ajratilgan va boshqariladigan asosiy xotira bo'lib, unda obyektlar va ma'lumotlar saqlanadi.
Heap xotira avtomatik ravishda **Garbage Collector (GC)** tomonidan boshqariladi va quyidagi asosiy qismlarga bo'linadi:

- **Young Generation (Yosh avlod)**
- **Old Generation (Eski avlod)**
- **Metaspace (Metama'lumotlar maydoni)**

---

## 2. Java Heap Qismlari

### 2.1 Young Generation (Yosh avlod)
**Yosh avlod** yangi yaratilgan obyektlarni saqlaydi. U quyidagi bo‘limlardan iborat:

- **Eden Space** – yangi obyektlar dastlab shu yerda yaratiladi.
- **Survivor Spaces (S0 va S1)** – GC jarayonidan omon qolgan obyektlar vaqtincha shu joyga o'tkaziladi.

> **Garbage Collection (Minor GC)**
> Eden to‘lganda Minor GC ishga tushadi va ishlatilmayotgan obyektlarni o‘chirib tashlaydi. Omon qolgan obyektlar Survivor Space-ga o'tkaziladi.

### 2.2 Old Generation (Eski avlod)
Agar obyekt **Survivor Space** da yetarlicha vaqt saqlansa, u **Old Generation** ga o'tkaziladi.
Bu joy uzoq umr ko‘radigan obyektlarni saqlash uchun ishlatiladi.

> **Garbage Collection (Major GC / Full GC)**
> Old Generation to‘lganda Major GC yoki Full GC ishga tushadi. Bu jarayon odatda sekinroq va ko'proq tizim resurslarini talab qiladi.

### 2.3 Metaspace
Java 8 versiyasidan boshlab **Metaspace** **PermGen** (Permanent Generation) o‘rnini egalladi. Bu bo‘lim **klass ma’lumotlari, metodlar, refleksiya ma’lumotlari va JVM ichki tuzilmalari** saqlanadigan joy hisoblanadi.

#### Metaspace Xususiyatlari:
- **Dinamik kengayish** – JVM kerak bo‘lganda Metaspace hajmini oshirishi yoki kamaytirishi mumkin.
- **PermGen’dan farqi** – PermGen oldindan belgilangan maksimal hajmga ega edi, Metaspace esa OS tomonidan boshqariladi.
- **GC orqali boshqarish** – Keraksiz klass ma’lumotlari GC tomonidan tozalanadi.

#### Metaspace da saqlanadigan ma’lumotlar:
- **Class metadata** – Yangi yuklangan klasslarning ma’lumotlari.
- **Method metadata** – Metodlarning tavsiflari va kompilyatsiya qilingan kodlari.
- **Reflection objects** – Refleksiya orqali yaratilgan obyektlar.
- **JVM ichki ma’lumotlari** – Java Virtual Machine ichki tuzilmalari uchun kerak bo‘lgan ma’lumotlar.

#### Metaspace Xotira Cheklovlari va Sozlash
Metaspace hajmini cheklash yoki optimallashtirish uchun quyidagi JVM bayroqlari ishlatiladi:

```sh
-XX:MetaspaceSize=128m   # Dastlabki hajm
-XX:MaxMetaspaceSize=512m # Maksimal hajm
```

Agar Metaspace ortiqcha o'sib ketsa va GC uni optimallashtira olmasa, **java.lang.OutOfMemoryError: Metaspace** xatosi yuzaga kelishi mumkin.

### 2.4 Code Cache
**Code Cache** – bu JIT (Just-In-Time) kompilyatori tomonidan ishlab chiqarilgan mashina kodlarini saqlash uchun ishlatiladigan maxsus xotira maydoni. JIT kompilyatori Java bayt-kodlarini real vaqtda mashina kodiga o‘giradi, bu esa dastur tezligini oshiradi.

---

## 3. Garbage Collection (GC) Algoritmlari# Java Garbage Collection (GC) Algoritmlari

Java dasturlash tilida **Garbage Collection (GC)** avtomatik xotira boshqarish jarayonidir. GC ishlatilmayotgan obyektlarni aniqlaydi va xotirani bo'shatadi, bu esa dastur samaradorligini oshirishga yordam beradi.

---

## 1. Garbage Collection Turlari

Java-da GC turli usullarda amalga oshiriladi:

1. **Minor GC** – Young Generation xotirasida ishlaydi.
2. **Major GC (Full GC)** – Old Generation va boshqa xotira bo‘limlarida ishlaydi.
3. **ZGC, G1GC, CMS GC, Serial GC** kabi maxsus GC algoritmlari mavjud.

---

## 2. Garbage Collection Algoritmlari

### 2.1 Serial Garbage Collector
- **Oddiy va ketma-ket ishlaydi**.
- **Bitta tilda ishlaydi (single-threaded)**.
- Kichik hajmli ilovalar uchun samarali.
- JVM bayroqlari:
  ```sh
  -XX:+UseSerialGC
  ```

---

### 2.2 Parallel Garbage Collector
- **Ko‘p oqimli (multi-threaded)** ishlaydi.
- Minor va Major GC jarayonlarini parallellashtiradi.
- Katta hajmli ilovalar uchun mos.
- JVM bayroqlari:
  ```sh
  -XX:+UseParallelGC
  ```

---

### 2.3 CMS (Concurrent Mark-Sweep) Garbage Collector
- **Parallel va fon rejimida ishlaydi**.
- Old Generation da ishlashga mos.
- JVM bayroqlari:
  ```sh
  -XX:+UseConcMarkSweepGC
  ```
- **Kamchiliklari:**
    - Fragmentatsiya muammosi.
    - Katta resurs talab qiladi.

---

### 2.4 G1 (Garbage First) Garbage Collector
- **Hozirgi zamonaviy GC**.
- Katta heap hajmli ilovalar uchun ishlatiladi.
- Parallel va fon rejimida ishlaydi.
- JVM bayroqlari:
  ```sh
  -XX:+UseG1GC
  ```
- **Afzalliklari:**
    - Ilova ishlashiga ta’sir qilmaydi.
    - Minimal to‘xtalish va optimallashtirilgan xotira boshqarish.

---

### 2.5 ZGC (Z Garbage Collector)
- **Eng ilg‘or va zamonaviy GC algoritmi**.
- **Katta hajmli heap (multi-TB)** uchun mo‘ljallangan.
- JVM bayroqlari:
  ```sh
  -XX:+UseZGC
  ```
- **Afzalliklari:**
    - Minimal to‘xtalish (1-2 ms gacha kamaytiriladi).
    - Linux va macOS uchun qo‘llab-quvvatlanadi.

---

## 3. Garbage Collection Ishlash Bosqichlari

1. **Mark (Belgilash)** – Foydalanilayotgan obyektlar belgilanadi.
2. **Sweep (Tozalash)** – Keraksiz obyektlar o‘chiriladi.
3. **Compact (Siqish)** – Xotira fragmentatsiyasini oldini olish uchun ma’lumotlar qayta joylashtiriladi.

---

## 4. Xotira Sozlamalari

Heap xotira hajmini belgilash uchun JVM bayroqlari:
```sh
-Xms512m   # Dastlabki heap hajmi
-Xmx2g     # Maksimal heap hajmi
-XX:MetaspaceSize=128m  # Metaspace hajmi
-XX:MaxMetaspaceSize=512m
```

---

## 5. Xulosa

Java GC algoritmlari dastur samaradorligini oshirish uchun mo‘ljallangan. Kichik ilovalar uchun **Serial GC**, o‘rta hajmli ilovalar uchun **Parallel GC**, real vaqtda ishlovchi tizimlar uchun **G1GC yoki ZGC** tavsiya etiladi. GC konfiguratsiyasini dastur ehtiyojlariga mos ravishda optimallashtirish muhimdir.


---

## 4. Just-In-Time (JIT) va Ahead-Of-Time (AOT) Kompilyatsiya

### 4.1 Just-In-Time (JIT) Kompilyatsiya
JIT kompilyatori **Java HotSpot VM** ning muhim qismi bo‘lib, Java bayt-kodlarini **mashina kodiga** kompilyatsiya qilish orqali ish unumdorligini oshiradi.

#### JIT kompilyatorining asosiy turlari:
- **C1 (Client Compiler)** – past kechikish talab qilinadigan yengil ilovalar uchun optimallashtirilgan.
- **C2 (Server Compiler)** – yuqori unumdorlik talab qiladigan ilovalar uchun chuqur optimizatsiyaga ega.

#### JIT optimizatsiya usullari:
- **Inline expansion** – metod chaqiruvlarini kodga kiritish orqali samaradorlikni oshirish.
- **Loop unrolling** – takrorlanuvchi sikllarni optimallashtirish.
- **Escape analysis** – obyektning qayerda ishlatilishini tahlil qilish va heap yoki stack ga joylashtirishni tanlash.

### 4.2 Ahead-Of-Time (AOT) Kompilyatsiya
AOT kompilyatsiya – bu dastur bajarilishidan oldin bayt-kodni mashina kodiga kompilyatsiya qilish jarayoni bo‘lib, bu usul JIT kompilyatsiyadan farqli ravishda ishlaydi.

#### AOT ning asosiy xususiyatlari:
- Ishga tushish vaqtini qisqartiradi, chunki JIT kabi real vaqt optimizatsiyasini kutish talab etilmaydi.
- Java ilovalari uchun **GraalVM Native Image** yordamida AOT kompilyatsiya qilish mumkin.

#### AOT vs JIT farqlari:
| Xususiyat | JIT | AOT |
|-----------|-----|-----|
| Ishga tushish tezligi | Sekinroq (chunki kompilyatsiya bajariladi) | Tezroq |
| Ishlash samaradorligi | Yuqori, real vaqt optimizatsiyasi bilan | Pastroq |
| Xotira sarfi | Ko‘proq (JIT va profiling ma’lumotlari talab etiladi) | Kamroq |

Agar **tez ishga tushadigan va past resurs talab qiladigan** ilova kerak bo‘lsa, **AOT** tanlanadi. Agar **dastur bajarilish vaqtida yuqori samaradorlik** kerak bo‘lsa, **JIT** afzal.

...

## 5. Heap Xotirani Sozlash
...

## 6. Xulosa
...

