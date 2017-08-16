package org.fska.projects.problems100_199.problem102;

public class Geometry {

	/**
	 * Returns an array of 2 doubles;
	 * result[0] is the Y intercept
	 * result[1] is the X intercept
	 * @param A
	 * @param B
	 * @return
	 */
	public double[] findXYintercept(Coordinate A, Coordinate B)
	{
		//Slope formula: y=(mx)+b
		double result[] = new double[2];
		double slope = findSlope(A, B);
		double b = findB (A, findSlope( A, B));
		result[0] = b;
		result[1] = -(b/slope);
		return result;
	}
	
	private double findSlope(Coordinate A, Coordinate B)
	{
		double slope = 0d;
		if(A.getX() == B.getX() || A.getY() == B.getY())
		{
			System.out.println("There's a straight line here!");
			if(A.getX() == B.getX())
				System.out.println("There should be a stack trace!  Line is Very VERY Vertical");
		}
			if(A.getX() == B.getX())
				return Double.MAX_VALUE;
			slope = ((double)(B.getY() - A.getY())) / ((double)(B.getX() - A.getX()));
		return slope;
	}
	
	private double findB(Coordinate A, double slope)
	{
		double b = (double)A.getY() - (slope * A.getX());
		return b;		
	}
}
