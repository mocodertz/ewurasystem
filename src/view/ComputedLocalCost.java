package view;

import Static.LocalCost;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ComputedLocalCost extends VBox {

    /*todo Petroleum Controls*/
    private Label wharfage_petroleum;
    private Label customProcessingFee_petroleum;
    private Label weightMeasuresFee_petroleum;
    private Label tbsCharge_petroleum;
    private Label tiperFeeVAT_petroleum;
    private Label actualDemurageCost_petroleum;
    private Label surveyorsCost_petroleum;
    private Label financingCost_petroleum;
    private Label regulatoryLevy_petroleum;
    private Label evaporationLosses_petroleum;
    private Label petroleumMarkingCost_petroleum;
    private Label totalLocalCost_petroleum;

    /*todo Diesel Controls*/
    private Label wharfage_diesel;
    private Label customProcessingFee_diesel;
    private Label weightMeasuresFee_diesel;
    private Label tbsCharge_diesel;
    private Label tiperFeeVAT_diesel;
    private Label actualDemurageCost_diesel;
    private Label surveyorsCost_diesel;
    private Label financingCost_diesel;
    private Label regulatoryLevy_diesel;
    private Label evaporationLosses_diesel;
    private Label dieselMarkingCost_diesel;
    private Label totalLocalCost_diesel;

    /*todo Kerosene Controls*/
    private Label wharfage_kerosene;
    private Label customProcessingFee_kerosene;
    private Label weightMeasuresFee_kerosene;
    private Label tbsCharge_kerosene;
    private Label tiperFeeVAT_kerosene;
    private Label actualDemurageCost_kerosene;
    private Label surveyorsCost_kerosene;
    private Label financingCost_kerosene;
    private Label regulatoryLevy_kerosene;
    private Label evaporationLosses_kerosene;
    private Label keroseneMarkingCost_kerosene;
    private Label totalLocalCost_kerosene;

    /*todo Shared Controls*/
    private Button queryComputedLocalCost;
    private ComboBox<Integer> localCostYear;
    private ComboBox<String> localCostMonth;

    /**For Saving Local Cost*/
    private ComboBox<String> save_day;
    private ComboBox<Integer> save_date;
    private ComboBox<String> save_month;
    private ComboBox<Integer> save_year;
    private Button save_submit_button;


    /**For Saving the Current Local Cost*/

    /*todo Section Header Holder*/
    private HBox custom_local_heading_section;
    private VBox temp_save_controls_vbox;

    public ComputedLocalCost() {

        this.setPadding(new Insets(5, 0, 5, 75));

        this.save_day = new ComboBox<>();
        this.save_day.setPromptText("Select Day");

        this.save_date = new ComboBox<>();
        this.save_date.setPromptText("Select Date");

        this.save_month = new ComboBox<>();
        this.save_month.setPromptText("Select Month");

        this.save_year = new ComboBox<>();
        this.save_year.setPromptText("Select Day");

        this.save_submit_button = new Button("Save");

        /*todo Initializing Petroleum Controls*/
        this.wharfage_petroleum = new Label("Not Available");
        this.customProcessingFee_petroleum = new Label("Not Available");
        this.weightMeasuresFee_petroleum = new Label("Not Available");
        this.tbsCharge_petroleum = new Label("Not Available");
        this.tiperFeeVAT_petroleum = new Label("Not Available");
        this.actualDemurageCost_petroleum = new Label("Not Available");
        this.surveyorsCost_petroleum = new Label("Not Available");
        this.financingCost_petroleum = new Label("Not Available");
        this.regulatoryLevy_petroleum = new Label("Not Available");
        this.evaporationLosses_petroleum = new Label("Not Available");
        this.petroleumMarkingCost_petroleum = new Label("Not Available");
        this.totalLocalCost_petroleum = new Label("Not Available");

        /*todo Initializing Diesel Controls*/
        this.wharfage_diesel = new Label("Not Available");
        this.customProcessingFee_diesel = new Label("Not Available");
        this.weightMeasuresFee_diesel = new Label("Not Available");
        this.tbsCharge_diesel = new Label("Not Available");
        this.tiperFeeVAT_diesel = new Label("Not Available");
        this.actualDemurageCost_diesel = new Label("Not Available");
        this.surveyorsCost_diesel = new Label("Not Available");
        this.financingCost_diesel = new Label("Not Available");
        this.regulatoryLevy_diesel = new Label("Not Available");
        this.evaporationLosses_diesel = new Label("Not Available");
        this.dieselMarkingCost_diesel = new Label("Not Available");
        this.totalLocalCost_diesel = new Label("Not Available");

        /*todo Initializing Kerosene Controls*/
        this.wharfage_kerosene = new Label("Not Available");
        this.customProcessingFee_kerosene = new Label("Not Available");
        this.weightMeasuresFee_kerosene = new Label("Not Available");
        this.tbsCharge_kerosene = new Label("Not Available");
        this.tiperFeeVAT_kerosene = new Label("Not Available");
        this.actualDemurageCost_kerosene = new Label("Not Available");
        this.surveyorsCost_kerosene = new Label("Not Available");
        this.financingCost_kerosene = new Label("Not Available");
        this.regulatoryLevy_kerosene = new Label("Not Available");
        this.evaporationLosses_kerosene = new Label("Not Available");
        this.keroseneMarkingCost_kerosene = new Label("Not Available");
        this.totalLocalCost_kerosene = new Label("Not Available");

        /*todo Initializing Shared Controls*/
        this.queryComputedLocalCost = new Button("Get Local Cost Payable to Other Authorities");
        this.localCostMonth = new ComboBox<>();
        this.localCostMonth.setPromptText("Select Month");
        this.localCostYear = new ComboBox<>();
        this.localCostYear.setPromptText("Select Year");

        /*todo Call Class Methods*/
        constructComputedLocalCostView();
        populateComboBoxes();

    }

    private void constructComputedLocalCostView(){

        this.custom_local_heading_section = new HBox();
        VBox.setMargin(custom_local_heading_section,new Insets(10));
        this.custom_local_heading_section.setStyle("-fx-background-color: #085394;");
        this.custom_local_heading_section.setPadding(new Insets(5,5,5,0));
        this.custom_local_heading_section.setMinWidth(700);
        this.custom_local_heading_section.setMinHeight(27);
        this.custom_local_heading_section.setAlignment(Pos.CENTER);
        Label lbl_adding_section = new Label("Monthly Computed Local Cost");
        lbl_adding_section.setStyle("-fx-font-size: 13px;-fx-text-fill: white;");
        this.custom_local_heading_section.getChildren().add(lbl_adding_section);

        HBox hold_search_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_search_controls.setSpacing(5);
        hold_search_controls.setPadding(new Insets(10));
        hold_search_controls.getChildren().addAll(this.localCostMonth,this.localCostYear,this.queryComputedLocalCost);

        this.temp_save_controls_vbox = new VBox();
        this.temp_save_controls_vbox.setSpacing(2.5);
        this.temp_save_controls_vbox.setPadding(new Insets(10));
        HBox hold_save_controls = new HBox();
        /**hold_search_controls.setAlignment(Pos.CENTER);*/
        hold_save_controls.setSpacing(5);
        //hold_save_controls.setPadding(new Insets(10));
        hold_save_controls.getChildren().addAll(this.save_day,this.save_date,this.save_month,this.save_year);
        this.temp_save_controls_vbox.getChildren().addAll(hold_save_controls,this.save_submit_button);

        /*todo local GridPane*/
        Label localCost_header = new Label("LOCAL COST PAYABLE TO OTHER AUTHORITIES");
        localCost_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label petrol_header = new Label("PETROL");
            petrol_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label diesel_header = new Label("DIESEL");
            diesel_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");
        Label kerosene_header = new Label("KEROSENE");
            kerosene_header.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 5px;");

        GridPane hold_localComputedControls = new GridPane();
            hold_localComputedControls.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            hold_localComputedControls.setGridLinesVisible(true);
            hold_localComputedControls.setAlignment(Pos.CENTER);
            hold_localComputedControls.setPadding(new Insets(10));

            hold_localComputedControls.add(localCost_header,0,0);
            hold_localComputedControls.add(petrol_header,1,0);
            hold_localComputedControls.add(diesel_header,2,0);
            hold_localComputedControls.add(kerosene_header,3,0);

        Label wharfage_name = new Label("Wharfage $10/MT + 18% VAT");
            wharfage_name.setStyle("-fx-font-size: 14px;  -fx-padding: 3px;");
            this.wharfage_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.wharfage_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.wharfage_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(wharfage_name,0,1);
            hold_localComputedControls.add(wharfage_petroleum,1,1);
            hold_localComputedControls.add(wharfage_diesel,2,1);
            hold_localComputedControls.add(wharfage_kerosene,3,1);

        Label customProcessing = new Label("Custom Processing Fee (TZS 4.80/Lt)");
            customProcessing.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.customProcessingFee_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.customProcessingFee_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.customProcessingFee_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(customProcessing,0,2);
            hold_localComputedControls.add(customProcessingFee_petroleum,1,2);
            hold_localComputedControls.add(customProcessingFee_diesel,2,2);
            hold_localComputedControls.add(customProcessingFee_kerosene,3,2);

        Label weightsMeasures = new Label("Weights & Measures Fee (Tsh. 1.00/Lt)");
            weightsMeasures.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.weightMeasuresFee_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.weightMeasuresFee_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.weightMeasuresFee_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(weightsMeasures,0,3);
            hold_localComputedControls.add(weightMeasuresFee_petroleum,1,3);
            hold_localComputedControls.add(weightMeasuresFee_diesel,2,3);
            hold_localComputedControls.add(weightMeasuresFee_kerosene,3,3);

        Label tbsCharge = new Label("TBS Charge");
            tbsCharge.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.tbsCharge_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.tbsCharge_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.tbsCharge_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(tbsCharge,0,4);
            hold_localComputedControls.add(tbsCharge_petroleum,1,4);
            hold_localComputedControls.add(tbsCharge_diesel,2,4);
            hold_localComputedControls.add(tbsCharge_kerosene,3,4);

        Label tiperFee = new Label("TIPER Fee + 18% VAT");
            tiperFee.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.tiperFeeVAT_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.tiperFeeVAT_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.tiperFeeVAT_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(tiperFee,0,5);
            hold_localComputedControls.add(tiperFeeVAT_petroleum,1,5);
            hold_localComputedControls.add(tiperFeeVAT_diesel,2,5);
            hold_localComputedControls.add(tiperFeeVAT_kerosene,3,5);

        Label actualDemurage = new Label("Actual Demurage Cost(USD/MT)");
            actualDemurage.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.actualDemurageCost_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.actualDemurageCost_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.actualDemurageCost_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(actualDemurage,0,6);
            hold_localComputedControls.add(actualDemurageCost_petroleum,1,6);
            hold_localComputedControls.add(actualDemurageCost_diesel,2,6);
            hold_localComputedControls.add(actualDemurageCost_kerosene,3,6);

        Label surveyorsCost = new Label("Surveyors Cost (USD/MT)");
            surveyorsCost.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.surveyorsCost_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.surveyorsCost_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.surveyorsCost_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(surveyorsCost,0,7);
            hold_localComputedControls.add(surveyorsCost_petroleum,1,7);
            hold_localComputedControls.add(surveyorsCost_diesel,2,7);
            hold_localComputedControls.add(surveyorsCost_kerosene,3,7);

        Label financingCost = new Label("Financing Cost (1.00% CIF)");
            financingCost.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.financingCost_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.financingCost_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.financingCost_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(financingCost,0,8);
            hold_localComputedControls.add(financingCost_petroleum,1,8);
            hold_localComputedControls.add(financingCost_diesel,2,8);
            hold_localComputedControls.add(financingCost_kerosene,3,8);

        Label regulatoryLevy = new Label("Regulatory Levy");
            regulatoryLevy.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.regulatoryLevy_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.regulatoryLevy_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.regulatoryLevy_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(regulatoryLevy,0,9);
            hold_localComputedControls.add(regulatoryLevy_petroleum,1,9);
            hold_localComputedControls.add(regulatoryLevy_diesel,2,9);
            hold_localComputedControls.add(regulatoryLevy_kerosene,3,9);

        Label evaporationLosses = new Label("Evaporation Losses (0.5% MSP, 0.30% GO, %IK) CIF");
            evaporationLosses.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.evaporationLosses_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.evaporationLosses_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.evaporationLosses_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(evaporationLosses,0,10);
            hold_localComputedControls.add(evaporationLosses_petroleum,1,10);
            hold_localComputedControls.add(evaporationLosses_diesel,2,10);
            hold_localComputedControls.add(evaporationLosses_kerosene,3,10);

        Label petroleumMarkingCost = new Label("Petroleum Marking Cost ($5.782/CM VAT Inclusive)");
            petroleumMarkingCost.setStyle("-fx-font-size: 14px; -fx-padding: 3px;");
            this.petroleumMarkingCost_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.dieselMarkingCost_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.keroseneMarkingCost_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(petroleumMarkingCost,0,11);
            hold_localComputedControls.add(petroleumMarkingCost_petroleum,1,11);
            hold_localComputedControls.add(dieselMarkingCost_diesel,2,11);
            hold_localComputedControls.add(keroseneMarkingCost_kerosene,3,11);

        Label totalCost = new Label("TOTAL LOCAL COSTS (LC)");
            totalCost.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 3px;");
            this.totalLocalCost_petroleum.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.totalLocalCost_diesel.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            this.totalLocalCost_kerosene.setStyle("-fx-font-size: 14px;  -fx-padding: 5px;");
            hold_localComputedControls.add(totalCost,0,12);
            hold_localComputedControls.add(totalLocalCost_petroleum,1,12);
            hold_localComputedControls.add(totalLocalCost_diesel,2,12);
            hold_localComputedControls.add(totalLocalCost_kerosene,3,12);

        /*todo Setting Grid Pane Constraints*/
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(325));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));
        hold_localComputedControls.getColumnConstraints().add(new ColumnConstraints(125));

        this.getChildren().addAll(this.custom_local_heading_section,hold_search_controls,hold_localComputedControls,
                temp_save_controls_vbox);
        this.setAlignment(Pos.CENTER);

    }

    private void clearLocalCostComputedControlsVaribles(){
        /*todo Initializing Petroleum Controls*/
        this.wharfage_petroleum.setText("");
        this.customProcessingFee_petroleum.setText("");
        this.weightMeasuresFee_petroleum.setText("");
        this.tbsCharge_petroleum.setText("");
        this.tiperFeeVAT_petroleum.setText("");
        this.actualDemurageCost_petroleum.setText("");
        this.surveyorsCost_petroleum.setText("");
        this.financingCost_petroleum.setText("");
        this.regulatoryLevy_petroleum.setText("");
        this.evaporationLosses_petroleum.setText("");
        this.petroleumMarkingCost_petroleum.setText("");
        this.totalLocalCost_petroleum.setText("");

        /*todo Initializing Diesel Controls*/
        this.wharfage_diesel.setText("");
        this.customProcessingFee_diesel.setText("");
        this.weightMeasuresFee_diesel.setText("");
        this.tbsCharge_diesel.setText("");
        this.tiperFeeVAT_diesel.setText("");
        this.actualDemurageCost_diesel.setText("");
        this.surveyorsCost_diesel.setText("");
        this.financingCost_diesel.setText("");
        this.regulatoryLevy_diesel.setText("");
        this.evaporationLosses_diesel.setText("");
        this.dieselMarkingCost_diesel.setText("");
        this.totalLocalCost_diesel.setText("");

        /*todo Initializing Kerosene Controls*/
        this.wharfage_kerosene.setText("");
        this.customProcessingFee_kerosene.setText("");
        this.weightMeasuresFee_kerosene.setText("");
        this.tbsCharge_kerosene.setText("");
        this.tiperFeeVAT_kerosene.setText("");
        this.actualDemurageCost_kerosene.setText("");
        this.surveyorsCost_kerosene.setText("");
        this.financingCost_kerosene.setText("");
        this.regulatoryLevy_kerosene.setText("");
        this.evaporationLosses_kerosene.setText("");
        this.keroseneMarkingCost_kerosene.setText("");
        this.totalLocalCost_kerosene.setText("");
    }

    public void setNonComputedData(
            double processing_fee_petroleum,double processing_fee_kerosene,double processing_fee_diesel,
            double tbs_charge_petroleum,double tbs_charge_kerosene,double tbs_charge_diesel,
            double tiper_fee_petroleum,double tiper_fee_kerosene,double tiper_fee_diesel,
            double financing_cost_petroleum,double financing_cost_kerosene,double financing_cost_diesel,
            double regulatory_levy_petroleum,double regulatory_levy_kerosene,double regulatory_levy_diesel,
            double evaporation_loss_petroleum,double evaporation_loss_kerosene,double evaporation_loss_diesel,
            double weight_measure_fee_petroleum,double weight_measure_fee_kerosene,double weight_measure_fee_diesel,
            double wharfage_petroleum, double wharfage_kerosene, double wharfage_diesel,
            double actual_demurage_cost_petroleum, double actual_demurrage_cost_kerosene, double actual_demurrage_cost_diesel,
            double surveyor_cost_petroleum, double surveyor_cost_kerosene, double surveyor_cost_diesel,
            double marking_cost_petroleum){


        /*Custom Processing Fee*/
        this.customProcessingFee_petroleum.setText(String.valueOf(String.format("%1.2f",processing_fee_petroleum)));
        this.customProcessingFee_kerosene.setText(String.valueOf(String.format("%1.2f",processing_fee_kerosene)));
        this.customProcessingFee_diesel.setText(String.valueOf(String.format("%1.2f",processing_fee_diesel)));

        /*TBS Charges*/
        this.tbsCharge_petroleum.setText(String.valueOf(String.format("%1.2f",tbs_charge_petroleum)));
        this.tbsCharge_kerosene.setText(String.valueOf(String.format("%1.2f",tbs_charge_kerosene)));
        this.tbsCharge_diesel.setText(String.valueOf(String.format("%1.2f",tbs_charge_diesel)));

        /*TIPER Fee*/
        this.tiperFeeVAT_petroleum.setText(String.valueOf(String.format("%1.2f",tiper_fee_petroleum)));
        this.tiperFeeVAT_kerosene.setText(String.valueOf(String.format("%1.2f",tiper_fee_kerosene)));
        this.tiperFeeVAT_diesel.setText(String.valueOf(String.format("%1.2f",tiper_fee_diesel)));

        /*Financing Cost*/
        this.financingCost_petroleum.setText(String.valueOf(String.format("%1.2f",financing_cost_petroleum * 0.01)));
        this.financingCost_kerosene.setText(String.valueOf(String.format("%1.2f",financing_cost_kerosene * 0.01)));
        this.financingCost_diesel.setText(String.valueOf(String.format("%1.2f",financing_cost_diesel * 0.01)));

        /*Regulatory Levy*/
        this.regulatoryLevy_petroleum.setText(String.valueOf(String.format("%1.2f",regulatory_levy_petroleum)));
        this.regulatoryLevy_kerosene.setText(String.valueOf(String.format("%1.2f",regulatory_levy_kerosene)));
        this.regulatoryLevy_diesel.setText(String.valueOf(String.format("%1.2f",regulatory_levy_diesel)));

        /*Evaporation Losses*/
        this.evaporationLosses_petroleum.setText(String.valueOf(String.format("%1.2f",financing_cost_petroleum * 0.005)));
        this.evaporationLosses_kerosene.setText(String.valueOf(String.format("%1.2f",financing_cost_kerosene * 0.003)));
        this.evaporationLosses_diesel.setText(String.valueOf(String.format("%1.2f",financing_cost_diesel * 0.003)));

        /*Weight and Measures*/
        this.weightMeasuresFee_petroleum.setText(String.valueOf(String.format("%1.2f",weight_measure_fee_petroleum)));
        this.weightMeasuresFee_kerosene.setText(String.valueOf(String.format("%1.2f",weight_measure_fee_kerosene)));
        this.weightMeasuresFee_diesel.setText(String.valueOf(String.format("%1.2f",weight_measure_fee_diesel)));

        /**Wharfage*/
        this.wharfage_petroleum.setText(String.valueOf(String.format("%1.2f",wharfage_petroleum)));
        this.wharfage_kerosene.setText(String.valueOf(String.format("%1.2f",wharfage_kerosene)));
        this.wharfage_diesel.setText(String.valueOf(String.format("%1.2f",wharfage_diesel)));

        /**Actual Demurrage Cost*/
        this.actualDemurageCost_petroleum.setText(String.valueOf(String.format("%1.2f",actual_demurage_cost_petroleum)));
        this.actualDemurageCost_kerosene.setText(String.valueOf(String.format("%1.2f",actual_demurrage_cost_kerosene)));
        this.actualDemurageCost_diesel.setText(String.valueOf(String.format("%1.2f",actual_demurrage_cost_diesel)));

        /**Surveyor Cost*/
        this.surveyorsCost_petroleum.setText(String.valueOf(String.format("%1.2f",surveyor_cost_petroleum)));
        this.surveyorsCost_kerosene.setText(String.valueOf(String.format("%1.2f",surveyor_cost_kerosene)));
        this.surveyorsCost_diesel.setText(String.valueOf(String.format("%1.2f",surveyor_cost_diesel)));

        /**Marking Cost*/
        this.petroleumMarkingCost_petroleum.setText(String.valueOf(String.format("%1.2f",marking_cost_petroleum)));
        this.keroseneMarkingCost_kerosene.setText(String.valueOf(String.format("%1.2f",marking_cost_petroleum)));
        this.dieselMarkingCost_diesel.setText(String.valueOf(String.format("%1.2f",marking_cost_petroleum)));
    }


    public void setComputedData(
            double processing_fee_petroleum,double processing_fee_kerosene,double processing_fee_diesel,
            double tbs_charge_petroleum,double tbs_charge_kerosene,double tbs_charge_diesel,
            double tiper_fee_petroleum,double tiper_fee_kerosene,double tiper_fee_diesel,
            double financing_cost_petroleum,double financing_cost_kerosene,double financing_cost_diesel,
            double regulatory_levy_petroleum,double regulatory_levy_kerosene,double regulatory_levy_diesel,
            double evaporation_loss_petroleum,double evaporation_loss_kerosene,double evaporation_loss_diesel,
            double weight_measure_fee_petroleum,double weight_measure_fee_kerosene,double weight_measure_fee_diesel,
            double wharfage_petroleum, double wharfage_kerosene, double wharfage_diesel,
            double actual_demurage_cost_petroleum, double actual_demurrage_cost_kerosene, double actual_demurrage_cost_diesel,
            double surveyor_cost_petroleum, double surveyor_cost_kerosene, double surveyor_cost_diesel,
            double marking_cost_petroleum){


        double temp_total_computed_local_cost_petroleum = processing_fee_petroleum + tbs_charge_petroleum + (financing_cost_petroleum * 0.01) +
                tiper_fee_petroleum + regulatory_levy_petroleum + evaporation_loss_petroleum + weight_measure_fee_petroleum +
                actual_demurage_cost_petroleum + surveyor_cost_petroleum + marking_cost_petroleum + wharfage_petroleum;

        double temp_total_computed_local_cost_kerosene = processing_fee_kerosene + tbs_charge_kerosene + (financing_cost_kerosene * 0.01) +
                tiper_fee_kerosene + regulatory_levy_kerosene + evaporation_loss_kerosene + weight_measure_fee_kerosene +
                actual_demurrage_cost_kerosene + surveyor_cost_kerosene + marking_cost_petroleum + wharfage_kerosene;

        double temp_total_computed_local_cost_diesel = processing_fee_diesel + tbs_charge_diesel + (financing_cost_diesel * 0.01) +
                tiper_fee_diesel + regulatory_levy_diesel + evaporation_loss_diesel + weight_measure_fee_diesel +
                actual_demurrage_cost_diesel + surveyor_cost_diesel + marking_cost_petroleum + wharfage_diesel;

        /*Assign Value to Respective Labels*/
        this.totalLocalCost_petroleum.setText(String.valueOf(String.format("%1.2f",temp_total_computed_local_cost_petroleum)));
        this.totalLocalCost_kerosene.setText(String.valueOf(String.format("%1.2f",temp_total_computed_local_cost_kerosene)));
        this.totalLocalCost_diesel.setText(String.valueOf(String.format("%1.2f",temp_total_computed_local_cost_diesel)));
    }

    public void addQueryStoredDataEvent(EventHandler eventhandler){
        this.queryComputedLocalCost.setOnAction(eventhandler);
    }

    public String getMonth(){
        return localCostMonth.getValue().toString();
    }

    public int getYear(){
        return localCostYear.getValue();
    }

    private void populateComboBoxes(){

        ObservableList<String> month_value = FXCollections.observableArrayList("January","February","March","April",
                "May", "June","July","August","September","October","November","December");

        ObservableList<String> day_value = FXCollections.observableArrayList("Monday","Tuesday","Wednesday","Friday",
                "Thursday", "Saturday","Sunday");

        ObservableList<Integer> date_value = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ObservableList<Integer> year_value =FXCollections.observableArrayList(2015,2016,2017,2018,2019,2020,2021,2022
                ,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2051,2052,
                2053,2054,2055,2056,2057,2058,2059,2060,2070,2080,2081,2082,2083,2084,2085,2086,2087,2089,2090,2091,2092,2093,
                2094,2095,2096,2097,2098,2099,2030);

        this.localCostMonth.setItems(null);
        this.localCostYear.setItems(null);

        this.localCostMonth.setItems(month_value);
        this.localCostYear.setItems(year_value);

        this.save_day.setItems(null);
        this.save_date.setItems(null);
        this.save_year.setItems(null);
        this.save_month.setItems(null);

        this.save_day.setItems(day_value);
        this.save_date.setItems(date_value);
        this.save_month.setItems(month_value);
        this.save_year.setItems(year_value);

    }

    public void hideSearchControls(){
        this.queryComputedLocalCost.setVisible(false);
        this.localCostMonth.setVisible(false);
        this.localCostYear.setVisible(false);
        this.temp_save_controls_vbox.setVisible(false);
    }

    public LocalCost getLocalCostPetroleumData(){

        LocalCost localCost = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            localCost = new LocalCost(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    1,Double.parseDouble(this.totalLocalCost_petroleum.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return localCost;
    }

    public LocalCost getLocalCostKeroseneData(){

        LocalCost localCost = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            localCost = new LocalCost(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    2,Double.parseDouble(this.totalLocalCost_kerosene.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return localCost;
    }

    public LocalCost getLocalCostDieselData(){

        LocalCost localCost = null;
        if(this.save_day.getValue() !=null && this.save_date.getValue() !=null && this.save_month.getValue() !=null &&
                this.save_year.getValue() !=null) {
            localCost = new LocalCost(1, this.save_day.getValue().toString(), Integer.parseInt(this.save_date.getValue().toString()),
                    this.save_month.getValue().toString(), Integer.parseInt(this.save_year.getValue().toString()),
                    3,Double.parseDouble(this.totalLocalCost_diesel.getText()));
        }else{
            System.out.println("You Must Fill All the Filled");
        }
        return localCost;
    }

    public  void saveCurrentComputedLocalCost(EventHandler eventHandler){
        this.save_submit_button.setOnMouseClicked(eventHandler);
    }

}
