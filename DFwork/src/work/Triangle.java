package work;
import java.util.*;
public class Triangle {
	int Tri_size;
	char mark = ' ';
	char tri [][] ;
	
	
	//�o�w�T���Τj�p
	public void Side_length(int len ,char chose_mark) {		
		Tri_size = len;
		tri = new char[len][len];
		mark = chose_mark;
		
		
	}
	//��ϮצL�W�h
	public void set_tri() {
		for(int i = 0 ; i < Tri_size ; i++) {
			for(int j = 0 ; j < Tri_size ; j++) {
				if( i+j < Tri_size) {
					tri[i][j] = mark;
				}
			}
		}
	}
	//�N�Ϯץ����R��
	public void set_start() {
		for(int i = 0 ; i < Tri_size ; i++) {
			for(int j = 0 ; j < Tri_size ; j++) {
				tri[i][j] = ' ';
				
			}
		}
	}
	//���ਤ��
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
	
	//�����T����
	public char[][] get_Tri(){
		return tri;
	}
	//�N�r����L�h
	public char get_V() {
		return mark;
	}
}
