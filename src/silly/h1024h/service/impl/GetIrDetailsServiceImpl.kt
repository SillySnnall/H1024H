package silly.h1024h.service.impl

import silly.h1024h.entity.ImgRes
import javax.servlet.http.HttpServletRequest

interface GetIrDetailsServiceImpl {
    /**
     * 获取组信息
     */
    fun getIrDetails():List<String>
}