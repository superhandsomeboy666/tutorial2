package work;
import java.util.*;
public class Square {
	int Squ_size;
	char mark = ' ';
	char squ [][] ;
	
	//�N�����쪺�ƭȮ��ӻs�@����Ϊ��}�C
	public void Side_length(int len ,char chose_mark) {		
		Squ_size = len;
		squ = new char[len][len];
		mark = chose_mark;		
	}
	//�M�Ű}�C�����r��
	public void clean_squ() {
		for(int i = 0 ; i < Squ_size ; i++) {
			for(int j = 0 ; j < Squ_size ; j++) {
				squ[i][j] = ' ';
			}
		}
	}
	//�Ⱶ���쪺�Ÿ���i�}�C
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
