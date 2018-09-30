package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WAAConversionFactor {
    private  SimpleIntegerProperty waac_identity;
    private  SimpleStringProperty waac_product;
    private  SimpleStringProperty waac_day;
    private  SimpleIntegerProperty waac_date;
    private  SimpleStringProperty waac_month;
    private  SimpleIntegerProperty waac_year;
    private  SimpleDoubleProperty waac_value;

    public WAAConversionFactor(int waac_identity, String waac_product,
                               String waac_day, int waac_date,
                               String waac_month, int waac_year, double waac_value) {
        this.waac_date = new SimpleIntegerProperty(waac_date);
        this.waac_day = new SimpleStringProperty(waac_day);
        this.waac_identity = new SimpleIntegerProperty(waac_identity);
        this.waac_month = new SimpleStringProperty(waac_month);
        this.waac_product =new SimpleStringProperty(waac_product);
        this.waac_value = new SimpleDoubleProperty( waac_value);
        this.waac_year = new SimpleIntegerProperty(waac_year);
    }



    public int getWaac_date() {
        return waac_date.get();
    }

    public SimpleIntegerProperty waac_dateProperty() {
        return waac_date;
    }

    public void setWaac_date(int waac_date) {
        this.waac_date.set(waac_date);
    }

    public String getWaac_day() {
        return waac_day.get();
    }

    public SimpleStringProperty waac_dayProperty() {
        return waac_day;
    }

    public void setWaac_day(String waac_day) {
        this.waac_day.set(waac_day);
    }

    public int getWaac_identity() {
        return waac_identity.get();
    }

    public SimpleIntegerProperty waac_identityProperty() {
        return waac_identity;
    }

    public void setWaac_identity(int waac_identity) {
        this.waac_identity.set(waac_identity);
    }

    public String getWaac_month() {
        return waac_month.get();
    }

    public SimpleStringProperty waac_monthProperty() {
        return waac_month;
    }

    public void setWaac_month(String waac_month) {
        this.waac_month.set(waac_month);
    }

    public String getWaac_product() {
        return waac_product.get();
    }

    public SimpleStringProperty waac_productProperty() {
        return waac_product;
    }

    public void setWaac_product(String waac_product) {
        this.waac_product.set(waac_product);
    }

    public double getWaac_value() {
        return waac_value.get();
    }

    public SimpleDoubleProperty waac_valueProperty() {
        return waac_value;
    }

    public void setWaac_value(double waac_value) {
        this.waac_value.set(waac_value);
    }

    public int getWaac_year() {
        return waac_year.get();
    }

    public SimpleIntegerProperty waac_yearProperty() {
        return waac_year;
    }

    public void setWaac_year(int waac_year) {
        this.waac_year.set(waac_year);
    }
}
