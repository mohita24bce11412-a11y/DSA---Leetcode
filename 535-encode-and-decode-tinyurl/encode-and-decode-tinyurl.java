import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BASE_HOST = "http://tinyurl.com/";
    private static final int KEY_LENGTH = 6;

    private final Map<String, String> shortToLong = new HashMap<>();
    private final Map<String, String> longToShort = new HashMap<>();
    private final Random random = new Random();

    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return BASE_HOST + longToShort.get(longUrl);
        }

        String key = generateKey();
        while (shortToLong.containsKey(key)) {
            key = generateKey(); // Handle rare collision
        }

        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);

        return BASE_HOST + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_HOST, "");
        return shortToLong.get(key);
    }

    private String generateKey() {
        StringBuilder key = new StringBuilder(KEY_LENGTH);
        for (int i = 0; i < KEY_LENGTH; i++) {
            key.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return key.toString();
    }
}