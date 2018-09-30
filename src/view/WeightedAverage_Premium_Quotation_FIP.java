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

public class WeightedAverage_Premium_Quotation_FIP extends VBox {

    /*ScrollPane For Holding the All Content*/
    protected ScrollPane weightedAverage_Premium_Quotation_FIP_scrollpane;

    /*Table View Properties*/
    private TableView<ExchangeRate> weightedAverage_Premium_Quotation_FIP_tableview;

    /*Charts Variables*/
    private LineChart<String,Number> weightedAverage_Premium_Quotation_FIP_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;


    /*Main Container Box*/
    protected VBox main_content_weightedAverage_Premium_Quotation_FIP;

    /*Heading Section*/
    private HBox linechart_heading_section;
    private HBox weightedAverage_Premium_Quotation_FIP_table_heading_section;


    public WeightedAverage_Premium_Quotation_FIP(){

        /*The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /*TableView Properties*/
        this.weightedAverage_Premium_Quotation_FIP_tableview = new TableView<>();
        this.weightedAverage_Premium_Quotation_FIP_tableview.setStyle("-fx-background-color: #eeeeee;");


        /*For Charts Properties*/
        this.weightedAverage_Premium_Quotation_FIP_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();


        /*Call the Method to Populate Controls and Data*/
        construct_weightedAverage_Premium_Quotation_FIP_graph();
        construct_weightedAverage_Premium_Quotation_FIP_TableView();
         /*End Call the Method to Populate Controls and Data*/


        /*Main Container Box Properties*/
        this.main_content_weightedAverage_Premium_Quotation_FIP = new VBox();
        this.main_content_weightedAverage_Premium_Quotation_FIP.setAlignment(Pos.TOP_CENTER);
        this.main_content_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_weightedAverage_Premium_Quotation_FIP.setPadding(new Insets(5,5,5,5));
        this.main_content_weightedAverage_Premium_Quotation_FIP.setSpacing(10);
        this.main_content_weightedAverage_Premium_Quotation_FIP.getChildren().addAll(this.linechart_heading_section,this.weightedAverage_Premium_Quotation_FIP_linechart,
                this.weightedAverage_Premium_Quotation_FIP_table_heading_section,this.weightedAverage_Premium_Quotation_FIP_tableview);


        /*Scrollpane Properties*/
        this.weightedAverage_Premium_Quotation_FIP_scrollpane =new ScrollPane();
        this.weightedAverage_Premium_Quotation_FIP_scrollpane.setContent(this.main_content_weightedAverage_Premium_Quotation_FIP);
        this.weightedAverage_Premium_Quotation_FIP_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.weightedAverage_Premium_Quotation_FIP_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.weightedAverage_Premium_Quotation_FIP_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(weightedAverage_Premium_Quotation_FIP_scrollpane);
    }


    private void construct_weightedAverage_Premium_Quotation_FIP_graph(){

        /*Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_weightedAverage_Premium_Quotation_FIP = new Label("Line Chart Showing Surveyor's Cost");
        lbl_chart_section_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_weightedAverage_Premium_Quotation_FIP);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Petroleum Marking Cost");

        this.weightedAverage_Premium_Quotation_FIP_linechart.setTitle("Petroleum Marking Cost");

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
        this.weightedAverage_Premium_Quotation_FIP_linechart.getData().add(series);
    }

    private void construct_weightedAverage_Premium_Quotation_FIP_TableView(){
        /*Section Setting*/
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section = new HBox();
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.setMinWidth(700);
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.setMinHeight(27);
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_weightedAverage_Premium_Quotation_FIP_table_section = new Label("Surveyor Cost Information Table");
        lbl_weightedAverage_Premium_Quotation_FIP_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.weightedAverage_Premium_Quotation_FIP_table_heading_section.getChildren().add(lbl_weightedAverage_Premium_Quotation_FIP_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column_weightedAverage_Premium_Quotation_FIP = new TableColumn<>("Identity");
        identity_column_weightedAverage_Premium_Quotation_FIP.setMinWidth(100);
        identity_column_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column_weightedAverage_Premium_Quotation_FIP = new TableColumn<>("Date");
        date_column_weightedAverage_Premium_Quotation_FIP.setMinWidth(100);
        date_column_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column_weightedAverage_Premium_Quotation_FIP = new TableColumn<>("Day");
        day_column_weightedAverage_Premium_Quotation_FIP.setMinWidth(100);
        day_column_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column_weightedAverage_Premium_Quotation_FIP = new TableColumn<>("Month");
        month_column_weightedAverage_Premium_Quotation_FIP.setMinWidth(100);
        month_column_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column_weightedAverage_Premium_Quotation_FIP = new TableColumn<>("Year");
        year_column_weightedAverage_Premium_Quotation_FIP.setMinWidth(100);
        year_column_weightedAverage_Premium_Quotation_FIP.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> weightedAverage_Premium_Quotation_FIP_value_column = new TableColumn<>("surveyor_cost Value");
        weightedAverage_Premium_Quotation_FIP_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        weightedAverage_Premium_Quotation_FIP_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column_weightedAverage_Premium_Quotation_FIP.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column_weightedAverage_Premium_Quotation_FIP.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column_weightedAverage_Premium_Quotation_FIP.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column_weightedAverage_Premium_Quotation_FIP.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column_weightedAverage_Premium_Quotation_FIP.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        weightedAverage_Premium_Quotation_FIP_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        Model model = new Model();
        this.weightedAverage_Premium_Quotation_FIP_tableview.setItems(model.getExchangerateData());

        /*Setting the Columns Properties*/

        this.weightedAverage_Premium_Quotation_FIP_tableview.getColumns().addAll(identity_column_weightedAverage_Premium_Quotation_FIP,date_column_weightedAverage_Premium_Quotation_FIP,
                day_column_weightedAverage_Premium_Quotation_FIP,month_column_weightedAverage_Premium_Quotation_FIP,year_column_weightedAverage_Premium_Quotation_FIP,weightedAverage_Premium_Quotation_FIP_value_column);

        /*End TableView Columns*/

    }

}

