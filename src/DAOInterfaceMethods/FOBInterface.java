package DAOInterfaceMethods;

import Static.ExchangeRate;
import Static.FOB;
import javafx.collections.ObservableList;

public interface FOBInterface {
    void insertFOBData(FOB fob);
    ObservableList<FOB> getFOBData();
    double getFOBValue(String month, int year, String product);
    int getFOBValueId(String month, int year, String product);
    void updateFOBData(ExchangeRate exchangeRate);
    ObservableList<ExchangeRate> searchFOBByAll(String day, int date, String month, int year);
    ObservableList<ExchangeRate> searchFOBSearchArray(String search_array);
}
