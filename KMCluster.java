import java.util.ArrayList;

/**
 * This class contains the method that is called by the "Run" button to create the two clusters.
 *
 * @author Makayla Eaves
 * @version 2022.07.05
 */
public class KMCluster implements ClusterHandler {
	int[] centroids = new int[4];
	ArrayList<Integer> blueX = new ArrayList<Integer>();
	ArrayList<Integer> blueY = new ArrayList<Integer>();
	ArrayList<Integer> redX = new ArrayList<Integer>();
	ArrayList<Integer> redY = new ArrayList<Integer>();
	
	/**
	 * This method is the constructor.
	 */
	public KMCluster() {
	}
	
	/**
	 * This method picks two random points on the JPanel to be the centroids
	 * 
	 * @param work - WorkArea to pass points
	 * @return centroids- returns integer array of 2 points (x and y values)
	 */
	public int[] Centroid(WorkArea work) {
		int width = work.work.getWidth();
		int height = work.work.getHeight();
		centroids[0] = (int) (Math.random() * width); // x2 //randoms between dimensions
		centroids[1] = (int) (Math.random() * height); //y2
		centroids[2] = (int) (Math.random() * width);//x2
		centroids[3] = (int) (Math.random() * height);//y2
		System.out.println(centroids[0] + centroids[1]+ centroids[2]+ centroids[3]);
		return centroids;	
	}
	
	/**
	 * This method is called to calculate the shorter distance of the two centroids and group it accordingly
	 * 
	 * @param work - WorkArea to pass the points
	 */
	public void Calculate(WorkArea work) {
		int[] centroids = Centroid(work);
		for (int i=0; i<work.aX.size(); i++) {
			//calculate the distance from each centroid
			int d1 = (int) Math.sqrt(
					(centroids[1] - work.aY.get(i)) * (centroids[1] - work.aY.get(i)) + 
					(centroids[0] - work.aX.get(i)) * (centroids[0] - work.aX.get(i)));
			int d2 = (int) Math.sqrt(
					(centroids[3] - work.aY.get(i)) * (centroids[3] - work.aY.get(i)) + 
					(centroids[2] - work.aX.get(i)) * (centroids[2] - work.aX.get(i))); 
			//find the shorter of the two distances
			if (d1 < d2) {
				blueX.add(work.aX.get(i));
				blueY.add(work.aY.get(i));				
			}else {
				redX.add(work.aX.get(i));
				redY.add(work.aY.get(i));
			}
			work.Cluster(blueX, blueY, redX, redY);
		}
	}
}
