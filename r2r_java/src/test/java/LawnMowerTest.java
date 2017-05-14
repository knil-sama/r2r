package test.java;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.Lawn;
import main.java.LawnMower;
import main.java.WrongDimensionLawnException;

public class LawnMowerTest {

	@Test
	public void test_init_instruction_lawn_mover_1() throws IOException, WrongDimensionLawnException {
		Lawn lawn = new Lawn(5,6);
		Point initial_position = new Point(1,2);
		ArrayList<Character> instructions =  (ArrayList<Character>) "GAGAGAGAA".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		LawnMower test_lawn_mover = new LawnMower(lawn, initial_position, 'N', instructions);
		assertEquals("1 2 N",test_lawn_mover.get_position_and_direction());
		test_lawn_mover.execute_instructions();
		assertEquals("1 3 N",test_lawn_mover.get_position_and_direction());
	}
	
	@Test
	public void test_init_instruction_lawn_mover_2() throws IOException, WrongDimensionLawnException {
		Lawn lawn = new Lawn(6,6);
		Point initial_position = new Point(3,3);
		ArrayList<Character> instructions =  (ArrayList<Character>) "AADAADADDAAA".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		LawnMower test_lawn_mover = new LawnMower(lawn, initial_position, 'E', instructions);
		assertEquals("3 3 E",test_lawn_mover.get_position_and_direction());
		test_lawn_mover.execute_instructions();
		assertEquals("6 1 E",test_lawn_mover.get_position_and_direction());
	}
}
