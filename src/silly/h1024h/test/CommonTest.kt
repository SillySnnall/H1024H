package silly.h1024h.test

import org.apache.commons.beanutils.BeanUtils
import org.testng.annotations.Test
import silly.h1024h.entity.ImgRes
import silly.h1024h.entity.User
import silly.h1024h.utils.*


//测试Hibernate框架
class CommonTest {
    @Test
    fun add() {
        for (i in 0..20) {
            val session = HibernateUtils.getCurrentSession()
            val tx = session.beginTransaction()
            //----------------------------------------------
//        val user = User(0, "hahaha", "123123", "万物", "lisi@163.com",
//                "110", 1, "male", "xxxxxxxx")
//        session.save(user)
            val imgRes = ImgRes("zxzxzxewewzxz$i", 1, 2)
            session.save(imgRes)
            //----------------------------------------------
            tx.commit()
            session.close()
        }
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
    fun limit() {
        val session = HibernateUtils.openSession()
        val query = session.createQuery("from ImgRes where irCover = ?").setParameter(0, 0)
        query.firstResult = 0
        query.maxResults = 1
        val list = query.list() as List<ImgRes>
        System.out.println(list)
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
    fun email() {
        val email = Util.isPhone("15432121421")
        System.out.println(email)
    }

    @Test
    fun sendSMS() {
        QqSmsUtil.sendSMS()
    }

    @Test
    fun sendEmail() {
        EmailUtil.sendCodeEmail("411600050@qq.com")
    }

    @Test
    fun jedis() {
        val ru = RedisUtil.getRu()
        ru.setex("qwe", "12312", 10)
        val get = ru.get("qwe")
        System.out.println(get)
    }
}
