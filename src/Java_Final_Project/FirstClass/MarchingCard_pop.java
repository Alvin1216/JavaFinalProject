package Java_Final_Project.FirstClass;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MarchingCard_pop {
	public MarchingCard_pop() throws Exception{
		 Parent root = FXMLLoader.load(getClass().getResource("MarchingCard.fxml"));
	      Stage stage  = new Stage();
	      stage.setTitle("-Let's Play Movie_Phrase2-");
	      stage.setScene(new Scene(root,800,800));
	      stage.show();
	}
}
