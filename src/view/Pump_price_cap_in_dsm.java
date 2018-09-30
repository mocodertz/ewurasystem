package view;

import Static.ExchangeRate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;

public class Pump_price_cap_in_dsm extends VBox {

    /*ScrollPane For Holding the All Content*/
    protected ScrollPane pump_price_cap_in_dsm_scrollpane;

    /*Table View Properties*/
    private TableView<ExchangeRate> pump_price_cap_in_dsm_tableview;

    /*Charts Variables*/
    private LineChart<String,Number> pump_price_cap_in_dsm_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;


    /*Main Container Box*/
    protected VBox main_content_pump_price_cap_in_dsm;

    /*Heading Section*/
    private HBox linechart_heading_section;
    private HBox pump_price_cap_in_dsm_table_heading_section;


    public Pump_price_cap_in_dsm(){

        /*The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /*TableView Properties*/
        this.pump_price_cap_in_dsm_tableview = new TableView<>();
        this.pump_price_cap_in_dsm_tableview.setStyle("-fx-background-color: #eeeeee;");


        /*For Charts Properties*/
        this.pump_price_cap_in_dsm_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();


        /*Call the Method to Populate Controls and Data*/
        construct_pump_price_cap_in_dsm_graph();
        construct_pump_price_cap_in_dsm_TableView();
         /*End Call the Method to Populate Controls and Data*/


        /*Main Container Box Properties*/
        this.main_content_pump_price_cap_in_dsm = new VBox();
        this.main_content_pump_price_cap_in_dsm.setAlignment(Pos.TOP_CENTER);
        this.main_content_pump_price_cap_in_dsm.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_pump_price_cap_in_dsm.setPadding(new Insets(5,5,5,5));
        this.main_content_pump_price_cap_in_dsm.setSpacing(10);
        this.main_content_pump_price_cap_in_dsm.getChildren().addAll(this.linechart_heading_section,this.pump_price_cap_in_dsm_linechart,
                this.pump_price_cap_in_dsm_table_heading_section,this.pump_price_cap_in_dsm_tableview);


        /*Scrollpane Properties*/
        this.pump_price_cap_in_dsm_scrollpane =new ScrollPane();
        this.pump_price_cap_in_dsm_scrollpane.setContent(this.main_content_pump_price_cap_in_dsm);
        this.pump_price_cap_in_dsm_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.pump_price_cap_in_dsm_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.pump_price_cap_in_dsm_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(pump_price_cap_in_dsm_scrollpane);
    }


    private void construct_pump_price_cap_in_dsm_graph(){

        /*Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_pump_price_cap_in_dsm = new Label("Line Chart Showing Surveyor's Cost");
        lbl_chart_section_pump_price_cap_in_dsm.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_pump_price_cap_in_dsm);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Petroleum Marking Cost");

        this.pump_price_cap_in_dsm_linechart.setTitle("Petroleum Marking Cost");

        this.series.setName("Monthly Petroleum Marking Cost");
        this.series.getData().add(new XYChart.Data("Jan",20));
        this.series.getData().add(new XYChart.Data("Feb",200));
        this.series.getData().add(new XYChart.Data("Mar",160));
        this.series.getData().add(new XYChart.Data("Apr",27));
        this.series.getData().add(new XYChart.Data("May",100));
        this.series.getData().add(new XYChart.Data("June",1390));
        this.series.getData().add(new XYChart.Data("Jul",225));
        this.series.getData().add(new XYChart.Data("Ags",200));
        this.series.getData().add(new XYChart.Data("Sept",100));
        this.series.getData().add(new XYChart.Data("Oct",178));
        this.series.getData().add(new XYChart.Data("Nov",176));
        this.series.getData().add(new XYChart.Data("Dec",156));
        this.pump_price_cap_in_dsm_linechart.getData().add(series);
    }

    private void construct_pump_price_cap_in_dsm_TableView(){
        /*Section Setting*/
        this.pump_price_cap_in_dsm_table_heading_section = new HBox();
        this.pump_price_cap_in_dsm_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.pump_price_cap_in_dsm_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.pump_price_cap_in_dsm_table_heading_section.setMinWidth(700);
        this.pump_price_cap_in_dsm_table_heading_section.setMinHeight(27);
        this.pump_price_cap_in_dsm_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_pump_price_cap_in_dsm_table_section = new Label("Surveyor Cost Information Table");
        lbl_pump_price_cap_in_dsm_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.pump_price_cap_in_dsm_table_heading_section.getChildren().add(lbl_pump_price_cap_in_dsm_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column_pump_price_cap_in_dsm = new TableColumn<>("Identity");
        identity_column_pump_price_cap_in_dsm.setMinWidth(100);
        identity_column_pump_price_cap_in_dsm.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column_pump_price_cap_in_dsm = new TableColumn<>("Date");
        date_column_pump_price_cap_in_dsm.setMinWidth(100);
        date_column_pump_price_cap_in_dsm.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column_pump_price_cap_in_dsm = new TableColumn<>("Day");
        day_column_pump_price_cap_in_dsm.setMinWidth(100);
        day_column_pump_price_cap_in_dsm.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column_pump_price_cap_in_dsm = new TableColumn<>("Month");
        month_column_pump_price_cap_in_dsm.setMinWidth(100);
        month_column_pump_price_cap_in_dsm.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column_pump_price_cap_in_dsm = new TableColumn<>("Year");
        year_column_pump_price_cap_in_dsm.setMinWidth(100);
        year_column_pump_price_cap_in_dsm.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> pump_price_cap_in_dsm_value_column = new TableColumn<>("surveyor_cost Value");
        pump_price_cap_in_dsm_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        pump_price_cap_in_dsm_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column_pump_price_cap_in_dsm.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column_pump_price_cap_in_dsm.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column_pump_price_cap_in_dsm.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column_pump_price_cap_in_dsm.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column_pump_price_cap_in_dsm.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        pump_price_cap_in_dsm_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        Model model = new Model();
        this.pump_price_cap_in_dsm_tableview.setItems(model.getExchangerateData());

        /*Setting the Columns Properties*/

        this.pump_price_cap_in_dsm_tableview.getColumns().addAll(identity_column_pump_price_cap_in_dsm,date_column_pump_price_cap_in_dsm,
                day_column_pump_price_cap_in_dsm,month_column_pump_price_cap_in_dsm,year_column_pump_price_cap_in_dsm,pump_price_cap_in_dsm_value_column);

        /*End TableView Columns*/

    }

}

