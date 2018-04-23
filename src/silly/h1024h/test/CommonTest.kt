package silly.h1024h.test

import org.apache.commons.beanutils.BeanUtils
import org.testng.annotations.Test
import silly.h1024h.dao.ImgResDao
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
            val imgRes = ImgRes("zxzxzxewewzxz$i", 1, 2,"万物")
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
        val query = session.createQuery("select irUrl,irType,irDetails from ImgRes where irCover = ?").setParameter(0, 1)
        query.firstResult = 0
        query.maxResults = 15
        val list = query.list()
        for (listx in list){
            System.out.println(listx)
        }

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

    @Test
    fun saveImg(){
        val imgResDao = ImgResDao()
        val arrayListOf = arrayListOf<ImgRes>()
        arrayListOf.add(ImgRes("sasas",1,0,"212qwqw"))
        arrayListOf.add(ImgRes("434343",1,0,"212qwqw"))
        imgResDao.saveImg(arrayListOf)
    }

    @Test
    fun forTest(){
        for (i in 1..10){
            System.out.println(i)
        }
    }

    @Test
    fun to1(){
        System.out.println(doubleTo1("1"))
        System.out.println(doubleTo1("12"))
        System.out.println(doubleTo1("12."))
        System.out.println(doubleTo1("12.7"))
        System.out.println(doubleTo1("12.95"))
        System.out.println(doubleTo1("12.9596521"))
    }

    /**
     * 保留一位小数
     */
    fun doubleTo1(num: String): String {
        if (num.isEmpty()) {
            return ""
        }
        if (!num.contains(".")) {
            return "$num.0"
        }

        if (num.substring(num.indexOf("."), num.length).length > 2) {
            return num.substring(0, num.indexOf(".") + 2)
        }

        if (num.indexOf(".") == num.length - 1) {
            return num.substring(0, num.indexOf(".")) + ".0"
        }

        return num
    }

    @Test
    fun findIrDetils(){
        val findAllDetailsOnly = ImgResDao().findAllDetailsOnly()
        System.out.println(findAllDetailsOnly)
    }
}
