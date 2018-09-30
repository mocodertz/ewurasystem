package controller;

import Static.*;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Model;
import view.*;

import java.time.Year;
import java.util.concurrent.ExecutionException;

public class Controller {
    protected WAA_conversion_factor waa_conversion_factor;
    protected CIFCostDaresalaam cif_cost_daresalaam;
    protected Model model;
    private MainView mainView;
    private ExchangeRateView exchangeRateView;
    private SettingView settingView;
    private FIPView fipView;
    private FOBView fobView;
    private ComputedExchangerateView computedExchangerateView;
    private MarkingCostView markingCostView;
    private WharfageVATView wharfageVATView;
    private ComputedLocalCost computedLocalCost;
    private ComputeGovernmentTaxes computeGovernmentTaxes;
    private ComputedPumpPriceCapDaresSalaam computedPumpPriceCapDaresSalaam;
    private ComputedWholesalePriceCap computedWholesalePriceCap;
    private WeightedAveragePlattFOB weightedAveragePlattFOB;
    private WeightedAveragePremiumFIP weightedAveragePremiumFIP;
    private MonthlyReport monthlyReport;
    private ActualTenderRate actualTenderRate;
    private ActualDemurrageFactor actualDemurrageFactor;
    private ActualDemurrageCost actualDemurrageCost;
    private SurveyorCost surveyorCost;

