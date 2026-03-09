package exam.model;

public class Official extends Phone {
    private int period;
    private String coverage;

    public Official(int id, String name, double price, String quantity, String company, int period, String coverage) {
        super(id, name, price, quantity, company);
        this.period = period;
        this.coverage = coverage;
    }
    public Official(String name, double price, String quantity, String company, int period, String coverage) {
        super(name, price, quantity, company, period, coverage);
        this.period = period;
        this.coverage = coverage;

    }


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    @Override
    public String toString() {
        return "Official{" +
                "period=" + period +
                ", coverage='" + coverage + '\'' +
                '}' + super.toString();
    }
    public String toLineString() {
    return super.getId() + "," + super.getName() + "," + super.getPrice() + "," + super.getQuantity() + ","
            + super.getCompany() + "," + period + "," + coverage + '}';
    }
}
