import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

class MoveCalculatorTests {
	
	@Test
	void movesEastWhenTargetIsEastOfPlayer(){
		def grid = new Grid("You are player 1\n1..F");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'E'	
	}
	
	@Test
	void movesWestWhenTargetIsWestOfPlayer(){
		def grid = new Grid("You are player 1\nF..1");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'W'
	}
	
	@Test
	void movesNorthWhenTargetIsNorthOfPlayer(){
		def grid = new Grid("You are player 1\nF\n.\n.\n1");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'N'
	}
	
	@Test
	void movesSouthWhenTargetIsSouthOfPlayer(){
		def grid = new Grid("You are player 1\n1\n.\n.\nF");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'S'
	}

	@Test
	void doesntMoveIntoWallsWhenMovingEast(){
		def grid = new Grid("You are player 1\n1*\n..\n..\n.F");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'S'
	}
	
	@Test
	void doesntMoveIntoWallsWhenMovingWest(){
		def grid = new Grid("You are player 1\nF.\n..\n..\n*1");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'N'
	}

	@Test
	void doesntMoveIntoWallsWhenMovingNorth(){
		def grid = new Grid("You are player 1\nF.\n..\n*.\n1.");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'E'
	}
	
	@Test
	void doesntMoveIntoWallsWhenMovingSouth(){
		def grid = new Grid("You are player 1\n1.\n*.\n..\nF.");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'E'
	}

	@Test
	void doesntMoveIntoOppositionPlayersCell(){
		def grid = new Grid("You are player 1\n1.\n2.\n..\nF.");
		def calculator = new MoveCalculator(grid)
		assert calculator.nextMove == 'E'
	}
	
	@Test
	@Ignore
	void canMoveIntoAnIceCell(){
		
	}

}
