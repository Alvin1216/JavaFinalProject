package Java_Final_Project.FirstClass;
import java.util.Random;

//製作卡牌配置介面---16張牌
//文字版
public class gameboard_position_16 {
	private int[] check_position=new int [16];
	private int[] position_order=new int [16];
	private Random ran=new Random();
	private int[][] gameboard=new int [2][8];
	private int[] card_set=new int [8];
	private int[] check_position_card=new int [16];
	
	public gameboard_position_16(){
		for(int i=0;i<16;i++){
			check_position[i]=i;
			check_position_card[i]=i;
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<8;j++){
				gameboard[i][j]=0;
			}
		}
	}
	public void image_order(){
		for(int i=0 ; i<8 ; i++){
			int a;
			a=(int)ran.nextInt(8);
			//有七種牌 拿四種出來
			do{
				a=(int)ran.nextInt(8);
			}while(check_position_card[a]==-1);
			
			card_set[i]=check_position_card[a];
			check_position_card[a]=-1;
		}
		System.out.println("image_order");
		for(int i=0;i<8;i++)System.out.print(card_set[i]+"  ");
		System.out.println();
		//return card_set;
	}
	public void gameboard_order(){
		for(int i=0 ; i<16 ; i++){
			int a;
			a=(int)ran.nextInt(16);
			do{
				a=(int)ran.nextInt(16);
			}while(check_position[a]==-1);
			
			position_order[i]=check_position[a];
			check_position[a]=-1;
		}
		System.out.println("gameboard_order");
		for(int i=0;i<16;i++)System.out.print(position_order[i]+"  ");
		System.out.println();
		//return position_order;
	}
	
	public int[][] set_gameboard(){
		int j=0;
		for(int i=0;i<=15;){
			gameboard[position_order[i]/8][position_order[i]%8]=card_set[j];
			gameboard[position_order[i+1]/8][position_order[i+1]%8]=card_set[j];
			i=i+2;
			j++;
		}
		return gameboard;
	}
}
