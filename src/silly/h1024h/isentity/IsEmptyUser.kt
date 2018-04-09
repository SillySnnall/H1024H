package silly.h1024h.isentity

import silly.h1024h.entity.User

/**
 * User字段判空类
 */
object IsEmptyUser {

    fun isUser(user: User): String {
        if (user.getuName().isNullOrEmpty()) return "用户名为空"
        if (user.getuPassword().isNullOrEmpty()) return "密码为空"
        return ""
    }
}