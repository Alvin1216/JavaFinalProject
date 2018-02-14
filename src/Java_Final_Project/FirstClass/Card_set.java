package Java_Final_Project.FirstClass;

import javafx.scene.image.Image;

public class Card_set {
	private Image[] image_guardians=new Image[9];
	private Image[] image_avengers=new Image[9];
	
	public Card_set(){
		for(int i=0;i<9;i++)image_guardians[i]=new Image("file:///D:/Java_Project/Java_Final_Project/MemberCard/gotg/gotg"+i+".jpg");
		for(int i=0;i<9;i++)image_avengers[i]=new Image("file:///D:/Java_Project/Java_Final_Project/MemberCard/avengers/avengers"+i+".jpg",150,250, false, false);
	}
	public Image[] Avengers(){
		return image_avengers;
	}
	public Image[] Guardians(){
		return image_guardians;
	}
}
