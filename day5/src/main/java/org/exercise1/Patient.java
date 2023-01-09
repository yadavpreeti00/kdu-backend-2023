package org.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Patient extends User{

    private  static final Logger logger= LoggerFactory.getLogger(Patient.class);

    private long patientId;


    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public static void main(String[] args){
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);


        double[] payments = Billing.computePaymentAmount(patient, 1000.0);

        System.out.println("Insurance Company will pay: "+payments[0]);
        System.out.println("Patient will pay: "+payments[1]);
    }



}
