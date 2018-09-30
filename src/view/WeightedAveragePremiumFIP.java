package view;
import Static.WeightPlattFIP;
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

public class WeightedAveragePremiumFIP extends VBox {

    protected ScrollPane weightedFIP_view_scrollpane;
    private TableView<WeightPlattFIP> weightedFIP_view_tableview;
    protected VBox main_content_weightedFIP_view;
    private HBox weightedFIP_view_table_heading_section;

    private ComboBox<String> add_day;
    private ComboBox<String> add_exchangerate_month;
    private ComboBox<String> add_FIP_month;
    private ComboBox<String> add_weighted_actual_conversion_month;
    private ComboBox<String> selected_product;
    private ComboBox<Integer> add_date;
    private ComboBox<String> add_month;
    private ComboBox<Integer> add_year;
    private TextField add_weightedFIP_value;
    private Button add_submit_button;
    private Button add_clear_button;

    private ComboBox<String> update_day;
    private ComboBox<String> update_product;
    private ComboBox<Integer> update_date;
    private ComboBox<String> update_month;
    private ComboBox<Integer> update_year;
    private TextField update_weightedFIP_value;
    private Button update_submit_button;
    private Button update_clear_button;

    HBox adding_control_heading_section;
    HBox updating_control_heading_section;

    VBox main_holder_controler_adding_section;
    VBox main_holder_controler_updating_section;

