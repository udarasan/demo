package dao;

import dto.LoginDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public String login (LoginDTO loginDTO) throws SQLException, ClassNotFoundException {

        String sql="SELECT Password FROM User Where username =?";
        ResultSet rst=CrudUtil.executeQuery(sql,loginDTO.getUsername());
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
