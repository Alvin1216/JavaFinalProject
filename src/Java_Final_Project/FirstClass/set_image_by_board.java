package Java_Final_Project.FirstClass;

import java.sql.Struct;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class set_image_by_board {
	
	private GraphicsContext gc;
	private int[][] gameboard=new int [2][4];
	private int start_x=20;
	private int start_y=10;
	private int gap=10;
	private Image[] image=new Image[9];
	private double width=150;
	private double height=250;
	//private where_position[][] wp=new where_position[2][4];
	
	//存每張卡在canvas上的位置 點的時候要用
	
	public set_image_by_board(GraphicsContext gc,int[][] gameboard,Image[] image){
		this.gc=gc;
		this.gameboard=gameboard;
		this.image=image;
		
		//物件陣列要初始化 給他pointer!!!
		/*for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				wp[i][j]=new where_position();
			}
		}*/
	}
	
	public void draw_image(){
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				gc.drawImage( image[gameboard[i][j]+1], start_x+(width+gap)*(j), start_y );
			}
			start_y=(int) (height+start_y+gap);
		}
	}
	public void draw_image_background(where_position[][] wp){
		int y=start_y;
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				gc.drawImage( image[0], start_x+(width+gap)*(j), y );
				wp[i][j].set_position((int)(start_x+(width+gap)*(j)), y);
			}
			y=(int) (height+start_y+gap);
		}
	}
	
	
	/*public where_position[][] get_where_position(){
		return wp;
	}*/
	
	public void draw_one_card(int position_x,int position_y){
		//position放gameboard[i][j]--->裡面的i,j
		int y=start_y;
		if(position_x==1)y=(int) (height+start_y+gap);
		gc.drawImage(  image[gameboard[position_x][position_y]+1], start_x+(width+gap)*(position_y), y );
	}
	
	public void draw_one_background(int position_x,int position_y){
		//position放gameboard[i][j]--->裡面的i,j
		int y=start_y;
		if(position_x==1) y=(int) (height+start_y+gap);
		gc.drawImage(  image[0], start_x+(width+gap)*(position_y), y );
	}
	
	public void now_board(int[][] turn){
		start_y=150;
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				if(turn[i][j]==1)gc.drawImage( image[gameboard[i][j]+1], start_x+(width+gap)*(j), start_y );
				else gc.drawImage( image[0], start_x+(width+gap)*(j), start_y );
			}
			start_y=(int) (height+start_y+gap);
		}
	}
}
