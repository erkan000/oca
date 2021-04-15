## Lambda Expressions
Functional programming is a way of writing code more declaratively. You specify what you want to do rather than dealing with the state of objects. Functional programming uses lambda expressions to write code. You can think of a lambda expression as an unnamed method. Lambda expressions are often referred to as lambdas for short. A lambda expression is like a method that you can pass as if it were a variable. 

Think of a lambda expression as a shortcut for the compiler that does two things - defines a class with a method and instantiates that class. java8.lambda.LambdaInternals.java incele. Lambda CarFilter sınıfını otomatik oluşturdu ve instantiate etti. Sınıfı oluştururken rastgele bir isim verdi ve metod type larını context'e bakarak elde etti. Interface'in imzasına baktı ve istenen sınıf parametresini aldı. Burada interface'in tek bir abstract  metod içermesini istemiştik her zaman. Bunun sebebi lambda nın lambda gövdesini hangi metoda yazacağını bilememesidir. Bu sebepten interface de sadece bir tane abstract metod olmalıdır. Burada dikkat edilecek husus lambda parametreleri, interface ile uyumlu olmalıdır. Compiler sadece implementasyonu yazamaz onu da lambda body de biz belirtiyoruz.

Diğer bir anlatımla, Anonymous classları yazmamızı ve okumamızı kolaylaştıran syntax dır. Yani bir interface'in concreate implementasyonunu içerir.  Yazmak için sadece Anonymous class'ın giriş parametresini al (->) işareti sonrasında Anonymous class'ın body'sini yapıştır. 

Sample lambda;
   a -> a.canHop()
Lambdas work with interfaces that have only one abstract method!! Sebebi lambda nın çalışma mantığıdır. Yukardaki lambda Java şu metoda map eder;
   boolean test(Animal a);
Since that interface’s method takes an Animal, that means the lambda parameter has to be an Animal. And since that interface’s method returns a boolean, we know the lambda returns a boolean.

Bu iki satır aynıdır.
   a -> a.canHop()
   (Animal a) -> { return a.canHop(); }

![](media/lambda_syntax.png)

Dikkat edilecek kurallar;
- Parametre bir tane ve tipi belirtilmemiş ise parantezler yazılmayabilir.
- Metod body bir satır ise {} ve return kelimesine gerek yok, birden fazla ise zorunludur.
- Sıfır veya daha fazla parametre alabilir. Parametre yok ise () yazılabilir. Paremetre tipleri de yazılmayabilir!
- Parametreler aynen body'de kullanılıyorsa şu syntax de kullanılabilir.   (s) -> System.out.println(s);  === System.out::println;

Bu geçerli bir lambda dır!
s -> {}

![](media/valid_lambdas.png)

![](media/invalid_lambdas.png)

```java
() -> true 				//valid
-> 1 					//invalid, missing variable declaration part
a -> a*a 				//valid
(a) -> a*a 				//valid
(int a) -> a*a 				//valid
(a, b, c) -> a + b + c 			//valid
a, b -> a+b 				//invalid, multiple parameters must be within ()
(int a, int b, int c) -> a + b + c 	//valid
(int a, int b, c) -> a + b + c		//invalid, all or none type paramamethers

(var a) -> a*a				// valid, var keyword için parantezler zorunlu

(@NotNull a) -> a*a			// invalid, anotasyon varsa type zorunludur
(@NotNull Integer a) -> a*a		// valid

a -> a + 2 				//valid
a - > return a + 2 			//invalid, must not have return keyword
(a, b) -> System.out.println(a+b)	//valid, method call is a valid expression

(a) -> {				//valid
	int x = 2;
	int y = x+a;
	return y;
}

() -> {					//valid
	int x = 2;
	int y = 3;
	System.out.println(x+y);
}
```

## Functional Interfaces
Lambdas work with interfaces that have only one abstract method. These are called functional interfaces. 
Lambda Expression ların type'ı "Functional Interface" dir. Java 8 ile geldi. Tek bir abstract medodu olan interface'e Functional Interface denir. Bir interface üzerine "@FunctionalInterface" anotasyonu ile Functional interface olduğu belirtilebilir ama zorunlu değildir. The signature of the abstract method of a functional interface provides the signature of a lambda expression (this signature is called a functional descriptor). En sık kullanılanları Predicate, Consumer, Supplier, ve Comparator. Fakat java.util.function package ile 43 tane "Functional Interface" tanımlanmıştır. Supplier, Consumer, BiConsumer, Predicate, BiPredicate, Function - UnaryOperator, BiFunction - BinaryOperator. 

