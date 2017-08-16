package org.fska.projects.problems100_199.problem102;

public class Triangle {

	private Coordinate A,B,C;

	public Triangle()
	{
		this.A = null;
		this.B = null;
		this.C = null;
	}

	public Triangle(Coordinate A, Coordinate B, Coordinate C)
	{
		this.A = A;
		this.B = B;
		this.C = C;
	}

	public double[] getAllXYintercepts()
	{
		double[] result = new double[6];
		Geometry geo = new Geometry();

		double[] resultAB = geo.findXYintercept(A, B);
		double[] resultBC = geo.findXYintercept(B, C);
		double[] resultCA = geo.findXYintercept(C, A);
		result[0] = resultAB[0];
		result[1] = resultAB[1];
		result[2] = resultBC[0];
		result[3] = resultBC[1];
		result[4] = resultCA[0];
		result[5] = resultCA[1];
		return result;
	}

	/**
	 * Finds the Min / Max Limits for both the X & Y planes
	 * result[0] and result[1] are for X, result[2] & result[3] are for Y
	 * @return
	 */
	private double[] findLimits()
	{
		double xMin, xMax;
		double yMin, yMax;

		//Check X coordinate first
		xMin = Math.min(this.A.getX(), this.B.getX());
		xMin = Math.min(xMin, this.C.getX());

		xMax = Math.max(this.A.getX(), this.B.getX());
		xMax = Math.max(xMax, this.C.getX());

		yMin = Math.min(this.A.getY(), this.B.getY());
		yMin = Math.min(yMin, this.C.getY());

		yMax = Math.max(this.A.getY(), this.B.getY());
		yMax = Math.max(yMax, this.C.getY());

		return new double[]{xMin, xMax, yMin, yMax};
	}
	public boolean checkIfOriginInside()
	{
		//effectively for each quadrant on a 2-D grid (I, II, III, IV)
		boolean[] quadrantCheck = new boolean[]{false,false,false,false};
		boolean XorY = true; //False for Y, True for X

		double[] limits = findLimits();
		for(double dbl : getAllXYintercepts())
		{
			//Check the Y intercept side
			if(XorY)
			{
				if((dbl >= limits[2] && dbl <= limits[3]))
				{
					if(dbl >= 0)
						quadrantCheck[0] = true;
					if(dbl < 0)
						quadrantCheck[2] = true;
				}
			}
			else
			{
				if((dbl >= limits[0] && dbl <= limits[1]))
				{
					if(dbl >= 0)
						quadrantCheck[1] = true;
					if(dbl < 0)
						quadrantCheck[3] = true;
				}
			}
			XorY = !XorY;
		}
		for(Boolean bool : quadrantCheck)
		{
			if(!bool)
			{
				return false;
			}
		}
		return true;
	}

	public Coordinate getA() {
		return A;
	}

	public void setA(Coordinate a) {
		A = a;
	}

	public Coordinate getB() {
		return B;
	}

	public void setB(Coordinate b) {
		B = b;
	}

	public Coordinate getC() {
		return C;
	}

	public void setC(Coordinate c) {
		C = c;
	}

	public int hashCode()
	{
		int hashCode = 0;

		hashCode += (A.getX() * B.getY()) + (B.getX() + A.getY());
		hashCode += (C.getX() * B.getY()) + (C.getX() + A.getY());
		hashCode += A.hashCode() * B.hashCode() * C.hashCode();
		return hashCode;
	}
}
