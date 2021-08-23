package revive.wrapper.objects.minigames;

import java.util.UUID;

public class BedwarsPlayerData {
	private int kills;
	private int victories;
	private int final_kills;
	private String fav1, fav2, fav3;
	private int games;
	private int beds;
	private long updated;
	private int deaths;
	private int points;
	private UUID player;

	/**
	 * @return - How many beds the player has broken
	 */
	public int getBeds() {
		return beds;
	}

	/**
	 * @return - How many times the player died
	 */
	public int getDeaths() {
		return deaths;
	}

	/**
	 * @return - Get the first favourite item of the player
	 */
	public String getFavouriteOne() {
		return fav1;
	}

	/**
	 * @return - Get the second favourite item of the player
	 */
	public String getFavouriteTwo() {
		return fav2;
	}

	/**
	 * @return - Get the third favourite item of the player
	 */
	public String getFavouriteThree() {
		return fav3;
	}

	/**
	 * @return - Get the amount of final kills
	 */
	public int getFinalKills() {
		return final_kills;
	}

	/**
	 * @return - Get the amount of games the player played
	 */
	public int getGames() {
		return games;
	}

	/**
	 * @return - Get the amount of kills
	 */
	public int getKills() {
		return kills;
	}

	/**
	 * @return - Get the player
	 */
	public UUID getPlayer() {
		return player;
	}

	/**
	 * @return - Get the amount of points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return - Get how recent this data is
	 */
	public long getUpdated() {
		return updated;
	}

	/**
	 * @return - Get the amount of victories
	 */
	public int getVictories() {
		return victories;
	}
}
