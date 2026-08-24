package com.mycompany.hospitaladmissionsystem;

import java.util.List;

public class ProjectManager {

    public void displayAllPatients(List<Patient> patients) {
        System.out.println("\n--- Patient List ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient p : patients) {
                p.displayDetails();
            }
        }
    }

    public void displayOccupancy(List<Patient> patients, BedManager bedManager) {
        System.out.println("\n--- Occupancy Report ---");
        int totalPatients = patients.size();
        int occupiedBeds = bedManager.getOccupiedCount();
        double occupancyPercent = totalPatients == 0 ? 0 : (occupiedBeds * 100.0 / totalPatients);

        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Occupied Beds: " + occupiedBeds);
        System.out.printf("Occupancy %%: %.2f%n", occupancyPercent);
    }
}
