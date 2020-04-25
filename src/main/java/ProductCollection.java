import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class ProductCollection {
    protected WebDriver driver = new ChromeDriver();

    List<Product> productCollection = new ArrayList<Product>();

    public static final By nameLocator = By.className("name");
    WebElement nameOfProduct = driver.findElement(nameLocator);
    public  static final By priceLocator = By.className("price");
    WebElement priceOfProduct = driver.findElement(priceLocator);
    public static final By imageLocator = By.className("image");
    WebElement imageOfProduct = driver.findElement(imageLocator);
    public static final By pageElements=By.tagName("item");
    List <WebElement> itemElements= driver.findElements(pageElements);

    public void addToCollection(){


        for(int i=0; i < itemElements.size();i++ ){
          WebElement currentItem=itemElements.get(i);

            String currentItemName = currentItem.findElement(nameLocator).getText();
            String currentItemPrice = currentItem.findElement(priceLocator).getText();
            String currentItemImage = currentItem.findElement(imageLocator).getAttribute("img");
            String [] itemPriceArray= currentItemPrice.split(" ");
            Double priceValue = Double.parseDouble(itemPriceArray[0]);
            String prceCurrency = itemPriceArray[1];


        productCollection.add(new Product(currentItemName, priceValue, prceCurrency, currentItemImage));
    }
    }

    public Double getPriceInBYN(Product product) {
        Map<String, Double> currencyExcange = new HashMap<String, Double>();
        return product.getPrice()* currencyExcange.get(product.getCurrency());
     }
      public Product findLowestProduct(){
          productCollection.sort(new Comparator<Product>() {
              public int compare(Product o1, Product o2) {

              return getPriceInBYN(o1).compareTo(getPriceInBYN(o2));

              }
          });


return null;
      }
}


