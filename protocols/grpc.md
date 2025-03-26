# gRPC Haqida To'liq Ma'lumot

## gRPC Nima?
gRPC (Google Remote Procedure Call) – bu Google tomonidan ishlab chiqilgan ochiq manbali, yuqori samarali RPC (Remote Procedure Call) tizimi bo‘lib, xizmatlar orasidagi tezkor va samarali aloqa uchun mo‘ljallangan.

## gRPC Xususiyatlari
- **Protobuf asosida ishlaydi** – Ma’lumotlarni tez va samarali kodlash uchun Protocol Buffers (Protobuf) dan foydalanadi.
- **Ko‘p tilli qo‘llab-quvvatlash** – Java, Go, Python, C++, Node.js va boshqa tillarda ishlaydi.
- **HTTP/2 asosida** – Tezkor va samarali aloqa o‘rnatish uchun HTTP/2 protokolidan foydalanadi.
- **Stream qo‘llab-quvvatlashi** – Bir yo‘nalishda yoki ikki tomonlama stream ma’lumot uzatish imkonini beradi.
- **Avtomatik kod generatsiyasi** – Xizmat interfeysini yaratishda kod generatsiya qilish imkoniyati mavjud.

## Protobuf (Protocol Buffers) Nima?
Protocol Buffers (Protobuf) – bu Google tomonidan ishlab chiqilgan soddalashtirilgan ma’lumotlarni serializatsiya qilish formati bo‘lib, tezkor va samarali ma’lumot almashish uchun ishlatiladi. JSON yoki XML bilan solishtirganda, Protobuf kam joy egallaydi va kodlash/decodlash tezligi yuqori.

### Protobuf Xususiyatlari
- **Engil va tez** – JSON va XML ga nisbatan ancha kichik hajmda ishlaydi.
- **Ko‘p tillarni qo‘llab-quvvatlaydi** – Java, C++, Python, Go va boshqa ko‘plab tillarda ishlaydi.
- **Avtomatik kod generatsiyasi** – .proto fayllardan avtomatik kod yaratish imkonini beradi.
- **Sodda sintaksis** – Oson o‘qiladigan va tushunarli.
- **Binar formatda ma’lumot uzatish** – JSON va XML dan farqli ravishda, Protobuf ma’lumotlarni binar formatda uzatadi. Bu esa ma’lumot almashish tezligini oshiradi va tarmoqda kamroq joy egallaydi.

### Protobuf Misol
```proto
syntax = "proto3";

message Person {
    string name = 1;
    int32 age = 2;
    string email = 3;
}
```

Bu misolda **Person** nomli ma’lumot tuzilmasi yaratilgan bo‘lib, u uchta maydonni o‘z ichiga oladi: **name** (string), **age** (int32) va **email** (string).

## gRPC Ishlash Mexanizmi
1. **Xizmat interfeysi Protobuf orqali aniqlanadi.**
2. **Protobuf dan foydalangan holda server va mijoz uchun kod generatsiya qilinadi.**
3. **Server ma’lumotlarni qayta ishlaydi va javob qaytaradi.**
4. **Mijoz RPC chaqiruvini bajaradi va javob oladi.**

## gRPC Pod Kapoti Ostida (How gRPC Works Internally)
gRPC ishlashining asosiy tarkibiy qismlari quyidagilardan iborat:

1. **Stub va Skeleton**: Mijoz tomonida stub (client proxy) va server tomonida skeleton (server stub) avtomatik ravishda Protobuf asosida generatsiya qilinadi.
2. **HTTP/2**: gRPC HTTP/2 dan foydalangan holda bir nechta chaqiruvlarni parallel ravishda amalga oshirish imkoniyatiga ega bo‘ladi.
3. **Ma’lumotni Binar Formatga O‘girish**: JSON yoki XML o‘rniga, ma’lumotlar Protobuf orqali binar formatda uzatiladi, bu esa samaradorlikni oshiradi.
4. **Multiplexing**: HTTP/2 tufayli bir nechta so‘rovlar bitta ulanish orqali jo‘natilishi va qabul qilinishi mumkin.
5. **Stream Qo‘llab-quvvatlashi**: gRPC serverdan mijozga yoki aksincha, yoki hatto ikki tomonlama ma’lumot oqimini qo‘llab-quvvatlaydi.
6. **Xavfsizlik**: gRPC TLS orqali shifrlashni qo‘llab-quvvatlaydi, bu esa ma’lumotlarni himoyalashga yordam beradi.

## gRPC Turlari
- **Oddiy RPC** – Mijoz so‘rov yuboradi va serverdan natijani kutadi.
- **Server-side Streaming** – Serverdan mijozga ma’lumotlar oqim orqali jo‘natiladi.
- **Client-side Streaming** – Mijozdan serverga ma’lumotlar oqim orqali jo‘natiladi.
- **Bidirectional Streaming** – Mijoz va server o‘zaro ikki tomonlama oqim orqali ma’lumot almashadi.

## Protobuf bilan gRPC Misol
```proto
syntax = "proto3";

service Greeter {
    rpc SayHello (HelloRequest) returns (HelloReply);
}

message HelloRequest {
    string name = 1;
}

message HelloReply {
    string message = 1;
}
```

## Java-da gRPC Server
```java
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloWorldServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreeterImpl())
                .build()
                .start();
        server.awaitTermination();
    }
}

class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Salom, " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
```

## Java-da gRPC Client
```java
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("Olam").build());
        System.out.println(response.getMessage());
        channel.shutdown();
    }
}
```

## gRPC va REST Farqlari
| Xususiyat | gRPC | REST |
|-----------|------|------|
| Protokol | HTTP/2 | HTTP/1.1 |
| Ma’lumot formati | Protobuf (Binar) | JSON/XML (Matnli) |
| Tezlik | Yuqori | Pastroq |
| Streaming | Qo‘llab-quvvatlanadi | Qo‘llab-quvvatlanmaydi |
| Kod generatsiyasi | Avtomatik | Qo‘lda |

## Xulosa
gRPC zamonaviy mikroxizmat arxitekturasi uchun juda mos keladi, chunki u tez, samarali va ko‘p tillarni qo‘llab-quvvatlaydi. REST API bilan solishtirganda, u yuqori ishlash tezligi va samarali ma’lumot almashinuvini ta’minlaydi. Protobuf esa JSON va XML bilan solishtirganda, hajmi kichik va tezkor ishlashi bilan ajralib turadi. Bundan tashqari, Protobuf binar formatda ma’lumot uzatgani uchun, u tarmoqda kamroq joy egallaydi va ma’lumotlar tezroq qayta ishlanadi.

