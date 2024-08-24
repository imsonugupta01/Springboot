package com.example.Makersharks.Controller;

import com.example.Makersharks.Exception.SupplierException;
import com.example.Makersharks.Module.Supplier;
import com.example.Makersharks.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepo supplierRepo;

    @GetMapping("/all")
    public List<Supplier> getAllSuppliers() {
        try {
            return (List<Supplier>) supplierRepo.findAll();
        } catch (Exception e) {
            throw new SupplierException("Error fetching all suppliers", e);
        }
    }

    @GetMapping("/from/{location}")
    public List<Supplier> getSuppliersbyLocation(
            @PathVariable("location") String location) {
        try {
            return supplierRepo.findByLocation(location);
        } catch (Exception e) {
            throw new SupplierException("Error fetching suppliers by location: " + location, e);
        }
    }

    @GetMapping("/type/{nature}")
    public List<Supplier> getSuppliersbynature(
            @PathVariable("nature") String nature) {
        try {
            return supplierRepo.findByNature(nature);
        } catch (Exception e) {
            throw new SupplierException("Error fetching suppliers by nature: " + nature, e);
        }
    }

    @GetMapping("/process/{process}")
    public List<Supplier> getSuppliersbyManufactureProcess(
            @PathVariable("process") String process) {
        try {
            return supplierRepo.findByManufactureProcess(process);
        } catch (Exception e) {
            throw new SupplierException("Error fetching suppliers by manufacturing process: " + process, e);
        }
    }

    @GetMapping("/Indian")
    public List<Supplier> suppliers() {
        try {
            return supplierRepo.findSuppliers("India", "small_scale", "3d_printing");
        } catch (Exception e) {
            throw new SupplierException("Error fetching Indian small-scale suppliers with 3D printing process", e);
        }
    }

    @GetMapping("/search/{location}/{nature_of_business}/{manufacturing_process}")
    public List<Supplier> getSuppliers(
            @PathVariable("location") String location,
            @PathVariable("nature_of_business") String natureOfBusiness,
            @PathVariable("manufacturing_process") String manufacturingProcess) {
        try {
            return supplierRepo.findByLocationAndNatureOfBusinessAndManufacturingProcesses(location, natureOfBusiness, manufacturingProcess);
        } catch (Exception e) {
            throw new SupplierException("Error fetching suppliers with location: " + location + ", nature of business: " + natureOfBusiness + ", and manufacturing process: " + manufacturingProcess, e);
        }
    }
}
