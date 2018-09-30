package view;

import Static.GovernmentTaxes;
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

public class ComputeGovernmentTaxes extends VBox {

    /*todo Petroleum Controls*/
    private Label fuelLevyPetroleum;
    private Label exerciseDutyPetroleum;
    private Label petroleumFee;
    private Label totalGovernmentTaxesPetroleum;

    /*todo Petroleum Controls*/
    private Label fuelLevyDiesel;
    private Label exerciseDutyDiesel;
    private Label dieselFee;
    private Label totalGovernmentTaxesDiesel;

    /*todo Petroleum Controls*/
    private Label fuelLevyKerosene;
    private Label exerciseDutyKerosene;
    private Label keroseneFee;
    private Label totalGovernmentTaxesKerosene;

    /*todo Shared Controls*/
    private Button queryComputedGovernmentTax;
    private ComboBox<Integer> governmentTaxesYear;
    private ComboBox<String> governmentTaxesMonth;

    /**For Saving Local Cost*/
    private ComboBox<String> save_day;
    private ComboBox<Integer> save_date;
    private ComboBox<String> save_month;
    private ComboBox<Integer> save_year;
    private Button save_submit_button;
    /*todo Section Header Holder*/
    /**private HBox custom_local_heading_section;*/
    private VBox temp_save_controls_vbox;

    public ComputeGovernmentTaxes(){

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
        this.fuelLevyPetroleum = new Label("Not Available");
        this.exerciseDutyPetroleum = new Label("Not Available");
        this.petroleumFee = new Label("Not Available");
        this.totalGovernmentTaxesPetroleum = new Label("Not Available");

        /*todo Initializing Petroleum Controls*/
        this.fuelLevyDiesel = new Label("Not Available");
        this.exerciseDutyDiesel = new Label("Not Available");
        this.dieselFee = new Label("Not Available");
        this.totalGovernmentTaxesDiesel = new Label("Not Available");

        /*todo Initializing Petroleum Controls*/
        this.fuelLevyKerosene = new Label("Not Available");
        this.exerciseDutyKerosene = new Label("Not Available");
        this.keroseneFee = new Label("Not Available");
        this.totalGovernmentTaxesKerosene = new Label("Not Available");

         /*todo Initializing Shared Controls*/
        this.queryComputedGovernmentTax = new Button("Get Computed Government Taxes");
        this.governmentTaxesMonth = new ComboBox<>();
        this.governmentTaxesMonth.setPromptText("Select Month");
        this.governmentTaxesYear = new ComboBox<>();
        this.governmentTaxesYear.setPromptText("Select Year");

        populateComboBoxes();
        constructComputedGovernmentTaxes();
    }

