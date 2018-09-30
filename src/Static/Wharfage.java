package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wharfage {
    private SimpleIntegerProperty wharfage_id;
    private SimpleIntegerProperty wharfage_product_id;
    private SimpleStringProperty wharfage_day;
    private SimpleIntegerProperty wharfage_date;
    private SimpleStringProperty wharfage_month;
    private SimpleIntegerProperty wharfage_year;
    private SimpleDoubleProperty wharfage_value;
    private SimpleIntegerProperty wharfage_exchangerate;
    private SimpleIntegerProperty wharfage_waa_conversion_factor;

    public Wharfage(int id, int product_id, String day, int date, String month, int year, double fip_value,
                          int exchangerate_id, int waa_id){
        this.wharfage_id = new SimpleIntegerProperty(id);
        this.wharfage_product_id = new SimpleIntegerProperty(product_id);
        this.wharfage_day = new SimpleStringProperty(day);
        this.wharfage_date = new SimpleIntegerProperty(date);
        this.wharfage_month = new SimpleStringProperty(month);
        this.wharfage_year = new SimpleIntegerProperty(year);
        this.wharfage_value = new SimpleDoubleProperty(fip_value);
        this.wharfage_exchangerate = new SimpleIntegerProperty(exchangerate_id);
        this.wharfage_waa_conversion_factor = new SimpleIntegerProperty(waa_id);
    }

    public int getWharfage_id() {
        return wharfage_id.get();
    }

    public SimpleIntegerProperty wharfage_idProperty() {
        return wharfage_id;
    }

    public void setWharfage_id(int wharfage_id) {
        this.wharfage_id.set(wharfage_id);
    }

    public int getWharfage_product_id() {
        return wharfage_product_id.get();
    }

    public SimpleIntegerProperty wharfage_product_idProperty() {
        return wharfage_product_id;
    }

    public void setWharfage_product_id(int wharfage_product_id) {
        this.wharfage_product_id.set(wharfage_product_id);
    }

    public String getWharfage_day() {
        return wharfage_day.get();
    }

    public SimpleStringProperty wharfage_dayProperty() {
        return wharfage_day;
    }

    public void setWharfage_day(String wharfage_day) {
        this.wharfage_day.set(wharfage_day);
    }

    public int getWharfage_date() {
        return wharfage_date.get();
    }

    public SimpleIntegerProperty wharfage_dateProperty() {
        return wharfage_date;
    }

    public void setWharfage_date(int wharfage_date) {
        this.wharfage_date.set(wharfage_date);
    }

    public String getWharfage_month() {
        return wharfage_month.get();
    }

    public SimpleStringProperty wharfage_monthProperty() {
        return wharfage_month;
    }

    public void setWharfage_month(String wharfage_month) {
        this.wharfage_month.set(wharfage_month);
    }

    public int getWharfage_year() {
        return wharfage_year.get();
    }

    public SimpleIntegerProperty wharfage_yearProperty() {
        return wharfage_year;
    }

    public void setWharfage_year(int wharfage_year) {
        this.wharfage_year.set(wharfage_year);
    }

    public double getWharfage_value() {
        return wharfage_value.get();
    }

    public SimpleDoubleProperty wharfage_valueProperty() {
        return wharfage_value;
    }

    public void setWharfage_value(double wharfage_value) {
        this.wharfage_value.set(wharfage_value);
    }

    public int getWharfage_exchangerate() {
        return wharfage_exchangerate.get();
    }

    public SimpleIntegerProperty wharfage_exchangerateProperty() {
        return wharfage_exchangerate;
    }

    public void setWharfage_exchangerate(int wharfage_exchangerate) {
        this.wharfage_exchangerate.set(wharfage_exchangerate);
    }

    public int getWharfage_waa_conversion_factor() {
        return wharfage_waa_conversion_factor.get();
    }

    public SimpleIntegerProperty wharfage_waa_conversion_factorProperty() {
        return wharfage_waa_conversion_factor;
    }

    public void setWharfage_waa_conversion_factor(int wharfage_waa_conversion_factor) {
        this.wharfage_waa_conversion_factor.set(wharfage_waa_conversion_factor);
    }
}
