package com.example.treebuilder.mapper;

import com.example.treebuilder.dto.VendorDto;
import com.example.treebuilder.model.Vendor;

public class VendorMapper {
    public static Vendor toVendor(VendorDto vendorDto) {
        return Vendor.builder()
            .name(vendorDto.getName())
            .build();
    }
}
