package com.example.healthcare.service;

import com.example.healthcare.ResourceNotFoundException;
import com.example.healthcare.model.Patient;
import com.example.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id) throws Throwable {
        return (Patient) patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
    }

    public Patient createPatient(Patient patient) {
        return (Patient) patientRepository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient patientDetails) throws Throwable {
        Patient patient = (Patient) patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));

        patient.setName(patientDetails.getName());

        return (Patient) patientRepository.save(patient);
    }

    public void deletePatient(Integer id) throws Throwable {
        Patient patient = (Patient) patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));

        patientRepository.delete(patient);
    }
}
