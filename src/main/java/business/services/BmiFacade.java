package business.services;

import business.exceptions.UserException;
import business.persistence.BmiMapper;
import business.persistence.Database;

import java.util.List;

public class BmiFacade {

    private BmiMapper bmiMapper;

    public BmiFacade(Database database) {

        this.bmiMapper = new BmiMapper(database);

    }

    public void InsertBmiEntry(double bmi, double height, double weight, String gender, String category, int sportid, int userid, List<Integer> hobbyList) throws UserException {

        bmiMapper.insertBmiEntry(bmi,height,weight, gender, category,sportid,userid,hobbyList);

    }

}
