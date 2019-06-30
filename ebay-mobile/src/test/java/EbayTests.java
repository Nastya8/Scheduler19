import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayTests extends TestBase{

    @Test
    public void testAppOpened(){
        System.out.println("App opened");
    }
    @Test
    public void searchEbay() throws InterruptedException {
        Thread.sleep(5000);
        if(isElementPresent(By.id("search_box"))){
            clickSplash();
        }
        Thread.sleep(5000);

        typeText(By.id("search_src_text"), "Dress");
        Thread.sleep(5000);

        String articleTitle = getElementText(By.id("text"));
        Assert.assertTrue(articleTitle.toLowerCase().contains("dress"));
    }

}
