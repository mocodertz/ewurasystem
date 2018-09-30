package view;

import Static.FOB;
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

public class FOBView extends VBox {

    protected ScrollPane fob_view_scrollpane;
    private TableView<FOB> fob_view_tableview;
    protected VBox main_content_fob_view;
    private HBox fob_view_table_heading_section;

    private ComboBox<String> add_day;
    private ComboBox<String> add_product;
    private ComboBox<Integer> add_date;
    private ComboBox<String> add_month;
    private ComboBox<Integer> add_year;
    private TextField add_fob_value;
    private Button add_submit_button;
    private Button add_clear_button;

    private ComboBox<String> update_day;
    private ComboBox<String> update_product;
    private ComboBox<Integer> update_date;
    private ComboBox<String> update_month;
    private ComboBox<Integer> update_year;
    private TextField update_fob_value;
    private Button update_submit_button;
    private Button update_clear_button;

    HBox adding_control_heading_section;
    HBox updating_control_heading_section;

    VBox main_holder_controler_adding_section;
    VBox main_holder_controler_updating_section;

    public FOBView(){
        this.setPadding(new Insets(5,0,5,0));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        this.add_day = new ComboBox<>();
        this.add_day.setPromptText("Select Day");

        this.add_product=new ComboBox<>();
        this.add_product.setPromptText("Select Product");
        this.add_date = new ComboBox<>();
        this.add_date.setPromptText("Select Date");

        this.add_month = new ComboBox<>();
        this.add_month.setPromptText("Select Month");

        this.add_year = new ComboBox<>();
        this.add_year.setPromptText("Select Year");

        this.add_fob_value = new TextField();
        this.add_fob_value.setPromptText("FOB Value");

        this.add_submit_button = new Button("Add");
        this.add_clear_button = new Button("Clear");

        this.update_day = new ComboBox<>();
        this.update_day.setPromptText("Select Day");

        this.update_product = new ComboBox<>();
        this.update_product.setPromptText("Select Product");
        this.update_date = new ComboBox<>();
        this.update_date.setPromptText("Select Date");

        this.update_month = new ComboBox<>();
        this.update_month.setPromptText("Select Month");

        this.update_year = new ComboBox<>();
        this.update_year.setPromptText("Select Year");

        this.update_fob_value = new TextField();
        this.update_fob_value.setPromptText("Exchange Rate Value");

        this.update_submit_button = new Button("Update");

        this.update_clear_button = new Button("Clear");

        this.fob_view_tableview = new TableView<>();
        this.fob_view_tableview.setStyle("-fx-background-color: #eeeeee;");

        this.main_holder_controler_adding_section = new VBox();
        this.main_holder_controler_adding_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_adding_section.setSpacing(5);
        this.main_holder_controler_updating_section = new VBox();
        this.main_holder_controler_updating_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_updating_section.setSpacing(5);

        construct_fob_view_TableView();
        constructfobAddingControls();
        constructfobUpdatingControls();

        this.main_content_fob_view = new VBox();
        this.main_content_fob_view.setAlignment(Pos.TOP_CENTER);
        this.main_content_fob_view.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_fob_view.setPadding(new Insets(5,5,5,5));
        this.main_content_fob_view.setSpacing(10);
        this.main_content_fob_view.getChildren().addAll(this.fob_view_table_heading_section,this.fob_view_tableview,
                this.adding_control_heading_section,this.main_holder_controler_adding_section,this.updating_control_heading_section,
                this.main_holder_controler_updating_section);

        this.fob_view_scrollpane =new ScrollPane();
        this.fob_view_scrollpane.setContent(this.main_content_fob_view);
        this.fob_view_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.fob_view_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.fob_view_scrollpane.setStyle("-fx-background-color: #eeeeee;");

        this.getChildren().add(fob_view_scrollpane);
    }

