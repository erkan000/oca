## Date

Java 7 Date sınıfı mutable idi. Bu sınıfta değiştirilmesin diye setter ını silsek bile getter kullanılarak değeri set edilebilirdi. Java 8 ile beraber java.time package içinde yeni Date Time API geldi ve eski Date sınıfı ile tamamen uyumludur. Artık tarih kavramı ile zaman kavramı ayrıştırıldı.

- LocalDate : Sadece tarih hassasiyetinde olan tarih sınıfıdır.
- LocalTime : Günün belirli bir zamanını gösterir. 
- ZoneId : Zamanlara zone bilgisi eklememize yarar. Java time zone lar için IANA veritabanını kullanır.(https://www.iana.org/time-zones) 

![](media/date_time_types.png)

Yukardaki sınıfların hepsinde oluşturmak için static "now" metodu bulunur. LocalDate.now() gibi. Ayrıca hepsinde static "of" metodu bulunur. Örnekleri date.time.Create sınıfında.
- LocalTime of ile oluştururken nano saniye mertebesinde ayrıntılı overload edilmiş metodları bulunur. Aylar 1 den başlar, saatler 24 saat esasına göre yazılır.
- 4 sınıfın hiçbiri new ile oluşturulamaz, constructor private dır.
- getYear, getHour gibi metodları bulunur. Ayrıca format metodu ile hepsini formatlayabiliriz. Bu metod format almak için DateTimeFormatter sınıfındaki tanımlı sabitleri kullanır. Bu sınıfa "ofPattern" metodu ile custom formatter verebiliriz. (date.time.Format.java) 
- Burada harfler bir zaman birimini temsil eder, aşağıdaki gibi. Harflerin sayısı ise değiştirir. Ay için kulanılan büyük M harfi, bir defa yazılırsa aylar başına sıfır almadan, iki defa yazılırsa tek haneliler başına sıfır alarak, üç defa yazılısa ayın kısaltılması 3 harfli ve dört defa yazılırsa ayın adı uzun şekilde yazılmasını temsil eder.

![](media/date_time_symbols.png)

- Burada dikkat edilmesi gereken, herhangi bir formatlamada, olmayan veriler ile formatlama geçilir ise runtime da hata alınır. Mesela LocalDate nesnesini hh,mm,ss ile formatlayamayız. Veya LocalTime nesnesini y,M,d ile.
- Hem date time nesnelerinde format metodu bulunur hemde DateTimeFormatter sınıfında. İkiside aynıdır.  (date.time.Format.java) 
- Formatlarken içine text yazmak için tek tırnak kullanabiliriz. 'text' gibi. Eğer tek tırnağı string a yazmak istersek ise yan yana iki tane tek tırnak yazarız. '' gibi.

Diğer sınıfları ise;
- Instant : Zamanda belirli bir noktayı nanosaniye hassasiyetinde gösterir. Immutable'dır! 
  - Instant 0 is the January the 1st, 1970 at midnight GMT
  - Instant.MIN is 1 billion years ago
  - Instant.MAX is Dec. 31 of the year 1,000,000,000
  - Instant.now() is the current instant
- Duration : İki instant arasında geçen zaman farkıdır. 
  - Duration.between(Ins1, Ins2) ile elde edilebilir.
  - toNanos, toSeconds, toMinutes, plusNanos, isZero gibi metodları vardır.
- Period : İki Localdate arasında geçen zamanı temsil eder. Gün hassasiyetinde veriyi tutar.
- DateAdjuster : Instant veya LocalDate e bir zaman aralığı eklememizi ve çıkarmamızı sağlar.
  - firstDayOfMonth(), lastDayOfMonth(), firstDayOfNextMonth(), firstDayOfNextYear(), next(DayOfWeek.SUNDAY), nextOrSame(DayOfWeek.SUNDAY) , previous(DayOfWeek.SUNDAY) gibi metodları bulunur.


Legacy Api ler ile şu şekilde geçişler yapılabilir.

```java

Date date = Date.from(instant); // legacy ‐> new API
Instant instant = date.toInstant(); // API ‐> legacy

TimeStamp time = TimeStamp.from(instant); // legacy ‐> new API
Instant instant = time.toInstant(); // API ‐> legacy

Date date = Date.from(localDate); // legacy ‐> new API
LocalDate localDate = date.toLocalDate(); // API ‐> legacy

Time time = Time.from(localTime); // legacy ‐> new API
LocalTime localTime = time.toLocalTime(); // API ‐> legacy

```




