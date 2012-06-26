import static org.junit.Assert.*;

import org.junit.Test;


class PathfinderTests {
	
	@Test
	void shouldReturnAMoveGivenAGridAsAnArgument(){
		def pathfinder = new Pathfinder();
		pathfinder.move("You are player 1\n***********\n*..1...__.*\n....***...F\n*2........*\n***********")
	}

}
