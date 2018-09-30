package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GovernmentTaxes {
    private SimpleIntegerProperty government_tax_identity;
    private SimpleStringProperty government_tax_day;
    private  SimpleStringProperty government_tax_month;
    private  SimpleIntegerProperty government_tax_year;
    private  SimpleIntegerProperty government_tax_date;
    private SimpleDoubleProperty government_tax_value;
    private  SimpleIntegerProperty government_tax_product_id;

    public GovernmentTaxes(int identity,String day,int date, String month,int year,int product,double cost_value ){
        this.government_tax_identity = new SimpleIntegerProperty(identity);
        this.government_tax_day = new SimpleStringProperty(day);
        this.government_tax_date = new SimpleIntegerProperty(date);
        this.government_tax_month = new SimpleStringProperty(month);
        this.government_tax_year = new SimpleIntegerProperty(year);
        this.government_tax_value = new SimpleDoubleProperty(cost_value);
        this.government_tax_product_id = new SimpleIntegerProperty(product);
    }

    public int getGovernment_tax_identity() {
        return government_tax_identity.get();
    }

    public SimpleIntegerProperty government_tax_identityProperty() {
        return government_tax_identity;
    }

    public void setGovernment_tax_identity(int government_tax_identity) {
        this.government_tax_identity.set(government_tax_identity);
    }

    public String getGovernment_tax_day() {
        return government_tax_day.get();
    }

    public SimpleStringProperty government_tax_dayProperty() {
        return government_tax_day;
    }

    public void setGovernment_tax_day(String government_tax_day) {
        this.government_tax_day.set(government_tax_day);
    }

    public String getGovernment_tax_month() {
        return government_tax_month.get();
    }

    public SimpleStringProperty government_tax_monthProperty() {
        return government_tax_month;
    }

    public void setGovernment_tax_month(String government_tax_month) {
        this.government_tax_month.set(government_tax_month);
    }

    public int getGovernment_tax_year() {
        return government_tax_year.get();
    }

    public SimpleIntegerProperty government_tax_yearProperty() {
        return government_tax_year;
    }

    public void setGovernment_tax_year(int government_tax_year) {
        this.government_tax_year.set(government_tax_year);
    }

    public int getGovernment_tax_date() {
        return government_tax_date.get();
    }

    public SimpleIntegerProperty government_tax_dateProperty() {
        return government_tax_date;
    }

    public void setGovernment_tax_date(int government_tax_date) {
        this.government_tax_date.set(government_tax_date);
    }

    public double getGovernment_tax_value() {
        return government_tax_value.get();
    }

    public SimpleDoubleProperty government_tax_valueProperty() {
        return government_tax_value;
    }

    public void setGovernment_tax_value(double government_tax_value) {
        this.government_tax_value.set(government_tax_value);
    }

    public int getGovernment_tax_product_id() {
        return government_tax_product_id.get();
    }

    public SimpleIntegerProperty government_tax_product_idProperty() {
        return government_tax_product_id;
    }

    public void setGovernment_tax_product_id(int government_tax_product_id) {
        this.government_tax_product_id.set(government_tax_product_id);
    }
}
