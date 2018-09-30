package view;

import Static.ComputedExchagerate;
import Static.ExchangeRate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ComputedExchangerateView extends VBox {

    protected ScrollPane computed_exchangerate_view_scrollpane;
    private TableView<ExchangeRate> computed_exchangerate_view_tableview;
    protected VBox main_content_computed_exchangerate_view;
    private HBox computed_exchangerate_view_table_heading_section;

    private ComboBox<String> com_add_day;
    private ComboBox<Integer> com_add_date;
    private ComboBox<String> com_add_month;
    private ComboBox<Integer> com_add_year;
    private Button add_button_computed;
    private Button add_clear_button;

    private ComboBox<String> com_update_day;
    private ComboBox<Integer> com_update_date;
    private ComboBox<String> com_update_month;
    private ComboBox<Integer> com_update_year;
    private Button update_computed_submit_button;
    private Button update_computed_clear_button;

    HBox adding_control_heading_section;
    HBox updating_control_heading_section;

    VBox main_holder_controler_adding_section;
    VBox main_holder_controler_updating_section;

    public ComputedExchangerateView(){

        this.setPadding(new Insets(5, 0, 5, 75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        this.com_add_day = new ComboBox<>();
        this.com_add_day.setPromptText("Select Day");

        this.com_add_date = new ComboBox<>();
        this.com_add_date.setPromptText("Select Date");

        this.com_add_month = new ComboBox<>();
        this.com_add_month.setPromptText("Select Month");

        this.com_add_year = new ComboBox<>();
        this.com_add_year.setPromptText("Select Year");

        this.add_button_computed = new Button("Compute");
        this.add_clear_button = new Button("Clear");

        this.com_update_day = new ComboBox<>();
        this.com_update_day.setPromptText("Select Day");

        this.com_update_date = new ComboBox<>();
        this.com_update_date.setPromptText("Select Date");

        this.com_update_month = new ComboBox<>();
        this.com_update_month.setPromptText("Select Month");

        this.com_update_year = new ComboBox<>();
        this.com_update_year.setPromptText("Select Year");

        this.update_computed_submit_button = new Button("Update");

        this.update_computed_clear_button = new Button("Clear");

        this.computed_exchangerate_view_tableview = new TableView<>();
        this.computed_exchangerate_view_tableview.setStyle("-fx-background-color: #eeeeee;");

        this.main_holder_controler_adding_section = new VBox();
        this.main_holder_controler_adding_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_adding_section.setSpacing(5);
        this.main_holder_controler_updating_section = new VBox();
        this.main_holder_controler_updating_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_updating_section.setSpacing(5);

        construct_computed_exchangerate_view_TableView();
        construct_computed_exchangerateAddingControls();
        construct_computed_exchangerateUpdatingControls();

        this.main_content_computed_exchangerate_view = new VBox();
        this.main_content_computed_exchangerate_view.setAlignment(Pos.TOP_CENTER);
        this.main_content_computed_exchangerate_view.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_computed_exchangerate_view.setPadding(new Insets(5,5,5,5));
        this.main_content_computed_exchangerate_view.setSpacing(10);
        this.main_content_computed_exchangerate_view.getChildren().addAll(this.computed_exchangerate_view_table_heading_section,this.computed_exchangerate_view_tableview,
                this.adding_control_heading_section,this.main_holder_controler_adding_section,this.updating_control_heading_section,
                this.main_holder_controler_updating_section);

        this.computed_exchangerate_view_scrollpane =new ScrollPane();
        this.computed_exchangerate_view_scrollpane.setContent(this.main_content_computed_exchangerate_view);
        this.computed_exchangerate_view_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.computed_exchangerate_view_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.computed_exchangerate_view_scrollpane.setStyle("-fx-background-color: #eeeeee;");

        this.getChildren().add(computed_exchangerate_view_scrollpane);
    }

    private void construct_computed_exchangerate_view_TableView(){

        this.computed_exchangerate_view_table_heading_section = new HBox();
        this.computed_exchangerate_view_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.computed_exchangerate_view_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.computed_exchangerate_view_table_heading_section.setMinWidth(700);
        this.computed_exchangerate_view_table_heading_section.setMinHeight(27);
        this.computed_exchangerate_view_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_computed_exchangerate_view_table_section = new Label("computed_exchangerate Information Table");
        lbl_computed_exchangerate_view_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.computed_exchangerate_view_table_heading_section.getChildren().add(lbl_computed_exchangerate_view_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column = new TableColumn<>("Identity");
        identity_column.setMinWidth(100);
        identity_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column = new TableColumn<>("Date");
        date_column.setMinWidth(100);
        date_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column = new TableColumn<>("Day");
        day_column.setMinWidth(100);
        day_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column = new TableColumn<>("Month");
        month_column.setMinWidth(100);
        month_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column = new TableColumn<>("Year");
        year_column.setMinWidth(100);
        year_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> exchangerate_value_column = new TableColumn<>("Exchangerate Value(USD->TSH)");
        exchangerate_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        exchangerate_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        exchangerate_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        /*Setting the Columns Properties*/

        this.computed_exchangerate_view_tableview.getColumns().addAll(identity_column,date_column,day_column,month_column,year_column,exchangerate_value_column);

        /*End TableView Columns*/

    }
    private void construct_computed_exchangerateAddingControls(){
        this.adding_control_heading_section = new HBox();
        this.adding_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.adding_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.adding_control_heading_section.setMinWidth(700);
        this.adding_control_heading_section.setMinHeight(27);
        this.adding_control_heading_section.setAlignment(Pos.CENTER);

        Label lbl_adding_section = new Label("Computed Exchange Rate");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        adding_control_heading_section.getChildren().add(lbl_adding_section);

        HBox info_hbox = new HBox();
        info_hbox.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox.setSpacing(2);
        info_hbox.getChildren().addAll(info_image,lbl_info);

        HBox hold_rowone_controls = new HBox();
        hold_rowone_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls.setSpacing(5);
        hold_rowone_controls.getChildren().addAll(this.com_add_day,this.com_add_date,this.com_add_month,this.com_add_year);

        HBox hold_rowthree_controls = new HBox();
        hold_rowthree_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls.setSpacing(5);
        hold_rowthree_controls.getChildren().addAll(this.add_button_computed,this.add_clear_button);

        populateComboBoxes();

        main_holder_controler_adding_section.getChildren().addAll(info_hbox,hold_rowone_controls,hold_rowthree_controls);

    }

    private void construct_computed_exchangerateUpdatingControls(){

        this.updating_control_heading_section = new HBox();
        this.updating_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.updating_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.updating_control_heading_section.setMinWidth(700);
        this.updating_control_heading_section.setMinHeight(27);
        this.updating_control_heading_section.setAlignment(Pos.TOP_CENTER);
        Label lbl_updating_section = new Label("Update Computed Exchange Rate Information");
        lbl_updating_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.updating_control_heading_section.getChildren().add(lbl_updating_section);

        HBox info_hbox_update = new HBox();
        info_hbox_update.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_update = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_update.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_update.setSpacing(2);
        info_hbox_update.getChildren().addAll(info_image,lbl_info_update);

        HBox hold_rowone_controls_update = new HBox();
        hold_rowone_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_update.setSpacing(5);
        hold_rowone_controls_update.getChildren().addAll(this.com_update_day,this.com_update_date,this.com_update_month,this.com_update_year);

        HBox hold_rowthree_controls_update = new HBox();
        hold_rowthree_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_update.setSpacing(5);
        hold_rowthree_controls_update.getChildren().addAll(this.update_computed_submit_button,this.update_computed_clear_button);

        main_holder_controler_updating_section.getChildren().addAll(info_hbox_update,hold_rowone_controls_update,hold_rowthree_controls_update);
    }

    public ExchangeRate getComputedExchangerateDatatobeAdded(){

        ExchangeRate exchangerate = null;
        if(this.com_add_day.getValue() !=null && this.com_add_date.getValue() !=null && this.com_add_month.getValue() !=null &&
                this.com_add_year.getValue() !=null) {
                exchangerate= new ExchangeRate(1, this.com_add_day.getValue(), Integer.parseInt(this.com_add_date.getValue().toString()), this.com_add_month.getValue(), Integer.parseInt(this.com_add_year.getValue().toString()),0);

        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return exchangerate;
    }

    public ComputedExchagerate getPreviousMonth(){
        ComputedExchagerate temp = null;
        if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "January"))
        {
            temp = new ComputedExchagerate("December",this.com_add_year.getValue()-1);
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "February"))
        {
            temp = new ComputedExchagerate("January",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "March"))
        {
            temp = new ComputedExchagerate("February",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "April"))
        {
            temp = new ComputedExchagerate("March",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "May"))
        {
            temp = new ComputedExchagerate("April",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "June"))
        {
            temp = new ComputedExchagerate("May",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "July"))
        {
            temp = new ComputedExchagerate("June",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "August"))
        {
            temp = new ComputedExchagerate("July",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "September"))
        {
            temp = new ComputedExchagerate("August",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "October"))
        {
            temp = new ComputedExchagerate("September",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "November"))
        {
            temp = new ComputedExchagerate("October",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "December"))
        {
            temp = new ComputedExchagerate("November",this.com_add_year.getValue());
        }

        return temp;
    }

    public ComputedExchagerate getPreviousThreeMonth(){
        ComputedExchagerate temp = null;
        if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "January"))
        {
            temp = new ComputedExchagerate("November",this.com_add_year.getValue()-1);
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "February"))
        {
            temp = new ComputedExchagerate("December",this.com_add_year.getValue()-1);
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "March"))
        {
            temp = new ComputedExchagerate("January",this.com_add_year.getValue()-1);
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "April"))
        {
            temp = new ComputedExchagerate("February",this.com_add_year.getValue()-1);
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "May"))
        {
            temp = new ComputedExchagerate("March",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "June"))
        {
            temp = new ComputedExchagerate("April",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "July"))
        {
            temp = new ComputedExchagerate("May",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(),"August"))
        {
            temp = new ComputedExchagerate("June",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "September"))
        {
            temp = new ComputedExchagerate("July",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "October"))
        {
            temp = new ComputedExchagerate("August",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "November"))
        {
            temp = new ComputedExchagerate("September",this.com_add_year.getValue());
        }
        else if(this.com_add_month.getValue() != null && Objects.equals(this.com_add_month.getValue(), "December"))
        {
            temp = new ComputedExchagerate("October",this.com_add_year.getValue());
        }

        return temp;

    }

    public void setComputedExchangerateTableViewData(ObservableList<ExchangeRate> computed_exchangerate_data){
        this.computed_exchangerate_view_tableview.setItems(computed_exchangerate_data);
    }

    public void addEventListenersAddComputedExchangerate(EventHandler handler){

        this.add_button_computed.setOnMouseClicked(handler);

    }

    public void addEventListenersUpdateButton(EventHandler eventHandler){
        this.update_computed_submit_button.setOnMouseClicked(eventHandler);
    }

    private void populateComboBoxes(){

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","November","December");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Friday",
                "Thursday", "Saturday","Sunday");



        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);
        ObservableList<String> product_list = FXCollections.observableArrayList("Petroleum","Kerosene","Diesel");

        /*For Adding*/
        this.com_add_day.setItems(null);
        this.com_add_date.setItems(null);
        this.com_add_year.setItems(null);

        this.com_add_day.setItems(day_value);
        this.com_add_date.setItems(date_value);
        this.com_add_month.setItems(month_value);
        this.com_add_year.setItems(year_value);

        /*For Updating*/
        this.com_update_day.setItems(null);
        this.com_update_date.setItems(null);
        this.com_update_year.setItems(null);

        this.com_update_day.setItems(day_value);
        this.com_update_date.setItems(date_value);
        this.com_update_month.setItems(month_value);
        this.com_update_year.setItems(year_value);
    }

}
