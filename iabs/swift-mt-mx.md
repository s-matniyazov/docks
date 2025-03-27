
# SWIFT MT va MX Xabarlar Formati

## SWIFT MT dan MX ga o'tish sabablari

SWIFT o‘zining MT (Message Type) formatidan MX (ISO 20022) formatiga o‘tmoqda, chunki:

1. **Standartlashtirish va global moslik** – ISO 20022 butun dunyo bo‘ylab moliyaviy tizimlar uchun universal standart bo‘lib, banklar va moliyaviy institutlar orasidagi o‘zaro muvofiqlikni oshiradi.
2. **Ko‘proq ma’lumotlarni uzatish imkoniyati** – MX formati XML asosida bo‘lib, ma’lumotlarni aniqroq va to‘liqroq uzatishga imkon beradi, MT format esa cheklangan uzunlikdagi tarmoqlarga bo‘lingan.
3. **Avtomatlasiyani rivojlantirish** – ISO 20022 formati avtomatlashtirish va STP (Straight-Through Processing) jarayonlarini yaxshilashga yordam beradi.
4. **Regulyatorlarning talablariga javob berish** – Turli davlatlarning moliyaviy regulyatorlari va markaziy banklari yangi standartlarni joriy etishni talab qilmoqda.
5. **Kelajak uchun moslashuvchanlik** – MX (ISO 20022) formati kelajakdagi texnologik o‘zgarishlarga moslashishga va to‘g‘ridan-to‘g‘ri API, blokcheyn yoki boshqa ilg‘or tizimlarga integratsiya qilishga qulay.

SWIFT 2025-yilgacha to‘liq MX formatiga o‘tishni rejalashtirgan. Shu vaqtgacha MT va MX formatlari parallel ishlaydi.

---

## SWIFT MT xabarlarini uzatish jarayoni

SWIFT MT (Message Type) formatidagi xabarlar SWIFTNet tarmog‘i orqali quyidagi bosqichlarda uzatiladi:

### **1. Xabar tuzilishi (MT Message Structure)**
MT formatidagi har bir xabar quyidagi asosiy qismlardan iborat:

1. **Basic Header Block (`{1:...}`)** – Xabar turi, yo‘nalishi va SWIFT tarmog‘i haqida ma’lumot.
2. **Application Header Block (`{2:...}`)** – Xabar qabul qiluvchi va yuboruvchining roli haqida ma’lumot.
3. **User Header Block (`{3:...}`) – [Ixtiyoriy]** – Maxsus parametrlar yoki yo‘riqnomalar.
4. **Text Block (`{4:...}`)** – Asosiy tranzaksiya ma’lumotlari.
5. **Trailer Block (`{5:...}`) – [Ixtiyoriy]** – Xavfsizlik va tekshirish ma’lumotlari.

**MT103 misol xabari:**
```plaintext
{1:F01BANKXXXXXX0000000000}
{2:I103BANKYYYYXXXXN}
{4:
:20:REFERENCE12345
:23B:CRED
:32A:240325USD1000,00
:50K:/123456789
JOHN DOE
:59:/987654321
JANE DOE
}
```

### **2. Xabarni yuborish (Transmission Process)**
1. **Bank yoki moliyaviy institut** o‘zining SWIFT interfeysi orqali MT formatida xabarni yaratadi.
2. **Xabar SWIFTNet orqali marshrutlanadi** – SWIFTNet xavfsiz tarmog‘i orqali qabul qiluvchi bankka yo‘naltiriladi.
3. **Qabul qiluvchi bank xabarni dekod qiladi** – Bank xabarni olgach, uni o‘z tizimiga yuklaydi va pul o‘tkazmani bajaradi.

### **3. Yetkazib berish va tasdiqlash**
- Agar xabar muvaffaqiyatli yetkazilsa, SWIFT **ACK (Acknowledgment)** xabarini yuboradi.
- Agar xabar noto‘g‘ri bo‘lsa, **NACK (Negative Acknowledgment)** yoki **error code** bilan qaytariladi.

---

