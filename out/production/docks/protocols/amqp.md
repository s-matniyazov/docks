# AMQP (Advanced Message Queuing Protocol) Haqida To'liq Ma'lumot

## AMQP Nima?
AMQP (Advanced Message Queuing Protocol) – bu xabar almashish tizimlari uchun mo‘ljallangan ochiq standart protokol bo‘lib, ishonchli va samarali xabar uzatish imkonini beradi. U asosan mikroxizmatlar, tizimlararo aloqa va asenkron jarayonlarni boshqarishda keng qo‘llaniladi.

## AMQP Tuzilishi
AMQP quyidagi asosiy komponentlardan iborat:

1. **Producer (Ishlab chiqaruvchi)** – Xabarlarni yaratadi va brokerga yuboradi.
2. **Broker (Vositachi)** – Xabarlarni qabul qiladi, marshrutlash va yetkazib berish bilan shug‘ullanadi (masalan, RabbitMQ).
3. **Exchange (Almashinuv punkti)** – Xabarlarni marshrutlash qoidalariga ko‘ra qabul qilib, kerakli joyga yo‘naltiradi.
4. **Queue (Navbat)** – Xabarlarni vaqtincha saqlaydi va kerakli iste'molchilarga yetkazib beradi.
5. **Consumer (Iste'molchi)** – Xabarlarni qabul qilib, ulardan foydalanadi.

## AMQP Ishlash Mexanizmi
1. **Producer xabar yaratadi va uni Exchange ga yuboradi.**
2. **Exchange xabarni marshrutlash qoidalariga asosan Queue ga yo‘naltiradi.**
3. **Queue xabarlarni saqlaydi va Consumer uni talab qilguncha kutib turadi.**
4. **Consumer navbatdan xabarni olib, qayta ishlaydi.**

## AMQP Pod Kapoti Ostida (How AMQP Works Internally)
### 1. **Connection va Channel**
- AMQP mijoz va server orasida **TCP ulanishi (Connection)** o‘rnatadi.
- Har bir ulanish ichida **Channel** ochiladi, bu esa bir nechta xabarlarni bitta TCP ulanish orqali jo‘natish imkonini beradi.

### 2. **Exchange Turlari**
- **Direct Exchange** – Xabar faqat belgilangan queue ga yuboriladi.
- **Fanout Exchange** – Xabar barcha bog‘langan queue larga tarqatiladi.
- **Topic Exchange** – Xabarlar mavzu (pattern) bo‘yicha filtrlanadi.
- **Headers Exchange** – Xabarlar sarlavha maydonlari asosida yo‘naltiriladi.

### 3. **Message Acknowledgment (Tasdiqlash)**
- **Auto Acknowledge** – Iste'molchi xabarni olishi bilan u avtomatik o‘chiriladi.
- **Manual Acknowledge** – Iste'molchi xabarni qayta ishlaganidan keyin tasdiqlaydi, agar xatolik bo‘lsa, qayta yuboriladi.

### 4. **Durability va Persistence**
- **Durable Queue** – Brokerni qayta ishga tushirganda ham saqlanib qoladigan navbat.
- **Persistent Message** – Diskda saqlanadigan xabarlar, broker qayta ishga tushganda yo‘qolmaydi.

## RabbitMQ-da AMQP Misol (Spring Boot bilan)

### 1. Producer (Xabar jo‘natuvchi)
```java
@RestController
@RequestMapping("/send")
public class Producer {
    private final RabbitTemplate rabbitTemplate;
    
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
        return "Xabar yuborildi: " + message;
    }
}
```

### 2. Consumer (Xabar qabul qiluvchi)
```java
@Component
public class Consumer {
    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        System.out.println("Xabar qabul qilindi: " + message);
    }
}
```

### 3. RabbitMQ Konfiguratsiyasi
```java
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }
}
```

## AMQP va REST Farqlari
| Xususiyat | AMQP | REST |
|-----------|------|------|
| Aloqa turi | Asenkron | Senkron |
| Ishonchlilik | Yuqori | O'rtacha |
| Xabarni qayta ishlash | Navbat orqali | So‘rov-javob |

## Xulosa
AMQP – bu ishonchli va samarali xabar jo‘natish protokoli bo‘lib, mikroxizmatlar, distribyut qilingan tizimlar va asenkron jarayonlarni boshqarishda keng qo‘llaniladi. RabbitMQ kabi AMQP brokerlari yordamida tizimlarning yuklanishini samarali boshqarish va skalabillikni ta’minlash mumkin.

