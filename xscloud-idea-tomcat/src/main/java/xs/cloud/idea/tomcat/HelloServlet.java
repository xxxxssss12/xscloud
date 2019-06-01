package xs.cloud.idea.tomcat;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by xs on 2019/6/1.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setHeader("Content-Type", "application/json;charset=utf-8");
            OutputStream out = resp.getOutputStream();
            JSONObject obj = new JSONObject();
            obj.put("msg", "你好，世界！");
            obj.put("code", true);
            out.write(obj.toJSONString().getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }
}