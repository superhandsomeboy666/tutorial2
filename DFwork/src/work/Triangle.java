package work;
import java.util.*;
public class Triangle {
	int Tri_size;
	char mark = ' ';
	char tri [][] ;
	
	
	//這定三角形大小
	public void Side_length(int len ,char chose_mark) {		
		Tri_size = len;
		tri = new char[len][len];
		mark = chose_mark;
		
		
	}
	//把圖案印上去
	public void set_tri() {
		for(int i = 0 ; i < Tri_size ; i++) {
			for(int j = 0 ; j < Tri_size ; j++) {
				if( i+j < Tri_size) {
					tri[i][j] = mark;
				}
			}
		}
	}
	//將圖案全部刪除
	public void set_start() {
		for(int i = 0 ; i < Tri_size ; i++) {
			for(int j = 0 ; j < Tri_size ; j++) {
				tri[i][j] = ' ';
				
			}
		}
	}
	//旋轉角度
	public void turn(int num) {
		set_start();
		switch(num) {
		case 0:
		//	System.out.println(num);
			for(int i = 0 ; i < Tri_size ; i++) {
				for(int j = 0 ; j < Tri_size ; j++) {
					if( i+j < Tri_size) {
						tri[i][j] = mark;
					}
				}
			}
			break;
		case 1:
	
			for(int i = 0 ; i < Tri_size ; i++) {
				for(int j = 0 ; j < Tri_size ; j++) {
					if( i >=j ) {
						tri[i][j] = mark;
					}
				}
			}
			break;
			
		case 2:
	
			for(int i = 0 ; i < Tri_size ; i++) {
				for(int j = 0 ; j < Tri_size ; j++) {
					if( i+j >= Tri_size-1) {
						tri[i][j] = mark;
					}
				}
			}
			break;
		case 3:
	
			for(int i = 0 ; i < Tri_size ; i++) {
				for(int j = 0 ; j < Tri_size ; j++) {
					if( i <=j ) {
						tri[i][j] = mark;
					}
				}
			}
			break;
		}
	}
	
	//提取三角形
	public char[][] get_Tri(){
		return tri;
	}
	//將字元丟過去
	public char get_V() {
		return mark;
	}
}
