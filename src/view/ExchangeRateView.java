package view;

import Static.ExchangeRate;
import Static.FIP;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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

public class ExchangeRateView extends VBox {

    private ScrollPane exchange_rate_content;
    private LineChart<String, Number> exchangerate_linechart;
    private final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    XYChart.Series series;

    private TableView<ExchangeRate> exchangerate_tableview;
    private VBox main_contents;

    private HBox chart_heading_section;
    private HBox exchange_rate_table_heading_section;
    private HBox adding_wiget_heading_section;
    private HBox updating_wiget_heading_section;

    /*Input Controls for Adding Widget*/
    private ComboBox<String> add_day;
    private ComboBox<Integer> add_date;
    private ComboBox<String> add_month;
    private ComboBox<Integer> add_year;
    private TextField add_exchangerate_value;
    private Button add_submit_button;
    private Button add_clear_button;

    /*Input Controls for Updating Widget*/
    private ComboBox update_day;
    private ComboBox update_date;
    private ComboBox update_month;
    private ComboBox update_year;
    private TextField update_exchangerate_value;
    private Button update_submit_button;
    private Button update_clear_button;

    /*Holder Controls*/
    VBox main_holder_controler_adding_section;
    VBox main_holder_controler_updating_section;

    /*Observable Collection*/
    ObservableList<FIP> fip_data = null;

    public ExchangeRateView() {

        this.exchangerate_tableview = new TableView<>();
        this.exchangerate_tableview.setStyle("-fx-background-color: #eeeeee;");

        this.setPadding(new Insets(5,0,5,0));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

       /* this.setPadding(new Insets(5, 0, 5, 75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");*/

        this.exchangerate_linechart = new LineChart<>(this.xAxis, this.yAxis);
        this.series = new XYChart.Series();

        this.add_day = new ComboBox<>();
        this.add_day.setPromptText("Select Day");

        this.add_date = new ComboBox<>();
        this.add_date.setPromptText("Select Date");

        this.add_month = new ComboBox<>();
        this.add_month.setPromptText("Select Month");

        this.add_year = new ComboBox<>();
        this.add_year.setPromptText("Select Year");

        this.add_exchangerate_value = new TextField();
        this.add_exchangerate_value.setPromptText("Exchange Rate Value");

        this.add_submit_button = new Button("Add");
        this.add_clear_button = new Button("Clear");

        this.update_day = new ComboBox();
        this.update_day.setPromptText("Select Day");

        this.update_date = new ComboBox();
        this.update_date.setPromptText("Select Date");

        this.update_month = new ComboBox();
        this.update_month.setPromptText("Select Month");

        this.update_year = new ComboBox();
        this.update_year.setPromptText("Select Year");

        this.update_exchangerate_value = new TextField();
        this.update_exchangerate_value.setPromptText("Exchange Rate Value");

        this.update_submit_button = new Button("Update");

        this.update_clear_button = new Button("Clear");

        this.main_holder_controler_adding_section = new VBox();
        this.main_holder_controler_adding_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_adding_section.setSpacing(5);
        this.main_holder_controler_updating_section = new VBox();
        this.main_holder_controler_updating_section.setAlignment(Pos.CENTER_LEFT);
        this.main_holder_controler_updating_section.setSpacing(5);


        constructExchangrateLineChart();
        constructExchangerateTableView();
        constructExchangerateAddingControls();
        constructExchangerateUpdatingControls();

        this.main_contents = new VBox();
        this.main_contents.setAlignment(Pos.TOP_CENTER);
        this.main_contents.setStyle("-fx-background-color:#eeeeee;");
        this.main_contents.setPadding(new Insets(5, 5, 5, 5));
        this.main_contents.setSpacing(10);

        this.main_contents.getChildren().addAll(
                this.chart_heading_section, this.exchangerate_linechart,
                this.exchange_rate_table_heading_section, this.exchangerate_tableview, this.adding_wiget_heading_section,
                this.main_holder_controler_adding_section, this.updating_wiget_heading_section, this.main_holder_controler_updating_section);


        this.exchange_rate_content = new ScrollPane();
        this.exchange_rate_content.setContent(this.main_contents);
        this.exchange_rate_content.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.exchange_rate_content.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.exchange_rate_content.setStyle("-fx-background-color: #eeeeee;");


        this.getChildren().addAll(this.exchange_rate_content);
    }

    private void constructExchangrateLineChart() {

        /*Section Setting*/
        this.chart_heading_section = new HBox();
        this.chart_heading_section.setStyle("-fx-background-color: #085394;");
        this.chart_heading_section.setMinWidth(700);
        this.chart_heading_section.setMinHeight(27);
        this.chart_heading_section.setAlignment(Pos.CENTER);
        Label lbl_chart_section = new Label("Line Chart Showing Monthly Exchange Rate (1 USD -> TSH)");
        lbl_chart_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.chart_heading_section.getChildren().add(lbl_chart_section);

        this.xAxis.setLabel("Month");
        this.yAxis.setLabel("Tanzanian Shillings");

        this.exchangerate_linechart.setTitle("Exchange Rate 2016");

        this.series.setName("Month Exchange Rate Value");
    }

