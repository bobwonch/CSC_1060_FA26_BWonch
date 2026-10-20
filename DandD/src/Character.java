
public class Character {
	private String name;
	private int level;
	private String archetype;
	private int ac;
	private int hp;
	private String race;
	private String note;
	private Attributes stats;
	
	public Character() {
		this.name = "";
		this.level = 1;
		this.archetype = "";
		this.ac = 0;
		this.hp = 0;
		this.race = "";
		this.note = "";
		this.stats = StatRoller.rollStats();
	}

	public Character(String name, int level, String archetype, int ac, int hp, String race, String note, Attributes stats) {
		this.name = name;
		this.level = level;
		this.archetype = archetype;
		this.ac = ac;
		this.hp = hp;
		this.race = race;
		this.note = note;
		this.stats = stats;
	}

	public Attributes getStats()
	{
		return stats;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getArchetype() {
		return archetype;
	}
	public void setArchetype(String archetype) {
		this.archetype = archetype;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "~Character~\nName: " + name + "\nLevel: " + level + "\nArchetype: " + archetype + "\nAC: " + ac + "\nHP: " + hp
				+ "\nRace: " + race + "\nNote:" + note + "\nStats:\n" + stats;
	}
	
}
