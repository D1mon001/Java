package postgreSQL;
import java.sql.*;
import exceptions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.*;
public class CarDatabase {

    private Connector connection;

    public CarDatabase() throws SQLException {
        connection = new Connector();
        //DataBasePoolConnection dbc = new DataBasePoolConnection();
        //connection = dbc.setUp();
    }

    private static final String CREATE_TABLE = "create table if not exists car " +
            "(id serial, " +
            "number varchar(100) unique not null, " +
            "brand varchar(10), " + "year int4, " + "user_id int4)";
    private static final String DROP = "DROP TABLE IF EXISTS %s";

    private static final String CREATE_CAR = "insert into car (number, brand, year, user_id) values (?, ?, ?, ?)";
    private static final String ALL_CARS = "select * from car";

    private static final String EDIT_CAR = "update car set number = ?, brand = ?, year = ?, user_id = ? where id = ?;";
    private static final String GET_CAR_BY_ID = "select * from car where id = ?";

    private static final String GET_CAR_BY_NUMBER = "select * from car where number = ?";
    private static final String GET_CAR_BY_USER_ID = "select * from car where user_id = ?";


    /*private static void Execute(String query) throws SQLException {
        Connection connection = Connector.getConnection();
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            Connector.Disconnect(connection);
        }
    }*/

    public boolean createTableCar() throws SQLException {
        try (Connection conn = connection.getConnection()) {
            Statement statement = conn.createStatement();
            return statement.execute(CREATE_TABLE);
        }
    }

    public int addCar(Car car) throws SQLException {
        try (Connection conn = connection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_CAR);
            preparedStatement.setString(1, car.getNumber());
            preparedStatement.setString(2, car.getBrand().toString());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setInt(4, car.getUser_id());
            return preparedStatement.executeUpdate();
        }
    }

    public int editCar(Car car, int id) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(EDIT_CAR);
            preparedStatement.setString(1, car.getNumber());
            preparedStatement.setInt(5, id);
            preparedStatement.setString(2, car.getBrand().toString());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setInt(4, car.getUser_id());
            return preparedStatement.executeUpdate();
        }
    }


    public Car getById(int id) throws SQLException, CarNotFoundException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_CAR_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Car c = null;
            while (rs.next()) {
                c = new Car(rs.getString("number"));
                c.setBrand(Car.Brand.valueOf(rs.getString("brand")));
                c.setYear(rs.getInt("year"));
                c.setId(rs.getInt("id"));
                c.setUser_id(rs.getInt("user_id"));
                return c;
            }
            throw new CarNotFoundException();
        }
    }

    public Car getByNumber(String number) throws SQLException, CarNotFoundException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_CAR_BY_NUMBER);
            statement.setString(1, number);
            ResultSet rs = statement.executeQuery();
            Car c = null;
            while (rs.next()) {
                c = new Car(rs.getString("number"));
                c.setBrand(Car.Brand.valueOf(rs.getString("brand")));
                c.setYear(rs.getInt("year"));
                c.setId(rs.getInt("id"));
                c.setUser_id(rs.getInt("user_id"));
                return c;
            }
            throw new CarNotFoundException();
        }
    }

    public List<Car> getByUserId(int user_id) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_CAR_BY_USER_ID);
            statement.setInt(1, user_id);
            ResultSet rs = statement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getString("number"));
                car.setBrand(Car.Brand.valueOf(rs.getString("brand")));
                car.setYear(rs.getInt("year"));
                car.setId(rs.getInt("id"));
                car.setUser_id(rs.getInt("user_id"));
                cars.add(car);
            }
            return cars;
        }
    }

    public List<Car> getAll() throws SQLException {
        try (Connection conn = connection.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(ALL_CARS);
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getString("number"));
                car.setBrand(Car.Brand.valueOf(rs.getString("brand")));
                car.setYear(rs.getInt("year"));
                car.setId(rs.getInt("id"));
                car.setUser_id(rs.getInt("user_id"));
                cars.add(car);
            }
            return cars;
        }
    }
}