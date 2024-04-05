package com.example.treebuilder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.treebuilder.dto.VendorDto;
import com.example.treebuilder.mapper.VendorMapper;
import com.example.treebuilder.model.Vendor;
import com.example.treebuilder.service.VendorService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class VendorController {
    private final VendorService vendorService;

    @PostMapping("/vendors")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor add(@RequestBody VendorDto vendorDto) {
        log.info("Request for add vendor: {}", vendorDto);
        Vendor vendor = VendorMapper.toVendor(vendorDto);

        return vendorService.add(vendor);
    }

    @PatchMapping("/vendors/{id}")
    public Vendor update(@RequestBody VendorDto vendorDto,
                        @PathVariable int id) {
        log.info("Request for update vendor id={}", id);
        Vendor vendor = VendorMapper.toVendor(vendorDto);
        vendor.setId(id);

        return vendorService.update(id, vendor);
    }

    @GetMapping("/vendors")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendor> getAll() {
        log.info("Request for get all vendors");
        
        return vendorService.findAll();
    }

    @GetMapping("/vendors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendor getById(@PathVariable int id) {
        log.info("Request for vendor id={}", id);
        return vendorService.findById(id);
    }

    @DeleteMapping("/vendors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        log.info("Request for delete vendor id={}", id);
        vendorService.delete(id);
    }
}
