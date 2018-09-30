package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MonthlyReport extends VBox {

    private ScrollPane report_content;
    private VBox main_contents;
    private Button queryMonthlyReport;
    private ComboBox<String> report_month;
    private ComboBox<Integer> report_year;
    private ImageView imageViewLogo;
    /*Section Header Holders*/
    private PieChart imported_volume ;
    private VBox importedOilVolume;
    private VBox localCost;
    private VBox governmentTaxes;
    private VBox wholesalePriceCap;
    private VBox pumpPriceCapDSM;
    private VBox reportMainHeader;
    private VBox searchandPrintHeaderControls;
    private VBox addressHolder;

    /*View to Draw*/
    public ComputedPumpPriceCapDaresSalaam computedPumpPriceCapDaresSalaam;
    public ComputedLocalCost computedLocalCost;
    public ComputeGovernmentTaxes computeGovernmentTaxes;
    public ComputedWholesalePriceCap computedWholesalePriceCap;


    public MonthlyReport(){
        this.setPadding(new Insets(5, 5, 5, 0));
        this.setSpacing(5);
       this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #eeeeee;");

        this.queryMonthlyReport = new Button("Get Monthly Report");
        this.report_month = new ComboBox<>();
            this.report_month.setPromptText("Select Month");
        this.report_year = new ComboBox<>();
            this.report_year.setPromptText("Select Year");


        this.reportMainHeader = new VBox();
            this.reportMainHeader.setAlignment(Pos.CENTER);
            this.reportMainHeader.setSpacing(5);

        this.searchandPrintHeaderControls = new VBox();
            this.searchandPrintHeaderControls.setAlignment(Pos.CENTER);
            this.searchandPrintHeaderControls.setSpacing(5);

        this.addressHolder = new VBox();
            this.addressHolder.setAlignment(Pos.CENTER);
            this.addressHolder.setSpacing(2);

        this.pumpPriceCapDSM = new VBox();
            this.pumpPriceCapDSM.setAlignment(Pos.CENTER);
            this.pumpPriceCapDSM.setSpacing(5);

        this.wholesalePriceCap = new VBox();
            this.wholesalePriceCap.setAlignment(Pos.CENTER);
            this.wholesalePriceCap.setSpacing(5);

        this.governmentTaxes = new VBox();
            this.governmentTaxes.setAlignment(Pos.CENTER);
            this.governmentTaxes.setSpacing(5);

        this.localCost = new VBox();
            this.localCost.setAlignment(Pos.CENTER);
            VBox.setMargin(localCost,new Insets(10));
            this.localCost.setSpacing(5);

        this.importedOilVolume = new VBox();
            this.importedOilVolume.setAlignment(Pos.CENTER);
            this.importedOilVolume.setSpacing(5);


        this.main_contents = new VBox();
        this.main_contents.setAlignment(Pos.TOP_CENTER);
        this.main_contents.setStyle("-fx-background-color:#eeeeee;");
        this.main_contents.setPadding(new Insets(5,5,5,5));
        this.main_contents.setSpacing(10);

        this.main_contents.getChildren().addAll(this.reportMainHeader,this.addressHolder,this.searchandPrintHeaderControls,
                this.importedOilVolume,this.localCost,this.governmentTaxes,this.wholesalePriceCap,
                this.pumpPriceCapDSM);
        this.report_content =new ScrollPane();
        this.report_content.setStyle("-fx-background-color: #eeeeee;");
        this.report_content.setContent(this.main_contents);
        this.report_content.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.report_content.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.report_content.setStyle("-fx-background-color: #eeeeee;");

        addReportHeaderLogo();
        addressInfoData();
        addSearchControls();
        addVolumeOfImportedOilView();
        addLocalCostView();
        addGovernmentTaxesView();
        addWholesalePriceCapView();
        addComputedPumpPriceCapDaresSalaamView();
        populateComboBoxes();

        hideViewsSearchControls();

        this.report_content.setContent(main_contents);
        this.getChildren().add(report_content);
        this.setStyle("-fx-background-color: #eeeeee;");

    }

    private void addComputedPumpPriceCapDaresSalaamView(){

        this.computedPumpPriceCapDaresSalaam = new ComputedPumpPriceCapDaresSalaam();
        Label header_lbl = new Label("Pump Price Cap Dar es Salaam");
            header_lbl.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(header_lbl);
        this.pumpPriceCapDSM.getChildren().addAll(hBox,computedPumpPriceCapDaresSalaam);
    }

    private void addWholesalePriceCapView(){
        this.computedWholesalePriceCap = new ComputedWholesalePriceCap();
        Label header_lbl = new Label("Wholesale Price Cap");
        header_lbl.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(header_lbl);
        this.wholesalePriceCap.getChildren().addAll(hBox,computedWholesalePriceCap);
    }

    private void addGovernmentTaxesView(){
        this.computeGovernmentTaxes = new ComputeGovernmentTaxes();
        Label header_lbl = new Label("Government Taxes");
        header_lbl.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(header_lbl);
        this.governmentTaxes.getChildren().addAll(hBox,computeGovernmentTaxes);

    }

    private void addLocalCostView(){
        this.computedLocalCost = new ComputedLocalCost();
        Label header_lbl = new Label("Local Cost");
            header_lbl.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(header_lbl);
        this.localCost.getChildren().addAll(hBox,computedLocalCost);
    }

    private void addVolumeOfImportedOilView(){
         /*Section Setting*/
        Label header_lbl = new Label("Pie CHart Showing Volume or Weight of Imported Oil");
            header_lbl.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");
        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(

                new PieChart.Data("Petroleum",750),
                new PieChart.Data("Kerosene",500),
                new PieChart.Data("Diesel",1000));

        this.imported_volume= new PieChart(piechartData);
        this.imported_volume.setTitle("Imported Oil");

        this.importedOilVolume.getChildren().add(imported_volume);
    }

    private void addReportHeaderLogo(){
         /*Section Setting*/
        Image logoImage = new Image("/resources/images/ewura_img.png");
        this.imageViewLogo = new ImageView();
        this.imageViewLogo.setImage(logoImage);
        this.reportMainHeader.getChildren().add(imageViewLogo);
    }

    public String getMonth(){
        return report_month.getValue().toString();
    }

    public int getYear(){
        return report_year.getValue();
    }

    private void populateComboBoxes(){

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","October","November","December");

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);

        this.report_month.setItems(null);
        this.report_year.setItems(null);

        this.report_month.setItems(month_value);
        this.report_year.setItems(year_value);

    }

    public void addQueryStoredDataEvent(EventHandler eventhandler){
        this.queryMonthlyReport.setOnAction(eventhandler);
    }

    private void hideViewsSearchControls(){
        this.computedLocalCost.hideSearchControls();
        this.computeGovernmentTaxes.hideSearchControls();
        this.computedWholesalePriceCap.hideSearchControls();
        this.computedPumpPriceCapDaresSalaam.hideSearchControls();
    }

    private void addSearchControls(){
        HBox hold_search_controls = new HBox();
        hold_search_controls.setAlignment(Pos.CENTER);
        hold_search_controls.setSpacing(5);
        hold_search_controls.setPadding(new Insets(10));
        hold_search_controls.getChildren().addAll(this.report_month,this.report_year,this.queryMonthlyReport);

        this.searchandPrintHeaderControls.getChildren().add(hold_search_controls);
    }

    private void addressInfoData(){
        HBox ewura_address_headerOne = new HBox();
            ewura_address_headerOne.setAlignment(Pos.CENTER);
            Label lbl_headerOne = new Label("Seventh Floor , LAPFPensions Fund Tower, Opposite Makumbosho Village, Kijitonyama");
                lbl_headerOne.setStyle("-fx-font-size: 12px;");
            ewura_address_headerOne.getChildren().add(lbl_headerOne);

        HBox ewura_address_headerTwo = new HBox();
            ewura_address_headerTwo.setAlignment(Pos.CENTER);
            Label lbl_headerTwo = new Label("P.O Box 72175, Dar es Salaam, Tanzania");
                lbl_headerTwo.setStyle("-fx-font-size: 12px;");
            ewura_address_headerTwo.getChildren().add(lbl_headerTwo);

        HBox ewura_address_headerThree = new HBox();
            ewura_address_headerThree.setAlignment(Pos.CENTER);
            Label lbl_headerThree = new Label("TEL: +255-022 2923513-18; FAX: +255-22 2923519");
                lbl_headerThree.setStyle("-fx-font-size: 12px;");
            ewura_address_headerThree.getChildren().add(lbl_headerThree);

        HBox ewura_address_headerFour = new HBox();
            ewura_address_headerFour.setAlignment(Pos.CENTER);
            ewura_address_headerFour.setSpacing(20);
            Label lbl_headerFourEmail = new Label("Email: info@ewura.go.tz");
                lbl_headerFourEmail.setStyle("-fx-font-size: 12px; -fx-text-fill: blue;");
        Label lbl_headerFourWebsite = new Label("Website: http.//www.ewura.go.tz");
                lbl_headerFourWebsite.setStyle("-fx-font-size: 12px;-fx-text-fill: blue;");
            ewura_address_headerFour.getChildren().addAll(lbl_headerFourEmail,lbl_headerFourWebsite);

        HBox top_line_orange = new HBox();
        HBox top_line_dark_blue = new HBox();
            top_line_orange.setStyle("-fx-background-color: orange;");
            top_line_orange.setMaxWidth(600);
            top_line_orange.setMinHeight(0.5);

            top_line_dark_blue.setStyle("-fx-background-color: darkblue");
            top_line_dark_blue.setMaxWidth(600);
            top_line_dark_blue.setMinHeight(0.5);

        this.addressHolder.getChildren().addAll(top_line_orange,ewura_address_headerOne,ewura_address_headerTwo,
                ewura_address_headerThree,ewura_address_headerFour,top_line_dark_blue);
    }

}
