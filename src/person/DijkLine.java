package person;

import java.util.Stack;

public class DijkLine {
	
	private int x;
	private int y;
	private int val;
	private Stack<Integer> LuCheng;
	

	public Stack<Integer> getLuCheng() {
		return LuCheng;
	}
	public void setLuCheng(Stack<Integer> luCheng) {
		LuCheng = luCheng;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public DijkLine(int x, int y, int val, Stack<Integer> stack) {
		this.x = x;
		this.y = y;
		this.val = val;
		LuCheng = stack;
	}

}
