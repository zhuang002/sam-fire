
public class Piece {
	private int status;
	private boolean isTaken;
	
	public Piece() {
		this.status = 0;
		this.isTaken = false;
	}
	
	
	public boolean is_occupied() {
		return status != 0;
	}
	
	public int get_status() {
		return this.status;
	}
	
	public boolean set_piece(int player) {
		if (this.status == 0) {
			this.status = player;
			this.isTaken = true; // ? Do not clear about what "is taken" stands for.
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public String toString() {
		
		if (this.status == -1) {
			return "-1 "; 
		} else {
			return " "+this.status+" ";
		}
	}
}
