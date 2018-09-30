package view;

import Static.CIFCostDaresSalaamStatic;
import Static.ExchangeRate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;

public class CIFCostDaresalaam extends VBox {

    /*ScrollPane For Holding the All Content*/
    protected ScrollPane cif_cost_daresalaam_scrollpane;

    /*Table View Properties*/
    private TableView<CIFCostDaresSalaamStatic> cif_conversion_factor_tableview;

    /*Charts Variables*/
    private LineChart<String,Number> cif_cost_daresalaam_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;


    /*todo Main Container Box*/
    private VBox main_content_cif_cost_daresalaam;
    private HBox adding_wiget_heading_section_cif;

    /*todo Main Holder Controllers*/
    private VBox main_holder_controller_adding_section_cif;
    /*todo Heading Section*/
    private HBox linechart_heading_section;
    private HBox conversion_factor_table_heading_section;

    /*todo adding Controls*/
    private ComboBox<String> cif_add_day;
    private ComboBox<Integer> cif_add_date;
    private ComboBox<String> cif_add_month;
    private ComboBox<Integer> cif_add_year;
    private ComboBox<Integer> WAP_WT_year;
    private ComboBox<String> WAP_WT_month;
    private ComboBox<String> cif_add_product;
    private Button add_cif_button;
    private Button clear_cif_button;

    public CIFCostDaresalaam(){

        /**
         * The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /**
         * TableView Properties*/
        this.cif_conversion_factor_tableview = new TableView<>();
        this.cif_conversion_factor_tableview.setStyle("-fx-background-color: #eeeeee;");

        /**
         * Initializing Holder */
        this.main_holder_controller_adding_section_cif = new VBox();
        this.main_holder_controller_adding_section_cif.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controller_adding_section_cif.setSpacing(5);

        /**
         * For Charts Properties*/
        this.cif_cost_daresalaam_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();


        /**
         * Call the Method to Populate Controls and Data*/
            construct_actual_conversion_factor();
            construct_cif_conversion_factor_TableView();
            construct_cif_adding_controls();
            populateComboBoxes();

        /**
         * Main Container Box Properties*/
        this.main_content_cif_cost_daresalaam = new VBox();
        this.main_content_cif_cost_daresalaam.setAlignment(Pos.TOP_CENTER);
        this.main_content_cif_cost_daresalaam.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_cif_cost_daresalaam.setPadding(new Insets(5,5,5,5));
        this.main_content_cif_cost_daresalaam.setSpacing(10);

        /**
         * temp removed this.linechart_heading_section,this.cif_cost_daresalaam_linechart,*/
        this.main_content_cif_cost_daresalaam.getChildren().addAll(this.conversion_factor_table_heading_section,this.cif_conversion_factor_tableview,this.adding_wiget_heading_section_cif,
                this.main_holder_controller_adding_section_cif);


        /**
         * Scrollpane Properties*/
        this.cif_cost_daresalaam_scrollpane =new ScrollPane();
        this.cif_cost_daresalaam_scrollpane.setContent(this.main_content_cif_cost_daresalaam);
        this.cif_cost_daresalaam_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.cif_cost_daresalaam_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.cif_cost_daresalaam_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /**
         * Adding All Controls to the Main Node VBox*/
        this.getChildren().add(cif_cost_daresalaam_scrollpane);
    }

    private void construct_actual_conversion_factor(){

        /**
         * Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_conversion_factor = new Label("Line Chart Showing CIF cost Dar es Salaam");
        lbl_chart_section_conversion_factor.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_conversion_factor);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("CIF Cost");

        this.cif_cost_daresalaam_linechart.setTitle("CIF Cost Dar es Salaam");

        this.series.setName("Monthly Weighted Actual Conversion Factor");
        this.series.getData().add(new XYChart.Data("Jan",20));
        this.series.getData().add(new XYChart.Data("Feb",200));
        this.series.getData().add(new XYChart.Data("Mar",160));
        this.series.getData().add(new XYChart.Data("Apr",267));
        this.series.getData().add(new XYChart.Data("May",100));
        this.series.getData().add(new XYChart.Data("June",190));
        this.series.getData().add(new XYChart.Data("Jul",225));
        this.series.getData().add(new XYChart.Data("Ags",200));
        this.series.getData().add(new XYChart.Data("Sept",100));
        this.series.getData().add(new XYChart.Data("Oct",178));
        this.series.getData().add(new XYChart.Data("Nov",176));
        this.series.getData().add(new XYChart.Data("Dec",156));
        this.cif_cost_daresalaam_linechart.getData().add(series);

        /**
         * Initializing Adding Controls*/

        this.cif_add_day = new ComboBox();
        this.cif_add_day.setPromptText("Select Day");

        this.cif_add_date = new ComboBox();
        this.cif_add_date.setPromptText("Select Date");

        this.cif_add_month = new ComboBox();
        this.cif_add_month.setPromptText("Select Month");

        this.cif_add_year = new ComboBox();
        this.cif_add_year.setPromptText("Select Year");

        this.WAP_WT_month = new ComboBox();
        this.WAP_WT_month.setPromptText("Select WAP and WT Month");

        this.WAP_WT_year = new ComboBox();
        this.WAP_WT_year.setPromptText("Select WAP and WT Year");

        this.add_cif_button = new Button("Add");
        this.clear_cif_button = new Button("Clear");

        this.cif_add_product = new ComboBox<>();
        this.cif_add_product.setPromptText("Select Product");
    }

