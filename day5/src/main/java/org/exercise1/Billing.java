package org.exercise1;



public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        int patientDiscount= 20;

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if(patientInsurancePlan==null){
            patientDiscount= 20;
        }
        if(patientInsurancePlan.getPlanType()=="platinum"){
            patientDiscount= 50;
        }
        if(patientInsurancePlan.getPlanType()=="gold"){
            patientDiscount= 40;
        }
        if(patientInsurancePlan.getPlanType()=="silver"){
            patientDiscount= 30;
        }
        if(patientInsurancePlan.getPlanType()=="bronze"){
            patientDiscount= 25;
        }

        double percentageCoverage=patientInsurancePlan.getCoverage();

        payments[0]=percentageCoverage*amount;
        payments[1]=amount-payments[0]-patientDiscount;

        return payments;
    }

}
