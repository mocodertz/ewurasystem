package DAOInterfaceMethods;

import Static.ActualTenderRateStatic;
import javafx.collections.ObservableList;

public interface ActualTenderRateInterface {

    public void insertActualTenderRateValue(ActualTenderRateStatic actualTenderRateStatic);
    public ObservableList<ActualTenderRateStatic> getActualTenderRateValues();
    int getActualTenderRateValueId(String month, int year, String product, String vesselType);
    public double getActualTenderRateValue(String month, int year, String Product, String vesselType);
}
