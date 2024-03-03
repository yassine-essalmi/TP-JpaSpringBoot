package com.example.jpaspringboot.web;

import com.example.jpaspringboot.entities.Patient;
import com.example.jpaspringboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getPatient() {
        return patientService.getAllPatient();
    }
}
