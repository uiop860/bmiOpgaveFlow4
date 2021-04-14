package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBmiPageCommand extends CommandProtectedPage{

    public ShowBmiPageCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {




        return pageToShow;
    }

    @Override
    public String getRole() {
        return super.getRole();
    }
}
