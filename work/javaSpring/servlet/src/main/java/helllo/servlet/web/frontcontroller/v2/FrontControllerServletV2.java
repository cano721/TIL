package helllo.servlet.web.frontcontroller.v2;

import helllo.servlet.web.frontcontroller.MyView;
import helllo.servlet.web.frontcontroller.v1.ControllerV1;
import helllo.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import helllo.servlet.web.frontcontroller.v1.controller.MemberListController;
import helllo.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import helllo.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import helllo.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import helllo.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // key 해당하는 벨류가 나옴.( 예시: new MemberSaveControllerV2())
        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
