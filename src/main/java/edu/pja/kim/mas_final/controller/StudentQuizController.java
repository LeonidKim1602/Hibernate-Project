package edu.pja.kim.mas_final.controller;

import edu.pja.kim.mas_final.dto.QuizDTO;
import edu.pja.kim.mas_final.dto.StudentDTO;
import edu.pja.kim.mas_final.service.StudentQuizService;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for managing student-quiz assignments.
 */
@Component
public class StudentQuizController implements Initializable {

    @FXML
    private ListView<StudentDTO> studentListView;

    @FXML
    private ListView<QuizDTO> quizListView;

    @FXML
    private ChoiceBox<StudentDTO> studentChoiceBox;

    @FXML
    private ChoiceBox<QuizDTO> quizChoiceBox;

    private final StudentQuizService studentQuizService;

    /**
     * Constructor for the StudentQuizController.
     *
     * @param studentQuizService Service class for student-quiz related operations.
     */
    public StudentQuizController(StudentQuizService studentQuizService) {
        this.studentQuizService = studentQuizService;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadStudents();
        loadQuizzes();
        studentListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAssignedQuizzes(newValue));
    }

    /**
     * Loads all students and populates the student choice box and list view.
     */
    private void loadStudents() {
        List<StudentDTO> students = studentQuizService.getAllStudents();
        ObservableList<StudentDTO> studentObservableList = new SimpleListProperty<>(FXCollections.observableList(students));
        studentChoiceBox.setItems(studentObservableList);
        studentListView.setItems(studentObservableList);
    }

    /**
     * Loads all quizzes and populates the quiz choice box.
     */
    private void loadQuizzes(){
        List<QuizDTO> quizzes = studentQuizService.getAllQuizzes();
        quizChoiceBox.getItems().addAll(quizzes);
    }

    /**
     * Shows the quizzes assigned to the selected student.
     *
     * @param student The student whose quizzes are to be displayed.
     */
    private void showAssignedQuizzes(StudentDTO student) {
        if (student != null) {
            List<QuizDTO> quizzes = studentQuizService.getStudentQuizzesByStudentId(student.getId());
            ObservableList<QuizDTO> quizObservableList = FXCollections.observableArrayList(quizzes);
            quizListView.setItems(quizObservableList);
        } else {
            quizListView.getItems().clear();
        }
    }

    /**
     * Saves the assignment of a selected quiz to a selected student.
     */
    @FXML
    private void saveAssignment() {
        StudentDTO selectedStudent = studentChoiceBox.getSelectionModel().getSelectedItem();
        QuizDTO selectedQuiz = quizChoiceBox.getSelectionModel().getSelectedItem();
        if (selectedStudent != null && selectedQuiz != null) {
            studentQuizService.assignQuizToStudent(selectedStudent.getId(), selectedQuiz.getId());
            showAssignedQuizzes(selectedStudent);
        }
    }
}
