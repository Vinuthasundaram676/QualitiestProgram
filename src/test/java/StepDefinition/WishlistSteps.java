package StepDefinition;

import com.pages.Wishlistpage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistSteps {
	
	private Wishlistpage wishlist = new Wishlistpage(DriverFactory.getDriver());
	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list()  {
		DriverFactory.getDriver().get("https://testscriptdemo.com/");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wishlist.additemstowishlist();
		
		
	    
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		wishlist.viewmywishlist();
		
	    
	}

	@Then("I find total four selected items in my Wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
	    wishlist.viewwishlisttable();
	}

	@When("I search for the lowest price product")
	public void i_search_for_the_lowest_price_product() {
	    
	}

	@When("I am able to add  the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
	    
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
	    
	}



}
