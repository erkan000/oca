Runnable İnterface;

  @FunctionalInterface
  public interface Runnable {
     void run();
  }

LAmbda ile tanımlanırken hiçbirşey döndürmemeli, yoksa derlenmez!

Runnable sloth = () -> System.out.println("Hello World");
Runnable snake = () -> {int i=10; i++;};
Runnable beaver = () -> {return;};
Runnable coyote = () -> {};

Runnable capybara = () -> "";                 // DOES NOT COMPILE
Runnable Hippopotamus = () -> 5;              // DOES NOT COMPILE
Runnable emu = () -> {return new Object();};  // DOES NOT COMPILE

2 şekilde çalıştırılır;
- public class PrintData implements Runnable {
  (new Thread(new PrintData())).start();
  
- public class ReadInventoryThread extends Thread {
  (new ReadInventoryThread()).start();
  
The Concurrency API includes the ExecutorService interface, which defines services that create and manage threads for you. Concurrency API includes the Executors factory class that can be used to create instances of the ExecutorService object. Asenkron thread şöyle oluşturulur. shurdown çağırmassan uygulaman hiçbir zaman kapanmaz.

   ExecutorService service = Executors.newSingleThreadExecutor();
   service.execute(runnable);  
   service.shutdown();
   
![](media/executor_service_lifecycle.png)

shutdown         metodu hali hazırsaki işlerin bitmesini bekler, yeni iş almaz.
shutdownNow      metod ise hali hazırdaki işleri sonlandırır.

execute metodu ile işin durumunu bilemeyiz, sadece çalıştırmaya yarar. submit metodu ise bize Future nesnesi döner ve iş durumundan haberdar oluruz. 

![](media/executor_service_methods.png)

Future arayüzü metodları şunlardır;
![](media/future_methods.png)

Callable interface;
Runnable yerine kullanabiliriz. Runnable ın aksine değer dönebilir ve hata fırlatabilir. ExecutorService in submit metoduna geçilebilir. Runnable her zaman null dönerken, callable T dönebilir.

   @FunctionalInterface public interface Callable<V> {
      V call() throws Exception;
   }

Threadlerin bitmesini awaitTermination metodu ile bekleyebiliriz. shutdown dan sonra kullanılır, kullanımı şöyledir;
if(service != null)
   service.shutdown();
}
if(service != null) {
   service.awaitTermination(1, TimeUnit.MINUTES);
 
   if(service.isTerminated())
     System.out.println("Finished!");
   else
      System.out.println("At least one task is still running");
}
   
invokeAll() and invokeAny();
Both of these methods execute synchronously and take a Collection of tasks. 
- The invokeAll() method executes all tasks in a provided collection and returns a List of ordered Future instances, with one Future instance corresponding to each submitted task, in the order they were in the original collection.
- The invokeAny() method executes a collection of tasks and returns the result of one of the tasks that successfully completes execution, cancelling all unfinished tasks.
- Bu iki metodun timeout alan parametreleri de bulunur.

Scheduling Tasks;
The ScheduledExecutorService, which is a subinterface of ExecutorService, can be used for scheduling tasks. 

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

![](media/scheduled_executor_service.png)

- The schedule() method returns a ScheduledFuture instance. The ScheduledFuture interface is identical to the Future interface, except that it includes a getDelay() method that returns the remaining delay. Delay tam zamanında gerçekleşmeyebilir. Daha sonra çalışabilir. 
- The scheduleAtFixedRate() method creates a new task and submits it to the executor every period, regardless of whether the previous task finished.
- The scheduleWithFixedDelay() method creates a new task only after the previous task has finished. Örneğin 2 dakikada bir iş yap denmişse ve ilk iş 5 dakikada bitmişse, 2. iş 7 dakika sonra başlar.

Pooling
Bu ana kadar hep tek bir thread ile çalıştık. Aşağıda Concurrency API nin birden fazla thread metodları bulunur.

![](media/pooling.png)

The difference between a single-thread and a pooled-thread executor is what happens when a task is already running. While a single-thread executor will wait for a thread to become available before running the next task, a pooled-thread executor can execute the next task concurrently. If the pool runs out of available threads, the task will be queued by the thread executor and wait to be completed.

- The newFixedThreadPool() takes a number of threads and allocates them all upon creation. As long as our number of tasks is less than our number of threads, all tasks will be executed concurrently. If at any point the number of tasks exceeds the number of threads in the pool, they will wait in a similar manner as you saw with a single‐thread executor. In fact, calling newFixedThreadPool() with a value of 1 is equivalent to calling newSingleThreadExecutor().
- The newCachedThreadPool() method will create a thread pool of unbounded size, allocating a new thread anytime one is required or all existing threads are busy. This is commonly used for pools that require executing many short‐lived asynchronous tasks. For long‐lived processes, usage of this executor is strongly discouraged, as it could grow to encompass a large number of threads over the application life cycle.
- The newScheduledThreadPool() is identical to the newFixedThreadPool() method, except that it returns an instance of ScheduledExecutorService and is therefore compatible with scheduling tasks.

Writing Thread-Safe Code;
4 şekilde yazmayı göreceğiz, bunlar
- Atomic classes
- Synchronized blocks
- The Lock framework
- Cyclic barriers

Atomic Classes;
Bir değişkeni atomik olarak tanımlayarak race condition'ı engelleyebiliriz. Burada değişkenle işlem yapılırken otomatik olarak diğer threadler değişkene okuyup, yazamazlar, beklemek zorunda kalırlar. java.util.concurrent.atomic package altında bulunan;
- AtomicBoolean 
- AtomicInteger 
- AtomicLong 
sınıfları ile yapılırlar. Bu sınıfların metodları ile güvenli şekilde değişkenleri değiştirebiliriz. Bazı metodları;
- get() 	            Retrieves the current value
- set() 	            Sets the given value, equivalent to the assignment = operator
- getAndSet() 	    Atomically sets the new value and returns the old value
- incrementAndGet() 	For numeric classes, atomic pre‐increment operation equivalent to ++value
- getAndIncrement() 	For numeric classes, atomic post‐increment operation equivalent to value++
- decrementAndGet() 	For numeric classes, atomic pre‐decrement operation equivalent to --value
- getAndDecrement() 	For numeric classes, atomic post‐decrement operation equivalent to value--

Synchronized blocks;
The most common technique is to use a monitor, also called a lock, to synchronize access. A monitor is a structure that supports mutual exclusion, which is the property that at most one thread is executing a particular segment of code at a given time. In Java, any Object can be used as a monitor, along with the synchronized keyword. 

   SheepManager manager = new SheepManager();
   synchronized(manager) {
      // Work to be completed by one thread at a time
   }

Yukarıdaki kod bloğunda synchronized alanı içinde sadece bir thread çalışabilir, başka bir thread gelirse ilk thread'in işini bitirmesini bekler. Burada önemli olan farklı threadlerin aynı nesne üzerinde lock almasıdır. Farklı nesnelerde çalışmaz. Synchronized keyword instance metodlarda da kullanılabilir. Şu iki metod birbirinin aynısıdır.

   private void incrementAndReport() {
      synchronized(this) {
        // code
      }
   }
   private synchronized void incrementAndReport() {
      // code
   }

static metodlarda ise;

   public static void printDaysWork() {
      synchronized(SheepManager.class) {
         // code
      }
   }
   public static synchronized void printDaysWork() {
      // code
   }

Lock Framework;
Synchronized kelimesinin çok daha özellikli versiyonu Lock interface'idir. Bu interface'i implemente eden sınıflarla yapılır. Synchronized yerine nesne üzerinde lock() metodu ile kilit oluşturulur, unlock() metodu ile kilit kaldırılır. Örneğin;

   Lock lock = new ReentrantLock();
   try {
      lock.lock();   
      // Protected code
   } finally {
      lock.unlock();
   }
Lock interface metodları şöyledir;
- void lock() 	        Requests a lock and blocks until lock is acquired
- void unlock() 	    Releases a lock
- boolean tryLock() 	Requests a lock and returns immediately. Returns a boolean indicating whether the lock was successfully acquired
- boolean tryLock(long,TimeUnit) 	Requests a lock and blocks up to the specified time until lock is required. Returns a boolean indicating whether the lock was successfully acquired

CYCLIC BARRIER;
4 thread çalıştıralım. Bunların hepsi kodun bir kısmına kadar birbirlerini beklesin. Yani thread'in belirli bir noktasında, bütün threadler birbirlerini beklesin ve hepsi oraya gelince, hepsi çalışmaya devam etsin. Bu cyclic barrier dır. CyclicBarrier sınıfı ile oluşturulur ve await() metodu bekleme noktasını belirtir. Constructor ları;
    var c1 = new CyclicBarrier(4);
    var c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));  // bekleme noktasına hepsi gelince bu işi yap.
