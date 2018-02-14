package Java_Final_Project.FirstClass;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FirstClass_Controller {
		private int  total_files=3;
		private int answer_set_at;
		private Image[] Movie_Poster=new Image[total_files];
		private String[] Movie_script=new String[total_files];
		private String[] Movie_title=new String[total_files];
		
		Stage prevStage;
		
	   @FXML private ImageView moviePoster1;
	   @FXML private ImageView moviePoster2;
	   @FXML private ImageView moviePoster3;
	    
	    @FXML private Button movieButton1;
	    @FXML private Button movieButton2;
	    @FXML private Button movieButton3;
	    
	    @FXML private Text text;
	    
	    public void setPrevStage(Stage stage){
	         this.prevStage = stage;
	    }
	    
	    public void gotoPhrase2() throws Exception{
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MarchingCard.fxml"));
	    	MarchingCard_Controller controller_m=new MarchingCard_Controller();
	    	fxmlLoader.setController(controller_m);
	    	
	    	//Stage stage = new Stage();
	    	prevStage.setTitle("-Let's play movies_Phrase2-");
 	       Parent MC =  fxmlLoader.load();
		        
		   controller_m.setPrevStage(this.prevStage);
 	       Scene scene = new Scene(MC,670,550);
 	      prevStage.setScene(scene);
 	      // prevStage.close();
 	      prevStage.show();
	    }
	    
	    private  void openfile() throws Exception  {
	    	//開檔，初始化Movie_poster 和 Movie_script
	    	//read file with buffered reader can read lines
	    	FileReader fr = new FileReader("Movie_script.txt");
	    	BufferedReader br = new BufferedReader(fr);
	    	int i=0;
	    	 	while (br.ready()) {
	    	 		Movie_script[i]=br.readLine();
	    	 		i++;
	    	 		//System.out.println(Movie_script[i-1]);
	    	 		}
	    	 	fr.close();
	    	 	
	    	 	
	    	 	fr = new FileReader("Movie_title.txt");
		    	br = new BufferedReader(fr);
		    	int it=0;
		    	 	while (br.ready()) {
		    	 		Movie_title[it]=br.readLine();
		    	 		it++;
		    	 		}
		    	 	fr.close();
		    	 	
	    	 	
	    	    for(int r=0;r<total_files;r++)Movie_Poster[r]=new Image("file:///D:/Java_Project/Java_Final_Project/Posters/Movie_Poster["+r+"].jpg");
	    	 	//到時候要想辦法改成相對位置	    	
	    }
	    private void answerSet(int answer_index){
	    	int setwhere=(int)(Math.random()*3);
	    	int others_set_a=answer_index;
	    	int others_set_b=answer_index;
	    	answer_set_at=setwhere;
	    	
	    	while((others_set_a==answer_index || others_set_b==answer_index || others_set_a==others_set_b ) ){
	    		others_set_a=(int)(Math.random()*total_files);
	    		others_set_b=(int)(Math.random()*total_files);
	 	    	}
	    	
	    	if(setwhere==0){
	    		moviePoster1.setImage(Movie_Poster[answer_index]);
	    		moviePoster2.setImage(Movie_Poster[others_set_a]);
	    		moviePoster3.setImage(Movie_Poster[others_set_b]);
	    		
	    		movieButton1.setText(Movie_title[answer_index]);
	    		movieButton2.setText(Movie_title[others_set_a]);
	    		movieButton3.setText(Movie_title[others_set_b]);
	    		
	    	}else if(setwhere==1){
	    		moviePoster1.setImage(Movie_Poster[others_set_a]);
	    		moviePoster2.setImage(Movie_Poster[answer_index]);
	    		moviePoster3.setImage(Movie_Poster[others_set_b]);
	    		
	    		movieButton1.setText(Movie_title[others_set_a]);
	    		movieButton2.setText(Movie_title[answer_index]);
	    		movieButton3.setText(Movie_title[others_set_b]);
	    	}else if(setwhere==2){
	    		moviePoster1.setImage(Movie_Poster[others_set_a]);
	    		moviePoster2.setImage(Movie_Poster[others_set_b]);
	    		moviePoster3.setImage(Movie_Poster[answer_index]);
	    		
	    		movieButton1.setText(Movie_title[others_set_a]);
	    		movieButton2.setText(Movie_title[others_set_b]);
	    		movieButton3.setText(Movie_title[answer_index]);
	    	}
	    }

	    @FXML
	    private void initialize() throws Exception{
	    	
	    	openfile();
	    	int answer_index=(int)(Math.random()*total_files);
	    	text.setText(Movie_script[answer_index]);
	    	answerSet(answer_index);
	
	    	movieButton1.setOnAction ( new EventHandler<ActionEvent> () {
	            @Override
	            public void handle ( ActionEvent event ) {
	            	if(answer_set_at==0){
	            		movieButton1.setText("Courrect!!");
	            		
	            		try {
							gotoPhrase2();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	      	            	}else{

	            		movieButton1.setText("Wrong!");
	            	}
	            }
	        } );
	    	
	    	movieButton2.setOnAction ( new EventHandler<ActionEvent> () {
	            @Override
	            public void handle ( ActionEvent event ) {
	            	if(answer_set_at==1){
	            		movieButton2.setText("Courrect!!");
	            		try {
	            			gotoPhrase2();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}else{
	            		movieButton2.setText("Wrong!");
	            	}
	            }
	        } );
	    	
	    	movieButton3.setOnAction ( new EventHandler<ActionEvent> () {
	            @Override
	            public void handle ( ActionEvent event ) {
	            	if(answer_set_at==2){
	            		movieButton3.setText("Courrect!!");
	            		try {
	            			gotoPhrase2();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}else{
	            		movieButton3.setText("Wrong!");
	            	}
	            }
	        } );
	    
	    }
	    /*public void setScene(Scene scene){
	    	scene.setOnKeyPressed ( new EventHandler<KeyEvent> () {
	            @Override
	            public void handle ( KeyEvent event ) {
	               
	            }
	        } );
	    }*/
}