    private void construct_cif_conversion_factor_TableView(){
        /**
         * Section Setting*/
        this.conversion_factor_table_heading_section = new HBox();
        this.conversion_factor_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.conversion_factor_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.conversion_factor_table_heading_section.setMinWidth(700);
        this.conversion_factor_table_heading_section.setMinHeight(27);
        this.conversion_factor_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_conversion_factor_table_section = new Label("CIF Cost Dar es Salaam Information Table");
        lbl_conversion_factor_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.conversion_factor_table_heading_section.getChildren().add(lbl_conversion_factor_table_section);

        /**
         * Creating the TableView Columns*/
        TableColumn<CIFCostDaresSalaamStatic, Integer> identity_column_cif = new TableColumn<>("Identity");
        identity_column_cif.setMinWidth(100);
        identity_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, Integer> date_column_cif = new TableColumn<>("Date");
        date_column_cif.setMinWidth(100);
        date_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, String> day_column_cif = new TableColumn<>("Day");
        day_column_cif.setMinWidth(100);
        day_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, String> month_column_cif = new TableColumn<>("Month");
        month_column_cif.setMinWidth(100);
        month_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, Integer> year_column_cif = new TableColumn<>("Year");
        year_column_cif.setMinWidth(100);
        year_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, Integer> weighted_platt_fob_column_cif = new TableColumn<>("WAP FOB");
        weighted_platt_fob_column_cif.setMinWidth(100);
        weighted_platt_fob_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, Integer> weighted_premium_fip_column_cif = new TableColumn<>("WP FIP");
        weighted_premium_fip_column_cif.setMinWidth(100);
        weighted_premium_fip_column_cif.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<CIFCostDaresSalaamStatic, Double> cif_conversion_factor_value_column = new TableColumn<>("CIF Value");
        cif_conversion_factor_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        cif_conversion_factor_value_column.setMinWidth(200);

            /**
             * Dummy Data*/
        identity_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_id"));
        date_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_date"));
        day_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_day"));
        month_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_month"));
        year_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_year"));
        weighted_premium_fip_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_wa_premium_quotation"));
        weighted_platt_fob_column_cif.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_weighted_average_plat_fob"));
        cif_conversion_factor_value_column.setCellValueFactory(new PropertyValueFactory<>("cif_cost_dsm_value"));

        /**
         * Setting the Columns Properties*/

        this.cif_conversion_factor_tableview.getColumns().addAll(identity_column_cif,date_column_cif,day_column_cif,month_column_cif,
                year_column_cif,cif_conversion_factor_value_column);
    }

