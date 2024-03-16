package com.example.lab4.controllers;

import com.example.lab4.exceptions.InvalidParamsException;
import com.example.lab4.model.HitEntity;
import com.example.lab4.repositories.HitRepo;
import com.example.lab4.service.HitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hits")
public class HitController {
    @Autowired
    private HitService hitService;
    @Autowired
    private HitRepo hitRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<HitEntity> getHits() {
        return hitRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody HitEntity hit) {
        try {
            HitEntity savedHit = hitRepo.save(hitService.check(hit));
            return new ResponseEntity<>(savedHit, HttpStatus.OK);
        } catch (InvalidParamsException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"Your coordinates aren't numbers!\"}");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public ResponseEntity<?> clear() {
        try {
            hitRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"Your coordinates aren't numbers!\"}");
        }
    }
}