Lambda Expression bir değişkene atanabilir. Böylece bir metoda parametre olarak lambda geçebiliriz veya metoddan lambda döndürebiliriz. Metod parametresi functional interface olmalıdır.

# Predicate
Genellikle filtreleme ve eşleştirmede kullanılabilir. 
   public interface Predicate<T> {
      boolean test(T t);
   }

# Consumer
Konsola yazı yazdırma gibi işlerde kullanılabilir.
   void accept(T t)

# Supplier
Değer üretmek için kullanılabilir.
   T get()

# Comparator
Bu interface java8 den önce de vardı. Bu yüzden java.util package içindedir.
   int compare(T o1, T o2)

## Variables in lambda
- Body de local variable tanımlanabilir, sadece body içinde geçerlidir.
- Parametrelerdeki ve Body deki parametre adı local context ile çakışmamalıdır, yoksa compile time error.
- Lambda body si instance variable, method parameter, veya local variable e ulaşabilir.
- Effectively final, Java 9 ile gelen yeni bir özellik. Eğer bir local değişkenin değeri sanki final gibi bir defa atanıyor ve hiç değişmiyor ise bu değişken effectively final dır.
- Method parameters and local variables are allowed to be referenced if they are effectively final. Lambda body de tanımlanan local ve metod parametreleri final olmalıdır. Yoksa kod derlenmez. Lambda expression dan sonra bile yeniden değer alsalar bile kod derlenmez. (Parametrelerde tek kural, lambda body ye dışardan geçtiğimiz parametreler final olmalı, body de yoksa istediğin şekilde değiştirebilirsin! Ayrıca lambda parametresi dışarıya gözükmez, birden fazla veya aynı parametreyi tanımlayabilirsin. Lambdayı sınıf olarak düşün!.)


![](media/lambda_body_variables.png)

# RemoveIf
List and Set declare a removeIf() method that takes a Predicate. List ve set de tanımlıdır, map de yoktur.
   collection.removeIf(s -> s.charAt(0) != 'h');

# Sort
Sıralar. Sadece list için tanımlı, set ve map zaten sıralıdır.
   collection.sort((b1, b2) -> b1.compareTo(b2));

# Foreach
forEach() takes a Consumer and calls that lambda for each element encountered. List, set için tanımlıdır. Map'in values ve keySet metodları için tanımlıdır.
   collection.forEach(b -> System.out.println(b));


## Method References
Lambdaları kısaltmanın diğer bir yolu da metod referanslarıdır. (::) ile temsil edilir. (Remember that :: is like a lambda, and it is used for deferred execution with a functional interface.) 4 formatta yazılabilir;
- Static methods (ClassName::staticMetod)
- Instance methods on a particular instance (instanceObject::instanceMethodName)
- Instance methods on a parameter to be determined at runtime 
- Constructors (ClassName::new)

# Calling Static methods
Mesela collection lardaki sort metodu statik tir ve şöyle yazılabilir;
   Consumer<List<Integer>> lambda = x -> Collections.sort(x);
   Consumer<List<Integer>> methodRef = Collections::sort;
Ayrıca burada lambda tek parametreli metodu çağıracağını Consumer dan anlıyor. 

# Calling Instance methods on a particular object
   var str = "abc";
   Predicate<String> methodRef = str::startsWith;
   Predicate<String> lambda = s -> str.startsWith(s);

# Calling Instance methods on a parameter
   Predicate<String> methodRef = String::isEmpty;
   Predicate<String> lambda = s -> s.isEmpty();

# Calling Constructors
   Supplier<List<String>> methodRef = ArrayList::new;
   Supplier<List<String>> lambda = () -> new ArrayList();

Özetlersek;
![](media/metod_referances.png)


## Functional programming with streams
Bu tablodaki function interfaces metod imzalarını KESİNLİKLE ezberlemelisin, metod isimleri ezberlemede yardımcı olabilir.
![](media/functional_interfaces.png)

