public class Product {
    private String name;
    private double price;
    private String currency;
    private String inmageLink;


    public Product(String name, double price, String currency, String inmageLink) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.inmageLink = inmageLink;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInmageLink() {
        return inmageLink;
    }



}
