package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WeightPlattFIP {
    private SimpleIntegerProperty platt_fip_id;
    private SimpleIntegerProperty platt_fip_product_id;
    private SimpleStringProperty platt_fip_day;
    private SimpleIntegerProperty platt_fip_date;
    private SimpleStringProperty platt_fip_month;
    private SimpleIntegerProperty platt_fip_year;
    private SimpleDoubleProperty platt_fip_value;
    private SimpleIntegerProperty platt_fip_exchangerate;
    private SimpleIntegerProperty platt_fip_waa_conversion_factor;
    private SimpleIntegerProperty platt_fip_current_fip_fk;

    public WeightPlattFIP(int id, int product_id, String day, int date, String month, int year, double fip_value,
                          int exchangerate_id, int waa_id, int fip_id){
        this.platt_fip_id = new SimpleIntegerProperty(id);
        this.platt_fip_product_id = new SimpleIntegerProperty(product_id);
        this.platt_fip_day = new SimpleStringProperty(day);
        this.platt_fip_date = new SimpleIntegerProperty(date);
        this.platt_fip_month = new SimpleStringProperty(month);
        this.platt_fip_year = new SimpleIntegerProperty(year);
        this.platt_fip_value = new SimpleDoubleProperty(fip_value);
        this.platt_fip_exchangerate = new SimpleIntegerProperty(exchangerate_id);
        this.platt_fip_waa_conversion_factor = new SimpleIntegerProperty(waa_id);
        this.platt_fip_current_fip_fk = new SimpleIntegerProperty(fip_id);
    }

    public int getPlatt_fip_id() {
        return platt_fip_id.get();
    }

    public SimpleIntegerProperty platt_fip_idProperty() {
        return platt_fip_id;
    }

    public void setPlatt_fip_id(int platt_fip_id) {
        this.platt_fip_id.set(platt_fip_id);
    }

    public int getPlatt_fip_product_id() {
        return platt_fip_product_id.get();
    }

    public SimpleIntegerProperty platt_fip_product_idProperty() {
        return platt_fip_product_id;
    }

    public void setPlatt_fip_product_id(int platt_fip_product_id) {
        this.platt_fip_product_id.set(platt_fip_product_id);
    }

    public String getPlatt_fip_day() {
        return platt_fip_day.get();
    }

    public SimpleStringProperty platt_fip_dayProperty() {
        return platt_fip_day;
    }

    public void setPlatt_fip_day(String platt_fip_day) {
        this.platt_fip_day.set(platt_fip_day);
    }

    public int getPlatt_fip_date() {
        return platt_fip_date.get();
    }

    public SimpleIntegerProperty platt_fip_dateProperty() {
        return platt_fip_date;
    }

    public void setPlatt_fip_date(int platt_fip_date) {
        this.platt_fip_date.set(platt_fip_date);
    }

    public String getPlatt_fip_month() {
        return platt_fip_month.get();
    }

    public SimpleStringProperty platt_fip_monthProperty() {
        return platt_fip_month;
    }

    public void setPlatt_fip_month(String platt_fip_month) {
        this.platt_fip_month.set(platt_fip_month);
    }

    public int getPlatt_fip_year() {
        return platt_fip_year.get();
    }

    public SimpleIntegerProperty platt_fip_yearProperty() {
        return platt_fip_year;
    }

    public void setPlatt_fip_year(int platt_fip_year) {
        this.platt_fip_year.set(platt_fip_year);
    }

    public double getPlatt_fip_value() {
        return platt_fip_value.get();
    }

    public SimpleDoubleProperty platt_fip_valueProperty() {
        return platt_fip_value;
    }

    public void setPlatt_fip_value(double platt_fip_value) {
        this.platt_fip_value.set(platt_fip_value);
    }

    public int getPlatt_fip_exchangerate() {
        return platt_fip_exchangerate.get();
    }

    public SimpleIntegerProperty platt_fip_exchangerateProperty() {
        return platt_fip_exchangerate;
    }

    public void setPlatt_fip_exchangerate(int platt_fip_exchangerate) {
        this.platt_fip_exchangerate.set(platt_fip_exchangerate);
    }

    public int getPlatt_fip_waa_conversion_factor() {
        return platt_fip_waa_conversion_factor.get();
    }

    public SimpleIntegerProperty platt_fip_waa_conversion_factorProperty() {
        return platt_fip_waa_conversion_factor;
    }

    public void setPlatt_fip_waa_conversion_factor(int platt_fip_waa_conversion_factor) {
        this.platt_fip_waa_conversion_factor.set(platt_fip_waa_conversion_factor);
    }

    public int getPlatt_fip_current_fip_fk() {
        return platt_fip_current_fip_fk.get();
    }

    public SimpleIntegerProperty platt_fip_current_fip_fkProperty() {
        return platt_fip_current_fip_fk;
    }

    public void setPlatt_fip_current_fip_fk(int platt_fip_current_fip_fk) {
        this.platt_fip_current_fip_fk.set(platt_fip_current_fip_fk);
    }
}
