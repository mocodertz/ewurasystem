package DAOInterfaceMethods;

import Static.ActualDemurrageFactorStatic;
import javafx.collections.ObservableList;

public interface ActualDemurrageFactorInterface {
    void insertActualTenderRateValue(ActualDemurrageFactorStatic actualTenderRateStatic);
    ObservableList<ActualDemurrageFactorStatic> getActualDemurrageFactorValues();
    double getActualDemurrageFactorValue(String month, int year, String Product, String vesselType);
    int getActualDemurrageFactorId(String month, int year, String Product, String vesselType);
}
