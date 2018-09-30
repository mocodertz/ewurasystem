package DAOInterfaceMethods;

import Static.LocalCost;

public interface LocalCostInterface {
    void insertLocalCostData(LocalCost localCost);
    double getLocalCostDataValue(String month, int year, String product);
}
