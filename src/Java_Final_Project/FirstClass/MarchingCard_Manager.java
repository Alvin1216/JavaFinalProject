package Java_Final_Project.FirstClass;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class MarchingCard_Manager {
	private GraphicsContext gc;
	private Image[] image_guardians=new Image[9];
	//private Image[] image_avengers=new Image[8];
	//private Image[] image_Ironman=new Image[8];
	//private Image[] image_thor=new Image[8];
	 // private List<GameObject> objectList = new ArrayList<>(); 
	
	
	
	public MarchingCard_Manager(GraphicsContext gc){
        this.gc = gc; //Pass the GraphicsContext from canvas
    }
	public void draw(){
		gc.setFill(Color.WHITE);
		//image_guardians[0]=new Image("file:MemberCard/gotg/gotg.jpg");
		for(int i=0;i<9;i++)image_guardians[i]=new Image("file:///D:/Java_Project/Java_Final_Project/MemberCard/gotg/gotg"+i+".jpg");
		 gc.drawImage( image_guardians[0], 180, 100 );
     }
}
