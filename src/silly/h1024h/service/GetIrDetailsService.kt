package silly.h1024h.service

import silly.h1024h.dao.ImgResDao
import silly.h1024h.service.impl.GetIrDetailsServiceImpl


class GetIrDetailsService : GetIrDetailsServiceImpl {
    private val imgResDao = ImgResDao()
    override fun getIrDetails(): List<String> {
        return imgResDao.findAllDetailsOnly()
    }
}