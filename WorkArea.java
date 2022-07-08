import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class contains the Work Area that the user can place dots on. It displays the line or cluster.
 *
 * @author Makayla Eaves
 * @version 2022.07.05
 */
public class WorkArea extends JPanel implements MouseListener{
	ArrayList<Integer> aX = new ArrayList<Integer>();
	ArrayList<Integer> aY = new ArrayList<Integer>();
	ArrayList<Integer> bX = new ArrayList<Integer>();
	ArrayList<Integer> bY = new ArrayList<Integer>();
	ArrayList<Integer> rX = new ArrayList<Integer>();
	ArrayList<Integer> rY = new ArrayList<Integer>();
	int x,y;
	JPanel work;
	boolean line, cluster;
	
	/**
	 * This method contains the constructor for the WorkArea object.
	 */
	public WorkArea() {
		work = new JPanel();
		this.addMouseListener(this);
		this.add(work);
	}

	/**
	 * This method contains the paint components to draw on the Work Area. It draws the arraylist of
	 * dots that is added to with each new click.
	 * @param g - graphics 
	 */
	@Override
    public void paintComponent (Graphics g){
	int i,j=1;
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (i = 0; i<aX.size(); i++){
            g.fillOval(aX.get(i), aY.get(i), 5, 5);
        }
        //only draws the following when line is chosen
        if (line) {
        	g.setColor(Color.BLACK);
        	for (int f = 0; f<aX.size()-1; f++) {
        		g.drawLine(aX.get(f), aY.get(f), aX.get(j), aY.get(j));
        		j++;
        	}
        }
        //only draws the following when cluster is chosen
        if (cluster) {
        	//blue cluster
        	g.setColor(Color.BLUE);
            for (i = 0; i<bX.size(); i++){
                g.fillOval(bX.get(i), bY.get(i), 5, 5);
            }
            //red cluster
            g.setColor(Color.RED);
            for (i = 0; i<rX.size(); i++){
                g.fillOval(rX.get(i), rY.get(i), 5, 5);
            }
        }
        //reset WorkArea to only dots
        line = false;
        cluster = false;
        }
	
	/**
	 * This method is called to draw a line between points.
	 */
	public void Line() {
		line = true;
		cluster = false;
		repaint();
	}
	
	/**
	 * This method is called to color the points in their designated cluster.
	 */
	public void Cluster(ArrayList<Integer> bx, ArrayList<Integer> by, 
			ArrayList<Integer> rx, ArrayList<Integer> ry) {
		bX = bx;
		bY = by;
		rX = rx;
		rY = ry;
		line = false;
		cluster = true;
		repaint();
	}
     
	/**
	 * This method contains the events that occur when the mouse is clicked.
	 * @param e the event that calls the action
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		aX.add(x);
		aY.add(y);
		repaint();
	}

	/**
	 * The following handler methods are not used in this project.
	 * @param e the event that calls the action
	 */
	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
