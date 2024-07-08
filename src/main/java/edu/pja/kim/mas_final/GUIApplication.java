package edu.pja.kim.mas_final;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A main application class. You start here
 */
@SpringBootApplication
public class GUIApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GUIApplication.class, args);
        Application.launch(FXApplication.class, args);
    }

}
