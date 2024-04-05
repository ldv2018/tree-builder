package com.example.treebuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.treebuilder.model.Vendor;
import com.example.treebuilder.repository.VendorRepository;
import com.example.treebuilder.exception.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendorService {
    final VendorRepository vendorRepository;

    public Vendor add(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void delete(int id) {
        throwIfVendorNotExist(id);
        vendorRepository.deleteById(id);
    }

    public Vendor update(int id, Vendor vendor) {
        throwIfVendorNotExist(id);
        return vendorRepository.save(vendor);
    }

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Vendor findById(int id) {
        throwIfVendorNotExist(id);
        return vendorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, 
                "Vendor with id=" + id + " was not found"));
    }

    private void throwIfVendorNotExist(int id) {
        if(!vendorRepository.existsById(id)) {
            log.info("Vendor id={} not found", id);
            throw new NotFoundException(HttpStatus.NOT_FOUND, "Vendor with id=" + id + " was not found");
        }
    }
}
