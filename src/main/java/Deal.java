public class Deal {
    private int length;
    private int width;
    private double price;

    public Deal(int length, int width, double price) {
        this.length = length;
        this.width = width;
        this.price = Math.round(price * 100.0) / 100.0;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Deal {" +
                "length = " + length +
                ", width =" + width +
                ", price per square meter = " + price +
                '}';
    }
}
