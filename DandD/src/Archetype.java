
public enum Archetype {
	FIGHTER(10, 0),
	ROGUE(8, 1),
	WIZARD(6, 3),
	CLERIC(8, 4),
	PALADIN(10, 0),
	BARD(8, 5);
	
	private final int hitDie;
	private final int primaryStatIndex;
	
	private Archetype(int hitDie, int primaryStatIndex) {
		this.hitDie = hitDie;
		this.primaryStatIndex = primaryStatIndex;
	}

	public int getHitDie() {return hitDie;}
	public int getPrimaryStatIndex() {return primaryStatIndex;}
	
}
