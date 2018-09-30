package Static;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MarkingCost {
    private SimpleIntegerProperty marking_cost_id;
    private SimpleStringProperty marking_cost_day;
    private SimpleIntegerProperty marking_cost_date;
    private SimpleStringProperty marking_cost_month;
    private SimpleIntegerProperty marking_cost_year;
    private SimpleIntegerProperty marking_cost_exchangerate_month;
    private SimpleDoubleProperty marking_cost_value;

    public MarkingCost(int marking_cost_id, String marking_cost_day, int marking_cost_date, String marking_cost_month, int marking_cost_year,
                       int marking_cost_exchangerate, double marking_cost_value) {
        this.marking_cost_date = new SimpleIntegerProperty(marking_cost_date);
        this.marking_cost_day = new SimpleStringProperty(marking_cost_day);
        this.marking_cost_exchangerate_month = new SimpleIntegerProperty(marking_cost_exchangerate);
        this.marking_cost_id = new SimpleIntegerProperty(marking_cost_id);
        this.marking_cost_month = new SimpleStringProperty(marking_cost_month);
        this.marking_cost_value = new SimpleDoubleProperty(marking_cost_value);
        this.marking_cost_year = new SimpleIntegerProperty(marking_cost_year);
    }

    public int getMarking_cost_date() {
        return marking_cost_date.get();
    }

    public SimpleIntegerProperty marking_cost_dateProperty() {
        return marking_cost_date;
    }

    public void setMarking_cost_date(int marking_cost_date) {
        this.marking_cost_date.set(marking_cost_date);
    }

    public String getMarking_cost_day() {
        return marking_cost_day.get();
    }

    public SimpleStringProperty marking_cost_dayProperty() {
        return marking_cost_day;
    }

    public void setMarking_cost_day(String marking_cost_day) {
        this.marking_cost_day.set(marking_cost_day);
    }

    public double getMarking_cost_exchangerate() {
        return marking_cost_exchangerate_month.get();
    }

    public SimpleIntegerProperty marking_cost_exchangerateProperty() {
        return marking_cost_exchangerate_month;
    }

    public void setMarking_cost_exchangerate(int marking_cost_exchangerate_month) {
        this.marking_cost_exchangerate_month.set(marking_cost_exchangerate_month);
    }

    public int getMarking_cost_id() {
        return marking_cost_id.get();
    }

    public SimpleIntegerProperty marking_cost_idProperty() {
        return marking_cost_id;
    }

    public void setMarking_cost_id(int marking_cost_id) {
        this.marking_cost_id.set(marking_cost_id);
    }

    public String getMarking_cost_month() {
        return marking_cost_month.get();
    }

    public SimpleStringProperty marking_cost_monthProperty() {
        return marking_cost_month;
    }

    public void setMarking_cost_month(String marking_cost_month) {
        this.marking_cost_month.set(marking_cost_month);
    }

    public double getMarking_cost_value() {
        return marking_cost_value.get();
    }

    public SimpleDoubleProperty marking_cost_valueProperty() {
        return marking_cost_value;
    }

    public void setMarking_cost_value(double marking_cost_value) {
        this.marking_cost_value.set(marking_cost_value);
    }

    public int getMarking_cost_year() {
        return marking_cost_year.get();
    }

    public SimpleIntegerProperty marking_cost_yearProperty() {
        return marking_cost_year;
    }

    public void setMarking_cost_year(int marking_cost_year) {
        this.marking_cost_year.set(marking_cost_year);
    }
}
