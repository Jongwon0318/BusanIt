package chap05;

public class Km2Mile extends Converter{
	
	public Km2Mile(double km) {
		super.ratio=km;
	}
	
	@Override
	protected double convert(double src) {
		return src/ratio;
	}
	
	@Override
	protected String getDestString() {
		return "mile";
	}
	
	@Override
	protected String getSrcString() {
		return "Km";
	}
	
	public static void main(String[] args) {
		Km2Mile toMile=new Km2Mile(1.6);
		toMile.run();
	}

}
