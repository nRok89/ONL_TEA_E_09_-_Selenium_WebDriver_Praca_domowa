package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchPage {

    private static WebDriver driver;


    @FindBy(id = "hotel_location")
    private WebElement locationInput;

    @FindBy(id = "check_in_time")
    private WebElement inTimeButtom;

    @FindBy(id = "check_out_time")
    private WebElement outTimeButtom;

    @FindBy(id = "search_room_submit")
    private  WebElement searchSubmit;

    @FindBy(id = "hotel_cat_name")
    private  WebElement hotelButtom;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[5]/div/div/div[2]/div/form/div[2]/div/ul/li")
    private  WebElement hotelPrimeButtom;

//    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/p[1]")
//    private WebElement myHotel;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/a")
    private WebElement myHotel;




    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void hotelDominic(String city, String inDate, String outDate){
        locationInput.click();
        locationInput.clear();
        locationInput.sendKeys(city);
        hotelButtom.click();
        hotelPrimeButtom.click();
        inTimeButtom.click();
        inTimeButtom.clear();
        inTimeButtom.sendKeys(inDate);
        outTimeButtom.click();
        outTimeButtom.clear();
        outTimeButtom.sendKeys(outDate);
        searchSubmit.click();
        myHotel.click();
    }

//    public void hotelDominic(){
//        myHotel.click();
//
//    }

    public boolean roomAdd() {
        return myHotel.isEnabled();
    }

}
