
public class Character {
	private String name;
	private int level;
	private Archetype archetype;
	private int ac;
	private int hp;
	private Race race;
	private String note;
	private Attributes stats;
	

	public Character(String name, Archetype archetype, Race race, String note) {
		this.name = name;
		this.level = 1;
		this.archetype = archetype;
		this.race = race;
		this.note = note;
		this.stats = StatRoller.rollStats(race);
		
		this.ac = 10 + this.stats.getBonus(1);
		this.hp = archetype.getHitDie() + this.stats.getBonus(2);
	}
	
	public Character(String name, int level, Archetype archetype, int ac, int hp, Race race, String note,
			Attributes stats) {
		this.name = name;
		this.level = level;
		this.archetype = archetype;
		this.ac = ac;
		this.hp = hp;
		this.race = race;
		this.note = note;
		this.stats = stats;
	}

	
	
	public Attributes getStats(){return stats;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getLevel() {	return level;}
	public void setLevel(int level) {this.level = level;}
	public Archetype getArchetype() {return archetype;}
	public void setArchetype(Archetype archetype) {this.archetype = archetype;}
	public int getAc() {return ac;}
	public void setAc(int ac) {this.ac = ac;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public Race getRace() {return race;}
	public void setRace(Race race) {this.race = race;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}

	@Override
	public String toString() {
		return "~Character~\nName: " + name + "\nLevel: " + level + "\nArchetype: " + archetype + "\nAC: " + ac + "\nHP: " + hp
				+ "\nRace: " + race + "\nNote:" + note + "\nStats:\n" + stats;
	}
	
}
