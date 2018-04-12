package silly.h1024h.web

import org.apache.commons.fileupload.FileUploadException
import org.apache.commons.fileupload.disk.DiskFileItemFactory
import org.apache.commons.fileupload.servlet.ServletFileUpload
import org.apache.commons.io.IOUtils
import silly.h1024h.base.BaseServlet
import silly.h1024h.entity.User
import java.io.File
import java.io.FileOutputStream

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "UpdateImgServlet", urlPatterns = ["/updateImg"])
class UpdateImgServlet : BaseServlet<Any>() {
    override fun getModel(): Any? {
        return null
    }

    /**
     * 上传图片
     */
    override fun doWork(request: HttpServletRequest, response: HttpServletResponse, model: Any?) {
        try {
            //1、创建磁盘文件项工厂
            //作用：设置缓存文件的大小  设置临时文件存储的位置
            val path_temp = this.servletContext.getRealPath("temp")
            //DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, new File(path_temp));
            val factory = DiskFileItemFactory()
            factory.sizeThreshold = 1024 * 1024
            factory.repository = File(path_temp)
            //2、创建文件上传的核心类
            val upload = ServletFileUpload(factory)
            //设置上传文件的名称的编码
            upload.headerEncoding = "UTF-8"

            //ServletFileUpload的API
            val multipartContent = ServletFileUpload.isMultipartContent(request)//判断表单是否是文件上传的表单
            if (multipartContent) {
                //是文件上传的表单
                //***解析request获得文件项集合
                val parseRequest = upload.parseRequest(request)
                if (parseRequest != null) {
                    for (item in parseRequest) {
                        //判断是不是一个普通表单项
                        val formField = item.isFormField
                        if (formField) {
                            //username=zhangsan
                            val fieldName = item.fieldName
                            val fieldValue = item.getString("UTF-8")//对普通表单项的内容进行编码

                            println("$fieldName----$fieldValue")

                            //当表单是enctype="multipart/form-data"时 request.getParameter相关的方法
                            //String parameter = request.getParameter("username");

                        } else {
                            //文件上传项
                            //文件的名
                            val fileName = item.name
                            //获得上传文件的内容
                            val fis = item.inputStream
                            val path_store = this.servletContext.getRealPath("upload")
                            val file = File(path_store)
                            if (!file.exists()) {
                                file.mkdirs()
                            }
                            val out = FileOutputStream("$path_store/$fileName")
                            IOUtils.copy(fis, out)
                            fis.close()
                            out.close()

                            //删除临时文件
                            item.delete()

                        }
                    }
                }

            } else {
                //不是文件上传表单
                //使用原始的表单数据的获得方式 request.getParameter();
            }
        } catch (e: FileUploadException) {
            e.printStackTrace()
        }

    }
}
