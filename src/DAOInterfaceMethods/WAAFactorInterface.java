package DAOInterfaceMethods;

import Static.WAAConversionFactor;
import javafx.collections.ObservableList;

public interface WAAFactorInterface {
    void insertWAAData(WAAConversionFactor waaConversionFactor);
    double getMonthWAADValue(String month, int year, String product);
    int getWAADID(String month, int year,String product);
    ObservableList<WAAConversionFactor> getWAAData();

}
