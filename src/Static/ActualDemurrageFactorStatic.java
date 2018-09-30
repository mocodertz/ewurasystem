package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ActualDemurrageFactorStatic {
    private SimpleIntegerProperty actual_demurrage_cost_id;
    private SimpleIntegerProperty actual_demurrage_cost_product_id;
    private SimpleStringProperty actual_demurrage_cost_day;
    private SimpleIntegerProperty actual_demurrage_cost_date;
    private SimpleStringProperty actual_demurrage_cost_month;
    private SimpleIntegerProperty actual_demurrage_cost_year;
    private SimpleStringProperty actual_demurrage_cost_type;
    private SimpleDoubleProperty actual_demurrage_cost_value;

    public ActualDemurrageFactorStatic(int id, int product_id, String day, int date, String month, int year, String type,
                                       double value){
        this.actual_demurrage_cost_id = new SimpleIntegerProperty(id);
        this.actual_demurrage_cost_product_id = new SimpleIntegerProperty(product_id);
        this.actual_demurrage_cost_day = new SimpleStringProperty(day);
        this.actual_demurrage_cost_date = new SimpleIntegerProperty(date);
        this.actual_demurrage_cost_month = new SimpleStringProperty(month);
        this.actual_demurrage_cost_year = new SimpleIntegerProperty(year);
        this.actual_demurrage_cost_type = new SimpleStringProperty(type);
        this.actual_demurrage_cost_value = new SimpleDoubleProperty(value);

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

    public String getActual_demurrage_cost_type() {
        return actual_demurrage_cost_type.get();
    }

    public SimpleStringProperty actual_demurrage_cost_typeProperty() {
        return actual_demurrage_cost_type;
    }

    public void setActual_demurrage_cost_type(String actual_demurrage_cost_type) {
        this.actual_demurrage_cost_type.set(actual_demurrage_cost_type);
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
}
