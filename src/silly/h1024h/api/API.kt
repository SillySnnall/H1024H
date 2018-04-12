package silly.h1024h.api

import org.testng.annotations.Test

object InterF {
    val interf = mapOf(
            "doRegister" to "注册",
            "doSendCode" to "发送验证码",
            "getCoverImg" to "获取封面图片",
            "getDetailed" to "获取这个封面中的详细图片"
    )
}
// 参数名 to 作用,是否必传,备注
object Param {
    val doRegister = mapOf(
            "uName" to "用户名,是,",
            "uPassword" to "密码,是,",
            "code" to "验证码,是,"
    )

    val doSendCode = mapOf(
            "uName" to "用户名,是,"
    )

    val getCoverImg = mapOf(
            "pageNum" to "页码,否,从0开始",
            "itemCount" to "条目数,否,从1开始"
    )

    val getDetailed = mapOf(
            "irType" to "封面标识,是",
            "pageNum" to "页码,否,从0开始",
            "itemCount" to "条目数,否,从1开始"
    )
}