package silly.h1024h.test

import org.apache.commons.beanutils.BeanUtils
import org.testng.annotations.Test
import silly.h1024h.entity.User
import silly.h1024h.utils.HibernateUtils
import silly.h1024h.utils.Util

//测试Hibernate框架
class HibernateTest {
    @Test
    fun add() {
        val session = HibernateUtils.getCurrentSession()
        val tx = session.beginTransaction()
        //----------------------------------------------
        val user = User(0, "hahaha", "123123", "万物", "lisi@163.com",
                "110", 1, "male", "xxxxxxxx")
        session.save(user)
        //----------------------------------------------
        tx.commit()
        session.close()
    }

    @Test
    fun delete() {
        val session = HibernateUtils.openSession()
        val tx = session.beginTransaction()
        //----------------------------------------------
        val user = User(101, "lisi", "123123", "万物", 13, "lisi@163.com",
                "110", 1, "male", "xxxxxxxx")
        session.delete(user)
        //----------------------------------------------
        tx.commit()
        session.close()
    }

    @Test
    fun find() {
        val session = HibernateUtils.openSession()
        val query = session.createQuery("from User where uName = ?").setParameter(0, "xxxxxxlisi").list() as List<User>
        System.out.println(query)
    }

    @Test
    fun UUID() {
        val randomUUID = java.util.UUID.randomUUID().toString().replace("-", "")
        System.out.println(randomUUID)
    }

    @Test
    fun beanToMap() {
        val user = User()
        user.setuName("1231")
        user.setuEmail("010122919")
        val map = BeanUtils.describe(user)// bean->List
        System.out.println(map)
    }

    @Test
    fun email(){
        val email = Util.isPhone("15432121421")
        System.out.println(email)
    }
}
