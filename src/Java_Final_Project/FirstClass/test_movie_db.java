package Java_Final_Project.FirstClass;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test_movie_db extends Application{
	public Button button=new Button("Don't like??");
	public static get_movie gm=null;
	private static int[] movie_list=new int[61]; 
	
	public static void main(String[] args) throws Exception {
		movie_list();
		gm=new get_movie(get_id());
		launch(args);
	}
	
	public test_movie_db(){
		button=new Button("Don't like??");
		get_movie gm=null;
		int[] movie_list=new int[61];
	}
	
	public static void movie_list() throws IOException{
		FileReader fr = new FileReader("Movie_id.txt");
    	BufferedReader br = new BufferedReader(fr);
    	int i=0;
    	 	while (br.ready()) {
    	 		movie_list[i]=Integer.parseInt(br.readLine());
    	 		i++;
    	 		//System.out.println(Movie_script[i-1]);
    	 		}
    	 	fr.close();
	}
	
	public static int get_id(){
		int index=(int) (Math.random()*61);
		return movie_list[index];
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane=new Pane();
		Text text=new Text();
		Text text2=new Text();
		Text text3=new Text();
		ImageView iv=new ImageView();
		String imageSource = gm.movie_image_url+gm.movie_path;
		Image ig=new Image(imageSource);
		button=new Button("Don't like??");
		
		button.setLayoutX(300);
    	button.setLayoutY(250);
		
		text3.setText("Congratulations!!"+"\n"+"Recommend you a good movie!");
		text3.setFont(new Font("Verdana", 15));
		text3.setFill(Color.RED);
		text3.setLayoutX(300);
		text3.setLayoutY(140+5);
		
		iv.setImage(ig);
		iv.setLayoutX(50);
		iv.setLayoutY(40);
		iv.setFitHeight(330);
		iv.setFitWidth(220);
		
		text.setText(gm.movie_title);
		text.setFont(new Font("Impact", 25));
		text.setLayoutX(300);
		text.setLayoutY(140+30+30);
		
		text2.setText("Release Date:"+gm.movie_release);
		text2.setFont(new Font("Verdana", 20));
		text2.setLayoutX(300);
		text2.setLayoutY(170+30+30);
		
		pane.getChildren().add(text);
		pane.getChildren().add(text2);
		pane.getChildren().add(iv);
		pane.getChildren().add(text3);
		pane.getChildren().add(button);
		
		
		Scene scene=new Scene(pane,700,400);
		stage.setTitle("-Congratulations-");
		stage.setScene(scene);
		stage.show();
		
		   
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	gm=new get_movie(get_id());
            	Pane pane=new Pane();
        		Text text=new Text();
        		Text text2=new Text();
        		Text text3=new Text();
        		ImageView iv=new ImageView();
        		String imageSource = gm.movie_image_url+gm.movie_path;
        		Image ig=new Image(imageSource);
        		
        		text3.setText("Congratulations!!"+"\n"+"Recommend you a good movie!");
        		text3.setFont(new Font("Verdana", 15));
        		text3.setFill(Color.RED);
        		text3.setLayoutX(300);
        		text3.setLayoutY(140+5);
        		
        		iv.setImage(ig);
        		iv.setLayoutX(50);
        		iv.setLayoutY(40);
        		iv.setFitHeight(330);
        		iv.setFitWidth(220);
        		
        		text.setText(gm.movie_title);
        		text.setFont(new Font("Impact", 25));
        		text.setLayoutX(300);
        		text.setLayoutY(140+30+30);
        		
        		text2.setText("Release Date:"+gm.movie_release);
        		text2.setFont(new Font("Verdana", 20));
        		text2.setLayoutX(300);
        		text2.setLayoutY(170+30+30);
        		
        		pane.getChildren().add(text);
        		pane.getChildren().add(text2);
        		pane.getChildren().add(iv);
        		pane.getChildren().add(text3);
        		pane.getChildren().add(button);
        		
        		
        		Scene scene=new Scene(pane,700,400);
        		stage.setTitle("-Congratulations-");
        		stage.setScene(scene);
        		stage.show();
            }
        });
		
	}
}
