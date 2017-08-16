package org.fska.projects.problems100_199.problem102;

/**
 * 2-D coordinate class only!
 * @author c1dev
 *
 */
public class Coordinate {

	private int X;
	private int Y;
	
	public Coordinate()
	{
		this.X = 0;
		this.Y = 0;
	}
	
	public Coordinate(int X, int Y)
	{
		this.X = X;
		this.Y = Y;
	}
	
	public Coordinate subtract(Coordinate A, Coordinate B)
	{
		return new Coordinate(A.getX() - B.getX(), A.getY() - B.getY());
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	public int hashCode()
	{
		int hashCode = 0;
		hashCode += X;
		hashCode *= Y;
		return hashCode;
	}
}
