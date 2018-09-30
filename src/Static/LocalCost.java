package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LocalCost {
    private SimpleIntegerProperty local_cost_identity;
    private SimpleStringProperty local_cost_day;
    private  SimpleStringProperty local_cost_month;
    private  SimpleIntegerProperty local_cost_year;
    private  SimpleIntegerProperty local_cost_date;
    private SimpleDoubleProperty local_cost_value;
    private  SimpleIntegerProperty local_cost_product_id;

    public LocalCost(int identity,String day,int date, String month,int year,int product,double cost_value ){
        this.local_cost_identity = new SimpleIntegerProperty(identity);
        this.local_cost_day = new SimpleStringProperty(day);
        this.local_cost_date = new SimpleIntegerProperty(date);
        this.local_cost_month = new SimpleStringProperty(month);
        this.local_cost_year = new SimpleIntegerProperty(year);
        this.local_cost_value = new SimpleDoubleProperty(cost_value);
        this.local_cost_product_id = new SimpleIntegerProperty(product);
    }

    public int getLocal_cost_identity() {
        return local_cost_identity.get();
    }

    public SimpleIntegerProperty local_cost_identityProperty() {
        return local_cost_identity;
    }

    public void setLocal_cost_identity(int local_cost_identity) {
        this.local_cost_identity.set(local_cost_identity);
    }

    public String getLocal_cost_day() {
        return local_cost_day.get();
    }

    public SimpleStringProperty local_cost_dayProperty() {
        return local_cost_day;
    }

    public void setLocal_cost_day(String local_cost_day) {
        this.local_cost_day.set(local_cost_day);
    }

    public String getLocal_cost_month() {
        return local_cost_month.get();
    }

    public SimpleStringProperty local_cost_monthProperty() {
        return local_cost_month;
    }

    public void setLocal_cost_month(String local_cost_month) {
        this.local_cost_month.set(local_cost_month);
    }

    public int getLocal_cost_year() {
        return local_cost_year.get();
    }

    public SimpleIntegerProperty local_cost_yearProperty() {
        return local_cost_year;
    }

    public void setLocal_cost_year(int local_cost_year) {
        this.local_cost_year.set(local_cost_year);
    }

    public int getLocal_cost_date() {
        return local_cost_date.get();
    }

    public SimpleIntegerProperty local_cost_dateProperty() {
        return local_cost_date;
    }

    public void setLocal_cost_date(int local_cost_date) {
        this.local_cost_date.set(local_cost_date);
    }

    public double getLocal_cost_value() {
        return local_cost_value.get();
    }

    public SimpleDoubleProperty local_cost_valueProperty() {
        return local_cost_value;
    }

    public void setLocal_cost_value(double local_cost_value) {
        this.local_cost_value.set(local_cost_value);
    }

    public int getLocal_cost_product_id() {
        return local_cost_product_id.get();
    }

    public SimpleIntegerProperty local_cost_product_idProperty() {
        return local_cost_product_id;
    }

    public void setLocal_cost_product_id(int local_cost_product_id) {
        this.local_cost_product_id.set(local_cost_product_id);
    }
}
