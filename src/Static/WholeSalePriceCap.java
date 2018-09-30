package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WholeSalePriceCap {
    private SimpleIntegerProperty wholesales_id;
    private SimpleIntegerProperty wholesales_product_id;
    private SimpleStringProperty wholesales_day;
    private SimpleIntegerProperty wholesales_date;
    private SimpleStringProperty wholesales_month;
    private SimpleIntegerProperty wholesales_year;
    private SimpleDoubleProperty wholesales_value;

    public WholeSalePriceCap(int id, int product_id, String day, int date, String month, int year, double value){

        this.wholesales_id = new SimpleIntegerProperty(id);
        this.wholesales_product_id = new SimpleIntegerProperty(product_id);
        this.wholesales_day = new SimpleStringProperty(day);
        this.wholesales_date = new SimpleIntegerProperty(date);
        this.wholesales_month = new SimpleStringProperty(month);
        this.wholesales_year = new SimpleIntegerProperty(year);
        this.wholesales_value = new SimpleDoubleProperty(value);
    }

    public int getWholesales_id() {
        return wholesales_id.get();
    }

    public SimpleIntegerProperty wholesales_idProperty() {
        return wholesales_id;
    }

    public void setWholesales_id(int wholesales_id) {
        this.wholesales_id.set(wholesales_id);
    }

    public int getWholesales_product_id() {
        return wholesales_product_id.get();
    }

    public SimpleIntegerProperty wholesales_product_idProperty() {
        return wholesales_product_id;
    }

    public void setWholesales_product_id(int wholesales_product_id) {
        this.wholesales_product_id.set(wholesales_product_id);
    }

    public String getWholesales_day() {
        return wholesales_day.get();
    }

    public SimpleStringProperty wholesales_dayProperty() {
        return wholesales_day;
    }

    public void setWholesales_day(String wholesales_day) {
        this.wholesales_day.set(wholesales_day);
    }

    public int getWholesales_date() {
        return wholesales_date.get();
    }

    public SimpleIntegerProperty wholesales_dateProperty() {
        return wholesales_date;
    }

    public void setWholesales_date(int wholesales_date) {
        this.wholesales_date.set(wholesales_date);
    }

    public String getWholesales_month() {
        return wholesales_month.get();
    }

    public SimpleStringProperty wholesales_monthProperty() {
        return wholesales_month;
    }

    public void setWholesales_month(String wholesales_month) {
        this.wholesales_month.set(wholesales_month);
    }

    public int getWholesales_year() {
        return wholesales_year.get();
    }

    public SimpleIntegerProperty wholesales_yearProperty() {
        return wholesales_year;
    }

    public void setWholesales_year(int wholesales_year) {
        this.wholesales_year.set(wholesales_year);
    }

    public double getWholesales_value() {
        return wholesales_value.get();
    }

    public SimpleDoubleProperty wholesales_valueProperty() {
        return wholesales_value;
    }

    public void setWholesales_value(double wholesales_value) {
        this.wholesales_value.set(wholesales_value);
    }
}
