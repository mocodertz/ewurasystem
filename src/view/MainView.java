package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class MainView extends BorderPane {

    private HBox top_menu;
    private HBox center_contents;
    private VBox left_side_menu_main;
    public Rectangle2D screen_dimension = Screen.getPrimary().getVisualBounds();
    private int control_opacity = 0;
    private Image image_menu;
    private Label lbl_selected_menu;
    private TextField txt_search;
    private Image notification_image;
    private Image alarm_image;
    private Image user_image;
    private Image calender_image;
    private Label time_label;

    /**
     * Left Side Menu Controllers Containers
     * */
    /**HBox exchange_rate_contents;*/
    HBox computed_exchange_rate_contents;
    HBox wharfage_contents;
    HBox dsmppc_contents;
    HBox wholesales_ppc_contents;
    HBox region_ppc_contents;
    HBox percentage_change_contents;
    HBox cif_cost_contents;
    HBox actual_demurrage_cost_contents;
    HBox surveyor_cost_contents;
    HBox petroleum_marking_cost_contents;
    HBox local_tax_cost_contents;
    HBox weighted_fob_contents;
    HBox weighted_premium_contents;
    /*HBox weighted_factor_contents;*/
    HBox month_report_contents;
    HBox month_setting_contents;
    /**
     * End Left Side Menu Controllers Containers
     * */

    public MainView() {

        this.left_side_menu_main = new VBox();

        this.setMinWidth(screen_dimension.getWidth());  /*Setting Min width of VBox*/
        this.setMinHeight(screen_dimension.getHeight()); /*Setting Min Height of VBox*/

        this.setMaxWidth(screen_dimension.getWidth());  /*Setting Max width of VBox*/
        this.setMaxHeight(screen_dimension.getHeight()); /*Setting Max Height of VBox*/

        /**
         * Initiating Class Properties
         * */
        this.top_menu = new HBox();
        this.top_menu.setId("top_menu");
        this.top_menu.setStyle("-fx-background-color: #085394;");
        this.top_menu.setMinWidth(screen_dimension.getWidth());
        this.top_menu.setMinHeight(39);
        this.top_menu.setMaxWidth(screen_dimension.getWidth());
        this.top_menu.setMaxHeight(39);

        this.center_contents = new HBox();
        this.center_contents.setId("center_contents");
        this.center_contents.setPadding(new Insets(5, 0, 0, 0));

        this.image_menu = new Image("/resources/images/image_menu.png");
        this.lbl_selected_menu = new Label("Cap Petroleum Price");
        this.lbl_selected_menu.setId("lbl_selected_menu");
        this.lbl_selected_menu.setStyle("-fx-font-size: 14px;-fx-font-family: sans-serif;-fx-text-fill: white;");
        this.txt_search = new TextField();
        this.txt_search.setMinWidth(700);
        this.txt_search.setMinHeight(25);
        this.txt_search.setMaxWidth(700);
        this.txt_search.setMaxHeight(25);
        this.txt_search.setStyle("-fx-border-radius: 5px;-fx-border-color:whitesmoke;");
        this.txt_search.setPromptText("Search");
        this.txt_search.setId("txt_search");
        this.notification_image = new Image("/resources/images/notification_active.png");
        this.alarm_image = new Image("/resources/images/alarm_image.png");
        this.user_image = new Image("/resources/images/user_image.png");
        this.calender_image = new Image("/resources/images/calender_image.png");
        this.time_label = new Label("12:00 PM");
        this.time_label.setStyle("-fx-font-family: sans-serif;-fx-fon-size:14px;-fx-text-fill:white; -fx-font-weight: bold;");

        /**
         * Initiating the Left Side Menu HBox Containers
         * */
        /**this.exchange_rate_contents = new HBox();*/
        this.computed_exchange_rate_contents = new HBox();
        this.wharfage_contents = new HBox();
        this.dsmppc_contents = new HBox();
        this.wholesales_ppc_contents = new HBox();
        this.region_ppc_contents = new HBox();
        this.percentage_change_contents = new HBox();
        this.cif_cost_contents = new HBox();
        this.actual_demurrage_cost_contents = new HBox();
        this.surveyor_cost_contents = new HBox();
        this.petroleum_marking_cost_contents = new HBox();
        this.local_tax_cost_contents = new HBox();
        this.weighted_fob_contents = new HBox();
        this.weighted_premium_contents = new HBox();
        /*this.weighted_factor_contents = new HBox();*/
        this.month_report_contents = new HBox();
        this.month_setting_contents = new HBox();

        /**
         * Calling Private Object Methods
         * */
        this.constructTopmenu();
        this.constructLeftMenu();

        this.setTop(this.top_menu);
        this.setLeft(this.center_contents);

        HBox box = new HBox();
        box.setMinWidth(screen_dimension.getWidth());
        box.setMinHeight(10);
        box.setStyle("-fx-background-color: #eeeeee;");
        this.setBottom(box);
    }

    private void constructTopmenu() {

        ImageView image_menu_viewer = new ImageView(this.image_menu);
        image_menu_viewer.setId("image_menu");
        hideLeftMenu(image_menu_viewer);

        ImageView notification_image_viewer = new ImageView(this.notification_image);
        notification_image_viewer.setId("notification_image");

        ImageView alarm_image_viewer = new ImageView(this.alarm_image);
        alarm_image_viewer.setId("alarm_image");

        ImageView user_image_viewer = new ImageView(this.user_image);
        user_image_viewer.setId("user_image");

        ImageView calender_image_viewer = new ImageView(this.calender_image);
        calender_image_viewer.setId("calender_image");

        BorderPane top_menu_border_pane = new BorderPane();
        HBox hold_left_top_menu_controls;
        hold_left_top_menu_controls = new HBox();
        hold_left_top_menu_controls.setAlignment(Pos.CENTER_LEFT);
        hold_left_top_menu_controls.setSpacing(15);
        hold_left_top_menu_controls.setPadding(new Insets(0, 200, 0, 0));
        hold_left_top_menu_controls.getChildren().addAll(image_menu_viewer, this.lbl_selected_menu);
        top_menu_border_pane.setLeft(hold_left_top_menu_controls);

        HBox hold_center_top_menu_controls = new HBox();
        hold_center_top_menu_controls.setAlignment(Pos.CENTER);
        hold_center_top_menu_controls.getChildren().add(this.txt_search);
        top_menu_border_pane.setCenter(hold_center_top_menu_controls);

        HBox hold_right_top_menu_controls;
        hold_right_top_menu_controls = new HBox();
        hold_right_top_menu_controls.setAlignment(Pos.CENTER_RIGHT);
        hold_right_top_menu_controls.setSpacing(20);
        hold_right_top_menu_controls.setPadding(new Insets(0, 0, 0, 70));
        hold_right_top_menu_controls.getChildren().addAll(this.time_label, calender_image_viewer, notification_image_viewer, alarm_image_viewer, user_image_viewer);
        top_menu_border_pane.setRight(hold_right_top_menu_controls);
        this.top_menu.getChildren().addAll(top_menu_border_pane);
    }

    private void constructLeftMenu() {

        /*VBox exchange_rate_vertical_box = new VBox();
            exchange_rate_vertical_box.setPadding(new Insets(5, 5, 5, 5));*/
        VBox computed_exchange_rate_vertical_box = new VBox();
            computed_exchange_rate_vertical_box.setPadding(new Insets(5, 5, 5, 5));
        VBox price_per_cap_vertical_box = new VBox();
            price_per_cap_vertical_box.setPadding(new Insets(5, 5, 10, 5));
        VBox report_vertical_box = new VBox();
            report_vertical_box.setPadding(new Insets(5, 5, 10, 5));
        VBox settings_vertical_box = new VBox();
            settings_vertical_box.setPadding(new Insets(5, 5, 10, 5));
        VBox cost_vertical_box = new VBox();
            cost_vertical_box.setPadding(new Insets(5, 5, 10, 5));

        VBox weighted_vertical_box = new VBox();
        weighted_vertical_box.setPadding(new Insets(5, 5, 10, 5));

        /**
         * Exchange Rate VerticalBox Contents
         * */
       /* exchange_rate_contents.setSpacing(10);
        exchange_rate_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView exchange_rate_image = new ImageView(new Image("/resources/images/dollar_image.png"));
        Label lbl_exchange_rate = new Label("Exchange Rate");
        lbl_exchange_rate.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        exchange_rate_contents.setPadding(new Insets(5, 5, 2.5, 15));
        exchange_rate_contents.getChildren().addAll(exchange_rate_image, lbl_exchange_rate);
        setLeftMenuOpacity(exchange_rate_contents, "Exchange Rate         ");
        exchange_rate_vertical_box.getChildren().add(exchange_rate_contents);*/

        /**
         * Computed Exchange Rate VerticalBox Contents
         * */
        computed_exchange_rate_contents.setSpacing(10);
        computed_exchange_rate_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView computed_exchange_rate_image = new ImageView(new Image("/resources/images/dollar_image.png"));
        Label computed_lbl_exchange_rate = new Label("Computed Exchange Rate");
        computed_lbl_exchange_rate.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        computed_exchange_rate_contents.setPadding(new Insets(5, 5, 2.5, 15));
        computed_exchange_rate_contents.getChildren().addAll(computed_exchange_rate_image, computed_lbl_exchange_rate);
        setLeftMenuOpacity(computed_exchange_rate_contents, "Computed Exchange Rate         ");

        /**
         * Wharfage VerticalBox Contents
         * */
        wharfage_contents.setSpacing(10);
        wharfage_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView wharfage_image = new ImageView(new Image("/resources/images/dollar_image.png"));
        Label lbl_wharfage = new Label("Wharfage $10/MT + 10% VAT");
        lbl_wharfage.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        wharfage_contents.setPadding(new Insets(5, 5, 2.5, 15));
        wharfage_contents.getChildren().addAll(wharfage_image, lbl_wharfage);
        setLeftMenuOpacity(wharfage_contents, "Wharfage $10/MT + 10% VAT         ");

        /**
         * Price Per Cap VerticalBox Contents
         * */
        Label price_per_cap_group = new Label("Price Per Cap Attributes");
        price_per_cap_group.setPadding(new Insets(5, 5, 5, 15));
        price_per_cap_group.setStyle("-fx-font-size: 11px;-fx-font-family: sans-serif;");
        HBox divider_line_ppc = new HBox();
        divider_line_ppc.setMinWidth(100);
        divider_line_ppc.setMinHeight(1.25);
        divider_line_ppc.setStyle("-fx-border-color:silver;-fx-background-color: slategray;");
        /**
         * Dar es Salaam Petroleum Price Pump Cap
         * */
        this.dsmppc_contents.setSpacing(10);
        this.dsmppc_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView dsmppc_image = new ImageView(new Image("/resources/images/dsmppc.png"));
        Label lbl_dsmppc = new Label("Dar es Salaam Petroleum Price Pump Cap");
        lbl_dsmppc.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.dsmppc_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.dsmppc_contents.getChildren().addAll(dsmppc_image, lbl_dsmppc);
        setLeftMenuOpacity(this.dsmppc_contents, "Dar es Salaam PPC ");
        /**
         * Wholesale Petroleum Pump Price Cap
         * */
        this.wholesales_ppc_contents.setSpacing(10);
        this.wholesales_ppc_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView wholesales_ppc_image = new ImageView(new Image("/resources/images/wholesalesppc.png"));
        Label lbl_wholesales_ppc = new Label("Wholesales Petroleum Price Cap");
        lbl_wholesales_ppc.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.wholesales_ppc_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.wholesales_ppc_contents.getChildren().addAll(wholesales_ppc_image, lbl_wholesales_ppc);
        setLeftMenuOpacity(this.wholesales_ppc_contents, "Wholesales PPC       ");
        /**
         * Region Petroleum Pump Price Cap
         * */
        this.region_ppc_contents.setSpacing(10);
        this.region_ppc_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView region_ppc_image = new ImageView(new Image("/resources/images/regionppc.png"));
        Label lbl_region_ppc = new Label("Region Petroleum Pump Price Cap");
        lbl_region_ppc.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.region_ppc_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.region_ppc_contents.getChildren().addAll(region_ppc_image, lbl_region_ppc);
        setLeftMenuOpacity(this.region_ppc_contents, "Region PPC             ");
        /**
         * Percentage Change in WPPC and DSMPPC
         * */
        this.percentage_change_contents.setSpacing(10);
        this.percentage_change_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView percentage_change_image = new ImageView(new Image("/resources/images/percentagepp.png"));
        Label lbl_percentage_change = new Label("Percentage change in WPPC and DSMPPC");
        lbl_percentage_change.setStyle("-fx-font-size: 12px;-fx-font-family:Comic Sans MS;");
        this.percentage_change_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.percentage_change_contents.getChildren().addAll(percentage_change_image, lbl_percentage_change);
        setLeftMenuOpacity(this.percentage_change_contents, "Percentage Change ");

        /**Removed Attributes this.region_ppc_contents, this.percentage_change_contents*/
        price_per_cap_vertical_box.getChildren().addAll(price_per_cap_group,
                this.wholesales_ppc_contents, this.dsmppc_contents);
        /**
         * Cost Attribute VerticalBox Contents
         * */
        Label cost_group = new Label("Cost Attributes");
        cost_group.setPadding(new Insets(5, 5, 5, 15));
        cost_group.setStyle("-fx-font-size: 11px;-fx-font-family: sans-serif;");
        HBox divider_line_cost = new HBox();
        divider_line_cost.setMinWidth(100);
        divider_line_cost.setMinHeight(1.25);
        divider_line_cost.setStyle("-fx-border-color:silver;-fx-background-color: slategray;");
        /**
         * CIF Cost Dar es Salaam
         * */
        this.cif_cost_contents.setSpacing(10);
        this.cif_cost_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView cif_cost_image = new ImageView(new Image("/resources/images/cif_cost_image.png"));
        Label lbl_cif_cost = new Label("CIF Cost Dar es Salaam");
        lbl_cif_cost.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.cif_cost_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.cif_cost_contents.getChildren().addAll(cif_cost_image, lbl_cif_cost);
        setLeftMenuOpacity(cif_cost_contents, "CIF Cost Dar es Salaam ");
        /**
         * Actual Demurage Cost
         * */
        this.actual_demurrage_cost_contents.setSpacing(10);
        this.actual_demurrage_cost_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView actual_demurrage_cost_image = new ImageView(new Image("/resources/images/actual_demurage.png"));
        Label lbl_actual_demurrage_cost = new Label("Actual Demurrage Cost");
        lbl_actual_demurrage_cost.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.actual_demurrage_cost_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.actual_demurrage_cost_contents.getChildren().addAll(actual_demurrage_cost_image, lbl_actual_demurrage_cost);
        setLeftMenuOpacity(actual_demurrage_cost_contents, "Actual Demurrage Cost       ");
        /**
         * Surveyor Cost
         * */
        this.surveyor_cost_contents.setSpacing(10);
        this.surveyor_cost_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView surveyor_cost_image = new ImageView(new Image("/resources/images/surveyor_cost.png"));
        Label lbl_surveyor_cost = new Label("Surveyor Cost");
        lbl_surveyor_cost.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.surveyor_cost_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.surveyor_cost_contents.getChildren().addAll(surveyor_cost_image, lbl_surveyor_cost);
        setLeftMenuOpacity(surveyor_cost_contents, "Surveyor Cost             ");
        /**
         * Petroleum Marking Cost
         * */
        this.petroleum_marking_cost_contents.setSpacing(10);
        this.petroleum_marking_cost_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView petroleum_marking_cost_image = new ImageView(new Image("/resources/images/petroleum_marking_cost.png"));
        Label lbl_petroleum_marking_cost = new Label("Petroleum Marking Cost");
        lbl_petroleum_marking_cost.setStyle("-fx-font-size: 12px;-fx-font-family:Comic Sans MS;");
        this.petroleum_marking_cost_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.petroleum_marking_cost_contents.getChildren().addAll(petroleum_marking_cost_image, lbl_petroleum_marking_cost);
        setLeftMenuOpacity(petroleum_marking_cost_contents, "Petroleum Marking Cost ");

        /**
         * Petroleum Marking Cost
         * */
        this.local_tax_cost_contents.setSpacing(10);
        this.local_tax_cost_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView local_tax_cost_image = new ImageView(new Image("/resources/images/local_tax.png"));
        Label lbl_local_tax_cost = new Label("Local Cost and Taxes");
        lbl_local_tax_cost.setStyle("-fx-font-size: 12px;-fx-font-family:Comic Sans MS;");
        this.local_tax_cost_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.local_tax_cost_contents.getChildren().addAll(local_tax_cost_image, lbl_local_tax_cost);
        setLeftMenuOpacity(petroleum_marking_cost_contents, "Petroleum Marking Cost ");
        cost_vertical_box.getChildren().addAll(divider_line_cost, cost_group, this.computed_exchange_rate_contents ,this.cif_cost_contents, this.actual_demurrage_cost_contents,
                this.surveyor_cost_contents, this.petroleum_marking_cost_contents, this.local_tax_cost_contents,
                this.wharfage_contents);


        /**
         * Weighted Attribute VerticalBox Contents
         * */
        Label weighted_group = new Label("Weighted Average");
        weighted_group.setPadding(new Insets(5, 5, 5, 15));
        weighted_group.setStyle("-fx-font-size: 11px;-fx-font-family: sans-serif;");
        HBox divider_line_weighted = new HBox();
        divider_line_weighted.setMinWidth(100);
        divider_line_weighted.setMinHeight(1.25);
        divider_line_weighted.setStyle("-fx-border-color:silver;-fx-background-color: slategray;");
        /**
         * Weighted Average Plat FOB
         * */
        this.weighted_fob_contents.setSpacing(10);
        this.weighted_fob_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView weighted_fob_image = new ImageView(new Image("/resources/images/weighted_platfob.png"));
        Label lbl_weighted_fob = new Label("WA Plat FOB");
        lbl_weighted_fob.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.weighted_fob_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.weighted_fob_contents.getChildren().addAll(weighted_fob_image, lbl_weighted_fob);
        setLeftMenuOpacity(weighted_fob_contents, "Weighted Average Plat FOB ");

        /**
         * Weighted Average Premium as Per Quotation*/
        this.weighted_premium_contents.setSpacing(10);
        this.weighted_premium_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView weighted_premium_image = new ImageView(new Image("/resources/images/weighted_perquatation.png"));
        Label lbl_weighted_premium = new Label("WA Premium as Per Quotation");
        lbl_weighted_premium.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.weighted_premium_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.weighted_premium_contents.getChildren().addAll(weighted_premium_image, lbl_weighted_premium);
        setLeftMenuOpacity(weighted_premium_contents, "Weighted Average Premium");

       /* *//**
         * Weighted Average Actual Conversion Factors
         * *//*
        this.weighted_factor_contents.setSpacing(10);
        this.weighted_factor_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView weighted_factor_image = new ImageView(new Image("/resources/images/weighted_convertionfactor.png"));
        Label lbl_weighted_factor = new Label("WA Actual Conversion Factors");
        lbl_weighted_factor.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.weighted_factor_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.weighted_factor_contents.getChildren().addAll(weighted_factor_image, lbl_weighted_factor);

        setLeftMenuOpacity(weighted_factor_contents, "Weighted Average Actual Conversion Factors             ");*/

        weighted_vertical_box.getChildren().addAll(divider_line_weighted, weighted_group, this.weighted_fob_contents, this.weighted_premium_contents);

        /**
         * Report VerticalBox Contents
         * */
        Label report_group = new Label("Monthly and Annual Reports");
        report_group.setPadding(new Insets(5, 5, 5, 15));
        report_group.setStyle("-fx-font-size: 11px;-fx-font-family: sans-serif;");
        HBox divider_line_report = new HBox();
        divider_line_report.setMinWidth(100);
        divider_line_report.setMinHeight(1.25);
        divider_line_report.setStyle("-fx-border-color:silver;-fx-background-color: slategray;");

        /**
         * Monthly Report
         * */
        this.month_report_contents.setSpacing(10);
        this.month_report_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView month_report_image = new ImageView(new Image("/resources/images/image_report.png"));
        Label lbl_month_report = new Label("Monthly Report");
        lbl_month_report.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.month_report_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.month_report_contents.getChildren().addAll(month_report_image, lbl_month_report);
        setLeftMenuOpacity(this.month_report_contents, "Monthly Report         ");
        report_vertical_box.getChildren().addAll(divider_line_report, report_group, this.month_report_contents);

        /**
         * Setting VerticalBox Contents
         * */
        HBox divider_line = new HBox();
        divider_line.setMinWidth(100);
        divider_line.setMinHeight(1.25);
        divider_line.setStyle("-fx-border-color:silver;-fx-background-color: slategray;");
        Label setting_group = new Label("Settings");
        setting_group.setPadding(new Insets(5, 5, 5, 15));
        setting_group.setStyle("-fx-font-size: 11px;-fx-font-family: sans-serif;");

        /**
         * Monthly Settings*/
        this.month_setting_contents.setSpacing(10);
        this.month_setting_contents.setAlignment(Pos.CENTER_LEFT);
        ImageView month_setting_image = new ImageView(new Image("/resources/images/image_setting.png"));
        Label lbl_month_setting = new Label("Monthly Setting");
        lbl_month_setting.setStyle("-fx-font-size: 12px;-fx-font-family: Comic Sans MS;");
        this.month_setting_contents.setPadding(new Insets(5, 5, 2.5, 15));
        this.month_setting_contents.getChildren().addAll(month_setting_image, lbl_month_setting);
        setLeftMenuOpacity(this.month_setting_contents, "Monthly Setting         ");
        settings_vertical_box.getChildren().addAll(divider_line, setting_group, this.month_setting_contents);
        /*Setting VerticalBox Contents*/

       /*todo Adding the To the Left of Border Pane*/
        this.left_side_menu_main.setId("left_side_menu_main");
        this.left_side_menu_main.setAlignment(Pos.TOP_CENTER);
        this.left_side_menu_main.getChildren().addAll(price_per_cap_vertical_box, cost_vertical_box, weighted_vertical_box,
                report_vertical_box, settings_vertical_box);
        this.center_contents.getChildren().add(left_side_menu_main);
    }

    private void setLeftMenuOpacity(Node node, String menu_value) {
        node.setOnMouseEntered(event -> {
            node.setOpacity(0.5);
            /*this.lbl_selected_menu.setText(menu_value);*/
        });
        node.setOnMouseExited(event -> node.setOpacity(1));

    }


    private void hideLeftMenu(Node node_image_button) {
        node_image_button.setOnMouseClicked(event -> {
            if (control_opacity == 0) {
                this.left_side_menu_main.setOpacity(0);
                this.control_opacity++;
            } else if (control_opacity == 1) {
                this.left_side_menu_main.setOpacity(1);
                this.control_opacity = 0;
            }

        });
    }

    /*Adding Listeners for Left Side Menu
    public void addEventListenersExachangerate(EventHandler eventHandler) {
        exchange_rate_contents.setOnMouseClicked(eventHandler);
    }*/

    public void addEventListenersdsmppc_contents(EventHandler eventHandler) {
        dsmppc_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenerscif_cost_contents(EventHandler eventHandler) {
        cif_cost_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersSettingView(EventHandler eventHandler) {
        this.month_setting_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersMonthlyReport(EventHandler eventHandler) {
        this.month_report_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersSurveyorCostView(EventHandler eventHandler) {
        this.surveyor_cost_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersActualDemurrageCostView(EventHandler eventHandler) {
        this.actual_demurrage_cost_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersWeightedAveragePlattFOBView(EventHandler eventHandler) {
        this.weighted_fob_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersWeightedAveragePremiumFIPView(EventHandler eventHandler) {
        this.weighted_premium_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersPetroleumMarkingCostView(EventHandler eventHandler) {
        this.petroleum_marking_cost_contents.setOnMouseClicked(eventHandler);
    }

    /*public void addEventListenersWeightedActualConversionFactorView(EventHandler eventHandler) {
        this.weighted_factor_contents.setOnMouseClicked(eventHandler);
    }*/

    public void addEventListenersLocalCostAndTaxesView(EventHandler eventHandler) {
        this.local_tax_cost_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersComputeWholePriceCapDSMView(EventHandler eventHandler) {
        this.wholesales_ppc_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersComputeExchangeRateView(EventHandler eventHandler) {
        this.computed_exchange_rate_contents.setOnMouseClicked(eventHandler);
    }

    public void addEventListenersWharfageView(EventHandler eventHandler) {
        this.wharfage_contents.setOnMouseClicked(eventHandler);
    }



}
