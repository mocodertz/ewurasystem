package DAOInterfaceMethods;

import Static.ExchangeRate;
import Static.FIP;
import javafx.collections.ObservableList;

public interface FIPInterface {
    void insertFIPData(FIP fip);
    ObservableList<FIP> getFIPData();
    void updateFIPData(FIP fip);
    double getFIPValue(String month, int year, String product);
    int getFIPValueId(String month, int year, String product);
    ObservableList<ExchangeRate> searchFIPByAll(String day, int date, String month, int year);
    ObservableList<ExchangeRate> searchFIPSearchArray(String search_array);
}
