package problem144;

public class Problem144_Main {
	
	//A(x^2) + B(y^2) = C
	private static final double A = 4; 
	private static final double B = 1;
	private static final double C = 100;
	
	public static void main(String args[])
	{
		Second sec = new Second();
		sec.run();
		/*
		Coordinate v1 = new Coordinate(1.4d, -19.7d);
		Coordinate v2 = new Coordinate(-4.2d, -7.2d);
		Coordinate pureX = new Coordinate(1,0);
		Coordinate pureY = new Coordinate(0,1);
		Coordinate degree30 = new Coordinate(.5d,.5d);
		*/
		//checkAngle(v1,v2);
		//checkAngle(pureX, pureY);
		//checkAngle(new Coordinate(.5d, -.707d), new Coordinate(-4d, 10d));
		//checkAngle(degree30, pureX);
		//checkAngle(pureX, pureX);
		
		//TEST findConstantinSlope
		//Should equal -10.0
		//System.out.println("TEST: " + findConstantInSlope(2d, new Coordinate(10d,10d)));
		
		//m = tan(theta)
		//theta = arctan(m);
		
		/*------------------------------------*/
		//Given a starting point and end point, find the slope of reflection
		// then determine the next intersection on the ellipse
		//EUREKA MOMENT!  Angles are incorrect because the input line is not a vector coming from the origin!
		/*
		Coordinate pStart = new Coordinate(0,10.1d);
		Coordinate pEnd = new Coordinate(1.4,-9.6);
		Coordinate vector = new Coordinate().findVector(pStart, pEnd);
		//Find tangent slope at pEnd contact;
		double tangSlope = findTangentSlope(pEnd);
		//Get the normal line, which is perpendicular to the tangent line
		double normalLine = -(1d / tangSlope);
		double slopeConstant = findConstantInSlope(normalLine, pEnd);
		//checkAngle(pStart.findVector(pStart, pEnd), pStart.findUnitVectorOnSlope(tangSlope));
		
		System.out.println("---------===============------------");
		System.out.println("TEST ANGLE:: " + (Math.atan2(pEnd.findUnitVectorOnSlope(normalLine).getY(), pEnd.findUnitVectorOnSlope(normalLine).getX()) * (180/Math.PI)));
		System.out.println("TEST ANGLE:: " + Math.toDegrees((Math.atan2(-Math.sqrt(3),1))));
		double v1Angle = Math.atan2(pEnd.findUnitVectorOnSlope(normalLine).getY(), pEnd.findUnitVectorOnSlope(normalLine).getX());
		double v2Angle = Math.atan2(pEnd.findUnitVectorOnSlope(findSlope(pStart, pEnd)).getY(), pEnd.findUnitVectorOnSlope(findSlope(pStart, pEnd)).getX());
		double vDiff = 90+40.8936;
		System.out.println("v1 Angle::: " + Math.toDegrees(v1Angle));
		System.out.println("v2 Angle::: " + Math.toDegrees(v2Angle));
		//System.out.println("v3 Angle::: " + v3Angle);
		System.out.println("Differen::: " + vDiff);
		System.out.println("Slope   ::: " + Math.tan(Math.toRadians(vDiff)));
		
		//double v4Angle = checkAngle( pStart.findUnitVectorOnSlope(normalLine),pureY);
		//double v5Angle = checkAngle(vector.reverse(), pStart.findUnitVectorOnSlope(normalLine));
		//double v6Angle =  v4Angle + v5Angle;
		//System.out.println("New Angle: " + v6Angle + " :: Slope: " + Math.tan(v6Angle / (180 / Math.PI)));
		findIntersection(pEnd, Math.tan(Math.toRadians(vDiff)));
		//System.out.println("---------===============------------");
*/	}
	
	/**
	 * A and B act as vectors, not coordinates
	 * Returns an arccos value (i.e. 0 deg <= y <= 180 deg
	 * @param A
	 * @param B
	 */
	public static double checkAngle(Coordinate A, Coordinate B)
	{
		//A.B = |A||B|cos(theta);
		//cos(theta) = A.B / (|A||B|)
		//theta = arccos((A.B) / (|A||B|);
		double dotProduct = dotProd(A,B);
		double vecMag = (findMagnitude(A) * findMagnitude(B));
		//System.out.println("Dot Product: " + dotProduct);
		//System.out.println("Vector Magnitudes: " + vecMag);
		double result = Math.acos((dotProduct / vecMag)) * (180d / Math.PI);
		
		System.out.println("Angle between Vectors v1 and v2: " + result);
		return result;
	}
	
