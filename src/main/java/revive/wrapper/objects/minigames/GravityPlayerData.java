package revive.wrapper.objects.minigames;

import java.util.UUID;

import revive.wrapper.objects.MapTimes;

public class GravityPlayerData {
	private int checkpoints;
	private String streak;
	private long updated;
	private int deaths;
	private int points;
	private UUID player;

	private MapTimes besttimes;

	public MapTimes getBestTimes() {
		return besttimes;
	}

	public int getCheckpoints() {
		return checkpoints;
	}

	public int getDeaths() {
		return deaths;
	}

	public UUID getPlayer() {
		return player;
	}

	public int getPoints() {
		return points;
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
}
