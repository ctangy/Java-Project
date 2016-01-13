//package Objects;
//
//public class Balance {
//	private double amount;
//	private long lastWorked;
//	
//	public Balance(){
//		amount = 0;
//		lastWorked = 0;
//	}
//	
//	
//	public void subtractLateFees(long timeOverdue){// each second that goes by fee +2
//		if(timeOverdue > 1){
//			amount -= timeOverdue * 2.0;
//		}
//	}
//	
//	public boolean canWork(long time){
//		if ((time-lastWorked)/1000>10){
//			return true;
//		}
//		return false;
//	}
//	
//	public String earnMoney(long time){
//		if(canWork(time)){
//			amount += 5;
//			lastWorked = time;
//			return "AYYYY, You worked and got $5" ;
//		}
//		return "Lmao, you can't do a double shift. Finish the first job first!";
//	}
//	
//	public double getAmount() {
//		amount = Math.round(amount * 100) / 100;
//		return amount;
//	}
//	
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//	
//	public long getLastWorked() {
//		return lastWorked;
//	}
//	
//	public void setLastWorked(long lastWorked) {
//		this.lastWorked = lastWorked;
//	}
//	
//}
//
