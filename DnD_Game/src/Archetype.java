
public enum Archetype {
	FIGHTER(10, 0),
	ROGUE(8,1),
	WIZARD(6,3),
	CLERIC(8,4),
	PALADIN(10,0),
	BARD(8,5),
	SORCEROR(6,5),
	WARLOCK(8,5),
	RANGER(10,1),
	BARBARIAN(12, 2),
	ARTIFICER(8, 5),
	MONK(8, 1);
	
	private final int hitDie;
	private final int primaryStatIndex;
	
	private Archetype(int hitDie, int primaryStatIndex) {
		this.hitDie = hitDie;
		this.primaryStatIndex = primaryStatIndex;
	}

	public int getHitDie() {
		return hitDie;
	}

	public int getPrimaryStatIndex() {
		return primaryStatIndex;
	}
	
	
}
