package view;

import Static.WAAConversionFactor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class SettingView extends VBox {

    protected ScrollPane setting_view_scrollpane;
    protected VBox main_content_setting_view;
    Accordion setting_titled_holder;

    private TitledPane exchangeratePane;
    private TitledPane FIPViewPane;
    private TitledPane FOBViewPane;
    private TitledPane MarkingCostPane;
    private TitledPane WharfageVATPane;
    private TitledPane computedLocalCost;
    private TitledPane computedGovernmentTaxes;
    private TitledPane computedPumpPriceCap;
    private TitledPane computedWholesale;
    private TitledPane weightedPlatt;
    private TitledPane weightedPremium;
    private TitledPane actualTenderRatePane;
    private TitledPane actualDemurrageFactor;
    private TitledPane weighted_average_conversion_factor;

    public SettingView(){
        this.setPadding(new Insets(5,0,5,75));
        this.setStyle("-fx-border-color: #eeeeee; -fx-background-color:#eeeeee;");

        this.setting_titled_holder = new Accordion();
        /*Call the Method to Populate Setting Controls and Data*/
        /*End Call the Method to Populate Setting Controls and Data*/

        /*Main Container Box Properties*/
        this.main_content_setting_view = new VBox();
        this.main_content_setting_view.setAlignment(Pos.TOP_CENTER);
        this.main_content_setting_view.setStyle("-fx-background-color:#eeeeee;");
        this.main_content_setting_view.setPadding(new Insets(5,5,5,5));
        this.main_content_setting_view.setSpacing(10);
        this.main_content_setting_view.getChildren().addAll(setting_titled_holder);

        /*Scrollpane Properties*/
        this.setting_view_scrollpane =new ScrollPane();
        this.setting_view_scrollpane.setContent(this.main_content_setting_view);
        this.setting_view_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.setting_view_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.setting_view_scrollpane.setStyle("-fx-background-color: #eeeeee;");
        /*Adding All Controls to the Main Node VBox*/
        this.getChildren().add(setting_view_scrollpane);
    }

    public  void addExchangerateView(ExchangeRateView exchangeRateView){

        this.exchangeratePane = new TitledPane();
        this.exchangeratePane.setText("Exchange Rate Values");
        this.exchangeratePane.setContent(exchangeRateView);
        this.setting_titled_holder.getPanes().addAll(exchangeratePane);
    }

    public  void addFIPView(FIPView fipView){

        this.FIPViewPane = new TitledPane();
        this.FIPViewPane.setText("Freight Insurance Premium)");
        this.FIPViewPane.setContent(fipView);
        this.setting_titled_holder.getPanes().addAll(FIPViewPane);
    }

    public  void addFOBView(FOBView fipView){
        this.FOBViewPane = new TitledPane();
        this.FOBViewPane.setText("FOB Price)");
        this.FOBViewPane.setContent(fipView);
        this.setting_titled_holder.getPanes().addAll(FOBViewPane);
    }

    public  void addMarkingCostView(MarkingCostView markingCostView){
        this.MarkingCostPane = new TitledPane();
        this.MarkingCostPane.setText("Petroleum Marking Cost)");
        this.MarkingCostPane.setContent(markingCostView);
        this.setting_titled_holder.getPanes().addAll(MarkingCostPane);
    }

    public  void addWharfageVATView(WharfageVATView wharfageVATView){
        this.WharfageVATPane = new TitledPane();
        this.WharfageVATPane.setText("Wharfage $10/MT + 18% VAT");
        this.WharfageVATPane.setContent(wharfageVATView);
        this.setting_titled_holder.getPanes().addAll(this.WharfageVATPane);
    }

    public  void addComputedLocalCost(ComputedLocalCost computedLocalCost){
        this.computedLocalCost = new TitledPane();
        this.computedLocalCost.setText("Computed Local Cost");
        this.computedLocalCost.setContent(computedLocalCost);
        this.setting_titled_holder.getPanes().addAll(this.computedLocalCost);
    }

    public void addComputedGovernmentTaxes(ComputeGovernmentTaxes computeGovernmentTaxes) {
        this.computedGovernmentTaxes = new TitledPane();
        this.computedGovernmentTaxes.setText("Computed Government Taxes");
        this.computedGovernmentTaxes.setContent(computeGovernmentTaxes);
        this.setting_titled_holder.getPanes().addAll(this.computedGovernmentTaxes);
    }

    public void addComputedPumpPriceCapDaresSalaam(ComputedPumpPriceCapDaresSalaam computedPumpPriceCapDaresSalaam) {
        this.computedPumpPriceCap = new TitledPane();
        this.computedPumpPriceCap.setText("Computed Pump Price Cap Dar es Salaam");
        this.computedPumpPriceCap.setContent(computedPumpPriceCapDaresSalaam);
        this.setting_titled_holder.getPanes().addAll(this.computedPumpPriceCap);
    }

    public void addComputedWholeSalePriceCapView(ComputedWholesalePriceCap computedWholesalePriceCap) {
        this.computedWholesale = new TitledPane();
        this.computedWholesale.setText("Computed Wholesale Price Cap");
        this.computedWholesale.setContent(computedWholesalePriceCap);
        this.setting_titled_holder.getPanes().addAll(this.computedWholesale);
    }

    public void addComputedWeightedAveragePlattFOBView(WeightedAveragePlattFOB weightedAveragePlattFOB) {
        this.weightedPlatt = new TitledPane();
        this.weightedPlatt.setText("Weighted Average Platt FOB");
        this.weightedPlatt.setContent(weightedAveragePlattFOB);
        this.setting_titled_holder.getPanes().addAll(this.weightedPlatt);
    }

    public void addComputedWeightedAveragePremiumFIPView(WeightedAveragePremiumFIP weightedAveragePremiumFIP) {
        this.weightedPremium = new TitledPane();
        this.weightedPremium.setText("Weighted Average Platt FIP");
        this.weightedPremium.setContent(weightedAveragePremiumFIP);
        this.setting_titled_holder.getPanes().addAll(this.weightedPremium);
    }

    public void addActualTenderRateView(ActualTenderRate actualTenderRate){
        this.actualTenderRatePane = new TitledPane();
        this.actualTenderRatePane.setText("Actual Tender Rate");
        this.actualTenderRatePane.setContent(actualTenderRate);
        this.setting_titled_holder.getPanes().addAll(this.actualTenderRatePane);
    }

    public void addActualDemurrageFactorView(ActualDemurrageFactor actualDemurrageFactor){
        this.actualDemurrageFactor= new TitledPane();
        this.actualDemurrageFactor.setText("Actual Demurage Factor");
        this.actualDemurrageFactor.setContent(actualDemurrageFactor);
        this.setting_titled_holder.getPanes().addAll(this.actualDemurrageFactor);
    }

    public void addWeightedAverageActualConversionFactor(WAA_conversion_factor waa_conversion_factor){
        this.weighted_average_conversion_factor= new TitledPane();
        this.weighted_average_conversion_factor.setText("Weighted Average Actual Conversion Factor");
        this.weighted_average_conversion_factor.setContent(waa_conversion_factor);
        this.setting_titled_holder.getPanes().addAll(this.weighted_average_conversion_factor);
    }
    public void clearAccordion(){
        this.setting_titled_holder.getPanes().clear();
    }



}
