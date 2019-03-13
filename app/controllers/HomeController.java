package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    public Result index() {
        ObjectNode result = Json.newObject();
        result.put("test", "foobar");
        result.put("thing", "Hello world!");
        return ok(result);
    }
}
