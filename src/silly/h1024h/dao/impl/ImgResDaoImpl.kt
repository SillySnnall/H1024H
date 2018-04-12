package silly.h1024h.dao.impl

import silly.h1024h.entity.ImgRes

interface ImgResDaoImpl{
    /**
     * irCover分页查找
     */
    fun getCover(pageNum:Int,itemCount:Int):List<ImgRes>

    /**
     * irType分页查找
     */
    fun getDetailed(irType:Int,pageNum:Int,itemCount:Int): List<ImgRes>
}