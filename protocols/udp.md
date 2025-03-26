# UDP (User Datagram Protocol) Haqida To'liq Ma'lumot

## UDP Nima?
UDP (User Datagram Protocol) – bu transport darajasidagi yengil protokol bo‘lib, tezkor va kam kechikish bilan ma’lumot uzatish uchun ishlatiladi. U TCP kabi aloqani o‘rnatmaydi va xatolarni tekshirishni ta’minlamaydi, shu sababli ba’zi paketlar yo‘qolishi yoki noto‘g‘ri ketma-ketlikda kelishi mumkin.

## UDP xususiyatlari
- **Aloqani o‘rnatish talab qilinmaydi** – Aloqa sessiyasi bo‘lmagan holda ishlaydi.
- **Tezkor va kam kechikish** – TCP bilan solishtirganda ma’lumot tezroq uzatiladi.
- **Xato nazorati cheklangan** – Paketlar yo‘qolsa yoki buzilsa, qayta uzatish mexanizmi yo‘q.
- **Ketma-ketlikni kafolatlamaydi** – Paketlar har xil tartibda yetib kelishi mumkin.

## UDP Ishlash Mexanizmi
1. **Ma’lumotlar bo‘laklarga bo‘linadi** va UDP datagram shaklida uzatiladi.
2. **Har bir UDP paketi** quyidagi qismlardan iborat:
  - **Manba porti** – Qaysi portdan jo‘natilganligi.
  - **Manzil porti** – Qaysi portga borishi kerakligi.
  - **Paket uzunligi** – UDP paketi uzunligini belgilaydi.
  - **Tekshiruv summasi** – Paketda xatolik borligini tekshiradi.
  - **Ma’lumot** – Asosiy foydali yuk.
3. **Maqsad host UDP paketi**ni oladi va ma’lumotni yuqori darajadagi ilovalarga uzatadi.
4. **Paket yetib kelmasa yoki buzilsa**, uni qayta jo‘natish mexanizmi yo‘q.

## UDP Ishlatilish Sohaari
- **VoIP (Ovozli aloqa, Skype, Zoom, WhatsApp Call)** – Tezkor ovozli aloqa uchun ishlatiladi.
- **Video Streaming (YouTube, Netflix, Twitch)** – Tezkor yetkazish zarur bo‘lgan joylarda ishlatiladi.
- **DNS (Domain Name System)** – Tezkor so‘rovlarni qayta ishlash uchun ishlatiladi.
- **Onlayn o‘yinlar (Dota 2, CS:GO, PUBG)** – Past kechikish muhim bo‘lgan tizimlarda ishlatiladi.
- **IoT (Internet of Things)** – Sensorlar va qurilmalar o‘rtasida tezkor ma’lumot almashinuvi uchun ishlatiladi.

## UDP va TCP Taqqoslash
| Xususiyat | UDP | TCP |
|-----------|-----|-----|
| Aloqa o‘rnatish | Yo‘q | Ha |
| Xabar yetib borish kafolati | Yo‘q | Ha |
| Ma’lumot ketma-ketligi | Kafolatlanmagan | Kafolatlangan |
| Ishlash tezligi | Yuqori | Pastroq |
| Xato nazorati | Minimal | To‘liq |
| Qo‘llanilishi | Video, ovoz, DNS, o‘yinlar | Veb-saytlar, email, fayl yuklash |

## UDP Misol (Java-da)
```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buffer = "Salom, UDP!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
        socket.send(packet);
        socket.close();
    }
}
```

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Qabul qilindi: " + received);
        socket.close();
    }
}
```

## Xulosa
UDP tezkor va engil protokol bo‘lib, past kechikish muhim bo‘lgan ilovalarda ishlatiladi. Lekin u paketlar yetib borishini kafolatlamaydi, shu sababli xato nazorati kerak bo‘lgan holatlarda TCP ishlatiladi.