Burada dikkat etmemiz gereken nokta thread pool un size'ı cyclic barrier size ından küçük olmamalıdır. Yoksa hangs. 
	
	
Concurrent Classes;

![](media/concurrent_classes.png)

ConcurrentSkipListSet == TreeSet
ConcurrentSkipListMap == TreeMap

CopyOnWriteArrayList ve CopyOnWriteArraySet
These classes copy all of their elements to a new underlying structure anytime an element is added, modified, or removed from the collection. By a modified element, we mean that the reference in the collection is changed. Modifying the actual contents of objects within the collection will not cause a new structure to be allocated.
Mesela for ile dönerken içerde eleman eklersek normalde concurrent exception hatası alırız. CopyOnWrite ile bu hatayı almayız çünkü iterator elde edilince değişmeyen ilk nesne olur elimizde. Değişen list başka bir listtir.
Çok fazla memory kullanır. Çok okuma, az yazma olan işlerde kullanmalıyız.

BlockingQueue normal bir Queue implemenatasyonudur, tek farkı modifikasyon yaparken beklemek için timeout değeri belirtebiliriz. Timeout olduğunda InterruptedException hatası fırlatabilirler.
- offer(E e, long timeout, TimeUnit unit) 	  Adds an item to the queue, waiting the specified time and returning false if the time elapses before space is available
- poll(long timeout, TimeUnit unit) 	      Retrieves and removes an item from the queue, waiting the specified time and returning null if the time elapses before the item is available

