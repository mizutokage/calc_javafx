package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

class Item {
	final static int ADD = 1;//+
	final static int SUB = 2;//-
	final static int MUL = 3;//×
	final static int DIV = 4;//÷

	int sign;//+-*/を判別
	int num;
}

public class CalculatorController {
	@FXML Button button1;
	@FXML Button button2;
	@FXML Button button3;
	@FXML Button button4;
	@FXML Button button5;
	@FXML Button button6;
	@FXML Button button7;
	@FXML Button button8;
	@FXML Button button9;
	@FXML Button button0;
	@FXML Button buttonAdd;//足し算
	@FXML Button buttonSub;//引き算
	@FXML Button buttonMul;//掛け算
	@FXML Button buttonDiv;//割り算
	@FXML Button buttonEql;//「＝」
	@FXML Button buttonC;//クリアボタン
	@FXML Button buttonDot;//小数点
	@FXML TextField text;
	@FXML Label label;
	String str = "";
	Item[] items =  new Item[2];
	int now = 1;
	boolean next = false;
	public CalculatorController() {
		items[0] = new Item();
		items[1] = new Item();
	}

	//ボタン数字部分
	@FXML public void onClick(ActionEvent e) {
    	if(e.getSource().equals(button1)) {	//button1が押されたらテキストに1を表示
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "1";
    	} else if(e.getSource().equals(button2)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "2";
    	} else if(e.getSource().equals(button3)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "3";
    	} else if(e.getSource().equals(button4)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "4";
    	} else if(e.getSource().equals(button5)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "5";
    	} else if(e.getSource().equals(button6)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "6";
    	} else if(e.getSource().equals(button7)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "7";
    	} else if(e.getSource().equals(button8)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "8";
    	} else if(e.getSource().equals(button9)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "9";
    	} else if(e.getSource().equals(button0)) {
    		if(next) {
    			str = "";
    			text.setText(str);
    			now = 2;
    			next = false;
    		}
        	str += "0";
    	} else if(e.getSource().equals(buttonAdd)) { //＋ボタンが押されたら
    		if(now == 1) {	//第1項なら
    			items[0].num = Integer.valueOf(str);	//TextFieldの数字を変数numの第1項に代入
    			items[1].sign = Item.ADD;	//第2項の符号を「＋」にセット
    			next = true;	//次に第2項を入れるのでnextをオンにする
    			label.setText("");
    		} else if(now == 2) {
    			// SUB,MUL,DIVの部分の必要性がいまいちわからない．
    			items[1].num = Integer.valueOf(str);
    			str = String.valueOf(items[0].num + items[1].num);
    			items[0].num = Integer.valueOf(str);	//答えを第1項のnumに代入する
    			items[1].num = Item.ADD;	//第2項の符号を「＋」にセット
    			now = 1;	//第1項からの処理を繰り返すので，now変数を1に戻す
    			next = true;	//次，第2項から始めるのでnextをオンにする
    		}
    	} else if(e.getSource().equals(buttonSub)) {	//－ボタンが押されたら
    		if(now == 1) {
    		    try {  //  strに数字が入っていたら
    		        items[0].num = Integer.valueOf(str);
    		        items[1].sign = Item.SUB;
    		        next = true;
    		    }catch (NumberFormatException n) { //  strに数字が入っていなかったら
    		        if(items[0].sign != Item.SUB) { //  マイナス値でなかったら
    		            items[0].sign = Item.SUB;  //  マイナス値として扱う
    		            str = "-";  //  先頭にマイナス符号をつける
    		        }
    		        else if(items[0].sign == Item.SUB) { //  マイナス値だったら
    		            items[0].sign = Item.ADD;  //  プラス値として扱う
    		            str = "";  //  先頭のマイナス符号を削除する
    		        }
    		    }
    		} else if(now == 2) {
    			items[1].num = Integer.valueOf(str);
    			str = String.valueOf(items[0].num - items[1].num);
    			items[0].num = Integer.valueOf(str);
    			items[1].num = Item.SUB;
    			now = 1;
    			next = true;
    		}
    	} else if(e.getSource().equals(buttonMul)) {	//＊ボタンが押されたら
    		if(now == 1) {
    			items[0].num = Integer.valueOf(str);
    			items[1].sign = Item.MUL;
    			next = true;
    			label.setText("");
    		} else if(now == 2) {
    			items[1].num = Integer.valueOf(str);
    			str = String.valueOf(items[0].num * items[1].num);
    			items[0].num = Integer.valueOf(str);
    			items[1].num = Item.MUL;
    			now = 1;
    			next = true;
    		}
    	} else if(e.getSource().equals(buttonDiv)) { //÷ボタンが押されたら
    		if(now == 1) {
    			items[0].num = Integer.valueOf(str);
    			items[1].sign = Item.DIV;
    			next = true;
    			label.setText("");
    		} else if(now == 2) {
    			items[1].num = Integer.valueOf(str);
    			str = String.valueOf(items[0].num / items[1].num);
    			items[0].num = Integer.valueOf(str);
    			items[1].num = Item.DIV;
    			now = 1;
    			next = true;
    		}

    	} else if(e.getSource().equals(buttonEql)) {	//＝ボタンが押されたら
    		if(now == 2) {
    			items[1].num = Integer.valueOf(str);
    			switch(items[1].sign) {
    			case Item.ADD: str = String.valueOf(items[0].num + items[1].num); break;
    			case Item.SUB: str = String.valueOf(items[0].num - items[1].num); break;
    			case Item.MUL: str = String.valueOf(items[0].num * items[1].num); break;
    			case Item.DIV: str = String.valueOf(items[0].num / items[1].num); break;
    			}
    		}
    		items[0].num = Integer.valueOf(str);	//答えを第1項に代入する
    		now = 1;	//第1項からの処理を繰り返すので，now変数を1にする
    		next = true;	//次は第2項に入れるのでnext変数をオンにする

    	} else if(e.getSource().equals(buttonC)) {
    		str = "";
    		items[0].num = 0;
    		items[1].num = 0;
    		now = 1;
    		next = false;
    	} else if(e.getSource().equals(buttonDot)) {
    			
    	}
    	text.setText(str);
	}

}
