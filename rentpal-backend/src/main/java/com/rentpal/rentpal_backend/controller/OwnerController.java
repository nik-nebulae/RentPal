package com.rentpal.rentpal_backend.controller;

import com.rentpal.rentpal_backend.dto.OwnerSummaryDTO;
import com.rentpal.rentpal_backend.model.Owner;
import com.rentpal.rentpal_backend.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "*")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<OwnerSummaryDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }


    // ✅ Get owner by ID
    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    // ✅ Create owner
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }

    // ✅ Update owner
    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner updatedOwner) {
        return ownerService.updateOwner(id, updatedOwner);
    }

    // ✅ Delete owner
    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "Owner deleted successfully!";
    }
}
