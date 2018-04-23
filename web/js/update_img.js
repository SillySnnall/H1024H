$(document).ready(function () {
    var serviceUrl = "http://localhost:8080";
    var urlJson = "";// 图片集合json
    var irUrl = "";// 封面

    // 上传图片请求
    $("#file").change(function () {
        var fileName = $("#file").val();
        if (fileName == "") { //点击取消
            return;
        }
        getDetails();
        var formData = new FormData($("#uploadForm")[0]);
        $.ajax({
            type: "POST",
            data: formData,
            url: serviceUrl + "/updateImg",
            contentType: false,
            processData: false
        }).success(function (data) {
            console.log("成功");
            if (data.msg == 0) {
                $('#div_input').css('display', 'block');
                urlJson = JSON.stringify(data.data);
                showImg(data.data)
            } else {
                alert(data.param)
            }
        });
    });

    // 展示上传了的图片
    function showImg(imgList) {
        $("#main").empty();
        $("#selected_img").attr("src", "");
        irUrl = "";
        for (var i = 0; i < imgList.length; i++) {
            var imgUrl = serviceUrl + imgList[i];
            var $img = $('<img class="content_img" style="width: 300px;"/>');
            $img.attr("src", imgUrl);
            $img.click(function () {
                var src = this.getAttribute("src");
                $("#selected_img").attr("src", src);
                irUrl = src.replace(serviceUrl, "");
            });
            $img.appendTo($("#main"));
        }
    }

    // 清除图片封面
    $("#selected_img").click(function () {
        $("#selected_img").attr("src", "");
        irUrl = "";
    });

    // 屏幕变化调整布局
    $(window).resize(function () {
        var width = $(this).width();
        if (width <= 1366) {
            $("#main").css("-webkit-column-count", 3);
            $("#main").css("-moz-column-count", 3);
            $("#main").css("column-count", 3);
            $("#main").css("max-width", "852px");
            $(".content_img").css("width", 284);
        } else {
            $("#main").css("-webkit-column-count", 4);
            $("#main").css("-moz-column-count", 4);
            $("#main").css("column-count", 4);
            $("#main").css("max-width", "1200px");
            $(".content_img").css("width", 300);
        }
    });

    var isRequest = true;
    // 提交图片请求
    $("#commit").click(function () {
        if(isRequest){
            isRequest = false;
            var irDetails = $("#group_input").val();
            irDetails = $.trim(irDetails);
            if (irDetails == "") {
                alert("分组不能为空");
                return
            }
            if (urlJson == "") {
                alert("图片集合json不能为空");
                return
            }
            var data = "irDetails=" + irDetails + "&irUrl=" + irUrl + "&urlJson=" + urlJson;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", serviceUrl + "/commitImg", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // 添加http头，发送信息至服务器时内容编码类型
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {  // 304未修改
                    var data = JSON.parse(xhr.responseText);
                    if (data.msg == 0) {
                        alert(data.data)
                        // 清除图片封面
                        $("#selected_img").attr("src", "");
                        irUrl = "";
                        // 清除图片
                        $("#main").empty();
                        // 隐藏组类别
                        $('#div_input').css('display', 'none');
                    } else {
                        alert(data.param)
                    }
                }
                isRequest = true;
            };
            xhr.send(data);
        }
    });

    // 服务器获取组名
    function getDetails() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", serviceUrl + "/getIrDetails", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // 添加http头，发送信息至服务器时内容编码类型
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {  // 304未修改
                var data = JSON.parse(xhr.responseText);
                if (data.msg == 0) {
                    showGroup(data.data)
                } else {
                    alert(data.param)
                }
            }
        };
        xhr.send();
    }


    var colorArr = ["#ed5565", "#ffce54", "#a0d468", "#fc6e51", "#48cfad", "#4fc1e9", "#ac92ec", "#5d9cec"];

    // 显示已经存在的组名
    function showGroup(groupData) {
        // 清除组名
        $("#group_content").empty();
        for (var i = 0; i < groupData.length; i++) {
            var $span = $('<span>' + groupData[i] + '&nbsp;</span>');
            $span.css("color", colorArr[i % 8]);
            $span.click(function () {
                var innerText = this.innerText;
                $("#group_input").attr("value", innerText);
            });
            $span.appendTo($("#group_content"));
        }
    }
});