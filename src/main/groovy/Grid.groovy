class Grid {
	
    def grid = [][]	
	def player
	def playerXCoordinate
	def playerYCoordinate
	def targetXCoordinate
	def targetYCoordinate
	
	public Grid(def gridAsString){
		parseGrid(gridAsString)
		calculatePositions()
	}

	private boolean parseGrid(gridAsString) {
		def firstLine = true
		
		gridAsString.split("\n").each() {line ->
			if (!firstLine)	grid.add(line.toCharArray())
			else  {
				player = line.replace('You are player ', '')
				firstLine = false
			}
		}
		return firstLine
	}
	
	private void calculatePositions(){
	    def x = 0, y = 0
		grid.each{line->
			x=0
			line.each { cell ->
				if (cell == player){
					playerXCoordinate = x
					playerYCoordinate = y
				} else if (cell =='F'){
					targetXCoordinate = x
					targetYCoordinate = y
				}
				x++
					
			}
			y++
		}
		
	}
	
	String getContents(def x, def y){
		return grid[y][x]
	}
	
	boolean isWithinGrid(x,y){
		if (y <  0 || y > (grid.size()-1) || x < 0 || x > (grid[y].size()-1)) {
			return false
		} 
		return true
	}
}
