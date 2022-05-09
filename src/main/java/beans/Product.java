package beans;

public class Product {
	private String code;
	private String name;
	private float price;
	public Product(String code,String name,float price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	public void printlnInfor(){
		System.out.println("code: "+code);
		System.out.println("name: "+name);
		System.out.println("price: "+price);
		
	}
	
}
