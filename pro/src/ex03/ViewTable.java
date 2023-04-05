package ex03;

import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;

/** ConcreteProduct
 * (������ ������������
 * Factory Method)<br>
 * ���� � ������ �������
 * @author 34
 * @version 1.0
 * @see ViewResult
 */

public class ViewTable extends ViewResult 
{
	/** ���������� ������ ������� �� ������������*/
	private static final int DEFAULT_WIDTH = 88;
	
	/** ������� ������ ������� */
	private int width;
	
	/** ���������� {@linkplain ViewTable#width width}
	 * ��������� {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
	 * ����������� ����������� ���������� {@linkplain ViewResult#ViewResult() ViewResult()}
	 */
	public ViewTable() 
	{
		width = DEFAULT_WIDTH;
	}
	
	/** �������������� {@linkplain ViewTable#width} ��������� <b>width</b><br>
	 * ����������� ����������� ���������� {@linkplain ViewResult#ViewResult() ViewResult()}
	 * @param width ������� ������ �������
	 */
	public ViewTable(int width) 
	{
		this.width = width;
	}
	
	/** ���������� {@linkplain ViewTable#width} ��������� <b>width</b><br>
	 * ����������� ����������� ���������� {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * @param width ������� ������ �������
	 * @param n ������� �������� ��������; ���������� �����������������
	 */
	public ViewTable(int width, int n) 
	{
		super(n);
		this.width = width;
	}
	
	/** ���������� ���� {@linkplain ViewTable#width} ��������� <b>width</b>
	 * @param width ���� ������ �������
	 * @return ������ ���������� <b>width</b> ������ �������
	 */
	public int setWidth(int width) 
	{
		return this.width = width;
	}
	
	/** ������� �������� ���� {@linkplain ViewTable#width}
	 * @return ������� ������ �������
	 */
	public int getWidth() 
	{
		return width;
	}
	
	/** �������� ����������� ���� �������� ������� {@linkplain ViewTable#width} ������� */
	private void outLine() 
	{
		for(int i = width; i > 0; i--) 
		{
			System.out.print('-');
		}
	}
	
	/** ������� {@linkplain ViewTable#outLine()}; ������� ���� ���� �������� */
	private void outLineLn() 
	{
		outLine();
		System.out.println();
	}
	
	/** �������� ��������� ������� ������� {@linkplain ViewTable#width} ������� */
	private void outHeader() 
	{
		
		Formatter fmt = new Formatter();
		fmt.format("%s%d%s%2$d%s", "%", 5, "s | %", "s\n");
		System.out.printf(fmt.toString(), "x ", "y ");
	}
	
	/** �������� ��� ������� ������� {@linkplain ViewTable#width} ������� */
	private void outBody() 
	{
		
	 Formatter fmt = new Formatter();
	 fmt.format("%s%d%s%2$d%s", "%", 5, "s | %", "s\n");
	 for(Item2d item : getItems())
		{
		 String text = "";
			int y[] = new int [10];
			y = item.getY();
			for(int i=0;i<10;i++) 
			{
				text = text+i+" -> "+y[i]+"; ";
			}
			System.out.printf(fmt.toString(), item.getX(),text);
			
			
		}
	}
	
	/** ���������������� (��������, overloading) ������ ����������;
	 * ���������� ���� {@linkplain ViewTable#width} ��������� <b>width</b><br>
	 * ������� ����� {@linkplain ViewResult#viewInit() viewInit()}
	 * @param width ���� ������ �������
	*/
	public final void init(int width) 
	{ // method overloading
		this.width = width;
		viewInit();
	}
	
	/** ���������������� ������ ����������;
	 * ���������� ���� {@linkplain ViewTable#width} ��������� <b>width</b><br>
	 * ��� ��'���� {@linkplain ViewTable} ������� �����  {@linkplain ViewTable#init(int
	 stepX)}
	 * @param width ���� ������ �������.
	 * @param stepX ��������� ������ <b>init(int)</b>
	 */
	public final void init(int width, double stepX) 
	{ // method overloading
		this.width = width;
		init(stepX);
	}
	
	/** ����������� (��������, overriding) ������ ����������;
	 * �������� ������������ ����������� � ������� ����� ����������
	 * {@linkplain ViewResult#init(int stepX) init(int stepX)}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void init(double stepX) 
	{ // method overriding
		System.out.print("Initialization... ");
		super.init(stepX);
		System.out.println("done. ");
	}
	
	/** ���� �������� �������<br>{@inheritDoc} */
	@Override
	public void viewHeader() 
	{
		outHeader();
		outLineLn();
	}
	
	/** ���� �������� �������<br>{@inheritDoc} */
	@Override
	public void viewBody() 
	{
		outBody();
	}
	
	/** ���� �������� �������<br>{@inheritDoc} */
	@Override
	public void viewFooter() {
		outLineLn();
	}
}