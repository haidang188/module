package exam.model;

public class Imported extends Phone {
    private String country;
    private String status;

    public Imported(int id, String name, double price, String quantity, String company, String country, String status) {
        super(id, name, price, quantity, company);
        this.country = country;
        this.status = status;
    }
    public Imported(String name, double price, String quantity, String company, String country, String status) {
        super(name, price, quantity, company, Integer.parseInt(country), status);
        this.country = country;
        this.status = status;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Imported{" +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}' + super.toString();
    }

    public String toLineString() {
        return super.getId() + "," + super.getName() + "," + super.getPrice() + "," + super.getQuantity() + ","
                + super.getCompany() + "," + country + "," + status + '}';
    }
}
