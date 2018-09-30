package Static;

public class YearlyData {
    private double month_value = 0;
    private String month_name;

    public YearlyData(String month, double value){
        this.month_name = month;
        this.month_value = value;
    }

    public double getMonth_value() {
        return month_value;
    }

    public void setMonth_value(double month_value) {
        this.month_value = month_value;
    }

    public String getMonth_name() {
        return month_name;
    }

    public void setMonth_name(String month_name) {
        this.month_name = month_name;
    }
}
