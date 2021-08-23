package revive.wrapper.objects;

import java.util.UUID;

public class GeneralPlayerData {
	private int level;
	private long firstlogin;
	private long lastlogin;
	private int xp;
	private int tokens;
	private long lastlogout;
	private long playtime;
	private int loginstreak;

	private UUID[] liked;
	private UUID[] likes;
	private UUID player;

	/**
	 * Returns the level of the player
	 * 
	 * @return - The level of the player
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets a UNIX timestamp for the first time the player has logged in.
	 * 
	 * @return - The timestamp when the player has logged in
	 */
	public long getFirstLogin() {
		return firstlogin;
	}

	/**
	 * Gets a UNIX timestamp for the last time the player has logged in.
	 * 
	 * @return - The timestamp when the player has logged in
	 */
	public long getLastLogin() {
		return lastlogin;
	}

	/**
	 * Gets the current player XP (this goes to 0 every level!)
	 * 
	 * @return - The xp of the player
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * Gets the tokens of the player
	 * 
	 * @return - The tokens of the player
	 */
	public int getTokens() {
		return tokens;
	}

	/**
	 * Gets a UNIX timestamp for the last time the player has logged out.
	 * 
	 * @return - The timestamp when the player has logged out
	 */
	public long getLastLogout() {
		return lastlogout;
	}

	/**
	 * Gets the playtime of the player in seconds
	 * 
	 * @return - The playtime of the player
	 */
	public long getPlayTime() {
		return playtime;
	}

	/**
	 * Gets the login streak of the player, in days
	 * 
	 * @return
	 */
	public int getLoginStreak() {
		return loginstreak;
	}

	/**
	 * Returns an array of people this person has liked
	 * 
	 * @return - An array of people this person has liked
	 */
	public UUID[] getLiked() {
		return liked;
	}

	/**
	 * Returns an array of people that have liked this person
	 * 
	 * @return - An array of people that have liked this person
	 */
	public UUID[] getLikes() {
		return likes;
	}

	/**
	 * Returns the player
	 * 
	 * @return - the player
	 */
	public UUID getPlayer() {
		return player;
	}

}
