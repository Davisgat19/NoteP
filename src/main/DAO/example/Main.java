import DAO.NoteDAO;
import DAO.NoteDAOImpl;
import DAO.TagDAO;
import DAO.service.NoteService;
import DAO.service.TagService;
import controller.MainViewController;
import controller.NoteController;
import controller.TagController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Entitymanager instance
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Skapa en instance för NoteDAOImpl
        NoteDAO noteDAO = new NoteDAOImpl(entityManager);
        TagDAO tagDAO = new TagDAO(entityManager);
        TagController tagController = new TagController(tagDAO);
        NoteService noteService = new NoteService(noteDAO);
        TagService tagService = new TagService(tagDAO);
        NoteController noteController = new NoteController(noteService, tagService);

        // ladda FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent mainView = loader.load();

        MainViewController controller = loader.getController();



        // Inject NoteDAO instance
        controller.setNoteDAO(noteDAO);
        controller.setTagDAO(tagDAO);

        // Skapa scene för main view
        Scene scene = new Scene(mainView, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Notes Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
