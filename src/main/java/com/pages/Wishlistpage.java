package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class Wishlistpage {
	int price;
	private WebDriver driver;
	
	
	// All the xpath are stored here
	private By Home=By.xpath("//*[@id=\"menu-item-309\"]/a");
    private By Addtowishlist= By.xpath("//a[@data-title='Add to wishlist']");
    private By Singleshirt=By.xpath("//*[@id=\"site-content\"]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[3]/div/div[2]/div/div/a/span");
    private By BlackPants =By.xpath("//*[@id=\"site-content\"]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[1]/div/div[2]/div/div/a/span");
    private By Modern= By.xpath("//*[@id=\"site-content\"]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[2]/div/div[2]/div/div/a/span");
    private By Womendress=By.xpath("//*[@id=\"site-content\"]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[4]/div/div[2]/div/div/a/span");
    private By Clickwishlist = By.xpath("//*[@id=\"blog\"]/div[3]/div[1]/div/div/div[3]/div[3]/a/i");    
    By Cookieaccept=By.xpath("//*[@id=\"cc-window\"]/div[5]/a[1]");
    By Wishlisttablecol=By.xpath("//table/tbody/tr[1]/td");
    By Wishlisttablerow=By.xpath("//td[@class='product-price']");
   private By Lowestpricelinks=By.xpath("//td[@class='product-add-to-cart']/a");
   

    // Constructor of the page class:
	public Wishlistpage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page actions: features(behavior) of the page the form of methods:

		public  void additemstowishlist()  {
			
			driver.findElement(Cookieaccept).click();		
			driver.findElement(Home).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(Singleshirt).click();
			driver.findElement(Home).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(BlackPants).click();
			driver.findElement(Home).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(Modern).click();
			driver.findElement(Home).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(Womendress).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		//method to navigate wishlist
		public void viewmywishlist() {
			driver.findElement(Clickwishlist).click();
		}
		//This methods reads the number of cols in the  table in the wishlist page
		public void viewwishlisttable() {
			
//			List<WebElement> col =  driver.findElements(By.xpath("Wishlisttablecol"));
//			
//			System.out.println("No of cols are : "+col.size());
			
			List<WebElement> row =driver.findElements(Wishlisttablerow);
			List<String> pricelelement = new ArrayList<>();
			
			row.forEach(pr->pricelelement.add(pr.getAttribute("innerText")));
			System.out.println(pricelelement);
			
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("No of rows are : "+row.size());
		}
		
		private  List<Double> cleansePriceList(List<String> priceList){
	        List<Double> priceListDecimals=new ArrayList<>();
	        double priceInDecimal=0.0;
	        for(String price: priceList){
	            if(price.contains("–")){
	                priceInDecimal=Double.valueOf(price.split("–")[0].replace("£","").trim());

	            }else if(!price.contains("–")&&price.contains(" ")){
	                priceInDecimal=Double.valueOf(price.split(" ")[1].replace("£","").trim());
	            }
	            else{
	                priceInDecimal=Double.valueOf(price.replace("£","").trim());
	            }
	            priceListDecimals.add(priceInDecimal);
	        }
	        return priceListDecimals;

	    }
		private  int getMinIndex(List<Double> prices){
	        int pivot=0;
	        double currentValue=prices.get(0);
	        for(int i=0;i<prices.size();i++){
	            if(currentValue>=prices.get(i)){
	                currentValue=prices.get(i);
	                pivot=i;
	            }
	        }
	        return pivot;

		
	}
		public void findthelowestprice(List<String> pricelelement) {
			List<WebElement> addtoCartLinks =driver.findElements(Lowestpricelinks);
			int index=(getMinIndex(cleansePriceList(pricelelement)));
			addtoCartLinks.get(index).click();
		}
}