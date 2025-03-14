package inheritance;

public class Cpu {
	private String manufactor;
	private String seriesNum;
	
	public Cpu(String manufactor, String seriesNum) {
		this.manufactor = manufactor;
		this.seriesNum = seriesNum;
	}
	
	
	
	public Cpu() {
	
	}



	public void calculate() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("제조사: " + this.manufactor + "\n");
		sBuffer.append("시리즈번호: " + this.seriesNum + "\n");
		sBuffer.append("2진수 연산 중 ... !");
		System.out.println(sBuffer);
	}
	
	
	
}
