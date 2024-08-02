package testng;

import org.testng.annotations.Test;


public class Testng_Demo {
	//if we run as java appl
	//o/p=> Hello from main()
	
	//if we run as testng
	//o/p=> Hie from testng demo

	public static void main(String[] args) {
		System.out.println("Hello from main()");

	}
	
	@Test
	public void demo()
	{
		System.out.println("Hie from testng demo");
	}

}
