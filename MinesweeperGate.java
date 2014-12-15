package minesweeper;

import java.util.Random;


public class MinesweeperGate {

	public static int[][] bank =  new int[8][8];
	public static Integer[][] dispbank = new Integer[8][8];

	public static void main(String[] args) {

		setup();

		MineGUI.setupGUI();
	}

	public static void turn(int[] turn){
		int turned = 0;
			turned = bank[turn[0]][turn[1]];
			if (turned == 0){
				explode(turn[0], turn[1]);
			}else{
				dispbank[turn[0]][turn[1]] = turned;
			}
	}

	private static void setup(){

		for(int x1 = 0; x1 < 8; x1++){
			for(int y1 = 0; y1 < 8; y1++){
				dispbank[x1][y1] = 12;
			}
		}

		Random rand = new Random();

		int rx;
		int ry;
		int i = 0;

		while(i < 10){
			rx = rand.nextInt(8);
			ry = rand.nextInt(8);

			if(!(bank[rx][ry] == 9)){
				bank[rx][ry] = 9;
				i++;
			}
		}

		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(!(bank[x][y]==9)){
					bank[x][y] = scan(x,y,9);
				}
			}
		}
	}

	public static int scan(int o_x, int o_y, int searchFor){
		int count = 0;

		for(int x = (o_x-1); x < (o_x+2); x++){
			for(int y = (o_y-1); y < (o_y+2); y++){
				if(!(x<0) && !(x>7) && !(y<0) && !(y>7) && (bank[x][y] == searchFor) && !((o_x == x) && (o_y == y))){
					count++;
				}
			}
		}


		return count;
	}

	private static void explode(int x, int y){

		Search search = new Search();

		search.search(x, y);

	}

}
