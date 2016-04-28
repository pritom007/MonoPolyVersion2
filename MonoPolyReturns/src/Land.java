
public abstract class Land extends GameMapping{
	
	String name;
	
	public Land(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void doAction(Player player, GameMapping gameMapping);

	public void doAction(Player[] player, GameMapping gameMapping) {
		
		
	}

	


}