synchronizedCollection lar chapter4.s6.Senkronizasyon.java sınıfında örnekleri var. Concurrent Collectionların aksine for loop içinde ekleme ve silmede "ConcurrentModificationException" hatası fırlatırlar. 

Liveness;
Uygulamamızdaki threadler birbirlerini beklerken bu bekleme süreleri artabilir belki de sonsuz olabilir. Uygulamanın belirli bir zamanda cevap vermesine Liveness denir. 3 türü bulunur. Deadlock, starvation, ve livelock. 

Deadlock
- iki farklı thread birbirinin işlerini bitirmesini bekliyor ise bu durumda "Deadlock" oluşur. Örneği chapter10.s4.DeadLock sınıfında vardır. Bu sınıfta iki nesne üzerinde iki farklı thread çalışıyor. Bu thread ler birbirlerinin nesneleri üzerlerinde kilitlendikleri için sonsuza kadar birbirlerini bekliyorlar ve deadlock oluşuyor.
Starvation
Starvation = açlık
- Eğer akşam başbakan ile yemeğe gideceksin dense, planlarını değiştirir miydin? Evet. Bunun gibi OS içinde her thread'in bir önceliği vardır. Thread schuler önceliği yüksek olanları seçer. Bu durum düşün öncelikli thread'leri aç bırakabilir. Veya object monitörü almak için bekleyen bir thread'de aç kalabilir. Thread ayarlama OS'un görevidir.
Livelock
- Arkadaşın ile telefonda konuşurken çağrı kesildi. Sen tekrar ararsın ama meşguldür çünkü o da seni aynı şekilde aramaya çalışıyordur. Belli bi süre beklersin ve tekrar denersin yine aynı şekilde meşgul çalar. Bu durumda iki tarafda "livelock" durumundadır. Her iki tarafta ayakta ve tepki verebilmektedir. Aynı şekilde thread'lerde de oluşabilir. 
Livelock'daki thread'ler bloklanmamıştır, birbirlerine tepki verirler ama tamamlanamazlar.
Race Condition
- Aynı nesne üzerinde çalışan threadlerde meydana gelir. Bir thread nesneyi alım, bir alanının değerini değiştirirken thread suspend olabilir. Bu sırada başka bir thread aynı alanın değerini değiştirir. Yarın kalan işine devam ederse eski veri ile işlem yapmış olur. Bu duruma race condition denir. Veya bir sitede aynı kullanıcı ismi ile kullanıcı oluşturan iki kişi, aynı anda isteği gönderirse aynı kullanıcı adı 2 defa oluşabilir.


Parallel Streams;
Bu ana kadar sürekli serial streamler ile çalıştık. Her seferinde tek bir eleman işledik. Parallel streamlerde ise elemanları farklı thread lerde işleyebiliriz. Parallel streamler büyük verilerde performans artışı sağlar ayrıca bazı işlemler için ekstra birleştirmeler yapmamız gerekebilir. 2 şekilde oluşturulur.
- Stream<Integer> s1 = List.of(1,2).stream().parallel();
- Stream<Integer> s2 = List.of(1,2).parallelStream();

Parallel streamlerde thread sayısı, cpu sayısı ile orantılıdır. parallel dediğimiz anda sistemin cpu su kadar thread'i oluşturur ve her birini farklı bir thread de çalıştırır. Tahmin edeceğin üzere artık stream sonucu sırası belirsiz bir sırada olur. 

- order tabanlı stream işlemleri parallel streamlerde daha yavaş çalışır. Önlemek için .stream().unordered().parallel() ile listeyi sırasıza çevirebiliriz.
- Reduce işlemi de identity bütün threadlerde uygulanır.
- Reduce ve collect de accumulator ve combiner sonuçları herhangi bir sırada işleyecek şekilde yazılmalıdır.
- forEachOrdered metodu ile listenin eklenmes sırasına göre elememanları yazdırabiliriz.

