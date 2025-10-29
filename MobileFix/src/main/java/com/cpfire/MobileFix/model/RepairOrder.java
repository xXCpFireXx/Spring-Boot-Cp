package com.cpfire.MobileFix.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "repair_orders")
public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private User customer;

    @Column(nullable = false)
    private Device device;

    @Column(nullable = false)
    private String issueDescription;

    @Column(nullable = false)
    private RepairStatus status;

    @Column(nullable = false)
    private User assignedTech;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
