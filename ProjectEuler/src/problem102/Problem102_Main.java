package problem102;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem102_Main {

	private static Set<Triangle> triangleSet;
	public static void main(String args[])
	{
		InputStream is = null;
		try
		{
			is = new FileInputStream("src/problem102/triangles.txt");
			//FileInputStream fis = new FileInputStream("triangles.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(is)));
			
			String line = "";
			triangleSet = new HashSet<Triangle>();
			int countCorrect = 0;
			
			
			while((line = br.readLine()) != null)
			{
				String[] split = line.split(",");
				Coordinate A = new Coordinate(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
				Coordinate B = new Coordinate(Integer.parseInt(split[2]),Integer.parseInt(split[3]));
				Coordinate C = new Coordinate(Integer.parseInt(split[4]),Integer.parseInt(split[5]));
				//triangleSet.add(new Triangle(A,B,C));
//				if(new Triangle(A,B,C).checkIfOriginInside())
//					countCorrect++;
				if(new SameSide().testOrigin(new Triangle(A,B,C)))
					countCorrect++;
				//System.out.println(line);
			}
			
			/*
			for(int count = 0; count < 2; count++)
			{
				line = br.readLine();
				System.out.println(line);
				String[] split = line.split(",");
				Coordinate A = new Coordinate(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
				Coordinate B = new Coordinate(Integer.parseInt(split[2]),Integer.parseInt(split[3]));
				Coordinate C = new Coordinate(Integer.parseInt(split[4]),Integer.parseInt(split[5]));
				//triangleSet.add(new Triangle(A,B,C));
//				if(new Triangle(A,B,C).checkIfOriginInside())
//				countCorrect++;
			if(new SameSide().testOrigin(new Triangle(A,B,C)))
				countCorrect++;
			}
			*/
			System.out.println("Total Number correct: " + countCorrect);
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
		finally
		{
			try
			{
			if(is != null)
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


}

