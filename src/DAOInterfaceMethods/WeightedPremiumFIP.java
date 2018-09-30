package DAOInterfaceMethods;


import Static.WeightPlattFIP;
import javafx.collections.ObservableList;

public interface WeightedPremiumFIP {
    ObservableList<WeightPlattFIP> getWeightedAveragePlattFIPData();
    void insertWeightedAveragePlattFIPData(WeightPlattFIP weightPlattFIP);
    double getMonthWPFIPValue(String month, int year, String product);
    int getWPFIPID(String month, int year,String product);
}
