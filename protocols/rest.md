# REST (Representational State Transfer)

## REST Nima?
REST (Representational State Transfer) – bu veb-xizmatlar uchun arxitektura uslubi bo‘lib, u **HTTP protokoli** asosida ishlaydi. REST ma’lumotlarni olish, qo‘shish, o‘zgartirish va o‘chirish uchun **CRUD (Create, Read, Update, Delete)** operatsiyalarini qo‘llaydi.

## REST Asosiy Xususiyatlari
1. **Klient-server arxitekturasi** – Mijoz va server mustaqil ishlaydi.
2. **Stateless (Holatsiz)** – Har bir so‘rov server tomonidan mustaqil ko‘rib chiqiladi.
3. **Cacheable (Keshlash mumkin)** – Natijalar vaqtinchalik saqlanib, tezkor ishlash ta’minlanadi.
4. **Layered System (Qatlamli tizim)** – Oraliq serverlar orqali xavfsizlik va yuklamani boshqarish mumkin.
5. **Uniform Interface (Yagona interfeys)** – Oddiy va standart HTTP metodlari ishlatiladi.

## HTTP Metodlari
REST API quyidagi **HTTP metodlari** orqali ma’lumotlarni boshqaradi:

| HTTP Metod | Tavsif |
|------------|--------|
| GET | Ma’lumot olish |
| POST | Yangi ma’lumot qo‘shish |
| PUT | Ma’lumotni yangilash |
| DELETE | Ma’lumotni o‘chirish |

## REST API Ishlash Ketma-ketligi
1. **Mijoz (Client) HTTP so‘rov yuboradi** (`GET`, `POST`, `PUT`, `DELETE`).
2. **Server so‘rovni qayta ishlaydi** va kerakli operatsiyani bajaradi.
3. **Server natijani JSON yoki XML formatida qaytaradi**.
4. **Mijoz javobni qabul qilib, ko‘rsatadi yoki saqlaydi**.

## REST API JSON Javobi Misoli
```json
{
  "id": 1,
  "name": "Mahsulot A",
  "price": 10000
}
```

## REST vs SOAP
| Xususiyat | REST | SOAP |
|-----------|------|------|
| Protokol | HTTP | HTTP, SMTP |
| Ma’lumot formati | JSON, XML | Faqat XML |
| Murakkablik | Soddaroq | Murakkabroq |
| Ishlash tezligi | Tezroq | Sekinroq |

## SOAP (Simple Object Access Protocol)
SOAP – bu XML asosidagi xabar almashish protokoli bo‘lib, tarmoqdagi turli tizimlar o‘rtasida ma’lumot almashinuvini ta’minlaydi. U **WSDL (Web Services Description Language)** yordamida xizmatlarni tavsiflaydi va asosan **HTTP, SMTP, TCP** protokollarini qo‘llaydi.

### SOAP Asosiy Xususiyatlari
1. **XML formatidan foydalanadi** – Ma’lumotlarni XML shaklida jo‘natadi.
2. **Tizimlararo moslik** – Turli platformalar va dasturiy ta’minotlar bilan ishlay oladi.
3. **Qo‘shimcha xavfsizlik** – WS-Security kabi xavfsizlik standartlarini qo‘llaydi.
4. **Holatli (Stateful) yoki Holatsiz (Stateless) bo‘lishi mumkin** – REST’dan farqli ravishda holatni saqlab qolishi mumkin.

### SOAP Ishlash Ketma-ketligi
1. Mijoz **SOAP so‘rovini XML formatida** jo‘natadi.
2. Server **so‘rovni WSDL orqali tekshiradi va qayta ishlaydi**.
3. Server **XML formatida javob qaytaradi**.
4. Mijoz **javobni qabul qilib, natijani ishlaydi**.

### SOAP So‘rov Misoli
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:GetProductRequest>
         <web:ProductId>1</web:ProductId>
      </web:GetProductRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Java Spring Boot misolida SOAP xizmatini yaratish
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@SpringBootApplication
public class SoapApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("ProductPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/products");
        definition.setSchema(schema);
        return definition;
    }

    @Bean
    public XsdSchema productSchema() {
        return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
    }
}
```

## REST API Ishlatish
### Java Spring Boot misolida REST API yaratish
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}

@RestController
@RequestMapping("/product")
class ProductController {
    @GetMapping
    public Product getProduct() {
        return new Product(1, "Mahsulot A", 10000);
    }
}

class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
}
```

## Xulosa
REST – bu zamonaviy veb-xizmatlarni yaratishda keng qo‘llaniladigan yondashuv bo‘lib, u **oddiylik, tezlik va mustaqillik** kabi afzalliklarga ega. JSON va HTTP orqali ishlagani sababli, REST API’lar boshqa tizimlar bilan integratsiya qilish oson bo‘ladi.

SOAP esa murakkabroq bo‘lib, **korporativ darajadagi xavfsizlik va tranzaksiyalar** uchun moslashgan. U tizimlararo aloqada va murakkab xizmatlarni ta’minlashda qo‘llanadi.

