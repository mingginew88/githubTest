//package test_object;
//
//import java.util.Vector;
//
//
//public class ProductTest2 {
//	
//	public static void main(String[] args) {
//		
//	}
//	
//
//}
//
//
//class Product3{
//	Vector v = new Vector();
//	
//	String name;
//	int price;
//	int bonusPoint;
//	
//	public Product3(String name, int price){
//		this.name = name;
//		this.price = price;
//		bonusPoint = price/100;
//	}	
//}
//
//
//class Tv2 extends Product3{
//	Tv2(String name, int price){
//		super(name, price);
//	}
//
//	@Override			//alt shift s  -> s  toString생성
//	public String toString() {
//		return "Tv2";
//	}	
//}
//
//class Dron extends Product3{
//	public Dron(String name, int price){
//		super(name, price);
//	}
//
//	@Override
//	public String toString() {
//		return "Dron";
//	}	
//}