# Supplier
Bir input almadan value üret. Genelde yeni nesneler üretmek için kullanılır.
   @FunctionalInterface
   public interface Supplier<T> {
      T get() ;
   }
Mesela;
   Supplier<LocalDate> s1 = LocalDate::now;
   Supplier<LocalDate> s2 = () -> LocalDate.now();
   Supplier<StringBuilder> s1 = StringBuilder::new;
   Supplier<StringBuilder> s2 = () -> new StringBuilder();

# Consumer, BiConsumer
Consumer bir parametre ile bir iş yapacağımızı ama birşey döndürmeyeceğimizi belirtir. BiConsumer ise aynı şeyi iki parametre ile yapacağımızı temsil eder.
   @FunctionalInterface
   public interface Consumer<T> {
      void accept(T t);
   }

   Consumer<String> c1 = System.out::println;
   Consumer<String> c2 = x -> System.out.println(x);
   var map = new HashMap<String, Integer>();
   BiConsumer<String, Integer> b1 = map::put;
   BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

# Predicate, BiPredicate
   @FunctionalInterface
   public interface Predicate<T> {
      boolean test(T t);
   }

   Predicate<String> p1 = String::isEmpty;
   Predicate<String> p2 = x -> x.isEmpty();

# Function, BiFunction
@FunctionalInterface
   public interface Function<T, R> {
      R apply(T t);
   }
Bir parametreyi başka bir sınıfa dönüştürerek geri döndürür. Farklı olması şart değil, aynı sınıf da olabilir.

   Function<String, Integer> f1 = String::length;
   Function<String, Integer> f2 = x -> x.length();

   BiFunction<String, String, String> b1 = String::concat;
   BiFunction<String, String, String> b2 = 
   (string, toAdd) -> string.concat(toAdd);

# UnaryOperator, BinaryOperator
Function 'ın parametreleri aynı olan versiyonudur. 
   @FunctionalInterface
   public interface UnaryOperator<T> extends Function<T, T> {
      T apply(T t);
   }

   UnaryOperator<String> u1 = String::toUpperCase;
   UnaryOperator<String> u2 = x -> x.toUpperCase();
   BinaryOperator<String> b1 = String::concat;
   BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

## Convience methods on function interfaces
Function interface sadece bir abstract metodu olan interface'ler demiştik. Ayrıca birçok "default" helper metodları da bulunur. Aynı tipteki functional interface i combine veya modifiye etmek için kullanılırlar. En sık kullanılanları;

![](media/functional_default_methods.png) 

LE ayrıca Collection sınıflarında veri işlemek için de kullanılır. Iterable interface'ine yeni bir method eklenmiştir. "default void forEach(Consumer<? super T> action)" Bu şekilde forEach metodunda LE kullanabiliriz. Burada default kelimesi ile bir interface içinde default method tanımlıyoruz. İçinde body'side vardır. Amacı eklenen yeni özelliklerin eski kodu bozmaması için yeni davranışın interface'e yazılmasıdır. Ayrıca static metodların da eklebilmesi özelliği getirildi. 

Örnek;
   Predicate<String> brownEggs = egg.and(brown);
   Predicate<String> otherEggs = egg.and(brown.negate());
   Consumer<String> combined = c1.andThen(c2);
   Function<Integer, Integer> combined = after.compose(before);              // Burada önce before çalışır!!

Örnek kod java8.stream.ConvenienceTest

## Optional
Express "we don't know" or "not applicable". Optional bir kutu gibidir, içinde veri olabilir veya boş olabilir. Oluşturmak için;
   Optional.empty();
   Optional.of(double);
   opt.isPresent();			Optional içinde veri varmı?
   opt.get()				İçindeki değeri al (İçi boş ise NoSuchElementException fırlatır)
   Optional.empty()         null değeri temsil edebiliriz.

Optional a veri atarken null ise empty, değil ise veriyi sarmalarız. Bunu kısa yolu aşağıdaki gibidir. İki satır aynı işi yapar.
   Optional o = (value == null) ? Optional.empty() : Optional.of(value);
   Optional o = Optional.ofNullable(value);

