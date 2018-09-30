package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ActualDemurrageCostStatic {
    private SimpleIntegerProperty actual_demurrage_cost_id;
    private SimpleIntegerProperty actual_demurrage_cost_product_id;
    private SimpleStringProperty actual_demurrage_cost_day;
    private SimpleIntegerProperty actual_demurrage_cost_date;
    private SimpleStringProperty actual_demurrage_cost_month;
    private SimpleIntegerProperty actual_demurrage_cost_year;
    private SimpleDoubleProperty actual_demurrage_cost_value;
    private SimpleIntegerProperty actual_demurrage_cost_exchangerate;
    private SimpleIntegerProperty actual_demurrage_cost_waa_conversion_factor;
    private SimpleIntegerProperty actual_demurrage_cost_actual_demurrage_factor_small_vessel;
    private SimpleIntegerProperty actual_demurrage_cost_actual_demurrage_factor_big_vessel;

    public ActualDemurrageCostStatic(int identity,int product,String day,int date, String month,int year,double cost_value,
                                     int exchangrate_id,int waa_conversion_factor_id, int actual_demurrage_factor_small,
                                     int actual_demurrage_factor_big){

        this.actual_demurrage_cost_id = new SimpleIntegerProperty(identity);
        this.actual_demurrage_cost_day = new SimpleStringProperty(day);
        this.actual_demurrage_cost_date = new SimpleIntegerProperty(date);
        this.actual_demurrage_cost_month = new SimpleStringProperty(month);
        this.actual_demurrage_cost_year = new SimpleIntegerProperty(year);
        this.actual_demurrage_cost_product_id = new SimpleIntegerProperty(product);
        this.actual_demurrage_cost_value = new SimpleDoubleProperty(cost_value);
        this.actual_demurrage_cost_exchangerate = new SimpleIntegerProperty(exchangrate_id);
        this.actual_demurrage_cost_waa_conversion_factor = new SimpleIntegerProperty(waa_conversion_factor_id);
        this.actual_demurrage_cost_actual_demurrage_factor_small_vessel = new SimpleIntegerProperty(actual_demurrage_factor_small);
        this.actual_demurrage_cost_actual_demurrage_factor_big_vessel = new SimpleIntegerProperty(actual_demurrage_factor_big);

    }

    public int getActual_demurrage_cost_id() {
        return actual_demurrage_cost_id.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_idProperty() {
        return actual_demurrage_cost_id;
    }

    public void setActual_demurrage_cost_id(int actual_demurrage_cost_id) {
        this.actual_demurrage_cost_id.set(actual_demurrage_cost_id);
    }

    public int getActual_demurrage_cost_product_id() {
        return actual_demurrage_cost_product_id.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_product_idProperty() {
        return actual_demurrage_cost_product_id;
    }

    public void setActual_demurrage_cost_product_id(int actual_demurrage_cost_product_id) {
        this.actual_demurrage_cost_product_id.set(actual_demurrage_cost_product_id);
    }

    public String getActual_demurrage_cost_day() {
        return actual_demurrage_cost_day.get();
    }

    public SimpleStringProperty actual_demurrage_cost_dayProperty() {
        return actual_demurrage_cost_day;
    }

    public void setActual_demurrage_cost_day(String actual_demurrage_cost_day) {
        this.actual_demurrage_cost_day.set(actual_demurrage_cost_day);
    }

    public int getActual_demurrage_cost_date() {
        return actual_demurrage_cost_date.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_dateProperty() {
        return actual_demurrage_cost_date;
    }

    public void setActual_demurrage_cost_date(int actual_demurrage_cost_date) {
        this.actual_demurrage_cost_date.set(actual_demurrage_cost_date);
    }

    public String getActual_demurrage_cost_month() {
        return actual_demurrage_cost_month.get();
    }

    public SimpleStringProperty actual_demurrage_cost_monthProperty() {
        return actual_demurrage_cost_month;
    }

    public void setActual_demurrage_cost_month(String actual_demurrage_cost_month) {
        this.actual_demurrage_cost_month.set(actual_demurrage_cost_month);
    }

    public int getActual_demurrage_cost_year() {
        return actual_demurrage_cost_year.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_yearProperty() {
        return actual_demurrage_cost_year;
    }

    public void setActual_demurrage_cost_year(int actual_demurrage_cost_year) {
        this.actual_demurrage_cost_year.set(actual_demurrage_cost_year);
    }

    public double getActual_demurrage_cost_value() {
        return actual_demurrage_cost_value.get();
    }

    public SimpleDoubleProperty actual_demurrage_cost_valueProperty() {
        return actual_demurrage_cost_value;
    }

    public void setActual_demurrage_cost_value(double actual_demurrage_cost_value) {
        this.actual_demurrage_cost_value.set(actual_demurrage_cost_value);
    }

    public int getActual_demurrage_cost_exchangerate() {
        return actual_demurrage_cost_exchangerate.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_exchangerateProperty() {
        return actual_demurrage_cost_exchangerate;
    }

    public void setActual_demurrage_cost_exchangerate(int actual_demurrage_cost_exchangerate) {
        this.actual_demurrage_cost_exchangerate.set(actual_demurrage_cost_exchangerate);
    }

    public int getActual_demurrage_cost_waa_conversion_factor() {
        return actual_demurrage_cost_waa_conversion_factor.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_waa_conversion_factorProperty() {
        return actual_demurrage_cost_waa_conversion_factor;
    }

    public void setActual_demurrage_cost_waa_conversion_factor(int actual_demurrage_cost_waa_conversion_factor) {
        this.actual_demurrage_cost_waa_conversion_factor.set(actual_demurrage_cost_waa_conversion_factor);
    }

    public int getActual_demurrage_cost_actual_demurrage_factor_small_vessel() {
        return actual_demurrage_cost_actual_demurrage_factor_small_vessel.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_actual_demurrage_factor_small_vesselProperty() {
        return actual_demurrage_cost_actual_demurrage_factor_small_vessel;
    }

    public void setActual_demurrage_cost_actual_demurrage_factor_small_vessel(int actual_demurrage_cost_actual_demurrage_factor_small_vessel) {
        this.actual_demurrage_cost_actual_demurrage_factor_small_vessel.set(actual_demurrage_cost_actual_demurrage_factor_small_vessel);
    }

    public int getActual_demurrage_cost_actual_demurrage_factor_big_vessel() {
        return actual_demurrage_cost_actual_demurrage_factor_big_vessel.get();
    }

    public SimpleIntegerProperty actual_demurrage_cost_actual_demurrage_factor_big_vesselProperty() {
        return actual_demurrage_cost_actual_demurrage_factor_big_vessel;
    }

    public void setActual_demurrage_cost_actual_demurrage_factor_big_vessel(int actual_demurrage_cost_actual_demurrage_factor_big_vessel) {
        this.actual_demurrage_cost_actual_demurrage_factor_big_vessel.set(actual_demurrage_cost_actual_demurrage_factor_big_vessel);
    }
}
