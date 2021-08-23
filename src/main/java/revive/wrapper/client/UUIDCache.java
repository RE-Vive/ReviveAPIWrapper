package revive.wrapper.client;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class UUIDCache {

	/**
	 * Build everything needed, and assign the instance of the plugin
	 */
	public void initialize() {
		instance = this;

		// Clear the cache so it doesnt become a memory drag!
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				uuidCache.clear();
				reverseUuidCache.clear();
			}
		}, 0, 3_600_000 * 2 /* 2 hours */);
	}

	/**
	 * Shuts down the plugin. Be aware that any kind of attempt at fetching UUID's
	 * after this method was called will not work!
	 */
	public void shutdown() {
		service.shutdown();
		try {
			service.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong while shutting down UUIDCache!");
			e.printStackTrace();
		}
	}

	/**
	 * Static instance of {@link UUIDCache}
	 */
	private static UUIDCache instance;

	/**
	 * Caches for UUID - Name, Name - UUID relations!
	 */
	private static Map<String, UUID> uuidCache = new ConcurrentHashMap<>();
	private static Map<UUID, String> reverseUuidCache = new ConcurrentHashMap<>();

	/**
	 * The thread pool which handles the requests
	 */
	private static ExecutorService service = Executors.newCachedThreadPool();

	/**
	 * Returns the UUID for a certain username!
	 * 
	 * @param username - The username needed
	 * @return - A {@link CompletableFuture} which will contain the UUID of the
	 *         player or null if it was not found. Any errors will be followed by a
	 *         null completion of the future
	 */
	public static CompletableFuture<UUID> getUUIDFor(String username) {
		CompletableFuture<UUID> future = new CompletableFuture<>();

		if (uuidCache.containsKey(username))
			future.complete(uuidCache.get(username));
		else
			service.execute(() -> {
				try {
					JsonElement element = JsonParser.parseString(Jsoup
							.connect("https://api.minetools.eu/uuid/" + username).ignoreContentType(true).get().text());

					UUID u = fromStringUUID(element.getAsJsonObject().get("id").getAsString());
					uuidCache.put(username, u);
					reverseUuidCache.put(u, username);
					future.complete(u);
				} catch (Exception e) {
					future.complete(null);
				}
			});

		return future;
	}

	/**
	 * Inserts the dashes in a trimmed uuid
	 * 
	 * @param uuid - The trimmed UUID
	 * @return - The UUID from the trimmed UUID, or null if the UUID given was
	 *         invalid!
	 */
	private static UUID fromStringUUID(String uuid) {
		try {
			return UUID.fromString(
					new StringBuilder(uuid).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Fetches the username of a player based on UUID.
	 * 
	 * @param u - The UUID of the player
	 * @return - The username of the player or null if not found!
	 */
	public static CompletableFuture<String> getUsernameFor(UUID u) {
		CompletableFuture<String> future = new CompletableFuture<>();
		if (reverseUuidCache.containsKey(u))
			reverseUuidCache.get(u);
		service.execute(() -> {
			try {
				JsonElement element = JsonParser.parseString(
						Jsoup.connect("https://api.minetools.eu/uuid/" + u).ignoreContentType(true).get().text());
				String username = element.getAsJsonObject().get("name").getAsString();

				uuidCache.put(username, u);
				reverseUuidCache.put(u, username);
				future.complete(username);
			} catch (Exception ex) {
				future.complete(null);
			}
		});

		return future;
	}

	/**
	 * Returns an instance of the UUIDCache
	 * 
	 * @return - The instance of the UUIDCache, or null if not initialized yet
	 */
	public static UUIDCache getInstance() {
		return instance;
	}
}
