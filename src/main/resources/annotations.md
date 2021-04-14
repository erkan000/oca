# Annotations
Annotations metadata dır. Amaçları eklendikleri sınıf, metod, değişken veya type a ekstra metadata bilgisi eklemektir. @ işareti ile tanımlanırlar ve value, pair çiftine "element" adı verilir. 
- Interface gibi davranırlar. Sınıf yapısını değiştirmeden bilgi eklerler.
- Uygulama datasını yönetmek için sınıf-data ilişkisi sağlarlar.(Mesela xml config yerine annotation config)
- Tanımlandığı yere custom bilgi ekler. 
- İsteğe bağlı metadatadır ve kendi kendine hiçbirşey yapmaz. Projendeki bütün annotation ları sil, yine derlenir proje, ama çalışmayabilir.
- Tanımladığı işi yapmazlar. Bu implementasyona bağlıdır. Metodu @SafeVarargs yazmak gerçekten onun güvenli olmasını sağlamaz.

## Create Annotation

// tanımı
public @interface Exercise {}

// kullanımı
@Exercise
@Exercise()

Kullanırken ilk gördüğü annotation olmayan type a uygulanırlar. Aynı satırda veya alt alta birden fazla annotation olması farketmez, hepsi ilk görülen type a uygulanır. Annotation ismi case-sensitive dir. Pratikte ilk harf büyük olur. Tanımladığımız bu Exercise annotation ına  marker interface denir. Element içermeyen annotation lara denir. 

## Adding element
public @interface Exercise {
   int hoursPerDay();
}

@Exercise(hoursPerDay=3)
// Artık @Exercise derlenmez! 
Çünkü default yazmadığımız her element otomatik olarak zorunludur! default keyword ekleyerek optional yapabiliriz. 

public @interface Exercise {;
   int startHour() default 6;
}

Burada default değeri null olmayan sabit bir değer olmalıdır. Şu örnekler derlenmez;
- String name() default new String("");
- String name() default null;  

Elementin type ı ise primitive type, a String, a Class, an enum, another annotation, or an array of any of these types olabilir. Wrapper classes, 1 boyuttan fazla diziler, normal sınıflar element tipi olamazlar. 

Annotation element leri dolaylı olarak abstract ve public dir. Element önüne bunları yazabilirsin ama diğer access modifier ları yazarsan derlenmez. Final yazarsan da derlenmezi abstract kuralları gibi. 

Sabit de tanımlanabilir. Aynı interface sabitleri gibi public, static, ve final olurlar. Fakat kullanırken parametre olarak geçilmemelidir, yoksa derlenemez.

![](media/create_annotation.png)

## Declare Annotations
Annotations şuralara uygulanabilir;

- Classes, interfaces, enums, and modules
- Variables ( static, instance, local)
- Methods and constructors
- Method, constructor, and lambda parameters
- Cast expressions
- Other annotations

![](media/annotation_declare.png)

## Value element
Bazı annotation lar element ismi olmadan direk parametre alırlar.(@Resouce("jdbc/test")) Bunu yapmak için şu kurallar uygulanır;
- The annotation declaration must contain an element named value(), which may be optional or required.
- The annotation declaration must not contain any other elements that are required.
- The annotation usage must not provide values for any other elements.

   public @interface Injured {
      String veterinarian() default "unassigned";
      String value() default "foot";
      int age() default 1;
   }

## Element array
public @interface Music {
   String[] genres();
}
Yukardaki tanıma iki şekilde parametre geçilebilir. Parametre bir tane ise süslü parantezler yazılmayabilir. 
   @Music(genres={"Rock and roll"}) String mostDisliked;
   @Music(genres="Classical") String favorite;
   @Music(genres={}) String alternate;

# Annotation-Specific Annotations

## Limit usage with @Target
Annotation ın hangi type lara gelebileceğini @Target ile belirtiriz. default value metodu nerelere geleceğini belirtir. Parametreleri;

![](media/target_params.png)

Örnek;
   import java.lang.annotation.ElementType;
   import java.lang.annotation.Target;

   @Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
   public @interface ZooAttraction {}

