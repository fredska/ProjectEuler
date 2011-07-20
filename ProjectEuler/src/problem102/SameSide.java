package problem102;

public class SameSide {

	public boolean testOrigin(Triangle tri)
	{
		Coordinate origin = new Coordinate(0,0);
		Long dot00, dot01, dot02, dot11, dot12;
		
		Coordinate v0 = new Coordinate().subtract(tri.getC(), tri.getA());
		Coordinate v1 = new Coordinate().subtract(tri.getB(), tri.getA());
		Coordinate v2 = new Coordinate().subtract(origin, tri.getA());
		dot00 = dotProd(v0, v0);
		dot01 = dotProd(v0, v1);
		dot02 = dotProd(v0, v2);
		dot11 = dotProd(v1, v1);
		dot12 = dotProd(v1, v2);
		
		//Compute barycentric coordinates
		double invDenom = 1 / (double)((dot00 * dot11) - (dot01 * dot01));
		double u = ((dot11 * dot02) - (dot01 * dot12)) * invDenom;
		double v = ((dot00 * dot12) - (dot01 * dot02)) * invDenom;

		// Check if point is in triangle
		return (u > 0) && (v > 0) && (u + v < 1);

	}
	
	/**
	 * Generates the dot product of two 2-D Coodinates
	 * @param A
	 * @param B
	 * @return
	 */
	private Long dotProd(Coordinate A, Coordinate B)
	{
		Long result = (long)(A.getX() * B.getX()) + (long)(A.getY() * B.getY());
		return result;
	}
}
