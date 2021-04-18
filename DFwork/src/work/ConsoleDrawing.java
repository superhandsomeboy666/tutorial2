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
		//設定好初始畫布
		DrawingCanvas.initialization();
		DrawingCanvas.set_Canvas();
		Canvas = DrawingCanvas.get_Canvas();
		
		//包開始四選項
		while(big) {
			chose();
			chose_num = sc.nextInt();
			
			
			switch(chose_num) {
			case 1: //triangles
				tir_boolean = true;
				while(tir_boolean) {
					while(true) { //直到輸入的三角形比正方型小才繼續
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
					chose_mark = sc.next().charAt(0);//抓字串第一個char
					
					Triangle.Side_length(input_num,chose_mark);//把輸入的值丟過去
					Triangle.set_tri();
					Tri = Triangle.get_Tri();
					
					Canvas = DrawingCanvas.get_Canvas();
					//獲取目前使用的字元
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
					//刷新畫布
					DrawingCanvas.set_Canvas();
					
					//旋轉三角形
					while(true) {
						//判斷要左轉還是右轉
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
						else {//輸入R L以外跳出
							break;
						}
						
						
						trun_temp = trun_temp%4;
			
						
						//角度呼叫過去
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
	
					DrawingCanvas.set_Canvas();//刷新畫布
					//判斷是否重新tri
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
					while(true) { //直到輸入的正方形比正方型小才繼續
						System.out.print("Side length :\n");
						input_num = sc.nextInt();
						if(Than_size(input_num)) {
							break;
						}
						else {
							System.out.println("Error! The side length is too long (Current canvas size is 10x6). Please try again.");						
						}
					}
					//使用者輸入的數值丟去square製作陣列
					System.out.print("Printing character:\r\n");
					chose_mark = sc.next().charAt(0);
					Square.Side_length(input_num,chose_mark);
					Square.set_squ();
					Squ=Square.get_Squ();
					now_V = Square.get_v();
					
					System.out.println("Alignment (left, middle, right):");
					chose_RF = sc.next();
					Canvas = DrawingCanvas.get_Canvas();//重製背景畫布
					//靠左還是靠右
					if(chose_RF.equals("left")) {	
						show_fix_Canvas(cover_left(Canvas,Squ,now_V));
					}else if(chose_RF.equals("right")) {
						show_fix_Canvas(cover_right(Canvas,Squ,now_V));
					}else if(chose_RF.equals("middle")) {
						show_fix_Canvas(cover_middle(Canvas,Squ,now_V));
					}else {
						show_fix_Canvas(cover_left(Canvas,Squ,now_V));
					}
					//放大縮小
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
						Canvas = DrawingCanvas.get_Canvas();//重製背景畫布
						
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
				
				//將輸入的新數值丟去更新畫布大小
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
	

	//主選單內容
	static void chose(){
		System.out.println("Please select an option. Type 4 to exit.\r\n"
				+ "1. Draw triangles\r\n"
				+ "2. Draw squares\r\n"
				+ "3. Update drawing canvas settings\r\n"
				+ "4. Exit");
	}
	
	//與畫布最小的邊比大小
	static boolean Than_size(int ta) {
		
		if(ta<=DrawingCanvas.get_v())
			return true;
		else
			return false;		
	}
	
	//把圖形貼上畫布的工具(靠左
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
	//圖案靠右邊合併畫布
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
	//圖案靠中邊合併畫布
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
	//印出合成完圖片
	static void show_fix_Canvas(char[][]fix) {
		
		for(int i = 0 ; i < fix.length;i++) {
			for(int j = 0 ; j < fix[i].length;j++) {
				System.out.print(fix[i][j]);
			}System.out.println();
		}
	}
}