	/**
	 * Ellipse Equation
	 * http://mathworld.wolfram.com/Ellipse-LineIntersection.html
	 * @param pStart
	 * @param slope
	 */
	private static void findIntersection(Coordinate pStart, double slope)
	{
		/*
		 * Have to reduce the equation to ax^2 + bx + c = 0
		 * As such, get the y=mx+b values (m and b)
		 * replace y so that 4x^2 + B(mx+b)^2 = 100
		 * Reduce to above format and use quadratic equation to solve intersecting points of x
		 * use X and find y in quadratic equation
		 */
		
		double slopeConst = findConstantInSlope(slope, pStart);
		System.out.println("Test: y=m(x) + b; x="+pStart.getX()+" -- m="+slope+" -- b=" +slopeConst+" -- y="+ (slope*pStart.getX() + slopeConst));
		//y = slope(x) + slopeConst
		
		//4x^2 + B((m^2)(x^2) + 2mbx + b^2) = 100
		//4(x^2)*B*(m^2) + B*2mbx + B*(b^2) - 100 = 0
		double a = (A + slope * slope);
		double b = 2 * B * slope * slopeConst;
		double c = B*(slopeConst*slopeConst) - C;
		
		double xPlus  = (-b + Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		double xMinus = (-b - Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		
		System.out.println("Final Intersection: " + xPlus + " :OR: " + xMinus);
	}
	
	/**
	 * Finds the tangent slope based on the point on the ellipse
	 * @param coor
	 * @return
	 */
	private static double findTangentSlope(Coordinate coor)
	{
		return -((double)(A * coor.getX())) / (B * (double)coor.getY());
	}
	
	/**
	 * m = (B.Y - A.Y) / (B.X - A.X)
	 * @param A
	 * @param B
	 * @return
	 */
	private static double findSlope(Coordinate A, Coordinate B)
	{
		double aX, aY, bX, bY;
		aX = (double)A.getX();
		aY = (double)A.getY();
		bX = (double)B.getX();
		bY = (double)B.getY();
		
		return (bY - aY) / (bX - aX);
	}
	
	private static double findConstantInSlope(double slope, Coordinate point)
	{
		//y = m(x) + c
		//point.getY() = slope * point.getX() + c; find c
		
		//Use the broader version;
		//b^2 + 2mxb = -(4 + m^2)*(x^2) + 100
		//m, x are knowns, b is not
		//SO... (1)b^2 + (2mx)b + ((4 + m^2)x^2 + c) = 0
		
		double a = 1;
		double b = 2 * slope * point.getX();
		double c = ((4 + (slope * slope)) * (point.getX() * point.getX()) - C);
		
		double xPlus  = (-b + Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		double xMinus = (-b - Math.sqrt((b*b) - (4 * a * c))) / (2 * a);
		
		System.out.println("Constant in slope: " + xPlus + " :OR: " + xMinus);
		System.out.println("y = " + (slope * point.getX() + xPlus));
		System.out.println("y = " + (slope * point.getX() + xMinus));
		

		if((point.getY() - 0.00001 <= (slope * point.getX() + xPlus)) && (point.getY() + 0.00001 >= (slope * point.getX() + xPlus)))
			return xPlus;
		else
			return xMinus;
		
		
	}
	
	private static double dotProd(Coordinate A, Coordinate B)
	{
		return (A.getX() * B.getX()) + (A.getY() * B.getY());
	}
	
	private static double findMagnitude(Coordinate input)
	{
		return Math.sqrt((Math.pow(input.getX(), 2d)) + Math.pow(input.getY(), 2d));
	}
}

class Coordinate
{
	double X,Y;
	
	public Coordinate()
	{
		this.X = 0d;
		this.Y = 0d;
	}
	
	public Coordinate(double X, double Y)
	{
		this.X = X;
		this.Y = Y;
	}
	
	public Coordinate findUnitVectorOnSlope(double slope)
	{
		double theta = Math.atan(slope);
		return new Coordinate(Math.sin(theta),Math.cos(theta));
	}
	
	public Coordinate findVector(Coordinate A, Coordinate B)
	{
		return new Coordinate(B.getX() - A.getX(), B.getY() - A.getY());
	}
	
	public Coordinate reverse()
	{
		return new Coordinate(-this.X, -this.Y);
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
}
