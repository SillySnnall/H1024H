package silly.h1024h.base

import org.hibernate.Session
import org.hibernate.Transaction
import silly.h1024h.utils.HibernateUtils

open class BaseDao {

    private var session: Session? = null
    private var transaction: Transaction? = null

    init {

    }

    /**
     * 提交事物（如果使用的是getTransaction，则提交并关闭事物）
     */
    fun commit() {
        //提交事务
        transaction?.commit()
    }

    /**
     * 事物回滚
     */
    fun rollBack() {
        transaction?.rollback()
    }

    /**
     * 获取Session
     */
    fun getSession(): Session {
        session = HibernateUtils.getCurrentSession()
        return session!!
    }

    /**
     * 获取Transaction开启事务
     */
    fun getTransaction(): Transaction {
        session = HibernateUtils.getCurrentSession()
        transaction = session?.beginTransaction()
        return transaction!!
    }
}