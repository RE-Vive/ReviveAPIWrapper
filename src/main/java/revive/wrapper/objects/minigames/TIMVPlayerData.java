package revive.wrapper.objects.minigames;

import java.util.Map;
import java.util.UUID;

public class TIMVPlayerData {
	private int badkills_detective;
	private int badkills_inno;
	private int badkills_traitor;
	private int claymores_bought;
	private int claymores_used;
	private int creeper_bought;
	private int creeper_used;
	private int det_passes_used;
	private long first_played;
	private int flares;
	private int games;
	private int games_det;
	private int games_inno;
	private int games_traitor;
	private int goodkills_detective;
	private int goodkills_inno;
	private int goodkills_traitor;
	private int karma;
	private int kills;
	private Map<String, Integer> maps_played;
	private UUID player;
	private int regen_bought;
	private int regen_used;
	private int spoofer_bought;
	private int spoofer_used;
	private int suicide_bought;
	private int suicide_used;
	private int tests;
	private int traitor_passes_used;
	private long updated;

	public int getBadKillsDetective() {
		return badkills_detective;
	}

	public int getBadKillsInnocent() {
		return badkills_inno;
	}

	public int getBadKillsTraitor() {
		return badkills_traitor;
	}

	public int getClaymoresBought() {
		return claymores_bought;
	}

	public int getClaymoresUsed() {
		return claymores_used;
	}

	public int getCreeperBought() {
		return creeper_bought;
	}

	public int getCreeperUsed() {
		return creeper_used;
	}

	public int getDetectivePassesUsed() {
		return det_passes_used;
	}

	public long getFirstPlayed() {
		return first_played;
	}

	public int getFlares() {
		return flares;
	}

	public int getGames() {
		return games;
	}

	public int getGamesDetective() {
		return games_det;
	}

	public int getGamesInnocent() {
		return games_inno;
	}

	public int getGamesTraitor() {
		return games_traitor;
	}

	public int getGoodKillsDetective() {
		return goodkills_detective;
	}

	public int getGoodKillsInnocent() {
		return goodkills_inno;
	}

	public int getGoodKillsTraitor() {
		return goodkills_traitor;
	}

	public int getKarma() {
		return karma;
	}

	public int getKills() {
		return kills;
	}

	public Map<String, Integer> getMapsPlayed() {
		return maps_played;
	}

	public UUID getPlayer() {
		return player;
	}

	public int getRegenBought() {
		return regen_bought;
	}

	public int getRegenUsed() {
		return regen_used;
	}

	public int getSpooferBought() {
		return spoofer_bought;
	}

	public int getSpooferUsed() {
		return spoofer_used;
	}

	public int getSuicideBought() {
		return suicide_bought;
	}

	public int getSuicideUsed() {
		return suicide_used;
	}

	public int getTests() {
		return tests;
	}

	public int getTraitorPassesUsed() {
		return traitor_passes_used;
	}

	public long getUpdated() {
		return updated;
	}

}
