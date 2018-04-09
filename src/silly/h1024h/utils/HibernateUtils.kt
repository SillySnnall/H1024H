package silly.h1024h.utils

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

object HibernateUtils {
    private var sf: SessionFactory? = null

    init {
        //1 创建,调用空参构造
        val conf = Configuration().configure()
        //2 根据配置信息,创建 SessionFactory对象
        sf = conf.buildSessionFactory()
    }

    //获得session => 获得全新session
    fun openSession(): Session {
        //3 获得session
        return sf!!.openSession()
    }
    //获得session => 获得全新session
    fun getCurrentSession(): Session {
        //3 获得session
        return sf!!.currentSession
    }

    // SessionFactory对象
    fun getSessionFactory():SessionFactory{
        return sf!!
    }
}
