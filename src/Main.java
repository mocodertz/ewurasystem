import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Model;
import view.*;

public class Main extends Application {

    public Rectangle2D screen_dimension = Screen.getPrimary().getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception{
        /**
         * Views*/
        MainView mainView = new MainView();
        ExchangeRateView exchangeRateView = new ExchangeRateView();
        WAA_conversion_factor waa_conversion_factor = new WAA_conversion_factor();
        CIFCostDaresalaam cif_cost_daresalaam = new CIFCostDaresalaam();
        SettingView settingView = new SettingView();
        FIPView fipView = new FIPView();
        FOBView fobView = new FOBView();
        MarkingCostView markingCostView = new MarkingCostView();
        WharfageVATView wharfageVATView = new WharfageVATView();
        ComputedLocalCost computedLocalCost = new ComputedLocalCost();
        ComputeGovernmentTaxes computeGovernmentTaxes = new ComputeGovernmentTaxes();
        ComputedExchangerateView computedExchangerateView = new ComputedExchangerateView();
        ComputedPumpPriceCapDaresSalaam computedPumpPriceCapDaresSalaam = new ComputedPumpPriceCapDaresSalaam();
        ComputedWholesalePriceCap  computedWholesalePriceCap = new ComputedWholesalePriceCap();
        WeightedAveragePlattFOB weightedAveragePlattFOB = new WeightedAveragePlattFOB();
        WeightedAveragePremiumFIP weightedAveragePremiumFIP = new WeightedAveragePremiumFIP();
        MonthlyReport monthlyReport = new MonthlyReport();
        ActualTenderRate actualTenderRate = new ActualTenderRate();
        ActualDemurrageFactor actualDemurrageFactor = new ActualDemurrageFactor();
        SurveyorCost surveyorCost = new SurveyorCost();
        ActualDemurrageCost actualDemurrageCost = new ActualDemurrageCost();

        Model model = new Model();

        /*Creating the Model and Controller Object*/
        Controller controller = new Controller(mainView, waa_conversion_factor, exchangeRateView,cif_cost_daresalaam,
                settingView,fipView,fobView,wharfageVATView,computedLocalCost,
                computedExchangerateView,markingCostView,computeGovernmentTaxes,computedPumpPriceCapDaresSalaam,
                computedWholesalePriceCap,weightedAveragePlattFOB,weightedAveragePremiumFIP,monthlyReport,actualTenderRate,
                actualDemurrageFactor,surveyorCost,actualDemurrageCost,model);

        Group root = new Group();
        root.getChildren().add(mainView);

        Scene scene =new Scene(root, screen_dimension.getWidth(),screen_dimension.getHeight()-10, Color.rgb(238,238,238));
        scene.getStylesheets().add(Main.class.getResource("/resources/style/main.css").toExternalForm());

        primaryStage.setTitle("Cap Petroleum Price");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
