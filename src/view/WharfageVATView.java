package view;

import Static.MarkingCost;
import Static.WeightPlattFIP;
import Static.Wharfage;
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

public class WharfageVATView extends VBox {

    protected ScrollPane wharfage_view_scrollpane;
    private TableView<Wharfage> wharfage_view_tableview;
    protected VBox main_content_wharfage_view;
    private HBox wharfage_view_table_heading_section;

    private ComboBox<String> add_day;
    private ComboBox<String> add_exchangerate_month;
    private ComboBox<String> add_waa_conversion_factor_month;
    private ComboBox<String> add_product;
    private ComboBox<Integer> add_date;
    private ComboBox<String> add_month;
    private ComboBox<Integer> add_year;
    private Button add_submit_button;
    private Button add_clear_button;

    private ComboBox<String> update_day;
    private ComboBox<String> update_product;
    private ComboBox<Integer> update_date;
    private ComboBox<String> update_month;
    private ComboBox<Integer> update_year;
    private Button update_submit_button;
    private Button update_clear_button;

    HBox adding_control_heading_section;
    HBox updating_control_heading_section;

    VBox main_holder_controler_adding_section;
    VBox main_holder_controler_updating_section;

    public WharfageVATView(){
        this.setPadding(new Insets(5, 0, 5, 75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        this.add_day = new ComboBox<>();
        this.add_day.setPromptText("Select Day");

        this.add_exchangerate_month=new ComboBox<>();
        this.add_exchangerate_month.setPromptText("Exchangerate Month");

        this.add_waa_conversion_factor_month=new ComboBox();
        this.add_waa_conversion_factor_month.setPromptText("Conversion Factor");

        this.add_product=new ComboBox();
        this.add_product.setPromptText("Select Product");

        this.add_date = new ComboBox<>();
        this.add_date.setPromptText("Select Date");

        this.add_month = new ComboBox<>();
        this.add_month.setPromptText("Select Month");

        this.add_year = new ComboBox<>();
        this.add_year.setPromptText("Select Year");

        this.add_submit_button = new Button("Add");
        this.add_clear_button = new Button("Clear");

        this.update_day = new ComboBox<>();
        this.update_day.setPromptText("Select Day");

        this.update_product = new ComboBox<>();
        this.update_product.setPromptText("Exchangerate Month");
        this.update_date = new ComboBox<>();
        this.update_date.setPromptText("Select Date");

        this.update_month = new ComboBox<>();
        this.update_month.setPromptText("Select Month");

        this.update_year = new ComboBox<>();
        this.update_year.setPromptText("Select Year");

        this.update_submit_button = new Button("Update");

        this.update_clear_button = new Button("Clear");

        this.wharfage_view_tableview = new TableView<>();
        this.wharfage_view_tableview.setStyle("-fx-background-color: #eeeeee;");

        this.main_holder_controler_adding_section = new VBox();
        this.main_holder_controler_adding_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_adding_section.setSpacing(5);
        this.main_holder_controler_updating_section = new VBox();
        this.main_holder_controler_updating_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_updating_section.setSpacing(5);

        constructMarkingCostView_TableView();
        constructMarkingCostViewAddingControls();
        constructMarkingCostViewUpdatingControls();

        this.main_content_wharfage_view = new VBox();
        this.main_content_wharfage_view.setAlignment(Pos.TOP_CENTER);
        this.main_content_wharfage_view.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_wharfage_view.setPadding(new Insets(5,5,5,5));
        this.main_content_wharfage_view.setSpacing(10);
        this.main_content_wharfage_view.getChildren().addAll(this.wharfage_view_table_heading_section,this.wharfage_view_tableview,
                this.adding_control_heading_section,this.main_holder_controler_adding_section,this.updating_control_heading_section,
                this.main_holder_controler_updating_section);

        this.wharfage_view_scrollpane =new ScrollPane();
        this.wharfage_view_scrollpane.setContent(this.main_content_wharfage_view);
        this.wharfage_view_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.wharfage_view_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.wharfage_view_scrollpane.setStyle("-fx-background-color: #eeeeee;");

        this.getChildren().add(wharfage_view_scrollpane);
    }

    private void constructMarkingCostView_TableView(){

        this.wharfage_view_table_heading_section = new HBox();
        this.wharfage_view_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.wharfage_view_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.wharfage_view_table_heading_section.setMinWidth(700);
        this.wharfage_view_table_heading_section.setMinHeight(27);
        this.wharfage_view_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_wharfage_view_table_section = new Label("wharfage Information Table");
        lbl_wharfage_view_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.wharfage_view_table_heading_section.getChildren().add(lbl_wharfage_view_table_section);

        TableColumn<Wharfage, Integer> identity_column_wharfage_view = new TableColumn<>("Identity");
        identity_column_wharfage_view.setMinWidth(100);
        identity_column_wharfage_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<Wharfage, Integer> date_column_wharfage_view = new TableColumn<>("Date");
        date_column_wharfage_view.setMinWidth(100);
        date_column_wharfage_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<Wharfage, String> day_column_wharfage_view = new TableColumn<>("Day");
        day_column_wharfage_view.setMinWidth(100);
        day_column_wharfage_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<Wharfage, String> month_column_wharfage_view = new TableColumn<>("Month");
        month_column_wharfage_view.setMinWidth(100);
        month_column_wharfage_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<Wharfage, Integer> year_column_wharfage_view = new TableColumn<>("Year");
        year_column_wharfage_view.setMinWidth(100);
        year_column_wharfage_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<Wharfage, Double> wharfage_view_value_column = new TableColumn<>("Wharfage Value");
        wharfage_view_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        wharfage_view_value_column.setMinWidth(100);

        TableColumn<Wharfage, Integer> wharfage_view_exchangerate_column = new TableColumn<>("Exchangerate");
        wharfage_view_exchangerate_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        wharfage_view_exchangerate_column.setMinWidth(100);

        TableColumn<Wharfage, Integer> wharfage_waa_conversion_factor_column = new TableColumn<>("Exchangerate");
        wharfage_waa_conversion_factor_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        wharfage_waa_conversion_factor_column.setMinWidth(200);

        identity_column_wharfage_view.setCellValueFactory(new PropertyValueFactory<>("wharfage_id"));
        date_column_wharfage_view.setCellValueFactory(new PropertyValueFactory<>("wharfage_date"));
        day_column_wharfage_view.setCellValueFactory(new PropertyValueFactory<>("wharfage_day"));
        month_column_wharfage_view.setCellValueFactory(new PropertyValueFactory<>("wharfage_month"));
        year_column_wharfage_view.setCellValueFactory(new PropertyValueFactory<>("wharfage_year"));
        wharfage_view_value_column.setCellValueFactory(new PropertyValueFactory<>("wharfage_value"));
        wharfage_view_exchangerate_column.setCellValueFactory(new PropertyValueFactory<>("wharfage_exchangerate"));
        wharfage_waa_conversion_factor_column.setCellValueFactory(new PropertyValueFactory<>("wharfage_waa_conversion_factor"));

        this.wharfage_view_tableview.getColumns().addAll(identity_column_wharfage_view,date_column_wharfage_view,day_column_wharfage_view,month_column_wharfage_view,year_column_wharfage_view,wharfage_view_exchangerate_column,wharfage_view_value_column);
    }
    private void constructMarkingCostViewAddingControls(){
        this.adding_control_heading_section = new HBox();
        this.adding_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.adding_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.adding_control_heading_section.setMinWidth(700);
        this.adding_control_heading_section.setMinHeight(27);
        this.adding_control_heading_section.setAlignment(Pos.CENTER);

        Label lbl_adding_section = new Label("Add wharfage Information");
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
        hold_rowone_controls.getChildren().addAll(this.add_day,this.add_date,this.add_month,this.add_year);

        HBox hold_rowtwo_controls = new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(this.add_exchangerate_month,this.add_waa_conversion_factor_month, this.add_product);

        HBox hold_rowthree_controls = new HBox();
        hold_rowthree_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls.setSpacing(5);
        hold_rowthree_controls.getChildren().addAll(this.add_submit_button,this.add_clear_button);

        populateComboBoxes();

        main_holder_controler_adding_section.getChildren().addAll(info_hbox,hold_rowone_controls,hold_rowtwo_controls,
                hold_rowthree_controls);

    }

    private void constructMarkingCostViewUpdatingControls(){

        this.updating_control_heading_section = new HBox();
        this.updating_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.updating_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.updating_control_heading_section.setMinWidth(700);
        this.updating_control_heading_section.setMinHeight(27);
        this.updating_control_heading_section.setAlignment(Pos.TOP_CENTER);
        Label lbl_updating_section = new Label("Update Exchange Rate Information");
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
        hold_rowone_controls_update.getChildren().addAll(this.update_day,this.update_date,this.update_month,this.update_year);

        HBox hold_rowtwo_controls_update = new HBox();
        hold_rowtwo_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_update.setSpacing(5);
        hold_rowtwo_controls_update.getChildren().addAll(this.update_product);

        HBox hold_rowthree_controls_update = new HBox();
        hold_rowthree_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_update.setSpacing(5);
        hold_rowthree_controls_update.getChildren().addAll(this.update_submit_button,this.update_clear_button);

        main_holder_controler_updating_section.getChildren().addAll(info_hbox_update,hold_rowone_controls_update,hold_rowtwo_controls_update,
                hold_rowthree_controls_update);
    }

    public Wharfage getWharfageDatatobeAdded(double exchangerateValue, int exchangerate_id, double waaValue, int waa_id){

        Wharfage wharfage = null;
        int temp_product_id=0;
        double computed_wharfage_cost = (10 * exchangerateValue * waaValue * 1.18)/1000;
        if(this.add_day.getValue() !=null && this.add_date.getValue() !=null && this.add_month.getValue() !=null &&
                this.add_year.getValue() !=null && this.add_waa_conversion_factor_month.getValue().toString()!=null &&
                this.add_exchangerate_month.getValue().toString() !=null && this.add_product.getValue().toString() !=null) {

            if(this.add_product.getValue().toString() =="Petroleum"){

                temp_product_id=1;

            }else if(this.add_product.getValue().toString() =="Diesel"){
                temp_product_id=3;

            }else if(this.add_product.getValue().toString() =="Kerosene"){
                temp_product_id=2;
            }
            wharfage = new Wharfage(1,temp_product_id,this.add_day.getValue().toString(),
                    Integer.parseInt(this.add_date.getValue().toString()), this.add_month.getValue().toString(),
                    Integer.parseInt(this.add_year.getValue().toString()),computed_wharfage_cost,exchangerate_id,
                    waa_id);

        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return wharfage;
    }

    public void addEventListenersSubmitButtonAdd(EventHandler eventHandler){

        this.add_submit_button.setOnMouseClicked(eventHandler);

    }
    public void addEventListenersUpdateButton(EventHandler eventHandler){
        this.update_submit_button.setOnMouseClicked(eventHandler);
    }
    private void populateComboBoxes(){

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Friday",
                "Thursday", "Saturday","Sunday");

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","November","December");

        ObservableList<String> product_value = FXCollections.observableArrayList("Petroleum","Diesel","Kerosene");

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);

        /*For Adding*/
        this.add_day.setItems(null);
        this.add_date.setItems(null);
        this.add_year.setItems(null);
        this.add_exchangerate_month.setItems(null);
        this.add_product.setItems(null);


        this.add_day.setItems(day_value);
        this.add_date.setItems(date_value);
        this.add_month.setItems(month_value);
        this.add_year.setItems(year_value);
        this.add_exchangerate_month.setItems(month_value);
        this.add_waa_conversion_factor_month.setItems(month_value);
        this.add_product.setItems(product_value);

        /*For Updating*/
        this.update_day.setItems(null);
        this.update_date.setItems(null);
        this.update_year.setItems(null);
        this.update_product.setItems(null);

        this.update_day.setItems(day_value);
        this.update_date.setItems(date_value);
        this.update_month.setItems(month_value);
        this.update_year.setItems(year_value);
        this.update_product.setItems(month_value);
    }

    public String getSelectedMonth() {
        return this.add_exchangerate_month.getValue().toString();
    }

    public int getSelectedYear() {
        return this.add_year.getValue();
    }

    public String getWAAMonth(){
        return this.add_waa_conversion_factor_month.getValue().toString();
    }

    public String getSelectedProduct(){
        return this.add_product.getValue().toString();
    }

    public void setWharfageTableViewData(ObservableList<Wharfage> wharfage){
        this.wharfage_view_tableview.setItems(wharfage);
    }
}
