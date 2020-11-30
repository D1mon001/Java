package postgreSQL;
import java.sql.*;
import exceptions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class UserDatabase {
    private Connector connection;

    public UserDatabase() throws SQLException {
        connection = new Connector();
        //DataBasePoolConnection dbc = new DataBasePoolConnection();
        //connection = dbc.setUp();
    }

    private static final String CREATE_TABLE = "create table if not exists users " +
            "(id serial, " +
            "name varchar(100) unique not null, " + "surname varchar(100), " +
            "address varchar(20), " + "birthdate DATE)";
    private static final String DROP = "DROP TABLE IF EXISTS %s";

    private static final String CREATE_USER = "insert into users (name, surname, address, birthdate) values (?, ?, ?, ?)";
    private static final String ALL_USERS = "select * from users";

    private static final String EDIT_USER = "update users set number = ?, brand = ?, year = ?, birthdate = ? where id = ?;";
    private static final String GET_USER_BY_ID = "select * from users where id = ?";

    private static final String GET_USER_BY_NAME_SURNAME = "select * from users where name = ?, surname = ?";

    public boolean createTableUser() throws SQLException {
        try (Connection conn = connection.getConnection()) {
            Statement statement = conn.createStatement();
            return statement.execute(CREATE_TABLE);
        }
    }

    public int addUser(User user) throws SQLException {
        try (Connection conn = connection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setDate(4, Date.valueOf(user.getBirthdate()));
            return preparedStatement.executeUpdate();
        }
    }

    public int editUser(User user, int id) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(EDIT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(5, id);
            preparedStatement.setString(2, user.getSurname().toString());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setDate(4, Date.valueOf(user.getBirthdate()));
            return preparedStatement.executeUpdate();
        }
    }


    public User getById(int id) throws SQLException, UserNotFoundException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_USER_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            User u = null;
            CarDatabase c = new CarDatabase();
            while (rs.next()) {
                u = new User(rs.getString("name"), rs.getString("surname"));
                u.setAddress(rs.getString("address"));
                u.setBirthdate(rs.getDate("birthdate").toLocalDate());
                u.setId(rs.getInt("id"));
                u.setTransports(c.getByUserId(rs.getInt("id")));
                return u;
            }
            throw new UserNotFoundException();
        }
    }

    public User getByNameSurname(String name, String surname) throws SQLException, UserNotFoundException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_USER_BY_NAME_SURNAME);
            statement.setString(1, name);
            statement.setString(2, surname);
            ResultSet rs = statement.executeQuery();
            User u = null;
            CarDatabase c = new CarDatabase();
            while (rs.next()) {
                u = new User(rs.getString("name"), rs.getString("surname"));
                u.setAddress(rs.getString("address"));
                u.setBirthdate(rs.getDate("birthdate").toLocalDate());
                u.setId(rs.getInt("id"));
                u.setTransports(c.getByUserId(rs.getInt("id")));
                return u;
            }
            throw new UserNotFoundException();
        }
    }

    public List<User> getAll() throws SQLException {
        try (Connection conn = connection.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(ALL_USERS);
            List<User> users = new ArrayList<>();
            CarDatabase c = new CarDatabase();
            while (rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("surname"));
                user.setAddress(rs.getString("address"));
                user.setBirthdate(rs.getDate("birthdate").toLocalDate());
                user.setId(rs.getInt("id"));
                user.setTransports(c.getByUserId(rs.getInt("id")));
                users.add(user);
            }
            return users;
        }
    }
}
