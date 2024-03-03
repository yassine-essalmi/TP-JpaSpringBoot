package com.example.jpaspringboot;

import com.example.jpaspringboot.entities.Patient;
import com.example.jpaspringboot.repository.PatientRepository;
import com.example.jpaspringboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaSpringBootApplication implements CommandLineRunner {
    private final PatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(JpaSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create some patients
        patientService.createPatient(new Patient(null, "hamid", new Date(), true, 20));
        patientService.createPatient(new Patient(null, "yassine", new Date(), false, 10));
        patientService.createPatient(new Patient(null, "mohamed", new Date(), true, 30));

        // get all patients
        System.out.println("\n\n**********-> All patients <-**********");
        List<Patient> patients = patientService.getAllPatient();
        patients.forEach(System.out::println);

        // get patient by id
        System.out.println("\n\n**********-> patient by id <-**********");
        Patient patient = patientService.getPatientByid(1L);
        System.out.println(patient);

        // get patient by name
        System.out.println("\n\n**********-> patient by name <-**********");
        List<Patient> patientByName = patientService.getPatientByName("yassine");
        patientByName.forEach(System.out::println);

        // update patient
        System.out.println("\n\n**********-> update patient <-**********");
        patientService.updatePatient(new Patient(1L, "hamid", new Date(), false, 50));
        System.out.println(patientService.getPatientByid(1L));

        // delete patient
        System.out.println("\n\n**********-> delete patient <-**********");
        patientService.deletePatient(3L);
        List<Patient> patientList = patientService.getAllPatient();
        patientList.forEach(System.out::println);

    }
}
