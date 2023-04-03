package ex01;

import java.io.Serializable;

/**
 * ������ ������ ���� �� ��������� ��������� ������.
 * 
 * @author 34
 * @version 1.0
 */

public class Item2d implements Serializable 
{

	/** �������� ������������� �������. */
	// transient
	private int x;

	/** ��������� ���������� �������. */
	private int []y = new int [10];

	/** ����������� ����������� ��������� */
	private static final long serialVersionUID = 1L;

	/** �������� ���� {@linkplain Item2d#x}, {@linkplain Item2d#y} */
	public Item2d()
	{
		x = 0;
		for(int i=0; i<10;i++) 
		{
			y[i]=0;
		}
	}

	/**
	 * ���������� �������� �����: ��������� � ���������� ���������� �������.
	 * 
	 * @param x - �������� ��� ����������� ���� {@linkplain Item2d#x}
	 * @param y - �������� ��� ����������� ���� {@linkplain Item2d#y}
	 */
	public Item2d(int x, int []y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * ������������ �������� ���� {@linkplain Item2d#x}
	 * 
	 * @param x - �������� ��� {@linkplain Item2d#x}
	 * @return �������� {@linkplain Item2d#x}
	 */
	public int setX(int x)
	{
		return this.x = x;
	}

	/**
	 * ��������� �������� ���� {@linkplain Item2d#x}
	 * 
	 * @return �������� {@linkplain Item2d#x}
	 */
	public int getX() 
	{
		return x;
	}

	/**
	 * ������������ �������� ���� {@linkplain Item2d#y}
	 * 
	 * @param y - �������� ��� {@linkplain Item2d#y}
	 * @return �������� {@linkplain Item2d#y}
	 */
	public int[] setY(int []y)
	{
		return this.y = y;
	}

	/**
	 * ��������� �������� ���� {@linkplain Item2d#y}
	 * 
	 * @return �������� {@linkplain Item2d#y}
	 */
	public int[] getY()
	{
		return y;
	}

	/**
	 * ������������ �������� {@linkplain Item2d#x} � {@linkplain Item2d#y}
	 * 
	 * @param x - �������� ��� {@linkplain Item2d#x}
	 * @param y - �������� ��� {@linkplain Item2d#y}
	 * @return this
	 */
	public Item2d setXY(int x, int []y) 
	{
		this.x = x;
		this.y = y;
		return this;
	}

	/**
	 * ����������� ��������� ���������� � ������ �����.<br>
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		String text = "x= "+x+"\ny:\n";
		for(int i=0;i<10;i++) 
		{
			text = text+i+" -> "+y[i]+"\n";
		}
		
		return text;
	}

	/**
	 * ����������� ������������ �����.<br>
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item2d other = (Item2d) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		
		return true;
	}
}