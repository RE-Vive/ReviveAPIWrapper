package revive.wrapper.client;

import java.io.IOException;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import revive.wrapper.objects.GeneralPlayerData;
import revive.wrapper.objects.MapTimes;
import revive.wrapper.objects.adapters.UUIDAdapter;
import revive.wrapper.objects.minigames.BedwarsPlayerData;
import revive.wrapper.objects.minigames.BlockPartyPlayerData;
import revive.wrapper.objects.minigames.DeathRunPlayerData;
import revive.wrapper.objects.minigames.GravityPlayerData;
import revive.wrapper.objects.minigames.TIMVPlayerData;

public class ReviveAPI {

	private Gson gson;
	private static String BASE_URL = "https://api.mcrevive.net";

	public ReviveAPI() {
		super();
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(UUID.class, new UUIDAdapter());
		builder.registerTypeAdapter(MapTimes.class, MapTimes.getAdapter());

		this.gson = builder.create();
	}

	private Connection useEndpoint(String endpointPath) {
		return Jsoup.connect(BASE_URL + endpointPath);
	}

	public GeneralPlayerData getPlayerData(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/data");
		conn.data("player", player.toString());

		GeneralPlayerData result = gson.fromJson(conn.execute().body(), GeneralPlayerData.class);
		return result;
	}

	public BedwarsPlayerData getBedwarsStats(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/bedwars");
		conn.data("player", player.toString());

		BedwarsPlayerData result = gson.fromJson(conn.execute().body(), BedwarsPlayerData.class);
		return result;
	}

	public TIMVPlayerData getTIMVStats(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/timv");
		conn.data("player", player.toString());

		TIMVPlayerData result = gson.fromJson(conn.execute().body(), TIMVPlayerData.class);
		return result;
	}

	public DeathRunPlayerData getDeathRunStats(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/deathrun");
		conn.data("player", player.toString());

		DeathRunPlayerData result = gson.fromJson(conn.execute().body(), DeathRunPlayerData.class);
		return result;
	}

	public GravityPlayerData getGravityStats(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/gravity");
		conn.data("player", player.toString());

		GravityPlayerData result = gson.fromJson(conn.execute().body(), GravityPlayerData.class);
		return result;
	}

	public BlockPartyPlayerData getBlockPartyStats(UUID player) throws IOException {
		Connection conn = useEndpoint("/api/v1/player/blockparty");
		conn.data("player", player.toString());

		BlockPartyPlayerData result = gson.fromJson(conn.execute().body(), BlockPartyPlayerData.class);
		return result;
	}

}
