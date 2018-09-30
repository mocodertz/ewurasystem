package DAOInterfaceMethods;

import Static.PumpPriceCap;

public interface PumpPriceCapInterface {
    void insertPumpPriceCapData(PumpPriceCap pumpPriceCap);
    double getPumpPriceCapValue(String month, int year, String product);
}
