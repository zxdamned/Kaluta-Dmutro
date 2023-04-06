package ex04;

import ex01.Item2d;

/** �������
 * Change item;
 * ������ Command
 * @author 34
 * @version 1.0
 */

public class ChangeItemCommand implements Command {
	/** ���������� ��'���; ������ Command */
	private Item2d item;
	
	/** �������� �������; ������ Command */
	private int offset;
	
	/** ���������� ���� {@linkplain ChangeItemCommand#item}
	 * @param item �������� ��� {@linkplain ChangeItemCommand#item}
	 * @return ���� �������� {@linkplain ChangeItemCommand#item}
	 */
	public Item2d setItem(Item2d item) {
		return this.item = item;
	}
	
	/** ������� ���� {@linkplain ChangeItemCommand#item}
	 * @return �������� {@linkplain ChangeItemCommand#item}
	 */
	public Item2d getItem() {
		return item;
	}
	
	/** ���������� ���� ���� {@linkplain ChangeItemCommand#offset}
	 * @param offset �������� ��� {@linkplain ChangeItemCommand#offset}
	 * @return ���� �������� {@linkplain ChangeItemCommand#offset}
	 */
	public int setOffset(int offset) {
		return this.offset = offset;
	}
	
	/** ������� ���� {@linkplain ChangeItemCommand#offset}
	 * @return �������� {@linkplain ChangeItemCommand#offset}
	 */
	public int getOffset() {
		return offset;
	}
	
	@Override
	public void execute() {
		int []y = item.getY();
		for(int i=0;i<10;i++) {
			y[i]*=offset;
		}
		item.setY(y);
	}
}