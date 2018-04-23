package silly.h1024h.service

import silly.h1024h.entity.ImgRes
import silly.h1024h.dao.ImgResDao
import silly.h1024h.service.impl.ImgResServiceImpl

class ImgResService : ImgResServiceImpl {
    private val imgResDao = ImgResDao()
    override fun getCover(imgRes: ImgRes): List<ImgRes> {
        return imgResDao.getCover(imgRes.pageNum, imgRes.itemCount)
    }

    override fun getDetailed(imgRes: ImgRes): List<ImgRes> {
        return imgResDao.getDetailed(imgRes.irType, imgRes.pageNum, imgRes.itemCount)
    }
}