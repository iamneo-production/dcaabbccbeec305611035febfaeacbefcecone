package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private List<Medicine> medicineList = new ArrayList<>();

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        // Logic to add the medicine to the collection
        return medicineList.add(medicine);
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        // Logic to find and update the medicine by ID
        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineId() == medicineId) {
                // Update the medicine details
                medicine.setMedicineName(updatedMedicine.getMedicineName());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setQuantity(updatedMedicine.getQuantity());
                medicine.setDescription(updatedMedicine.getDescription());
                return medicine;
            }
        }
        return null; // Return null if medicine with the given ID is not found
    }
}