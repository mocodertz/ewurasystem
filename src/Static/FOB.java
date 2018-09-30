package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FOB {
    private  SimpleIntegerProperty fob_identity;
    private  SimpleStringProperty fob_day;
    private  SimpleStringProperty fob_month;
    private  SimpleIntegerProperty fob_year;
    private  SimpleIntegerProperty fob_date;
    private  SimpleDoubleProperty fob_value;
    private  SimpleStringProperty fob_product;

    public FOB(int identity,String day,int date, String month,int year,String product,double fob_value) {
        this.fob_identity = new SimpleIntegerProperty(identity);
        this.fob_day = new SimpleStringProperty(day);
        this.fob_month = new SimpleStringProperty(month);
        this.fob_year = new SimpleIntegerProperty(year);
        this.fob_date = new SimpleIntegerProperty(date);
        this.fob_value = new SimpleDoubleProperty(fob_value);
        this.fob_product = new SimpleStringProperty(product);
    }

    public int getFob_date() {
        return fob_date.get();
    }

    public SimpleIntegerProperty fob_dateProperty() {
        return fob_date;
    }

    public void setFob_date(int fob_date) {
        this.fob_date.set(fob_date);
    }

    public String getFob_day() {
        return fob_day.get();
    }

    public SimpleStringProperty fob_dayProperty() {
        return fob_day;
    }

    public void setFob_day(String fob_day) {
        this.fob_day.set(fob_day);
    }

    public int getFob_identity() {
        return fob_identity.get();
    }

    public SimpleIntegerProperty fob_identityProperty() {
        return fob_identity;
    }

    public void setFob_identity(int fob_identity) {
        this.fob_identity.set(fob_identity);
    }

    public String getFob_month() {
        return fob_month.get();
    }

    public SimpleStringProperty fob_monthProperty() {
        return fob_month;
    }

    public void setFob_month(String fob_month) {
        this.fob_month.set(fob_month);
    }

    public String getFob_product() {
        return fob_product.get();
    }

    public SimpleStringProperty fob_productProperty() {
        return fob_product;
    }

    public void setFob_product(String fob_product) {
        this.fob_product.set(fob_product);
    }

    public double getFob_value() {
        return fob_value.get();
    }

    public SimpleDoubleProperty fob_valueProperty() {
        return fob_value;
    }

    public void setFob_value(double fob_value) {
        this.fob_value.set(fob_value);
    }

    public int getFob_year() {
        return fob_year.get();
    }

    public SimpleIntegerProperty fob_yearProperty() {
        return fob_year;
    }

    public void setFob_year(int fob_year) {
        this.fob_year.set(fob_year);
    }
}