    public Controller(MainView mainView, WAA_conversion_factor waa_conversion_factor, ExchangeRateView exchangeRateView,
                      CIFCostDaresalaam cif_cost_daresalaam, SettingView settingView, FIPView fipView, FOBView fobView,
                      WharfageVATView wharfageVATView, ComputedLocalCost computedLocalCost, ComputedExchangerateView computedExchangerateView, MarkingCostView markingCostView,
                      ComputeGovernmentTaxes computeGovernmentTaxes, ComputedPumpPriceCapDaresSalaam computedPumpPriceCapDaresSalaam,
                      ComputedWholesalePriceCap computedWholesalePriceCap, WeightedAveragePlattFOB weightedAveragePlattFOB,
                      WeightedAveragePremiumFIP weightedAveragePremiumFIP, MonthlyReport monthlyReport, ActualTenderRate actualTenderRate,
                      ActualDemurrageFactor actualDemurrageFactor, SurveyorCost surveyorCost, ActualDemurrageCost actualDemurrageCost, Model model) {

        this.mainView = mainView;
        this.waa_conversion_factor = waa_conversion_factor;
        this.exchangeRateView = exchangeRateView;
        this.cif_cost_daresalaam = cif_cost_daresalaam;
        this.settingView = settingView;
        this.fipView = fipView;
        this.fobView = fobView;
        this.computedExchangerateView = computedExchangerateView;
        this.markingCostView = markingCostView;
        this.wharfageVATView = wharfageVATView;
        this.computedLocalCost = computedLocalCost;
        this.computeGovernmentTaxes = computeGovernmentTaxes;
        this.computedPumpPriceCapDaresSalaam = computedPumpPriceCapDaresSalaam;
        this.computedWholesalePriceCap = computedWholesalePriceCap;
        this.weightedAveragePlattFOB = weightedAveragePlattFOB;
        this.weightedAveragePremiumFIP = weightedAveragePremiumFIP;
        this.monthlyReport = monthlyReport;
        this.actualTenderRate = actualTenderRate;
        this.actualDemurrageFactor = actualDemurrageFactor;
        this.surveyorCost = surveyorCost;
        this.actualDemurrageCost = actualDemurrageCost;
        this.model = model;


     /*For MainView Class*//*
        this.mainView.addEventListenersExachangerate(event -> {
            this.mainView.setCenter(null);

            /**
             * For TableView*//*
            Task<ObservableList<ExchangeRate>> exchangerate_data = new Task<ObservableList<ExchangeRate>>() {
                @Override
                protected ObservableList<ExchangeRate> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getExchangerateData();
                }
            };
            new Thread(exchangerate_data).start();
            try {
                exchangeRateView.setExchangerateTableViewData(exchangerate_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            *//**
             * For Linechart*//*
            Task<XYChart.Series> exchangerate_linechart_data = new Task<XYChart.Series>() {
                @Override
                protected XYChart.Series call() throws Exception {
                    System.out.println("Background Thread Start for Line Chart");
                    return model.getExchangerateLinechartData(2016);
                }
            };
            new Thread(exchangerate_linechart_data).start();
            try {
                exchangeRateView.setExchangerateLineChartData(exchangerate_linechart_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            this.mainView.setCenter(exchangeRateView);
        });*/

        /*this.mainView.addEventListenersWeightedActualConversionFactorView(event -> {
            this.mainView.setCenter(null);
            this.mainView.setCenter(waa_conversion_factor);
        });*/

        /**
         * For CIF Cost in Dar es Salaam*/
        this.mainView.addEventListenerscif_cost_contents(event -> {
            this.mainView.setCenter(null);


            /** Loading Data for Table*/
            Task<ObservableList<CIFCostDaresSalaamStatic>> cifCostDaresSalaamStatic = new Task<ObservableList<CIFCostDaresSalaamStatic>>() {
                @Override
                protected ObservableList<CIFCostDaresSalaamStatic> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getCIFCostDaresSalaamData();
                }
            };
            new Thread(cifCostDaresSalaamStatic).start();
            try {
                this.cif_cost_daresalaam.setCIFCostTableViewData(cifCostDaresSalaamStatic.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }


            this.mainView.setCenter(this.cif_cost_daresalaam);
        });

        this.mainView.addEventListenersMonthlyReport(event -> {
            this.mainView.setCenter(null);
            this.mainView.setCenter(monthlyReport);
        });

        this.mainView.addEventListenersSurveyorCostView(event -> {
            this.mainView.setCenter(null);
            /** Loading Data for Table*/
            Task<ObservableList<SurveyorCostStatic>> surveyor_cost_data = new Task<ObservableList<SurveyorCostStatic>>() {
                @Override
                protected ObservableList<SurveyorCostStatic> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getSurveyorCostData();
                }
            };
            new Thread(surveyor_cost_data).start();
            try {
                this.surveyorCost.setSurveyorCostTableViewData(surveyor_cost_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            this.mainView.setCenter(this.surveyorCost);
        });

        this.mainView.addEventListenersActualDemurrageCostView(event -> {
            this.mainView.setCenter(null);
            /** Loading Data for Table*/
            Task<ObservableList<ActualDemurrageCostStatic>> actual_demurrage_cost_data = new Task<ObservableList<ActualDemurrageCostStatic>>() {
                @Override
                protected ObservableList<ActualDemurrageCostStatic> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getActualDemurrageCostData();
                }
            };
            new Thread(actual_demurrage_cost_data).start();
            try {
                this.actualDemurrageCost.setActualDemurrageCostTableViewData(actual_demurrage_cost_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            this.mainView.setCenter(this.actualDemurrageCost);
        });

        this.mainView.addEventListenersComputeExchangeRateView(event -> {
            this.mainView.setCenter(null);
            /**
             * Background Task Computed Exchange Rate*/
            Task<ObservableList<ExchangeRate>> computedExchangerate_data = new Task<ObservableList<ExchangeRate>>() {
                @Override
                protected ObservableList<ExchangeRate> call() throws Exception {
                    System.out.println("Background Thread Computed Exchangerate");
                    return model.getComputedExchangerate();
                }
            };
            new Thread(computedExchangerate_data).start();
            try {
                this.computedExchangerateView.setComputedExchangerateTableViewData(computedExchangerate_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            this.mainView.setCenter(computedExchangerateView);
        });
        this.mainView.addEventListenersWharfageView(event -> {
            this.mainView.setCenter(null);
           /** Background Wharfage*/
            Task<ObservableList<Wharfage>> wharfage_data = new Task<ObservableList<Wharfage>>() {
                @Override
                protected ObservableList<Wharfage> call() throws Exception {
                    System.out.println("Background Thread Wharfage");
                    return model.getWharfageData();
                }
            };
            new Thread(wharfage_data).start();
            try {
                this.wharfageVATView.setWharfageTableViewData(wharfage_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            this.mainView.setCenter(wharfageVATView);
        });

        /**
         * Weighted Average Platt's FOB for MainView Object*/
        this.mainView.addEventListenersWeightedAveragePlattFOBView(event -> {
            this.mainView.setCenter(null);
            /** Loading Data for Table*/
            Task<ObservableList<WeightPlattFOB>> weighted_average_platt_fob_data = new Task<ObservableList<WeightPlattFOB>>() {
                @Override
                protected ObservableList<WeightPlattFOB> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getWeightedAveragePlattFOBData();
                }
            };
            new Thread(weighted_average_platt_fob_data).start();
            try {
                this.weightedAveragePlattFOB.setWeightPlattFOBTableViewData(weighted_average_platt_fob_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            this.weightedAveragePlattFOB.clearBarChartData();
            this.weightedAveragePlattFOB.addBarChart(this.model.getYearlyWAPFOBValue(Year.now().getValue(), "Petroleum"),
                    this.model.getYearlyWAPFOBValue(Year.now().getValue(), "Kerosene"),
                    this.model.getYearlyWAPFOBValue(Year.now().getValue(), "Diesel"));

            this.mainView.setCenter(this.weightedAveragePlattFOB);
        });

        /**
         * Weighted Average Premium as Per Quotation (Freight + Insurance + Premium) */
        this.mainView.addEventListenersWeightedAveragePremiumFIPView(event -> {
            this.mainView.setCenter(null);
            /** Loading Data for Table*/
            Task<ObservableList<WeightPlattFIP>> weighted_average_premium_quotation_data = new Task<ObservableList<WeightPlattFIP>>() {
                @Override
                protected ObservableList<WeightPlattFIP> call() throws Exception {
                    System.out.println("Weighted Average Premium as Per Quotation (Freight + Insurance + Premium Task Start");
                    return model.getWeightedAveragePlattFIPData();
                }
            };
            new Thread(weighted_average_premium_quotation_data).start();
            try {
                this.weightedAveragePremiumFIP.setWeightPlattFIPTableViewData(weighted_average_premium_quotation_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            this.mainView.setCenter(this.weightedAveragePremiumFIP);
        });

        /**
         * Petroleum Marking Cost ($5.782/CM VAT inclusive)*/
        this.mainView.addEventListenersPetroleumMarkingCostView(event -> {
            this.mainView.setCenter(null);
            /** Loading Data for Table*/
            Task<ObservableList<MarkingCost>> marking_cost_data = new Task<ObservableList<MarkingCost>>() {
                @Override
                protected ObservableList<MarkingCost> call() throws Exception {
                    System.out.println("Petroleum Marking Cost ($5.782/CM VAT inclusive) Task Start");
                    return model.getMarkingCostData();
                }
            };
            new Thread(marking_cost_data).start();
            try {
                this.markingCostView.setMarkingCostTableViewData(marking_cost_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            this.mainView.setCenter(this.markingCostView);
        });

        /**Local Cost and Taxes*/
        this.mainView.addEventListenersLocalCostAndTaxesView(event -> {
            this.mainView.setCenter(null);
            ScrollPane temp_scrollpane = new ScrollPane();
                temp_scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                temp_scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                temp_scrollpane.setStyle("-fx-background-color: #eeeeee;");
            VBox temp_local_coast_taxes_holder = new VBox();
                temp_local_coast_taxes_holder.setStyle("-fx-background-color:#eeeeee");
                temp_scrollpane.setContent(temp_local_coast_taxes_holder);
                temp_local_coast_taxes_holder.getChildren().addAll(this.computedLocalCost,this.computeGovernmentTaxes);
            this.mainView.setCenter(temp_scrollpane);
        });

        /**Compute pump price cap in Dar es Salaam*/
        this.mainView.addEventListenersdsmppc_contents(event -> {
            this.mainView.setCenter(null);
            this.mainView.setCenter(this.computedPumpPriceCapDaresSalaam);
        });

        /**Compute wholesale Price Cap*/
        this.mainView.addEventListenersComputeWholePriceCapDSMView(event -> {
            this.mainView.setCenter(null);
            this.mainView.setCenter(this.computedWholesalePriceCap);
        });

        /**
         * for CIF Cost in Dar es Salaam*/
        this.cif_cost_daresalaam.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertCIFCostDaresSalaamData(this.cif_cost_daresalaam.getCIFCostDaresSalaamtobeeAdded(
                    this.model.getMonthWAPFOBValue(this.cif_cost_daresalaam.getSelectedWAP_WTMonthValue(),
                            this.cif_cost_daresalaam.getSelectedWAP_WT_YearValue(), this.cif_cost_daresalaam.getSelectedProduct()),
                    this.model.getWAPFOBID(this.cif_cost_daresalaam.getSelectedWAP_WTMonthValue(),
                            this.cif_cost_daresalaam.getSelectedWAP_WT_YearValue(), this.cif_cost_daresalaam.getSelectedProduct()),
                    this.model.getMonthWPFIPValue(this.cif_cost_daresalaam.getSelectedWAP_WTMonthValue(),
                            this.cif_cost_daresalaam.getSelectedWAP_WT_YearValue(), this.cif_cost_daresalaam.getSelectedProduct()),
                    this.model.getWPFIPID(this.cif_cost_daresalaam.getSelectedWAP_WTMonthValue(),
                            this.cif_cost_daresalaam.getSelectedWAP_WT_YearValue(), this.cif_cost_daresalaam.getSelectedProduct())));
            this.cif_cost_daresalaam.setCIFCostTableViewData(this.model.getCIFCostDaresSalaamData());
        });

        /**
         *  For ExchangerateView Class*/
        this.exchangeRateView.addEventListenersSubmitButtonAdd(event -> {
                /*Mario Remember to ADD Synchronous */
            this.model.insertExchangerateData(this.exchangeRateView.getExchangerateDatatobeAdded());
            this.exchangeRateView.setExchangerateTableViewData(this.model.getExchangerateData());
            this.exchangeRateView.setExchangerateLineChartData(this.model.getExchangerateLinechartData(2015));

        });

        this.exchangeRateView.addEventListenersUpdateButton(event -> {
            this.model.updateExchangerateData(this.exchangeRateView.getExchangerateDatatobeUpdated());
            this.exchangeRateView.setExchangerateTableViewData(this.model.getExchangerateData());
            this.exchangeRateView.setExchangerateLineChartData(this.model.getExchangerateLinechartData(2016));
        });


        /**
         *  For SettingView Class*/
        this.mainView.addEventListenersSettingView(event -> {
            this.mainView.setCenter(null);
            this.settingView.clearAccordion();
           /* *//**
             * Background Task Computed Exchange Rate*//*
            Task<ObservableList<ExchangeRate>> computedExchangerate_data = new Task<ObservableList<ExchangeRate>>() {
                @Override
                protected ObservableList<ExchangeRate> call() throws Exception {
                    System.out.println("Background Thread Computed Exchangerate");
                    return model.getComputedExchangerate();
                }
            };
            new Thread(computedExchangerate_data).start();
            try {
                this.computedExchangerateView.setComputedExchangerateTableViewData(computedExchangerate_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
*/
            /**
             * Background Task FIP*/
            Task<ObservableList<FIP>> fip_data = new Task<ObservableList<FIP>>() {
                @Override
                protected ObservableList<FIP> call() throws Exception {
                    System.out.println("Background Thread Computed Exchangerate");
                    return model.getFIPData();
                }
            };
            new Thread(fip_data).start();
            try {
                this.fipView.setFIPTableViewData(fip_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            /**
             * Background Task FOB*/
            Task<ObservableList<FOB>> fob_data = new Task<ObservableList<FOB>>() {
                @Override
                protected ObservableList<FOB> call() throws Exception {
                    System.out.println("Background Thread FOB");
                    return model.getFOBData();
                }
            };
            new Thread(fob_data).start();
            try {
                this.fobView.setFOBTableViewData(fob_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            /**
             * Background Task Actual TenderRate*/
            Task<ObservableList<ActualTenderRateStatic>> actualTenderRate_data = new Task<ObservableList<ActualTenderRateStatic>>() {
                @Override
                protected ObservableList<ActualTenderRateStatic> call() throws Exception {
                    System.out.println("Background Thread Actual Tender Rate");
                    return model.getActualTenderRateValues();
                }
            };
            new Thread(actualTenderRate_data).start();
            try {
                this.actualTenderRate.setActualTenderRateTableViewData(actualTenderRate_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            /**
             * Background Task Actual Demurrage Factor*/
            Task<ObservableList<ActualDemurrageFactorStatic>> actualDemurrageFactor_data = new Task<ObservableList<ActualDemurrageFactorStatic>>() {
                @Override
                protected ObservableList<ActualDemurrageFactorStatic> call() throws Exception {
                    System.out.println("Background Thread Actual Tender Rate");
                    return model.getActualDemurrageFactorValues();
                }
            };
            new Thread(actualDemurrageFactor_data).start();
            try {
                this.actualDemurrageFactor.setActualDemurrageCostTableViewData(actualDemurrageFactor_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            /*
             * Background Wharfage
            Task<ObservableList<Wharfage>> wharfage_data = new Task<ObservableList<Wharfage>>() {
                @Override
                protected ObservableList<Wharfage> call() throws Exception {
                    System.out.println("Background Thread Wharfage");
                    return model.getWharfageData();
                }
            };
            new Thread(wharfage_data).start();
            try {
                this.wharfageVATView.setWharfageTableViewData(wharfage_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
             */

            /**Exchange Rate*/
            /**
             * For TableView*/
            Task<ObservableList<ExchangeRate>> exchangerate_data = new Task<ObservableList<ExchangeRate>>() {
                @Override
                protected ObservableList<ExchangeRate> call() throws Exception {
                    System.out.println("Background Thread Start");
                    return model.getExchangerateData();
                }
            };
            new Thread(exchangerate_data).start();
            try {
                exchangeRateView.setExchangerateTableViewData(exchangerate_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            /**
             * For Linechart*/
            Task<XYChart.Series> exchangerate_linechart_data = new Task<XYChart.Series>() {
                @Override
                protected XYChart.Series call() throws Exception {
                    System.out.println("Background Thread Start for Line Chart");
                    return model.getExchangerateLinechartData(2016);
                }
            };
            new Thread(exchangerate_linechart_data).start();
            try {
                exchangeRateView.setExchangerateLineChartData(exchangerate_linechart_data.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }


            /**this.settingView.addComputedExchangerateView(this.computedExchangerateView);*/
            this.settingView.addFIPView(this.fipView);
            this.settingView.addFOBView(this.fobView);
            this.settingView.addWeightedAverageActualConversionFactor(waa_conversion_factor);
            /**this.settingView.addMarkingCostView(this.markingCostView);*/
            /**this.settingView.addWharfageVATView(this.wharfageVATView);*/
            /**this.settingView.addComputedLocalCost(this.computedLocalCost);*/
            /**this.settingView.addComputedGovernmentTaxes(this.computeGovernmentTaxes);*/
            /**this.settingView.addComputedPumpPriceCapDaresSalaam(this.computedPumpPriceCapDaresSalaam);*/
           /**this.settingView.addComputedWholeSalePriceCapView(this.computedWholesalePriceCap);*/
            /**this.settingView.addComputedWeightedAveragePlattFOBView(this.weightedAveragePlattFOB);*/
            /**this.settingView.addComputedWeightedAveragePremiumFIPView(this.weightedAveragePremiumFIP);*/
            this.settingView.addExchangerateView(exchangeRateView);
            this.settingView.addActualTenderRateView(actualTenderRate);
            this.settingView.addActualDemurrageFactorView(this.actualDemurrageFactor);
            this.mainView.setCenter(settingView);
        });

        /**
         * Actual Tender Rate*/
        this.actualTenderRate.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertActualTenderRateValue(this.actualTenderRate.getActualTenderRateDatatobeAdded());
            this.actualTenderRate.setActualTenderRateTableViewData(this.model.getActualTenderRateValues());
        });

        /**
         * Actual Tender Rate*/
        this.actualDemurrageFactor.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertActualTenderRateValue(this.actualDemurrageFactor.getActualDemurrageCostDatatobeAdded());
            this.actualDemurrageFactor.setActualDemurrageCostTableViewData(this.model.getActualDemurrageFactorValues());
        });

        /**
         * FIPView Object*/
        this.fipView.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertFIPData(this.fipView.getFIPDatatobeAdded());
            this.fipView.setFIPTableViewData(this.model.getFIPData());
        });

        this.fipView.addEventListenersUpdateButton(event -> {
            this.model.updateFIPData(this.fipView.getFIPDatatobeUpdated());
            this.fipView.setFIPTableViewData(this.model.getFIPData());
        });

        /**
         * ComputedExchangerateView Object*/
        this.computedExchangerateView.addEventListenersAddComputedExchangerate(event -> {
            this.model.addComputedExchangerate(this.computedExchangerateView.getPreviousMonth(),
                    this.computedExchangerateView.getPreviousThreeMonth(), this.computedExchangerateView.getComputedExchangerateDatatobeAdded());
            this.computedExchangerateView.setComputedExchangerateTableViewData(this.model.getExchangerateData());
        });

        this.computedExchangerateView.addEventListenersUpdateButton(event -> {

        });

        /**
         * FOBView Object*/
        this.fobView.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertFOBData(this.fobView.getFOBDatatobeAdded());
            this.fobView.setFOBTableViewData(this.model.getFOBData());
        });

        this.fobView.addEventListenersUpdateButton(event -> {

        });

        /**
         * Marking Cost Object*/
        this.markingCostView.addEventListenersSubmitButtonAdd(event ->{
                this.model.insertMarkingCostData(this.markingCostView.getMarkingCostDatatobeAdded(this.model.getMonthComputedExchangerate(this.markingCostView.getSelectedMonth(),
                        this.markingCostView.getSelectedYear()), this.model.getExchangerateID(this.markingCostView.getSelectedMonth(), this.markingCostView.getSelectedYear())));


        this.markingCostView.setMarkingCostTableViewData(this.model.getMarkingCostData());});

        /**
         * waa_conversion_factor Object*/

        /**
         * Petroleum Controls*/
        this.waa_conversion_factor.addSmallVesselButtonPetroleum(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addSmallVesseleDataPetroleum();
            }
        });

        this.waa_conversion_factor.addBigVesselButtonPetroleum(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addBigVessselDataPetroleum();
            }
        });

        this.waa_conversion_factor.addSubmitButtonEventPetroleum(event -> {

            this.model.insertWAAData(this.waa_conversion_factor.getDataToBeAddedPetroleum());
            this.waa_conversion_factor.setWAACFTableViewData(this.model.getWAAData());

        });

        /**
         * Diesel Controls*/
        this.waa_conversion_factor.addSmallVesselButtonDiesel(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addSmallVesseleDataDiesel();
            }
        });

        this.waa_conversion_factor.addBigVesselButtonDiesel(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addBigVessselDataDiesel();
            }
        });

        this.waa_conversion_factor.addSubmitButtonEventDiesel(event -> {

            this.model.insertWAAData(this.waa_conversion_factor.getDataToBeAddedDiesel());
            this.waa_conversion_factor.setWAACFTableViewData(this.model.getWAAData());

        });

        /**
         * Kerosene Controls*/
        this.waa_conversion_factor.addSmallVesselButtonKerosene(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addSmallVesseleDataKerosene();
            }
        });

        this.waa_conversion_factor.addBigVesselButtonKerosene(new EventHandler() {
            @Override
            public void handle(Event event) {
                waa_conversion_factor.addBigVessselDataKerosene();
            }
        });

        this.waa_conversion_factor.addSubmitButtonEventKerosene(event -> {

            this.model.insertWAAData(this.waa_conversion_factor.getDataToBeAddedKerosene());
            this.waa_conversion_factor.setWAACFTableViewData(this.model.getWAAData());

        });

        /**
         * Weighted Average Platt FOB*/

        /**
         * Marking Cost Object*/
        this.weightedAveragePlattFOB.addEventListenersSubmitButtonAdd(event ->
                this.model.insertWeightedAveragePlattFOBData(this.weightedAveragePlattFOB.getWeightPlattFOBDatatobeAdded(
                        this.model.getMonthComputedExchangerate(this.weightedAveragePlattFOB.getSelectedMonth(),
                                this.weightedAveragePlattFOB.getSelectedYear()), this.model.getExchangerateID(
                                this.weightedAveragePlattFOB.getSelectedMonth(), this.weightedAveragePlattFOB.getSelectedYear()),
                        this.model.getFOBValue(this.weightedAveragePlattFOB.getSelectedFOBMonth(),
                                this.weightedAveragePlattFOB.getSelectedYear(), this.weightedAveragePlattFOB.getSelectedProduct()),
                        this.model.getFOBValueId(this.weightedAveragePlattFOB.getSelectedFOBMonth(),
                                this.weightedAveragePlattFOB.getSelectedYear(), this.weightedAveragePlattFOB.getSelectedProduct()),
                        this.model.getMonthWAADValue(this.weightedAveragePlattFOB.getSelectedWAAMonth(),
                                this.weightedAveragePlattFOB.getSelectedYear(), this.weightedAveragePlattFOB.getSelectedProduct()),
                        this.model.getWAADID(this.weightedAveragePlattFOB.getSelectedWAAMonth(),
                                this.weightedAveragePlattFOB.getSelectedYear(), this.weightedAveragePlattFOB.getSelectedProduct()))));

        /**
         *  Weighted Average Platt FIP*/
        this.weightedAveragePremiumFIP.addEventListenersSubmitButtonAdd(event ->
                this.model.insertWeightedAveragePlattFIPData(this.weightedAveragePremiumFIP.getWeightPlattFIPDatatobeAdded(
                        this.model.getMonthComputedExchangerate(this.weightedAveragePremiumFIP.getSelectedMonth(),
                                this.weightedAveragePremiumFIP.getSelectedYear()), this.model.getExchangerateID(
                                this.weightedAveragePremiumFIP.getSelectedMonth(), this.weightedAveragePremiumFIP.getSelectedYear()),
                        this.model.getFIPValue(this.weightedAveragePremiumFIP.getSelectedFIPMonth(),
                                this.weightedAveragePremiumFIP.getSelectedYear(), this.weightedAveragePremiumFIP.getSelectedProduct()),
                        this.model.getFIPValueId(this.weightedAveragePremiumFIP.getSelectedFIPMonth(),
                                this.weightedAveragePremiumFIP.getSelectedYear(), this.weightedAveragePremiumFIP.getSelectedProduct()),
                        this.model.getMonthWAADValue(this.weightedAveragePremiumFIP.getSelectedWAAMonth(),
                                this.weightedAveragePremiumFIP.getSelectedYear(), this.weightedAveragePremiumFIP.getSelectedProduct()),
                        this.model.getWAADID(this.weightedAveragePremiumFIP.getSelectedWAAMonth(),
                                this.weightedAveragePremiumFIP.getSelectedYear(), this.weightedAveragePremiumFIP.getSelectedProduct()))));

        /**
         * Wharfage */
        this.wharfageVATView.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertWharfageData(this.wharfageVATView.getWharfageDatatobeAdded(
                    this.model.getMonthComputedExchangerate(this.wharfageVATView.getSelectedMonth(),
                            this.wharfageVATView.getSelectedYear()),
                    this.model.getExchangerateID(this.wharfageVATView.getSelectedMonth(),
                            this.wharfageVATView.getSelectedYear()),
                    this.model.getMonthWAADValue(this.wharfageVATView.getWAAMonth(),
                            this.wharfageVATView.getSelectedYear(), this.wharfageVATView.getSelectedProduct()),
                    this.model.getWAADID(this.wharfageVATView.getWAAMonth(), this.wharfageVATView.getSelectedYear(),
                            this.wharfageVATView.getSelectedProduct())));

            this.wharfageVATView.setWharfageTableViewData(this.model.getWharfageData());
        });


        /**
         * Compute pump price cap in Dar es Salaam (DSM)  */
        this.computedPumpPriceCapDaresSalaam.addQueryStoredDataEvent(event -> {

            /*For Non Computed Data Values*/
            this.computedPumpPriceCapDaresSalaam.setNonComputedData(
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel")
                    );

            /**for Computed Data Values*/
            this.computedPumpPriceCapDaresSalaam.setComputedData(
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getRetailersMarginValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getTransportChargesValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Petroleum"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Kerosene"),
                    this.model.getWholeSalePriceCapValue(this.computedPumpPriceCapDaresSalaam.getMonth(),
                            this.computedPumpPriceCapDaresSalaam.getYear(), "Diesel"));

        });

