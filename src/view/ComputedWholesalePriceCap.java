package view;

import Static.WholeSalePriceCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ComputedWholesalePriceCap extends VBox {

    /*todo Petroleum Controls*/
    private Label cifCostPetroleum;
    private Label totalLocalCostPetroleum;
    private Label totalGovernmentTaxesPetroleum;
    private Label chargesPayablePetroleum;
    private Label omcOverheadMarginsPetroleum;
    private Label wholeSalePetroleum;

    /*todo Diesel Controls*/
    private Label cifCostDiesel;
    private Label totalLocalCostDiesel;
    private Label totalGovernmentTaxesDiesel;
    private Label chargesPayableDiesel;
    private Label omcOverheadMarginsDiesel;
    private Label wholeSaleDiesel;

    /*todo Kerosene Controls*/
    private Label cifCostKerosene;
    private Label totalLocalCostKerosene;
    private Label totalGovernmentTaxesKerosene;
    private Label chargesPayableKerosene;
    private Label omcOverheadMarginsKerosene;
    private Label wholeSaleKerosene;

    /*todo Shared Controls*/
    private Button queryWholeSalesPrice;
    private ComboBox<Integer> wholeSalesYear;
    private ComboBox<String> wholeSalesMonth;

    /**
     * For Saving Local Cost
     */
    private ComboBox<String> save_day;
    private ComboBox<Integer> save_date;
    private ComboBox<String> save_month;
    private ComboBox<Integer> save_year;
    private Button save_submit_button;

    /*todo Section Header Holder*/
    private HBox custom_local_heading_section;
    private VBox temp_save_controls_vbox;

    public ComputedWholesalePriceCap() {

        this.setPadding(new Insets(5, 0, 5, 75));
        this.save_day = new ComboBox<>();
        this.save_day.setPromptText("Select Day");

        this.save_date = new ComboBox<>();
        this.save_date.setPromptText("Select Date");

        this.save_month = new ComboBox<>();
        this.save_month.setPromptText("Select Month");

        this.save_year = new ComboBox<>();
        this.save_year.setPromptText("Select Day");

        this.save_submit_button = new Button("Save");
        /*todo Initializing Petroleum Controls*/
        this.cifCostPetroleum = new Label("Not Available");
        this.totalLocalCostPetroleum = new Label("Not Available");
        this.totalGovernmentTaxesPetroleum = new Label("Not Available");
        this.chargesPayablePetroleum = new Label("Not Available");
        this.omcOverheadMarginsPetroleum = new Label("Not Available");
        this.wholeSalePetroleum = new Label("Not Available");

        /*todo Initializing Diesel Controls*/
        this.cifCostDiesel = new Label("Not Available");
        this.totalLocalCostDiesel = new Label("Not Available");
        this.totalGovernmentTaxesDiesel = new Label("Not Available");
        this.chargesPayableDiesel = new Label("Not Available");
        this.omcOverheadMarginsDiesel = new Label("Not Available");
        this.wholeSaleDiesel = new Label("Not Available");

        /*todo Initializing Kerosene Controls*/
        this.cifCostKerosene = new Label("Not Available");
        this.totalLocalCostKerosene = new Label("Not Available");
        this.totalGovernmentTaxesKerosene = new Label("Not Available");
        this.chargesPayableKerosene = new Label("Not Available");
        this.omcOverheadMarginsKerosene = new Label("Not Available");
        this.wholeSaleKerosene = new Label("Not Available");

        /*todo Initializing Shared Controls*/
        this.queryWholeSalesPrice = new Button("Get Computed Wholesale Price Cap");
        this.wholeSalesMonth = new ComboBox<>();
        this.wholeSalesMonth.setPromptText("Select Month");
        this.wholeSalesYear = new ComboBox<>();
        this.wholeSalesYear.setPromptText("Select Year");

        populateComboBoxes();
        constructComputedPumpPriceCapDaresSalaam();
    }

    private void constructComputedPumpPriceCapDaresSalaam() {
        this.custom_local_heading_section = new HBox();
        VBox.setMargin(this.custom_local_heading_section, new Insets(10));
        this.custom_local_heading_section.setStyle("-fx-background-color: #085394;");
        this.custom_local_heading_section.setPadding(new Insets(5, 0, 5, 0));
        this.custom_local_heading_section.setMaxWidth(700);
        this.custom_local_heading_section.setMinHeight(27);
        this.custom_local_heading_section.setAlignment(Pos.CENTER);
        Label lbl_adding_section = new Label("Computed Wholesale Price Cap");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.custom_local_heading_section.getChildren().add(lbl_adding_section);

        HBox hold_search_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_search_controls.setSpacing(5);
        hold_search_controls.setPadding(new Insets(10));
        hold_search_controls.getChildren().addAll(this.wholeSalesMonth, this.wholeSalesYear, this.queryWholeSalesPrice);

        this.temp_save_controls_vbox = new VBox();
        this.temp_save_controls_vbox.setSpacing(2.5);
        this.temp_save_controls_vbox.setPadding(new Insets(10));
        HBox hold_save_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_save_controls.setSpacing(5);
        //hold_save_controls.setPadding(new Insets(10));
        hold_save_controls.getChildren().addAll(this.save_day, this.save_date, this.save_month, this.save_year);
        this.temp_save_controls_vbox.getChildren().addAll(hold_save_controls, this.save_submit_button);

        Label petrol_header = new Label("PETROL");
        petrol_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label diesel_header = new Label("DIESEL");
        diesel_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label kerosene_header = new Label("KEROSENE");
        kerosene_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");

        Label unit_header = new Label("Unit");
        unit_header.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label petrol_header_price = new Label("Price");
        petrol_header_price.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label diesel_header_price = new Label("Price");
        diesel_header_price.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label kerosene_header_price = new Label("Price");
        kerosene_header_price.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 5px;");

        Label unit_cap = new Label("Tzs/Ltr");
        unit_cap.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label unit_retailers = new Label("Tzs/Ltr");
        unit_retailers.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label unit_transport = new Label("Tzs/Ltr");
        unit_transport.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label unit_pump = new Label("Tzs/Ltr");
        unit_pump.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label unit_wholesale = new Label("Tzs/Ltr");
        unit_wholesale.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label unit_tax = new Label("Tzs/Ltr");
        unit_tax.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");


        GridPane hold_localComputedControls = new GridPane();
        /**hold_localComputedControls.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);*/
        hold_localComputedControls.setGridLinesVisible(true);
        /** hold_localComputedControls.setAlignment(Pos.CENTER);*/
        hold_localComputedControls.setPadding(new Insets(10));

        hold_localComputedControls.add(petrol_header, 2, 0);
        hold_localComputedControls.add(diesel_header, 3, 0);
        hold_localComputedControls.add(kerosene_header, 4, 0);

        hold_localComputedControls.add(unit_header, 1, 1);
        hold_localComputedControls.add(petrol_header_price, 2, 1);
        hold_localComputedControls.add(diesel_header_price, 3, 1);
        hold_localComputedControls.add(kerosene_header_price, 4, 1);

        Label cif = new Label("CIF COST (DAR)");
        cif.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold;");
        this.cifCostPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.cifCostDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.cifCostKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(cif, 0, 2);
        hold_localComputedControls.add(unit_cap, 1, 2);
        hold_localComputedControls.add(cifCostPetroleum, 2, 2);
        hold_localComputedControls.add(cifCostDiesel, 3, 2);
        hold_localComputedControls.add(cifCostKerosene, 4, 2);

        Label totalCost = new Label("TOTAL LOCAL COST (LC)");
        totalCost.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold;");
        this.totalLocalCostPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.totalLocalCostDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.totalLocalCostKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(totalCost, 0, 3);
        hold_localComputedControls.add(unit_retailers, 1, 3);
        hold_localComputedControls.add(totalLocalCostPetroleum, 2, 3);
        hold_localComputedControls.add(totalLocalCostDiesel, 3, 3);
        hold_localComputedControls.add(totalLocalCostKerosene, 4, 3);

        Label governmentTaxes = new Label("TOTAL GOVERNMENT TAXES (GT)");
        governmentTaxes.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold;");
        this.totalGovernmentTaxesPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.totalGovernmentTaxesDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.totalGovernmentTaxesKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(governmentTaxes, 0, 4);
        hold_localComputedControls.add(unit_tax, 1, 4);
        hold_localComputedControls.add(totalGovernmentTaxesPetroleum, 2, 4);
        hold_localComputedControls.add(totalGovernmentTaxesDiesel, 3, 4);
        hold_localComputedControls.add(totalGovernmentTaxesKerosene, 4, 4);

        Label charges = new Label("Charges Payable to Other Local Authorities and Executive Agencies");
        charges.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
        this.chargesPayablePetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.chargesPayableDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.chargesPayableKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(charges, 0, 5);
        hold_localComputedControls.add(unit_transport, 1, 5);
        hold_localComputedControls.add(chargesPayablePetroleum, 2, 5);
        hold_localComputedControls.add(chargesPayableDiesel, 3, 5);
        hold_localComputedControls.add(chargesPayableKerosene, 4, 5);

        Label omc = new Label("OMC's Overheads & Margins");
        omc.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
        this.omcOverheadMarginsPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.omcOverheadMarginsDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.omcOverheadMarginsKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(omc, 0, 6);
        hold_localComputedControls.add(unit_pump, 1, 6);
        hold_localComputedControls.add(omcOverheadMarginsPetroleum, 2, 6);
        hold_localComputedControls.add(omcOverheadMarginsDiesel, 3, 6);
        hold_localComputedControls.add(omcOverheadMarginsKerosene, 4, 6);

        Label wholesale = new Label("WHOLESALE PRICE CAP (DSM)");
        wholesale.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold");
        this.wholeSalePetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.wholeSaleDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        this.wholeSaleKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
        hold_localComputedControls.add(wholesale, 0, 7);
        hold_localComputedControls.add(unit_wholesale, 1, 7);
        hold_localComputedControls.add(wholeSalePetroleum, 2, 7);
        hold_localComputedControls.add(wholeSaleDiesel, 3, 7);
        hold_localComputedControls.add(wholeSaleKerosene, 4, 7);

        /*todo Setting Grid Pane Constraints*/
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(235));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));

        this.getChildren().addAll(this.custom_local_heading_section, hold_search_controls, hold_localComputedControls,
                temp_save_controls_vbox);
        /**this.setAlignment(Pos.CENTER);*/

    }

    public void setNonComputedData(double charge_petroleum, double charge_kerosene, double charge_diesel,
                                   double omc_petroleum, double omc_kerosene, double omc_diesel,
                                   double cif_cost_petroleum, double cif_cost_kerosene, double cif_cost_diesel,
                                   double totalLocalCostPetroleum, double totalLocalCostKerosene, double totalLocalCostDiesel,
                                   double governmentTaxPetroleum, double governmentTaxKerosene, double governmentTaxDiesel) {

        /*todo Charges*/
        this.chargesPayablePetroleum.setText(String.valueOf(charge_petroleum));
        this.chargesPayableKerosene.setText(String.valueOf(charge_kerosene));
        this.chargesPayableDiesel.setText(String.valueOf(charge_diesel));

        /*todo OMC*/
        this.omcOverheadMarginsPetroleum.setText(String.valueOf(omc_petroleum));
        this.omcOverheadMarginsKerosene.setText(String.valueOf(omc_kerosene));
        this.omcOverheadMarginsDiesel.setText(String.valueOf(omc_diesel));

        /**CIF Cost*/
        this.cifCostPetroleum.setText(String.valueOf(String.format("%1.2f",cif_cost_petroleum)));
        this.cifCostKerosene.setText(String.valueOf(String.format("%1.2f",cif_cost_kerosene)));
        this.cifCostDiesel.setText(String.valueOf(String.format("%1.2f",cif_cost_diesel)));

        /**Total Local Cost*/
        this.totalLocalCostPetroleum.setText(String.valueOf(String.format("%1.2f",totalLocalCostPetroleum)));
        this.totalLocalCostKerosene.setText(String.valueOf(String.format("%1.2f",totalLocalCostKerosene)));
        this.totalLocalCostDiesel.setText(String.valueOf(String.format("%1.2f",totalLocalCostDiesel)));

        /**Total Government Taxes*/
        this.totalGovernmentTaxesPetroleum.setText(String.valueOf(String.format("%1.2f",governmentTaxPetroleum)));
        this.totalGovernmentTaxesKerosene.setText(String.valueOf(String.format("%1.2f",governmentTaxKerosene)));
        this.totalGovernmentTaxesDiesel.setText(String.valueOf(String.format("%1.2f",governmentTaxDiesel)));
    }

    public void setComputedData(double charge_petroleum, double charge_kerosene, double charge_diesel,
                                double omc_petroleum, double omc_kerosene, double omc_diesel,
                                double cif_cost_petroleum, double cif_cost_kerosene, double cif_cost_diesel,
                                double totalLocalCostPetroleum, double totalLocalCostKerosene, double totalLocalCostDiesel,
                                double governmentTaxPetroleum, double governmentTaxKerosene, double governmentTaxDiesel) {

        /*todo Temp Computed Values*/

        double temp_wholesale_petroleum = charge_petroleum + omc_petroleum + cif_cost_petroleum + totalLocalCostPetroleum + governmentTaxPetroleum;
        double temp_wholesale_kerosene = charge_kerosene + omc_kerosene + cif_cost_kerosene + totalLocalCostKerosene + governmentTaxKerosene;
        double temp_wholesale_diesel = charge_diesel + omc_diesel + cif_cost_diesel + totalLocalCostDiesel + governmentTaxDiesel;

        this.wholeSalePetroleum.setText(String.valueOf(String.format("%1.2f",temp_wholesale_petroleum)));
        this.wholeSaleKerosene.setText(String.valueOf(String.format("%1.2f",temp_wholesale_kerosene)));
        this.wholeSaleDiesel.setText(String.valueOf(String.format("%1.2f",temp_wholesale_diesel)));
    }

    public String getMonth() {
        return wholeSalesMonth.getValue().toString();
    }

    public int getYear() {
        return wholeSalesYear.getValue();
    }

    private void populateComboBoxes() {

        ObservableList<String> month_value = FXCollections.observableArrayList("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Friday",
                "Thursday", "Saturday", "Sunday");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);

        ObservableList<Integer> year_value = FXCollections.observableArrayList(2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022
                , 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039, 2040, 2041, 2051, 2052,
                2053, 2054, 2055, 2056, 2057, 2058, 2059, 2060, 2070, 2080, 2081, 2082, 2083, 2084, 2085, 2086, 2087, 2089, 2090, 2091, 2092, 2093,
                2094, 2095, 2096, 2097, 2098, 2099, 2030);

        this.wholeSalesMonth.setItems(null);
        this.wholeSalesYear.setItems(null);
        this.save_day.setItems(null);
        this.save_date.setItems(null);
        this.save_year.setItems(null);
        this.save_month.setItems(null);

        this.wholeSalesMonth.setItems(month_value);
        this.wholeSalesYear.setItems(year_value);
        this.save_day.setItems(day_value);
        this.save_date.setItems(date_value);
        this.save_year.setItems(year_value);
        this.save_month.setItems(month_value);


    }

    public void addQueryStoredDataEvent(EventHandler eventhandler) {
        this.queryWholeSalesPrice.setOnAction(eventhandler);
    }

    public void hideSearchControls() {
        this.queryWholeSalesPrice.setVisible(false);
        this.wholeSalesMonth.setVisible(false);
        this.wholeSalesYear.setVisible(false);
        this.temp_save_controls_vbox.setVisible(false);
    }

    public WholeSalePriceCap getWholeSalePriceCapPetroleumData() {

        WholeSalePriceCap wholeSalePriceCap = null;
        if (this.save_day.getValue() != null && this.save_date.getValue() != null && this.save_month.getValue() != null &&
                this.save_year.getValue() != null) {
            wholeSalePriceCap = new WholeSalePriceCap(1, 1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    Double.parseDouble(this.wholeSalePetroleum.getText()));
        } else {
            System.out.println("You Must Fill All the Filled");
        }
        return wholeSalePriceCap;
    }

    public WholeSalePriceCap getPumpWholesalePriceCapKeroseneData() {

        WholeSalePriceCap wholeSalePriceCap = null;
        if (this.save_day.getValue() != null && this.save_date.getValue() != null && this.save_month.getValue() != null &&
                this.save_year.getValue() != null) {
            wholeSalePriceCap = new WholeSalePriceCap(1, 2, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    Double.parseDouble(this.wholeSaleKerosene.getText()));
        } else {
            System.out.println("You Must Fill All the Filled");
        }
        return wholeSalePriceCap;
    }

    public WholeSalePriceCap getWholesalePriceCapDieselData() {

        WholeSalePriceCap wholeSalePriceCap = null;
        if (this.save_day.getValue() != null && this.save_date.getValue() != null && this.save_month.getValue() != null &&
                this.save_year.getValue() != null) {
            wholeSalePriceCap = new WholeSalePriceCap(1, 3, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    Double.parseDouble(this.wholeSaleDiesel.getText()));
        } else {
            System.out.println("You Must Fill All the Filled");
        }
        return wholeSalePriceCap;
    }

    public void saveCurrentComputedLWholeSlaePriceCap(EventHandler eventHandler) {
        this.save_submit_button.setOnMouseClicked(eventHandler);
    }
}
