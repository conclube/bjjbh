package common;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Credentials {
    private static final Pattern VALID_USERNAME = Pattern.compile("^[A-Za-z0-9]+$");

    private final String username;

    Credentials(String username) {
        this.username = username;
    }

    public static Credentials of(String username) {
        if (!VALID_USERNAME.matcher(username).matches()) {
            throw new RuntimeException("Invalid username");
        }
        return new Credentials(username);
    }

    public String username() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Credentials) obj;
        return Objects.equals(this.username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Credentials[" +
                "username=" + username + ']';
    }

}