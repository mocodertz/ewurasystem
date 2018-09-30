package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ExchangeRate {

    private final SimpleIntegerProperty exchangerate_identity;
    private final SimpleStringProperty exchangerate_day;
    private final SimpleStringProperty exchangerate_month;
    private final SimpleIntegerProperty exchangerate_year;
    private final SimpleIntegerProperty exchangerate_date;
    private final SimpleDoubleProperty exchangerate_value;

    public ExchangeRate(int identity,String day,int date, String month,int year,double rate_value) {
        this.exchangerate_identity = new SimpleIntegerProperty(identity);
        this.exchangerate_day = new SimpleStringProperty(day);
        this.exchangerate_date = new SimpleIntegerProperty(date);
        this.exchangerate_month = new SimpleStringProperty(month);
        this.exchangerate_year = new SimpleIntegerProperty(year);
        this.exchangerate_value = new SimpleDoubleProperty(rate_value);

    }

    public int getExchangerate_date() {
        return exchangerate_date.get();
    }

    public SimpleIntegerProperty exchangerate_dateProperty() {
        return exchangerate_date;
    }

    public void setExchangerate_date(int exchangerate_date) {
        this.exchangerate_date.set(exchangerate_date);
    }

    public String getExchangerate_day() {
        return exchangerate_day.get();
    }

    public SimpleStringProperty exchangerate_dayProperty() {
        return exchangerate_day;
    }

    public void setExchangerate_day(String exchangerate_day) {
        this.exchangerate_day.set(exchangerate_day);
    }

    public String getExchangerate_month() {
        return exchangerate_month.get();
    }

    public SimpleStringProperty exchangerate_monthProperty() {
        return exchangerate_month;
    }

    public void setExchangerate_month(String exchangerate_month) {
        this.exchangerate_month.set(exchangerate_month);
    }

    public double getExchangerate_value() {
        return exchangerate_value.get();
    }

    public SimpleDoubleProperty exchangerate_valueProperty() {
        return exchangerate_value;
    }

    public void setExchangerate_value(double exchangerate_value) {
        this.exchangerate_value.set(exchangerate_value);
    }

    public int getExchangerate_year() {
        return exchangerate_year.get();
    }

    public SimpleIntegerProperty exchangerate_yearProperty() {
        return exchangerate_year;
    }

    public void setExchangerate_year(int exchangerate_year) {
        this.exchangerate_year.set(exchangerate_year);
    }

    public int getExchangerate_identity() {
        return exchangerate_identity.get();
    }

    public SimpleIntegerProperty exchangerate_identityProperty() {
        return exchangerate_identity;
    }

    public void setExchangerate_identity(int exchangerate_identity) {
        this.exchangerate_identity.set(exchangerate_identity);
    }
}
