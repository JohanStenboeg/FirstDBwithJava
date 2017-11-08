package StenboegJohan;

        import java.sql.Connection;

public class TestClass {
    public static void main(String[] args) {
        DB_Statements stmt = new DB_Statements();
        stmt.createNewDB("ThisDatabase");
        stmt.useDB("ThisDatabase");
        stmt.createTable("MyTable");
        stmt.insertData("MyTable");
        stmt.selectFromTable("MyTable");
        Login_GUI run = new Login_GUI();
    }
}