    public WeightedAveragePremiumFIP(){
        this.setPadding(new Insets(5, 0, 5, 75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        this.add_day = new ComboBox<>();
        this.add_day.setPromptText("Select Day");

        this.add_exchangerate_month=new ComboBox<>();
        this.add_exchangerate_month.setPromptText("Exchangerate Month");

        this.add_FIP_month=new ComboBox<>();
        this.add_FIP_month.setPromptText("FIP Month");

        this.add_weighted_actual_conversion_month=new ComboBox<>();
        this.add_weighted_actual_conversion_month.setPromptText("WAACF Month");

        this.selected_product=new ComboBox<>();
        this.selected_product.setPromptText("Select Product");

        this.add_date = new ComboBox<>();
        this.add_date.setPromptText("Select Date");

        this.add_month = new ComboBox<>();
        this.add_month.setPromptText("Select Month");

        this.add_year = new ComboBox<>();
        this.add_year.setPromptText("Select Year");

        this.add_weightedFIP_value = new TextField();
        this.add_weightedFIP_value.setPromptText("Exchange Rate Value");

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

        this.update_weightedFIP_value = new TextField();
        this.update_weightedFIP_value.setPromptText("Exchange Rate Value");

        this.update_submit_button = new Button("Update");

        this.update_clear_button = new Button("Clear");

        this.weightedFIP_view_tableview = new TableView<>();
        this.weightedFIP_view_tableview.setStyle("-fx-background-color: #eeeeee;");

        this.main_holder_controler_adding_section = new VBox();
        this.main_holder_controler_adding_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_adding_section.setSpacing(5);
        this.main_holder_controler_updating_section = new VBox();
        this.main_holder_controler_updating_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_updating_section.setSpacing(5);

        constructWeightPlattFIPTableView();
        constructWeightPlattFIPViewAddingControls();
        constructWeightPlattFIPViewUpdatingControls();

        this.main_content_weightedFIP_view = new VBox();
        this.main_content_weightedFIP_view.setAlignment(Pos.TOP_CENTER);
        this.main_content_weightedFIP_view.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_weightedFIP_view.setPadding(new Insets(5,5,5,5));
        this.main_content_weightedFIP_view.setSpacing(10);
        this.main_content_weightedFIP_view.getChildren().addAll(this.weightedFIP_view_table_heading_section,this.weightedFIP_view_tableview,
                this.adding_control_heading_section,this.main_holder_controler_adding_section,this.updating_control_heading_section,
                this.main_holder_controler_updating_section);

        this.weightedFIP_view_scrollpane =new ScrollPane();
        this.weightedFIP_view_scrollpane.setContent(this.main_content_weightedFIP_view);
        this.weightedFIP_view_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.weightedFIP_view_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.weightedFIP_view_scrollpane.setStyle("-fx-background-color: #eeeeee;");

        this.getChildren().add(weightedFIP_view_scrollpane);
    }

    private void constructWeightPlattFIPTableView(){

        this.weightedFIP_view_table_heading_section = new HBox();
        this.weightedFIP_view_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.weightedFIP_view_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.weightedFIP_view_table_heading_section.setMinWidth(700);
        this.weightedFIP_view_table_heading_section.setMinHeight(27);
        this.weightedFIP_view_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_weightedFIP_view_table_section = new Label("weightedFIP Information Table");
        lbl_weightedFIP_view_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.weightedFIP_view_table_heading_section.getChildren().add(lbl_weightedFIP_view_table_section);

        TableColumn<WeightPlattFIP, Integer> identity_column_weightedFIP_view = new TableColumn<>("Identity");
        identity_column_weightedFIP_view.setMinWidth(102);
        identity_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> date_column_weightedFIP_view = new TableColumn<>("Date");
        date_column_weightedFIP_view.setMinWidth(102);
        date_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, String> day_column_weightedFIP_view = new TableColumn<>("Day");
        day_column_weightedFIP_view.setMinWidth(106);
        day_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, String> month_column_weightedFIP_view = new TableColumn<>("Month");
        month_column_weightedFIP_view.setMinWidth(102);
        month_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> year_column_weightedFIP_view = new TableColumn<>("Year");
        year_column_weightedFIP_view.setMinWidth(102);
        year_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> exchangerate_column_weightedFIP_view = new TableColumn<>("Exchange Rate");
        exchangerate_column_weightedFIP_view.setMinWidth(100);
        exchangerate_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> waacf_column_weightedFIP_view = new TableColumn<>("WAAC");
        waacf_column_weightedFIP_view.setMinWidth(100);
        waacf_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> fip_column_weightedFIP_view = new TableColumn<>("FIP");
        fip_column_weightedFIP_view.setMinWidth(102);
        fip_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<WeightPlattFIP, Integer> product_column_weightedFIP_view = new TableColumn<>("Product");
        product_column_weightedFIP_view.setMinWidth(102);
        product_column_weightedFIP_view.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");


        TableColumn<WeightPlattFIP, Double> weightedFIP_view_value_column = new TableColumn<>("Weighted Average Platt FIP");
        weightedFIP_view_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        weightedFIP_view_value_column.setMinWidth(190);

        identity_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_id"));
        date_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_date"));
        day_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_day"));
        month_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_month"));
        year_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_year"));
        product_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_product_id"));
        exchangerate_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_exchangerate"));
        waacf_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_waa_conversion_factor"));
        fip_column_weightedFIP_view.setCellValueFactory(new PropertyValueFactory<>("platt_fip_current_fip_fk"));
        weightedFIP_view_value_column.setCellValueFactory(new PropertyValueFactory<>("platt_fip_value"));

        /**Removed Columns identity_column_weightedFIP_view, exchangerate_column_weightedFIP_view,waacf_column_weightedFIP_view,fip_column_weightedFIP_view*/

        this.weightedFIP_view_tableview.getColumns().addAll(date_column_weightedFIP_view,
                day_column_weightedFIP_view,month_column_weightedFIP_view,year_column_weightedFIP_view,
                weightedFIP_view_value_column,product_column_weightedFIP_view);
    }
    private void constructWeightPlattFIPViewAddingControls(){
        this.adding_control_heading_section = new HBox();
        this.adding_control_heading_section.setStyle("-fx-background-color: #085394;");
        this.adding_control_heading_section.setPadding(new Insets(5,0,5,0));
        this.adding_control_heading_section.setMinWidth(700);
        this.adding_control_heading_section.setMinHeight(27);
        this.adding_control_heading_section.setAlignment(Pos.CENTER);

        Label lbl_adding_section = new Label("Add weighted FIP Information");
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
        hold_rowtwo_controls.getChildren().addAll(this.add_exchangerate_month,this.add_FIP_month,this.add_weighted_actual_conversion_month, this.selected_product);

        HBox hold_rowthree_controls = new HBox();
        hold_rowthree_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls.setSpacing(5);
        hold_rowthree_controls.getChildren().addAll(this.add_submit_button,this.add_clear_button);

        populateComboBoxes();

        main_holder_controler_adding_section.getChildren().addAll(info_hbox,hold_rowone_controls,hold_rowtwo_controls,
                hold_rowthree_controls);

    }

    private void constructWeightPlattFIPViewUpdatingControls(){

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
        hold_rowtwo_controls_update.getChildren().addAll(this.update_product,this.update_weightedFIP_value);

        HBox hold_rowthree_controls_update = new HBox();
        hold_rowthree_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_update.setSpacing(5);
        hold_rowthree_controls_update.getChildren().addAll(this.update_submit_button,this.update_clear_button);

        main_holder_controler_updating_section.getChildren().addAll(info_hbox_update,hold_rowone_controls_update,hold_rowtwo_controls_update,
                hold_rowthree_controls_update);
    }

    public WeightPlattFIP getWeightPlattFIPDatatobeAdded(double exchangerateValue, int exchangerate_id, double FIPValue, int FIP_id,
                                                         double waaValue, int waa_id){

        WeightPlattFIP weightPlattFIP = null;
        int temp_product_id=0;
        double computed_weightPlattFIP = (FIPValue * exchangerateValue * waaValue)/1000;
        if(this.add_day.getValue() !=null && this.add_date.getValue() !=null && this.add_month.getValue() !=null &&
                this.add_year.getValue() !=null && this.add_weightedFIP_value.getText() !=null && this.add_exchangerate_month !=null
                && this.selected_product != null) {

            if(this.selected_product.getValue().toString() =="Petroleum"){

                temp_product_id=1;

            }else if(this.selected_product.getValue().toString() =="Diesel"){
                temp_product_id=3;

            }else if(this.selected_product.getValue().toString() =="Kerosene"){
                temp_product_id=2;
            }
            weightPlattFIP = new WeightPlattFIP(1,temp_product_id,this.add_day.getValue().toString(),
                    Integer.parseInt(this.add_date.getValue().toString()), this.add_month.getValue().toString(),
                    Integer.parseInt(this.add_year.getValue().toString()),computed_weightPlattFIP,exchangerate_id,
                    waa_id,FIP_id);

        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return weightPlattFIP;
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
        this.add_FIP_month.setItems(null);
        this.add_weighted_actual_conversion_month.setItems(null);
        this.selected_product.setItems(null);


        this.add_day.setItems(day_value);
        this.add_date.setItems(date_value);
        this.add_month.setItems(month_value);
        this.add_year.setItems(year_value);
        this.add_exchangerate_month.setItems(month_value);
        this.add_FIP_month.setItems(month_value);
        this.add_weighted_actual_conversion_month.setItems(month_value);
        this.selected_product.setItems(product_value);

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

    public String getSelectedProduct(){
        return this.selected_product.getValue().toString();
    }

    public String getSelectedFIPMonth(){
        return this.add_FIP_month.getValue().toString();
    }

    public String getSelectedWAAMonth(){
        return this.add_weighted_actual_conversion_month.getValue().toString();
    }

    public void setWeightPlattFIPTableViewData(ObservableList<WeightPlattFIP> weightPlattFIP){
        this.weightedFIP_view_tableview.setItems(weightPlattFIP);
    }
}
