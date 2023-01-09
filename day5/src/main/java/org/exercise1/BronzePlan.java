package org.exercise1;

public class BronzePlan extends HealthInsurancePlan{

    public BronzePlan(){
        this.setCoverage(0.6);
        this.setPlanType("bronze");
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.05* salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
