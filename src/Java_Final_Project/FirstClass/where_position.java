package Java_Final_Project.FirstClass;

public class where_position {
	private int position_x;
	private int position_y;
	
	public where_position(){
		position_x=0;
		position_y=0;
	}
	
	public int get_position_x(){
		return position_x;
	}
	
	public int get_position_y(){
		return position_y;
	}
	
	public void set_position(int x,int y){
		position_x=x;
		position_y=y;
	}
	
	public void print_position(){
		System.out.println(position_x+" "+position_y);
	}
}
