package exam.model;

public abstract class Phone {
    private int id;
    private String name;
    private double price;
    private String quantity;
    private String company;

    public Phone(int id, String name, double price, String quantity, String company) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
    }
    public Phone(String name, double price, String quantity, String company, int period, String coverage) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.company = company;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity='" + quantity + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