Tablodaki TYPE_USE bütün java type larını temsil eder, fakat bazı özel durumları vardır.
- void dönen metodlara eklenemez, onları METHOD parametresi ekleyebilir. 
- @Target tanımlanmamışsa default olarak herşeye gelebilir sadece TYPE_USE ve TYPE_PARAMETER hariç. Geriye uyumluluk için.

## Retention
Annotation lar compiler tarafından ignore edilir ve derleme aşamasında .class içinde yeralmaz. Fakat retention RUTIME yapılırsa yer alırlar.
@Retention(RetentionPolicy.CLASS) şeklinde tanımlanırlar.

- SOURCE 	Used only in the source file, discarded by the compiler
- CLASS 	Stored in the .class file but not available at runtime (default compiler behavior)
- RUNTIME 	Stored in the .class file and available at runtime

## @Documented
Bir annotation başına @Documented alırsa, kullanıldığı sınıfın javadoc'u üretilirken bu annotation ında bilgileri üretilir. Bir marker annotation dır. Java ve Javadoc anotasyonları farklıdır. Mesela Java da sınıf başına @Deprecated gelir. Fakat Javadoc içinde ise @deprecated küçük harfle yorum içinde bulunur. 

## @Inherited
Marker annotation dır. Bir sınıfa uygulandığında subclass lar sınıftaki anotasyon bilgisini de inherit ederler. Yani bu örnekte child sınıfta @Vertebrate dır. Eğer @Inherited olmasaydı Dolphin @Vertebrate olmayacaktı.

// Vertebrate.java
import java.lang.annotation.Inherited;

@Inherited public @interface Vertebrate {} 

// Mammal.java
@Vertebrate public class Mammal {}

// Dolphin.java
public class Dolphin extends Mammal {}

## @Repeatable
Marker annotation dır. Bir anotasyonu bir type'a birden fazla yazmak istersek repeatable kullanmamız gerekir. Çünkü bir annotation birden fazla yazılamaz, kod derlenemez. Tanımlamak için @Repeatable(types) yazarak yenibir annotation daha oluştururuz. Yeni annotation value olarak primitive dizi göstermelidir. 
   @Repeatable(Risks.class)
   public @interface Risk {
      String danger();
      int level() default 1;
   }

   public @interface Risks {
      Risk[] value();
   }

- The repeatable annotation must be declared with @Repeatable and contain a value that refers to the containing type annotation.
- The containing type annotation must include an element named value(), which is a primitive array of the repeatable annotation type.

![](media/annotation_specific_annotations.png)

# Common annotations
Bu kısımdaki annotation ı yazmayabiliriz, birşey olmaz. Ama override edilmemiş metodlara yazamayız, kod derlenmez! Fakat yazmak her zaman iyidir, hata varsa bulmamızı sağlar, kod kalitesini arttırırlar. 

- The @Override is a marker annotation that is used to indicate a method is overriding an inherited method, whether it be inherited from an interface or parent class. The overriding method must have the same  signature, the same or broader access modifier, and a covariant return type, and not declare any new or broader checked exceptions. 

- @FunctionalInterface, interfaces with exactly one abstract method. The @FunctionalInterface marker annotation can be applied to any valid functional interface. 

- @Deprecated anotasyonunu mutlaka javadoc da deprecate sebebini açıklayarak yaz. Şöyle ekstra bir kullanımı da vardır; @Deprecated(since="1.8", forRemoval=true)

- @SuppressWarnings ile compiler a ne yaptığımı biliyorum, beni uyarma deriz. Bazı parametreleri;
 - "deprecation"  ,  Ignore warnings related to types or methods marked with the @Deprecated annotation.
 - "unchecked"    ,  Ignore warnings related to the use of raw types, such as List instead of List<String>.

- @SafeVargs marker annotation indicates that a method does not perform any potential unsafe operations on its varargs parameter. It can be applied only to constructors or methods that cannot be overridden (aka methods marked private, static, or final). Varargs daki nesneler yanlış bir cast işlemi yapabilir. Bu annotation eminim bu metod güvensiz bir iş yapmıyor anlamına gelir. Aslında hatalı bir işlem yapıyorsa bu annotation ı koysak bile hatadan kaçamayız, sadece bilgilendirme annotation ıdır bu.

![](media/common_annotations.png)

![](media/common_annotations_apply.png)


