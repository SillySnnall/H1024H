package silly.h1024h.home.web.action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ModelDriven
import org.apache.commons.beanutils.BeanUtils
import silly.h1024h.base.BaseAction
import silly.h1024h.common.ErrorEnumMsg
import silly.h1024h.common.ErrorEnumParam
import silly.h1024h.entity.User
import silly.h1024h.home.service.RegisterService
import silly.h1024h.utils.Util
import silly.h1024h.isentity.IsEmptyUser

class RegisterAction : BaseAction(), ModelDriven<User> {
    private val registerService = RegisterService()
    val user = User()
    override fun getModel(): User {
        return user
    }

    fun doRegister(): String {
        // 判空
        val isUser = IsEmptyUser.isUser(user)
        if (!isUser.isEmpty()) {
            failData(ErrorEnumMsg.error1002, isUser)
            return Action.NONE
        }
        // 电话号码判断
        if(!Util.isPhone(user.getuName())){
            // 邮箱判断
            if(!Util.isEmail(user.getuName())){
                failData(ErrorEnumMsg.error1005, ErrorEnumParam.error1005)
                return Action.NONE
            }else{
                user.setuEmail(user.getuName())
            }
        }else{
            user.setuPhone(user.getuName())
        }
        // 用户已存在
        if (registerService.isUser(user)) {
            failData(ErrorEnumMsg.error1000, ErrorEnumParam.error1000)
            return Action.NONE
        }
        // 创建token和时间
        user.setuToken(Util.getUUID())
        user.setuCreateTime(Util.getCurrentDate())
        // 用户保存失败
        if (!registerService.saveUser(user)) {
            failData(ErrorEnumMsg.error1001, ErrorEnumParam.error1001)
            return Action.NONE
        }
        // 查找注册用户，返回数据
        val registerUser = registerService.getRegisterUser(user)
        val map = BeanUtils.describe(registerUser)// bean->List
        map.remove("uPassword")// 移除密码
        map.remove("uCreateTime")// 移除创建时间
        map.remove("class")// 移除map自带字段
        successData(map)
        return Action.NONE
    }
}
