
package com.mycompany.hospitaladmissionsystem;


public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String patientId, String firstName, String lastName, int age,
                     String gender, String medicalCondition, PatientCategory category,
                     String wardNumber, String bedNumber) {
        super(patientId, firstName, lastName, age, gender, medicalCondition, category);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward: " + wardNumber + ", Bed: " + bedNumber);
    }
}
