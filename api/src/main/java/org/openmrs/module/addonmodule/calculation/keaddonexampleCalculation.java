package org.openmrs.module.addonmodule.calculation;

/**
 * Created by sci on 5/29/2014.
 */

import org.openmrs.Program;
import org.openmrs.calculation.BaseCalculation;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.Filters;
import org.openmrs.module.kenyaemr.metadata.HivMetadata;
import org.openmrs.module.metadatadeploy.MetadataUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class keaddonexampleCalculation extends BaseCalculation implements PatientCalculation{
    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> stringObjectMap, PatientCalculationContext patientCalculationContext) {

        Program hivProgram = MetadataUtils.existing(Program.class, HivMetadata._Program.HIV);

        Set<Integer> hivPositive = Filters.inProgram(hivProgram, cohort, patientCalculationContext);


        CalculationResultMap ret = new CalculationResultMap();
        for (Integer i: cohort){
            if (hivPositive.contains (i)){
                ret.put(i, new BooleanResult(true, this));
            }
        }
       /* CalculationResultMap gender = Calculations.genders(cohort, patientCalculationContext);
        for (Integer ptId : cohort) {
            boolean eligible = "F".equals(gender.get(ptId).getValue());
            if (hivPositive.contains(ptId)){
                ret.put(ptId, new BooleanResult(eligible, this));
            }
        } */

       return ret;
    }
}
