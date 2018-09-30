package DataVisualization;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class YearlyHistogram extends VBox {

    private  String barChartTitle;
    private String xAxisLabel;
    private String yAxisLabel;
    private final String bar_one = "Petroleum";
    private final String bar_two = "Kerosene";
    private final String bar_three = "Diesel";
//    private ObservableList<String> product_category = FXCollections.observableArrayList("January","February","March","April","May","June","July","August",
//            "September","October","November","December");

    private final String[] monthList ={"January","February","March","April","May","June","July","August",
                                        "September","October","November","December"};
    /**Bar Chart Properties*/
    private CategoryAxis xAxisBar;
    private NumberAxis yAxisBar;
    private XYChart.Series[] monthlyData;

    /**Bar Char Object*/
    private BarChart<String, Number> barChart;

    public YearlyHistogram(String barChartTitle, String xAxisLabel, String yAxisLabel){

            /**Setting Properties for Container VBox*/
            this.barChartTitle = barChartTitle;
            this.xAxisLabel = xAxisLabel;
            this.yAxisLabel = yAxisLabel;
        /**Initializing Bar Chart and its Properties*/
            this.xAxisBar = new CategoryAxis();
            this.yAxisBar = new NumberAxis();
            this.barChart = new BarChart<>(xAxisBar,yAxisBar);
            this.barChart.setAnimated(true);
            this.xAxisBar.setLabel(xAxisLabel);
            //this.xAxisBar.setCategories(product_category);
            this.yAxisBar.setLabel(yAxisLabel);

        /**Monthly Data Series*/
        this.monthlyData = new XYChart.Series[12]; /*This will Hold Data for Twelve Month for Each Product*/
    }

    public void constructBarChart(ArrayList<Double> petroleum_data, ArrayList<Double> kerosene_data, ArrayList<Double> diesel_data){

        /**Creating Local Series for Each Month*/
        this.getChildren().clear();

        /*My New Local Technical*/
        XYChart.Series petroleum_series = new XYChart.Series();
            petroleum_series.setName("Petroleum");
            petroleum_series.getData().add(new XYChart.Data(this.monthList[0], petroleum_data.get(0)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[1], petroleum_data.get(1)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[2], petroleum_data.get(2)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[3], petroleum_data.get(3)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[4], petroleum_data.get(4)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[5], petroleum_data.get(5)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[6], petroleum_data.get(6)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[7], petroleum_data.get(7)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[8], petroleum_data.get(8)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[9], petroleum_data.get(9)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[10], petroleum_data.get(10)));
            petroleum_series.getData().add(new XYChart.Data(this.monthList[11], petroleum_data.get(11)));

        XYChart.Series kerosene_series = new XYChart.Series();
            kerosene_series.setName("Kerosene");
            kerosene_series.getData().add(new XYChart.Data(this.monthList[0], kerosene_data.get(0)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[1], kerosene_data.get(1)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[2], kerosene_data.get(2)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[3], kerosene_data.get(3)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[4], kerosene_data.get(4)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[5], kerosene_data.get(5)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[6], kerosene_data.get(6)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[7], kerosene_data.get(7)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[8], kerosene_data.get(8)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[9], kerosene_data.get(9)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[10], kerosene_data.get(10)));
            kerosene_series.getData().add(new XYChart.Data(this.monthList[11], kerosene_data.get(11)));

        XYChart.Series diesel_series = new XYChart.Series();
            diesel_series.setName("Diesel");
            diesel_series.getData().add(new XYChart.Data(this.monthList[0], diesel_data.get(0)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[1], diesel_data.get(1)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[2], diesel_data.get(2)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[3], diesel_data.get(3)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[4], diesel_data.get(4)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[5], diesel_data.get(5)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[6], diesel_data.get(6)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[7], diesel_data.get(7)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[8], diesel_data.get(8)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[9], diesel_data.get(9)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[10], diesel_data.get(10)));
            diesel_series.getData().add(new XYChart.Data(this.monthList[11], diesel_data.get(11)));
        /*End Technical */
        
        /**Adding Series to Bar Chart*/
        this.barChart.getData().addAll(petroleum_series, kerosene_series, diesel_series);
        /**Adding the Bar Chart to VBox Container*/
        this.getChildren().add(barChart);
    }

    public void clearYearlyHistogram(){
        this.barChart.getData().clear();
        this.getChildren().clear();
    }
}
