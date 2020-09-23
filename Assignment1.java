/**  *  * @author Biswajit Sarkar  
 *        
 * */ 

package Sem_2A;

import java.util.Scanner;

class Stock
{
	
	private String productID; 
	private String productName;
	private int qoh;
	private int rsp;
	private double sellPrice;
	private double buyPrice;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	public int getRsp() {
		return rsp;
	}
	public void setRsp(int rsp) {
		this.rsp = rsp;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	
	public Stock()  //Default Constructor
	{
		productID="111_AAA";
		productName="Unknown Product";
		qoh=0;
		rsp=25;
		sellPrice=0;
		buyPrice=0;
		
		
	}
	public Stock(String productID,String productName,double sellPrice ) //Parameterized Constructor
	{
		setProductID(productID);
		setProductName(productName);
		setSellPrice(sellPrice);
		
	}
	public Stock(String productID, String productName, int qoh,int rsp, double sellPrice, double buyPrice)
	{
	
		setProductID(productID);
		setProductName(productName);
		setQoh(qoh);
		setRsp(rsp);
		setSellPrice(sellPrice);
		setBuyPrice(buyPrice);
		
		
	}

	
	static double reStockFee(double bPrice, int  bQuantity)  // calculate restock
	{
		double totalPrice= bPrice * bQuantity;
		
		return totalPrice;
		
	}
	

	
	@Override
	public String toString() {
		return productID+" ("+productName+"), QOH: "+ qoh + "  Buying Price: $"+ buyPrice;
	}
	
	public static void validateProductId(String productId)   // validating the product code
	{
	
		if(productId.length()==7)
		{
			boolean isFirstThree=false;
			isFirstThree=Character.isDigit(productId.charAt(0)) && Character.isDigit(productId.charAt(1))  && Character.isDigit(productId.charAt(2));
			boolean isLastThree=false;
			isLastThree=Character.isLetter(productId.charAt(4)) && Character.isLetter(productId.charAt(5))  && Character.isLetter(productId.charAt(6));
			boolean isLastThreeUpper=false;
			isLastThreeUpper=Character.isUpperCase(productId.charAt(4)) && Character.isUpperCase(productId.charAt(5))  && Character.isUpperCase(productId.charAt(6));
			
			
			if(isFirstThree && (productId.charAt(3)=='_') && isLastThree && isLastThreeUpper )
			{
				new Stock().setProductID(productId);
			}
			else
			{

				throw new IllegalArgumentException("Please enter valid product id");
				
			}
			
		}else
		{
			
			throw new IllegalArgumentException("Please enter valid product id");
			
		}
		
		
	}
	
	
	public static  void validateQuantity(int qoh,int rsp)  // validate quantity in hand and rsp
	{
		
		if(qoh<rsp)
		{
			int diff=rsp-qoh;
			{
				System.out.println("You should order at least "+diff+" products.");
			}
			
			
		}
	}
	

}

public class Assignment1 {

	public static void main(String[] args)
	{
		Scanner sc=null;
	   try
	   {
		Stock stock=new Stock();
		System.out.println(stock);
	    sc=new Scanner(System.in);
		System.out.println("Enter Product ID:");
		String productID=sc.nextLine();
		Stock.validateProductId(productID);
		System.out.println("Enter Product Name:");
		String productName=sc.nextLine();
		System.out.println("Qty On Hand:");
		int qoh=Integer.parseInt(sc.nextLine());
		if(qoh<0)
		{
			throw new IllegalArgumentException("Please enter positive number");
		}
		System.out.println("Re-Stock Point:");
		int rsp=Integer.parseInt(sc.nextLine());
		
		System.out.println("Selling Price:");
		double sellPrice=Double.parseDouble(sc.nextLine());
		if(sellPrice<0)
		{
			throw new IllegalArgumentException("Please enter positive number");
			
		}
		System.out.println("Buying Price:");
		double buyPrice=Double.parseDouble(sc.nextLine());
		if(buyPrice<0)
		{
			throw new IllegalArgumentException("Please enter positive number");
		}
		Stock stock1=new Stock(productID,productName,qoh,rsp,sellPrice,buyPrice);
		System.out.println(stock1);
		Stock.validateQuantity(qoh,rsp);
		System.out.println("Enter # of units to buy:");
		int unit=Integer.parseInt(sc.nextLine());
        System.out.println("Total Re-Stock Cost : $"+String.format("%.2f",Stock.reStockFee(buyPrice, unit)));
        
	   }catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   
	   }
	   finally
	   {
		   sc.close();
	   }
			
	}

}
