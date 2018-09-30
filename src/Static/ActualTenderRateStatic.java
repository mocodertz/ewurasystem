package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ActualTenderRateStatic {
    private SimpleIntegerProperty actual_tender_rate_id;
    private SimpleIntegerProperty actual_tender_rate_product_id;
    private SimpleStringProperty actual_tender_rate_day;
    private SimpleIntegerProperty actual_tender_rate_date;
    private SimpleStringProperty actual_tender_rate_month;
    private SimpleIntegerProperty actual_tender_rate_year;
    private SimpleStringProperty actual_tender_rate_type;
    private SimpleDoubleProperty actual_tender_rate_value;

    public ActualTenderRateStatic(int id, int product_id, String day, int date, String month, int year, String type,
                                  double value){

        this.actual_tender_rate_id = new SimpleIntegerProperty(id);
        this.actual_tender_rate_product_id = new SimpleIntegerProperty(product_id);
        this.actual_tender_rate_day = new SimpleStringProperty(day);
        this.actual_tender_rate_date = new SimpleIntegerProperty(date);
        this.actual_tender_rate_month = new SimpleStringProperty(month);
        this.actual_tender_rate_year = new SimpleIntegerProperty(year);
        this.actual_tender_rate_type = new SimpleStringProperty(type);
        this.actual_tender_rate_value = new SimpleDoubleProperty(value);
    }

    public int getActual_tender_rate_id() {
        return actual_tender_rate_id.get();
    }

    public SimpleIntegerProperty actual_tender_rate_idProperty() {
        return actual_tender_rate_id;
    }

    public void setActual_tender_rate_id(int actual_tender_rate_id) {
        this.actual_tender_rate_id.set(actual_tender_rate_id);
    }

    public int getActual_tender_rate_product_id() {
        return actual_tender_rate_product_id.get();
    }

    public SimpleIntegerProperty actual_tender_rate_product_idProperty() {
        return actual_tender_rate_product_id;
    }

    public void setActual_tender_rate_product_id(int actual_tender_rate_product_id) {
        this.actual_tender_rate_product_id.set(actual_tender_rate_product_id);
    }

    public String getActual_tender_rate_day() {
        return actual_tender_rate_day.get();
    }

    public SimpleStringProperty actual_tender_rate_dayProperty() {
        return actual_tender_rate_day;
    }

    public void setActual_tender_rate_day(String actual_tender_rate_day) {
        this.actual_tender_rate_day.set(actual_tender_rate_day);
    }

    public int getActual_tender_rate_date() {
        return actual_tender_rate_date.get();
    }

    public SimpleIntegerProperty actual_tender_rate_dateProperty() {
        return actual_tender_rate_date;
    }

    public void setActual_tender_rate_date(int actual_tender_rate_date) {
        this.actual_tender_rate_date.set(actual_tender_rate_date);
    }

    public String getActual_tender_rate_month() {
        return actual_tender_rate_month.get();
    }

    public SimpleStringProperty actual_tender_rate_monthProperty() {
        return actual_tender_rate_month;
    }

    public void setActual_tender_rate_month(String actual_tender_rate_month) {
        this.actual_tender_rate_month.set(actual_tender_rate_month);
    }

    public int getActual_tender_rate_year() {
        return actual_tender_rate_year.get();
    }

    public SimpleIntegerProperty actual_tender_rate_yearProperty() {
        return actual_tender_rate_year;
    }

    public void setActual_tender_rate_year(int actual_tender_rate_year) {
        this.actual_tender_rate_year.set(actual_tender_rate_year);
    }

    public String getActual_tender_rate_type() {
        return actual_tender_rate_type.get();
    }

    public SimpleStringProperty actual_tender_rate_typeProperty() {
        return actual_tender_rate_type;
    }

    public void setActual_tender_rate_type(String actual_tender_rate_type) {
        this.actual_tender_rate_type.set(actual_tender_rate_type);
    }

    public double getActual_tender_rate_value() {
        return actual_tender_rate_value.get();
    }

    public SimpleDoubleProperty actual_tender_rate_valueProperty() {
        return actual_tender_rate_value;
    }

    public void setActual_tender_rate_value(double actual_tender_rate_value) {
        this.actual_tender_rate_value.set(actual_tender_rate_value);
    }
}