    private void construct_cif_adding_controls(){

         /*Section Setting*/
        this.adding_wiget_heading_section_cif = new HBox();
        this.adding_wiget_heading_section_cif.setStyle("-fx-background-color: #085394;");
        this.adding_wiget_heading_section_cif.setPadding(new Insets(5,0,5,0));
        this.adding_wiget_heading_section_cif.setMinWidth(700);
        this.adding_wiget_heading_section_cif.setMinHeight(27);
        this.adding_wiget_heading_section_cif.setAlignment(Pos.CENTER);
        Label lbl_adding_section_cif = new Label("Adding CIF Cost in Dar es Salaam");
        lbl_adding_section_cif.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.adding_wiget_heading_section_cif.getChildren().add(lbl_adding_section_cif);

        HBox info_hbox_cif = new HBox();
        info_hbox_cif.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image_cif = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_cif = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_cif.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_cif.setSpacing(2);
        info_hbox_cif.getChildren().addAll(info_image_cif,lbl_info_cif);

        HBox hold_rowone_controls_cif = new HBox();
        hold_rowone_controls_cif.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_cif.setSpacing(5);
        hold_rowone_controls_cif.getChildren().addAll(this.cif_add_day,this.cif_add_date,this.cif_add_month,
                this.cif_add_year);

        HBox hold_rowtwo_controls_cif = new HBox();
        hold_rowtwo_controls_cif.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_cif.setSpacing(5);
        hold_rowtwo_controls_cif.getChildren().addAll(this.WAP_WT_month,this.WAP_WT_year,this.cif_add_product);

        HBox hold_rowthree_controls_cif = new HBox();
        hold_rowthree_controls_cif.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_cif.setSpacing(5);
        hold_rowthree_controls_cif.getChildren().addAll(this.add_cif_button,this.clear_cif_button);

       this.main_holder_controller_adding_section_cif.getChildren().addAll(info_hbox_cif,hold_rowone_controls_cif,hold_rowtwo_controls_cif,hold_rowthree_controls_cif);
    }

    private void populateComboBoxes(){

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Friday",
                "Thursday", "Saturday","Sunday");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","October","November","December");

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);

        ObservableList<String> product_list = FXCollections.observableArrayList("Petroleum","Kerosene","Diesel");

        /**
         * For Adding*/
        this.cif_add_day.setItems(null);
        this.cif_add_date.setItems(null);
        this.cif_add_year.setItems(null);
        this.WAP_WT_month.setItems(null);
        this.WAP_WT_year.setItems(null);
        this.cif_add_product.setItems(null);

        this.cif_add_day.setItems(day_value);
        this.cif_add_date.setItems(date_value);
        this.cif_add_month.setItems(month_value);
        this.cif_add_year.setItems(year_value);
        this.WAP_WT_month.setItems(month_value);
        this.WAP_WT_year.setItems(year_value);
        this.cif_add_product.setItems(product_list);


    }

    public int getSelectedWAP_WT_YearValue(){
        return this.WAP_WT_year.getValue();
    }

    public String getSelectedWAP_WTMonthValue(){
        return this.WAP_WT_month.getValue();
    }

    public String getSelectedProduct(){
        return this.cif_add_product.getValue();
    }

    public CIFCostDaresSalaamStatic getCIFCostDaresSalaamtobeeAdded(double WAPValue, int WAPValueID,
                                                                    double WTValue, int WTValueID){
        CIFCostDaresSalaamStatic cifCostDaresSalaamStatic = null;
        int temp_product_id=0;
        double temp_computed_cif_cost = WAPValue + WTValue;
        if(this.cif_add_day.getValue() !=null && this.cif_add_date.getValue() !=null && this.cif_add_month.getValue() !=null &&
                this.cif_add_year.getValue() !=null && this.WAP_WT_month.getValue().toString()!=null &&
                this.WAP_WT_year.getValue().toString() !=null && this.cif_add_product.getValue().toString() !=null) {

            if(this.cif_add_product.getValue().toString() =="Petroleum"){

                temp_product_id=1;

            }else if(this.cif_add_product.getValue().toString() =="Diesel"){
                temp_product_id=3;

            }else if(this.cif_add_product.getValue().toString() =="Kerosene"){
                temp_product_id=2;
            }
            cifCostDaresSalaamStatic = new CIFCostDaresSalaamStatic(1,temp_product_id,this.cif_add_day.getValue().toString(),
                    Integer.parseInt(this.cif_add_date.getValue().toString()), this.cif_add_month.getValue().toString(),
                    Integer.parseInt(this.cif_add_year.getValue().toString()),temp_computed_cif_cost,WAPValueID,
                    WTValueID);

        }else{
            System.out.println("You Must Fill All the Filled");
        }

        return cifCostDaresSalaamStatic;
    }

    public void addEventListenersSubmitButtonAdd(EventHandler eventHandler){
        this.add_cif_button.setOnMouseClicked(eventHandler);
    }

    public void setCIFCostTableViewData(ObservableList<CIFCostDaresSalaamStatic> cifCostDaresSalaamStatics){
        this.cif_conversion_factor_tableview.setItems(cifCostDaresSalaamStatics);
    }
}
