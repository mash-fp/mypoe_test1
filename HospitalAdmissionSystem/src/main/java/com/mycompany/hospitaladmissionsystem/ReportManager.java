
package com.mycompany.hospitaladmissionsystem;

import java.util.List;

public class ReportManager {
    public void displayAllPatients(List<Patient> patients) {
        for (Patient p : patients) {
            p.displayDetails();
        }
    }

    public void displayOccupancy(List<Patient> patients, BedManager bedManager) {
        long inpatients = patients.stream().filter(p -> p.getCategory() == PatientCategory.INPATIENT).count();
        double percentage = (inpatients / 20.0) * 100;
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Occupied Beds: " + inpatients);
        System.out.println("Occupancy %: " + percentage);
    }
}

