package problem144;

/**
 * Rework of Problem 144
 * http://0x5a4d.blogspot.com/2009/03/projecteuler-problem-144.html
 * @author c1dev
 *
 */
public class Second {

	
	private static final Coor start = new Coor(0,10.1);
	private static final Coor end = new Coor(1.4, -9.6);
	private static int bounces; //Counter of the number of bounces of the light
	private static double mConst;
	public Second()
	{
		bounces = 1;
	}
	
	public void run()
	{
		workWork(start,end);
		System.out.println("Done Done!  # of bounces = " + bounces);
	}
	
	private void workWork(Coor pStart, Coor pEnd)
	{
		Coor newEndPoint = new Coor();
		
		newEndPoint = getNextPoint(pStart, pEnd);
		System.out.println(newEndPoint);
		if(!isExit(newEndPoint) && bounces < 1000)
		{
			bounces++;
			workWork(pEnd, newEndPoint);
		}
		else
			return;
	}
	
	private boolean isExit(Coor input)
	{
		double X = input.getX();
		
		final double limit = 0.01;
		final Coor pExit = new Coor(0,10);
		return ((pExit.getX() - limit) <= X) && ((pExit.getX() + limit) >= X) && (input.getY() > 0);
	}
	
	private Coor getPointOnEllipse(double pX, double slope, Coor origin)
	{
		//4x^2 + y^2 = 100
		//y = mx + b
		//x is known;
		//y^2 = 100 - 4x^2
//		double coorY = Math.sqrt(100 - (4 * pX * pX));
//		
//		if(slope != getSlope(origin, new Coor(pX, coorY)))
//			coorY = -coorY;
//		
//		return new Coor(pX, coorY);
		
		return new Coor(pX, origin.getY() + slope*(pX - origin.getX()));
	}
	
	private Coor getNextPoint(Coor pStart, Coor pEnd)
	{
		//Slopes m0, m1, m2
		double m0, m1, m2;
		
		m0 = (pEnd.getY() - pStart.getY()) / (pEnd.getX() - pStart.getX());
		m1 = getTangentSlope(pEnd);
		
		//According to a graph, since a = a0 - a1 AND a = a1 + PI - a2;
		//tan(a) = (m0 - m1)/(1 + m0*m1)
		//tan(a) = (m1 - m2)/(1 + m1*m2)
		//As such; m2 = (m1 - ((m0 - m1)/(1 + m0*m1))) * (1 + ((m0 - m1)/(1 + m0*m1)) * m1)
		//Let X = (m0 - m1)/(1 + m0*m1);
		double testX = (m0 - m1)/(1 + (m0*m1));
		m2 = (m1 - testX)/(1 + (testX * m1));
		//System.out.println("Slope of Input: " + m0);
		//System.out.println("Slope of Tangent: " + m1 + " :::: " + testX);
		//System.out.println("Slope of Reflection: " + m2);
		
		double pX = quadraticEquation(m2, pEnd);
		//y - y0 = m(x - x0) + b;
		//y = y0 + m(x - x0) + b;
		//m = (y2 - y1)/(x2 - x1);
		//return new Coor(pX, pEnd.getY() + m2*(pX - pEnd.getX()) + mConst);
		return getPointOnEllipse(quadraticEquation(m2, pEnd), m2, pEnd);
	}
	
	private double quadraticEquation(double slope, Coor point)
	{
		//a*x^2 + b*x + c = 0
		//x^2*(4+a^2) + x*(2*a*b) + (b^2-100) = 0
		//where
		//a = m2
		//b = y0 - (m2*x0), where x0,y0 are the point of "origin"
		
		//x = -b (+/-) (sqrt(b^2 - (4ac)) / 2a)
		mConst = point.getY() - (slope * point.getX());
		double a = 4 + (slope * slope);
		double b = 2 * slope * mConst;
		double c = (mConst * mConst) - 100;
		
		double xPlus  = (-b + Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		double xMinus = (-b - Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		
		//System.out.println("Final Intersection: " + xPlus + " :OR: " + xMinus);
		
		//if((point.getY() - 0.00001 <= (slope * point.getX() + xPlus)) && (point.getY() + 0.00001 >= (slope * point.getX() + xPlus)))
		//	return xPlus;
		//else
		//	return xMinus;
		if((xMinus - 0.00001) <= point.getX() && (xMinus + 0.00001) >= point.getX())
			return xPlus;
		else
			return xMinus;
	}
	
	/**
	 * Gets the tangent slope of the ellipse at a given point
	 * @param input
	 * @return
	 */
	private double getTangentSlope(Coor input)
	{
		return (-4 * input.getX()) / (input.getY());
	}
	
	private double getSlope(Coor pStart, Coor pEnd)
	{
		return (pEnd.getY() - pStart.getY()) / (pEnd.getX() - pStart.getX());
	}
	
	
}

class Coor
{
	private double X,Y;
	public Coor()
	{
		this.X = 0d;
		this.Y = 0d;
	}
	
	public Coor(double X, double Y)
	{
		this.X = X;
		this.Y = Y;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
	
	public String toString()
	{
		return "Coordinate (X,Y): " + "(" + this.X + "," + this.Y + ")";
	}
}
