package com.example.treebuilder.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;


@Entity
@Data
@Table(name = "vendor", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    int id;
    @Column(name = "name")
    String name;
}
