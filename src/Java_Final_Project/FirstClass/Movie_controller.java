package Java_Final_Project.FirstClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Movie_controller {
	 
	Stage prevStage;
	
	public get_movie gm=null;
	private int[] movie_list=new int[61];
	
	@FXML private Pane pane;
	@FXML private Text text;
	@FXML private Text text2;
	@FXML private Text text3;
	@FXML private ImageView iv;
	@FXML private  Button button;
	
	public void movie_list() throws Exception{
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
	
	public int get_id(){
		int index=(int) (Math.random()*61);
		return movie_list[index];
	}
	
	 public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
	
	
	@FXML 
	private void initialize() throws Exception{
		
		movie_list();
		gm=new get_movie(get_id());
		String imageSource = gm.movie_image_url+gm.movie_path;
		Image ig=new Image(imageSource);
		
		button.setText("Don't like");
		
		text3.setText("Congratulations!!"+"\n"+"Recommend you a good movie!");
		text3.setFont(new Font("Verdana", 15));
		text3.setFill(Color.RED);
		
		iv.setImage(ig);

		text.setText(gm.movie_title);
		text.setFont(new Font("Impact", 25));

		
		text2.setText("Release Date:"+gm.movie_release);
		text2.setFont(new Font("Verdana", 20));
		
		/*pane.getChildren().add(text);
		pane.getChildren().add(text2);
		pane.getChildren().add(iv);
		pane.getChildren().add(text3);
		pane.getChildren().add(button);
		
		
		Scene scene=new Scene(pane,700,400);
		stage.setTitle("-Congratulations-");
		stage.setScene(scene);
		stage.show();*/
	}
}
