package DAOInterfaceMethods;

import Static.MarkingCost;
import javafx.collections.ObservableList;

public interface MarkingCostInterface {
    ObservableList<MarkingCost> getMarkingCostData();
    void insertMarkingCostData(MarkingCost markingCost);
    double getPetroleumMarkingCostMonthValue(String month, int year);
}
