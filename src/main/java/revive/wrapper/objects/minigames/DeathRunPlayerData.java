package revive.wrapper.objects.minigames;

import java.util.UUID;

import revive.wrapper.objects.MapTimes;

public class DeathRunPlayerData {
	private int wins;
	private int kills;
	private int traps;
	private int games;
	private MapTimes besttimes;
	private int checkpoints;
	private String streak;
	private long updated;
	private int deaths;
	private int points;
	private UUID player;

	public int getWins() {
		return wins;
	}

	public int getKills() {
		return kills;
	}

	public int getTraps() {
		return traps;
	}

	public int getGames() {
		return games;
	}

	public MapTimes getBestTimes() {
		return besttimes;
	}

	public int getCheckpoints() {
		return checkpoints;
	}

	public int getStreak() {
		try {
			return Integer.parseInt(streak);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public long getUpdated() {
		return updated;
	}

	public int getDeaths() {
		return deaths;
	}

	public int getPoints() {
		return points;
	}

	public UUID getPlayer() {
		return player;
	}
}
