package DAOInterfaceMethods;

import Static.WholeSalePriceCap;
import javafx.collections.ObservableList;

public interface WholeSalesPriceCap {

    ObservableList<WholeSalePriceCap> getWholesalePriceCapData();
    void insertWholeSalesPriceCapData(WholeSalePriceCap wholeSalePriceCap);
    double getWholeSalePriceCapValue(String month, int year, String product);
    int getWholeSalePriceCapValueId(String month, int year, String product);
}
