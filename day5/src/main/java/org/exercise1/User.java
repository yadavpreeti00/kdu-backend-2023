package org.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger= LoggerFactory.getLogger(User.class);

    private boolean insured;

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private HealthInsurancePlan insurancePlan;



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsInsured() {
        return insured;
    }
    public void setIsInsured(boolean insured) {
        this.insured = insured;
    }



    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public static void main(String[] args){

        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        double ans=insurancePlan.computeMonthlyPremium(5000, 56, true);
        System.out.println(ans);
        logger.info(String.valueOf(ans));
    }

}