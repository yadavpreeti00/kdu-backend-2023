package org.exercise1;

public class GoldPlan extends HealthInsurancePlan{

    public GoldPlan(){
        this.setCoverage(0.8);
        this.setPlanType("gold");
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
