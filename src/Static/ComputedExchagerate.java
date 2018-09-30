package Static;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ComputedExchagerate {
    private SimpleStringProperty month;
    private SimpleIntegerProperty year;

    public ComputedExchagerate(String month, int year)
    {
        this.month = new SimpleStringProperty(month);
        this.year = new SimpleIntegerProperty(year);
    }

    public String getMonth() {
        return month.get();
    }

    public SimpleStringProperty monthProperty() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
