package org.exercise1;

public class SilverPlan extends HealthInsurancePlan{

    public SilverPlan(){
        this.setCoverage(0.7);
        this.setPlanType("silver");
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
