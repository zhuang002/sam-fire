
public class Grid {
	private Piece[] data;
	
	public Grid() {
		this.data = new Piece[225];
		for (int i=0;i<this.data.length;i++) {
			data[i] = new Piece();
		}
	}
	
	static private int locate(int x, int y) {
		if (x>=15 || x<0 || y>=15 || y<0) {
			return -1;
		}
		return x*15+y;
	}
	
	private int get_status(int index) {
		return this.data[index].get_status();
	}
	
	public int get_status(int x, int y) {
		return this.get_status(locate(x,y));
	}
	
	public boolean set_piece(int x, int y, int player) {
		int index = locate(x,y);
		if (index<0 || index>=225)
			return false;
		return this.set_piece(index, player);
	}

	private boolean set_piece(int index, int player) {
		// TODO Auto-generated method stub
		if (index<0 || index>=225)
			return false;
		return this.data[index].set_piece(player);
	}
	
	@Override
	public String toString() {
		String s="";
		for (int x=0; x<15; x++) {
			for (int y=0;y<15;y++) {
				s+= this.data[locate(x,y)];
			}
			s+="\n"; // is last '\n' needed?
		}
		return s;
	}
}
