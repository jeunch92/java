package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class AbsView {
	protected String getKeyInputString(String str) { //키보드로부터 값을 입력받기 위한 메소드
		String input = JOptionPane.showInputDialog(str + "입력");
		return input;
	}
	
	protected String getEnter() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	
	protected void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	abstract public void show();

}
