package silly.h1024h.isentity

import silly.h1024h.entity.ImgRes
import silly.h1024h.entity.User

/**
 * User字段判空类
 */
object IsEmptyImgRes {

    fun isCoverImgRes(imgRes: ImgRes): String {
//        if (imgRes.pageNum()) return "请填写用户名"
//        if (imgRes.getuPassword().isNullOrEmpty()) return "请填写密码"
        return ""
    }
}