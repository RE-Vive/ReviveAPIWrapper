package revive.wrapper.objects.minigames;

import java.util.UUID;

public class BlockPartyPlayerData {
	private int games;
	private String longest_streak;
	private UUID player;
	private int points;
	private int powerups_collected;
	private int powerups_used;
	private int rounds_played;
	private int rounds_survived;
	private String streak;
	private long updated;
	private int wins;

	public int getGames() {
		return games;
	}

	public int getLongestStreak() {
		try {
			return Integer.parseInt(longest_streak);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public UUID getPlayer() {
		return player;
	}

	public int getPoints() {
		return points;
	}

	public int getPowerupsCollected() {
		return powerups_collected;
	}

	public int getPowerupsUsed() {
		return powerups_used;
	}

	public int getRoundsPlayed() {
		return rounds_played;
	}

	public int getRoundsSurvived() {
		return rounds_survived;
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

	public int getWins() {
		return wins;
	}
}
