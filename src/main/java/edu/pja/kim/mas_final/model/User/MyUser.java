package edu.pja.kim.mas_final.model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Abstract base class representing a MyUser entity in the system.
 * This class defines common attributes and behaviors for all users.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    @Email
    private String email;

    /**
     * Abstract method to handle user login functionality.
     * Subclasses must implement specific login logic.
     */
    public abstract void login();

    /**
     * Abstract method to handle user registration functionality.
     * Subclasses must implement specific registration logic.
     */
    public abstract void register();

    /**
     * Abstract method to handle password reset functionality.
     * Subclasses must implement specific password reset logic.
     */
    public abstract void resetPassword();



}
