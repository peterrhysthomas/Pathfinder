class Pathfinder {

	void move(args) {
		def grid = new Grid(args)
		def calculator = new MoveCalculator(grid)
		println calculator.nextMove
	}

}
