package com.iristechnology.maslak.services;

import com.iristechnology.maslak.ecxeption.UserNotFoundException;
import com.iristechnology.maslak.model.Patient;
import com.iristechnology.maslak.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServices {

    private final PatientRepo patientRepo;
    @Autowired
    public PatientServices(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient addPatient(Patient patient){

        return  patientRepo.save(patient);
    }
    public List<Patient> findAllPatient(){
        return patientRepo.findAll();
    }
    public Patient updatePatient(Patient patient){
        return patientRepo.save(patient);

    }
    public void deletePatient(Long id){
        patientRepo.deletePatientById(id);
    }
    public  Patient findPatientById(Long id){
        return patientRepo.findPatientById(id).orElseThrow(() -> new UserNotFoundException("User by id"+"was not found"));
    }
}