        this.computedPumpPriceCapDaresSalaam.saveCurrentPumpPriceCap(event -> {
            this.model.insertPumpPriceCapData(this.computedPumpPriceCapDaresSalaam.getPumpPriceCaPetroleumData());
            this.model.insertPumpPriceCapData(this.computedPumpPriceCapDaresSalaam.getPumpPriceCapKeroseneData());
            this.model.insertPumpPriceCapData(this.computedPumpPriceCapDaresSalaam.getPumpPriceCapDieselData());
        });

        /**
         * Compute wholesale Price Cap
         * */

        this.computedWholesalePriceCap.addQueryStoredDataEvent(event -> {

            /** for Non Computed Data*/
            this.computedWholesalePriceCap.setNonComputedData(
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel")
            );

            /** for Computed Data*/
            this.computedWholesalePriceCap.setComputedData(
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getChargePayabletoLocalAgence(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getOMCOverheadsMarginValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getLocalCostDataValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Petroleum"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Kerosene"),
                    this.model.getGovernmentTaxesValue(this.computedWholesalePriceCap.getMonth(),
                            this.computedWholesalePriceCap.getYear(), "Diesel")
            );
        });

        this.computedWholesalePriceCap.saveCurrentComputedLWholeSlaePriceCap(event -> {
            this.model.insertWholeSalesPriceCapData(this.computedWholesalePriceCap.getWholeSalePriceCapPetroleumData());
            this.model.insertWholeSalesPriceCapData(this.computedWholesalePriceCap.getPumpWholesalePriceCapKeroseneData());
            this.model.insertWholeSalesPriceCapData(this.computedWholesalePriceCap.getWholesalePriceCapDieselData());
        });

