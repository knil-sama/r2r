package main.java;

import java.util.ArrayList;
import java.util.List;

public class LawnMowerOperator {

	private List<LawnMower> lawn_mowers;
	public LawnMowerOperator() {
		this.lawn_mowers= new ArrayList<LawnMower>();
	}

	public void add_lawn_mower(LawnMower lawmMower) {
		lawn_mowers.add(lawmMower);
	}

	public ArrayList<String> start_lawn_mowers() {
		ArrayList<String> curent_pos_dir_lawn_mowers = new ArrayList<String>();
		for(int i = 0; i < lawn_mowers.size(); i++){
			lawn_mowers.get(i).execute_instructions();
			curent_pos_dir_lawn_mowers.add(lawn_mowers.get(i).get_position_and_direction());
		}
		return curent_pos_dir_lawn_mowers;
	}
	
	

}
