package inheritance.test1;

public class EV6 extends KIA {
	int chargeBattery;
	String softwareModel;
	
	public EV6() {
		super();
		System.out.println("EV6() 생성자 호출됨");
	}
	
	public void driveAutonomously() {
		System.out.println("EV6가 자율주행을 하다");
	}
	
	@Override
	public void stop() {
		System.out.println("EV2가 멈춘다.");
	}
	
	@Override
	public void turn(String derection) {
		System.out.println("EV6 가 " + derection + "회전하다");
	}
 }//class