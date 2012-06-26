class MoveCalculator {
	
	def grid
	
	public MoveCalculator(def grid){
		this.grid = grid
	}
	
	public String getNextMove(){
		def nextXCoordinate = grid.playerXCoordinate
		def nextYCoordinate = grid.playerYCoordinate
		if (grid.playerXCoordinate < grid.targetXCoordinate){
			nextXCoordinate++
		} else if (grid.playerXCoordinate > grid.targetXCoordinate){
			nextXCoordinate--
		} else if (grid.playerYCoordinate < grid.targetYCoordinate){
			nextYCoordinate++
		} else if (grid.playerYCoordinate > grid.targetYCoordinate){ 
			nextYCoordinate--
		}
		if (isSafeMove(nextXCoordinate, nextYCoordinate)){
			return evaluateNextMove(grid, nextXCoordinate, nextYCoordinate)
		} else {
		    performSafeRandomMove();
		}
	}
	
	private boolean isSafeMove(def x, def y){
		if (!grid.isWithinGrid(x,y)) return false
		return grid.getContents(x, y) == '.'
	}
	
	private String evaluateNextMove(def grid, def nextX, def nextY){
		def currentX = grid.playerXCoordinate
		def currentY = grid.playerYCoordinate
		
		if (nextX > currentX)       return 'E'
		else if (nextX < currentX)  return 'W'
		else if (nextY > currentY)  return 'S'
		else if (nextY < currentY)  return 'N'
	}
	
	private String performSafeRandomMove(){
		while(true){
			def random = new Random().nextInt(4)
			def x = 0
			def y = 0
			switch (random){
				case 0:
				  x++
				  break
				case 1:
				  x--
				  break
				case 2:
				  y++
				  break
				case 3:
				  y--
				  break
			}
			if (isSafeMove(grid.playerXCoordinate + x, grid.playerYCoordinate + y)){
				return evaluateNextMove(grid, grid.playerXCoordinate + x, grid.playerYCoordinate + y)
			}
		}
	}
}
