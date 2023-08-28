package com.arthurfc.projetoponto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arthurfc.projetoponto.domain.pointers.Pointer;
import com.arthurfc.projetoponto.domain.user.User;
import com.arthurfc.projetoponto.services.PointerService;

@RestController
@RequestMapping("/pointers")
public class PointerController {
    
    @Autowired
    private PointerService pointerService;

    @PostMapping
    public ResponseEntity<Pointer> createPointer(@RequestBody User user) throws Exception {
        Pointer newPointer = pointerService.createPointer(user);
        return new ResponseEntity<Pointer>(newPointer,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pointer>> getAllPointers() {
        List<Pointer> pointers = this.pointerService.getAllPointers();
        return new ResponseEntity<List<Pointer>>(pointers, HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<List<Pointer>> getAllPointersMonth(@RequestParam int month) {
        List<Pointer> pointers = this.pointerService.getAllPointersMonth(month);
        return new ResponseEntity<List<Pointer>>(pointers,HttpStatus.OK);
    }
}
