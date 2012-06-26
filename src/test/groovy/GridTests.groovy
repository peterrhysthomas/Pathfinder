import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class GridTests {
	def gridAsString = "You are player 1\n***********\n*..1...__.*\n....***...F\n*2........*\n***********";
    def grid
	
	@Before
	void setUp(){
		grid = new Grid(gridAsString);
	}
	
	@Test
	void parsesStringInputIntoGrid(){
		assert grid.grid.size() == 5
		assert grid.grid[0].size() == 11
	}

	@Test
	void determinesThePlayerNumber(){
		assert grid.player == 1 as String
	}
	
	@Test
	void findsThePlayerPosition(){
		assert grid.playerXCoordinate == 3
		assert grid.playerYCoordinate == 1
		assert grid.getContents(grid.playerXCoordinate, grid.playerYCoordinate) == '1'
	}
	
	@Test
	void findsTheTargetPosition(){
		assert grid.targetXCoordinate == 10
		assert grid.targetYCoordinate == 2
	}
	
	@Test
	void findsACellsContents(){
		assert grid.getContents(0,0) == '*'
		assert grid.getContents(10,3) == '*'
		assert grid.getContents(8,1) == '_'
	}
	
	@Test
	void determinesWhetherACoordinateIsWithinGrid(){
		assert grid.isWithinGrid(1,1) == true
		assert grid.isWithinGrid(1,6) == false
		assert grid.isWithinGrid(12,1) == false
		assert grid.isWithinGrid(0,0) == true
		assert grid.isWithinGrid(-1,-1) == false	
		
		
	}
}