    private void constructComputedGovernmentTaxes(){

        HBox custom_local_heading_section = new HBox();
        VBox.setMargin(custom_local_heading_section,new Insets(10));
        custom_local_heading_section.setStyle("-fx-background-color: #085394;");
        custom_local_heading_section.setPadding(new Insets(5, 0, 5, 0));
        custom_local_heading_section.setMaxWidth(700);
        custom_local_heading_section.setMinHeight(27);
        custom_local_heading_section.setAlignment(Pos.CENTER);
        Label lbl_adding_section = new Label("Computed Government Taxes");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        custom_local_heading_section.getChildren().add(lbl_adding_section);

        HBox hold_search_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_search_controls.setSpacing(5);
        hold_search_controls.setPadding(new Insets(10));
        hold_search_controls.getChildren().addAll(this.governmentTaxesMonth,this.governmentTaxesYear,this.queryComputedGovernmentTax);

        this.temp_save_controls_vbox = new VBox();
        this.temp_save_controls_vbox.setSpacing(2.5);
        this.temp_save_controls_vbox.setPadding(new Insets(10));
        HBox hold_save_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_save_controls.setSpacing(5);
        //hold_save_controls.setPadding(new Insets(10));
        hold_save_controls.getChildren().addAll(this.save_day,this.save_date,this.save_month,this.save_year);
        this.temp_save_controls_vbox.getChildren().addAll(hold_save_controls,this.save_submit_button);

        /*todo local GridPane*/
        Label localCost_header = new Label("GOVERNMENT TAXES");
        localCost_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label petrol_header = new Label("PETROL");
        petrol_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label diesel_header = new Label("DIESEL");
        diesel_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label kerosene_header = new Label("KEROSENE");
        kerosene_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");

        GridPane hold_localComputedControls = new GridPane();
            /**hold_localComputedControls.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);*/
            hold_localComputedControls.setGridLinesVisible(true);
            /**hold_localComputedControls.setAlignment(Pos.CENTER);*/
            hold_localComputedControls.setPadding(new Insets(10));

            hold_localComputedControls.add(localCost_header,0,0);
            hold_localComputedControls.add(petrol_header,1,0);
            hold_localComputedControls.add(diesel_header,2,0);
            hold_localComputedControls.add(kerosene_header,3,0);

        Label fuelLevy = new Label("Fuel Levy");
            fuelLevy.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
            this.fuelLevyPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.fuelLevyDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.fuelLevyKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(fuelLevy,0,1);
            hold_localComputedControls.add(fuelLevyPetroleum,1,1);
            hold_localComputedControls.add(fuelLevyDiesel,2,1);
            hold_localComputedControls.add(fuelLevyKerosene,3,1);

        Label exerciseDuty = new Label("Exercise Duty");
            exerciseDuty.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.exerciseDutyPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.exerciseDutyDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.exerciseDutyKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(exerciseDuty,0,2);
            hold_localComputedControls.add(exerciseDutyPetroleum,1,2);
            hold_localComputedControls.add(exerciseDutyDiesel,2,2);
            hold_localComputedControls.add(exerciseDutyKerosene,3,2);

        Label petroleumFeeLocal = new Label("Petroleum Fee");
            petroleumFeeLocal.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.petroleumFee.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.dieselFee.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.keroseneFee.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(petroleumFeeLocal,0,3);
            hold_localComputedControls.add(petroleumFee,1,3);
            hold_localComputedControls.add(dieselFee,2,3);
            hold_localComputedControls.add(keroseneFee,3,3);

        Label totalTaxes = new Label("TOTAL GOVERNMENT TAXES (GT)");
            totalTaxes.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 3px;");
            this.totalGovernmentTaxesPetroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.totalGovernmentTaxesDiesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.totalGovernmentTaxesKerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(totalTaxes,0,4);
            hold_localComputedControls.add(totalGovernmentTaxesPetroleum,1,4);
            hold_localComputedControls.add(totalGovernmentTaxesDiesel,2,4);
            hold_localComputedControls.add(totalGovernmentTaxesKerosene,3,4);

        /**Setting Grid Pane Constraints*/
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(325));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        /**this.setSpacing(100);*/
        this.getChildren().addAll(custom_local_heading_section,hold_search_controls,hold_localComputedControls,
                temp_save_controls_vbox);
        /**this.setAlignment(Pos.TOP_);*/
    }

    public String getMonth(){
        return governmentTaxesMonth.getValue().toString();
    }

    public int getYear(){
        return governmentTaxesYear.getValue();
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

        this.governmentTaxesMonth.setItems(null);
        this.governmentTaxesYear.setItems(null);

        this.save_day.setItems(null);
        this.save_date.setItems(null);
        this.save_year.setItems(null);
        this.save_month.setItems(null);

        this.save_day.setItems(day_value);
        this.save_date.setItems(date_value);
        this.save_month.setItems(month_value);
        this.save_year.setItems(year_value);
        this.governmentTaxesMonth.setItems(month_value);
        this.governmentTaxesYear.setItems(year_value);


    }

    public void setNonComputedData(double fuel_levy_petroleum, double fuel_levy_diesel, double fuel_levy_kerosene,
                                   double exercise_duty_petroleum, double exercise_duty_diesel, double exercise_duty_kerosene,
                                   double petroleum_fee_petroleum, double petroleum_fee_diesel, double petroleum_fee_kerosene){

        /*todo Fuel Levy*/
        this.fuelLevyPetroleum.setText(String.valueOf(fuel_levy_petroleum));
        this.fuelLevyKerosene.setText(String.valueOf(fuel_levy_kerosene));
        this.fuelLevyDiesel.setText(String.valueOf(fuel_levy_diesel));

        /*todo Exercise Duty*/
        this.exerciseDutyPetroleum.setText(String.valueOf(exercise_duty_petroleum));
        this.exerciseDutyKerosene.setText(String.valueOf(exercise_duty_kerosene));
        this.exerciseDutyDiesel.setText(String.valueOf(exercise_duty_diesel));

        /*todo Petroleum Fee*/
        this.petroleumFee.setText(String.valueOf(petroleum_fee_petroleum));
        this.dieselFee.setText(String.valueOf(petroleum_fee_diesel));
        this.keroseneFee.setText(String.valueOf(petroleum_fee_kerosene));

    }

    public void setComputedData(double fuel_levy_petroleum, double fuel_levy_diesel, double fuel_levy_kerosene,
                                double exercise_duty_petroleum, double exercise_duty_diesel, double exercise_duty_kerosene,
                                double petroleum_fee_petroleum, double petroleum_fee_diesel, double petroleum_fee_kerosene){

        double temp_government_taxes_petroleum = fuel_levy_petroleum + exercise_duty_petroleum +
                petroleum_fee_petroleum;
        double temp_government_taxes_kerosene = fuel_levy_kerosene + exercise_duty_kerosene +
                petroleum_fee_kerosene;
        double temp_government_taxes_diesel = fuel_levy_diesel + exercise_duty_diesel +
                petroleum_fee_diesel;


        /*todo assign values to labels*/
        this.totalGovernmentTaxesPetroleum.setText(String.valueOf(temp_government_taxes_petroleum));
        this.totalGovernmentTaxesKerosene.setText(String.valueOf(temp_government_taxes_kerosene));
        this.totalGovernmentTaxesDiesel.setText(String.valueOf(temp_government_taxes_diesel));
    }

    public void addQueryStoredDataEvent(EventHandler eventhandler){
        this.queryComputedGovernmentTax.setOnAction(eventhandler);
    }

    public void hideSearchControls(){
        this.queryComputedGovernmentTax.setVisible(false);
        this.governmentTaxesMonth.setVisible(false);
        this.governmentTaxesYear.setVisible(false);
        this.temp_save_controls_vbox.setVisible(false);
    }

    public GovernmentTaxes getGovernmentTaxesPetroleumData(){

        GovernmentTaxes governmentTaxes = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            governmentTaxes = new GovernmentTaxes(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    1,Double.parseDouble(this.totalGovernmentTaxesPetroleum.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return governmentTaxes;
    }

    public GovernmentTaxes getGovernmentTaxesKeroseneData(){

        GovernmentTaxes governmentTaxes = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            governmentTaxes = new GovernmentTaxes(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    2,Double.parseDouble(this.totalGovernmentTaxesKerosene.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return governmentTaxes;
    }

    public GovernmentTaxes getPumpGovernmentTaxesDieselData(){

        GovernmentTaxes governmentTaxes = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            governmentTaxes = new GovernmentTaxes(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    3,Double.parseDouble(this.totalGovernmentTaxesDiesel.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return governmentTaxes;
    }

    public  void saveCurrentComputedGovernmentTaxes(EventHandler eventHandler){
        this.save_submit_button.setOnMouseClicked(eventHandler);
    }
}
