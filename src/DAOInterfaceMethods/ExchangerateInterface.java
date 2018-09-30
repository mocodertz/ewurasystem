package DAOInterfaceMethods;

import Static.ComputedExchagerate;
import Static.ExchangeRate;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public interface ExchangerateInterface {
    void insertExchangerateData(ExchangeRate exchangeRate);
    double getMonthComputedExchangerate(String month, int year);
    int getExchangerateID(String month, int year);
    ObservableList<ExchangeRate> getExchangerateData();
    XYChart.Series getExchangerateLinechartData(int year);
    void updateExchangerateData(ExchangeRate exchangeRate);
    boolean addComputedExchangerate(ComputedExchagerate prev_month,ComputedExchagerate prev_three_month,ExchangeRate exchangeRate);
    ObservableList<ExchangeRate> getComputedExchangerate();
    ObservableList<ExchangeRate> searchExchangerateByAll(String day, int date, String month, int year);
    ObservableList<ExchangeRate> getExchangerateofPreviousMonth(String month, int year);
    ObservableList<ExchangeRate> getExchangerateofPreviousThreeMonths(String month, int year);
    ObservableList<ExchangeRate> searchExchangerateSearchArray(String search_array);
}
