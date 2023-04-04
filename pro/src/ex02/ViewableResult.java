package ex02;

/** ConcreteCreator
 * (������ ������������
 * Factory Method)<br>
 * ��'����� �����,
 * "�����������" ��'����
 * @author Danylo_Donets
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */

public class ViewableResult implements Viewable 
{
	/** ������� ����������� ��'��� {@linkplain ViewResult} */
	@Override
	public View getView() 
	{
		return new ViewResult();
	}
}