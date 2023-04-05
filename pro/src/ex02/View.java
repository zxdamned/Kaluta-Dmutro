package ex02;

import java.io.IOException;

/** Product
 * (������ ������������
 * Factory Method)<br>
 * ��������� "����������"
 * ��'����<br>
 * ��'����� ������
 * ����������� ��'����
 * @author 34
 * @version 1.0
 */
public interface View 
{
	/** ³������� ��������� */
	public void viewHeader();
	
	/** ³������� ������� ������� */
	public void viewBody();
	
	/** ³������� ��������� */
	public void viewFooter();
	
	/** ³������� ��'��� �������� */
	public void viewShow();
	
	/** ������ ������������ */
	public void viewInit();
	
	/** ������ ���� ��� ���������� ���������� 
	 *@throws IOException -��������� ���� 
	 */
	public void viewSave() throws IOException;
	
	/** ³������� ������ ��������� ���� 
	 *@throws Exception -��������� ���������� ����  
	 */
	public void viewRestore() throws Exception;
}