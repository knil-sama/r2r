package test.java;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import main.java.Lawn;
import main.java.LawnMower;
import main.java.LawnMowerOperator;
import main.java.WrongDimensionLawnException;

public class IntegrationTest {
	
	@Test
	public void test_final() throws IOException, WrongDimensionLawnException {
		String fileName_input = "src/test/ressources/input_integration_test.txt";
		Path path_input = FileSystems.getDefault().getPath(fileName_input);
		Iterator<String> datas = Files.readAllLines(path_input).iterator();

		//Create lawn
		String[] size_map = datas.next().trim().split(" ");
		Integer width = Integer.parseInt(size_map[0]);
		Integer height = Integer.parseInt(size_map[1]);
		Lawn test_lawn = new Lawn(width,height);
		LawnMowerOperator garry = new LawnMowerOperator();
		//Add lawnMowers
		while(datas.hasNext()){
			//create LawnMower
			String[] starting_position_string = datas.next().split(" ");
			Integer x_position = Integer.parseInt(starting_position_string[0]);
			Integer y_position = Integer.parseInt(starting_position_string[1]);
			Point position = new Point(x_position,y_position);
			char first_orientation = starting_position_string[2].charAt(0);;
			List<Character> instructions =  datas.next().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
			LawnMower lawmMower = new LawnMower(test_lawn,position,first_orientation,instructions);
			garry.add_lawn_mower(lawmMower);
		}

		ArrayList<String> final_positions_lawn_mowers = garry.start_lawn_mowers();
		String fileName_result = "src/test/ressources/expected_result_integration_test.txt";
		Path path_result = FileSystems.getDefault().getPath(fileName_result);
		List<String> final_positions_expected = Files.readAllLines(path_result);
		assertEquals(final_positions_expected, final_positions_lawn_mowers);
	}

}
