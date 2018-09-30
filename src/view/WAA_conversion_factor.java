package view;


import Static.WAAConversionFactor;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Model;

import java.util.ArrayList;

public class WAA_conversion_factor extends VBox {

    /*ScrollPane For Holding the All Content*/
    private ScrollPane WAA_conversion_factor_scrollpane;

    /*Table View Properties*/
    private TableView<WAAConversionFactor> waa_conversion_factor_tableview;

    /*Charts Variables*/
    private PieChart actual_product_volume ;
    private LineChart<String,Number> waa_conversion_factor_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;

    /*Input Controls for Adding Widget*/
    private ComboBox add_day_waa;
    private ComboBox add_date_waa;
    private ComboBox add_month_waa;
    private ComboBox add_year_waa;
    private TextField add_waa_actual_product_weight;
    private TextField add_waa_product_density;
    private Button smallVesselPetroleum;
    private Button bigVesselPetroleum;
    private Button add_submit_button_waa;
    private Button add_clear_button_waa;

    /*Input Controls for Updating Widget*/
    private ComboBox update_day_waa;
    private ComboBox update_date_waa;
    private ComboBox update_month_waa;
    private ComboBox update_year_waa;
    private TextField update_waa_actual_product_weight;
    private TextField update_waa_product_density;
    private Button update_submit_button_waa;
    private Button update_clear_button_waa;

    /*Input Controls Diesel Widget*/
    private ComboBox add_day_waa_diesel;
    private ComboBox add_date_waa_diesel;
    private ComboBox add_month_waa_diesel;
    private ComboBox add_year_waa_diesel;
    private TextField add_waa_actual_product_weight_diesel;
    private TextField add_waa_product_density_diesel;
    private Button smallVesselDiesel;
    private Button bigVesselDiesel;
    private Button add_submit_button_waa_diesel;
    private Button add_clear_button_waa_diesel;

    /*Input Controls kerosene Widget*/
    private ComboBox add_day_waa_kerosene;
    private ComboBox add_date_waa_kerosene;
    private ComboBox add_month_waa_kerosene;
    private ComboBox add_year_waa_kerosene;
    private TextField add_waa_actual_product_weight_kerosene;
    private TextField add_waa_product_density_kerosene;
    private Button smallVesselkerosene;
    private Button bigVesselkerosene;
    private Button add_submit_button_waa_kerosene;
    private Button add_clear_button_waa_kerosene;

    //TODO Testing
    private ArrayList bigVesselData_petroleum_volume;
    private ArrayList bigVesselData_petroleum_desity;
    private ArrayList smallVesselData_petroleum_volume;
    private ArrayList smallVesselData_petroleum_density;
    private ObservableList<TextField> petroleumBigVesselDensity;
    private ObservableList<TextField> petroleumBigVesselVolume;
    private ObservableList<TextField> petroleumSmallVesselDensity;
    private ObservableList<TextField> petroleumSmallVesselVolume;

    private ObservableList<TextField> dieselBigVesselDensity;
    private ObservableList<TextField> dieselBigVesselVolume;
    private ObservableList<TextField> dieselSmallVesselDensity;
    private ObservableList<TextField> dieselSmallVesselVolume;

    private ObservableList<TextField> keroseneBigVesselDensity;
    private ObservableList<TextField> keroseneBigVesselVolume;
    private ObservableList<TextField> keroseneSmallVesselDensity;
    private ObservableList<TextField> keroseneSmallVesselVolume;

    //TODO End Testing
    /*Main Container Box*/
    private VBox main_content_waa_conversion_factor;

    /*Heading Section*/
    private HBox piechart_heading_section;
    private HBox linechart_heading_section;
    private HBox conversion_factor_table_heading_section;
    private HBox adding_wiget_heading_section_waa;
    private HBox adding_wiget_heading_section_waa_diesel;
    private HBox adding_wiget_heading_section_waa_kerosene;
    private HBox updating_wiget_heading_section_waa;

