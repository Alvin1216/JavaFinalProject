package Java_Final_Project.FirstClass;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("First_Class.fxml"));
        FirstClass_Controller controller = new FirstClass_Controller ();
        fxmlLoader.setController(controller);
        
        
        controller.setPrevStage(primaryStage);
        
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("-Let's play movies_Phrase1-");
        Scene scene = new Scene ( root, 600, 400 );//©³¤U¶ëªºscene (©³®y)
        //controller.setScene ( scene );
        primaryStage.setScene(scene);
        primaryStage.show();
	   	}
	
	public Stage getprimaryStage(Stage primaryStage){
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
