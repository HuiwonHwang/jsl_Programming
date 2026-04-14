package k_interface;

public class Tiger extends Common implements inter_A,inter_B{
	@Override
	int getWeight() {
		return 125;
	}
	
	@Override
	public String getVoice() {
		return "크릉";
	}
	
	@Override
	public String getSkinColor() {
		return "yellow";
	}
	
	@Override
	public int teethCount() {
		return 36;
	}
	
	
	
}
