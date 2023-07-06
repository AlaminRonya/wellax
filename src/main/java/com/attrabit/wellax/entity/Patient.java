package com.attrabit.wellax.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String specialty;
    @Column(name = "insurance_of_information")
    private String insuranceOfInformation;
    @Column(name = "medical_history")
    private String medicalHistory;
    @Column(name = "date_of_birth")
    private Date dob;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;
}