    /*Holder adding Controls*/
    VBox main_holder_controller_adding_section_waa;
    VBox main_holder_controller_adding_section_waa_diesel;
    VBox main_holder_controller_adding_section_waa_kerosene;
    VBox main_holder_controller_updating_section_waa;
    VBox smallVesselVbox;
    VBox bigVesselVbox;
    VBox smallVesselVboxDiesel;
    VBox bigVesselVboxDiesel;
    VBox smallVesselVboxKerosene;
    VBox bigVesselVboxKerosene;
    public WAA_conversion_factor(){

        /*The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /*TableView Properties*/
        this.waa_conversion_factor_tableview = new TableView<>();
        this.waa_conversion_factor_tableview.setStyle("-fx-background-color: #eeeeee;");


        /*For Charts Properties*/
        this.waa_conversion_factor_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();

        /*Add Properties*/

        this.add_day_waa = new ComboBox();
        this.add_day_waa.setPromptText("Select Day");

        this.add_date_waa = new ComboBox();
        this.add_date_waa.setPromptText("Select Date");

        this.add_month_waa = new ComboBox();
        this.add_month_waa.setPromptText("Select Month");

        this.add_year_waa = new ComboBox();
        this.add_year_waa.setPromptText("Select Year");

        this.add_waa_actual_product_weight = new TextField();
        this.add_waa_actual_product_weight.setPromptText("Vessel Volume");

        this.add_waa_product_density = new TextField();
        this.add_waa_product_density.setPromptText("Vessel Density");

        this.smallVesselPetroleum = new Button("Add Small Vessel");
        this.bigVesselPetroleum = new Button("Add Big Vessel");

        this.add_submit_button_waa = new Button("Add");
        this.add_clear_button_waa = new Button("Clear");

        /*Adding Diesel Controls */
        this.add_day_waa_diesel = new ComboBox();
        this.add_day_waa_diesel.setPromptText("Select Day");

        this.add_date_waa_diesel = new ComboBox();
        this.add_date_waa_diesel.setPromptText("Select Date");

        this.add_month_waa_diesel = new ComboBox();
        this.add_month_waa_diesel.setPromptText("Select Month");

        this.add_year_waa_diesel = new ComboBox();
        this.add_year_waa_diesel.setPromptText("Select Year");

        this.add_waa_actual_product_weight_diesel = new TextField();
        this.add_waa_actual_product_weight_diesel.setPromptText("Vessel Volume");

        this.add_waa_product_density_diesel = new TextField();
        this.add_waa_product_density_diesel.setPromptText("Vessel Density");

        this.smallVesselDiesel = new Button("Add Small Vessel");
        this.bigVesselDiesel = new Button("Add Big Vessel");

        this.add_submit_button_waa_diesel = new Button("Add");
        this.add_clear_button_waa_diesel = new Button("Clear");

         /*Adding Kerosene Controls */
        this.add_day_waa_kerosene = new ComboBox();
        this.add_day_waa_kerosene.setPromptText("Select Day");

        this.add_date_waa_kerosene = new ComboBox();
        this.add_date_waa_kerosene.setPromptText("Select Date");

        this.add_month_waa_kerosene = new ComboBox();
        this.add_month_waa_kerosene.setPromptText("Select Month");

        this.add_year_waa_kerosene = new ComboBox();
        this.add_year_waa_kerosene.setPromptText("Select Year");

        this.add_waa_actual_product_weight_kerosene = new TextField();
        this.add_waa_actual_product_weight_kerosene.setPromptText("Vessel Volume");

        this.add_waa_product_density_kerosene = new TextField();
        this.add_waa_product_density_kerosene.setPromptText("Vessel Density");

        this.smallVesselkerosene = new Button("Add Small Vessel");
        this.bigVesselkerosene = new Button("Add Big Vessel");

        this.add_submit_button_waa_kerosene = new Button("Add");
        this.add_clear_button_waa_kerosene = new Button("Clear");

		/*Update Properties*/

        this.update_day_waa = new ComboBox();
        this.update_day_waa.setPromptText("Select Day");

        this.update_date_waa = new ComboBox();
        this.update_date_waa.setPromptText("Select Date");

        this.update_month_waa = new ComboBox();
        this.update_month_waa.setPromptText("Select Month");

        this.update_year_waa = new ComboBox();
        this.update_year_waa.setPromptText("Select Year");

        this.update_waa_actual_product_weight = new TextField();
        this.update_waa_actual_product_weight.setPromptText("Product Density");

        this.update_waa_product_density = new TextField();
        this.update_waa_product_density.setPromptText("Product Density");

        this.update_submit_button_waa = new Button("Update");

        this.update_clear_button_waa = new Button("Clear");

        /*Adding and Updating Controllers Containers Properties*/
        this.main_holder_controller_adding_section_waa = new VBox();
        this.main_holder_controller_adding_section_waa.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controller_adding_section_waa.setSpacing(5);

        this.main_holder_controller_adding_section_waa_diesel = new VBox();
        this.main_holder_controller_adding_section_waa_diesel.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controller_adding_section_waa_diesel.setSpacing(5);

        this.main_holder_controller_adding_section_waa_kerosene = new VBox();
        this.main_holder_controller_adding_section_waa_kerosene.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controller_adding_section_waa_kerosene.setSpacing(5);

        this.main_holder_controller_updating_section_waa = new VBox();
        this.main_holder_controller_updating_section_waa.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controller_updating_section_waa.setSpacing(5);

        this.smallVesselVbox = new VBox();
        this.smallVesselVbox.setAlignment(Pos.CENTER_LEFT);
        this.smallVesselVbox.setSpacing(5);

        this.bigVesselVbox = new VBox();
        this.bigVesselVbox.setAlignment(Pos.CENTER_LEFT);
        this.bigVesselVbox.setSpacing(5);

        this.smallVesselVboxDiesel = new VBox();
        this.smallVesselVboxDiesel.setAlignment(Pos.CENTER_LEFT);
        this.smallVesselVboxDiesel.setSpacing(5);

        this.smallVesselVboxKerosene = new VBox();
        this.smallVesselVboxKerosene.setAlignment(Pos.CENTER_LEFT);
        this.smallVesselVboxKerosene.setSpacing(5);

        this.bigVesselVboxDiesel = new VBox();
        this.bigVesselVboxDiesel.setAlignment(Pos.CENTER_LEFT);
        this.bigVesselVboxDiesel.setSpacing(5);

        this.bigVesselVboxKerosene = new VBox();
        this.bigVesselVboxKerosene.setAlignment(Pos.CENTER_LEFT);
        this.bigVesselVboxKerosene.setSpacing(5);

        this.bigVesselData_petroleum_volume = new ArrayList();
        this.bigVesselData_petroleum_desity = new ArrayList();
        this.bigVesselData_petroleum_volume = new ArrayList();
        this.smallVesselData_petroleum_density = new ArrayList();

        petroleumSmallVesselVolume = FXCollections.observableArrayList();
        petroleumSmallVesselDensity = FXCollections.observableArrayList();
        petroleumBigVesselDensity = FXCollections.observableArrayList();
        petroleumBigVesselVolume = FXCollections.observableArrayList();

        dieselSmallVesselVolume = FXCollections.observableArrayList();
        dieselSmallVesselDensity = FXCollections.observableArrayList();
        dieselBigVesselDensity = FXCollections.observableArrayList();
        dieselBigVesselVolume = FXCollections.observableArrayList();

        keroseneSmallVesselVolume = FXCollections.observableArrayList();
        keroseneSmallVesselDensity = FXCollections.observableArrayList();
        keroseneBigVesselDensity = FXCollections.observableArrayList();
        keroseneBigVesselVolume = FXCollections.observableArrayList();

        /*Call the Method to Populate Controls and Data*/
        construct_actual_weight_volume_piechart();
        construct_actual_conversion_factor();
        construct_waa_conversion_factor_TableView();
        construct_waa_conversion_factor_addingControls();
        populateComboBoxes();
        construct_waa_conversion_factor_updatingControls();
        construct_waa_conversion_factor_addingControlsDiesel();
        construct_waa_conversion_factor_addingControlsKerosene();
         /*End Call the Method to Populate Controls and Data*/


        /*Main Container Box Properties*/
        main_content_waa_conversion_factor = new VBox();
        this.main_content_waa_conversion_factor.setAlignment(Pos.TOP_CENTER);
        this.main_content_waa_conversion_factor.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_waa_conversion_factor.setPadding(new Insets(5,5,5,5));
        this.main_content_waa_conversion_factor.setSpacing(10);
        this.main_content_waa_conversion_factor.getChildren().addAll(this.piechart_heading_section,
                this.actual_product_volume,this.linechart_heading_section,this.waa_conversion_factor_linechart,
                this.conversion_factor_table_heading_section,this.waa_conversion_factor_tableview,
                this.adding_wiget_heading_section_waa,this.main_holder_controller_adding_section_waa,
                this.adding_wiget_heading_section_waa_diesel,this.main_holder_controller_adding_section_waa_diesel,
                this.adding_wiget_heading_section_waa_kerosene,this.main_holder_controller_adding_section_waa_kerosene);


        /*Scrollpane Properties*/
        this.WAA_conversion_factor_scrollpane =new ScrollPane();
        this.WAA_conversion_factor_scrollpane.setContent(this.main_content_waa_conversion_factor);
        this.WAA_conversion_factor_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.WAA_conversion_factor_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.WAA_conversion_factor_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(WAA_conversion_factor_scrollpane);
    }