    private void constructExchangerateTableView() {
        /*Section Setting*/
        this.exchange_rate_table_heading_section = new HBox();
        this.exchange_rate_table_heading_section.setStyle("-fx-background-color: #085394;");
        this.exchange_rate_table_heading_section.setPadding(new Insets(5, 0, 5, 0));
        this.exchange_rate_table_heading_section.setMinWidth(700);
        this.exchange_rate_table_heading_section.setMinHeight(27);
        this.exchange_rate_table_heading_section.setAlignment(Pos.CENTER);
        Label lbl_table_section = new Label("Exchange Rate Information Table");
        lbl_table_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.exchange_rate_table_heading_section.getChildren().add(lbl_table_section);

        /*Creating the TableView Columns*/
        TableColumn<ExchangeRate, Integer> identity_column = new TableColumn<>("Identity");
        identity_column.setMinWidth(100);
        identity_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> date_column = new TableColumn<>("Date");
        date_column.setMinWidth(100);
        date_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> day_column = new TableColumn<>("Day");
        day_column.setMinWidth(100);
        day_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, String> month_column = new TableColumn<>("Month");
        month_column.setMinWidth(100);
        month_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Integer> year_column = new TableColumn<>("Year");
        year_column.setMinWidth(100);
        year_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");

        TableColumn<ExchangeRate, Double> exchangerate_value_column = new TableColumn<>("Exchangerate Value(USD->TSH)");
        exchangerate_value_column.setStyle("-fx-border-color:silver;-fx-background-color: whitesmoke;-fx-alignment:center;");
        exchangerate_value_column.setMinWidth(200);

            /*Dummy Data*/
        identity_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_identity"));
        date_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_date"));
        day_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_day"));
        month_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_month"));
        year_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_year"));
        exchangerate_value_column.setCellValueFactory(new PropertyValueFactory<>("exchangerate_value"));

        /*Setting the Columns Properties*/

        this.exchangerate_tableview.getColumns().addAll(identity_column, date_column, day_column, month_column, year_column, exchangerate_value_column);

        /*End TableView Columns*/

    }

    private void constructExchangerateAddingControls() {
         /*Section Setting*/
        this.adding_wiget_heading_section = new HBox();
        this.adding_wiget_heading_section.setStyle("-fx-background-color: #085394;");
        this.adding_wiget_heading_section.setPadding(new Insets(5, 0, 5, 0));
        this.adding_wiget_heading_section.setMinWidth(700);
        this.adding_wiget_heading_section.setMinHeight(27);
        this.adding_wiget_heading_section.setAlignment(Pos.CENTER);
        Label lbl_adding_section = new Label("Add Exchange Rate Information");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.adding_wiget_heading_section.getChildren().add(lbl_adding_section);

        HBox info_hbox = new HBox();
        info_hbox.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox.setSpacing(2);
        info_hbox.getChildren().addAll(info_image, lbl_info);

        HBox hold_rowone_controls = new HBox();
        hold_rowone_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls.setSpacing(5);
        hold_rowone_controls.getChildren().addAll(this.add_day, this.add_date, this.add_month, this.add_year);

        HBox hold_rowtwo_controls = new HBox();
        hold_rowtwo_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls.setSpacing(5);
        hold_rowtwo_controls.getChildren().add(this.add_exchangerate_value);

        HBox hold_rowthree_controls = new HBox();
        hold_rowthree_controls.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls.setSpacing(5);
        hold_rowthree_controls.getChildren().addAll(this.add_submit_button, this.add_clear_button);

        populateComboBoxes();

        main_holder_controler_adding_section.getChildren().addAll(info_hbox, hold_rowone_controls, hold_rowtwo_controls,
                hold_rowthree_controls);

    }

