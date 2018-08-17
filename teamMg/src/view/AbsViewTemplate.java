package view;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbsViewTemplate extends AbsView {

	@Override
	public void show() {
		showMenu();
		
		String input = getKeyInputString("번호: ");
		if(isValidNumber(input)) {
			execute(NumberUtils.toInt(input));
		}

	}
	
	protected boolean isValidNumber(String input) {
		if(StringUtils.isBlank(input)) { //공백입니까~~~~~~
			return false;
		}
		if(StringUtils.isNumeric(input)) { //누메릭이면 숫자인거야
			int number = NumberUtils.toInt(input);
			if(number >= getMinMenuNumber() && number <= getMaxMenuNumber()) {
				return true;
			}
		} //아니면 펄스
			return false;
	}
	abstract protected void showMenu();
	abstract protected int getMinMenuNumber();
	abstract protected int getMaxMenuNumber();
	abstract protected void execute(int number);

}
