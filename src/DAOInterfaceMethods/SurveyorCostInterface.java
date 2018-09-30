package DAOInterfaceMethods;

import Static.SurveyorCostStatic;
import javafx.collections.ObservableList;

public interface SurveyorCostInterface {
    void insertSurveyorCostData(SurveyorCostStatic surveyorCostStatic);
    ObservableList<SurveyorCostStatic> getSurveyorCostData();
    double getSurveyorCostValue(String month, int year, String product);
    int getSurveyorCostValueId(String month, int year, String product);
}
