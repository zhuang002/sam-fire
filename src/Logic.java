
public class Logic {
	static Grid grid = new Grid();
	static int currentPlayer = 0;
	static int lastX=-1;
	static int lastY=-1;
	
	static public boolean deploy(int x, int y, int player) {
		if (player!=0 || player !=1) {
			return false;
		}
		if (!grid.set_piece(x, y, player)) {
			return false;
		} else {
			currentPlayer=(currentPlayer+1)%2;
			lastX = x;
			lastY = y;
		}
		return true;
	}
	
	static public boolean checkWins() {
		int lastPlayer = (currentPlayer+1)%2;
		int put = (lastPlayer == 0)?-1:1;
		return checkWins(lastX,lastY, put);
	}

	private static boolean checkWins(int x, int y, int put) {
		// TODO Auto-generated method stub
		
		// check horizontal
		int count = 1;
		count += checkDirection(x,y,-1,0, put); // check left
		count += checkDirection(x,y,1,0,put); // check right;
		if (count>=5) return true;
		
		// check vertical;
		count = 1;
		count += checkDirection(x,y,0,-1, put); // check up
		count += checkDirection(x,y,0,1,put); // check down;
		if (count>=5) return true;
		
		// check back slash
		count = 1;
		count += checkDirection(x,y,-1,-1, put); // check up left
		count += checkDirection(x,y,1,1,put); // check down right
		if (count>=5) return true;
		
		
		
		// check slash
		count = 1;
		count += checkDirection(x,y,1,-1, put); // check up right
		count += checkDirection(x,y,-1,1,put); // check down left
		if (count>=5) return true;
		
		return false;
	}

	private static int checkDirection(int x, int y, int x_step, int y_step, int put) {
		// TODO Auto-generated method stub
		int count=0;
		int currentX = x + x_step;
		int currentY = y + y_step;
		
		while (currentX>=0 && currentX<15 && currentY>=0 && currentY<15 && grid.get_status(currentX, currentY)==put) {
			count++;
			currentX = x + x_step;
			currentY = y + y_step;
		}
		return count;
	}

}
