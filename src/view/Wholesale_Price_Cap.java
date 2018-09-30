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

public class Wholesale_Price_Cap extends VBox {

    /*ScrollPane For Holding the All Content*/
    protected ScrollPane wholesale_Price_Cap_scrollpane;

    /*Table View Properties*/
    private TableView<ExchangeRate> wholesale_Price_Cap_tableview;

    /*Charts Variables*/
    private LineChart<String,Number> wholesale_Price_Cap_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;


    /*Main Container Box*/
    protected VBox main_content_wholesale_Price_Cap;

    /*Heading Section*/
    private HBox linechart_heading_section;
    private HBox wholesale_Price_Cap_table_heading_section;


    public Wholesale_Price_Cap(){

        /*The Super Class Properties*/
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        /*TableView Properties*/
        this.wholesale_Price_Cap_tableview = new TableView<>();
        this.wholesale_Price_Cap_tableview.setStyle("-fx-background-color: #eeeeee;");


        /*For Charts Properties*/
        this.wholesale_Price_Cap_linechart = new LineChart<>(this.xAxis,this.yAxis);
        this.series = new XYChart.Series();


        /*Call the Method to Populate Controls and Data*/
        construct_wholesale_Price_Cap_graph();
        construct_wholesale_Price_Cap_TableView();
         /*End Call the Method to Populate Controls and Data*/


        /*Main Container Box Properties*/
        this.main_content_wholesale_Price_Cap = new VBox();
        this.main_content_wholesale_Price_Cap.setAlignment(Pos.TOP_CENTER);
        this.main_content_wholesale_Price_Cap.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_wholesale_Price_Cap.setPadding(new Insets(5,5,5,5));
        this.main_content_wholesale_Price_Cap.setSpacing(10);
        this.main_content_wholesale_Price_Cap.getChildren().addAll(this.linechart_heading_section,this.wholesale_Price_Cap_linechart,
                this.wholesale_Price_Cap_table_heading_section,this.wholesale_Price_Cap_tableview);


        /*Scrollpane Properties*/
        this.wholesale_Price_Cap_scrollpane =new ScrollPane();
        this.wholesale_Price_Cap_scrollpane.setContent(this.main_content_wholesale_Price_Cap);
        this.wholesale_Price_Cap_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.wholesale_Price_Cap_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.wholesale_Price_Cap_scrollpane.setStyle("-fx-background-color: #eeeeee;");


        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(wholesale_Price_Cap_scrollpane);
    }


    private void construct_wholesale_Price_Cap_graph(){

        /*Section Setting*/
        this.linechart_heading_section = new HBox();
        this.linechart_heading_section.setStyle("-fx-background-color: #085394;");
        this.linechart_heading_section.setMinWidth(700);
        this.linechart_heading_section.setMinHeight(27);
        this.linechart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section_wholesale_Price_Cap = new Label("Line Chart Showing Surveyor's Cost");
        lbl_chart_section_wholesale_Price_Cap.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.linechart_heading_section.getChildren().add(lbl_chart_section_wholesale_Price_Cap);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Petroleum Marking Cost");

        this.wholesale_Price_Cap_linechart.setTitle("Petroleum Marking Cost");

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
        this.wholesale_Price_Cap_linechart.getData().add(series);
    }

    private void construct_wholesale_Price_Cap_TableView(){
        /*Section Setting*/
        this.wholesale_Price_Cap_table_heading_section = new HBox();
        this.wholesale_Price_Cap_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.wholesale_Price_Cap_table_heading_section.setPadding(new Insets(5,0,5,0));
        this.wholesale_Price_Cap_table_heading_section.setMinWidth(700);
        this.wholesale_Price_Cap_table_heading_section.setMinHeight(27);
        this.wholesale_Price_Cap_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_wholesale_Price_Cap_table_section = new Label("Surveyor Cost Information Table");
        lbl_wholesale_Price_Cap_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.wholesale_Price_Cap_table_heading_section.getChildren().add(lbl_wholesale_Price_Cap_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column_wholesale_Price_Cap = new TableColumn<>("Identity");
        identity_column_wholesale_Price_Cap.setMinWidth(100);
        identity_column_wholesale_Price_Cap.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column_wholesale_Price_Cap = new TableColumn<>("Date");
        date_column_wholesale_Price_Cap.setMinWidth(100);
        date_column_wholesale_Price_Cap.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column_wholesale_Price_Cap = new TableColumn<>("Day");
        day_column_wholesale_Price_Cap.setMinWidth(100);
        day_column_wholesale_Price_Cap.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column_wholesale_Price_Cap = new TableColumn<>("Month");
        month_column_wholesale_Price_Cap.setMinWidth(100);
        month_column_wholesale_Price_Cap.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column_wholesale_Price_Cap = new TableColumn<>("Year");
        year_column_wholesale_Price_Cap.setMinWidth(100);
        year_column_wholesale_Price_Cap.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> wholesale_Price_Cap_value_column = new TableColumn<>("surveyor_cost Value");
        wholesale_Price_Cap_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        wholesale_Price_Cap_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column_wholesale_Price_Cap.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column_wholesale_Price_Cap.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column_wholesale_Price_Cap.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column_wholesale_Price_Cap.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column_wholesale_Price_Cap.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        wholesale_Price_Cap_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        Model model = new Model();
        this.wholesale_Price_Cap_tableview.setItems(model.getExchangerateData());

        /*Setting the Columns Properties*/

        this.wholesale_Price_Cap_tableview.getColumns().addAll(identity_column_wholesale_Price_Cap,date_column_wholesale_Price_Cap,
                day_column_wholesale_Price_Cap,month_column_wholesale_Price_Cap,year_column_wholesale_Price_Cap,wholesale_Price_Cap_value_column);

        /*End TableView Columns*/

    }

}

