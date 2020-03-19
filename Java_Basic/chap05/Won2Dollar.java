package chap05;

public class Won2Dollar extends Converter {
	
	public Won2Dollar(int won) {
		super.ratio=won;
	}
	
	@Override
	protected String getDestString() {
		return "´Þ·¯";
	}
	
	@Override
	protected String getSrcString() {
		return "¿ø";
	}
	
	@Override
	protected double convert(double src) {
		return src/ratio;
	}
	
	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1200);
		toDollar.run();
	}

}
