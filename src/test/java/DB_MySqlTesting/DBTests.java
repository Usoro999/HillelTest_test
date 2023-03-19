package DB_MySqlTesting;

import MySQLconfig.Connect;
import MySQLconfig.UserFromDB;
import com.mysql.cj.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTests {
    @Test
    public void selectUserById(){
        String request = "select * from sys.users where id = 2";
        try {
            ResultSet response = Connect.createStatement().executeQuery(request);
            response.next();
            System.out.println(response.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void selectAllUserNames(){
        String request = "select * from sys.users";
        ResultSet response = null;
        List<String> names = new ArrayList<>();
        try {
            response = Connect.createStatement().executeQuery(request);
            while(response.next()){
                names.add(response.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(String l: names){
            System.out.println(l);
        }

    }

    @Test
    public void getUserList(){
        String request = "select * from sys.users";
        List<UserFromDB> userFromDBList = new ArrayList<>();
        ResultSet response = null;
        try {
            response = Connect.createStatement().executeQuery(request);
            while(response.next()) {
                userFromDBList.add(new UserFromDB(response));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(userFromDBList.get(0).getEmail());
        System.out.println(userFromDBList.size());


    }

    @Test
    public void checkCreateNewUser(){
        UserFromDB user = new UserFromDB("Martun","martun@gmail.com",17,"1234qwerty");
        String request = "INSERT INTO `sys`.`Users` (`id`,`name`,`email`,`password`) \n" +
                "VALUES ('"+user.getId()+"','"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"');";

        boolean response;

        try {
            response = Connect.createStatement().execute(request);
        } catch (SQLException e) {
             response = true;

        }
        Assert.assertTrue(response, "Must be true"); //If there are no errors it will be FALSE
    }

    @Test
    public void checkDeleteUser(){
        String request = "DELETE FROM sys.Users WHERE id = 17";
        boolean response;
        try {
            response = Connect.createStatement().execute(request);
        } catch (SQLException e) {
            response = true;
        }
        Assert.assertFalse(response); //If there are no errors it will be FALSE
    }
    //    public void selectByUserNameEmail(String username, String email) {
//        String s = "SELECT * FROM sys.user where username=\"" + username + "\" and email=\"" + email + "\"";
//        try {
//            ResultSet resultSet = statement.executeQuery(s);//запрос с ответом resultset(ответ)
//            resultSet.next();
//            System.out.println(resultSet.getString("username"));
//            System.out.println(resultSet.getString("password"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void selectUsersByName(String UserName){
//      String s="SELECT * FROM sys.user where username=\""+UserName+"\"";
//        try {
//            ResultSet resultSet=statement.executeQuery(s);
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public Human getUserByid(String id){
//        String s="SELECT * FROM sys.user where id=\""+id+"\"";
//        Human human=null;
//        try {
//            ResultSet resultSet=statement.executeQuery(s);
//            resultSet.next();
//            //Human testuse=new Human("fkff","fff@dd.com","pass","jjjf888");
//            human=new Human(
//                    resultSet.getString("username"),
//                    resultSet.getString("email"),
//                    resultSet.getString("password"),
//                    resultSet.getString("id"));
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return human ;
//    }
//
//    public void insert(String username, String password, String email)  {
//        UUID uuid = UUID.randomUUID();
//        String s = "INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) VALUES (\"" + username + "\",\"" + email + "\"" +
//                ",\"" + password + "\",\"" + uuid.toString() + "\");";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void insert(String username, String password, String email,String id)  {
//        String s = "INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) VALUES (\"" + username + "\",\"" + email + "\"" +
//                ",\"" + password + "\",\"" + id + "\");";
//        //System.out.println(s);
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void delete(String id)  {
//        //DELETE FROM `sys`.`user` WHERE (`id` = '62028969-a6ed-4a17-b546-0d73743f64b7');
//        String s="DELETE FROM `sys`.`user` WHERE (`id` = '"+id+"');";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
////    public USER selectfromID(String UUID) throws SQLException {
////        String s="SELECT * FROM sys.user WHERE `id`=\""+UUID+"\";";
////        ResultSet resultSet=statement.executeQuery(s);
////        resultSet.next();
////        return new USER(resultSet.getString("username"),
////                        resultSet.getString("password"),
////                        resultSet.getString("email"),
////                        resultSet.getString("createtime"),
////                        resultSet.getString("id"));
////    }
//    public List<Human> getListAllUsers() throws SQLException {
//        String s="SELECT * FROM sys.user;";
//        ResultSet resultSet=statement.executeQuery(s);
//        List<Human> users=new ArrayList<>();
//        while (resultSet.next()){
//            users.add(new Human(resultSet.getString("username"),
//                    resultSet.getString("password"),
//                    resultSet.getString("email"),
//                    resultSet.getString("id")));
//        }
//        return users;
//    }
//    public void UpdatePassword(String pass,String id){
//        String s="UPDATE `sys`.`user` SET `password` = \""+pass+"\" WHERE (`id` = \""+id+"\")";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
