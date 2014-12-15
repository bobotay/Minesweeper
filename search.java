package minesweeper;

public class Search {
	public void search(int x, int y){
		Search search = new Search();
		if((x > -1) && (x < 8) && (y > -1) && (y < 8) && !(MinesweeperGate.bank[x][y] == 9) && (MinesweeperGate.dispbank[x][y] == 12) && (MinesweeperGate.scan(x,y,0) > 0 || MinesweeperGate.bank[x][y] == 0)){
			MinesweeperGate.dispbank[x][y] = MinesweeperGate.bank[x][y];
			if(MinesweeperGate.bank[x][y] == 0){
				search.search(x, y+1);
				search.search(x, y-1);
				search.search(x-1, y);
				search.search(x-1, y+1);
				search.search(x-1, y-1);
				search.search(x+1, y);
				search.search(x+1, y+1);
				search.search(x+1, y-1);
			}
		}
	}
}
