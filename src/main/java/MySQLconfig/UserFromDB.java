package MySQLconfig;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFromDB {
    private String name;
    private String email;
    private int id;
    private String password;

    public UserFromDB(String name, String email, int id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public UserFromDB(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserFromDB(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt("id");
        name = resultSet.getString("name");
        password = resultSet.getString("password");
        email = resultSet.getString("email");
    }

    @Override
    public String toString() {
        return "UserFromDB{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
