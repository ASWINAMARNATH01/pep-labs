
import Util.ConnectionUtil;
import kotlin.Pair;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class InnerJoinTest {
    private final InnerJoinActivity innerJoinActivity = new InnerJoinActivity();
    private static Connection conn;

    @Test
    public void testActivityInnerJoin1() {
        Set<Pair<Integer, String>> expected = new HashSet<>();
        expected.add(new Pair<Integer, String>(1, "John Stewart"));
        expected.add(new Pair<Integer, String>(4, "Aasif Mandvi"));

        Set<Pair<Integer, String>> result = innerJoinActivity.problem1();

        Assert.assertEquals(expected, result);

    }

    @Test
    public void testActivityInnerJoin2() {
        Set<ExampleEntity> expected = new HashSet<>();
        expected.add(new ExampleEntity("Physics", "Mr. Tyson", "Stephen Colbert", "Motion 101"));
        expected.add(new ExampleEntity("Physics", "Mr. Tyson", "Robert Riggle", "Motion 101"));

        Set<ExampleEntity> result = innerJoinActivity.problem2();

        Assert.assertEquals(expected, result);

    }





























    @BeforeClass
    public static void beforeAll() {
        conn = ConnectionUtil.getConnection();
    }


    @Before
    public void beforeEach() {
        try {
            String facultyTable = "CREATE TABLE faculty (" +
                    "id SERIAL PRIMARY KEY," +
                    "teacher VARCHAR(255)," +
                    "class VARCHAR(255)" +
                    ");";
            PreparedStatement facultyTableStatement = conn.prepareStatement(facultyTable);
            facultyTableStatement.executeUpdate();

            String insertFaculty = "INSERT INTO faculty (teacher, class) VALUES" +
                    "('Mr. Tyson', 'Physics')," +
                    "('Ms. Lovelace', 'Math')," +
                    "('Mr. McCarthy', 'Writing')," +
                    "('Ms. Goodall', 'Biology');";
            PreparedStatement insertFacultyData = conn.prepareStatement(insertFaculty);
            insertFacultyData.executeUpdate();


            String studentsTable = "CREATE TABLE students (" +
                    "id SERIAL PRIMARY KEY," +
                    "student VARCHAR(255)," +
                    "class VARCHAR(255)" +
                    ");";
            PreparedStatement studentsTableStatement = conn.prepareStatement(studentsTable);
            studentsTableStatement.executeUpdate();

            String insertStudents = "INSERT INTO students (student, class) VALUES" +
                    "('John Stewart', 'Writing')," +
                    "('Stephen Colbert', 'Physics')," +
                    "('Samantha Bee', 'Math')," +
                    "('Aasif Mandvi', 'Writing')," +
                    "('Robert Riggle', 'Physics')," +
                    "('Jessica Williams', 'Art');";
            PreparedStatement insertStudentsData = conn.prepareStatement(insertStudents);
            insertStudentsData.executeUpdate();


            String textbooksTable = "CREATE TABLE textbooks (" +
                    "id SERIAL PRIMARY KEY," +
                    "class VARCHAR(255)," +
                    "textbook VARCHAR(255)" +
                    ");";
            PreparedStatement textbooksTableStatement = conn.prepareStatement(textbooksTable);
            textbooksTableStatement.executeUpdate();

            String insertTextbooks = "INSERT INTO textbooks (class, textbook) VALUES" +
                    "('Physics' , 'Motion 101')," +
                    "('Math', 'What even is modulus anyway?')," +
                    "('Biology', 'Lions, Tigers, and Organs 5th ed')," +
                    "('Writing', 'The Story Circle Workbook')," +
                    "('Art', 'Teenage Mutant Ninja Turtles #10');";
            PreparedStatement insertTextbooksStatement = conn.prepareStatement(insertTextbooks);
            insertTextbooksStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @After
    public void afterEach() {
        try {
            conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS faculty, students, textbooks";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @AfterClass
    public static void afterAll() {
        try {
            conn.close();
        } catch(SQLException e) {
        }

    }
}
