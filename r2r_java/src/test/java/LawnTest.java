package test.java;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.Lawn;
import main.java.WrongDimensionLawnException;

public class LawnTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_init_0_width() throws IOException, WrongDimensionLawnException {
		exception.expect(WrongDimensionLawnException.class);
		new Lawn(0,10);
	}
	@Test
	public void test_init_negative_height() throws IOException, WrongDimensionLawnException {
		exception.expect(WrongDimensionLawnException.class);
		new Lawn(10,-5);
	}
	
	@Test
	public void test_good_move() throws IOException, WrongDimensionLawnException {
		Lawn test_lawn = new Lawn(10,5);
		assertTrue(test_lawn.valid_move(new Point(1,1)));
	}
	
	@Test
	public void test_outside_lawn_move() throws IOException, WrongDimensionLawnException {
		Lawn test_lawn = new Lawn(1,1);
		assertFalse(test_lawn.valid_move(new Point(1,1)));
		assertFalse(test_lawn.valid_move(new Point(0,1)));
		assertFalse(test_lawn.valid_move(new Point(1,0)));
		assertFalse(test_lawn.valid_move(new Point(-1,0)));
		assertFalse(test_lawn.valid_move(new Point(0,-1)));
		assertTrue(test_lawn.valid_move(new Point(0,0)));
		
	}
	
	
}
