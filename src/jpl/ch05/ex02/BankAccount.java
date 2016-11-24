package jpl.ch05.ex02;

import java.util.ArrayList;

public class BankAccount {

	private long number;
	private long balance;
	private Action lastAct;
	ArrayList<Action> list = new ArrayList<Action>(10);

	public class Action {
		private String act;
		private long amount;

		public String getAct() {
			return act;
		}

		public void setAct(String act) {
			this.act = act;
		}

		public long getAmount() {
			return amount;
		}

		public void setAmount(long amount) {
			this.amount = amount;
		}

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;

		}
		
	}

	public class History {
		History(Action act) {
			list.add(0, act);
		}
		
		//問題文の意味がよく分からないため
		//とりあえずリストの最初の要素を取得して
		//リストの要素を左にずらします
		//そして取得した要素を戻します
		public Action next(){
			
			Action Ans = list.get(0);
			list.remove(0);
			return Ans;
		}
		

	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		new History(lastAct);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		new History(lastAct);
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Action getLastAct() {
		return lastAct;
	}

	public void setLastAct(Action lastAct) {
		this.lastAct = lastAct;
	}

}
//Historyはネストしたクラスにすべきで、staticにすべきではない
