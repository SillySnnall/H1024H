package silly.h1024h.dao

import org.hibernate.Session
import org.hibernate.Transaction
import silly.h1024h.base.BaseDao
import silly.h1024h.entity.ImgRes
import silly.h1024h.dao.impl.ImgResDaoImpl
import silly.h1024h.utils.HibernateUtils


class ImgResDao : BaseDao(), ImgResDaoImpl {
    override fun getIrTypeMax(): List<ImgRes> {
        val session = HibernateUtils.getCurrentSession()
        val beginTransaction = session.beginTransaction()
        return try {
            val list = session.createQuery("from ImgRes where irType=(select max(irType) from ImgRes)")
                    .list() as List<ImgRes>
            beginTransaction.commit()
            list
        } catch (e: Exception) {
            e.printStackTrace()
            beginTransaction.rollback()
            session.close()
            arrayListOf()
        }
    }


    override fun findByDetails(irDetails: String): List<ImgRes> {
        val session = HibernateUtils.getCurrentSession()
        val beginTransaction = session.beginTransaction()
        return try {
            val list = session.createQuery("from ImgRes where irDetails = ?")
                    .setParameter(0, irDetails)
                    .list() as List<ImgRes>
            beginTransaction.commit()
            list
        } catch (e: Exception) {
            e.printStackTrace()
            beginTransaction.rollback()
            session.close()
            arrayListOf()
        }
    }

    override fun findByIrCoverIrDetails(irCover: Int, irDetails: String): List<ImgRes> {
        val session = HibernateUtils.getCurrentSession()
        val beginTransaction = session.beginTransaction()
        return try {
            val list = session.createQuery("from ImgRes where irCover = ? and irDetails = ?")
                    .setParameter(0, irCover)
                    .setParameter(1, irDetails)
                    .list() as List<ImgRes>
            beginTransaction.commit()
            list
        } catch (e: Exception) {
            e.printStackTrace()
            beginTransaction.rollback()
            session.close()
            arrayListOf()
        }
    }

    override fun saveImg(imgResList: List<ImgRes>): Boolean {
        var session: Session? = null
        var beginTransaction: Transaction? = null
        return try {
            for (imgRes in imgResList) {
                session = HibernateUtils.getCurrentSession()
                beginTransaction = session.beginTransaction()
                session.save(imgRes)
                beginTransaction.commit()
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            beginTransaction?.rollback()
            session?.close()
            false
        }
    }

    override fun getCover(pageNum: Int, itemCount: Int): List<ImgRes> {
        return getSession().createQuery("from ImgRes where irCover = ?").setParameter(0, 1)
                .setFirstResult(pageNum)
                .setMaxResults(itemCount).list() as List<ImgRes>
    }

    override fun getDetailed(irType: Int, pageNum: Int, itemCount: Int): List<ImgRes> {
        return getSession().createQuery("from ImgRes where irType = ?").setParameter(0, irType)
                .setFirstResult(pageNum)
                .setMaxResults(itemCount).list() as List<ImgRes>
    }
}