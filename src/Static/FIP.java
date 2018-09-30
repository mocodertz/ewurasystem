package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FIP {
    private final SimpleIntegerProperty fip_identity;
    private final SimpleStringProperty fip_day;
    private final SimpleStringProperty fip_month;
    private final SimpleIntegerProperty fip_year;
    private final SimpleIntegerProperty fip_date;
    private final SimpleDoubleProperty fip_value;
    private final SimpleStringProperty fip_product;

    public FIP(int identity,String day,int date, String month,int year,String product,double fip_value) {
        this.fip_identity = new SimpleIntegerProperty(identity);
        this.fip_day = new SimpleStringProperty(day);
        this.fip_month = new SimpleStringProperty(month);
        this.fip_year = new SimpleIntegerProperty(year);
        this.fip_date = new SimpleIntegerProperty(date);
        this.fip_value = new SimpleDoubleProperty(fip_value);
        this.fip_product = new SimpleStringProperty(product);
    }

    public String getFip_product() {
        return fip_product.get();
    }

    public SimpleStringProperty fip_productProperty() {
        return fip_product;
    }

    public void setFip_product(String fip_product) {
        this.fip_product.set(fip_product);
    }
    public int getFip_date() {
        return fip_date.get();
    }

    public SimpleIntegerProperty fip_dateProperty() {
        return fip_date;
    }

    public void setFip_date(int fip_date) {
        this.fip_date.set(fip_date);
    }

    public String getFip_day() {
        return fip_day.get();
    }

    public SimpleStringProperty fip_dayProperty() {
        return fip_day;
    }

    public void setFip_day(String fip_day) {
        this.fip_day.set(fip_day);
    }

    public int getFip_identity() {
        return fip_identity.get();
    }

    public SimpleIntegerProperty fip_identityProperty() {
        return fip_identity;
    }

    public void setFip_identity(int fip_identity) {
        this.fip_identity.set(fip_identity);
    }

    public String getFip_month() {
        return fip_month.get();
    }

    public SimpleStringProperty fip_monthProperty() {
        return fip_month;
    }

    public void setFip_month(String fip_month) {
        this.fip_month.set(fip_month);
    }

    public double getFip_value() {
        return fip_value.get();
    }

    public SimpleDoubleProperty fip_valueProperty() {
        return fip_value;
    }

    public void setFip_value(double fip_value) {
        this.fip_value.set(fip_value);
    }

    public int getFip_year() {
        return fip_year.get();
    }

    public SimpleIntegerProperty fip_yearProperty() {
        return fip_year;
    }

    public void setFip_year(int fip_year) {
        this.fip_year.set(fip_year);
    }




}
