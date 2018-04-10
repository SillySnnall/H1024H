package silly.h1024h.home.web.action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ModelDriven
import silly.h1024h.base.BaseAction
import silly.h1024h.entity.ImgRes
import silly.h1024h.home.service.ImgResService

class ImgResAction : BaseAction(), ModelDriven<ImgRes> {
    private val imgResService = ImgResService()
    private val imgRes = ImgRes()
    override fun getModel(): ImgRes {
        return imgRes
    }

    /**
     * 获取封面
     */
    fun getCoverImg():String{
        successData(imgResService.getCover(imgRes))
        return Action.NONE
    }
}
