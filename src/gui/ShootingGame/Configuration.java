package gui.ShootingGame;

public class Configuration {

	private int enemyLevel;
	private int beamLevel;
	private int level;

	public int getEnemyLevel() {
		return enemyLevel;
	}

	public void setEnemyLevel(int enemyLevel) {
		this.enemyLevel = enemyLevel;
	}

	public int getBeamLevel() {
		return beamLevel;
	}

	public void setBeamLevel(int beamLevel) {
		this.beamLevel = beamLevel;
	}

	public Configuration(int level) {
		this.enemyLevel = level;
		this.beamLevel = level;
		this.level = level;

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
