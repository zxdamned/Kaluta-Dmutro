package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import ex01.Item2d;

/** ConcreteProduct
 * ( 
 * Factory Method)<br>
 *  ,
 *   
 * 
 * @author Danylo_Donets
 * @version 1.0
 * @see View
 */
public class ViewResult implements View 
{
	
	/** ' ,    */
	private static final String FNAME = "items.bin";
	
	/**        */
	private static final int DEFAULT_NUM = 10;
	
	/**      */
	private ArrayList<Item2d> items = new ArrayList<Item2d>();
	
	/**  {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 *   {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() 
	{
		this(DEFAULT_NUM);
		}
	
	/**   {@linkplain ViewResult#items}
	 * @param n   
	 */
	public ViewResult(int n) 
	{
		for(int ctr = 0; ctr < n; ctr++) 
		{
			items.add(new Item2d());
		}
	}
	
	/**   {@linkplain ViewResult#items}
	 * @return     ' {@linkplain ArrayList}
	 */
	public ArrayList<Item2d> getItems() 
	{
		return items;
	}
	
	/**   
	* @param x   
	* @return   
	*/
	private int[] calc(int x) 
	{
		int [] numbers = new int[10];
        while (x > 0) {
            numbers[x%10]++;
            x /= 10;
        }
        
		return numbers;
	}
	
	/**     
	 *    {@linkplain ViewResult#items}
	 * @param stepX   
	 */
	public void init(double stepX) 
	{
		int x = 0;
		for(Item2d item : items) 
		{
			item.setXY(x, calc(x));
			x += stepX;
		}
	}
	
	/**  <b>init(double stepX)</b>    <br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() 
	{
		Random random = new Random();
		init(random.ints(0, 360).findFirst().getAsInt());
	}
	
	/**   {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException 
	{
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}
	
	/**   {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception 
	{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item2d>) is.readObject();
		is.close();
	}
	
	/**   {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() 
	{
		System.out.println("Results:");
	}
	
	/**   {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() 
	{
		for(Item2d item : items)
		{
			System.out.print("[ "+item.getX()+"; ");
			int y[] = new int [10];
			y = item.getY();
			for(int i=0;i<10;i++) 
			{
				System.out.print(i+" -> "+y[i]+"; ");
			}
			System.out.print("]\n");
			
			
		}
		System.out.println();
	}
	
	/**   {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() 
	{
		System.out.println("End.");
	}
	
	/**   {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() 
	{
		viewHeader();
		viewBody();
		viewFooter();
	}
}
