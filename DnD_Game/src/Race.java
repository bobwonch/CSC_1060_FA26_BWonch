
public enum Race {
	HUMAN(1,1,1,1,1,1),
	ELF(0,2,0,1,0,0),
	DWARF(0,0,2,0,0,0),
	HALFLING(0,2,0,0,0,0);
	
	private final int strBonus;
	private final int dexBonus;
	private final int conBonus;
	private final int intBonus;
	private final int wisBonus;
	private final int chaBonus;
	
	private Race(int strBonus, int dexBonus, int conBonus, int intBonus, int wisBonus, int chaBonus) {
		this.strBonus = strBonus;
		this.dexBonus = dexBonus;
		this.conBonus = conBonus;
		this.intBonus = intBonus;
		this.wisBonus = wisBonus;
		this.chaBonus = chaBonus;
	}
	public int getStrBonus() {
		return strBonus;
	}
	public int getDexBonus() {
		return dexBonus;
	}
	public int getConBonus() {
		return conBonus;
	}
	public int getIntBonus() {
		return intBonus;
	}
	public int getWisBonus() {
		return wisBonus;
	}
	public int getChaBonus() {
		return chaBonus;
	}
	
	
	
}
