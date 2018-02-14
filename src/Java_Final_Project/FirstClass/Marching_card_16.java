package Java_Final_Project.FirstClass;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Marching_card_16 {
@FXML private Canvas canvas;
	
	private int gap=10;
	private int start_x=50;
	private int start_y=100;
	private int[][] gameboard=new int[2][8];//存畫面上的位置，每個位置放編號多少的卡
	private int[] card_used=new int[8];//存哪張卡用過了，可以的話盡量不要重複
	private Random ran=new Random();//拿來亂數放卡
	private double width=150;
	private double height=250;
	private int what_times_now=1;
	
	 Stage prevStage;
	 //private MarchingCard_Manager marchingCard_Manager;
     private GraphicsContext gc;
	 private Image[] image=new Image[9];
	 
	  public void gotoPhrase3() throws Exception{
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Movie_random.fxml"));
	    	Movie_controller controller_m=new Movie_controller();
	    	fxmlLoader.setController(controller_m);
	    	
	    	Stage stage = new Stage();
	    	stage.setTitle("-Congraduation-");
	       Parent MC =  fxmlLoader.load();
		        
		   controller_m.setPrevStage(stage);
	       Scene scene = new Scene(MC,700,400);
	       stage.setScene(scene);
	      prevStage.close();
	      stage.show();
	    }
	 
	 public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
	 @FXML
	 private void initialize(){
		 	gc=canvas.getGraphicsContext2D();
		 	//for(int i=0;i<9;i++)image_guardians[i]=new Image("file:///D:/Java_Project/Java_Final_Project/MemberCard/gotg/gotg"+i+".jpg");
		 	int a=(int) (Math.random()*2);
		 	Card_set cs=new Card_set();
		 	if(a==1)image=cs.Avengers();
		 	else image=cs.Guardians();
			
		 	gameboard_position_16 gp=new gameboard_position_16();
			gp.gameboard_order();
			gp.image_order();
			gameboard=gp.set_gameboard();
			
			
			set_image_by_board_16 STBB=new set_image_by_board_16(gc,gameboard,image);
			where_position[][] wp2=new where_position[2][8];
			
			for(int i=0;i<2;i++){
				for(int j=0;j<8;j++){
					wp2[i][j]=new where_position();
				}
			}
			
			System.out.println("Gameboard");
			for(int i=0;i<2;i++){
				for(int j=0;j<8;j++){
					System.out.print(gameboard[i][j]+"  ");
				}
				System.out.println();
			}
			//STBB.draw_image();
			STBB.draw_image_background(wp2);
			/*for(int i=0;i<2;i++){
				for(int j=0;j<4;j++){
					 STBB.draw_one_background(i,j);
				}
			}*/
			//先check按的位置對不對 先在gameboard上做記號 把裡面的東西換成-1 
			//要先把原本裡面存的東西先撈出來
			//在畫圖那邊 遇到-1就顯示原本的卡牌 
			//再做判斷 看兩張有沒有一樣 
			//如果一樣 重新畫一張 繼續顯示
			canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
            	int the_first_card_image=-1;
            	int the_second_card_image=-1;
            	int flag=-1;
            	int the_first_x=-1;
            	int the_first_y=-1;
            	int the_second_x=-1;
            	int the_second_y=-1;
            	int total=16;
		            @Override
		            public void handle(MouseEvent event) {
		            	if(what_times_now==1){
		            		the_first_card_image=-1;
		                	the_second_card_image=-1;
		                	flag=-1;
		                	the_first_x=-1;
		                	the_first_y=-1;
		                	the_second_x=-1;
		                	the_second_y=-1;
		            	}
		            	//檢查現在滑鼠點的是哪一張牌 八張全部掃一次
		            	//第一次點 記牌子
		            	//第二次點 比對有沒有點到一樣的
		            	//一樣的就都留著
		            
		            	if(what_times_now==1){
		            		System.out.println("START1:"+what_times_now+"  P1X"+the_first_x+"   P1Y"+the_first_y);
		            		for(int i=0;i<2;i++){
			    				for(int j=0;j<8;j++){
			    					if(event.getX()>=wp2[i][j].get_position_x() && event.getX()<=wp2[i][j].get_position_x()+width && 
			    						event.getY()>=wp2[i][j].get_position_y() && event.getY()<=wp2[i][j].get_position_y()+height){
			    						the_first_card_image=gameboard[i][j];
			    						the_first_x=i;
			    						the_first_y=j;
			    						what_times_now=2;
			    						flag=1;
			    						break;
			    					}
			    				}
			    			}
		            		//System.out.println(the_first_x+"  "+the_first_y);
		            		//System.out.println(the_first_card_image);
		            		STBB.draw_one_card(the_first_x,the_first_y);
		    				System.out.println(what_times_now);
		    				//what_times_now=2;
		    				
		            	}else if(what_times_now==2 && gameboard[the_first_x][the_first_y]!=-1){
		            		System.out.println("START2:"+what_times_now+"  P2X"+the_second_x+"   P2Y"+the_second_y);
		            		for(int i=0;i<2;i++){
			    				for(int j=0;j<8;j++){
			    					if(event.getX()>=wp2[i][j].get_position_x() && event.getX()<=wp2[i][j].get_position_x()+width && 
			    						event.getY()>=wp2[i][j].get_position_y() && event.getY()<=wp2[i][j].get_position_y()+height){
			    						the_second_card_image=gameboard[i][j];
			    						the_second_x=i;
			    						the_second_y=j;
			    						what_times_now=1;
			    						flag=2;
			    						break;
			    					}
			    				}
		            		}
		            		STBB.draw_one_card(the_second_x, the_second_y);
		            		System.out.println(the_second_x+" "+what_times_now+" "+the_second_y);
		            	}else{
		            		STBB.draw_one_background(the_first_x,the_first_y);
	            			STBB.draw_one_background(the_second_x,the_second_y);
		            	}
		            	
		            	
		            
		            	if(flag==2){
		            		///第二張選完後要看有沒有一樣
		            		System.out.println("START1:"+what_times_now+"  P1X"+the_first_x+"   P1Y"+the_first_y);
		            		System.out.println("START2:"+what_times_now+"  P2X"+the_second_x+"   P2Y"+the_second_y);
		            		System.out.println("Get into Second card");
		            		if(the_first_card_image!=the_second_card_image){
		            			System.out.println("NOT THE SAME");
		            			STBB.draw_one_background(the_first_x,the_first_y);
		            			STBB.draw_one_background(the_second_x,the_second_y);
		            		}else if(the_first_card_image==the_second_card_image){
		            			System.out.println("SAME ONE");
		            			//STBB.draw_one_card(the_first_x,the_first_y);
		            			//STBB.draw_one_card(the_second_x, the_second_y);
		            			gameboard[the_first_x][the_first_y]=-1;
		            			gameboard[the_second_x][the_second_y]=-1;
		            			total=total-2;
		            		}
		            	}
		            	
		            if(total==0){
		            	System.out.println("END");
		            	try {
							gotoPhrase3();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		         }
		   	 });

	 }

}
