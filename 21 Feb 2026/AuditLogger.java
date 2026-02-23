import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private AuditLogger() {}

    public static void log(String msg) {
        System.out.println("[AUDIT " + LocalDateTime.now().format(FMT) + "] " + msg);
    }

    public static void logError(Exception e) {
        System.out.println("[ERROR " + LocalDateTime.now().format(FMT) + "] " +
                e.getClass().getSimpleName() + ": " + e.getMessage());
    }
}
