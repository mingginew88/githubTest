package basic;
/*
	데이터를 공급하는 쓰레드와 데이터를 소비하는 쓰레드 처리 예제
	(wait(), notify()메서드 이용)
 */
public class ThreadTest20 {
	public static void main(String[] args) {
		
		DataBox databox = new DataBox();
		ProducerThread pth = new ProducerThread(databox);
		ConsumerThread cth = new ConsumerThread(databox);
		
		pth.start();
		cth.start();
		
	}
}


//데이터를 공급하는 쓰레드
class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		this.databox = databox;
	}	
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String data = "data-" + i;
			databox.setData(data);
		}
	}
}


//데이터를 소비하는 쓰레드
class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox){
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5 ; i++) {
			String data = databox.getData();
			System.out.println("가져온 데이터 : " + data);
		}
	}
}


//데이터를 공통으로 사용하는 클래스
class DataBox{
	private String data;
	
	public synchronized void setData(String data){
		if(this.data!=null){		//데이터가 있으면
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data = data;
		System.out.println("공급용 쓰레드가 생성한 데이터 : " + data);
		notify();
	}
	
	//데이터를 소비하는 메서드
	public synchronized String getData(){
		if(data==null){		//데이터가 없으면
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String returnData = data;
		System.out.println("소비용 쓰레드가 사용한 데이터 : " + data);
		data = null;
		notify();
		return returnData;
	}
}