package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PumpPriceCap {
    private SimpleIntegerProperty pump_price_cap_identity;
    private SimpleStringProperty pump_price_cap_day;
    private  SimpleStringProperty pump_price_month;
    private  SimpleIntegerProperty pump_price_cap_year;
    private  SimpleIntegerProperty pump_price_cap_date;
    private SimpleDoubleProperty pump_price_cap_value;
    private  SimpleIntegerProperty pump_price_cap_product_id;

    public PumpPriceCap(int identity,String day,int date, String month,int year,int product,double cost_value ){
        this.pump_price_cap_identity = new SimpleIntegerProperty(identity);
        this.pump_price_cap_day = new SimpleStringProperty(day);
        this.pump_price_cap_date = new SimpleIntegerProperty(date);
        this.pump_price_month = new SimpleStringProperty(month);
        this.pump_price_cap_year = new SimpleIntegerProperty(year);
        this.pump_price_cap_value = new SimpleDoubleProperty(cost_value);
        this.pump_price_cap_product_id = new SimpleIntegerProperty(product);
    }

    public int getPump_price_cap_identity() {
        return pump_price_cap_identity.get();
    }

    public SimpleIntegerProperty pump_price_cap_identityProperty() {
        return pump_price_cap_identity;
    }

    public void setPump_price_cap_identity(int pump_price_cap_identity) {
        this.pump_price_cap_identity.set(pump_price_cap_identity);
    }

    public String getPump_price_cap_day() {
        return pump_price_cap_day.get();
    }

    public SimpleStringProperty pump_price_cap_dayProperty() {
        return pump_price_cap_day;
    }

    public void setPump_price_cap_day(String pump_price_cap_day) {
        this.pump_price_cap_day.set(pump_price_cap_day);
    }

    public String getPump_price_month() {
        return pump_price_month.get();
    }

    public SimpleStringProperty pump_price_monthProperty() {
        return pump_price_month;
    }

    public void setPump_price_month(String pump_price_month) {
        this.pump_price_month.set(pump_price_month);
    }

    public int getPump_price_cap_year() {
        return pump_price_cap_year.get();
    }

    public SimpleIntegerProperty pump_price_cap_yearProperty() {
        return pump_price_cap_year;
    }

    public void setPump_price_cap_year(int pump_price_cap_year) {
        this.pump_price_cap_year.set(pump_price_cap_year);
    }

    public int getPump_price_cap_date() {
        return pump_price_cap_date.get();
    }

    public SimpleIntegerProperty pump_price_cap_dateProperty() {
        return pump_price_cap_date;
    }

    public void setPump_price_cap_date(int pump_price_cap_date) {
        this.pump_price_cap_date.set(pump_price_cap_date);
    }

    public double getPump_price_cap_value() {
        return pump_price_cap_value.get();
    }

    public SimpleDoubleProperty pump_price_cap_valueProperty() {
        return pump_price_cap_value;
    }

    public void setPump_price_cap_value(double pump_price_cap_value) {
        this.pump_price_cap_value.set(pump_price_cap_value);
    }

    public int getPump_price_cap_product_id() {
        return pump_price_cap_product_id.get();
    }

    public SimpleIntegerProperty pump_price_cap_product_idProperty() {
        return pump_price_cap_product_id;
    }

    public void setPump_price_cap_product_id(int pump_price_cap_product_id) {
        this.pump_price_cap_product_id.set(pump_price_cap_product_id);
    }
}
