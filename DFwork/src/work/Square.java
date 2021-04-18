package work;
import java.util.*;
public class Square {
	int Squ_size;
	char mark = ' ';
	char squ [][] ;
	
	//將接收到的數值拿來製作正方形的陣列
	public void Side_length(int len ,char chose_mark) {		
		Squ_size = len;
		squ = new char[len][len];
		mark = chose_mark;		
	}
	//清空陣列中的字元
	public void clean_squ() {
		for(int i = 0 ; i < Squ_size ; i++) {
			for(int j = 0 ; j < Squ_size ; j++) {
				squ[i][j] = ' ';
			}
		}
	}
	//把接收到的符號放進陣列
	public void set_squ() {
		for(int i = 0 ; i < Squ_size ; i++) {
			for(int j = 0 ; j < Squ_size ; j++) {
				squ[i][j] = mark;
			}
		}
	}

	public char[][] get_Squ(){
		return squ;
	}
	public char get_v() {
		return mark;
	}
	
}
