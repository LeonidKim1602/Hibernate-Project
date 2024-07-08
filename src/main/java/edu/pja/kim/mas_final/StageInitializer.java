package edu.pja.kim.mas_final;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Initializes the primary stage of the JavaFX application.
 *
 * <p>This class listens for the {@link FXApplication.StageReadyEvent} event and sets up the main
 * application window using an FXML file for the layout.
 */
@Component
@RequiredArgsConstructor
public class StageInitializer implements ApplicationListener<FXApplication.StageReadyEvent> {

    /**
     * The FXML file for the main view, loaded from the classpath.
     */
    @Value("classpath:/fxml/student_quiz.fxml")
    private Resource mainViewFxml;

    /**
     * The Spring application context, used to inject Spring-managed beans into the FXML controller.
     */
    private final ApplicationContext springContext;

    /**
     * Handles the {@link FXApplication.StageReadyEvent} to set up the primary stage.
     *
     * <p>This method loads the FXML file, sets the controller factory to use Spring for dependency injection,
     * and configures the primary stage with a scene created from the FXML layout.
     *
     * @param event the event indicating that the primary stage is ready
     */
    @Override
    @Transactional
    public void onApplicationEvent(FXApplication.StageReadyEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(mainViewFxml.getURL());
            loader.setControllerFactory(controllerClass -> springContext.getBean(controllerClass));
            Parent parent = loader.load();
            Stage stage = event.getStage();
            stage.setTitle("FP_KIM");
            stage.setScene(new Scene(parent, 800, 900));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML file", e);
        }
    }
}
