package silly.h1024h.home.web.action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport

class LoginAction : ActionSupport() {

    fun login(): String {

        println("hello world!")

        return Action.NONE
    }

    fun add(): String {

        println("add")

        return Action.SUCCESS
    }

}
