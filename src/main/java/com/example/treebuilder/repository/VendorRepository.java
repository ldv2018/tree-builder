package com.example.treebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.treebuilder.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{
    
}
