package silly.h1024h.service.impl

import silly.h1024h.entity.ImgRes

interface ImgResServiceImpl {
    /**
     * 获取封面数据
     */
    fun getCover(imgRes: ImgRes): List<ImgRes>
    /**
     * 获取详细数据
     */
    fun getDetailed(imgRes: ImgRes):List<ImgRes>
}