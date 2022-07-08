/**
 * This class contains the method that is called by the "Run" button to create the line.
 *
 * @author Makayla Eaves
 * @version 2022.06.19
 */
public class NearestNeighbor implements LineHandler{
	
	/**
	 * This is the constructor for the class.
	 */
	public NearestNeighbor() {	
	}
	
	/** 
	 * This method is calls the function to draw the line on the actual WorkArea.
	 * @param work - WorkArea with the points
	 */
	public void Calculate(WorkArea work) {
		work.Line();
	}
}

	    
	