Mesela optional içinde veri varsa bir iş yap, yoksa yapma diyebiliriz.
   opt.ifPresent(System.out::println);

![](media/optional_instance_methods.png)

Mesela opt boş ise;
   opt.orElse(Double.NaN)					Nan değeri yazar
   opt.orElseGet(() -> Math.random())		rastgele sayı yazar
   opt.orElseThrow()						NoSuchElementException fırlatır
   opt.orElseThrow(() -> new IllegalStateException())

  Örnek kod java8.stream.OptionalTest


## Streams
A stream in Java is a sequence of data. A stream pipeline consists of the operations that run on a stream to produce a result. Bir fabrikadaki üretim bandını düşünelim.
- Bir önceki adım tamamlanmadan diğer adım başlayamaz
- Döngü sonsuzdur, sürekli devam eder
- Adımlardaki kişiler nesneye dokunur ve işlem yaparlar. Nesnenin bir kısmı işlemlerde atılabilir. (With streams, the data isn't generated up front—it is created when needed. This is an example of lazy evaluation, which delays execution until necessary.)

![](media/stream_pipeline.png)

- Source: Where the stream comes from
- Intermediate operations: Transforms the stream into another one. There can be as few or as many intermediate operations as you'd like. Since streams use lazy evaluation, the intermediate operations do not run until the terminal operation runs.
- Terminal operation: Actually produces a result. Since streams can be used only once, the stream is no longer valid after a terminal operation completes.

Burayı şuna benzetebiliriz. Fabrikayı yöneten üretim müdürü önce çalışanlara ne yapacaklarını önceden anlatır. Bu stream oluşturmaktır. Onların ne zaman başlayacağınıda Terminal operation a göre haber verir. Yani kaynakta iş varsa çalışanlara çalışmalarını emreder. Ayrıca intermediate operation da 2 tane iş yap var ise, kaynakta ne kadar olursa olsun, 2 den sonra dur da diyebilir.

Intermediate operations verinin daha da işlenebilmesi için her zaman yeni bir stream oluştuturlar. Bu metodlar lazy çalışır ve veri işleme yapmazlar. Terminal operations, such as forEach(), mark the stream as consumed, after which point it can no longer be used further. Terminal operations verinin işlenmesini tetiklerler. 

Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed. All intermediate operations are lazy, so they’re not executed until a result of a processing is actually needed.

Bir "Typed Interface" dir. (Stream<T>) İçinde veri tutmaz. Bazı özellikleri;
- Streams work perfectly with lambdas.
- Streams don't store their elements.
- Streams are immutable.
- Streams are not reusable.
- Streams don't support indexed access to their elements.
- Streams are easily parallelizable.
- Stream operations are lazy when possible.

# Create Stream
Stream interface'i java.util.stream package'ı içinde Stream<T> şeklinde tanımlıdır.

Sonlu stream şöyle oluşturulabilir.
   Stream<String> empty = Stream.empty();
   Stream<Integer> singleElement = Stream.of(1);
   Stream<Integer> fromArray = Stream.of(1, 2, 3);  // varargs!
   Stream<String> fromList = collection.stream();   // !!
   Stream<String> fromListParallel = collection.parallelStream();

Sonsuz stream şöyle oluşturulabilir.
   Stream<Double> randoms = Stream.generate(Math::random);
   Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);  // 1 başlangıcı temsil ediyor.
   Stream<Integer> oddNumberUnder100 = Stream.iterate(
     1,                // seed
     n -> n < 100,     // Predicate to specify when done
     n -> n + 2);      // UnaryOperator to get next value

![](media/creating_stream.png)

Testlerde sürekli yeni stream oluşturmak yerine streamSupplier kullanılabilir.
   Supplier<Stream<String>> streamSupplier = () -> Stream.of("A", "B", "C", "D");
   streamSupplier.get().filter()

You can perform a terminal operation without any intermediate operations but not the other way around. This is why we will talk about terminal operations first.
Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object. For example, you might have an int or a Collection.(mesela count, min, max metodları) Reduction, operasyon eğer streamin bütün elemanlarını geziyor ise buna reduction denir. 

![](media/terminal_stream_operations.png)

