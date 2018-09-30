package DAOInterfaceMethods;

import Static.Wharfage;
import javafx.collections.ObservableList;

public interface WharfageInterface {
    ObservableList<Wharfage> getWharfageData();
    void insertWharfageData(Wharfage wharfage);
    double getWharfageMonthValue(String month, int year, String product);

}
