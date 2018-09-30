package DAOInterfaceMethods;

import Static.WeightPlattFOB;
import Static.YearlyData;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface WeightedAveragePlattFOBInterface {
    ObservableList<WeightPlattFOB> getWeightedAveragePlattFOBData();
    void insertWeightedAveragePlattFOBData(WeightPlattFOB weightPlattFOB);
    double getMonthWAPFOBValue(String month, int year, String product);
    int getWAPFOBID(String month, int year,String product);
    ArrayList<YearlyData> getYearlyWAPFOBValue(int year, String product);
}
