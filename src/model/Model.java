package model;

import DAOInterfaceMethods.*;
import DatabaseConfiguration.ConnectionConfiguration;
import Static.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model implements ExchangerateInterface, FIPInterface, FOBInterface,
        WAAFactorInterface, MarkingCostInterface, WeightedAveragePlattFOBInterface,
        WeightedPremiumFIP, WharfageInterface, WholeSalesPriceCap, RetailersMarginInterface, TransportChargesInterface,
        OMCOverheadsMargins, ChargesPayabletoLocalAgencies, FuelLevyInterface, ExerciseDuty, PetroleumFeeInterface,
        CustomProcessingFeeInterface, TBSChargeInterface, TiperFeeInterface, FinancingCostInterface, RegulatoryLevyInterface,
        EvaporationLossesInterface, WeightMeasuresFee, CIFCostDaresSalaanInterface, ActualTenderRateInterface,
        ActualDemurrageFactorInterface, SurveyorCostInterface,ActualDemurrageCostInterface,PumpPriceCapInterface,
        GovernmentTaxesInterface,LocalCostInterface{


    public Model() {
    }
/**
 * Exchange Rate */
    @Override
    public void insertExchangerateData(ExchangeRate exchangeRate) {

        Connection connection = null;
        PreparedStatement preparedStatement;

        if (exchangeRate != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO exchangerate_table (exchangerate_day," +
                        "exchangerate_date,exchangerate_month,exchangerate_year,exchangerate_value) VALUES(?,?,?,?,?) ");
                preparedStatement.setString(1, exchangeRate.getExchangerate_day());
                preparedStatement.setInt(2, exchangeRate.getExchangerate_date());
                preparedStatement.setString(3, exchangeRate.getExchangerate_month());
                preparedStatement.setInt(4, exchangeRate.getExchangerate_year());
                preparedStatement.setDouble(5, exchangeRate.getExchangerate_value());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public double getMonthComputedExchangerate(String month, int year) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double computed_exchangeRates_value = 0.0;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT com_exchangerate_value FROM computed_exchangerate_table WHERE com_exchangerate_year='" + year + "' AND com_exchangerate_month ='" + month + "'");

            while (resultSet.next()) {
                computed_exchangeRates_value = resultSet.getDouble("com_exchangerate_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return computed_exchangeRates_value;
    }

    @Override
    public int getExchangerateID(String month, int year) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int computed_exchangeRates_id = 0;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT com_exchangerate_id FROM computed_exchangerate_table WHERE com_exchangerate_year ='" + year + "' AND com_exchangerate_month = '" + month + "'");

            while (resultSet.next()) {
                computed_exchangeRates_id = resultSet.getInt("com_exchangerate_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return computed_exchangeRates_id;
    }

    @Override
    public void updateExchangerateData(ExchangeRate exchangeRate) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (exchangeRate != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("UPDATE exchangerate_table SET exchangerate_day='" + exchangeRate.getExchangerate_day() + "'," +
                        "exchangerate_date='" + exchangeRate.getExchangerate_date() + "',exchangerate_month='" + exchangeRate.getExchangerate_month() + "'," +
                        "exchangerate_year='" + exchangeRate.getExchangerate_year() + "',exchangerate_value ='" + exchangeRate.getExchangerate_value() + "' WHERE " +
                        "exchangerate_day='" + exchangeRate.getExchangerate_day() + "' AND exchangerate_date='" + exchangeRate.getExchangerate_date() + "'AND " +
                        "exchangerate_month='" + exchangeRate.getExchangerate_month() + "'AND exchangerate_year='" + exchangeRate.getExchangerate_year() + "'");
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean addComputedExchangerate(ComputedExchagerate prev_month, ComputedExchagerate prev_three_month, ExchangeRate exchangeRate) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        double previous_month_value = 0;
        double previous_three_month_value = 0;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT exchangerate_value FROM exchangerate_table WHERE " +
                    "exchangerate_month = '" + prev_month.getMonth() + "' AND exchangerate_year='" + prev_month.getYear() + "'");
            while (resultSet.next()) {
                previous_month_value = resultSet.getDouble("exchangerate_value");
            }

            resultSet = statement.executeQuery("SELECT exchangerate_value FROM exchangerate_table WHERE " +
                    "exchangerate_month = '" + prev_three_month.getMonth() + "' AND exchangerate_year='" + prev_three_month.getYear() + "'");
            while (resultSet.next()) {
                previous_three_month_value = resultSet.getDouble("exchangerate_value");
            }

            preparedStatement = connection.prepareStatement("INSERT INTO computed_exchangerate_table (com_exchangerate_day," +
                    "com_exchangerate_date,com_exchangerate_month,com_exchangerate_year,com_exchangerate_value) VALUES(?,?,?,?,?) ");
            preparedStatement.setString(1, exchangeRate.getExchangerate_day());
            preparedStatement.setInt(2, exchangeRate.getExchangerate_date());
            preparedStatement.setString(3, exchangeRate.getExchangerate_month());
            preparedStatement.setInt(4, exchangeRate.getExchangerate_year());
            preparedStatement.setDouble(5, (previous_month_value + (previous_month_value - previous_three_month_value)));

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public ObservableList<ExchangeRate> getComputedExchangerate() {
        ObservableList<ExchangeRate> computed_exchangeRates = null;
        List<ExchangeRate> temp_exchangerate = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM computed_exchangerate_table");

            while (resultSet.next()) {

                ExchangeRate temp_rates = new ExchangeRate(resultSet.getInt("com_exchangerate_id"),
                        resultSet.getString("com_exchangerate_day"),
                        resultSet.getInt("com_exchangerate_date"),
                        resultSet.getString("com_exchangerate_month"),
                        resultSet.getInt("com_exchangerate_year"),
                        resultSet.getDouble("com_exchangerate_value"));
                temp_exchangerate.add(temp_rates);
            }

            computed_exchangeRates = FXCollections.observableArrayList(temp_exchangerate);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return computed_exchangeRates;
    }

    @Override
    public ObservableList<ExchangeRate> getExchangerateData() {
        ObservableList<ExchangeRate> exchangeRates = null;
        List<ExchangeRate> temp_exchangerate = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM exchangerate_table");

            while (resultSet.next()) {

                ExchangeRate temp_rates = new ExchangeRate(resultSet.getInt("exchangerate_id"),
                        resultSet.getString("exchangerate_day"),
                        resultSet.getInt("exchangerate_date"),
                        resultSet.getString("exchangerate_month"),
                        resultSet.getInt("exchangerate_year"),
                        resultSet.getDouble("exchangerate_value"));
                temp_exchangerate.add(temp_rates);
            }

            exchangeRates = FXCollections.observableArrayList(temp_exchangerate);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exchangeRates;
    }

    @Override
    public XYChart.Series getExchangerateLinechartData(int year) {
        XYChart.Series temp_chart_data = new XYChart.Series<>();
        Connection connection = null;
        Statement linechart_statement;
        ResultSet linechart_resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            linechart_statement = connection.createStatement();
            linechart_resultSet = linechart_statement.executeQuery("SELECT * FROM exchangerate_table WHERE exchangerate_year ='" + year + "' ");

            while (linechart_resultSet.next()) {
                temp_chart_data.getData().add(new XYChart.Data(linechart_resultSet.getString("exchangerate_month"),
                        linechart_resultSet.getDouble("exchangerate_value")));
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return temp_chart_data;
    }

    @Override
    public ObservableList<ExchangeRate> searchExchangerateByAll(String day, int date, String month, int year) {
        return null;
    }

    @Override
    public ObservableList<ExchangeRate> getExchangerateofPreviousMonth(String month, int year) {
        return null;
    }

    @Override

    public ObservableList<ExchangeRate> getExchangerateofPreviousThreeMonths(String month, int year) {
        return null;
    }

    @Override
    public ObservableList<ExchangeRate> searchExchangerateSearchArray(String search_array) {
        return null;
    }

    /**
     * FIP Interface Implementation
     * */
    @Override
    public void insertFIPData(FIP fip) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        int temp_product_id = 0;

        if (fip != null) {
            if (Objects.equals(fip.getFip_product(), "Petroleum")) {
                temp_product_id = 1;
            } else if (Objects.equals(fip.getFip_product(), "Kerosene")) {
                temp_product_id = 2;
            } else if (Objects.equals(fip.getFip_product(), "Diesel")) {
                temp_product_id = 3;
            }


            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO fip_table (fip_product_id,fip_day,fip_date,fip_month,fip_year,fip_value) VALUES(?,?,?,?,?,?) ");

                preparedStatement.setInt(1, temp_product_id);
                preparedStatement.setString(2, fip.getFip_day());
                preparedStatement.setInt(3, fip.getFip_date());
                preparedStatement.setString(4, fip.getFip_month());
                preparedStatement.setInt(5, fip.getFip_year());
                preparedStatement.setDouble(6, fip.getFip_value());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ObservableList<FIP> getFIPData() {
        ObservableList<FIP> fip = null;
        List<FIP> temp_fip = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM fip_table");

            while (resultSet.next()) {

                FIP temp_fip_value = new FIP(resultSet.getInt("fip_id"),
                        resultSet.getString("fip_day"),
                        resultSet.getInt("fip_date"),
                        resultSet.getString("fip_month"),
                        resultSet.getInt("fip_year"),
                        resultSet.getString("fip_product_id"),
                        resultSet.getDouble("fip_value"));
                temp_fip.add(temp_fip_value);
            }

            fip = FXCollections.observableArrayList(temp_fip);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fip;
    }

    @Override
    public void updateFIPData(FIP fip) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (fip != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("UPDATE fip_table SET fip_day='" + fip.getFip_day() + "'," +
                        "fip_date='" + fip.getFip_date() + "',fip_month='" + fip.getFip_month() + "'," +
                        "fip_year='" + fip.getFip_year() + "',fip_value ='" + fip.getFip_value() + "'," +
                        "fip_product='" + fip.getFip_product() + "' WHERE " +
                        "fip_day='" + fip.getFip_day() + "' AND fip_date='" + fip.getFip_date() + "'AND " +
                        "fip_month='" + fip.getFip_month() + "'AND fip_year='" + fip.getFip_year() + "' AND " +
                        "fip_product ='" + Integer.parseInt(fip.getFip_product()) + "'");
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getFIPValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        double fip_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT fip_value FROM fip_table " +
                    "WHERE fip_year='" + year + "' AND fip_month ='" + month + "' " +
                    "AND fip_product_id ='"+product_id+"'");

            while (resultSet.next()) {
                fip_value = resultSet.getDouble("fip_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fip_value;
    }

    @Override
    public int getFIPValueId(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int fip_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT fip_id FROM fip_table " +
                    "WHERE fip_year='" + year + "' AND fip_month ='" + month + "' " +
                    "AND fip_product_id ='" + product_id +"'");

            while (resultSet.next()) {
                fip_id = resultSet.getInt("fip_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fip_id;
    }

    @Override
    public ObservableList<ExchangeRate> searchFIPByAll(String day, int date, String month, int year) {
        return null;
    }

    @Override
    public ObservableList<ExchangeRate> searchFIPSearchArray(String search_array) {
        return null;
    }

    /**
     * FOBInterface Implementation
     * */
    @Override
    public void insertFOBData(FOB fob) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        int temp_product_id = 0;

        if (fob != null) {
            if (Objects.equals(fob.getFob_product(), "Petroleum")) {
                temp_product_id = 1;
            } else if (Objects.equals(fob.getFob_product(), "Kerosene")) {
                temp_product_id = 2;
            } else if (Objects.equals(fob.getFob_product(), "Diesel")) {
                temp_product_id = 3;
            }


            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO fob_table (fob_product_id,fob_day,fob_date,fob_month,fob_year,fob_value) VALUES(?,?,?,?,?,?) ");

                preparedStatement.setInt(1, temp_product_id);
                preparedStatement.setString(2, fob.getFob_day());
                preparedStatement.setInt(3, fob.getFob_date());
                preparedStatement.setString(4, fob.getFob_month());
                preparedStatement.setInt(5, fob.getFob_year());
                preparedStatement.setDouble(6, fob.getFob_value());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ObservableList<FOB> getFOBData() {
        ObservableList<FOB> fob = null;
        List<FOB> temp_fob = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM fob_table");

            while (resultSet.next()) {

                FOB temp_fob_value = new FOB(resultSet.getInt("fob_id"),
                        resultSet.getString("fob_day"),
                        resultSet.getInt("fob_date"),
                        resultSet.getString("fob_month"),
                        resultSet.getInt("fob_year"),
                        resultSet.getString("fob_product_id"),
                        resultSet.getDouble("fob_value"));
                temp_fob.add(temp_fob_value);
            }

            fob = FXCollections.observableArrayList(temp_fob);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fob;
    }

    @Override
    public double getFOBValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double fob_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT fob_value FROM fob_table WHERE fob_year='" + year + "' AND fob_month ='" + month + "' AND fob_product_id='" + product_id + "'");

            while (resultSet.next()) {
                fob_value = resultSet.getDouble("fob_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fob_value;
    }

    @Override
    public int getFOBValueId(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int fob_id = 0;
        int product_id = 0;


        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }

            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT fob_id FROM fob_table WHERE fob_year ='" + year + "'" +
                    " AND fob_month = '" + month + "' AND fob_product_id='" + product_id + "'");

            while (resultSet.next()) {
                fob_id = resultSet.getInt("fob_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fob_id;
    }

    @Override
    public void updateFOBData(ExchangeRate exchangeRate) {

    }

    @Override
    public ObservableList<ExchangeRate> searchFOBByAll(String day, int date, String month, int year) {
        return null;
    }

    @Override
    public ObservableList<ExchangeRate> searchFOBSearchArray(String search_array) {
        return null;
    }

    /**
     * WAA Conversion Factor Interfaces
     * */
    @Override
    public void insertWAAData(WAAConversionFactor waaConversionFactor) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO waa_conversion_factor_table (waa_conversion_factor_product_id,waa_conversion_factor_day,waa_conversion_factor_date,waa_conversion_factor_month,waa_conversion_factor_year,waa_conversion_factor_value) VALUES(?,?,?,?,?,?) ");

            preparedStatement.setInt(1, Integer.parseInt(waaConversionFactor.getWaac_product()));
            preparedStatement.setString(2, waaConversionFactor.getWaac_day());
            preparedStatement.setInt(3, waaConversionFactor.getWaac_date());
            preparedStatement.setString(4, waaConversionFactor.getWaac_month());
            preparedStatement.setInt(5, waaConversionFactor.getWaac_year());
            preparedStatement.setDouble(6, waaConversionFactor.getWaac_value());

            preparedStatement.execute();

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double getMonthWAADValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double waa_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT waa_conversion_factor_value FROM waa_conversion_factor_table " +
                    "WHERE waa_conversion_factor_year='" + year + "' AND waa_conversion_factor_month ='" + month + "' " +
                    "AND waa_conversion_factor_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                waa_value = resultSet.getDouble("waa_conversion_factor_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return waa_value;
    }

    @Override
    public int getWAADID(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int waa_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT waa_conversion_factor_id FROM waa_conversion_factor_table WHERE " +
                    "waa_conversion_factor_year ='" + year + "' AND waa_conversion_factor_month = '" + month + "' AND waa_conversion_factor_product_id = '" + product_id + "' ");

            while (resultSet.next()) {
                waa_id = resultSet.getInt("waa_conversion_factor_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return waa_id;
    }


    @Override
    public ObservableList<WAAConversionFactor> getWAAData() {
        ObservableList<WAAConversionFactor> waaConversionFactors = null;
        List<WAAConversionFactor> temp_waac = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM waa_conversion_factor_table");

            while (resultSet.next()) {

                WAAConversionFactor temp_waac_value = new WAAConversionFactor(resultSet.getInt("waa_conversion_factor_id"),
                        resultSet.getString("waa_conversion_factor_product_id"),
                        resultSet.getString("waa_conversion_factor_day"),
                        resultSet.getInt("waa_conversion_factor_date"),
                        resultSet.getString("waa_conversion_factor_month"),
                        resultSet.getInt("waa_conversion_factor_year"),
                        resultSet.getDouble("waa_conversion_factor_value"));
                temp_waac.add(temp_waac_value);
            }

            waaConversionFactors = FXCollections.observableArrayList(temp_waac);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return waaConversionFactors;
    }

    /**
     * Marking Cost Methods
     * */
    @Override
    public ObservableList<MarkingCost> getMarkingCostData() {
        ObservableList<MarkingCost> markingCosts = null;
        List<MarkingCost> temp_markingcost = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM petroleum_marking_cost_table");

            while (resultSet.next()) {

                MarkingCost temp_markingcost_value = new MarkingCost(resultSet.getInt("petroleum_marking_cost_id"),
                        resultSet.getString("petroleum_marking_cost_day"),
                        resultSet.getInt("petroleum_marking_cost_date"),
                        resultSet.getString("petroleum_marking_cost_month"),
                        resultSet.getInt("petroleum_marking_cost_year"),
                        resultSet.getInt("petroleum_marking_cost_exchangerate"),
                        resultSet.getDouble("petroleum_marking_cost_value"));
                temp_markingcost.add(temp_markingcost_value);
            }

            markingCosts = FXCollections.observableArrayList(temp_markingcost);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return markingCosts;
    }

    @Override
    public void insertMarkingCostData(MarkingCost markingCost) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (markingCost != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO petroleum_marking_cost_table (petroleum_marking_cost_day," +
                        "petroleum_marking_cost_date,petroleum_marking_cost_month,petroleum_marking_cost_year,petroleum_marking_cost_value,petroleum_marking_cost_exchangerate) VALUES(?,?,?,?,?,?) ");
                preparedStatement.setString(1, markingCost.getMarking_cost_day());
                preparedStatement.setInt(2, markingCost.getMarking_cost_date());
                preparedStatement.setString(3, markingCost.getMarking_cost_month());
                preparedStatement.setInt(4, markingCost.getMarking_cost_year());
                preparedStatement.setDouble(5, markingCost.getMarking_cost_value());
                preparedStatement.setDouble(6, markingCost.getMarking_cost_exchangerate());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getPetroleumMarkingCostMonthValue(String month, int year) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double marking_cost_value = 0.0;

        try {

            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT petroleum_marking_cost_value FROM petroleum_marking_cost_table " +
                    "WHERE petroleum_marking_cost_year='" + year + "' AND petroleum_marking_cost_month ='" + month + "'");

            while (resultSet.next()) {
                marking_cost_value = resultSet.getDouble("petroleum_marking_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return marking_cost_value;
    }

    /**
     * Weighted Average Platt FOB
     * */
    @Override
    public ObservableList<WeightPlattFOB> getWeightedAveragePlattFOBData() {
        ObservableList<WeightPlattFOB> weightPlattFOBs = null;
        List<WeightPlattFOB> temp_weightedPlattFOB = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM weighted_average_platt_fob_table");

            while (resultSet.next()) {

                WeightPlattFOB temp_weighted_value = new WeightPlattFOB(resultSet.getInt("weighted_average_platt_fob_id"),
                        resultSet.getInt("weighted_average_platt_fob_product_id"),
                        resultSet.getString("weighted_average_platt_fob_day"),
                        resultSet.getInt("weighted_average_platt_fob_date"),
                        resultSet.getString("weighted_average_platt_fob_month"),
                        resultSet.getInt("weighted_average_platt_fob_year"),
                        resultSet.getDouble("weighted_average_platt_fob_value"),
                        resultSet.getInt("weighted_average_platt_fob_exchangerate"),
                        resultSet.getInt("weighted_average_platt_fob_waa_conversion_factor"),
                        resultSet.getInt("weighted_average_platt_fob_current_fob")
                );
                temp_weightedPlattFOB.add(temp_weighted_value);
            }

            weightPlattFOBs = FXCollections.observableArrayList(temp_weightedPlattFOB);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return weightPlattFOBs;
    }

    @Override
    public void insertWeightedAveragePlattFOBData(WeightPlattFOB weightPlattFOB) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (weightPlattFOB != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO weighted_average_platt_fob_table (weighted_average_platt_fob_product_id," +
                        "weighted_average_platt_fob_day,weighted_average_platt_fob_date,weighted_average_platt_fob_month," +
                        "weighted_average_platt_fob_year,weighted_average_platt_fob_value,weighted_average_platt_fob_exchangerate," +
                        "weighted_average_platt_fob_waa_conversion_factor,weighted_average_platt_fob_current_fob) VALUES(?,?,?,?,?,?,?,?,?) ");
                preparedStatement.setInt(1, weightPlattFOB.getPlatt_fob_product_id());
                preparedStatement.setString(2, weightPlattFOB.getPlatt_fob_day());
                preparedStatement.setInt(3, weightPlattFOB.getPlatt_fob_date());
                preparedStatement.setString(4, weightPlattFOB.getPlatt_fob_month());
                preparedStatement.setInt(5, weightPlattFOB.getPlatt_fob_year());
                preparedStatement.setDouble(6, weightPlattFOB.getPlatt_fob_value());
                preparedStatement.setInt(7, weightPlattFOB.getPlatt_fob_exchangerate());
                preparedStatement.setInt(8, weightPlattFOB.getPlatt_fob_waa_conversion_factor());
                preparedStatement.setInt(9, weightPlattFOB.getPlatt_fob_current_fob_fk());
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getMonthWAPFOBValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double wap_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT weighted_average_platt_fob_value FROM weighted_average_platt_fob_table " +
                    "WHERE weighted_average_platt_fob_year='" + year + "' AND weighted_average_platt_fob_month ='" + month + "' " +
                    "AND weighted_average_platt_fob_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                wap_value = resultSet.getDouble("weighted_average_platt_fob_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wap_value;
    }

    @Override
    public int getWAPFOBID(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int wap_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT weighted_average_platt_fob_id FROM weighted_average_platt_fob_table WHERE " +
                    "weighted_average_platt_fob_year ='" + year + "' AND weighted_average_platt_fob_month = '" + month + "' AND " +
                    "weighted_average_platt_fob_product_id = '" + product_id + "' ");

            while (resultSet.next()) {
                wap_id = resultSet.getInt("weighted_average_platt_fob_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wap_id;
    }

    @Override
    public ArrayList<YearlyData> getYearlyWAPFOBValue(int year, String product) {
        ArrayList<YearlyData> weightPlattFOB = null;
        ArrayList<YearlyData> temp_weightedPlattFOB = new ArrayList<>();
        Connection connection = null;
        int product_id =0;
        Statement statement;
        ResultSet resultSet;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM weighted_average_platt_fob_table WHERE weighted_average_platt_fob_product_id ='"+ product_id +"'");

            while (resultSet.next()) {

                YearlyData temp_weighted_value = new YearlyData(
                        resultSet.getString("weighted_average_platt_fob_month"),
                        resultSet.getDouble("weighted_average_platt_fob_value")
                );
                temp_weightedPlattFOB.add(temp_weighted_value);
            }

            weightPlattFOB = temp_weightedPlattFOB;

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return weightPlattFOB;
    }

    /**
     * Weighted Average Premium as Per Quotation (Freight + Insurance + Premium)
     * */
    @Override
    public ObservableList<WeightPlattFIP> getWeightedAveragePlattFIPData() {
        ObservableList<WeightPlattFIP> weightPlattFIPs = null;
        List<WeightPlattFIP> temp_weightedPlattFIP = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM weighted_average_premium_quatation_table");

            while (resultSet.next()) {

                WeightPlattFIP temp_weighted_value = new WeightPlattFIP(resultSet.getInt("weighted_average_premium_quatation_id"),
                        resultSet.getInt("weighted_average_premium_quatation_product_id"),
                        resultSet.getString("weighted_average_premium_quatation_day"),
                        resultSet.getInt("weighted_average_premium_quatation_date"),
                        resultSet.getString("weighted_average_premium_quatation_month"),
                        resultSet.getInt("weighted_average_premium_quatation_year"),
                        resultSet.getDouble("weighted_average_premium_quatation_value"),
                        resultSet.getInt("weighted_average_premium_quatation_exchangerate"),
                        resultSet.getInt("weighted_average_premium_quatation_waa_conversion_factor"),
                        resultSet.getInt("weighted_average_premium_quatation_current_fip")
                );
                temp_weightedPlattFIP.add(temp_weighted_value);
            }

            weightPlattFIPs = FXCollections.observableArrayList(temp_weightedPlattFIP);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return weightPlattFIPs;
    }

    @Override
    public void insertWeightedAveragePlattFIPData(WeightPlattFIP weightPlattFIP) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (weightPlattFIP != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO weighted_average_premium_quatation_table (weighted_average_premium_quatation_product_id," +
                        "weighted_average_premium_quatation_day,weighted_average_premium_quatation_date,weighted_average_premium_quatation_month," +
                        "weighted_average_premium_quatation_year,weighted_average_premium_quatation_value,weighted_average_premium_quatation_exchangerate," +
                        "weighted_average_premium_quatation_waa_conversion_factor,weighted_average_premium_quatation_current_fip) VALUES(?,?,?,?,?,?,?,?,?) ");
                preparedStatement.setInt(1, weightPlattFIP.getPlatt_fip_product_id());
                preparedStatement.setString(2, weightPlattFIP.getPlatt_fip_day());
                preparedStatement.setInt(3, weightPlattFIP.getPlatt_fip_date());
                preparedStatement.setString(4, weightPlattFIP.getPlatt_fip_month());
                preparedStatement.setInt(5, weightPlattFIP.getPlatt_fip_year());
                preparedStatement.setDouble(6, weightPlattFIP.getPlatt_fip_value());
                preparedStatement.setInt(7, weightPlattFIP.getPlatt_fip_exchangerate());
                preparedStatement.setInt(8, weightPlattFIP.getPlatt_fip_waa_conversion_factor());
                preparedStatement.setInt(9, weightPlattFIP.getPlatt_fip_current_fip_fk());
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getMonthWPFIPValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double wp_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT weighted_average_premium_quatation_value FROM weighted_average_premium_quatation_table " +
                    "WHERE weighted_average_premium_quatation_year='" + year + "' AND weighted_average_premium_quatation_month ='" + month + "' " +
                    "AND weighted_average_premium_quatation_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                wp_value = resultSet.getDouble("weighted_average_premium_quatation_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wp_value;
    }

    @Override
    public int getWPFIPID(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int wp_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT weighted_average_premium_quatation_id FROM weighted_average_premium_quatation_table " +
                    "WHERE weighted_average_premium_quatation_year='" + year + "' AND weighted_average_premium_quatation_month ='" + month + "' " +
                    "AND weighted_average_premium_quatation_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                wp_id = resultSet.getInt("weighted_average_premium_quatation_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wp_id;
    }

    /**
     * Wharfage VAT
     * */
    @Override
    public ObservableList<Wharfage> getWharfageData() {
        ObservableList<Wharfage> wharfage = null;
        List<Wharfage> temp_wharfage = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM wharfage_vat_table");

            while (resultSet.next()) {

                Wharfage wharfage_temp = new Wharfage(resultSet.getInt("wharfage_vat_id"),
                        resultSet.getInt("wharfage_vat_product_id"),
                        resultSet.getString("wharfage_vat_day"),
                        resultSet.getInt("wharfage_vat_date"),
                        resultSet.getString("wharfage_vat_month"),
                        resultSet.getInt("wharfage_vat_year"),
                        resultSet.getDouble("wharfage_vat_value"),
                        resultSet.getInt("wharfage_vat_exchangerate"),
                        resultSet.getInt("wharfage_vat_waa_conversion_factor")
                );
                temp_wharfage.add(wharfage_temp);
            }

            wharfage = FXCollections.observableArrayList(temp_wharfage);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wharfage;
    }

    @Override
    public void insertWharfageData(Wharfage wharfage) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (wharfage != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO wharfage_vat_table (wharfage_vat_product_id," +
                        "wharfage_vat_day,wharfage_vat_date,wharfage_vat_month," +
                        "wharfage_vat_year,wharfage_vat_value,wharfage_vat_exchangerate," +
                        "wharfage_vat_waa_conversion_factor) VALUES(?,?,?,?,?,?,?,?) ");
                preparedStatement.setInt(1, wharfage.getWharfage_product_id());
                preparedStatement.setString(2, wharfage.getWharfage_day());
                preparedStatement.setInt(3, wharfage.getWharfage_date());
                preparedStatement.setString(4, wharfage.getWharfage_month());
                preparedStatement.setInt(5, wharfage.getWharfage_year());
                preparedStatement.setDouble(6, wharfage.getWharfage_value());
                preparedStatement.setInt(7, wharfage.getWharfage_exchangerate());
                preparedStatement.setInt(8, wharfage.getWharfage_waa_conversion_factor());
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getWharfageMonthValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        double wharfage_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT wharfage_vat_value FROM wharfage_vat_table " +
                    "WHERE wharfage_vat_year='" + year + "' AND wharfage_vat_month ='" + month + "' " +
                    "AND wharfage_vat_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                wharfage_value = resultSet.getDouble("wharfage_vat_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wharfage_value;
    }

    /**
     * Wholesale Price Cap
     * */
    @Override
    public ObservableList<WholeSalePriceCap> getWholesalePriceCapData() {
        return null;
    }

    @Override
    public void insertWholeSalesPriceCapData(WholeSalePriceCap wholeSalePriceCap) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (wholeSalePriceCap != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO wholesales_price_table (wholesales_price_product_id," +
                        "wholesales_price_day,wholesales_price_date,wholesales_price_month," +
                        "wholesales_price_year,wholesales_price_value) VALUES(?,?,?,?,?,?) ");
                preparedStatement.setInt(1, wholeSalePriceCap.getWholesales_product_id());
                preparedStatement.setString(2, wholeSalePriceCap.getWholesales_day());
                preparedStatement.setInt(3, wholeSalePriceCap.getWholesales_date());
                preparedStatement.setString(4, wholeSalePriceCap.getWholesales_month());
                preparedStatement.setInt(5, wholeSalePriceCap.getWholesales_year());
                preparedStatement.setDouble(6, wholeSalePriceCap.getWholesales_value());
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getWholeSalePriceCapValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double wholesale_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT wholesales_price_value FROM wholesales_price_table WHERE " +
                    "wholesales_price_year='" + year + "' AND wholesales_price_month ='" + month + "' AND wholesales_price_product_id='" + product_id + "'");

            while (resultSet.next()) {
                wholesale_value = resultSet.getDouble("wholesales_price_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wholesale_value;
    }

    @Override
    public int getWholeSalePriceCapValueId(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int wholesale_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT wholesales_price_id FROM wholesales_price_table WHERE " +
                    "wholesales_price_year ='" + year + "' AND wholesales_price_month = '" + month + "' AND wholesales_price_product_id = '" + product_id + "' ");

            while (resultSet.next()) {
                wholesale_id = resultSet.getInt("wholesales_price_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wholesale_id;
    }

    /**
     * Retailers Margin
     * */
    @Override
    public double getRetailersMarginValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double retailers_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT retailers_margin_value FROM retailers_margin_table WHERE " +
                    "retailers_margin_year='" + year + "' AND retailers_margin_month ='" + month + "' AND retailers_margin_product_id='" + product_id + "'");

            while (resultSet.next()) {
                retailers_value = resultSet.getDouble("retailers_margin_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retailers_value;
    }

    /**
     * Transport Charges
     * */
    @Override
    public double getTransportChargesValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double transport_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT transport_charges_value FROM transport_charges_table WHERE " +
                    "transport_charges_year='" + year + "' AND transport_charges_month ='" + month + "' AND transport_charges_product_id='" + product_id + "'");

            while (resultSet.next()) {
                transport_value = resultSet.getDouble("transport_charges_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return transport_value;
    }

    /**
     * Charges payable to other Local Authorities and Executive Agencies
     * */
    @Override
    public double getChargePayabletoLocalAgence(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double charge_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT charges_payableto_local_agencies_value FROM charges_payableto_local_agencies_table WHERE " +
                    "charges_payableto_local_agencies_year='" + year + "' AND charges_payableto_local_agencies_month ='" + month + "' AND charges_payableto_local_agencies_product_id='" + product_id + "'");

            while (resultSet.next()) {
                charge_value = resultSet.getDouble("charges_payableto_local_agencies_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return charge_value;
    }

    /**
     * OMC's Overheads & Margins
     * */
    @Override
    public double getOMCOverheadsMarginValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double omc_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT omc_overheads_margins_value FROM omc_overheads_margins_table WHERE " +
                    "omc_overheads_margins_year='" + year + "' AND omc_overheads_margins_month ='" + month + "' AND omc_overheads_margins_product_id='" + product_id + "'");

            while (resultSet.next()) {
                omc_value = resultSet.getDouble("omc_overheads_margins_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return omc_value;
    }

    /**
     *Exercise Duty
     * */
    @Override
    public double getExerciseDutyValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double exercise_duty_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT exrcise_duty_value FROM exrcise_duty_table WHERE " +
                    "exrcise_duty_year='" + year + "' AND exrcise_duty_month ='" + month + "' AND exrcise_duty_product_id='" + product_id + "'");

            while (resultSet.next()) {
                exercise_duty_value = resultSet.getDouble("exrcise_duty_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exercise_duty_value;
    }

    /**
     * Fuel Levy
     * */
    @Override
    public double getFuelLevyValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double fuel_levy_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT fuel_levy_value FROM fuel_levy_table WHERE " +
                    "fuel_levy_year='" + year + "' AND fuel_levy_month ='" + month + "' AND fuel_levy_product_id='" + product_id + "'");

            while (resultSet.next()) {
                fuel_levy_value = resultSet.getDouble("fuel_levy_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fuel_levy_value;
    }

    /**
     * Petroleum Fee
     * */
    @Override
    public double getPetroleumFeeValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double petroleum_fee_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT petroleum_fee_value FROM petroleum_fee_table WHERE " +
                    "petroleum_fee_year='" + year + "' AND petroleum_fee_month ='" + month + "' AND petroleum_fee_product_id='" + product_id + "'");

            while (resultSet.next()) {
                petroleum_fee_value = resultSet.getDouble("petroleum_fee_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return petroleum_fee_value;
    }

    /**
     * Custom Processing Fee*/
    @Override
    public double geCustomProcessingFeeValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double processing_fee_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT custom_processing_fee_value FROM custom_processing_fee_table WHERE " +
                    "custom_processing_fee_year='" + year + "' AND custom_processing_fee_month ='" + month + "' AND custom_processing_fee_product_id='" + product_id + "'");

            while (resultSet.next()) {
                processing_fee_value = resultSet.getDouble("custom_processing_fee_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return processing_fee_value;
    }

    /**
     * Evaporation Losses
     * */
    @Override
    public double getEvaporationLossesValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double evaporation_loss_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT evaporation_losses_value FROM evaporation_losses_table WHERE " +
                    "evaporation_losses_year='" + year + "' AND evaporation_losses_month ='" + month + "' AND evaporation_losses_product_id='" + product_id + "'");

            while (resultSet.next()) {
                evaporation_loss_value = resultSet.getDouble("evaporation_losses_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return evaporation_loss_value;
    }

    /**
     * Financing Cost
     * */
    @Override
    public double getFinancingCostValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double financing_cost_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT financing_cost_value FROM financing_cost_table WHERE " +
                    "financing_cost_year='" + year + "' AND financing_cost_month ='" + month + "' AND financing_cost_product_id='" + product_id + "'");

            while (resultSet.next()) {
                financing_cost_value = resultSet.getDouble("financing_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return financing_cost_value;
    }

    /**
     * Regulatory Levy
     * */
    @Override
    public double getRegulatoryLevyValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double regulatory_levy_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT regulatory_levy_value FROM regulatory_levy_table WHERE " +
                    "regulatory_levy_year='" + year + "' AND regulatory_levy_month ='" + month + "' AND regulatory_levy_product_id='" + product_id + "'");

            while (resultSet.next()) {
                regulatory_levy_value = resultSet.getDouble("regulatory_levy_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return regulatory_levy_value;
    }

    /**
     * TBS Charge Value
     * */
    @Override
    public double getTBSChargeValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double tbs_charge_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT tbs_charge_value FROM tbs_charge_table WHERE " +
                    "tbs_charge_year='" + year + "' AND tbs_charge_month ='" + month + "' AND tbs_charge_product_id='" + product_id + "'");

            while (resultSet.next()) {
                tbs_charge_value = resultSet.getDouble("tbs_charge_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tbs_charge_value;
    }

    /**
     * Tiper Fee
     * */
    @Override
    public double getTiperFeeValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double tiper_fee_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT tiper_fee_value FROM tiper_fee_table WHERE " +
                    "tiper_fee_year='" + year + "' AND tiper_fee_month ='" + month + "' AND tiper_fee_product_id='" + product_id + "'");

            while (resultSet.next()) {
                tiper_fee_value = resultSet.getDouble("tiper_fee_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tiper_fee_value;
    }

    /***
     * Weight and Measures Fee
     */
    @Override
    public double getWeightMeasureFeeValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double weight_measure_fee_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT weight_measures_fee_value FROM weight_measures_fee_table WHERE " +
                    "weight_measures_fee_year='" + year + "' AND weight_measures_fee_month ='" + month + "' AND weight_measures_fee_product_id='" + product_id + "'");

            while (resultSet.next()) {
                weight_measure_fee_value = resultSet.getDouble("weight_measures_fee_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return weight_measure_fee_value;
    }

    /**
     * CIF Cost in Dar Es Salaam
     */
    @Override
    public ObservableList<CIFCostDaresSalaamStatic> getCIFCostDaresSalaamData() {
        ObservableList<CIFCostDaresSalaamStatic> cifCostDaresSalaamStatics = null;
        List<CIFCostDaresSalaamStatic> temp_cif = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM cif_cost_dsm_table");

            while (resultSet.next()) {

                CIFCostDaresSalaamStatic cifCostDaresSalaamStatics_temp = new CIFCostDaresSalaamStatic(resultSet.getInt("cif_cost_dsm_id"),
                        resultSet.getInt("cif_cost_dsm_product_id"),
                        resultSet.getString("cif_cost_dsm_day"),
                        resultSet.getInt("cif_cost_dsm_date"),
                        resultSet.getString("cif_cost_dsm_month"),
                        resultSet.getInt("cif_cost_dsm_year"),
                        resultSet.getDouble("cif_cost_dsm_value"),
                        resultSet.getInt("cif_cost_dsm_weighted_average_plat_fop"),
                        resultSet.getInt("cif_cost_dsm_wa_premium_quatation")
                );
                temp_cif.add(cifCostDaresSalaamStatics_temp);
            }

            cifCostDaresSalaamStatics = FXCollections.observableArrayList(temp_cif);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cifCostDaresSalaamStatics;
    }

    @Override
    public void insertCIFCostDaresSalaamData(CIFCostDaresSalaamStatic cifCostDaresSalaamStatic) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        if (cifCostDaresSalaamStatic != null) {
            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO cif_cost_dsm_table (cif_cost_dsm_product_id," +
                        "cif_cost_dsm_day,cif_cost_dsm_date,cif_cost_dsm_month," +
                        "cif_cost_dsm_year,cif_cost_dsm_value,cif_cost_dsm_weighted_average_plat_fop," +
                        "cif_cost_dsm_wa_premium_quatation) VALUES(?,?,?,?,?,?,?,?) ");
                preparedStatement.setInt(1, cifCostDaresSalaamStatic.getCif_cost_dsm_product_id());
                preparedStatement.setString(2, cifCostDaresSalaamStatic.getCif_cost_dsm_day());
                preparedStatement.setInt(3, cifCostDaresSalaamStatic.getCif_cost_dsm_date());
                preparedStatement.setString(4, cifCostDaresSalaamStatic.getCif_cost_dsm_month());
                preparedStatement.setInt(5, cifCostDaresSalaamStatic.getCif_cost_dsm_year());
                preparedStatement.setDouble(6, cifCostDaresSalaamStatic.getCif_cost_dsm_value());
                preparedStatement.setInt(7, cifCostDaresSalaamStatic.getCif_cost_dsm_weighted_average_plat_fob());
                preparedStatement.setInt(8, cifCostDaresSalaamStatic.getCif_cost_dsm_wa_premium_quatation());
                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public double getCIFCostDaresSalaamValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double cif_value = 0.0;
        int product_id = 0;

        try {

            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT cif_cost_dsm_value FROM cif_cost_dsm_table WHERE " +
                    "cif_cost_dsm_year='" + year + "' AND cif_cost_dsm_month ='" + month + "' AND cif_cost_dsm_product_id='" + product_id + "'");

            while (resultSet.next()) {
                cif_value = resultSet.getDouble("cif_cost_dsm_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cif_value;
    }

    /**
     * Actual Tender Rate
     */
    @Override
    public void insertActualTenderRateValue(ActualTenderRateStatic actualTenderRateStatic) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO atr_vessel_cost_table (atr_vessel_cost_product_id,atr_vessel_cost_day," +
                    "atr_vessel_cost_date,atr_vessel_cost_month,atr_vessel_cost_year,atr_vessel_type,atr_vessel_cost_value) VALUES(?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, actualTenderRateStatic.getActual_tender_rate_product_id());
            preparedStatement.setString(2, actualTenderRateStatic.getActual_tender_rate_day());
            preparedStatement.setInt(3, actualTenderRateStatic.getActual_tender_rate_date());
            preparedStatement.setString(4, actualTenderRateStatic.getActual_tender_rate_month());
            preparedStatement.setInt(5, actualTenderRateStatic.getActual_tender_rate_year());
            preparedStatement.setString(6, actualTenderRateStatic.getActual_tender_rate_type());
            preparedStatement.setDouble(7, actualTenderRateStatic.getActual_tender_rate_value());

            preparedStatement.execute();

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ObservableList<ActualTenderRateStatic> getActualTenderRateValues() {
        ObservableList<ActualTenderRateStatic> actualTenderRateStatics = null;
        List<ActualTenderRateStatic> temp_actualTenderRate = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM atr_vessel_cost_table");

            while (resultSet.next()) {

                ActualTenderRateStatic temp_actual_value = new ActualTenderRateStatic(resultSet.getInt("atr_vessel_cost_id"),
                        resultSet.getInt("atr_vessel_cost_product_id"),
                        resultSet.getString("atr_vessel_cost_day"),
                        resultSet.getInt("atr_vessel_cost_date"),
                        resultSet.getString("atr_vessel_cost_month"),
                        resultSet.getInt("atr_vessel_cost_year"),
                        resultSet.getString("atr_vessel_type"),
                        resultSet.getDouble("atr_vessel_cost_value")
                );
                temp_actualTenderRate.add(temp_actual_value);
            }

            actualTenderRateStatics = FXCollections.observableArrayList(temp_actualTenderRate);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return actualTenderRateStatics;
    }

    @Override
    public int getActualTenderRateValueId(String month, int year, String product, String vesselType) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int atr_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT atr_vessel_cost_id FROM atr_vessel_cost_table " +
                    "WHERE atr_vessel_cost_year='" + year + "' AND atr_vessel_cost_month ='" + month + "' " +
                    "AND atr_vessel_cost_product_id = '" + product_id + "' AND atr_vessel_type ='" + vesselType + "'");

            while (resultSet.next()) {
                atr_id = resultSet.getInt("atr_vessel_cost_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atr_id;
    }

    @Override
    public double getActualTenderRateValue(String month, int year, String product, String vesselType) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double atr_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT atr_vessel_cost_value FROM atr_vessel_cost_table " +
                    "WHERE atr_vessel_cost_year='" + year + "' AND atr_vessel_cost_month ='" + month + "' " +
                    "AND atr_vessel_cost_product_id = '" + product_id + "' AND atr_vessel_type ='" + vesselType + "'");

            while (resultSet.next()) {
                atr_value = resultSet.getDouble("atr_vessel_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atr_value;
    }

    /**
     * Actual Demurrage Factor
     */
    @Override
    public void insertActualTenderRateValue(ActualDemurrageFactorStatic actualTenderRateStatic) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO df_vessel_cost_table (df_vessel_cost_product_id,df_vessel_cost_day," +
                    "df_vessel_cost_date,df_vessel_cost_month,df_vessel_cost_year,df_vessel_type,df_vessel_cost_value) VALUES(?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, actualTenderRateStatic.getActual_demurrage_cost_product_id());
            preparedStatement.setString(2, actualTenderRateStatic.getActual_demurrage_cost_day());
            preparedStatement.setInt(3, actualTenderRateStatic.getActual_demurrage_cost_date());
            preparedStatement.setString(4, actualTenderRateStatic.getActual_demurrage_cost_month());
            preparedStatement.setInt(5, actualTenderRateStatic.getActual_demurrage_cost_year());
            preparedStatement.setString(6, actualTenderRateStatic.getActual_demurrage_cost_type());
            preparedStatement.setDouble(7, actualTenderRateStatic.getActual_demurrage_cost_value());

            preparedStatement.execute();

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ObservableList<ActualDemurrageFactorStatic> getActualDemurrageFactorValues() {
        ObservableList<ActualDemurrageFactorStatic> actualDemurrageFactors = null;
        List<ActualDemurrageFactorStatic> temp_actualDemurrageFactor = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM df_vessel_cost_table");

            while (resultSet.next()) {

                ActualDemurrageFactorStatic temp_actual_value = new ActualDemurrageFactorStatic(resultSet.getInt("df_vessel_cost_id"),
                        resultSet.getInt("df_vessel_cost_product_id"),
                        resultSet.getString("df_vessel_cost_day"),
                        resultSet.getInt("df_vessel_cost_date"),
                        resultSet.getString("df_vessel_cost_month"),
                        resultSet.getInt("df_vessel_cost_year"),
                        resultSet.getString("df_vessel_type"),
                        resultSet.getDouble("df_vessel_cost_value")
                );
                temp_actualDemurrageFactor.add(temp_actual_value);
            }

            actualDemurrageFactors = FXCollections.observableArrayList(temp_actualDemurrageFactor);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return actualDemurrageFactors;
    }

    @Override
    public double getActualDemurrageFactorValue(String month, int year, String Product, String vesselType) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double adc_value = 0.0;
        int product_id = 0;

        try {
            if (Product == "Petroleum") {
                product_id = 1;

            } else if (Product == "Diesel") {
                product_id = 3;
            } else if (Product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT df_vessel_cost_value FROM df_vessel_cost_table " +
                    "WHERE df_vessel_cost_year='" + year + "' AND df_vessel_cost_month ='" + month + "' " +
                    "AND df_vessel_cost_product_id = '" + product_id + "' AND df_vessel_type ='" + vesselType + "'");

            while (resultSet.next()) {
                adc_value = resultSet.getDouble("df_vessel_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adc_value;
    }

    @Override
    public int getActualDemurrageFactorId(String month, int year, String Product, String vesselType) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int adc_int = 0;
        int product_id = 0;

        try {
            if (Product == "Petroleum") {
                product_id = 1;

            } else if (Product == "Diesel") {
                product_id = 3;
            } else if (Product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT df_vessel_cost_id FROM df_vessel_cost_table " +
                    "WHERE df_vessel_cost_year='" + year + "' AND df_vessel_cost_month ='" + month + "' " +
                    "AND df_vessel_cost_product_id = '" + product_id + "' AND df_vessel_type ='" + vesselType + "'");

            while (resultSet.next()) {
                adc_int = resultSet.getInt("df_vessel_cost_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adc_int;
    }

    /**
     *Surveyor Cost*/
    @Override
    public void insertSurveyorCostData(SurveyorCostStatic surveyorCostStatic) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        int temp_product_id = 0;

        if (surveyorCostStatic != null) {
            if (Objects.equals(surveyorCostStatic.getSurveyors_cost_product_id(), "Petroleum")) {
                temp_product_id = 1;
            } else if (Objects.equals(surveyorCostStatic.getSurveyors_cost_product_id(), "Kerosene")) {
                temp_product_id = 2;
            } else if (Objects.equals(surveyorCostStatic.getSurveyors_cost_product_id(), "Diesel")) {
                temp_product_id = 3;
            }


            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO surveyors_cost_table (" +
                        "surveyors_cost_product_id,surveyors_cost_day,surveyors_cost_date,surveyors_cost_month," +
                        "surveyors_cost_year,surveyors_cost_value,surveyors_cost_exchangerate," +
                        "surveyors_cost_waa_conversion_factor,surveyors_cost_atr_small,surveyors_cost_atr_big" +
                        ") VALUES(?,?,?,?,?,?,?,?,?,?) ");

                preparedStatement.setInt(1, surveyorCostStatic.getSurveyors_cost_product_id());
                preparedStatement.setString(2, surveyorCostStatic.getSurveyors_cost_day());
                preparedStatement.setInt(3, surveyorCostStatic.getSurveyors_cost_date());
                preparedStatement.setString(4, surveyorCostStatic.getSurveyors_cost_month());
                preparedStatement.setInt(5, surveyorCostStatic.getSurveyors_cost_year());
                preparedStatement.setDouble(6, surveyorCostStatic.getSurveyors_cost_value());
                preparedStatement.setInt(7,surveyorCostStatic.getSurveyors_cost_exchangerate());
                preparedStatement.setInt(8,surveyorCostStatic.getSurveyors_cost_waa_conversion_factor());
                preparedStatement.setInt(9,surveyorCostStatic.getSurveyors_cost_actual_tender_rate_small_vessel());
                preparedStatement.setInt(10,surveyorCostStatic.getSurveyors_cost_actual_tender_rate_big_vessel());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ObservableList<SurveyorCostStatic> getSurveyorCostData() {
        ObservableList<SurveyorCostStatic> surveyorCostStatics = null;
        List<SurveyorCostStatic> temp_surveyorCostStatics = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM surveyors_cost_table");

            while (resultSet.next()) {

                SurveyorCostStatic temp_actual_value = new SurveyorCostStatic(resultSet.getInt("surveyors_cost_id"),
                        resultSet.getInt("surveyors_cost_product_id"),
                        resultSet.getString("surveyors_cost_day"),
                        resultSet.getInt("surveyors_cost_date"),
                        resultSet.getString("surveyors_cost_month"),
                        resultSet.getInt("surveyors_cost_year"),
                        resultSet.getDouble("surveyors_cost_value"),
                        resultSet.getInt("surveyors_cost_exchangerate"),
                        resultSet.getInt("surveyors_cost_waa_conversion_factor"),
                        resultSet.getInt("surveyors_cost_atr_small"),
                        resultSet.getInt("surveyors_cost_atr_big")
                );
                temp_surveyorCostStatics.add(temp_actual_value);
            }

            surveyorCostStatics = FXCollections.observableArrayList(temp_surveyorCostStatics);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return surveyorCostStatics;
    }

    @Override
    public double getSurveyorCostValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double cost_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT surveyors_cost_value FROM surveyors_cost_table " +
                    "WHERE surveyors_cost_year='" + year + "' AND surveyors_cost_month ='" + month + "' " +
                    "AND surveyors_cost_product_id = '" + product_id+"'");

            while (resultSet.next()) {
                cost_value = resultSet.getDouble("surveyors_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost_value;
    }

    @Override
    public int getSurveyorCostValueId(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int cost_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT surveyors_cost_id FROM surveyors_cost_table " +
                    "WHERE surveyors_cost_year='" + year + "' AND surveyors_cost_month ='" + month + "' " +
                    "AND surveyors_cost_product_id = '" + product_id);

            while (resultSet.next()) {
                cost_id = resultSet.getInt("surveyors_cost_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost_id;
    }

    /**
     * Actual Demurrage Cost*/
    @Override
    public void insertActualDemurrageCostData(ActualDemurrageCostStatic actualDemurrageCostStatic) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        int temp_product_id = 0;

        if (actualDemurrageCostStatic != null) {
            if (Objects.equals(actualDemurrageCostStatic.getActual_demurrage_cost_product_id(), "Petroleum")) {
                temp_product_id = 1;
            } else if (Objects.equals(actualDemurrageCostStatic.getActual_demurrage_cost_product_id(), "Kerosene")) {
                temp_product_id = 2;
            } else if (Objects.equals(actualDemurrageCostStatic.getActual_demurrage_cost_product_id(), "Diesel")) {
                temp_product_id = 3;
            }


            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO actual_demurrage_cost_table (" +
                        "actual_demurrage_cost_product_id,actual_demurrage_cost_day,actual_demurrage_cost_date,actual_demurrage_cost_month," +
                        "actual_demurrage_cost_year,actual_demurrage_cost_value,actual_demurrage_cost_exchangerate," +
                        "actual_demurrage_cost_waa_conversion_factor,actual_demurrage_cost_atr_small,actual_demurrage_cost_atr_big" +
                        ") VALUES(?,?,?,?,?,?,?,?,?,?) ");

                preparedStatement.setInt(1, actualDemurrageCostStatic.getActual_demurrage_cost_product_id());
                preparedStatement.setString(2, actualDemurrageCostStatic.getActual_demurrage_cost_day());
                preparedStatement.setInt(3, actualDemurrageCostStatic.getActual_demurrage_cost_date());
                preparedStatement.setString(4, actualDemurrageCostStatic.getActual_demurrage_cost_month());
                preparedStatement.setInt(5, actualDemurrageCostStatic.getActual_demurrage_cost_year());
                preparedStatement.setDouble(6, actualDemurrageCostStatic.getActual_demurrage_cost_value());
                preparedStatement.setInt(7,actualDemurrageCostStatic.getActual_demurrage_cost_exchangerate());
                preparedStatement.setInt(8,actualDemurrageCostStatic.getActual_demurrage_cost_waa_conversion_factor());
                preparedStatement.setInt(9,actualDemurrageCostStatic.getActual_demurrage_cost_actual_demurrage_factor_small_vessel());
                preparedStatement.setInt(10,actualDemurrageCostStatic.getActual_demurrage_cost_actual_demurrage_factor_big_vessel());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ObservableList<ActualDemurrageCostStatic> getActualDemurrageCostData() {
        ObservableList<ActualDemurrageCostStatic> actualDemurrageCostStatics = null;
        List<ActualDemurrageCostStatic> temp_actualDemurrageCostStatic = new ArrayList<>();
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM actual_demurrage_cost_table");

            while (resultSet.next()) {

                ActualDemurrageCostStatic temp_actual_value = new ActualDemurrageCostStatic(resultSet.getInt("actual_demurrage_cost_id"),
                        resultSet.getInt("actual_demurrage_cost_product_id"),
                        resultSet.getString("actual_demurrage_cost_day"),
                        resultSet.getInt("actual_demurrage_cost_date"),
                        resultSet.getString("actual_demurrage_cost_month"),
                        resultSet.getInt("actual_demurrage_cost_year"),
                        resultSet.getDouble("actual_demurrage_cost_value"),
                        resultSet.getInt("actual_demurrage_cost_exchangerate"),
                        resultSet.getInt("actual_demurrage_cost_waa_conversion_factor"),
                        resultSet.getInt("actual_demurrage_cost_atr_small"),
                        resultSet.getInt("actual_demurrage_cost_atr_big")
                );
                temp_actualDemurrageCostStatic.add(temp_actual_value);
            }

            actualDemurrageCostStatics = FXCollections.observableArrayList(temp_actualDemurrageCostStatic);

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return actualDemurrageCostStatics;
    }

    @Override
    public double getActualDemurrageCostValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        Double cost_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT actual_demurrage_cost_value FROM actual_demurrage_cost_table " +
                    "WHERE actual_demurrage_cost_year='" + year + "' AND actual_demurrage_cost_month ='" + month + "' " +
                    "AND actual_demurrage_cost_product_id = '" + product_id + "'");

            while (resultSet.next()) {
                cost_value = resultSet.getDouble("actual_demurrage_cost_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost_value;
    }

    @Override
    public int getActualDemurrageCostValueId(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        int cost_id = 0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT actual_demurrage_cost_id FROM actual_demurrage_cost_table " +
                    "WHERE actual_demurrage_cost_year='" + year + "' AND actual_demurrage_cost_month ='" + month + "' " +
                    "AND actual_demurrage_cost_product_id = '" + product_id+"'");

            while (resultSet.next()) {
                cost_id = resultSet.getInt("actual_demurrage_cost_id");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost_id;
    }

    /**
     * Pump Price Cap */
    @Override
    public void insertPumpPriceCapData(PumpPriceCap pumpPriceCap) {
        Connection connection = null;
        PreparedStatement preparedStatement;

            try {
                connection = ConnectionConfiguration.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO pump_price_cap_dsm_table (" +
                        "pump_price_cap_dsm_product_id,pump_price_cap_dsm_day,pump_price_cap_dsm_date," +
                        "pump_price_cap_dsm_month,pump_price_cap_dsm_year,pump_price_cap_dsm_value) VALUES(?,?,?,?,?,?) ");

                preparedStatement.setInt(1, pumpPriceCap.getPump_price_cap_product_id());
                preparedStatement.setString(2, pumpPriceCap.getPump_price_cap_day());
                preparedStatement.setInt(3, pumpPriceCap.getPump_price_cap_date());
                preparedStatement.setString(4, pumpPriceCap.getPump_price_month());
                preparedStatement.setInt(5, pumpPriceCap.getPump_price_cap_year());
                preparedStatement.setDouble(6, pumpPriceCap.getPump_price_cap_value());

                preparedStatement.execute();

            } catch (Exception sql_exception) {
                sql_exception.printStackTrace();

            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    @Override
    public double getPumpPriceCapValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        double price_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT pump_price_cap_dsm_value FROM pump_price_cap_dsm_table " +
                    "WHERE pump_price_cap_dsm_year='" + year + "' AND pump_price_cap_dsm_month ='" + month + "' " +
                    "AND pump_price_cap_dsm_product_id = '" + product_id +"'");

            while (resultSet.next()) {
                price_value = resultSet.getDouble("pump_price_cap_dsm_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return price_value;
    }

    /**Government Taxes*/
    @Override
    public void insertGovernmentTaxesData(GovernmentTaxes governmentTaxes) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO government_taxes_table (" +
                    "government_taxes_product_id,government_taxes_day,government_taxes_date," +
                    "government_taxes_month,government_taxes_year,government_taxes_value) VALUES(?,?,?,?,?,?) ");

            preparedStatement.setInt(1, governmentTaxes.getGovernment_tax_product_id());
            preparedStatement.setString(2, governmentTaxes.getGovernment_tax_day());
            preparedStatement.setInt(3, governmentTaxes.getGovernment_tax_date());
            preparedStatement.setString(4, governmentTaxes.getGovernment_tax_month());
            preparedStatement.setInt(5, governmentTaxes.getGovernment_tax_year());
            preparedStatement.setDouble(6, governmentTaxes.getGovernment_tax_value());

            preparedStatement.execute();

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double getGovernmentTaxesValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        double tax_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT government_taxes_value FROM government_taxes_table " +
                    "WHERE government_taxes_year='" + year + "' AND government_taxes_month ='" + month + "' " +
                    "AND government_taxes_product_id = '" + product_id +"'");

            while (resultSet.next()) {
                tax_value = resultSet.getDouble("government_taxes_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tax_value;
    }

    /**
     * Local Cost*/
    @Override
    public void insertLocalCostData(LocalCost localCost) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO local_cost_computed_table (" +
                    "local_cost_computed_product_id,local_cost_computed_day,local_cost_computed_date," +
                    "local_cost_computed_month,local_cost_computed_year,local_cost_computed_value) VALUES(?,?,?,?,?,?) ");

            preparedStatement.setInt(1, localCost.getLocal_cost_product_id());
            preparedStatement.setString(2, localCost.getLocal_cost_day());
            preparedStatement.setInt(3, localCost.getLocal_cost_date());
            preparedStatement.setString(4, localCost.getLocal_cost_month());
            preparedStatement.setInt(5, localCost.getLocal_cost_year());
            preparedStatement.setDouble(6, localCost.getLocal_cost_value());

            preparedStatement.execute();

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double getLocalCostDataValue(String month, int year, String product) {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        double cost_value = 0.0;
        int product_id = 0;

        try {
            if (product == "Petroleum") {
                product_id = 1;

            } else if (product == "Diesel") {
                product_id = 3;
            } else if (product == "Kerosene") {
                product_id = 2;
            }
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT local_cost_computed_value FROM local_cost_computed_table " +
                    "WHERE local_cost_computed_year='" + year + "' AND local_cost_computed_month ='" + month + "' " +
                    "AND local_cost_computed_product_id = '" + product_id +"'");

            while (resultSet.next()) {
                cost_value = resultSet.getDouble("local_cost_computed_value");
            }

        } catch (Exception sql_exception) {
            sql_exception.printStackTrace();

        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cost_value;
    }
}
