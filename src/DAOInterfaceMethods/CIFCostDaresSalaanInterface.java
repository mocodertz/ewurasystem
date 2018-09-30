package DAOInterfaceMethods;

import Static.CIFCostDaresSalaamStatic;
import javafx.collections.ObservableList;

public interface CIFCostDaresSalaanInterface {
    ObservableList<CIFCostDaresSalaamStatic> getCIFCostDaresSalaamData();
    void insertCIFCostDaresSalaamData(CIFCostDaresSalaamStatic cifCostDaresSalaamStatic);
    double getCIFCostDaresSalaamValue(String month, int year, String product);

}
