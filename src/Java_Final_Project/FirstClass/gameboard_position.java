package Java_Final_Project.FirstClass;
import java.util.Random;

//製作卡牌配置介面---4張牌
//文字版
public class gameboard_position {
	private int[] check_position=new int [8];
	private int[] position_order=new int [8];
	private Random ran=new Random();
	private int[][] gameboard=new int [2][4];
	private int[] card_set=new int [4];
	private int[] check_position_card=new int [8];
	
	public gameboard_position(){
		for(int i=0;i<8;i++){
			check_position[i]=i;
			check_position_card[i]=i;
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				gameboard[i][j]=0;
			}
		}
	}
	public void image_order(){
		for(int i=0 ; i<4 ; i++){
			int a;
			a=(int)ran.nextInt(7);
			//有七種牌 拿四種出來
			do{
				a=(int)ran.nextInt(7);
			}while(check_position_card[a]==-1);
			
			card_set[i]=check_position_card[a];
			check_position_card[a]=-1;
		}
		for(int i=0;i<4;i++)System.out.print(card_set[i]+"  ");
		System.out.println();
		//return card_set;
	}
	public void gameboard_order(){
		for(int i=0 ; i<8 ; i++){
			int a;
			a=(int)ran.nextInt(8);
			do{
				a=(int)ran.nextInt(8);
			}while(check_position[a]==-1);
			
			position_order[i]=check_position[a];
			check_position[a]=-1;
		}
		
		for(int i=0;i<8;i++)System.out.print(position_order[i]+"  ");
		System.out.println();
		//return position_order;
	}
	
	public int[][] set_gameboard(){
		int j=0;
		for(int i=0;i<=7;){
			gameboard[position_order[i]/4][position_order[i]%4]=card_set[j];
			gameboard[position_order[i+1]/4][position_order[i+1]%4]=card_set[j];
			i=i+2;
			j++;
		}
		return gameboard;
	}
}