        /** for Compute Government Taxes */

        this.computeGovernmentTaxes.addQueryStoredDataEvent(event -> {

            /** Non Computed Data*/
            this.computeGovernmentTaxes.setNonComputedData(
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"));


            /** Computed Data*/
            this.computeGovernmentTaxes.setComputedData(
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getFuelLevyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getExerciseDutyValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Petroleum"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Diesel"),
                    this.model.getPetroleumFeeValue(this.computeGovernmentTaxes.getMonth(),
                            this.computeGovernmentTaxes.getYear(), "Kerosene"));
        });

        this.computeGovernmentTaxes.saveCurrentComputedGovernmentTaxes(event -> {
            this.model.insertGovernmentTaxesData(this.computeGovernmentTaxes.getGovernmentTaxesPetroleumData());
            this.model.insertGovernmentTaxesData(this.computeGovernmentTaxes.getGovernmentTaxesKeroseneData());
            this.model.insertGovernmentTaxesData(this.computeGovernmentTaxes.getPumpGovernmentTaxesDieselData());

        });

        /**
         * Computed Local Cost*/
        this.computedLocalCost.addQueryStoredDataEvent(event -> {

            /** for Non Computed Data*/
            this.computedLocalCost.setNonComputedData(
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getPetroleumMarkingCostMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear()));


            /** for Computed Data*/
            this.computedLocalCost.setComputedData(
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.geCustomProcessingFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getTBSChargeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getTiperFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getRegulatoryLevyValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getEvaporationLossesValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getWeightMeasureFeeValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getWharfageMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getActualDemurrageCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Petroleum"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Kerosene"),
                    this.model.getSurveyorCostValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear(), "Diesel"),
                    this.model.getPetroleumMarkingCostMonthValue(this.computedLocalCost.getMonth(), this.computedLocalCost.getYear()));
        });

        this.computedLocalCost.saveCurrentComputedLocalCost(event -> {
            this.model.insertLocalCostData(this.computedLocalCost.getLocalCostPetroleumData());
            this.model.insertLocalCostData(this.computedLocalCost.getLocalCostKeroseneData());
            this.model.insertLocalCostData(this.computedLocalCost.getLocalCostDieselData());

        });

        /** For Monthly Report */
        this.monthlyReport.addQueryStoredDataEvent(event -> {

            /**  For Non Computed Data Local Cost */
            this.monthlyReport.computedLocalCost.setNonComputedData(
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getPetroleumMarkingCostMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear()));


            /** for Computed Data Local Cost */
            this.monthlyReport.computedLocalCost.setComputedData(
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.geCustomProcessingFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTBSChargeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTiperFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getFinancingCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getRegulatoryLevyValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getEvaporationLossesValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWeightMeasureFeeValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWharfageMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getActualDemurrageCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getSurveyorCostValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear(), "Diesel"),
                    this.model.getPetroleumMarkingCostMonthValue(this.monthlyReport.getMonth(), this.monthlyReport.getYear()));


            /** for Non Computed Data Government Taxes */
            this.monthlyReport.computeGovernmentTaxes.setNonComputedData(
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"));

            /** Computed Data for Government Taxes */
            this.monthlyReport.computeGovernmentTaxes.setComputedData(
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getFuelLevyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getExerciseDutyValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getPetroleumFeeValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"));


            /** For Non Computed Data Wholesales Price Cap */
            this.monthlyReport.computedWholesalePriceCap.setNonComputedData(
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel")
            );

            /** For Computed Data Wholesale Price Cap */
            this.monthlyReport.computedWholesalePriceCap.setComputedData(
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getChargePayabletoLocalAgence(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getOMCOverheadsMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getCIFCostDaresSalaamValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getLocalCostDataValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getGovernmentTaxesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"));


            /** For Non Computed Data Values Pump Price Cap Dar es Salaam */
            this.monthlyReport.computedPumpPriceCapDaresSalaam.setNonComputedData(
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"));

            /** for Computed Data Values Pump Price Cap Dar es Salaam */
            this.monthlyReport.computedPumpPriceCapDaresSalaam.setComputedData(
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getRetailersMarginValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getTransportChargesValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Petroleum"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Kerosene"),
                    this.model.getWholeSalePriceCapValue(this.monthlyReport.getMonth(),
                            this.monthlyReport.getYear(), "Diesel"));

        });/** End For Monthly Report */


        /**
         * Surveyor Cost*/
        this.surveyorCost.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertSurveyorCostData(this.surveyorCost.getSurveyorCostViewDatatobeAdded(
                    this.model.getMonthComputedExchangerate(this.surveyorCost.getSelectedMonth(), this.surveyorCost.getSelectedYear()),
                    this.model.getExchangerateID(this.surveyorCost.getSelectedMonth(), this.surveyorCost.getSelectedYear()),
                    this.model.getActualTenderRateValue(this.surveyorCost.getSelectedActualTenderRateMonth(),
                            this.surveyorCost.getSelectedYear(), this.surveyorCost.getSelectedProduct(), "Small Vessel"),
                    this.model.getActualTenderRateValueId(this.surveyorCost.getSelectedActualTenderRateMonth(),
                            this.surveyorCost.getSelectedYear(), this.surveyorCost.getSelectedProduct(), "Small Vessel"),
                    this.model.getActualTenderRateValue(this.surveyorCost.getSelectedActualTenderRateMonth(),
                            this.surveyorCost.getSelectedYear(), this.surveyorCost.getSelectedProduct(), "Big Vessel"),
                    this.model.getActualTenderRateValueId(this.surveyorCost.getSelectedActualTenderRateMonth(),
                            this.surveyorCost.getSelectedYear(), this.surveyorCost.getSelectedProduct(), "Big Vessel"),
                    this.model.getMonthWAADValue(this.surveyorCost.getSelectedWAAMonth(), this.surveyorCost.getSelectedYear(),
                            this.surveyorCost.getSelectedProduct()),
                    this.model.getWAADID(this.surveyorCost.getSelectedWAAMonth(), this.surveyorCost.getSelectedYear(),
                            this.surveyorCost.getSelectedProduct())
            ));

            this.surveyorCost.setSurveyorCostTableViewData(this.model.getSurveyorCostData());
        });

        /**
         * Actual Demurrage Cost*/
        this.actualDemurrageCost.addEventListenersSubmitButtonAdd(event -> {
            this.model.insertActualDemurrageCostData(this.actualDemurrageCost.getActualDemurrageCostStaticViewDatatobeAdded(
                    this.model.getMonthComputedExchangerate(this.actualDemurrageCost.getSelectedMonth(), this.actualDemurrageCost.getSelectedYear()),
                    this.model.getExchangerateID(this.actualDemurrageCost.getSelectedMonth(), this.actualDemurrageCost.getSelectedYear()),
                    this.model.getActualDemurrageFactorValue(this.actualDemurrageCost.getSelectedActualDemurrageFactorMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct(), "Small Vessel"),
                    this.model.getActualDemurrageFactorId(this.actualDemurrageCost.getSelectedActualDemurrageFactorMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct(), "Small Vessel"),
                    this.model.getActualDemurrageFactorValue(this.actualDemurrageCost.getSelectedActualDemurrageFactorMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct(), "Big Vessel"),
                    this.model.getActualDemurrageFactorId(this.actualDemurrageCost.getSelectedActualDemurrageFactorMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct(), "Big Vessel"),
                    this.model.getMonthWAADValue(this.actualDemurrageCost.getSelectedWAAMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct()),
                    this.model.getWAADID(this.actualDemurrageCost.getSelectedWAAMonth(),
                            this.actualDemurrageCost.getSelectedYear(), this.actualDemurrageCost.getSelectedProduct())));

            this.actualDemurrageCost.setActualDemurrageCostTableViewData(this.model.getActualDemurrageCostData());
        });
    }

}
