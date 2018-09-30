package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WeightPlattFOB {
    private SimpleIntegerProperty platt_fob_id;
    private SimpleIntegerProperty platt_fob_product_id;
    private SimpleStringProperty platt_fob_day;
    private SimpleIntegerProperty platt_fob_date;
    private SimpleStringProperty platt_fob_month;
    private SimpleIntegerProperty platt_fob_year;
    private SimpleDoubleProperty platt_fob_value;
    private SimpleIntegerProperty platt_fob_exchangerate;
    private SimpleIntegerProperty platt_fob_waa_conversion_factor;
    private SimpleIntegerProperty platt_fob_current_fob_fk;

    public WeightPlattFOB(int id, int product_id, String day, int date, String month, int year, double fob_value,
                          int exchangerate_id, int waa_id, int fob_id){
        this.platt_fob_id = new SimpleIntegerProperty(id);
        this.platt_fob_product_id = new SimpleIntegerProperty(product_id);
        this.platt_fob_day = new SimpleStringProperty(day);
        this.platt_fob_date = new SimpleIntegerProperty(date);
        this.platt_fob_month = new SimpleStringProperty(month);
        this.platt_fob_year = new SimpleIntegerProperty(year);
        this.platt_fob_value = new SimpleDoubleProperty(fob_value);
        this.platt_fob_exchangerate = new SimpleIntegerProperty(exchangerate_id);
        this.platt_fob_waa_conversion_factor = new SimpleIntegerProperty(waa_id);
        this.platt_fob_current_fob_fk = new SimpleIntegerProperty(fob_id);
    }

    public int getPlatt_fob_id() {
        return platt_fob_id.get();
    }

    public SimpleIntegerProperty platt_fob_idProperty() {
        return platt_fob_id;
    }

    public void setPlatt_fob_id(int platt_fob_id) {
        this.platt_fob_id.set(platt_fob_id);
    }

    public int getPlatt_fob_product_id() {
        return platt_fob_product_id.get();
    }

    public SimpleIntegerProperty platt_fob_product_idProperty() {
        return platt_fob_product_id;
    }

    public void setPlatt_fob_product_id(int platt_fob_product_id) {
        this.platt_fob_product_id.set(platt_fob_product_id);
    }

    public String getPlatt_fob_day() {
        return platt_fob_day.get();
    }

    public SimpleStringProperty platt_fob_dayProperty() {
        return platt_fob_day;
    }

    public void setPlatt_fob_day(String platt_fob_day) {
        this.platt_fob_day.set(platt_fob_day);
    }

    public int getPlatt_fob_date() {
        return platt_fob_date.get();
    }

    public SimpleIntegerProperty platt_fob_dateProperty() {
        return platt_fob_date;
    }

    public void setPlatt_fob_date(int platt_fob_date) {
        this.platt_fob_date.set(platt_fob_date);
    }

    public String getPlatt_fob_month() {
        return platt_fob_month.get();
    }

    public SimpleStringProperty platt_fob_monthProperty() {
        return platt_fob_month;
    }

    public void setPlatt_fob_month(String platt_fob_month) {
        this.platt_fob_month.set(platt_fob_month);
    }

    public int getPlatt_fob_year() {
        return platt_fob_year.get();
    }

    public SimpleIntegerProperty platt_fob_yearProperty() {
        return platt_fob_year;
    }

    public void setPlatt_fob_year(int platt_fob_year) {
        this.platt_fob_year.set(platt_fob_year);
    }

    public double getPlatt_fob_value() {
        return platt_fob_value.get();
    }

    public SimpleDoubleProperty platt_fob_valueProperty() {
        return platt_fob_value;
    }

    public void setPlatt_fob_value(double platt_fob_value) {
        this.platt_fob_value.set(platt_fob_value);
    }

    public int getPlatt_fob_exchangerate() {
        return platt_fob_exchangerate.get();
    }

    public SimpleIntegerProperty platt_fob_exchangerateProperty() {
        return platt_fob_exchangerate;
    }

    public void setPlatt_fob_exchangerate(int platt_fob_exchangerate) {
        this.platt_fob_exchangerate.set(platt_fob_exchangerate);
    }

    public int getPlatt_fob_waa_conversion_factor() {
        return platt_fob_waa_conversion_factor.get();
    }

    public SimpleIntegerProperty platt_fob_waa_conversion_factorProperty() {
        return platt_fob_waa_conversion_factor;
    }

    public void setPlatt_fob_waa_conversion_factor(int platt_fob_waa_conversion_factor) {
        this.platt_fob_waa_conversion_factor.set(platt_fob_waa_conversion_factor);
    }

    public int getPlatt_fob_current_fob_fk() {
        return platt_fob_current_fob_fk.get();
    }

    public SimpleIntegerProperty platt_fob_current_fob_fkProperty() {
        return platt_fob_current_fob_fk;
    }

    public void setPlatt_fob_current_fob_fk(int platt_fob_current_fob_fk) {
        this.platt_fob_current_fob_fk.set(platt_fob_current_fob_fk);
    }
}
