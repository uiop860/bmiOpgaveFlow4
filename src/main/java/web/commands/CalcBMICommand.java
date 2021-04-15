package web.commands;

import business.exceptions.UserException;
import business.services.BmiFacade;
import business.services.BmiUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcBMICommand extends CommandUnprotectedPage {


    private BmiFacade bmiFacade;

    public CalcBMICommand(String pageToShow) {
        super(pageToShow);
        this.bmiFacade = new BmiFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int userid = 1; //TODO: skal laves dynamisk i forhold til login
        double height = 0.0;
        double weight = 0.0;
        double bmi = 0.0;
        String category = "";
        String gender = request.getParameter("gender");
        int sportid = Integer.parseInt(request.getParameter("sport"));

        String[] hobbies = request.getParameterValues("hobby");
        List<String> hobbyListStrings = null;
        if(hobbies != null){
            hobbyListStrings = Arrays.asList(hobbies);
        }

        List<Integer> hobbyList = new ArrayList<>();

        for (String item : hobbyListStrings) {

            hobbyList.add(Integer.parseInt(item));

        }

        try{
            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        } catch(NumberFormatException e){
            request.setAttribute("error","Husk at du skal indtaste 2 hele tal i formularen");
            return "index";
            /*throw new UserException("Husk at du skal indtaste 2 hele tal i formularen");*/
        }

        bmi = BmiUtil.calcBMI(height,weight);
        category = BmiUtil.getCategory(bmi);

        request.setAttribute("bmi", String.format("%.2f", bmi));
        request.setAttribute("height",height);
        request.setAttribute("weight",weight);
        request.setAttribute("category",category);

        request.setAttribute("gender",gender);
        request.setAttribute("sport_id",sportid);
        request.setAttribute("hobbies",hobbyListStrings);

        bmiFacade.InsertBmiEntry(bmi,height,weight,gender,category,sportid,userid,hobbyList);

        return pageToShow;
    }
}
