package edu.pja.kim.mas_final.model.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * Represents an Administrator entity, extending the functionality of the MyUser class.
 * Administrators are users with special privileges within the system.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("administrator")
@NoArgsConstructor
@ToString(callSuper = true)
public class Administrator extends MyUser {
    private String logFilePath;

    @Override
    public void login() {
        System.out.println("Administrator login");
    }

    @Override
    public void register() {
        System.out.println("Administrator register");
    }


    @Override
    public void resetPassword() {
        System.out.println("Administrator resetPassword");
    }
}