    private void construct_actual_weight_volume_piechart(){
        /*Section Setting*/
        this.piechart_heading_section = new HBox();
        this.piechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.piechart_heading_section.setMinWidth(700);
        this.piechart_heading_section.setMinHeight(27);
        this.piechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_actual_volume = new Label("Pie CHart Showing Volume or Weight of Imported Oil");
        lbl_chart_section_actual_volume.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.piechart_heading_section.getChildren().add(lbl_chart_section_actual_volume);

        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(

                new PieChart.Data("Petroleum",750),
                new PieChart.Data("Kerosene",500),
                new PieChart.Data("Diesel",1000));

        this.actual_product_volume= new PieChart(piechartData);
        this.actual_product_volume.setTitle("Imported Oil");
    }

    private void construct_actual_conversion_factor(){

        /*Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_conversion_factor = new Label("Line Chart Showing Monthly Weight Actual Conversion Factor");
        lbl_chart_section_conversion_factor.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_conversion_factor);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Conversion Factor");

        this.waa_conversion_factor_linechart.setTitle("Weighted Actual Conversion Factor");

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

        int m[] = {345,33,44,666,777,77,22,22,456,333,222,1444};

        /*Adding the Chart Animations */
        Timeline chart_timeline = new Timeline();
        chart_timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                actionEvent -> {
                    for (XYChart.Series<String, Number> series_temp : waa_conversion_factor_linechart.getData()) {
                        int index = 0;
                        for (XYChart.Data<String, Number> data : series_temp.getData()) {
                            data.setYValue(m[index]);
                            index++;
                        }
                    }
                }));
        chart_timeline.setCycleCount(12);
        chart_timeline.play();
        /*End Adding the Chart Animations */


        this.waa_conversion_factor_linechart.getData().add(series);
    }

    private void construct_waa_conversion_factor_TableView(){
        /*Section Setting*/
        this.conversion_factor_table_heading_section = new HBox();
        this.conversion_factor_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.conversion_factor_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.conversion_factor_table_heading_section.setMinWidth(700);
        this.conversion_factor_table_heading_section.setMinHeight(27);
        this.conversion_factor_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_conversion_factor_table_section = new Label("Weighted Conversion Factor Information Table");
        lbl_conversion_factor_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.conversion_factor_table_heading_section.getChildren().add(lbl_conversion_factor_table_section);

        /*Creating the TableView Columns*/
        TableColumn identity_column_waa = new TableColumn("Identity");
        identity_column_waa.setMinWidth(100);
        identity_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");


        /*Creating the TableView Columns*/
        TableColumn product_column_waa = new TableColumn("Product");
        product_column_waa.setMinWidth(100);
        product_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn date_column_waa = new TableColumn("Date");
        date_column_waa.setMinWidth(90);
        date_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn day_column_waa = new TableColumn("Day");
        day_column_waa.setMinWidth(100);
        day_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn month_column_waa = new TableColumn("Month");
        month_column_waa.setMinWidth(100);
        month_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn year_column_waa = new TableColumn("Year");
        year_column_waa.setMinWidth(90);
        year_column_waa.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn waa_conversion_factor_value_column = new TableColumn("Conversion Factor");
        waa_conversion_factor_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        waa_conversion_factor_value_column.setMinWidth(120);

            /*Dummy Data*/
        identity_column_waa.setCellValueFactory(new PropertyValueFactory<WAA_conversion_factor,Integer>("waac_identity"));
        product_column_waa.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,String>("waac_product"));
        date_column_waa.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,Integer>("waac_date"));
        day_column_waa.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,String>("waac_day"));
        month_column_waa.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,String>("waac_month"));
        year_column_waa.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,Integer>("waac_year"));
        waa_conversion_factor_value_column.setCellValueFactory(new PropertyValueFactory<WAAConversionFactor,Double>("waac_value"));



        /*Setting the Columns Properties*/

        this.waa_conversion_factor_tableview.getColumns().addAll(identity_column_waa,product_column_waa,day_column_waa,date_column_waa,month_column_waa,year_column_waa,waa_conversion_factor_value_column);

        Model model = new Model();
        this.waa_conversion_factor_tableview.setItems(model.getWAAData());
        /*End TableView Columns*/

    }

    private void construct_waa_conversion_factor_addingControls(){
         /*Section Setting*/
        this.adding_wiget_heading_section_waa = new HBox();
        this.adding_wiget_heading_section_waa.setStyle("-fx-background-color: #085394;");
        this.adding_wiget_heading_section_waa.setPadding(new Insets(5,0,5,0));
        this.adding_wiget_heading_section_waa.setMinWidth(700);
        this.adding_wiget_heading_section_waa.setMinHeight(27);
        this.adding_wiget_heading_section_waa.setAlignment(Pos.CENTER);
        Label lbl_adding_section_waa = new Label("Add Petroleum Volume nad Density Data for Big Vessel and Small Vessel");
        lbl_adding_section_waa.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.adding_wiget_heading_section_waa.getChildren().add(lbl_adding_section_waa);

        HBox info_hbox_waa = new HBox();
        info_hbox_waa.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image_waa = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_waa = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_waa.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_waa.setSpacing(2);
        info_hbox_waa.getChildren().addAll(info_image_waa,lbl_info_waa);

        HBox hold_rowone_controls_waa = new HBox();
        hold_rowone_controls_waa.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_waa.setSpacing(5);
        hold_rowone_controls_waa.getChildren().addAll(this.add_day_waa,this.add_date_waa,this.add_month_waa,
                this.add_year_waa);

        HBox hold_rowtwo_controls_waa = new HBox();
        hold_rowtwo_controls_waa.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_waa.setSpacing(5);
        hold_rowtwo_controls_waa.getChildren().addAll(this.smallVesselPetroleum,this.bigVesselPetroleum);

        HBox hold_rowthree_controls_waa = new HBox();
        hold_rowthree_controls_waa.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_waa.setSpacing(5);
        hold_rowthree_controls_waa.getChildren().addAll(this.add_submit_button_waa,this.add_clear_button_waa);

        main_holder_controller_adding_section_waa.getChildren().addAll(info_hbox_waa,hold_rowone_controls_waa,this.smallVesselPetroleum,this.smallVesselVbox,this.bigVesselPetroleum,this.bigVesselVbox,hold_rowthree_controls_waa);
    }
    private void construct_waa_conversion_factor_updatingControls(){
         /*Section Setting*/
        this.updating_wiget_heading_section_waa = new HBox();
        this.updating_wiget_heading_section_waa.setStyle("-fx-background-color: #085394;");
        this.updating_wiget_heading_section_waa.setPadding(new Insets(5,0,5,0));
        this.updating_wiget_heading_section_waa.setMinWidth(700);
        this.updating_wiget_heading_section_waa.setMinHeight(27);
        this.updating_wiget_heading_section_waa.setAlignment(Pos.CENTER);
        Label lbl_updating_section_waa = new Label("Update Weighted Actual Conversion Factor Data");
        lbl_updating_section_waa.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.updating_wiget_heading_section_waa.getChildren().add(lbl_updating_section_waa);

        HBox updating_info_hbox_waa = new HBox();
        updating_info_hbox_waa.setAlignment(Pos.CENTER_LEFT);
        ImageView updating_info_image_waa = new ImageView(new Image("/resources/images/info_image.png"));
        Label updating_lbl_info_waa = new Label("For auto-filled value Make sure you computer date set correctly");
        updating_lbl_info_waa.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        updating_info_hbox_waa.setSpacing(2);
        updating_info_hbox_waa.getChildren().addAll(updating_info_image_waa,updating_lbl_info_waa);

        HBox updating_hold_rowone_controls_waa = new HBox();
        updating_hold_rowone_controls_waa.setAlignment(Pos.CENTER_LEFT);
        updating_hold_rowone_controls_waa.setSpacing(5);
        updating_hold_rowone_controls_waa.getChildren().addAll(this.update_day_waa,this.update_date_waa,
                this.update_month_waa,this.update_year_waa);

        HBox updating_hold_rowtwo_controls_waa = new HBox();
        updating_hold_rowtwo_controls_waa.setAlignment(Pos.CENTER_LEFT);
        updating_hold_rowtwo_controls_waa.setSpacing(5);
        updating_hold_rowtwo_controls_waa.getChildren().addAll(this.update_waa_actual_product_weight,
                update_waa_product_density);

        HBox updating_hold_rowthree_controls_waa = new HBox();
        updating_hold_rowthree_controls_waa.setAlignment(Pos.CENTER_LEFT);
        updating_hold_rowthree_controls_waa.setSpacing(5);
        updating_hold_rowthree_controls_waa.getChildren().addAll(this.update_submit_button_waa,
                this.update_clear_button_waa);

        main_holder_controller_updating_section_waa.getChildren().addAll(updating_info_hbox_waa,
                updating_hold_rowone_controls_waa,updating_hold_rowtwo_controls_waa,updating_hold_rowthree_controls_waa);

    }

    /*todo Petroleum Product*/
    public void addSmallVesseleDataPetroleum(){

        TextField vessel_volume = new TextField();
        vessel_volume.setPromptText("Vessel Volume");

        TextField vessel_density = new TextField();
        vessel_density.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume,vessel_density);

        this.petroleumSmallVesselVolume.add(vessel_volume);
        this.petroleumSmallVesselDensity.add(vessel_density);
        this.smallVesselVbox.getChildren().add(hold_rowtwo_controls);
    }
    public void addBigVessselDataPetroleum(){
        TextField vessel_volume = new TextField();
        vessel_volume.setPromptText("Vessel Volume");

        TextField vessel_density = new TextField();
        vessel_density.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume,vessel_density);

        this.petroleumBigVesselVolume.add(vessel_volume);
        this.petroleumBigVesselDensity.add(vessel_density);
        this.bigVesselVbox.getChildren().add(hold_rowtwo_controls);

    }

    public void addSmallVesselButtonPetroleum(EventHandler eventhandler){
        this.smallVesselPetroleum.setOnAction(eventhandler);
    }

    public void addBigVesselButtonPetroleum(EventHandler eventhandler){
        this.bigVesselPetroleum.setOnAction(eventhandler);
    }

    public void addSubmitButtonEventPetroleum(EventHandler eventhandler){
        this.add_submit_button_waa.setOnAction(eventhandler);
    }
    public double getSmallVesselTotalVolumePetroleum(){
        double temp_volume= 0;
        for(int index =0 ; index < this.petroleumSmallVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( petroleumSmallVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }

    public double getBigVesselTotalVolumePetroleum(){
        double temp_volume= 0;
        for(int index =0 ; index < this.petroleumBigVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( petroleumBigVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }
    public double getBigVesselVolumeDensityPetroleum(){
        double temp_volume_x_density = 0;
        for(int index =0 ; index < this.petroleumBigVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( petroleumBigVesselVolume.get(index).getText())) * (Double.parseDouble(petroleumBigVesselDensity.get(index).getText()));
        }
        return  temp_volume_x_density;
    }

    public double getSmallVesselVolumeDensityPetroleum(){
        double temp_volume_x_density = 0;

        for(int index =0 ; index < this.petroleumSmallVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( petroleumSmallVesselVolume.get(index).getText())) * (Double.parseDouble(petroleumSmallVesselDensity.get(index).getText()));
        }

        return  temp_volume_x_density;
    }

    public WAAConversionFactor getDataToBeAddedPetroleum(){

        WAAConversionFactor waaConversionFactor = null;
        if(this.add_day_waa.getValue() !=null && this.add_date_waa.getValue() !=null && this.add_month_waa.getValue() !=null && this.add_year_waa.getValue()!= null) {
            waaConversionFactor = new WAAConversionFactor (1,"1",this.add_day_waa.getValue().toString(),
                    Integer.parseInt(this.add_date_waa.getValue().toString()),
                    this.add_month_waa.getValue().toString(),
                    Integer.parseInt(this.add_year_waa.getValue().toString()),getComputedWAAFactorPetroleum());

        }else{
            System.out.println("You Must Fill All the Filled");
        }

        return waaConversionFactor;
    }
    public double getComputedWAAFactorPetroleum(){

        double computed_waa_factor;

        computed_waa_factor =  (getBigVesselVolumeDensityPetroleum() + getSmallVesselVolumeDensityPetroleum())/(getBigVesselTotalVolumePetroleum() + getSmallVesselTotalVolumePetroleum());

        return computed_waa_factor;
    }

    /*todo Diesel Product*/
    public void addSmallVesseleDataDiesel(){

        TextField vessel_volume_diesel = new TextField();
        vessel_volume_diesel.setPromptText("Vessel Volume");

        TextField vessel_density_diesel = new TextField();
        vessel_density_diesel.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume_diesel,vessel_density_diesel);

        this.dieselSmallVesselVolume.add(vessel_volume_diesel);
        this.dieselSmallVesselDensity.add(vessel_density_diesel);
        this.smallVesselVboxDiesel.getChildren().add(hold_rowtwo_controls);
    }
    public void addBigVessselDataDiesel(){
        TextField vessel_volume_diesel = new TextField();
        vessel_volume_diesel.setPromptText("Vessel Volume");

        TextField vessel_density_diesel = new TextField();
        vessel_density_diesel.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume_diesel,vessel_density_diesel);

        this.dieselBigVesselVolume.add(vessel_volume_diesel);
        this.dieselBigVesselDensity.add(vessel_density_diesel);
        this.bigVesselVboxDiesel.getChildren().add(hold_rowtwo_controls);

    }

    public void addSmallVesselButtonDiesel(EventHandler eventhandler){
        this.smallVesselDiesel.setOnAction(eventhandler);
    }
    public void addBigVesselButtonDiesel(EventHandler eventhandler){

        this.bigVesselDiesel.setOnAction(eventhandler);
    }
    public void addSubmitButtonEventDiesel(EventHandler eventhandler){
        this.add_submit_button_waa_diesel.setOnAction(eventhandler);
    }

    public double getSmallVesselTotalVolumeDiesel(){
        double temp_volume= 0;
        for(int index =0 ; index < this.dieselSmallVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( dieselSmallVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }
    public double getBigVesselTotalVolumeDiesel(){
        double temp_volume= 0;
        for(int index =0 ; index < this.dieselBigVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( dieselBigVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }
    public double getBigVesselVolumeDensityDiesel(){
        double temp_volume_x_density = 0;
        for(int index =0 ; index < this.dieselBigVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( dieselBigVesselVolume.get(index).getText())) * (Double.parseDouble(dieselBigVesselDensity.get(index).getText()));
        }
        return  temp_volume_x_density;
    }
    public double getSmallVesselVolumeDensityDiesel(){
        double temp_volume_x_density = 0;

        for(int index =0 ; index < this.dieselSmallVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( dieselSmallVesselVolume.get(index).getText())) * (Double.parseDouble(dieselSmallVesselDensity.get(index).getText()));
        }

        return  temp_volume_x_density;
    }
    public WAAConversionFactor getDataToBeAddedDiesel(){

        WAAConversionFactor waaConversionFactor = null;
        if(this.add_day_waa_diesel.getValue() !=null && this.add_date_waa_diesel.getValue() !=null && this.add_month_waa_diesel.getValue() !=null && this.add_year_waa_diesel.getValue()!= null) {
            waaConversionFactor = new WAAConversionFactor (1,"3",this.add_day_waa_diesel.getValue().toString(),
                    Integer.parseInt(this.add_date_waa_diesel.getValue().toString()),
                    this.add_month_waa_diesel.getValue().toString(),
                    Integer.parseInt(this.add_year_waa_diesel.getValue().toString()),getComputedWAAFactorDiesel());

        }else{
            System.out.println("You Must Fill All the Filled");
        }

        return waaConversionFactor;
    }
    public double getComputedWAAFactorDiesel(){

        double computed_waa_factor;

        computed_waa_factor =  (getBigVesselVolumeDensityDiesel() + getSmallVesselVolumeDensityDiesel())/(getBigVesselTotalVolumeDiesel() + getSmallVesselTotalVolumeDiesel());

        return computed_waa_factor;
    }
    private void construct_waa_conversion_factor_addingControlsDiesel(){

         /*Section Setting*/
        this.adding_wiget_heading_section_waa_diesel = new HBox();
        this.adding_wiget_heading_section_waa_diesel.setStyle("-fx-background-color: #085394;");
        this.adding_wiget_heading_section_waa_diesel.setPadding(new Insets(5,0,5,0));
        this.adding_wiget_heading_section_waa_diesel.setMinWidth(700);
        this.adding_wiget_heading_section_waa_diesel.setMinHeight(27);
        this.adding_wiget_heading_section_waa_diesel.setAlignment(Pos.CENTER);
        Label lbl_adding_section_waa_diesel = new Label("Add Diesel Volume nad Density Data for Big Vessel and Small Vessel");
        lbl_adding_section_waa_diesel.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.adding_wiget_heading_section_waa_diesel.getChildren().add(lbl_adding_section_waa_diesel);

        HBox info_hbox_waa_diesel = new HBox();
        info_hbox_waa_diesel.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image_waa_diesel = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_waa_diesel = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_waa_diesel.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_waa_diesel.setSpacing(2);
        info_hbox_waa_diesel.getChildren().addAll(info_image_waa_diesel,lbl_info_waa_diesel);

        HBox hold_rowone_controls_waa_diesel = new HBox();
        hold_rowone_controls_waa_diesel.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_waa_diesel.setSpacing(5);
        hold_rowone_controls_waa_diesel.getChildren().addAll(this.add_day_waa_diesel,this.add_date_waa_diesel,this.add_month_waa_diesel,
                this.add_year_waa_diesel);

        HBox hold_rowtwo_controls_waa_diesel = new HBox();
        hold_rowtwo_controls_waa_diesel.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_waa_diesel.setSpacing(5);
        hold_rowtwo_controls_waa_diesel.getChildren().addAll(this.smallVesselDiesel,this.bigVesselDiesel);

        HBox hold_rowthree_controls_waa_diesel = new HBox();
        hold_rowthree_controls_waa_diesel.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_waa_diesel.setSpacing(5);
        hold_rowthree_controls_waa_diesel.getChildren().addAll(this.add_submit_button_waa_diesel,this.add_clear_button_waa_diesel);

        main_holder_controller_adding_section_waa_diesel.getChildren().addAll(info_hbox_waa_diesel,hold_rowone_controls_waa_diesel,this.smallVesselDiesel,this.smallVesselVboxDiesel,
                this.bigVesselDiesel,this.bigVesselVboxDiesel,hold_rowthree_controls_waa_diesel);
    }

    /*todo Kerosene Product*/
    public void addSmallVesseleDataKerosene(){

        TextField vessel_volume_kerosene = new TextField();
        vessel_volume_kerosene.setPromptText("Vessel Volume");

        TextField vessel_density_kerosene = new TextField();
        vessel_density_kerosene.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume_kerosene,vessel_density_kerosene);

        this.keroseneSmallVesselVolume.add(vessel_volume_kerosene);
        this.keroseneSmallVesselDensity.add(vessel_density_kerosene);
        this.smallVesselVboxKerosene.getChildren().add(hold_rowtwo_controls);
    }
    public void addBigVessselDataKerosene(){
        TextField vessel_volume_kerosene = new TextField();
        vessel_volume_kerosene.setPromptText("Vessel Volume");

        TextField vessel_density_kerosene = new TextField();
        vessel_density_kerosene.setPromptText("Vessel Density");

        HBox hold_rowtwo_controls= new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().addAll(vessel_volume_kerosene,vessel_density_kerosene);

        this.dieselBigVesselVolume.add(vessel_volume_kerosene);
        this.dieselBigVesselDensity.add(vessel_density_kerosene);
        this.bigVesselVboxKerosene.getChildren().add(hold_rowtwo_controls);

    }

    public void addSmallVesselButtonKerosene(EventHandler eventhandler){
        this.smallVesselkerosene.setOnAction(eventhandler);
    }
    public void addBigVesselButtonKerosene(EventHandler eventhandler){

        this.bigVesselkerosene.setOnAction(eventhandler);
    }
    public void addSubmitButtonEventKerosene(EventHandler eventhandler){
        this.add_submit_button_waa_kerosene.setOnAction(eventhandler);
    }

    public double getSmallVesselTotalVolumeKerosene(){
        double temp_volume= 0;
        for(int index =0 ; index < this.keroseneSmallVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( keroseneSmallVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }
    public double getBigVesselTotalVolumeKerosene(){
        double temp_volume= 0;
        for(int index =0 ; index < this.keroseneBigVesselVolume.size(); index++){
            temp_volume += (Double.parseDouble( keroseneBigVesselVolume.get(index).getText()));
        }
        return  temp_volume;
    }
    public double getBigVesselVolumeDensityKerosene(){
        double temp_volume_x_density = 0;
        for(int index =0 ; index < this.keroseneBigVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( keroseneBigVesselVolume.get(index).getText())) * (Double.parseDouble(keroseneBigVesselDensity.get(index).getText()));
        }
        return  temp_volume_x_density;
    }
    public double getSmallVesselVolumeDensityKerosene(){
        double temp_volume_x_density = 0;

        for(int index =0 ; index < this.keroseneSmallVesselVolume.size(); index++){
            temp_volume_x_density += (Double.parseDouble( keroseneSmallVesselVolume.get(index).getText())) * (Double.parseDouble(keroseneSmallVesselDensity.get(index).getText()));
        }

        return  temp_volume_x_density;
    }
    public WAAConversionFactor getDataToBeAddedKerosene(){

        WAAConversionFactor waaConversionFactor = null;
        if(this.add_day_waa_kerosene.getValue() !=null && this.add_date_waa_kerosene.getValue() !=null && this.add_month_waa_kerosene.getValue() !=null && this.add_year_waa_kerosene.getValue()!= null) {
            waaConversionFactor = new WAAConversionFactor (1,"2",this.add_day_waa_kerosene.getValue().toString(),
                    Integer.parseInt(this.add_date_waa_kerosene.getValue().toString()),
                    this.add_month_waa_kerosene.getValue().toString(),
                    Integer.parseInt(this.add_year_waa_kerosene.getValue().toString()),getComputedWAAFactorKerosene());

        }else{
            System.out.println("You Must Fill All the Filled");
        }

        return waaConversionFactor;
    }
    public double getComputedWAAFactorKerosene(){

        double computed_waa_factor;

        computed_waa_factor =  (getBigVesselVolumeDensityKerosene() + getSmallVesselVolumeDensityKerosene())/(getBigVesselTotalVolumeKerosene() + getSmallVesselTotalVolumeKerosene());

        return computed_waa_factor;
    }
    private void construct_waa_conversion_factor_addingControlsKerosene(){

         /*Section Setting*/
        this.adding_wiget_heading_section_waa_kerosene = new HBox();
        this.adding_wiget_heading_section_waa_kerosene.setStyle("-fx-background-color: #085394;");
        this.adding_wiget_heading_section_waa_kerosene.setPadding(new Insets(5,0,5,0));
        this.adding_wiget_heading_section_waa_kerosene.setMinWidth(700);
        this.adding_wiget_heading_section_waa_kerosene.setMinHeight(27);
        this.adding_wiget_heading_section_waa_kerosene.setAlignment(Pos.CENTER);
        Label lbl_adding_section_waa_kerosene = new Label("Add Kerosene Volume nad Density Data for Big Vessel and Small Vessel");
        lbl_adding_section_waa_kerosene.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.adding_wiget_heading_section_waa_kerosene.getChildren().add(lbl_adding_section_waa_kerosene);

        HBox info_hbox_waa_kerosene = new HBox();
        info_hbox_waa_kerosene.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image_waa_kerosene = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_waa_kerosene = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_waa_kerosene.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_waa_kerosene.setSpacing(2);
        info_hbox_waa_kerosene.getChildren().addAll(info_image_waa_kerosene,lbl_info_waa_kerosene);

        HBox hold_rowone_controls_waa_kerosene = new HBox();
        hold_rowone_controls_waa_kerosene.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_waa_kerosene.setSpacing(5);
        hold_rowone_controls_waa_kerosene.getChildren().addAll(this.add_day_waa_kerosene,this.add_date_waa_kerosene,this.add_month_waa_kerosene,
                this.add_year_waa_kerosene);

        HBox hold_rowtwo_controls_waa_kerosene = new HBox();
        hold_rowtwo_controls_waa_kerosene.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_waa_kerosene.setSpacing(5);
        hold_rowtwo_controls_waa_kerosene.getChildren().addAll(this.smallVesselkerosene,this.bigVesselkerosene);

        HBox hold_rowthree_controls_waa_kerosene = new HBox();
        hold_rowthree_controls_waa_kerosene.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_waa_kerosene.setSpacing(5);
        hold_rowthree_controls_waa_kerosene.getChildren().addAll(this.add_submit_button_waa_kerosene,this.add_clear_button_waa_kerosene);

        main_holder_controller_adding_section_waa_kerosene.getChildren().addAll(info_hbox_waa_kerosene,hold_rowone_controls_waa_kerosene,this.smallVesselkerosene,this.smallVesselVboxKerosene,
                this.bigVesselkerosene,this.bigVesselVboxKerosene,hold_rowthree_controls_waa_kerosene);
    }

    /*todo common to all*/
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

        /*For Adding*/
        this.add_day_waa.setItems(null);
        this.add_date_waa.setItems(null);
        this.add_year_waa.setItems(null);

        this.add_day_waa.setItems(day_value);
        this.add_date_waa.setItems(date_value);
        this.add_month_waa.setItems(month_value);
        this.add_year_waa.setItems(year_value);

        /*todo For Adding Diesel*/
        this.add_day_waa_diesel.setItems(null);
        this.add_date_waa_diesel.setItems(null);
        this.add_year_waa_diesel.setItems(null);

        this.add_day_waa_diesel.setItems(day_value);
        this.add_date_waa_diesel.setItems(date_value);
        this.add_month_waa_diesel.setItems(month_value);
        this.add_year_waa_diesel.setItems(year_value);

        /*todo For Adding kerosene*/
        this.add_day_waa_kerosene.setItems(null);
        this.add_date_waa_kerosene.setItems(null);
        this.add_year_waa_kerosene.setItems(null);

        this.add_day_waa_kerosene.setItems(day_value);
        this.add_date_waa_kerosene.setItems(date_value);
        this.add_month_waa_kerosene.setItems(month_value);
        this.add_year_waa_kerosene.setItems(year_value);

        /*todo For Updating*/
        this.update_day_waa.setItems(null);
        this.update_date_waa.setItems(null);
        this.update_year_waa.setItems(null);


        this.update_day_waa.setItems(day_value);
        this.update_date_waa.setItems(date_value);
        this.update_month_waa.setItems(month_value);
        this.update_year_waa.setItems(year_value);
    }

    public void setWAACFTableViewData(ObservableList<WAAConversionFactor> waaConversionFactors){
        this.waa_conversion_factor_tableview.setItems(waaConversionFactors);
    }


}
