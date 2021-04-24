# Define a Secure Object

- Değişkenlere mümkün olduğunca az ulaşılabilirlik ver. Public yerine private vs. Buna principle of least privilege denir. Modüler yapıda ise şu şekilde kimlerin ulaşacağını belirtebilirsin. "exports animals.security to zoo.staff;"
- Bir sınıf parametre olarak geçiliyor ise, hacker bu sınıfı extend ederek sınıf içindeki gerçek iş yapan metodları etkisiz hale getirebilir. Bunu engellemek için hassas iş yapan sınıfları mutlaka final olarak tanımla.
- Immutable nesneler oluştur. Bir sınıfı immutable yapmak için;
 - Mark the class as final.
 - Mark all the instance variables private.
 - Don't define any setter methods and make fields final.
 - Don't allow referenced mutable objects to be modified.(mesela bir arraylist getter metodu ile değiştirilebilir!) Ya veriyi kontrollü bir şekilde değiştirmeye izin ver, mesela get(i) gibi, veya getter da nesnenin bir kopyasını döndür.
 - Use a constructor to set all properties of the object, making a copy if needed. (Constuctor a this.favoriteFoods = new ArrayList<String>(favoriteFoods); gibi bir bağımsız nesne ile sınıfı oluşturt.)
 - final keyword restricts extensibility; private keyword limits accessibility;

# Clone Object
Java Cloneable interface'i ile nesne kopyalamayı sağlar. clone() metodu tanımlanmıştır. Defensive copy yapmamızı sağlar. Yukardaki örnekte ArrayList "this.favoriteFoods = (ArrayList) favoriteFoods.clone();" şeklinde de kopyalanabilirdi.

Clone 2 şekilde yapılır;
- Deep copy
- Shallow copy

-Defensive copy, bir sınıf içindeki değişebilen bir instance variable'ın get metodu ile elde edilirken her zaman new ile başka bir kopyasını oluşturup, o kopyanın dönmesini sağlamaktır. Örnekleri;
- new ArrayList<>(liste)  Bu da shallow copy
- (ArrayList) liste.clone()   (Burada da ArrayList in clone metodu shallow copy oluşturur.)

By default, the clone() method makes a shallow copy of the data, which means only the top-level object references and primitives are copied. No new objects from within the cloned object are created. For example, if the object contains a reference to an ArrayList, a shallow copy contains a reference to that same ArrayList. Changes to the ArrayList in one object will be visible in the other since it is the same object.

İstersek clone metodunu override ederek deep copy oluşturmak için metodu tekrar tanımlayabiliriz. Object sınıfı içindeki clone metodu default olarak implemente edilmedi hatası fırlatır. clone metodunu çağırdığımızda olabilecek olasılıklar şöyledir;

![](media/clone_method.png)

- SQL Injection önlemek için preparedStatement 'ı binding ile beraber kullan. (setString gibi..)
- Command Injection önlemek için white list kullan.
- Hassas verileri loga, exceptiona, consola veya dosyalara yazma
- Hassas verileri kullandıktan sonra bellekten yok etmek için referansını null a set et ki, GC toplasın. Ayrıca console.readPassword gibi metodları kullan. Mesela bu metod string okumak yerine veriyi char[] olarak saklar. Veya Arrays.fill(pass, 'x') ile hassas verinin üstüne yazabilirsin.
- Serialize etmek istemediğimiz alanları "transient int age" transient keyword'ü ile serialization yapılmasını engelleyebiliriz. Veya serialize edilecek alanları ObjectStreamField dizisi içinde belirtebiliriz.(serialPersistentFields) Biri whitelist, diğeri blacklist yaklaşımıdır.
- serialPersistentFields must be declared private static final, or it will be ignored.
- Serialize ederken hassas verileri şifreleyip serialize etmek istersek, writeObject(PutField) ve readObject(GetField) metodlarımıza ilgili alanları encrypt ve decrypt metodları yazabiliriz. Yani serialization ı kendimiz yaparız.
- Serialize etmeden önce veya sonra bazı metodlar çalıştırabiliriz. readResolve ve writeReplace metodları ile.

![](media/serialization_process.png)

- metodları final yaparak metodlerın ezilmesini engelleyebiliriz.
- sınıfları final yaparak extend edilmelerini engelleyebiliriz.
- constructor ı private yaparak, sınıfımızın oluşmasını kontrol altına alabiliriz. Sınıfı oluşturmak için static factory metodlara ihtiyacımız vardır.

## Dos attacks(Dos aynı cihazdan, DDos farklı cihazlardan)
- Leaking resources, dosya okuduktan sonra dosyayı kapatmazsak
- Dosya okurken size kontrolü yapmazsak, çok büyük dosyalarla memory taşabilir.
- Inclusion attack, küçük bir zip dosyası açılınca kocaman bir resim çıkabilir veya küçük bir XML loop yapılarak kocaman bir veri elde ettirilebilir.(billion laughs attack, zip bomb)
- Uygulamamızda kullandığımız int değerlerde size'ı geçilebilir. Integer overflow yaşanınca değişken negatif değer olur. Böylece programımız yanlış çalışır ve istenmeyen sonuçlar üretir.
- HashMap içinde key ile arama hızlıdır, veriler hashlidir. Eğer hashcode değeri sabit dönen bir sınıf yazarsak, 1 milyon kayıtta arama hızımız çok yavaşlar. Böylece uygulama yavaşlatılabilir.

## permission file sample

grant {
  permission java.io.FilePermission
     "/usr/local/library/book.txt",
     "read,write";
};
