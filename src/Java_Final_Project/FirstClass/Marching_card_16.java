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
	private int[][] gameboard=new int[2][8];//�s�e���W����m�A�C�Ӧ�m��s���h�֪��d
	private int[] card_used=new int[8];//�s���i�d�ιL�F�A�i�H���ܺɶq���n����
	private Random ran=new Random();//���ӶüƩ�d
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
			//��check������m�藍�� ���bgameboard�W���O�� ��̭����F�贫��-1 
			//�n����쥻�̭��s���F������X��
			//�b�e�Ϩ��� �J��-1�N��ܭ쥻���d�P 
			//�A���P�_ �ݨ�i���S���@�� 
			//�p�G�@�� ���s�e�@�i �~�����
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
		            	//�ˬd�{�b�ƹ��I���O���@�i�P �K�i�������@��
		            	//�Ĥ@���I �O�P�l
		            	//�ĤG���I ��靈�S���I��@�˪�
		            	//�@�˪��N���d��
		            
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
		            		///�ĤG�i�粒��n�ݦ��S���@��
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
