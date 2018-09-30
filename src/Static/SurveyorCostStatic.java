package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SurveyorCostStatic {
    private SimpleIntegerProperty surveyors_cost_id;
    private SimpleIntegerProperty surveyors_cost_product_id;
    private SimpleStringProperty surveyors_cost_day;
    private SimpleIntegerProperty surveyors_cost_date;
    private SimpleStringProperty surveyors_cost_month;
    private SimpleIntegerProperty surveyors_cost_year;
    private SimpleDoubleProperty surveyors_cost_value;
    private SimpleIntegerProperty surveyors_cost_exchangerate;
    private SimpleIntegerProperty surveyors_cost_waa_conversion_factor;
    private SimpleIntegerProperty surveyors_cost_actual_tender_rate_small_vessel;
    private SimpleIntegerProperty surveyors_cost_actual_tender_rate_big_vessel;

    public SurveyorCostStatic(int identity,int product,String day,int date, String month,int year,double cost_value,
                              int exchangrate_id,int waa_conversion_factor_id, int actual_tender_rate_small,int actual_tender_rate_big){
        this.surveyors_cost_id = new SimpleIntegerProperty(identity);
        this.surveyors_cost_day = new SimpleStringProperty(day);
        this.surveyors_cost_date = new SimpleIntegerProperty(date);
        this.surveyors_cost_month = new SimpleStringProperty(month);
        this.surveyors_cost_year = new SimpleIntegerProperty(year);
        this.surveyors_cost_product_id = new SimpleIntegerProperty(product);
        this.surveyors_cost_value = new SimpleDoubleProperty(cost_value);
        this.surveyors_cost_exchangerate = new SimpleIntegerProperty(exchangrate_id);
        this.surveyors_cost_waa_conversion_factor = new SimpleIntegerProperty(waa_conversion_factor_id);
        this.surveyors_cost_actual_tender_rate_small_vessel = new SimpleIntegerProperty(actual_tender_rate_small);
        this.surveyors_cost_actual_tender_rate_big_vessel = new SimpleIntegerProperty(actual_tender_rate_big);

    }

    public int getSurveyors_cost_id() {
        return surveyors_cost_id.get();
    }

    public SimpleIntegerProperty surveyors_cost_idProperty() {
        return surveyors_cost_id;
    }

    public void setSurveyors_cost_id(int surveyors_cost_id) {
        this.surveyors_cost_id.set(surveyors_cost_id);
    }

    public int getSurveyors_cost_product_id() {
        return surveyors_cost_product_id.get();
    }

    public SimpleIntegerProperty surveyors_cost_product_idProperty() {
        return surveyors_cost_product_id;
    }

    public void setSurveyors_cost_product_id(int surveyors_cost_product_id) {
        this.surveyors_cost_product_id.set(surveyors_cost_product_id);
    }

    public String getSurveyors_cost_day() {
        return surveyors_cost_day.get();
    }

    public SimpleStringProperty surveyors_cost_dayProperty() {
        return surveyors_cost_day;
    }

    public void setSurveyors_cost_day(String surveyors_cost_day) {
        this.surveyors_cost_day.set(surveyors_cost_day);
    }

    public int getSurveyors_cost_date() {
        return surveyors_cost_date.get();
    }

    public SimpleIntegerProperty surveyors_cost_dateProperty() {
        return surveyors_cost_date;
    }

    public void setSurveyors_cost_date(int surveyors_cost_date) {
        this.surveyors_cost_date.set(surveyors_cost_date);
    }

    public String getSurveyors_cost_month() {
        return surveyors_cost_month.get();
    }

    public SimpleStringProperty surveyors_cost_monthProperty() {
        return surveyors_cost_month;
    }

    public void setSurveyors_cost_month(String surveyors_cost_month) {
        this.surveyors_cost_month.set(surveyors_cost_month);
    }

    public int getSurveyors_cost_year() {
        return surveyors_cost_year.get();
    }

    public SimpleIntegerProperty surveyors_cost_yearProperty() {
        return surveyors_cost_year;
    }

    public void setSurveyors_cost_year(int surveyors_cost_year) {
        this.surveyors_cost_year.set(surveyors_cost_year);
    }

    public double getSurveyors_cost_value() {
        return surveyors_cost_value.get();
    }

    public SimpleDoubleProperty surveyors_cost_valueProperty() {
        return surveyors_cost_value;
    }

    public void setSurveyors_cost_value(double surveyors_cost_value) {
        this.surveyors_cost_value.set(surveyors_cost_value);
    }

    public int getSurveyors_cost_exchangerate() {
        return surveyors_cost_exchangerate.get();
    }

    public SimpleIntegerProperty surveyors_cost_exchangerateProperty() {
        return surveyors_cost_exchangerate;
    }

    public void setSurveyors_cost_exchangerate(int surveyors_cost_exchangerate) {
        this.surveyors_cost_exchangerate.set(surveyors_cost_exchangerate);
    }

    public int getSurveyors_cost_waa_conversion_factor() {
        return surveyors_cost_waa_conversion_factor.get();
    }

    public SimpleIntegerProperty surveyors_cost_waa_conversion_factorProperty() {
        return surveyors_cost_waa_conversion_factor;
    }

    public void setSurveyors_cost_waa_conversion_factor(int surveyors_cost_waa_conversion_factor) {
        this.surveyors_cost_waa_conversion_factor.set(surveyors_cost_waa_conversion_factor);
    }

    public int getSurveyors_cost_actual_tender_rate_small_vessel() {
        return surveyors_cost_actual_tender_rate_small_vessel.get();
    }

    public SimpleIntegerProperty surveyors_cost_actual_tender_rate_small_vesselProperty() {
        return surveyors_cost_actual_tender_rate_small_vessel;
    }

    public void setSurveyors_cost_actual_tender_rate_small_vessel(int surveyors_cost_actual_tender_rate_small_vessel) {
        this.surveyors_cost_actual_tender_rate_small_vessel.set(surveyors_cost_actual_tender_rate_small_vessel);
    }

    public int getSurveyors_cost_actual_tender_rate_big_vessel() {
        return surveyors_cost_actual_tender_rate_big_vessel.get();
    }

    public SimpleIntegerProperty surveyors_cost_actual_tender_rate_big_vesselProperty() {
        return surveyors_cost_actual_tender_rate_big_vessel;
    }

    public void setSurveyors_cost_actual_tender_rate_big_vessel(int surveyors_cost_actual_tender_rate_big_vessel) {
        this.surveyors_cost_actual_tender_rate_big_vessel.set(surveyors_cost_actual_tender_rate_big_vessel);
    }
}
