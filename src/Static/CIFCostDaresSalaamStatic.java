package Static;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CIFCostDaresSalaamStatic {
    private SimpleIntegerProperty  cif_cost_dsm_id;
    private SimpleIntegerProperty  cif_cost_dsm_product_id;
    private SimpleStringProperty cif_cost_dsm_day;
    private SimpleIntegerProperty cif_cost_dsm_date;
    private SimpleStringProperty cif_cost_dsm_month;
    private SimpleIntegerProperty cif_cost_dsm_year;
    private SimpleDoubleProperty cif_cost_dsm_value;
    private SimpleIntegerProperty cif_cost_dsm_weighted_average_plat_fob;
    private SimpleIntegerProperty cif_cost_dsm_wa_premium_quotation ;

    public CIFCostDaresSalaamStatic(int cost_id, int product_id, String day, int date, String month, int year, double value,
                                    int conversion_factor_id, int premium_quotation ){

        this.cif_cost_dsm_id = new SimpleIntegerProperty(cost_id);
        this.cif_cost_dsm_product_id = new SimpleIntegerProperty(product_id);
        this.cif_cost_dsm_day = new SimpleStringProperty(day);
        this.cif_cost_dsm_date = new SimpleIntegerProperty(date);
        this.cif_cost_dsm_month = new SimpleStringProperty(month);
        this.cif_cost_dsm_year = new SimpleIntegerProperty(year);
        this.cif_cost_dsm_value = new SimpleDoubleProperty(value);
        this.cif_cost_dsm_weighted_average_plat_fob = new SimpleIntegerProperty(conversion_factor_id);
        this.cif_cost_dsm_wa_premium_quotation  = new SimpleIntegerProperty(premium_quotation );

    }

    public int getCif_cost_dsm_id() {
        return cif_cost_dsm_id.get();
    }

    public SimpleIntegerProperty cif_cost_dsm_idProperty() {
        return cif_cost_dsm_id;
    }

    public void setCif_cost_dsm_id(int cif_cost_dsm_id) {
        this.cif_cost_dsm_id.set(cif_cost_dsm_id);
    }

    public int getCif_cost_dsm_product_id() {
        return cif_cost_dsm_product_id.get();
    }

    public SimpleIntegerProperty cif_cost_dsm_product_idProperty() {
        return cif_cost_dsm_product_id;
    }

    public void setCif_cost_dsm_product_id(int cif_cost_dsm_product_id) {
        this.cif_cost_dsm_product_id.set(cif_cost_dsm_product_id);
    }

    public String getCif_cost_dsm_day() {
        return cif_cost_dsm_day.get();
    }

    public SimpleStringProperty cif_cost_dsm_dayProperty() {
        return cif_cost_dsm_day;
    }

    public void setCif_cost_dsm_day(String cif_cost_dsm_day) {
        this.cif_cost_dsm_day.set(cif_cost_dsm_day);
    }

    public int getCif_cost_dsm_date() {
        return cif_cost_dsm_date.get();
    }

    public SimpleIntegerProperty cif_cost_dsm_dateProperty() {
        return cif_cost_dsm_date;
    }

    public void setCif_cost_dsm_date(int cif_cost_dsm_date) {
        this.cif_cost_dsm_date.set(cif_cost_dsm_date);
    }

    public String getCif_cost_dsm_month() {
        return cif_cost_dsm_month.get();
    }

    public SimpleStringProperty cif_cost_dsm_monthProperty() {
        return cif_cost_dsm_month;
    }

    public void setCif_cost_dsm_month(String cif_cost_dsm_month) {
        this.cif_cost_dsm_month.set(cif_cost_dsm_month);
    }

    public int getCif_cost_dsm_year() {
        return cif_cost_dsm_year.get();
    }

    public SimpleIntegerProperty cif_cost_dsm_yearProperty() {
        return cif_cost_dsm_year;
    }

    public void setCif_cost_dsm_year(int cif_cost_dsm_year) {
        this.cif_cost_dsm_year.set(cif_cost_dsm_year);
    }

    public double getCif_cost_dsm_value() {
        return cif_cost_dsm_value.get();
    }

    public SimpleDoubleProperty cif_cost_dsm_valueProperty() {
        return cif_cost_dsm_value;
    }

    public void setCif_cost_dsm_value(double cif_cost_dsm_value) {
        this.cif_cost_dsm_value.set(cif_cost_dsm_value);
    }

    public int getCif_cost_dsm_weighted_average_plat_fob() {
        return cif_cost_dsm_weighted_average_plat_fob.get();
    }

    public SimpleIntegerProperty cif_cost_dsm_weighted_average_plat_fobProperty() {
        return cif_cost_dsm_weighted_average_plat_fob;
    }

    public void setCif_cost_dsm_weighted_average_plat_fob(int cif_cost_dsm_weighted_average_plat_fob) {
        this.cif_cost_dsm_weighted_average_plat_fob.set(cif_cost_dsm_weighted_average_plat_fob);
    }

    public int getCif_cost_dsm_wa_premium_quatation() {
        return cif_cost_dsm_wa_premium_quotation .get();
    }

    public SimpleIntegerProperty cif_cost_dsm_wa_premium_quatationProperty() {
        return cif_cost_dsm_wa_premium_quotation ;
    }

    public void setCif_cost_dsm_wa_premium_quatation(int cif_cost_dsm_wa_premium_quotation ) {
        this.cif_cost_dsm_wa_premium_quotation .set(cif_cost_dsm_wa_premium_quotation );
    }
}

