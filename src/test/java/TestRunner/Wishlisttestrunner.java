package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/java/Wishlistfeature/Wishlist.feature"},
			glue = {"WishlistSteps"},
			plugin = {"pretty"
					}
			)
			public class Wishlisttestrunner{
			}
			
			
			