# Stream Terminal Operations
- count, sonlu streamdeki eleman sayısını verir(long döner)
- min ve max, sonlu streamdeki min ve max elemanı comparator'a göre döner. 
- findAny ve findFirst, sonlu ve sonsuz streamlerde kullanılabilir. findAny de genellikle ilk eleman dönsede rastgele eleman döner. findAny ve findFirst stream boş ise boş optional döner.
- allMatch, anyMatch, ve noneMatch verilen Predicate'i arar. Recustion değildir, sonsuz streamlerde sonlanmama ihtimali vardır. Herhangi bir eşleşme durumunda stream durur ve diğer elemanları işlemez! 
- allMatch(), noneMatch(), anyMatch()         Boolean döndürür
- findFirst(), findAny()                      Optional döndürür
- forEach sonlu ve sonsuz streamlerde verilen consumer'a göre çalışır. 
- reduce, stream'i tek bir nesne içine koyar. Reduction dır, yani bütün elemanları işler.
- collect, stream'i tek bir nesne içine koyar. Özel bir reduction'dır, "mutable reduction". Normal reduction dan daha verimlidir. Bu bahsedilen nesne bir string de olabilir bir List de olabilir. Collectors.toList, Collectors.joining(""), Collectors.counting() gibi metodlarla yaparız bu işi.

REDUCE;
3 şekilde oluşturabiliriz. 
   String word = stream.reduce("", (s, c) -> s + c);
   String word = stream.reduce("", String::concat);
İlk parametre identity dir, başlangıç değeri. İkinci parametre ise accumulator'dur yani her eleman ile ne yapılacağı. Burada streamdeki kelimeler birleştirilir.
İlk parametre genellikle gereksizdir. Yazmayabiliriz. Yazmazsak Optional döner. Optional içinde reduce edecek kadar eleman bulunmayabilir. Eleman sayısına göre aşağıdaki durumlar döner;

- If the stream is empty, an empty Optional is returned.
- If the stream has one element, it is returned.
- If the stream has multiple elements, the accumulator is applied to combine them. 

Reduce fonksiyonu SQL aggregation fonksiyonları gibi çalışır, stream üzerinde max, min, count, avg gibi birleştirmeler yapmamızı sağlar. Reduce metodu iki parametre alır. Birincisi reduction işleminin kimliğini belirtmek için kullanılır. İkincisi ise bir BinaryOperator (BiFunction) fonsiyonudur. BinaryOperator BiFunction'ın aynı parametreler almış halidir. Identity değişkeni yapılan reduce işlemi sonucuna eklenir! Bu da max gibi işlemde yanlış sonuca sebebiyet verebilir, önlemek için Optional oluşturuldu. Bu yeni method imzasında redude metodunun sadece BinaryOperator alır ve Optional döndürür.

3 parametreli metodunda combiner sadece paralel streamler için çalışıyor, farklı streamleri birleştirmek için yani.


COLLECT;
Genelde StringBuilder and ArrayList ile yapılır. Veriyi stream dışına başka şekilde aktarmamızı sağlar. 
<R> R collect(Supplier<R> supplier, 
   BiConsumer<R, ? super T> accumulator, 
   BiConsumer<R, R> combiner)

- supplier, veriyi saklayacağımız nesnedir, genelde stringbuilder oluşturur,
- accumulator, supplier a veri eklemeye yarar,
- combiner, paralel işlemlerde collection ları birleştrimeye yarar.

Collector'u her seferinde yazmak yerine, hazır collector lar tanımlanmıştır. 
- stream.collect(Collectors.toCollection(TreeSet::new));
- stream.collect(Collectors.toSet());

*** Remember, a stream can have only one terminal operation. Once a terminal operation has been run, the stream cannot be used again. But functional interfaces can be used again and again

# Using common intermediate operations
Filter
   Stream<T> filter(Predicate<? super T> predicate)
Filter işlemi Predicate parametresi alır. Bu parametre boolean test metodunu içerir. Filter ile tanımlanan Predicate e göre filtreleme yapılır. Ayrıca Predicate and, or, negate, isEqual gibi metodlar da içerir ve Predicate ler zincir yapılabilir. Zincir yaparken öncelik yazma sırasına göredir;
    p1.and(p2).or(p3)  =   (p1 AND p2) OR p3
	
