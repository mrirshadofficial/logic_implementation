import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

// HealthcareSystem class
class HealthcareSystem {
    private Map<Integer, Patient> patients;
    private Map<Integer, Appointment> appointments;

    public HealthcareSystem() {
        patients = new HashMap<>();
        appointments = new HashMap<>();
    }

    public void registerPatient(int patientId, String name, int age, String gender) {
        if (!patients.containsKey(patientId)) {
            Patient patient = new Patient(patientId, name, age, gender);
            patients.put(patientId, patient);
            System.out.println("Patient " + name + " registered successfully.");
        } else {
            System.out.println("Patient ID already exists.");
        }
    }

    public void scheduleAppointment(int appointmentId, int patientId, String doctor, String date, String time) {
        if (patients.containsKey(patientId)) {
            Patient patient = patients.get(patientId);
            Appointment appointment = new Appointment(appointmentId, patient, doctor, date, time);
            appointments.put(appointmentId, appointment);
            System.out.println("Appointment scheduled for " + patient.getName() + " with Dr. " + doctor + " on " + date + " at " + time + ".");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public List<String> viewPatientRecords(int patientId) {
        if (patients.containsKey(patientId)) {
            return patients.get(patientId).viewRecords();
        } else {
            System.out.println("Patient not found.");
            return null;
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        HealthcareSystem healthcareSystem = new HealthcareSystem();

        // Registering patients
        healthcareSystem.registerPatient(1, "John Doe", 30, "Male");
        healthcareSystem.registerPatient(2, "Jane Smith", 25, "Female");

        // Scheduling appointments
        healthcareSystem.scheduleAppointment(101, 1, "Dr. Brown", "2023-10-01", "10:00 AM");
        healthcareSystem.scheduleAppointment(102, 2, "Dr. Green", "2023-10-02", "11:00 AM");

        // Viewing patient records (initially empty)
        System.out.println("Patient 1 Records: " + healthcareSystem.viewPatientRecords(1));  // Should return an empty list
    }
}
