import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Custom Exception for Patient Not Found
class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String message) {
        super(message);
    }
}

// Custom Exception for Duplicate Patient ID
class DuplicatePatientIdException extends Exception {
    public DuplicatePatientIdException(String message) {
        super(message);
    }
}

// Custom Exception for Appointment Conflict
class AppointmentConflictException extends Exception {
    public AppointmentConflictException(String message) {
        super(message);
    }
}

// Patient class
class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private List<String> records;

    public Patient(int patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.records = new ArrayList<>();
    }

    public void addRecord(String record) {
        records.add(record);
    }

    public List<String> viewRecords() {
        return records;
    }

    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }
}

// Appointment class
class Appointment {
    private int appointmentId;
    private Patient patient;
    private String doctor;
    private String date;
    private String time;

    public Appointment(int appointmentId, Patient patient, String doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getAppointmentId() {
        return appointmentId;
    }
}

// HealthcareSystem class
class HealthcareSystem {
    private Map<Integer, Patient> patients;
    private Map<Integer, Appointment> appointments;

    public HealthcareSystem() {
        patients = new HashMap<>();
        appointments = new HashMap<>();
    }

    public void registerPatient(int patientId, String name, int age, String gender) throws DuplicatePatientIdException {
        if (patients.containsKey(patientId)) {
            throw new DuplicatePatientIdException("Patient ID " + patientId + " already exists.");
        }
        Patient patient = new Patient(patientId, name, age, gender);
        patients.put(patientId, patient);
        System.out.println("Patient " + name + " registered successfully.");
    }

    public void scheduleAppointment(int appointmentId, int patientId, String doctor, String date, String time) 
            throws PatientNotFoundException, AppointmentConflictException {
        if (!patients.containsKey(patientId)) {
            throw new PatientNotFoundException("Patient ID " + patientId + " not found.");
        }

        // Check for appointment conflicts
        for (Appointment appointment : appointments.values()) {
            if (appointment.getPatient().getPatientId() == patientId && 
                appointment.getDate().equals(date) && 
                appointment.getTime().equals(time)) {
                throw new AppointmentConflictException("Appointment conflict for patient " + patientId + " on " + date + " at " + time);
            }
        }

        Patient patient = patients.get(patientId);
        Appointment appointment = new Appointment(appointmentId, patient, doctor, date, time);
        appointments.put(appointmentId, appointment);
        System.out.println("Appointment scheduled for " + patient.getName() + " with Dr. " + doctor + " on " + date + " at " + time + ".");
    }

    public List<String> viewPatientRecords(int patientId) throws PatientNotFoundException {
        if (!patients.containsKey(patientId)) {
            throw new PatientNotFoundException("Patient ID " + patientId + " not found.");
        }
        return patients.get(patientId).viewRecords();
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        HealthcareSystem healthcareSystem = new HealthcareSystem();

        try {
            // Registering patients
            healthcareSystem.registerPatient(1, "John Doe", 30, "Male");
            healthcareSystem.registerPatient(2, "Jane Smith", 25, "Female");
            // Attempting to register a patient with a duplicate ID
            healthcareSystem.registerPatient(1, "John Doe", 30, "Male"); // This should throw an exception