## MT vs MX asosiy farqlari

| **Xususiyat**  | **MT (SWIFT Message Type)** | **MX (ISO 20022)** |
|---------------|---------------------------|--------------------|
| **Ma'lumot formati** | Matn (text-based) | XML (structured data) |
| **Ma'lumot uzunligi** | Cheklangan | Moslashuvchan |
| **O‘qish va tahlil qilish** | Qo‘lda yoki maxsus parserlar kerak | XML parserlar bilan avtomatlashtirilgan |
| **Standartlashtirish** | Faqat SWIFT uchun ishlatiladi | Global moliyaviy tizimlar bilan mos keladi |
| **Avtomatlasiya** | Cheklangan | Yaxshi qo‘llab-quvvatlanadi |
| **Xavfsizlik va nazorat** | Minimal | Kengaytirilgan xavfsizlik va ma’lumot tekshirish imkoniyatlari |

**MT103 va MX (ISO 20022) formatidagi xabarlarning solishtirishi:**

**MT103 (Matn formatida)**
```plaintext
{1:F01BANKXXXXXX0000000000}
{2:I103BANKYYYYXXXXN}
{4:
:20:REFERENCE12345
:23B:CRED
:32A:240325USD1000,00
:50K:/123456789
JOHN DOE
:59:/987654321
JANE DOE
}
```

**MX (ISO 20022) ekvivalenti (XML format)**
```xml
<Document xmlns="urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02">
    <FIToFICstmrCdtTrf>
        <GrpHdr>
            <MsgId>REFERENCE12345</MsgId>
            <CreDtTm>2024-03-25T10:15:30</CreDtTm>
        </GrpHdr>
        <CdtTrfTxInf>
            <PmtId>
                <EndToEndId>REFERENCE12345</EndToEndId>
            </PmtId>
            <IntrBkSttlmAmt Ccy="USD">1000.00</IntrBkSttlmAmt>
            <Cdtr>
                <Nm>JANE DOE</Nm>
            </Cdtr>
            <Dbtr>
                <Nm>JOHN DOE</Nm>
            </Dbtr>
        </CdtTrfTxInf>
    </FIToFICstmrCdtTrf>
</Document>
```

---

## **Xulosa**
- **MT** – oddiy **text format** bo‘lib, o‘qish va ishlash qiyinroq.
- **MX (ISO 20022)** – **XML asosida** bo‘lib, **ko‘proq ma’lumot** saqlaydi va avtomatlashtirishga qulay.
- **2025-yilgacha SWIFT MT dan to‘liq MX ga o‘tishni rejalashtirmoqda**.


# SWIFT MT va MX haqida ma'lumotlar

## SWIFT MT dan MX ga o'tish sabablari
- **Standartlashtirish va global moslik** – ISO 20022 universal standart bo‘lib, banklar va moliyaviy institutlar orasidagi muvofiqlikni oshiradi.
- **Ko‘proq ma’lumot uzatish imkoniyati** – MX formati XML asosida bo‘lib, aniqroq va to‘liqroq uzatishga imkon beradi.
- **Avtomatlasiyani rivojlantirish** – ISO 20022 formati avtomatlashtirish va STP jarayonlarini yaxshilaydi.
- **Regulyatorlarning talablariga javob berish** – Moliyaviy regulyatorlar va markaziy banklar yangi standartlarni joriy etishni talab qilmoqda.
- **Kelajak uchun moslashuvchanlik** – MX (ISO 20022) API, blokcheyn yoki boshqa tizimlarga integratsiya qilishga qulay.

## SWIFT MT qanday ishlaydi?
- Xabar **SWIFTNet** tarmog‘i orqali uzatiladi.
- MT xabarlari quyidagi bloklardan iborat:
    1. **Basic Header Block (`{1:...}`)** – Asosiy ma'lumotlar.
    2. **Application Header Block (`{2:...}`)** – Qabul qiluvchi va yuboruvchi haqida ma’lumot.
    3. **User Header Block (`{3:...}`) – [Ixtiyoriy]** – Qo'shimcha parametrlar.
    4. **Text Block (`{4:...}`)** – Asosiy tranzaksiya ma’lumotlari.
    5. **Trailer Block (`{5:...}`) – [Ixtiyoriy]** – Xavfsizlik ma’lumotlari.
