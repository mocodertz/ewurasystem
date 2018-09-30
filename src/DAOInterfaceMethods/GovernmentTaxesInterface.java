package DAOInterfaceMethods;

import Static.GovernmentTaxes;

public interface GovernmentTaxesInterface {
    void insertGovernmentTaxesData(GovernmentTaxes governmentTaxes);
    double getGovernmentTaxesValue(String month, int year, String product);
}
