package silly.h1024h.base

import com.google.gson.Gson
import com.opensymphony.xwork2.ActionSupport
import org.apache.struts2.ServletActionContext
import silly.h1024h.entity.FailData
import silly.h1024h.entity.SuccessData

open class BaseAction : ActionSupport() {

    init {
        ServletActionContext.getResponse().contentType = "text/json;charset=utf-8"
        ServletActionContext.getResponse().characterEncoding = "utf-8"
        ServletActionContext.getResponse().contentType = "text/json;charset=utf-8"
        ServletActionContext.getResponse().addHeader("Access-Control-Allow-Origin", "*")
    }

    /**
     * 返回成功的数据
     */
    fun successData(map: Map<String, Any>) {
        val writer = ServletActionContext.getResponse().writer
        writer.write(Gson().toJson(SuccessData(0, "msgok", map)))
        writer.flush()
        writer.close()
    }

    /**
     * 返回失败的数据
     */
    fun failData(msg: Int, param: String) {
        val writer = ServletActionContext.getResponse().writer
        writer.write(Gson().toJson(FailData(msg, param)))
        writer.flush()
        writer.close()
    }
}