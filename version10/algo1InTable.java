package version10;

import java.io.IOException;

/**
 * @author Paz Cheredman
 *
 */
public class algo1InTable {
	//private outputTable input= new outputTable();
	//private outputRow inRow1 =new outputRow();
	private table inTab;
	private rowMeasurement inRow =inTab.getRow(0);

	/**
	 * 
	 * @param input
	 * @throws IOException
	 * receive as input: combined csv (from ex0)
	 * fullData takes the data from the input table
	 * data wanted: lat lon alt mac signal 
	 */

	public algo1InTable() {
		outputTableAlgo1 input= new outputTableAlgo1() ;
		inTab=input;
	}
	public void fullData(outputTableAlgo1 input) throws IOException{
		for (int i = 0; i < input.size(); i++) {
			if(inRow.)
			
		}
	}

	public void reset(csv input) throws IOException{
		input.read();
		input.process();
		input.write();
		//this.input=input;
	}

	public static void main(String [] args) throws IOException{
		//algo1InTable input1=new algo1InTable();

		//System.out.println(input1);
		//input1.toString();
	}




}
