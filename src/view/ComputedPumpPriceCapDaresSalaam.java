package view;

import Static.PumpPriceCap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class ComputedPumpPriceCapDaresSalaam extends VBox {

    /*todo Petroleum Controls*/
    private Label wholeSalesPriceCapPetroleum;
    private Label retailersMarginPetroleum;
    private Label transportChargesPetroleum;
    private Label pumpPriceCapPetroleum;

    /*todo Diesel Controls*/
    private Label wholeSalesPriceCapDiesel;
    private Label retailersMarginDiesel;
    private Label transportChargesDiesel;
    private Label pumpPriceCapDiesel;

    /*todo Kerosene Controls*/
    private Label wholeSalesPriceCapKerosene;
    private Label retailersMarginKerosene;
    private Label transportChargesKerosene;
    private Label pumpPriceCapKerosene;

    /*todo Shared Controls*/
    private Button queryComputedPumpPriceCap;
    private ComboBox<Integer> pumpPriceCapYear;
    private ComboBox<String> pumpPriceCapMonth;

    /**For Saving Local Cost*/
    private ComboBox<String> save_day;
    private ComboBox<Integer> save_date;
    private ComboBox<String> save_month;
    private ComboBox<Integer> save_year;
    private Button save_submit_button;

    /*todo Section Header Holder*/
    private HBox custom_local_heading_section;
    private VBox temp_save_controls_vbox;

    public ComputedPumpPriceCapDaresSalaam(){

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
        this.wholeSalesPriceCapPetroleum = new Label("Not Available");
        this.retailersMarginPetroleum = new Label("Not Available");
        this.transportChargesPetroleum = new Label("Not Available");
        this.pumpPriceCapPetroleum = new Label("Not Available");

        /*todo Initializing Diesel Controls*/
        this.wholeSalesPriceCapDiesel = new Label("Not Available");
        this.retailersMarginDiesel = new Label("Not Available");
        this.transportChargesDiesel = new Label("Not Available");
        this.pumpPriceCapDiesel = new Label("Not Available");

        /*todo Initializing Kerosene Controls*/
        this.wholeSalesPriceCapKerosene = new Label("Not Available");
        this.retailersMarginKerosene = new Label("Not Available");
        this.transportChargesKerosene = new Label("Not Available");
        this.pumpPriceCapKerosene = new Label("Not Available");

        /*todo Initializing Shared Controls*/
        this.queryComputedPumpPriceCap = new Button("Get Computed Pump Price Cap");
        this.pumpPriceCapMonth = new ComboBox<>();
        this.pumpPriceCapMonth.setPromptText("Select Month");
        this.pumpPriceCapYear = new ComboBox<>();
        this.pumpPriceCapYear.setPromptText("Select Year");

        populateComboBoxes();
        constructComputedPumpPriceCapDaresSalaam();


    }

    private void constructComputedPumpPriceCapDaresSalaam(){
        this.custom_local_heading_section = new HBox();
        VBox.setMargin(this.custom_local_heading_section,new Insets(10));
        this.custom_local_heading_section.setStyle("-fx-background-color: #085394;");
        this.custom_local_heading_section.setPadding(new Insets(5, 0, 5, 0));
        this.custom_local_heading_section.setMaxWidth(700);
        this.custom_local_heading_section.setMinHeight(27);
        this.custom_local_heading_section.setAlignment(Pos.CENTER);
        Label lbl_adding_section = new Label("Computed Pump Price Cap Dar es Salaam");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.custom_local_heading_section.getChildren().add(lbl_adding_section);

        HBox hold_search_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_search_controls.setSpacing(5);
        hold_search_controls.setPadding(new Insets(10));
        hold_search_controls.getChildren().addAll(this.pumpPriceCapMonth,this.pumpPriceCapYear,this.queryComputedPumpPriceCap);

        this.temp_save_controls_vbox = new VBox();
        this.temp_save_controls_vbox.setSpacing(2.5);
        this.temp_save_controls_vbox.setPadding(new Insets(10));
        HBox hold_save_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_save_controls.setSpacing(5);
        //hold_save_controls.setPadding(new Insets(10));
        hold_save_controls.getChildren().addAll(this.save_day,this.save_date,this.save_month,this.save_year);
        temp_save_controls_vbox.getChildren().addAll(hold_save_controls,this.save_submit_button);

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


        GridPane hold_localComputedControls = new GridPane();
            /**hold_localComputedControls.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);*/
            hold_localComputedControls.setGridLinesVisible(true);
            /**hold_localComputedControls.setAlignment(Pos.CENTER);*/
            hold_localComputedControls.setPadding(new Insets(10));

            hold_localComputedControls.add(petrol_header,2,0);
            hold_localComputedControls.add(diesel_header,3,0);
            hold_localComputedControls.add(kerosene_header,4,0);

            hold_localComputedControls.add(unit_header,1,1);
            hold_localComputedControls.add(petrol_header_price,2,1);
            hold_localComputedControls.add(diesel_header_price,3,1);
            hold_localComputedControls.add(kerosene_header_price,4,1);

            Label wholesales = new Label("WHOLESALE PRICE CAP DSM");
            wholesales.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold;");
            this.wholeSalesPriceCapPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.wholeSalesPriceCapDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.wholeSalesPriceCapKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(wholesales,0,2);
            hold_localComputedControls.add(unit_cap,1,2);
            hold_localComputedControls.add(wholeSalesPriceCapPetroleum,2,2);
            hold_localComputedControls.add(wholeSalesPriceCapDiesel,3,2);
            hold_localComputedControls.add(wholeSalesPriceCapKerosene,4,2);

            Label retailer = new Label("Retailers Margin");
            retailer.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
            this.retailersMarginPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.retailersMarginDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.retailersMarginKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(retailer,0,3);
            hold_localComputedControls.add(unit_retailers,1,3);
            hold_localComputedControls.add(retailersMarginPetroleum,2,3);
            hold_localComputedControls.add(retailersMarginDiesel,3,3);
            hold_localComputedControls.add(retailersMarginKerosene,4,3);

            Label transport = new Label("Transport Charges (Local)");
            transport.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
            this.transportChargesPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.transportChargesDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.transportChargesKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(transport,0,4);
            hold_localComputedControls.add(unit_transport,1,4);
            hold_localComputedControls.add(transportChargesPetroleum,2,4);
            hold_localComputedControls.add(transportChargesDiesel,3,4);
            hold_localComputedControls.add(transportChargesKerosene,4,4);

            Label pump = new Label("PUMP PRICE CAP (DSM)");
            pump.setStyle("-fx-font-size: 14px;  -fx-padding: 3px; -fx-font-weight: bold");
            this.pumpPriceCapPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.pumpPriceCapDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.pumpPriceCapKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(pump,0,5);
            hold_localComputedControls.add(unit_pump,1,5);
            hold_localComputedControls.add(pumpPriceCapPetroleum,2,5);
            hold_localComputedControls.add(pumpPriceCapDiesel,3,5);
            hold_localComputedControls.add(pumpPriceCapKerosene,4,5);

        /*todo Setting Grid Pane Constraints*/
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(235));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));

        this.getChildren().addAll(this.custom_local_heading_section,hold_search_controls,hold_localComputedControls,
                temp_save_controls_vbox);
       /** this.setAlignment(Pos.CENTER);*/

    }


    public void setNonComputedData(double retailer_petroleum, double retailer_kerosene, double retailer_diesel,
                                   double transport_petroleum, double transport_kerosene, double transport_diesel,
                                   double wholesale_petroleum, double wholesale_kerosene, double wholesale_diesel){

        /*todo Retailers Margin*/
        this.retailersMarginPetroleum.setText(String.valueOf(String.format("%1.2f",retailer_petroleum)));
        this.retailersMarginDiesel.setText(String.valueOf(String.format("%1.2f",retailer_diesel)));
        this.retailersMarginKerosene.setText(String.valueOf(String.format("%1.2f",retailer_kerosene)));

        /*todo Transport Charges */
        this.transportChargesPetroleum.setText(String.valueOf(String.format("%1.2f",transport_petroleum)));
        this.transportChargesDiesel.setText(String.valueOf(String.format("%1.2f",transport_diesel)));
        this.transportChargesKerosene.setText(String.valueOf(String.format("%1.2f",transport_kerosene)));

        /*todo Wholesales Price Cap */
        this.wholeSalesPriceCapPetroleum.setText(String.valueOf(String.format("%1.2f",wholesale_petroleum)));
        this.wholeSalesPriceCapKerosene.setText(String.valueOf(String.format("%1.2f",wholesale_kerosene)));
        this.wholeSalesPriceCapDiesel.setText(String.valueOf(String.format("%1.2f",wholesale_diesel)));


    }

    public void setComputedData(double retailer_petroleum, double retailer_kerosene, double retailer_diesel,
                                double transport_petroleum, double transport_kerosene, double transport_diesel,
                                double wholesale_petroleum, double wholesale_kerosene, double wholesale_diesel){

        Double temp_pumpPriceCap_petroleum = retailer_petroleum + transport_petroleum + wholesale_petroleum;
        Double temp_pumpPriceCap_kerosene = retailer_kerosene + transport_kerosene + wholesale_kerosene;
        Double temp_pumpPriceCap_diesel = retailer_diesel + transport_diesel + wholesale_diesel;

            /*assigning value TextField*/
            this.pumpPriceCapPetroleum.setText(String.valueOf(String.format("%1.2f",temp_pumpPriceCap_petroleum)));
            this.pumpPriceCapKerosene.setText(String.valueOf(String.format("%1.2f",temp_pumpPriceCap_kerosene)));
            this.pumpPriceCapDiesel.setText(String.valueOf(String.format("%1.2f",temp_pumpPriceCap_diesel)));

    }

    public void addQueryStoredDataEvent(EventHandler eventhandler){
        this.queryComputedPumpPriceCap.setOnAction(eventhandler);
    }

    public String getMonth(){
        return pumpPriceCapMonth.getValue().toString();
    }

    public int getYear(){
        return pumpPriceCapYear.getValue();
    }

    private void populateComboBoxes(){

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","October","November","December");

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Friday",
                "Thursday", "Saturday","Sunday");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);

        this.pumpPriceCapMonth.setItems(null);
        this.pumpPriceCapYear.setItems(null);

        this.pumpPriceCapMonth.setItems(month_value);
        this.pumpPriceCapYear.setItems(year_value);

        this.save_day.setItems(null);
        this.save_date.setItems(null);
        this.save_year.setItems(null);
        this.save_month.setItems(null);

        this.save_day.setItems(day_value);
        this.save_date.setItems(date_value);
        this.save_month.setItems(month_value);
        this.save_year.setItems(year_value);

    }

    public void hideSearchControls(){
        this.queryComputedPumpPriceCap.setVisible(false);
        this.pumpPriceCapMonth.setVisible(false);
        this.pumpPriceCapYear.setVisible(false);
        this.temp_save_controls_vbox.setVisible(false);
    }

    public PumpPriceCap getPumpPriceCaPetroleumData(){

        PumpPriceCap pumpPriceCap = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            pumpPriceCap = new PumpPriceCap(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    1,Double.parseDouble(this.pumpPriceCapPetroleum.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return pumpPriceCap;
    }

    public PumpPriceCap getPumpPriceCapKeroseneData(){

        PumpPriceCap pumpPriceCap = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            pumpPriceCap = new PumpPriceCap(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    2,Double.parseDouble(this.pumpPriceCapKerosene.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return pumpPriceCap;
    }

    public PumpPriceCap getPumpPriceCapDieselData(){

        PumpPriceCap pumpPriceCap = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            pumpPriceCap = new PumpPriceCap(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    3,Double.parseDouble(this.pumpPriceCapDiesel.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return pumpPriceCap;
    }

    public  void saveCurrentPumpPriceCap(EventHandler eventHandler){
        this.save_submit_button.setOnMouseClicked(eventHandler);
    }

}
