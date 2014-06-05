package org.openmrs.module.addonmodule.calculation;

import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.Calculations;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sci on 6/3/2014.
 */
public class EligibleForMCHProgram extends BaseCalculation implements PatientCalculation{
    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> stringObjectMap, PatientCalculationContext context) {

        CalculationResultMap genders = Calculations.genders(cohort, context);


        CalculationResultMap ret = new CalculationResultMap();
        for (Integer ptId : cohort) {
            boolean eligible = "F".equals(genders.get(ptId).getValue());
            ret.put(ptId, new BooleanResult(eligible, this));
        }
        return ret;
    }




}