- SWIFT **ACK/NACK xabarlari** orqali jo‘natilgan xabar qabul qilingan yoki rad etilganligi haqida bildirish olinadi.

## MT va MX o'rtasidagi farqlar
| Xususiyat  | MT (Message Type) | MX (ISO 20022) |
|------------|------------------|---------------|
| Format | Matn (Text-based) | XML |
| Ma'lumot uzunligi | Cheklangan | Moslashuvchan |
| Avtomatlasiya | Cheklangan | XML parserlar bilan qulay |
| Standart | Faqat SWIFT uchun | Global moliyaviy tizimlar uchun |

### MT103 – Xalqaro pul o'tkazmasi namunasi
```
{1:F01BANKABCXXXX0000000000}
{2:I103BANKXYZXXXXN}
{4:
:20:REFERENCE12345
:23B:CRED
:32A:240325USD1000,00
:50K:/123456789
JOHN DOE
:59:/987654321
JANE DOE
:70:PAYMENT FOR INVOICE 456
:71A:OUR
}
```

### MX (ISO 20022) ekvivalenti (XML format)
```xml
<Document xmlns="urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02">
    <FIToFICstmrCdtTrf>
        <GrpHdr>
            <MsgId>REFERENCE12345</MsgId>
            <CreDtTm>2024-03-25T10:15:30</CreDtTm>
        </GrpHdr>
        <CdtTrfTxInf>
            <PmtId>
                <EndToEndId>REFERENCE12345</EndToEndId>
            </PmtId>
            <IntrBkSttlmAmt Ccy="USD">1000.00</IntrBkSttlmAmt>
            <Cdtr>
                <Nm>JANE DOE</Nm>
            </Cdtr>
            <Dbtr>
                <Nm>JOHN DOE</Nm>
            </Dbtr>
        </CdtTrfTxInf>
    </FIToFICstmrCdtTrf>
</Document>
```

## SWIFT MT formatidagi xabarlar namunasi

### **MT202 – Banklararo pul o‘tkazmasi**
```
{1:F01BANKABCXXXX0000000000}
{2:I202BANKXYZXXXXN}
{4:
:20:REF987654321
:21:RELATEDREF
:32A:240325USD500000,00
:52A:BANKABCXXX
:58A:BANKXYZXXX
}
```

### **MT940 – Bank hisobvaraqi bo‘yicha ko‘chirma**
```
{1:F01BANKABCXXXX0000000000}
{2:I940BANKXYZXXXXN}
{4:
:20:STATEMENT123
:25:123456789
:28C:1/1
:60F:C240325USD10000,00
:61:240325C500,00NTRFNONREF
:86:Transfer from CLIENT1
:62F:C240325USD10500,00
}
```

### **MT950 – Bank balans hisoboti**
```
{1:F01BANKABCXXXX0000000000}
{2:I950BANKXYZXXXXN}
{4:
:20:BALANCE12345
:25:987654321
:28C:1/1
:60F:C240325USD50000,00
:62F:C240325USD51000,00
}
```

### **MT799 – Bank kafolati**
```
{1:F01BANKABCXXXX0000000000}
{2:I799BANKXYZXXXXN}
{4:
:20:MESSAGEID001
:21:CONTRACT987
:79:WE HEREBY CONFIRM OUR COMMITMENT TO PROVIDE THE AGREED FUNDS AS PER CONTRACT NUMBER 987.
}
```

## **Xulosa**
- **MT** format matn asosida, **MX** esa XML asosida ishlaydi.
- **SWIFT 2025-yilgacha** to‘liq **ISO 20022** ga o‘tishni rejalashtirmoqda.
- **MT103, MT202, MT940, MT950, MT799** kabi xabarlar bank operatsiyalarida ishlatiladi.
