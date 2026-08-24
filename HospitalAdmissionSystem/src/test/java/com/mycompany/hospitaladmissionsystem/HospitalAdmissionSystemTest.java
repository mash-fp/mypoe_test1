package com.mycompany.hospitaladmissionsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class HospitalAdmissionSystemTest {

    @Test
    public void testRegisterPatient() {
        Patient p = new Patient("P01", "John", "Doe", 30, "Male", "Flu", PatientCategory.OUTPATIENT);
        assertEquals("P01", p.getPatientId());
        assertEquals("John", p.getFirstName());
        assertEquals(PatientCategory.OUTPATIENT, p.getCategory());
    }

    @Test
    public void testUpdatePatient() {
        Patient p = new Patient("P02", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.INPATIENT);
        p.setFirstName("Janet");
        p.setAge(26);
        assertEquals("Janet", p.getFirstName());
        assertEquals(26, p.getAge());
    }

    @Test
    public void testDeletePatient() {
        Patient p = new Patient("P03", "Mike", "Brown", 40, "Male", "Injury", PatientCategory.EMERGENCY);
        List<Patient> list = new ArrayList<>();
        list.add(p);
        list.remove(p);
        assertTrue(list.isEmpty(), "Patient should be removed from the list");
    }

    @Test
    public void testAllocateBed() {
        BedManager bm = new BedManager();
        boolean success = bm.allocateBed("B01", "P01");
        assertTrue(success, "Bed should be allocated successfully");
        assertEquals(1, bm.getOccupiedCount());
    }

    @Test
    public void testReleaseBed() {
        BedManager bm = new BedManager();
        bm.allocateBed("B02", "P02");
        boolean success = bm.releaseBed("B02");
        assertTrue(success, "Bed should be released successfully");
        assertEquals(0, bm.getOccupiedCount());
    }

    @Test
    public void testProjectManagerDisplayAllPatients() {
        List<Patient> list = new ArrayList<>();
        list.add(new Patient("P04", "Alice", "Green", 22, "Female", "Checkup", PatientCategory.OUTPATIENT));
        ProjectManager pm = new ProjectManager();
        pm.displayAllPatients(list);
        assertEquals(1, list.size());
    }

    @Test
    public void testProjectManagerOccupancy() {
        List<Patient> list = new ArrayList<>();
        list.add(new Patient("P05", "Bob", "White", 50, "Male", "Surgery", PatientCategory.INPATIENT));
        BedManager bm = new BedManager();
        bm.allocateBed("B03", "P05");
        ProjectManager pm = new ProjectManager();
        pm.displayOccupancy(list, bm);
        assertEquals(1, bm.getOccupiedCount());
    }
}

