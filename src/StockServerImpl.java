import StockMarket.*;
import java.util.Vector;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class StockServerImpl extends StockServerPOA {
	private ORB orb;
	
	//stock symbols and their respective values
	private Vector myStockSymbols;
	private Vector myStockValues;
	
	//characters from which stock symbol names are built
	private static char ourCharacters[]={ 'A','B','C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	//path name for stock server objects
	private static String ourPathName="StockServer";
	
	//create a new stockserverimpl
	public StockServerImpl(){
		myStockSymbols=new Vector();
		myStockValues=new Vector();
		
		//initialize symbols and values with some random values
		for(int i=0;i<10;i++){
			//generate a string of four random characetrs
			StringBuffer stockSymbol=new StringBuffer("    ");
			for(int j=0;j<4;j++){
				stockSymbol.setCharAt(j, ourCharacters[(int)(Math.random()* 26f)]);
			}
			
			myStockSymbols.addElement(stockSymbol.toString());
			//give the stock a value between 0 and 100
			myStockValues.addElement(new Float(Math.random()*100f));
		}
		
		//print out the stock sysmbols generated above
		
		System.out.println("Generated stock sysmbols:");
		for(int i=0;i<10;i++){
			System.out.println(" "+myStockSymbols.elementAt(i)+" "+myStockValues.elementAt(i));	
		}
		System.out.println();	
	}
	
	
	public float getStockValue(String symbol){
		//try to find given sysmbol
		int stockIndex=myStockSymbols.indexOf(symbol);
		if(stockIndex!= -1){
			//symbol found.return its value
			return ((Float)myStockValues.elementAt(stockIndex)).floatValue();
		}
		else{
			//symbol was not found
			return 0f;
		}
	}
	
	//return sequence of all elements 
	public String[] getStockSymbols(){
		String[] symbols=new String[myStockSymbols.size()];
		myStockSymbols.copyInto(symbols);
		return symbols;
	}
	
	
	public void setORB(ORB orb_val){
		orb=orb_val;
		
	}
	
	

}