    private void constructExchangerateUpdatingControls() {

         /*Section Setting*/
        this.updating_wiget_heading_section = new HBox();
        this.updating_wiget_heading_section.setStyle("-fx-background-color: #085394;");
        this.updating_wiget_heading_section.setPadding(new Insets(5, 0, 5, 0));
        this.updating_wiget_heading_section.setMinWidth(700);
        this.updating_wiget_heading_section.setMinHeight(27);
        this.updating_wiget_heading_section.setAlignment(Pos.TOP_CENTER);
        Label lbl_updating_section = new Label("Update Exchange Rate Information");
        lbl_updating_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.updating_wiget_heading_section.getChildren().add(lbl_updating_section);

        HBox info_hbox_update = new HBox();
        info_hbox_update.setAlignment(Pos.CENTER_LEFT);
        ImageView info_image = new ImageView(new Image("/resources/images/info_image.png"));
        Label lbl_info_update = new Label("For auto-filled value Make sure you computer date set correctly");
        lbl_info_update.setStyle("-fx-text-fill: #3a7ee4;-fx-font-size: 13px;");
        info_hbox_update.setSpacing(2);
        info_hbox_update.getChildren().addAll(info_image, lbl_info_update);

        HBox hold_rowone_controls_update = new HBox();
        hold_rowone_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowone_controls_update.setSpacing(5);
        hold_rowone_controls_update.getChildren().addAll(this.update_day, this.update_date, this.update_month, this.update_year);

        HBox hold_rowtwo_controls_update = new HBox();
        hold_rowtwo_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowtwo_controls_update.setSpacing(5);
        hold_rowtwo_controls_update.getChildren().add(this.update_exchangerate_value);

        HBox hold_rowthree_controls_update = new HBox();
        hold_rowthree_controls_update.setAlignment(Pos.CENTER_LEFT);
        hold_rowthree_controls_update.setSpacing(5);
        hold_rowthree_controls_update.getChildren().addAll(this.update_submit_button, this.update_clear_button);

        main_holder_controler_updating_section.getChildren().addAll(info_hbox_update, hold_rowone_controls_update, hold_rowtwo_controls_update,
                hold_rowthree_controls_update);
    }

    /*Adding Controls Listeners*/
    public void addEventListenersSubmitButtonAdd(EventHandler eventHandler) {

        this.add_submit_button.setOnMouseClicked(eventHandler);

    }

    public void addEventListenersUpdateButton(EventHandler eventHandler) {
        this.update_submit_button.setOnMouseClicked(eventHandler);
    }

    public ExchangeRate getExchangerateDatatobeAdded() {

        ExchangeRate exchangeRate = null;
        if (this.add_day.getValue() != null && this.add_date.getValue() != null && this.add_month.getValue() != null &&
                this.add_year.getValue() != null && this.add_exchangerate_value.getText() != null) {
            exchangeRate = new ExchangeRate(1, this.add_day.getValue().toString(), Integer.parseInt(this.add_date.getValue().toString()),
                    this.add_month.getValue().toString(), Integer.parseInt(this.add_year.getValue().toString()),
                    Double.parseDouble(this.add_exchangerate_value.getText()));

        } else {
            System.out.println("You Must Fill All the Filled");
        }
        return exchangeRate;
    }

    public ExchangeRate getExchangerateDatatobeUpdated() {
        ExchangeRate exchangeRate = null;
        if (this.update_day.getValue() != null && this.update_date.getValue() != null && this.update_month.getValue() != null &&
                this.update_year.getValue() != null && this.update_exchangerate_value.getText() != null) {
            exchangeRate = new ExchangeRate(1, this.update_day.getValue().toString(), Integer.parseInt(this.update_date.getValue().toString()),
                    this.update_month.getValue().toString(), Integer.parseInt(this.update_year.getValue().toString()),
                    Double.parseDouble(this.update_exchangerate_value.getText()));

        } else {
            System.out.println("You Must Fill All the Filled");
        }
        return exchangeRate;
    }

    public void setExchangerateTableViewData(ObservableList<ExchangeRate> exchangerate_data) {
        this.exchangerate_tableview.setItems(exchangerate_data);
    }

    public void setExchangerateLineChartData(XYChart.Series series) {
        if (series != null) {
            this.series = series;
            this.exchangerate_linechart.getData().clear();
            this.exchangerate_linechart.getData().add(this.series);
        } else {
            System.out.println("Linechart Series is Empty");
        }

    }

    private void populateComboBoxes() {

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Friday",
                "Thursday", "Saturday", "Sunday");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);

        ObservableList<String> month_value = FXCollections.observableArrayList("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");

        ObservableList<Integer> year_value = FXCollections.observableArrayList(2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022
                , 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031, 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039, 2040, 2041, 2051, 2052,
                2053, 2054, 2055, 2056, 2057, 2058, 2059, 2060, 2070, 2080, 2081, 2082, 2083, 2084, 2085, 2086, 2087, 2089, 2090, 2091, 2092, 2093,
                2094, 2095, 2096, 2097, 2098, 2099, 2030);

        /*For Adding*/
        this.add_day.setItems(null);
        this.add_date.setItems(null);
        this.add_year.setItems(null);

        this.add_day.setItems(day_value);
        this.add_date.setItems(date_value);
        this.add_month.setItems(month_value);
        this.add_year.setItems(year_value);

        /*For Updating*/
        this.update_day.setItems(null);
        this.update_date.setItems(null);
        this.update_year.setItems(null);

        this.update_day.setItems(day_value);
        this.update_date.setItems(date_value);
        this.update_month.setItems(month_value);
        this.update_year.setItems(year_value);
    }
}