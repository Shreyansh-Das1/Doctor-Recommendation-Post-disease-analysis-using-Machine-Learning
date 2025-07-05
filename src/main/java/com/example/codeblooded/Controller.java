package com.example.codeblooded;

import com.example.codeblooded.objects.Disease;
import com.example.codeblooded.objects.Doctor;
import com.example.codeblooded.objects.repositories.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/find")
public class Controller {

    final String modelurl = "http://127.0.0.1:5000/predict";
    @Autowired DocRepo docRepo;
    RestTemplate restTemplate = new RestTemplate();
    Disease dis;

    @GetMapping("/diagnose")
    public @ResponseBody ResponseEntity<Disease> diagnose(@RequestParam boolean  array[])
    {
        Disease response = restTemplate.postForObject(modelurl, array, Disease.class);
        dis = response;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/doctors")
    public @ResponseBody ResponseEntity<List<Doctor>> fetchDocs()
    {
        List<Doctor> docs = docRepo.searchByDepartment(dis.getDepartment());
        return ResponseEntity.ok(docs);
    }
}