Distinct, nesnelerin equals metodunu kullanır.
   Stream<T> distinct()
Limit, skip
   Stream<T> limit(long maxSize)
   Stream<T> skip(long n)        // stream başından itibaren n adet elemanı atla.
Map, datayı dönüştürmek için, Function alır.
   <R> Stream<R> map(Function<? super T, ? extends R> mapper)
FlatMap, iç içe nesneler yaratmayı kolaylaştırmak için
   <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
Sorted, returns a stream with the elements sorted
   Stream<T> sorted()
   Stream<T> sorted(Comparator<? super T> comparator)
Peek, It is useful for debugging because it allows us to perform a stream operation without actually changing the stream
   Stream<T> peek(Consumer<? super T> action)

Örnek kod java8.stream.IntermediateOperations

## Stream'in çalışma sırası;
var list = List.of("Toby", "Anna", "Leroy", "Alex");
list.stream()
   .filter(n -> n.length() == 4)
   .sorted()
   .limit(2)
   .forEach(System.out::println); 
1- The stream() method sends Toby to filter(). The filter() method sees that the length is good and sends Toby to sorted(). The sorted() method can't sort yet because it needs all of the data, so it holds Toby.
2- The stream() method sends Anna to filter(). The filter() method sees that the length is good and sends Anna to sorted(). The sorted() method can't sort yet because it needs all of the data, so it holds Anna.
3- The stream() method sends Leroy to filter(). The filter() method sees that the length is not a match, and it takes Leroy out of the assembly line processing.
4- The stream() method sends Alex to filter(). The filter() method sees that the length is good and sends Alex to sorted(). The sorted() method can't sort yet because it needs all of the data, so it holds Alex. It turns out sorted() does have all of the required data, but it doesn't know it yet.
5- The foreman lets sorted() know that it is time to sort and the sort occurs.
6- The sorted() method sends Alex to limit(). The limit() method remembers that it has seen one element and sends Alex to forEach(), printing Alex.
7- The sorted() method sends Anna to limit(). The limit() method remembers that it has seen two elements and sends Anna to forEach(), printing Anna.
8- The limit() method has now seen all of the elements that are needed and tells the foreman. The foreman stops the line, and no more processing occurs in the pipeline.   

## Primitive Streams
- IntStream: Used for the primitive types int, short, byte, and char
- LongStream: Used for the primitive type long
- DoubleStream: Used for the primitive types double and float

![](media/primitive_stream_methods1.png)
![](media/primitive_stream_methods2.png)

Primitive stream oluşturma, java8.stream.PrimitiveStreams.java

# Create with mapping
Stream lerin map metodları streamleri birbirine çevirmeye yarar. Mesela bir string stream'i int stream'e her elemanı string in uzunluğu olan stream'e çevirebilirsin. Tablodaki gibi metodlar ve çevrimler mevcuttur.
![](media/primitive_stream_mapping.png)

![](media/primitive_stream_mapping_params.png)

flatMap metodu Stream sınıfındaki gibi primitive stream lerde de vardır fakat ismi farklıdır. flatMapToInt, flatMapToDouble, flatMapToLong

Primitive stream ler stream e dönüştürülebilir. Yukardaki tabloda gördüğümüz gibi mapToObj metoduyla veya boxed metoduyla. Farkı boxed da mapping fonksiyonuna ihtiyacımız yoktur, autobox yapar.

# Using Optional with Primitive streams
Primitive streamler için Optional sınıfının primitive leri bulunur. Normal Optional ile farkı ise normalde Wrapper sınıfları kullanılır, OptionalDouble gibi optionallarda ise primitive tipler kullanılır. 

![](media/primitive_optionals.png)

Primitive stream lerde, stream içindeki sayıların bazı istatistiki verilerini hazır sağlayan metod bulunur. 
   IntSummaryStatistics stats = primitiveStream.summaryStatistics();
- Smallest number (minimum): getMin()
- Largest number (maximum): getMax()
- Average: getAverage()
- Sum: getSum()
- Number of values: getCount()

istatistik metodu stream boş ise count ve sum için 0 döndürür, diğer metodlar için Optional döndürür. 

