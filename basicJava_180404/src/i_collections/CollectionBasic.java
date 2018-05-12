package i_collections;

public class CollectionBasic {
	
	public static void main(String[] args) {
		
		/*
		  1. collection framework
		  	1) 의미
		  	 - collection : 다수의 데이터(그룹)
		  	 - framework : 표준화된 프로그래밍 방식을 의미한다.
		  	 
		  2. 핵심 interface
		  	 - List
		  	   : 순서가 있다.
		  	   : 데이터의 중복을 허용한다.
		  	     예) 대기자 명단
		  	   : ArrayList, LinkedList, Stack, Vector 등...  
		  	 - Set
		  	   : 순서가 없다.
		  	   : 데이터의 중복을 허용하지않는다.
		  	     예) 양의 정수의 집합, 소수의 집합...
		  	   : HashSet, TreeSet(트리는 검색용도로 사용된다)...  
		  	 - Map
		  	   : 키(key) 와 값(value)로 이루어진 데이터의 집합.
		  	   : 순서가 없다.
		  	   : 키는 중복을 허용하지않고, 값은 중복을 허용한다.
		  	     예) 우편번호, 지역번호
		  	   : HashMap, HashTable(hashmap이 나오기전에 사용되던 아이 앞으로 쓰지않기때문에 지금은 줄이그어진다),  TreeMap, Properties ...
		  
		  3. List
		    - Vector와 ArrayList
		      : Vector는 동기화를 보장한다.
		      : Object배열을 이용해서 데이터를 순차적으로 저장한다.
		      : 배열이 커져서 기존 배열크기로 안될때 새로운 배열을 만들어 배열을 복사하게 된다.
		      
		    - LinkedList
		      : 배열의 단점을 보완하기 위해서 만들어짐
		      : 자신과 연결된 다음요소에 대한 주소값과 데이터를 구성되어 있다.
		      
		        
		    - DoubleLinkedList
		      : 자신과 연결된 다음요소에 대한 주소값, 자신과 연결된 이전요소에 대한 주소값,  자신의 데이터 로 구성되어 있다.		      
		        
		    - Stack과 Queue
		      : stack -> LIFO
		        저장 : push()
		        추출 : pop()
		        맨위 객체를 반환 : peek()
		        주어진 객체를 반환 : search()
		       
		      : Queue  -> FIFO
		        저장 : offer()
		        추출 : poll() 
		        
		   - Iterator, ListIterator
		     : 컬렉션에서 저장된 요소를 읽어오는 방법
		     
		  4. Set
		   - Set인터페이스를 구현한 가장 대표적인 컬렉션 : HashSet
		   - add나 addAll메서드를 사용하는데 이미 저장된 요소가 있다면 저장에 실패하게 된다.
		   - HashSet은 대부적으로 HashMap을 이용해 구현되어 있다.
		    
		         
		  5. HashMap과 HashTable
		    - HashTable의 최신버전이 HashMap이므로 HashMap을 사용하자
		    - Map의 특징인 키(key)와 값(value)를 묶어 하나의 데이터로 저장한다.
		    - HashMap<Object, Object>타입이지만 일반적으로 key의 경우 String형을 많이 사용한다.     
		    - key의 경우 유일해야 한다.
		    
		        
		        
		        
		        
		 
		 */
		
		
	}

}
