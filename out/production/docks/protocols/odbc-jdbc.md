# ODBC va JDBC Haqida To'liq Ma'lumot

## ODBC (Open Database Connectivity)

ODBC – bu dasturlar va turli ma'lumotlar bazalari o'rtasida ulanishni ta'minlovchi standart interfeys. U orqali turli xil DBMS (Database Management System) lar bilan ishlash mumkin.

### ODBC Ishlash Mexanizmi
1. Dastur ODBC driver manager orqali ODBC driver bilan bog'lanadi.
2. ODBC driver SQL so'rovlarni ma'lumotlar bazasiga uzatadi.
3. Ma'lumotlar bazasi so‘rovni qayta ishlaydi va natijani ODBC driver orqali qaytaradi.
4. Dastur natijalarni oladi va foydalanuvchiga taqdim etadi.

### ODBC Afzalliklari
- Bir nechta turdagi DBMS bilan ishlash imkoniyati.
- Mustaqillik – dastur ma'lumotlar bazasiga bog‘liq emas.
- SQL so‘rovlarni bir xil formatda yuborish imkoniyati.

## JDBC (Java Database Connectivity)

JDBC – bu Java dasturlar va ma'lumotlar bazasi orasidagi ulanishni ta'minlovchi API hisoblanadi. U SQL so‘rovlarni bajarish va natijalarni olish uchun ishlatiladi.

### JDBC Ishlash Mexanizmi
1. Dastur JDBC Driver orqali ma'lumotlar bazasiga ulanishni yaratadi.
2. SQL so‘rov yuboriladi.
3. Ma'lumotlar bazasi so‘rovni bajarib, natijani qaytaradi.
4. Dastur natijani qayta ishlaydi.

### JDBC API ning Asosiy Klass va Metodlari
JDBC quyidagi asosiy komponentlarga ega:

#### 1. **DriverManager**
- `getConnection(String url, String user, String password)`: Ma'lumotlar bazasi bilan ulanish yaratadi.

#### 2. **Connection**
- `createStatement()`: SQL so‘rovlarni bajarish uchun `Statement` obyektini yaratadi.
- `prepareStatement(String sql)`: Oldindan tayyorlangan so‘rov yaratadi.
- `setAutoCommit(boolean autoCommit)`: Avtomatik commitni yoqish yoki o‘chirish.
- `commit()`: Qo‘lda tranzaksiya commit qilish.
- `rollback()`: Tranzaksiyani bekor qilish.
- `close()`: Ulanishni yopish.

#### 3. **Statement**
- `executeQuery(String sql)`: SQL SELECT so‘rovini bajaradi va natijani `ResultSet` qaytaradi.
- `executeUpdate(String sql)`: SQL INSERT, UPDATE, DELETE so‘rovlarini bajaradi.
- `close()`: Statement obyektini yopish.

#### 4. **PreparedStatement**
- `setInt(int parameterIndex, int value)`: Integer parametr qo‘shish.
- `setString(int parameterIndex, String value)`: String parametr qo‘shish.
- `executeQuery()`: Natijani qaytarish.
- `executeUpdate()`: Ma'lumotlar bazasini o‘zgartirish.

#### 5. **ResultSet**
- `next()`: Keyingi qatorga o‘tish.
- `getInt(String columnLabel)`: Integer ma’lumot olish.
- `getString(String columnLabel)`: String ma’lumot olish.
- `close()`: ResultSet obyektini yopish.

### JDBC Afzalliklari
- Turli xil DBMS lar bilan ishlash imkoniyati.
- Platformaga bog‘liq emas (Java’da ishlaydi).
- Mustahkam tranzaksiya boshqaruvi (commit va rollback imkoniyatlari bilan).
- Tayyorlangan so‘rovlar orqali samaradorlikni oshirish.

### JDBC Statement Turlari
JDBC uch xil `Statement` turini taqdim etadi:

1. **Statement**
  - Dinamik SQL so‘rovlarni bajarish uchun ishlatiladi.
  - Har safar so‘rov yuborilganda, ma’lumotlar bazasi uni kompilyatsiya qiladi.
  - Katta hajmdagi ma’lumotlarni qayta ishlashda samaradorligi pastroq.

2. **PreparedStatement**
  - Oldindan tayyorlangan SQL so‘rovlarni bajarish uchun ishlatiladi.
  - Parametrlarni dinamik tarzda qo‘shish mumkin.
  - Bir xil so‘rovlarni ko‘p martta bajarishda samarali, chunki u faqat bir marta kompilyatsiya qilinadi.

3. **CallableStatement**
  - Ma’lumotlar bazasidagi saqlangan protseduralarni chaqirish uchun ishlatiladi.
  - Parametrlarni kirish (`IN`), chiqish (`OUT`), yoki har ikkisini (`INOUT`) sifatida ishlatish mumkin.

### JDBC Misol (MySQL bilan ulanish)
```java
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## ODBC va JDBC Taqqoslash

| Xususiyat | ODBC | JDBC |
|-----------|------|------|
| Platforma | Platformadan mustaqil | Faqat Java |
| Tillar | C, C++, Python, .NET | Faqat Java |
| Ishlash tezligi | Yuqori | Biroz pastroq |
| Ma'lumot bazasi qo‘llab-quvvatlashi | Ko‘p DBMS lar | Faqat JDBC driver mavjud DBMS lar |
| Tranzaksiya qo‘llab-quvvatlashi | Ha | Ha |

## Xulosa
ODBC va JDBC har ikkalasi ham ma'lumotlar bazasi bilan aloqa qilish uchun ishlatiladi. JDBC faqat Java uchun mo‘ljallangan bo‘lsa, ODBC esa turli dasturlash tillari bilan ishlashi mumkin. JDBC ma'lumotlar bazasi bilan ishlashni soddalashtiradi va platformaga bog‘liq bo‘lmagan yechim sifatida foydalaniladi. ODBC esa, asosan, Windows muhitida ishlaydigan dasturlar uchun qulay interfeys hisoblanadi.

