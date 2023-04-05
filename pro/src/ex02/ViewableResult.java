package ex02;

/** ConcreteCreator
 * (������ ������������
 * Factory Method)<br>
 * ��'����� �����,
 * "�����������" ��'����
 * @author 34
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