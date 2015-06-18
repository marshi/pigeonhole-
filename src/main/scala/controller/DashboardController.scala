package controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
 * @author mukai_masaki on 2015/06/19.
 */
class DashboardController extends Controller {

  get ("/helloworld") { request: Request =>
    response.ok().body("hello pigeion")
  }

}
