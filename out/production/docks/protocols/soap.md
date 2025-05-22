# SOAP Haqida To'liq Ma'lumot

## SOAP Nima?
SOAP (Simple Object Access Protocol) – bu veb-xizmatlar orasida ma’lumot almashish uchun ishlatiladigan protokol. U XML asosida ishlaydi va HTTP, SMTP kabi transport protokollaridan foydalanib, ma’lumotlarni uzatadi.

## SOAP Xususiyatlari
- **Platformadan mustaqil** – Har qanday operatsion tizim va dasturlash tilida ishlaydi.
- **XML asosida** – Barcha ma’lumotlar XML formatida uzatiladi.
- **Standart protokol** – W3C tomonidan tasdiqlangan standart.
- **Transport mustaqilligi** – HTTP, SMTP, TCP kabi turli transport protokollarini qo‘llab-quvvatlaydi.
- **Extensibility (Kengaytiriluvchanlik)** – Qo‘shimcha xavfsizlik va tranzaktsiyalarni qo‘llab-quvvatlaydi.

## SOAP Tuzilishi
SOAP xabari 3 asosiy qismdan iborat:
1. **SOAP Envelope (O‘ram)** – Xabarni o‘z ichiga oluvchi asosiy element.
2. **SOAP Header (Sarlavha)** – Xavfsizlik, autentifikatsiya va boshqa qo‘shimcha ma’lumotlarni saqlaydi.
3. **SOAP Body (Jism)** – Asosiy ma’lumotlar va so‘rov/javob joylashgan bo‘lim.

### SOAP Xabari Misoli
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ex="http://example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ex:GetUserInfo>
         <ex:UserID>12345</ex:UserID>
      </ex:GetUserInfo>
   </soapenv:Body>
</soapenv:Envelope>
```

## SOAP Ishlash Jarayoni
1. **Mijoz** SOAP so‘rovini serverga jo‘natadi.
2. **Server** so‘rovni qabul qilib, uni qayta ishlaydi.
3. **Server** javobni SOAP formatida qaytaradi.
4. **Mijoz** javobni qabul qilib, undan ma’lumotlarni oladi.

## SOAP va REST Farqlari
| Xususiyat | SOAP | REST |
|-----------|------|------|
| Ma’lumot formati | XML | JSON, XML, YAML |
| Transport protokoli | HTTP, SMTP, TCP | HTTP |
| Tezlik | Sekinroq | Tezroq |
| Standartlashtirish | Yuqori | Kamroq |
| Oson integratsiya | Murakkab | Oddiy |

## Spring-da SOAP Xizmati Yaratish
### 1. SOAP Web Service Yaratish
```java
@Endpoint
public class UserService {
    private static final String NAMESPACE_URI = "http://example.com/";
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserInfoRequest")
    @ResponsePayload
    public GetUserInfoResponse getUserInfo(@RequestPayload GetUserInfoRequest request) {
        GetUserInfoResponse response = new GetUserInfoResponse();
        response.setName("John Doe");
        response.setAge(30);
        return response;
    }
}
```

### 2. SOAP Client Yaratish
```java
public class SoapClient {
    private WebServiceTemplate webServiceTemplate;
    
    public GetUserInfoResponse getUserInfo(String userId) {
        GetUserInfoRequest request = new GetUserInfoRequest();
        request.setUserId(userId);
        return (GetUserInfoResponse) webServiceTemplate.marshalSendAndReceive(request);
    }
}
```

## SOAP Xavfsizligi
SOAP xavfsizligi WS-Security standarti orqali amalga oshiriladi:
- **Shifrlash** – Ma’lumotlarni himoya qilish.
- **Autentifikatsiya** – Kimligini tekshirish.
- **Imzolash** – Xabar butunligini ta’minlash.

## Xulosa
SOAP korporativ darajadagi tizimlar uchun qulay bo‘lib, xavfsizlik va ishonchlilik talab qilinadigan loyihalarda keng qo‘llaniladi. Ammo, REST API tezligi va soddaligi sababli ko‘proq ishlatilmoqda.

