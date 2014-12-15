package minesweeper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineGUI {
	public static JFrame frame = new JFrame("Minesweeper");
	public static JPanel panel = new JPanel();
	public static JButton[][] buttons = new JButton[8][8];
	public static JLabel win = new JLabel("You Win!");
	public static JLabel lose = new JLabel("You lose!");
	static int changeX = 0;
	static int changeY = 0;

	public static void setupGUI(){

		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				buttons[x][y] = new JButton();
				panel.add(buttons[x][y]);
				buttons[x][y].setSize(20,20);


				buttons[x][y].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int x = ((JButton) e.getSource()).getX();
						int y = ((JButton) e.getSource()).getY();
						if (e.getButton() == MouseEvent.BUTTON3) {
							MinesweeperGate.dispbank[Math.round((float)y/(float)changeY)][Math.round((float)x/(float)changeX)] = 11;
						}else{
							MinesweeperGate.turn(new int[]{
									Math.round((float)y/(float)changeY), Math.round((float)x/(float)changeX)
							});
						}
						draw();
					}
				});
			}
		}

		frame.setVisible(true);
		draw();
		panel.setVisible(true);
		frame.add(panel);
		frame.setSize(644,296);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeX = frame.getWidth()/8;
		changeY = frame.getHeight()/8;
		frame.setResizable(false);

	}

	public static void draw(){
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(!(MinesweeperGate.dispbank[x][y] == 0) && !(MinesweeperGate.dispbank[x][y] == 9) && !(MinesweeperGate.dispbank[x][y] == 11) && !(MinesweeperGate.dispbank[x][y] == 12)){
					buttons[x][y].setText(Integer.toString(MinesweeperGate.dispbank[x][y]));
				}else if(MinesweeperGate.dispbank[x][y] == 0){
					buttons[x][y].setText("");
					buttons[x][y].setEnabled(false); 
				}else if(MinesweeperGate.dispbank[x][y] == 11){
					buttons[x][y].setText("F");
				}else if(MinesweeperGate.dispbank[x][y] == 9){
					panel.removeAll();
					panel.add(lose);
				}else{
					buttons[x][y].setText("");
				}

			}
	 	}
		
		boolean twelves[] = {
				Arrays.asList(MinesweeperGate.dispbank[0]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[1]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[2]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[3]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[4]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[5]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[6]).contains(12),
				Arrays.asList(MinesweeperGate.dispbank[7]).contains(12),
		};
		
		boolean tf = false;
		
		for(boolean value: twelves){
			  if(value){  tf=true;}
			}
		
		if(!tf){
			panel.removeAll();
			panel.add(win);
		}
		
		panel.repaint();
	}
}
