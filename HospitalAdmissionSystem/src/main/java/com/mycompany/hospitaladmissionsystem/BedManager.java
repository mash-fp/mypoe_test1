package com.mycompany.hospitaladmissionsystem;

import java.util.HashMap;
import java.util.Map;

public class BedManager {
    private Map<String, String> bedAllocations = new HashMap<>();

    // Allocate a bed to a patient
    public boolean allocateBed(String bedId, String patientId) {
        if (bedAllocations.containsKey(bedId)) {
            // Bed already occupied
            return false;
        }
        bedAllocations.put(bedId, patientId);
        return true;
    }

    // Release a bed
    public boolean releaseBed(String bedId) {
        if (bedAllocations.containsKey(bedId)) {
            bedAllocations.remove(bedId);
            return true;
        }
        return false;
    }

    // Count occupied beds (needed for ProjectManager reports)
    public int getOccupiedCount() {
        return bedAllocations.size();
    }

    // Display ward layout
    public void displayWardLayout() {
        System.out.println("\n--- Ward Layout ---");
        if (bedAllocations.isEmpty()) {
            System.out.println("No beds allocated.");
        } else {
            for (Map.Entry<String, String> entry : bedAllocations.entrySet()) {
                System.out.println("Bed " + entry.getKey() + " → Patient " + entry.getValue());
            }
        }
    }
}

