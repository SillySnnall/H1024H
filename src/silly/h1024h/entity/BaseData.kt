package silly.h1024h.entity

data class SuccessData(var msg: Int, var param: String, var data: Map<String, Any>)
data class FailData(var msg: Int, var param: String)