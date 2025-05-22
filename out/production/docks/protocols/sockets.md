# WebSocket Protokoli

## WebSocket nima?
WebSocket – bu ikki tomonlama, real vaqt rejimidagi aloqa kanalini ta’minlaydigan tarmoq protokoli. U **TCP** ustida ishlaydi va **HTTP bilan boshlanib**, keyin doimiy ulanishga o‘tadi.

WebSocket **ishonchli** va **dupleks** (ikki tomonlama) aloqa imkonini beradi, bu esa uni **real vaqt ilovalari** uchun mukammal yechimga aylantiradi.

## WebSocket va HTTP farqi
| Xususiyat | WebSocket | HTTP |
|-----------|----------|------|
| Ulanish turi | Doimiy | So‘rov-javob |
| Ma'lumot uzatish | Ikki tomonlama | Bir tomonlama (so‘rovdan keyin javob) |
| Ishlash printsipi | TCP ulanishi orqali davomli aloqa | Har bir so‘rov uchun yangi ulanish |
| Ma’lumot formati | JSON, XML, biner, matn | HTTP body (matn, JSON, XML) |
| Qo‘llanilish sohasi | Real vaqt ilovalari (chat, o‘yinlar, market) | Veb-sahifalar, API-lar |

## WebSocket qanday ishlaydi?
1. **HTTP orqali boshlanish (Handshake)**
  - WebSocket ulanishi **HTTP 1.1 yoki undan yuqori** versiyasi orqali boshlanadi.
  - Mijoz serverga `Upgrade: websocket` sarlavhasi bilan HTTP **GET** so‘rovini yuboradi.
  - So‘rov quyidagi kabi bo‘ladi:

   ```http
   GET /chat HTTP/1.1
   Host: example.com
   Upgrade: websocket
   Connection: Upgrade
   Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==
   Sec-WebSocket-Version: 13
   ```

  - **Sec-WebSocket-Key** – mijoz tomonidan yuborilgan **tasodifiy kalit**, server tomonidan javob sifatida ishlatiladi.
  - **Upgrade va Connection** – bu sarlavhalar serverni WebSocket rejimiga o‘tishga majbur qiladi.

2. **Server javobi**
  - Server ushbu so‘rovni qabul qiladi va quyidagicha javob qaytaradi:

   ```http
   HTTP/1.1 101 Switching Protocols
   Upgrade: websocket
   Connection: Upgrade
   Sec-WebSocket-Accept: s3pPLMBiTxaQ9kYGzzhZRbK+xOo=
   ```

  - **101 Switching Protocols** – bu javob server WebSocket rejimiga muvaffaqiyatli o‘tgani haqida signal beradi.
  - **Sec-WebSocket-Accept** – mijoz yuborgan `Sec-WebSocket-Key` ustida SHA-1 algoritmi va Base64 kodlash bilan hosil qilingan kalit.

3. **Doimiy ulanish**
  - HTTP ulanishi yopilmaydi, aksincha, **ikki tomonlama aloqa** o‘rnatiladi.
  - Ma’lumotlar oldinga va orqaga **real vaqtda** uzatiladi.

4. **Ma'lumot uzatish**
  - Server va mijoz har qanday vaqtda xabar yuborishi mumkin.
  - JSON, XML yoki **biner ma'lumotlar** yuborilishi mumkin.

5. **Ulanishni yopish**
  - Mijoz yoki server `CLOSE` signalini yuboradi va ulanish yopiladi.

## WebSocket Protokol Tuzilishi
WebSocket protokoli quyidagi asosiy qismlardan iborat:
- **Handshake (Boshlang‘ich so‘rov)** – HTTP orqali WebSocket ulanishi o‘rnatiladi.
- **Frame-based communication** – Ma’lumotlar **ramkalar** (frames) orqali yuboriladi.
- **Control Frames** – Ulanishni boshqarish uchun qo‘llaniladi (`Close`, `Ping`, `Pong`).
- **Data Frames** – Asosiy ma’lumotlarni uzatish uchun ishlatiladi.

### WebSocket Frame Tuzilishi
Har bir WebSocket xabari **frame** shaklida yuboriladi:
```
0       1       2       3       4       5       6       7       8       9       10      11      12      13      14      15      
+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+
| Fin | RSV1 | RSV2 | RSV3 | OpCode | Mask | Payload Length |
+-------+-------+-------+-------+-------+-------+-------+-------+
| Extended Payload Length (if needed) |
+-----------------------------------------------+
| Masking Key (if Mask is set) |
+-----------------------------------------------+
| Payload Data |
+-----------------------------------------------+
```

## WebSocket ilovalari
WebSocket quyidagi sohalarda keng qo‘llaniladi:
- **Chat ilovalari** (Telegram Web, WhatsApp Web)
- **Onlayn o‘yinlar**
- **Real vaqtda narxlarni kuzatish** (kriptovalyuta, aksiyalar)
- **Onlayn monitoring tizimlari**
- **IoT (Internet of Things)**

## WebSocket uchun JavaScript misoli
```javascript
const socket = new WebSocket("wss://example.com/socket");

socket.onopen = function() {
    console.log("WebSocket ulanishi o‘rnatildi");
    socket.send("Salom, server!");
};

socket.onmessage = function(event) {
    console.log("Serverdan xabar: ", event.data);
};

socket.onclose = function() {
    console.log("Ulanish yopildi");
};
```

## WebSocket uchun Java Spring misoli
```java
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.sendMessage(new TextMessage("Salom, mijoz!"));
    }
}
```

## Xulosa
WebSocket – bu HTTP’dan farqli ravishda **real vaqt** rejimida ikki tomonlama aloqa o‘rnatish imkonini beruvchi kuchli texnologiya. U chat ilovalari, onlayn o‘yinlar va tezkor ma’lumot almashinuvi talab qilinadigan boshqa sohalarda keng qo‘llaniladi. WebSocket protokoli **frame-based** bo‘lib, u **ping/pong mexanizmi**, **xabar turlari**, va **masking** bilan ishlaydi. Bu esa uni ishonchli va samarali qiladi.