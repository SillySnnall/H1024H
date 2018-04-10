package silly.h1024h.home.service

import silly.h1024h.entity.ImgRes
import silly.h1024h.home.dao.ImgResDao
import silly.h1024h.home.service.impl.ImgResServiceImpl

class ImgResService : ImgResServiceImpl {
    private val imgResDao = ImgResDao()
    override fun getCover(imgRes: ImgRes): List<ImgRes> {
        try {
            imgResDao.getTransaction()
            val coverlist = imgResDao.getCover(imgRes.pageNum, imgRes.itemCount)
            imgResDao.commit()
            return coverlist
        } catch (e: Exception) {
            e.printStackTrace()
            imgResDao.rollBack()
        }
        return arrayListOf()
    }

    override fun getDetailed(imgRes: ImgRes): List<ImgRes> {
        try {
            imgResDao.getTransaction()
            val detailedList = imgResDao.getDetailed(imgRes.irType, imgRes.pageNum, imgRes.itemCount)
            imgResDao.commit()
            return detailedList
        } catch (e: Exception) {
            e.printStackTrace()
            imgResDao.rollBack()
        }
        return arrayListOf()
    }
}