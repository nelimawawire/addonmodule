package org.openmrs.module.keaddonexample.calculation;

import org.openmrs.Program;
import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.keaddonexample.metadata.Metadata;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.Calculations;
import org.openmrs.module.metadatadeploy.MetadataUtils;
import org.openmrs.module.reporting.common.Age;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sci on 6/5/2014.
 */
public class EligibleForEarlyInfantProgram extends BaseCalculation implements PatientCalculation {

    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> stringObjectMap, PatientCalculationContext context) {

        CalculationResultMap ages = Calculations.ages(cohort, context);

        CalculationResultMap ret = new CalculationResultMap();
        for (int ptId : cohort) {
            Integer ageInMonths = ((Age) ages.get(ptId).getValue()).getFullMonths();
            boolean eligible = (ageInMonths != null && ageInMonths <= 40);

            ret.put(ptId, new BooleanResult(eligible, this));
        }
        return ret;
    }
}
