package work;
import java.util.*;
import java.util.Scanner.*;
public class ConsoleDrawing {
	public static void main(String[] args) {
		
		char Canvas [][] , Tri[][],now_V,Squ[][];
		boolean True = true , tir_boolean = true,big=true;
		Scanner sc = new Scanner(System.in);
		Square Square = new Square();
		Triangle Triangle = new Triangle();
		DrawingCanvas DrawingCanvas = new DrawingCanvas();
		int chose_num,input_num,trun_temp,change_x,change_y;
		char chose_mark,turn_RT,user_input,chose_IO;
		String chose_RF;
		System.out.println("----WELCOME TO MY CONSOLE DRAWING APP----\n"
				+ "Current drawing canvas settings:\r\n"
				+ "- Width: 10\n"
				+ "- Height: 6\r\n"
				+ "- Background character: - \n");
		//�]�w�n��l�e��
		DrawingCanvas.initialization();
		DrawingCanvas.set_Canvas();
		Canvas = DrawingCanvas.get_Canvas();
		
		//�]�}�l�|�ﶵ
		while(big) {
			chose();
			chose_num = sc.nextInt();
			
			
			switch(chose_num) {
			case 1: //triangles
				tir_boolean = true;
				while(tir_boolean) {
					while(true) { //�����J���T���Τ񥿤諬�p�~�~��
						System.out.print("Side length :\n");
						input_num = sc.nextInt();
						if(Than_size(input_num)) {
							break;
						}
						else {
							System.out.println("Error! The side length is too long (Current canvas size is 10x6). Please try again.");						
						}
					}
					
					System.out.println("Printing character:");
					chose_mark = sc.next().charAt(0);//��r��Ĥ@��char
					
					Triangle.Side_length(input_num,chose_mark);//���J���ȥ�L�h
					Triangle.set_tri();
					Tri = Triangle.get_Tri();
					
					Canvas = DrawingCanvas.get_Canvas();
					//����ثe�ϥΪ��r��
					now_V = Triangle.get_V();
					System.out.println("Alignment (left, middle, right):");
					chose_RF = sc.next();
					
					if(chose_RF.equals("left")) {
						show_fix_Canvas(cover_left(Canvas,Tri,now_V));
					}else if(chose_RF.equals("right")) {
						show_fix_Canvas(cover_right(Canvas,Tri,now_V));
					}else if(chose_RF.equals("middle")) {
						show_fix_Canvas(cover_middle(Canvas,Tri,now_V));
					}else {
						show_fix_Canvas(cover_left(Canvas,Tri,now_V));
					}
					trun_temp =0;
					//��s�e��
					DrawingCanvas.set_Canvas();
					
					//����T����
					while(true) {
						//�P�_�n�����٬O�k��
						System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
						turn_RT = sc.next().charAt(0);
						if(turn_RT == 'l' || turn_RT =='L') {
							trun_temp ++;
						}else if(turn_RT == 'r' || turn_RT =='R') {
							if(trun_temp==0) {
								trun_temp = trun_temp +3;
							}
							else {
								trun_temp--;
							}
						}
						else {//��JR L�H�~���X
							break;
						}
						
						
						trun_temp = trun_temp%4;
			
						
						//���שI�s�L�h
						Triangle.turn(trun_temp);
						DrawingCanvas.set_Canvas();
						Tri = Triangle.get_Tri();//get new tri
						Canvas = DrawingCanvas.get_Canvas();
						
						if(chose_RF.equals("left")) {
							show_fix_Canvas(cover_left(Canvas,Tri,now_V));					
						}else if(chose_RF.equals("right")) {
							show_fix_Canvas(cover_right(Canvas,Tri,now_V));
						}else if(chose_RF.equals("middle")) {
							show_fix_Canvas(cover_middle(Canvas,Tri,now_V));
						}else {
							show_fix_Canvas(cover_left(Canvas,Tri,now_V));
						}
				
					}	
	
					DrawingCanvas.set_Canvas();//��s�e��
					//�P�_�O�_���stri
					System.out.println("Draw another triangle (Y/N)?");
					user_input = sc.next().charAt(0);
					if(user_input == 'Y'||user_input == 'y') {
						tir_boolean = true;
					}else if (user_input == 'N'||user_input == 'n') {
						tir_boolean = false;
					}
				}
				
				break;
			case 2: // squares
				tir_boolean = true;
				while(tir_boolean) {
					while(true) { //�����J������Τ񥿤諬�p�~�~��
						System.out.print("Side length :\n");
						input_num = sc.nextInt();
						if(Than_size(input_num)) {
							break;
						}
						else {
							System.out.println("Error! The side length is too long (Current canvas size is 10x6). Please try again.");						
						}
					}
					//�ϥΪ̿�J���ƭȥ�hsquare�s�@�}�C
					System.out.print("Printing character:\r\n");
					chose_mark = sc.next().charAt(0);
					Square.Side_length(input_num,chose_mark);
					Square.set_squ();
					Squ=Square.get_Squ();
					now_V = Square.get_v();
					
					System.out.println("Alignment (left, middle, right):");
					chose_RF = sc.next();
					Canvas = DrawingCanvas.get_Canvas();//���s�I���e��
					//�a���٬O�a�k
					if(chose_RF.equals("left")) {	
						show_fix_Canvas(cover_left(Canvas,Squ,now_V));
					}else if(chose_RF.equals("right")) {
						show_fix_Canvas(cover_right(Canvas,Squ,now_V));
					}else if(chose_RF.equals("middle")) {
						show_fix_Canvas(cover_middle(Canvas,Squ,now_V));
					}else {
						show_fix_Canvas(cover_left(Canvas,Squ,now_V));
					}
					//��j�Y�p
					while(true) {
						System.out.println("Type I/O to zoom in/out. Use other keys to continue.");				
						chose_IO = sc.next().charAt(0);
						if(chose_IO == 'o'||chose_IO == 'O') {
							
							if(input_num ==1) {}
							else {
								input_num--;								
							}
					//		Square.change_IO(chose_IO);
						}else if(chose_IO == 'i'||chose_IO == 'I') {
							
							if(input_num >= DrawingCanvas.get_v()) {}
							else {
								input_num++;
							}
					//		Square.change_IO(chose_IO);
						}else {
							break;
						}
						Square.Side_length(input_num,chose_mark);
						DrawingCanvas.set_Canvas();
						Square.set_squ();
						Squ=Square.get_Squ();
						Canvas = DrawingCanvas.get_Canvas();//���s�I���e��
						
						if(chose_RF.equals("left")) {	
							show_fix_Canvas(cover_left(Canvas,Squ,now_V));
						}else if(chose_RF.equals("right")) {
							show_fix_Canvas(cover_right(Canvas,Squ,now_V));
						}else if(chose_RF.equals("middle")) {
							show_fix_Canvas(cover_middle(Canvas,Squ,now_V));
						}else {
							show_fix_Canvas(cover_left(Canvas,Squ,now_V));
						}
					}
					System.out.println("Draw another square (Y/N)?");
					user_input = sc.next().charAt(0);
					if(user_input == 'Y'||user_input == 'y') {
						tir_boolean = true;
					}else if (user_input == 'N'||user_input == 'n') {
						tir_boolean = false;
					}
				}
				Square.clean_squ();
				break;
			case 3: // Update drawing canvas settings
				System.out.print("Canvas width: ");				
				change_x = sc.nextInt();
				System.out.print("Canvas height: ");
				change_y = sc.nextInt();
				System.out.println("Background character: "
						+"Drawing canvas has been updated!");
				chose_mark = sc.next().charAt(0);
				System.out.println();
				
				//�N��J���s�ƭȥ�h��s�e���j�p
				DrawingCanvas.set_parameter(change_x,change_y,chose_mark);
				DrawingCanvas.set_Canvas();
				DrawingCanvas.show_V();
				System.out.println();
		
				break;
			case 4:
				big = false;
				System.out.println("GoodBye!");
				break;
			default:
				System.out.println("Unsupported option. Please try again!");
							
			}
		}
	
	}
	

