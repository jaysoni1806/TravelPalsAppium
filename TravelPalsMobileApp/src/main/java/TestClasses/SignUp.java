package TestClasses;

import org.testng.annotations.Test;

import TravelBase.DeviceConfig;

public class SignUp extends DeviceConfig{
	
	@Test
	public void Signup() throws InterruptedException {
		homescreen.Signup();
	}
}
