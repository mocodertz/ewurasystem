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

public class PetroleumMarkingCost extends VBox {

    /*ScrollPane For Holding the All Content*/
    protected ScrollPane petroleum_marking_cost_scrollpane;

    /*Table View Properties*/
    private TableView<ExchangeRate> petroleum_marking_cost_tableview;

    /*Charts Variables*/
    private LineChart<String,Number> petroleum_marking_cost_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;


    /*Main Container Box*/
    protected VBox main_content_petroleum_marking_cost;

    /*Heading Section*/
    private HBox linechart_heading_section;
    private HBox petroleum_marking_cost_table_heading_section;


    public PetroleumMarkingCost(){

        /*The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /*TableView Properties*/
        this.petroleum_marking_cost_tableview = new TableView<>();
        this.petroleum_marking_cost_tableview.setStyle("-fx-background-color: #eeeeee;");


        /*For Charts Properties*/
        this.petroleum_marking_cost_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();


        /*Call the Method to Populate Controls and Data*/
        construct_petroleum_marking_cost_graph();
        construct_petroleum_marking_cost_TableView();
         /*End Call the Method to Populate Controls and Data*/


        /*Main Container Box Properties*/
        this.main_content_petroleum_marking_cost = new VBox();
        this.main_content_petroleum_marking_cost.setAlignment(Pos.TOP_CENTER);
        this.main_content_petroleum_marking_cost.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_petroleum_marking_cost.setPadding(new Insets(5,5,5,5));
        this.main_content_petroleum_marking_cost.setSpacing(10);
        this.main_content_petroleum_marking_cost.getChildren().addAll(this.linechart_heading_section,this.petroleum_marking_cost_linechart,
                this.petroleum_marking_cost_table_heading_section,this.petroleum_marking_cost_tableview);


        /*Scrollpane Properties*/
        this.petroleum_marking_cost_scrollpane =new ScrollPane();
        this.petroleum_marking_cost_scrollpane.setContent(this.main_content_petroleum_marking_cost);
        this.petroleum_marking_cost_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.petroleum_marking_cost_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.petroleum_marking_cost_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(petroleum_marking_cost_scrollpane);
    }


    private void construct_petroleum_marking_cost_graph(){

        /*Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_petroleum_marking_cost = new Label("Line Chart Showing Surveyor's Cost");
        lbl_chart_section_petroleum_marking_cost.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_petroleum_marking_cost);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Petroleum Marking Cost");

        this.petroleum_marking_cost_linechart.setTitle("Petroleum Marking Cost");

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
        this.petroleum_marking_cost_linechart.getData().add(series);
    }

    private void construct_petroleum_marking_cost_TableView(){
        /*Section Setting*/
        this.petroleum_marking_cost_table_heading_section = new HBox();
        this.petroleum_marking_cost_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.petroleum_marking_cost_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.petroleum_marking_cost_table_heading_section.setMinWidth(700);
        this.petroleum_marking_cost_table_heading_section.setMinHeight(27);
        this.petroleum_marking_cost_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_petroleum_marking_cost_table_section = new Label("Surveyor Cost Information Table");
        lbl_petroleum_marking_cost_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.petroleum_marking_cost_table_heading_section.getChildren().add(lbl_petroleum_marking_cost_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column_petroleum_marking_cost = new TableColumn<>("Identity");
        identity_column_petroleum_marking_cost.setMinWidth(100);
        identity_column_petroleum_marking_cost.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column_petroleum_marking_cost = new TableColumn<>("Date");
        date_column_petroleum_marking_cost.setMinWidth(100);
        date_column_petroleum_marking_cost.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column_petroleum_marking_cost = new TableColumn<>("Day");
        day_column_petroleum_marking_cost.setMinWidth(100);
        day_column_petroleum_marking_cost.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column_petroleum_marking_cost = new TableColumn<>("Month");
        month_column_petroleum_marking_cost.setMinWidth(100);
        month_column_petroleum_marking_cost.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column_petroleum_marking_cost = new TableColumn<>("Year");
        year_column_petroleum_marking_cost.setMinWidth(100);
        year_column_petroleum_marking_cost.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> petroleum_marking_cost_value_column = new TableColumn<>("surveyor_cost Value");
        petroleum_marking_cost_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        petroleum_marking_cost_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column_petroleum_marking_cost.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column_petroleum_marking_cost.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column_petroleum_marking_cost.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column_petroleum_marking_cost.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column_petroleum_marking_cost.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        petroleum_marking_cost_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        Model model = new Model();
        this.petroleum_marking_cost_tableview.setItems(model.getExchangerateData());

        /*Setting the Columns Properties*/

        this.petroleum_marking_cost_tableview.getColumns().addAll(identity_column_petroleum_marking_cost,date_column_petroleum_marking_cost,
                day_column_petroleum_marking_cost,month_column_petroleum_marking_cost,year_column_petroleum_marking_cost,petroleum_marking_cost_value_column);

        /*End TableView Columns*/

    }

}
