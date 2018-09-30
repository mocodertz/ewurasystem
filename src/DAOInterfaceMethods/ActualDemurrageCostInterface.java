package DAOInterfaceMethods;

import Static.ActualDemurrageCostStatic;
import javafx.collections.ObservableList;

public interface ActualDemurrageCostInterface {
    void insertActualDemurrageCostData(ActualDemurrageCostStatic actualDemurrageCostStatic);
    ObservableList<ActualDemurrageCostStatic> getActualDemurrageCostData();
    double getActualDemurrageCostValue(String month, int year, String product);
    int getActualDemurrageCostValueId(String month, int year, String product);
}
