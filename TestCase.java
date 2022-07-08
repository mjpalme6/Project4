import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

class TestCase {
	 
	@Test
	public void Cluster() {
		assertNotNull(new KMCluster());
	}
	
	@Test
	public void Line() {
		assertNotNull(new NearestNeighbor());
		
	}
	
	@Test
	public void Centroid() {
		WorkArea work = new WorkArea();
		assertNotNull(new KMCluster().Centroid(work));
	}
	
	@Test
	public void WorkArea() {
		assertNotNull(new WorkArea());
	}
	
	@Test
	public void Main() {
		assertNotNull(new MainUI());
	}



}
