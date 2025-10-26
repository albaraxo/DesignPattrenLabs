package lab5;

public class Facade {
}

// Assignment 2 - Facade Pattern Example
// Student: Albara Abumansoor
// ID: 2240096

// =========================== Domain Model Classes ===========================

// Represents a patient in the hospital system
class Patient {
    String id;
    String name;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient { id='" + id + "', name='" + name + "' }";
    }
}

// Represents an appointment scheduled for a patient
class Appointment {
    String apptId;
    String patientId;
    String dateTime;

    public Appointment(String apptId, String patientId, String dateTime) {
        this.apptId = apptId;
        this.patientId = patientId;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment { id='" + apptId + "', patientId='" + patientId + "', dateTime='" + dateTime + "' }";
    }
}

// Represents a medical record for a patient
class MedicalRecord {
    String recordId;
    String patientId;
    String notes;

    public MedicalRecord(String recordId, String patientId, String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "MedicalRecord { id='" + recordId + "', patientId='" + patientId + "', notes='" + notes + "' }";
    }
}

// =========================== Subsystem Classes ==============================

// Subsystem 1: Responsible for retrieving patient info
class PatientInfoSubsystem {
    public Patient retrievePatientInfo(String patientId) {
        System.out.println("[PatientInfoSubsystem] Retrieving information for ID: " + patientId);
        // Simulated database lookup
        return new Patient(patientId, "Sara Al-Qahtani");
    }
}

// Subsystem 2: Handles appointment scheduling
class AppointmentSubsystem {
    public Appointment scheduleAppointment(String patientId, String dateTime) {
        System.out.println("[AppointmentSubsystem] Scheduling appointment for " + patientId);
        return new Appointment("APT-" + System.currentTimeMillis(), patientId, dateTime);
    }
}

// Subsystem 3: Manages patient medical records
class MedicalRecordSubsystem {
    public MedicalRecord manageMedicalRecords(String patientId, String note) {
        System.out.println("[MedicalRecordSubsystem] Updating record for " + patientId);
        return new MedicalRecord("REC-" + System.currentTimeMillis(), patientId, note);
    }
}

// =========================== Facade Class ===================================

// The Facade that simplifies access to all subsystems
class HospitalManagementFacade {

    private PatientInfoSubsystem patientInfo;
    private AppointmentSubsystem appointment;
    private MedicalRecordSubsystem records;

    public HospitalManagementFacade() {
        this.patientInfo = new PatientInfoSubsystem();
        this.appointment = new AppointmentSubsystem();
        this.records = new MedicalRecordSubsystem();
    }

    public Patient retrievePatientInfo(String patientId) {
        return patientInfo.retrievePatientInfo(patientId);
    }

    public Appointment scheduleAppointment(String patientId, String dateTime) {
        return appointment.scheduleAppointment(patientId, dateTime);
    }

    public MedicalRecord manageMedicalRecords(String patientId, String note) {
        return records.manageMedicalRecords(patientId, note);
    }


}

// =========================== Client / Demo ==================================

 class HospitalManagementFacadeDemo {
    public static void main(String[] args) {

        System.out.println("=== Hospital Management System (Facade Pattern) ===\n");

        HospitalManagementFacade facade = new HospitalManagementFacade();

        // Individual operations
        Patient patient = facade.retrievePatientInfo("P-1001");
        System.out.println("Retrieved: " + patient + "\n");

        Appointment appointment = facade.scheduleAppointment("P-1001", "2025-10-20 09:30 AM");
        System.out.println("Scheduled: " + appointment + "\n");

        MedicalRecord record = facade.manageMedicalRecords("P-1001", "Follow-up: Regular check-up completed.");
        System.out.println("Updated Record: " + record + "\n");

        System.out.println("All operations completed successfully!");
    }
}