    private void construct_fob_view_TableView(){

        this.fob_view_table_heading_section = new HBox();
        this.fob_view_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.fob_view_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.fob_view_table_heading_section.setMinWidth(700);
        this.fob_view_table_heading_section.setMinHeight(27);
        this.fob_view_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_fob_view_table_section = new Label("fob Information Table");
        lbl_fob_view_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.fob_view_table_heading_section.getChildren().add(lbl_fob_view_table_section);

        TableColumn<FOB, Integer> identity_column_fob_view = new TableColumn<>("Identity");
        identity_column_fob_view.setMinWidth(100);
        identity_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, Integer> date_column_fob_view = new TableColumn<>("Date");
        date_column_fob_view.setMinWidth(100);
        date_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, String> day_column_fob_view = new TableColumn<>("Day");
        day_column_fob_view.setMinWidth(100);
        day_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, String> month_column_fob_view = new TableColumn<>("Month");
        month_column_fob_view.setMinWidth(100);
        month_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, Integer> year_column_fob_view = new TableColumn<>("Year");
        year_column_fob_view.setMinWidth(100);
        year_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, String> product_column_fob_view = new TableColumn<>("Product");
        product_column_fob_view.setMinWidth(100);
        product_column_fob_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<FOB, Double> fob_view_value_column = new TableColumn<>("FOB Value");
        fob_view_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        fob_view_value_column.setMinWidth(200);

        identity_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_identity"));
        date_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_date"));
        day_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_day"));
        month_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_month"));
        year_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_year"));
        product_column_fob_view.setCellValueFactory(new PropertyValueFactory<>("fob_product"));
        fob_view_value_column.setCellValueFactory(new PropertyValueFactory<>("fob_value"));

        this.fob_view_tableview.getColumns().addAll(identity_column_fob_view,date_column_fob_view,day_column_fob_view,month_column_fob_view,
                year_column_fob_view,fob_view_value_column,product_column_fob_view);
    }
    private void constructfobAddingControls(){
        this.adding_control_heading_section = new HBox();
        this.adding_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.adding_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.adding_control_heading_section.setMinWidth(700);
        this.adding_control_heading_section.setMinHeight(27);
        this.adding_control_heading_section.setAlignment(Pos.CENTER);

        Label lbl_adding_section = new Label("Add FOB Price Information");
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
        hold_rowtwo_controls.getChildren().addAll(this.add_product,this.add_fob_value);

        HBox hold_rowthree_controls = new HBox();
        hold_rowthree_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls.setSpacing(5);
        hold_rowthree_controls.getChildren().addAll(this.add_submit_button,this.add_clear_button);

        populateComboBoxes();

        main_holder_controler_adding_section.getChildren().addAll(info_hbox,hold_rowone_controls,hold_rowtwo_controls,
                hold_rowthree_controls);

    }

    private void constructfobUpdatingControls(){

        this.updating_control_heading_section = new HBox();
        this.updating_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.updating_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.updating_control_heading_section.setMinWidth(700);
        this.updating_control_heading_section.setMinHeight(27);
        this.updating_control_heading_section.setAlignment(Pos.TOP_CENTER);
        Label lbl_updating_section = new Label("Update FOB Price Information");
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

    public FOB getFOBDatatobeAdded(){

        FOB fob = null;
        if(this.add_day.getValue() !=null && this.add_date.getValue() !=null && this.add_month.getValue() !=null &&
                this.add_year.getValue() !=null && this.add_fob_value.getText() !=null && this.add_product !=null) {
            fob = new FOB(1, this.add_day.getValue().toString(), Integer.parseInt(this.add_date.getValue().toString()),
                    this.add_month.getValue().toString(), Integer.parseInt(this.add_year.getValue().toString()),
                    this.add_product.getValue().toString(),Double.parseDouble(this.add_fob_value.getText()));

        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return fob;
    }
    public FOB getFOBDatatobeUpdated(){
        FOB fob=null;
        String temp_product_id=null;
        if(this.update_day.getValue() !=null && this.update_date.getValue() !=null && this.update_month.getValue() !=null &&
                this.update_year.getValue() !=null && this.update_fob_value.getText() !=null && this.update_product !=null) {

            if(this.update_product.getValue() =="Petroleum"){
                temp_product_id ="1";
            }else if(this.update_product.getValue()=="Kerosene"){
                temp_product_id ="2";
            }else if(this.update_product.getValue()=="Diesel"){
                temp_product_id="3";
            }

            fob = new FOB(1,this.update_day.getValue().toString(), Integer.parseInt(this.update_date.getValue().toString()),
                    this.update_month.getValue().toString(), Integer.parseInt(this.update_year.getValue().toString()),temp_product_id,Double.parseDouble(this.update_fob_value.getText()));

        } else{
            System.out.println("You Must Fill All the Filled");
        }
        return fob;
    }
    public void setFOBTableViewData(ObservableList<FOB> fob_data){
        this.fob_view_tableview.setItems(fob_data);
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

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);
        ObservableList<String> product_list = FXCollections.observableArrayList("Petroleum","Kerosene","Diesel");

        /*For Adding*/
        this.add_day.setItems(null);
        this.add_date.setItems(null);
        this.add_year.setItems(null);
        this.add_product.setItems(null);

        this.add_day.setItems(day_value);
        this.add_date.setItems(date_value);
        this.add_month.setItems(month_value);
        this.add_year.setItems(year_value);
        this.add_product.setItems(product_list);

        /*For Updating*/
        this.update_day.setItems(null);
        this.update_date.setItems(null);
        this.update_year.setItems(null);
        this.update_product.setItems(null);

        this.update_day.setItems(day_value);
        this.update_date.setItems(date_value);
        this.update_month.setItems(month_value);
        this.update_year.setItems(year_value);
        this.update_product.setItems(product_list);
    }

}
