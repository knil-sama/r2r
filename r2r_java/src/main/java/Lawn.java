package main.java;

import java.awt.Point;

public class Lawn {
	private Integer with, height;
	
	public Lawn(Integer width, Integer height) throws WrongDimensionLawnException {
		if(width <= 0 || height <= 0){
			throw new WrongDimensionLawnException("width and height need to be integer greater than 0");
		}
		this.with = width;
		this.height = height;
	}
	
	public boolean valid_move(Point position){
		return (position.x >= 0 && position.x <= this.with) && (position.y >= 0 && position.y <= this.height);
	}

}
