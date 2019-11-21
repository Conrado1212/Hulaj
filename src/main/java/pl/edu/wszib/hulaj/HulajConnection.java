package pl.edu.wszib.hulaj;

import pl.edu.wszib.hulaj.model.Scooter;

import java.sql.*;

public class HulajConnection {
    public static Connection connection = null;

    public static void connect(){
        //polaczenie z baza danych
        try{
            Class.forName("com.mysql.jdbc.Driver");
            HulajConnection.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/scooter?scooter=root&passwords=");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void addScooter(Scooter scooter){
        String sql = "INSERT INTO scooter (brand,model,scooterId,price,rent) VALUES (?,?,?,?,?)";


        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = HulajConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,scooter.getBrand());
            preparedStatement.setString(2,scooter.getModel());
            preparedStatement.setInt(3,scooter.getScooterId());
            preparedStatement.setDouble(4,scooter.getPrice());
            preparedStatement.setBoolean(5,scooter.isRent());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Scooter getScooter(String brand,String model,int scooterId,int price,boolean rent){
        String sqlSelect = "SELECT * FROM scooter WHERE model = ?";
        try{
            PreparedStatement preparedStatement = HulajConnection.connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1,brand);
            preparedStatement.setString(2,model);
            preparedStatement.setInt(3,scooterId);
            preparedStatement.setInt(4,price);
            preparedStatement.setBoolean(5,rent);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Scooter scooter1 = new Scooter();
                scooter1.setBrand(resultSet.getString("Brand"));
                scooter1.setModel(resultSet.getString("Model"));
                scooter1.setScooterId(resultSet.getInt("id"));
                scooter1.setPrice(resultSet.getDouble("price"));
                scooter1.setRent(resultSet.getBoolean("rent"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Scooter getUpdate(String model){
        try{
            String sqlSelect = "SELECT * FROM scooter WHERE model = ?";
            PreparedStatement preparedStatement = HulajConnection.connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1,model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Scooter scooter1 = new Scooter();
                scooter1.setBrand(resultSet.getString("Brand"));
                scooter1.setModel(resultSet.getString("Model"));
                scooter1.setScooterId(resultSet.getInt("id"));
                scooter1.setPrice(resultSet.getDouble("price"));
                scooter1.setRent(resultSet.getBoolean("rent"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Scooter removeScooterId(int scooterId){
        String sqlSelect = "SELECT * FROM scooter WHERE scooterId = ?";
        try{
            PreparedStatement preparedStatement = HulajConnection.connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1,scooterId);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.clearParameters();
            while (resultSet.next()){
                Scooter scooter1 = new Scooter();
                scooter1.setBrand(resultSet.getString("Brand"));
                scooter1.setModel(resultSet.getString("Model"));
                scooter1.setScooterId(resultSet.getInt("id"));
                scooter1.setPrice(resultSet.getDouble("price"));
                scooter1.setRent(resultSet.getBoolean("rent"));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
