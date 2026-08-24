package com.mycompany.hospitaladmissionsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        BedManager bedManager = new BedManager();
        ProjectManager projectManager = new ProjectManager();

        int choice;
        do {
            System.out.println("\n--- Hospital Admission System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Allocate Bed");
            System.out.println("7. Release Bed");
            System.out.println("8. Display Ward Layout");
            System.out.println("9. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter First Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Condition: ");
                    String condition = sc.nextLine();
                    System.out.print("Enter Category (INPATIENT/OUTPATIENT/EMERGENCY): ");
                    String categoryStr = sc.nextLine();
                    PatientCategory category = PatientCategory.valueOf(categoryStr.toUpperCase());
                    patients.add(new Patient(id, fname, lname, age, gender, condition, category));
                    System.out.println("Patient registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    String searchId = sc.nextLine();
                    patients.stream()
                            .filter(p -> p.getPatientId().equals(searchId))
                            .findFirst()
                            .ifPresentOrElse(
                                Patient::displayDetails,
                                () -> System.out.println("Patient not found.")
                            );
                    break;

                case 3:
                    System.out.print("Enter Patient ID to update: ");
                    String updateId = sc.nextLine();
                    for (Patient p : patients) {
                        if (p.getPatientId().equals(updateId)) {
                            System.out.print("Enter new First Name: ");
                            p.setFirstName(sc.nextLine());
                            System.out.print("Enter new Age: ");
                            p.setAge(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Patient updated successfully!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Patient ID to delete: ");
                    String deleteId = sc.nextLine();
                    patients.removeIf(p -> p.getPatientId().equals(deleteId));
                    System.out.println("Patient deleted successfully!");
                    break;

                case 5:
                    projectManager.displayAllPatients(patients);
                    break;

                case 6:
                    System.out.print("Enter Bed ID: ");
                    String bedId = sc.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String pid = sc.nextLine();
                    if (bedManager.allocateBed(bedId, pid)) {
                        System.out.println("Bed allocated successfully!");
                    } else {
                        System.out.println("Bed already occupied.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Bed ID to release: ");
                    String releaseId = sc.nextLine();
                    if (bedManager.releaseBed(releaseId)) {
                        System.out.println("Bed released successfully!");
                    } else {
                        System.out.println("Bed not found or already free.");
                    }
                    break;

                case 8:
                    bedManager.displayWardLayout();
                    break;

                case 9:
                    projectManager.displayOccupancy(patients, bedManager);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
