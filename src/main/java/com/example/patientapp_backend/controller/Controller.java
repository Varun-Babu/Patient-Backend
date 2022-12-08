package com.example.patientapp_backend.controller;

import com.example.patientapp_backend.DAO.PatientDao;
import com.example.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PatientDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add" , consumes ="application/json", produces = "application/json")
    public HashMap<String,String> addPatient(@RequestBody Patient p){
        dao.save(p);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List SearchPatient(@RequestBody Patient p){
        String pid = String.valueOf(p.getId());
        System.out.println(pid);
        return (List<Patient>)dao.SearchPatient(p.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/delete",consumes = "application/json", produces = "application/json")
    public HashMap<String, String> DeletePatient(@RequestBody Patient p) {
        String id = String.valueOf(p.getId());
        dao.deletePatient(p.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> viewPatient(){
        return (List<Patient>) dao.findAll();
    }
}
