package business.persistence;

import business.exceptions.UserException;

import java.sql.*;
import java.util.List;

public class BmiMapper {

    private Database database;

    public BmiMapper(Database database) {
        this.database = database;
    }


    public void insertBmiEntry(double bmi, double height, double weight, String gender, String category, int sportid, int userid, List<Integer> hobbyList) throws UserException {

        //TODO: insert data into database

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO bmi.bmi_entries(height,weight,category,bmi,gender,sport_id,user_id) VALUES(?,?,?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setDouble(1,height);
                ps.setDouble(2,weight);
                ps.setString(3,category);
                ps.setDouble(4,bmi);
                ps.setString(5,gender);
                ps.setInt(6,sportid);
                ps.setInt(7,userid);

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int bmiEntryID = ids.getInt(1);

                // TODO: her skal vi indsætte hobbyer i link_hobby_bmi_entry tabel
                for (Integer item : hobbyList) {
                    insertIntoLinkHobbyEntryBmiEntry(bmiEntryID, item);
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public void insertIntoLinkHobbyEntryBmiEntry(int bmiEntryID, int hobbyID)throws UserException{

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO bmi.link_bmi_hobby(hobby_id,bmi_entry_id) VALUES(?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,hobbyID);
                ps.setInt(2,bmiEntryID);

                ps.executeUpdate();

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
}
