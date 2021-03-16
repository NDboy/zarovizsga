package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getDogsByCountry(String country) {
        List<String> foundDogs = new ArrayList<>();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select name from dog_types where country = ?")){
            stmt.setString(1, country.toUpperCase());
            loadSelectedDogsToList(foundDogs, stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        foundDogs.sort(Comparator.naturalOrder());
        return foundDogs;

    }

    private void loadSelectedDogsToList(List<String> foundDogs, PreparedStatement stmt) {

        try (ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                foundDogs.add(rs.getString(1).toLowerCase());
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not execute query", se);
        }
    }

}
