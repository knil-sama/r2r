package main.java;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;


public class LawnMower {
	public enum Direction {
		// @warning we will cycle through enum so don't change order of value
		WEST, NORTH, EAST, SOUTH;
		public Direction turn_right() {
			return values()[(ordinal() + 1) % values().length];
		}
		public Direction turn_left() {
			return values()[(ordinal()+ values().length - 1) % values().length];
		}
	}
	public enum Action {
		TURN_LEFT, TURN_RIGHT, FORWARD
	}
	private Point position;
	private Direction direction;
	private Iterator<Action> instructions;
	private Lawn lawn;
	public LawnMower(Lawn lawn, Point initial_position, char first_orientation, List<Character> instructions) {
		this.direction = convert_char_to_direction(first_orientation);
		this.position = initial_position;
		this.instructions = instructions.stream().map(this::convert_char_to_action).iterator();
		this.lawn = lawn;
	}

	private Direction convert_char_to_direction(char char_direction){
		Direction direction = null;
		switch (char_direction) {
		case 'N':  direction=Direction.NORTH;
		break;
		case 'W':  direction=Direction.WEST;
		break;
		case 'E':  direction=Direction.EAST;
		break;
		case 'S':  direction=Direction.SOUTH;
		break;
		}
		return direction;
	}


	public Point execute_instructions(){
		Action current_instruction;
		while(this.instructions.hasNext()){
			current_instruction = this.instructions.next();
			switch(current_instruction){
			case TURN_LEFT:
				this.direction = this.direction.turn_left();
				break;	
			case TURN_RIGHT:
				this.direction = this.direction.turn_right();
				break;
			case FORWARD:
				this.move_forward();
				break;
			default:
				//@todo raise exception ?
				break; 
			}
		}
		return position;
	}
	private void move_forward() {
		Point new_position = new Point(position);
		switch(this.direction){
		case NORTH:
			new_position.translate(0, 1);
			break;
		case EAST:
			new_position.translate(1, 0);
			break;
		case SOUTH:
			new_position.translate(0, -1);
			break;
		case WEST:
			new_position.translate(-1, 0);
			break;
		default:
			break;
		}
		if(lawn.valid_move(new_position)){
			this.position = new_position;
		}
	}

	private Action convert_char_to_action(char char_instruction){
		Action action = null;
		switch (char_instruction) {
		case 'G':  action=Action.TURN_LEFT;
		break;
		case 'D':  action=Action.TURN_RIGHT;
		break;
		case 'A':  action=Action.FORWARD;
		break;
		}
		return action;
	}

	public String get_position_and_direction() {
		return position.x + " " + position.y + " " + direction.toString().charAt(0);
	}

}
