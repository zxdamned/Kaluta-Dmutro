package ex02;

/** Creator
 * (������ ������������
 * Factory Method)<br>
 * ��'����� �����,
 * "����������" ��'����
 * @author 34
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable 
{
	/** ������� ��'���, ���������� {@linkplain View} 
	 *@return - ��������� ����
	 */
	public View getView();
}