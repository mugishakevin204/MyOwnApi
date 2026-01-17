package com.Student.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Schema(example = "admin")
    private String username;

    @Column(nullable = false)
    @Schema(example = "admin123", accessMode = Schema.AccessMode.WRITE_ONLY)
    private String password;

    @Schema(example = "ROLE_ADMIN")
    private String role;
}