# Learning Functional interfaces for primitives
Konu başında Supplier, Consumer, Predicate görmüştük. Şimdi ise bunların primitive karşılıklarını göreceğiz. Önce şu özel functional interface görelim. BooleanSupplier;
   boolean getAsBoolean()
Diğer primitive function interfaces şunlardır;

![](media/primitive_functional_interfaces.png)

- Generics are gone from some of the interfaces, and instead the type name tells us what primitive type is involved. In other cases, such as IntFunction, only the return type generic is needed because we're converting a primitive int into an object.
- The single abstract method is often renamed when a primitive type is returned.

![](media/primitive_specific_functional_interfaces.png)

# Chaining Optionals
Optional ın da stream gibi map, flatMap, filter, ifPresent metodları bulunmaktadır. 

79. sayfa kodunu yazarak anlayabilirsin ancak.
Ayrıca checked exceptions kutusu

# Collecting Results
Sonuçları gruplamak için aşağıdaki tablodaki metodlar hazır tanımlanmıştır. Collectors interface'inin static metodlarıdır. 

![](media/collectors1.png)
![](media/collectors2.png)

- Collectors.joining stringleri birleştirmek için kullanılır.
- Collectors.toCollection(ArrayList::new) Stream'i bir Collection nesnesine çevirmeye yarar. Supplier alır.
- Collectors.toList() List interface'ine çevirmek yeterli ise bu kullanılabilir.
- Collectors.toSet()
- Collectors.toMap(s -> s, String::length) ilk Function, key'in nasıl oluşacağı, ikinci Function ise value'nun nasıl oluşacağı
- Collectors.toMap(s -> s, String::length, collector) buradaki fark ise aynı elemanların nasıl birleştirileceğini 3. parametre belirler
- toMap metodları dönüşü HashMap olabilir, kesin değildir. Kesin olarak bir tip belirtmek istiyorsak, 4. parametre olarak "TreeMap::new" geçebiliriz.

- Collectors.groupingBy stream içindeki elemanları Function a göre gruplar ve map olarak döner. Değerler ise gruplanmış List lerdir. Null dönmez, çünkü null a izin vermez. Burada oluşturulan map ve list in tiplerini set edebiliriz;
   Collectors.groupingBy(
      String::length, 
      TreeMap::new, 
      Collectors.toSet()));
- Collectors.partitioningBy ise verilen Predicate'a göre stream'i ikiye ayırıp, map olarak true,false key leri döndürür. Predicate 'e uyanlar true keyinin içinde list olarak saklanır, uymayanlar da false olarak List de saklanır. Eşleşme olmama durumunda map de yine true veya false key'i bulunur ama List in içi boştur. Diğeri gibi list yerine set dönecek şekilde ayarlayabiliriz. Fakat diğeri gibi map türünü ayarlayamıyoruz.(Çünkü her zaman 2 key var, map türünü değiştirmeye ihtiyacımız olmaz!)
   Collectors.partitioningBy(
      s -> s.length() <= 7, 
      Collectors.toSet()));
- Collectors.mapping bir seviye aşağı inmemizi ve değerler için Collector yazmamızı sağlar. 


## Lambda and anonymous classes

So lambda expressions are an alternative to anonymous classes, but they are not the same.

They have some similarities:

- Local variables (variables or parameters defined in a method) can only be used if they are declared final or are effectively final.
- You can access instance or static variables of the enclosing class.
- They must not throw more exceptions than specified in the throws clause of the functional interface method. Only the same type or a supertype.

Some significant differences between lambdas and anonymous classes:

- For an anonymous class, the this keyword resolves to the anonymous class itself. For a lambda expression, this resolves to the enclosing class where the lambda is written.
- Default methods of a functional interface cannot be accessed from within lambda expressions. Anonymous classes can.
- Anonymous classes are compiled into inner classes, while lambda expressions are converted into private, static (in some cases) methods within their enclosing class. Using the invokedynamic instruction (added in Java 7), they are bound dynamically. Simply put, since there's no need to load another class, lambda expressions are more efficient than anonymous classes.

Lambda Expression Anonymous class larddan daha performanslıdır. Çünkü Anonymous class new keyword ü ile oluşturulur ve LE a göre daha fazla kaynak tüketir!

