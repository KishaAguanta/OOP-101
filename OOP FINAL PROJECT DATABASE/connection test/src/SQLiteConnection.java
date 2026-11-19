import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteConnection {
    public static void main(String[] args) {
        // SQLite database URL (create a new database if it doesn't exist)
        String url = "jdbc:sqlite:sample.db";  // replace with your database file path

        // SQL statement to create a table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create a table
            stmt.execute(createTableSQL);
            System.out.println("Database connection established, table created.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
