package work;
import java.util.*;
public class DrawingCanvas {

	static int Canvas_x;
	static int Canvas_y;
	static char background = ' ';
	static char Canvas [][] ;
	
	//��l�Ƶe��
	public void initialization(){
		Canvas_x = 10;
		Canvas_y = 6;
		background = '-';
		Canvas = new char[Canvas_y][Canvas_x];
		
	}
	
	//�]�w�Ѽ�
	public void set_parameter(int x,int y , char b) {
		Canvas_x = x;
		Canvas_y = y;
		background = b;		
	}
		
	//��ѼƱa�J�e��
	public static void set_Canvas() {
		Canvas = new char[Canvas_y][Canvas_x];
		
		for(int i = 0 ; i < Canvas_y ; i++) {
			for(int j = 0 ; j < Canvas_x;j++) {
				Canvas[i][j] = background;
			}
		}
		
	}
	//�����e��
	public char[][] get_Canvas() {
		return Canvas;
	}
	
	//�q�X�I��
	public void show_Canvas() {
		for(int i = 0 ; i < Canvas_y ; i++) {
			for(int j = 0 ; j < Canvas_x;j++) {
				System.out.print(Canvas[i][j]);
			}System.out.println();
		}
		System.out.println();
	}
	
	//�q�X���᪺�ƭ�
	public void show_V() {
		System.out.println("Current drawing canvas settings:");
		System.out.println("- Width: "+Canvas_x);
		System.out.println("- Height: "+Canvas_y);
		System.out.println("- Background character: "+background);
	}
	
	//����e�������e ��X����p����
	public static int get_v() {
		if(Canvas_y>Canvas_x) {
			return Canvas_x;
		}
		else {
			return Canvas_y;
		}
		 
	}
}
