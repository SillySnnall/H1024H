package silly.h1024h.home.dao

import silly.h1024h.base.BaseDao
import silly.h1024h.entity.ImgRes
import silly.h1024h.home.dao.impl.ImgResDaoImpl


class ImgResDao : BaseDao(), ImgResDaoImpl {
    override fun getCover(pageNum:Int,itemCount:Int): List<ImgRes> {
       return  getSession().createQuery("from ImgRes where irCover = ?").setParameter(0, 1)
               .setFirstResult(pageNum)
               .setMaxResults(itemCount).list() as List<ImgRes>
    }

    override fun getDetailed(irType:Int,pageNum:Int,itemCount:Int): List<ImgRes> {
        return  getSession().createQuery("from ImgRes where irType = ?").setParameter(0, irType)
                .setFirstResult(pageNum)
                .setMaxResults(itemCount).list() as List<ImgRes>
    }

}