package silly.h1024h.utils

import java.util.*
import java.util.regex.Pattern

object Util {
    /**
     * 获取UUID
     */
    fun getUUID(): String {
        return java.util.UUID.randomUUID().toString().replace("-", "")
    }

    /**
     * 获取当前时间yyyy-mm--dd
     */
    fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        return "${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH) + 1}-${calendar.get(Calendar.DATE)}"
    }

    /**
     * 是否是电话号码
     */
    fun isPhone(phone: String): Boolean {
        val pattern = "^134[0-8]\\d{7}\$|^13[^4]\\d{8}\$|^14[5-9]\\d{8}\$|^15[^4]\\d{8}\$|^16[6]\\d{8}\$|^17[0-8]\\d{8}\$|^18[\\d]{9}\$|^19[8,9]\\d{8}\$"
        return Pattern.matches(pattern, phone)
    }

    /**
     * 是否是邮箱
     */
    fun isEmail(email: String): Boolean {
        val pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
        return Pattern.matches(pattern, email)
    }
}