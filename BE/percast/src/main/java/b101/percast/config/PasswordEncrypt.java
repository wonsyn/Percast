package b101.percast.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Objects;

public class PasswordEncrypt {

    public static String encrypt(String password) {
        String salt = getSalt();
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Objects.requireNonNull(salt).getBytes());

            byte[] passBytes = password.getBytes();
            // Get the hash's bytes
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digested) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;
        }
    }

    public static String getSalt() {
        try {
            // Always use a SecureRandom generator
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
            // Create array for salt
            byte[] salt = new byte[16];
            // Get a random salt
            sr.nextBytes(salt);
            // return salt
            return salt.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

}
