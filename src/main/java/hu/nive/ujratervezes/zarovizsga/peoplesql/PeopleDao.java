package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select ip_address from people where first_name = ? and last_name = ?")){
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return getIpStringByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
    }


    private String getIpStringByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()){
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not execute query", se);
        }
        throw new IllegalArgumentException("Ip not found!");
    }

}

