package java8.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {

        List<Developer> list = init();

        Set<String> collect =
                list.stream()
                        .map(x -> x.getBook()).peek(System.out::println)                              //  Stream<Set<String>>
                        .flatMap(x -> x.stream()).peek(System.out::println)                           //  Stream<String>
                        .filter(x -> x.contains("Java"))   //  filter python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        System.out.println("---");
        collect.forEach(s -> System.out.println("Sonuc: " + s));        

	}
	
	public static List<Developer> init() {
		Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        return list;
	}

}

class Developer {

    private Integer id;
    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
    public Set<String> getBook() {
		return book;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
