package inheritance.test1;

public class Car {
	String manufacturer; //제조사
	String name; //차 이름
	int displacement; //배기량
	
//	public Car() {
//		System.out.println("Car() 생성자 호출됨");
//	}
	
	public Car(String manufacturer, String name, int displacement) {
		super(); //생략가능
		this.manufacturer = manufacturer;
		this.name = name;
		this.displacement = displacement;
		System.out.println("Car(String manufacturer, String name, int displacement) 생성자 호출됨");
	}

	public void start() {
		System.out.println("자동차 시동을 걸다.");
	}
}