package basic;

import java.util.HashSet;

public class EqualHashCodeTest {
	public static void main(String[] args) {
		
		HashSet<Person> set = new HashSet<Person>();
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("일지매");
		
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("일지매");
		
		//equals()메서드로 값이 같은지 비교
		System.out.println(p1.equals(p2));
		
		set.add(p1);
		set.add(p2);
		
		
		//equals 뿐만아니라 hashcode도 동일한 값으로 비교되게?? 해주어야 같은값으로 인식한다.
		System.out.println("set ==> " + set);
		
	}
}


class Person{
	private int id;
	private String name;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}





