package pages;

public class Jacket {
    private String title;
    private String price;
    private String topSellerMessage;

    public Jacket(String title, String price, String topSellerMessage) {
        this.title = title;
        this.price = price;
        this.topSellerMessage = topSellerMessage;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getTopSellerMessage() {
        return topSellerMessage;
    }
}
