package ElementClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import TravelBase.DeviceConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class HomeScreen extends DeviceConfig{
	public AndroidDriver driver;
	String date = dateformater();

	public HomeScreen(AndroidDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy( xpath  = "//android.widget.ImageView[@content-desc='Next']") 
	public WebElement Nextbtn;
	
	@FindBy( xpath  = "//android.widget.Button[@content-desc=\"Sign Up\"]") 
	public WebElement SignUpBtn;
	
	By SignupDetailScreen = By.xpath("//android.view.View[@content-desc='Enter your personal Information to connect with us']");
	
	@FindBy( className = "android.widget.EditText") 
	public List<WebElement> ListOfEditText;
	
	@FindBy( className = "android.widget.Button") 
	public List<WebElement> ListOfButton;
	
	/*@FindBy( xpath  = "//android.view.View[@content-desc='Verify'])[2]/parent::android.widget.EditText/following-sibling::android.view.View") 
	public WebElement DateBox;*/
	
	@FindBy( xpath  = "//android.widget.Button[@content-desc='CONFIRM']")
	public WebElement DateConfirm;
	
	@FindBy( xpath  = "//android.widget.Button[@content-desc='Select Language']") 
	public WebElement LanguageDropDown;
	
	@FindBy( xpath  = "//android.view.View[@content-desc='English']") 
	public WebElement EnglishLanguage;
	
	@FindBy( className = "android.widget.SeekBar") 
	public WebElement DistanceRangeSeekBaar;
	
	@FindBy( xpath = "//android.widget.SeekBar/following-sibling::android.widget.Button") 
	public WebElement TCRadiobutton;
	
	@FindBy( xpath = "//android.view.View[@content-desc='Sign Up']") 
	public WebElement SignupClick;
	
	@FindBy( xpath = "//android.view.View[@content-desc='Personal information']") 
	public WebElement PersonalInfoView;
	
	@FindBy(id = "com.google.android.documentsui:id/dir_list" ) 
	public WebElement ImagesListPerent;
	@FindBy( className = "android.widget.EditText") 
	public WebElement TestEditor;
	@FindBy( xpath = "//android.view.View[@content-desc='Next']") 
	public WebElement NextBtn;
	@FindBy( xpath = "//android.widget.SeekBar[@content-desc='15%']") 
	public WebElement AgeSeekbar15;
	@FindBy( xpath = "//android.widget.SeekBar[@content-desc='35%']") 
	public WebElement AgeSeekbar35;
	@FindBy( xpath = "//android.view.View[@content-desc='Everyone']") 
	public WebElement EveryoneRadio;
	@FindBy( xpath = "//android.view.View[@content-desc='Solo travel']") 
	public WebElement TravelType;
	@FindBy( xpath = "//android.widget.Button[@content-desc='Skip']") 
	public WebElement SkipBtn;
	@FindBy( xpath = "//android.view.View[@content-desc='Do you smoke?']/android.view.View") 
	public WebElement DoYouSmokePerent;
	@FindBy( name = "No") 
	public WebElement NoOption;
	//1DoYouSmokeChiled .//android.widget.Button[@content-desc="No"]
	@FindBy( xpath = "//android.view.View[@content-desc='Do you drink?']/android.view.View") 
	public WebElement DoYouDrinkPerent;
	@FindBy( xpath = "//android.view.View[@content-desc=\"Done\"]") 
	public WebElement DoneBtn;

	
	
	
	
	

	public void Signup() throws InterruptedException {
		
		System.out.println("\n* Landing screen displayed.");
		wait.until(ExpectedConditions.visibilityOf(Nextbtn)).click();
		System.out.println("\n-> Clicked on Next Button to navigate on Login screen.");
		
		wait.until(ExpectedConditions.visibilityOf(SignUpBtn)).click();
		System.out.println("-> Click on the SignUp label located at the bottom which will navigate to the Signup Detail screen.");
	
		//First Name
		wait.until(ExpectedConditions.presenceOfElementLocated(SignupDetailScreen));
		System.out.println("-> Create Account screen present.");
		ListOfEditText.get(0).click();
		Thread.sleep(2000);
		ListOfEditText.get(0).sendKeys("QA");
		System.out.println("-> Entered First name.");
		
		//Skip Middle Name Initial check box
		ListOfButton.get(0).click();
		System.out.println("-> Clicked on Skip Middle Name Initial check box.");	
		
		//Last Name
		ListOfEditText.get(2).click();
		Thread.sleep(2000);
		ListOfEditText.get(2).sendKeys("Tester");
		System.out.println("-> Entered Last name.");
		
		//Country drown.
		ListOfEditText.get(3).click();
		Thread.sleep(2000);
		ListOfEditText.get(3).sendKeys("qa+37@tester.com");
		System.out.println("-> Entered Email.");
		
		//Select country from the lists
		ListOfButton.get(1).click();
		System.out.println("-> Clicked on Country dropdown.");
		Thread.sleep(2000);
		driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector()" +
                ".description(\"India\").instance(0))")).click();
		System.out.println("-> Select India from the country list.");
		
		//Phone Number
		Thread.sleep(2000);
		ListOfEditText.get(4).click();
		Thread.sleep(2000);
		ListOfEditText.get(4).sendKeys("9898989898");
		System.out.println("-> Entered Phone number.");
		
		driver.hideKeyboard();
		WebElement DateBox = driver.findElement(By.xpath("(//android.view.View[@content-desc='Verify'])[2]/parent::android.widget.EditText/following-sibling::android.view.View"));
		DateBox.click();
		System.out.println("-> Cliked on DOB field to select date.");
		
		DateConfirm.click();
		System.out.println("-> Cliked on Confirm button. Default date selected.");
		
		wait.until(ExpectedConditions.elementToBeClickable(ListOfEditText.get(4))).click();
		Thread.sleep(2000);
		ListOfEditText.get(3).sendKeys("QA@12345");
		System.out.println("-> Entered password.");
		
		driver.hideKeyboard();
		ListOfEditText.get(4).click();
		Thread.sleep(2000);
		ListOfEditText.get(3).sendKeys("QA@12345");
		System.out.println("-> Entered confirm password.");
		
		wait.until(ExpectedConditions.visibilityOf(LanguageDropDown)).click();
		System.out.println("Clicked on Language dropdown.");
		wait.until(ExpectedConditions.visibilityOf(EnglishLanguage)).click();
		System.out.println("English language slected. ");
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		int start = DistanceRangeSeekBaar.getLocation().getX();
		int end = DistanceRangeSeekBaar.getLocation().getY();		
		int moveTo = (int) (end * 0.4);
		actions.clickAndHold(DistanceRangeSeekBaar).moveToElement(DistanceRangeSeekBaar, start, moveTo).release().perform();
		System.out.println("Select distance range.");	
		
		TCRadiobutton.click();
		System.out.println("Clicked on Term and Condition radio button");
				
		wait.until(ExpectedConditions.elementToBeClickable(SignupClick)).click();
		System.out.println("Clicked Signup button.");
		
		wait.until(ExpectedConditions.visibilityOf(PersonalInfoView));
		WebElement childImageXpath = PersonalInfoView.findElement(By.className("android.widget.ImageView"));
		childImageXpath.click();
		System.out.println("Clicked on Image controller button.");
		Thread.sleep(3000);
	}
	public void TempXpathActions() {
		/*
		
		wait.until(ExpectedConditions.visibilityOf(ImageViewPerentXpath));
		WebElement childImageXpath = ImageViewPerentXpath.findElement(By.className("android.widget.ImageView"));
		childImageXpath.click();
		System.out.println("Clicked on Image controller button.");
		Thread.sleep(3000);

		List<WebElement> childImagelist = ImagesListPerent.findElements(By.className("android.widget.LinearLayout"));
		childImagelist.get(1).click();
		System.out.println("Profile Image selected.");
		
		
		wait.until(ExpectedConditions.visibilityOf(TestEditor)).click();
		TestEditor.sendKeys("This is the testig discription....");
		System.out.println("Added Discription.");
		driver.hideKeyboard();
		
		NextBtn.click();
		System.out.println("Clicked on Next button");
		
		wait.until(ExpectedConditions.visibilityOf(AgeSeekbar15));
		int startX = AgeSeekbar15.getLocation().getX();
		int wid = AgeSeekbar15.getSize().getWidth();
		//int endY = AgeSeekbar15.getLocation().getY();		
		int moveToXtoY = (int) (wid * 0.4);
		actions.clickAndHold(AgeSeekbar15).moveByOffset(startX, moveToXtoY).release().perform();
		System.out.println("Select distance range");
		
		wait.until(ExpectedConditions.visibilityOf(NextBtn)).click();
		*/
		}
}