	//�D��椺�e
	static void chose(){
		System.out.println("Please select an option. Type 4 to exit.\r\n"
				+ "1. Draw triangles\r\n"
				+ "2. Draw squares\r\n"
				+ "3. Update drawing canvas settings\r\n"
				+ "4. Exit");
	}
	
	//�P�e���̤p�����j�p
	static boolean Than_size(int ta) {
		
		if(ta<=DrawingCanvas.get_v())
			return true;
		else
			return false;		
	}
	
	//��ϧζK�W�e�����u��(�a��
	static char[][] cover_left(char[][]back,char[][]on,char V) {
		char [][] fix = back.clone();
		DrawingCanvas.set_Canvas();
		
		for(int i = 0 ; i < on.length;i++) {
			for(int j = 0 ; j < on[i].length;j++) {
				if(on[i][j]==V) {
					fix[i][j] = V;  
				}
			}
		}
		return fix;	
	}
	//�Ϯ׾a�k��X�ֵe��
	static char[][] cover_right(char[][]back,char[][]on,char V) {
		char [][] fix = back.clone();
		DrawingCanvas.set_Canvas();
		
		for(int i = 0 ; i < on.length;i++) {
			for(int j = 0 ; j < on[i].length;j++) {
				if(on[i][j]==V) {
					fix[i][j+(back[i].length-on.length)] = V;  
				}
			}
		}
		return fix;	
	}
	//�Ϯ׾a����X�ֵe��
	static char[][] cover_middle(char[][]back,char[][]on,char V) {
		char [][] fix = back.clone();
		DrawingCanvas.set_Canvas();
		
		for(int i = 0 ; i < on.length;i++) {
			for(int j = 0 ; j < on[i].length;j++) {
				if(on[i][j]==V) {
					fix[i][j+((back[i].length-on.length)/2)] = V;  
				}
			}
		}
		return fix;	
	}
	//�L�X�X�����Ϥ�
	static void show_fix_Canvas(char[][]fix) {
		
		for(int i = 0 ; i < fix.length;i++) {
			for(int j = 0 ; j < fix[i].length;j++) {
				System.out.print(fix[i][j]);
			}System.out.println();
		}
	}
}
