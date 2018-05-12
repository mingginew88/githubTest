package h_javaLang;

public class EqualsTest02 {
	public static void main(String[] args) {
		Person p1 = new Person(8801151111111L);
		Person p2 = new Person(8801151111111L);
		System.out.println(p1);
		System.out.println(p1.hashCode());		
		
		if(p1.equals(p2)){
			System.out.println("같은사람");
		}else{
			System.out.println("다른사람");
		}		
	}
}

class Person{	
	long id;
	public Person (long id ){
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {		
		Person p = (Person)obj;
		return id == p.id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + "]";
	}
	
	
	
	
	
}










