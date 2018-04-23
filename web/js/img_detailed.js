var serviceUrl = "http://localhost:8080";
$(document).ready(function () {

    // 屏幕滚动监听
    $(window).scroll(function () {
        // 滚动条到底部差200
        if ($(document).scrollTop() >= $(document).height() - $(window).height() - 200) {
            loadImg();
        }
    });
    // 屏幕滚动监听


    // 服务器获取详细图片
    var isRequest = true;
    var page = 0;

    function loadImg() {
        if (isRequest) {
            isRequest = false;
            var irType = window.location.search;
            irType = irType.substring(irType.indexOf("?") + 1, irType.length);
            var data = "irType=" + irType + "&pageNum=" + page + "&itemCount=15";
            var xhr = new XMLHttpRequest();
            xhr.open("POST", serviceUrl + "/getCoverImgDetailed", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  // 添加http头，发送信息至服务器时内容编码类型
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {  // 304未修改
                    var data = JSON.parse(xhr.responseText);
                    if (data.msg == 0) {
                        showCoverImg(data.data);
                        page += 15;
                        isRequest = true;
                    } else {
                        alert(data.param);
                    }
                }
                isRequest = true;
            };
            xhr.send(data);
        }
    }

    // 服务器获取图片

    function showCoverImg(data) {
        for (var i = 0; i < data.length; i++) {
            water.add(data[i].irUrl);
            water.li.find("img").load(function () {
                water.minTop().calc($(this).parent().outerHeight()).move($(this).parent());
            });
        }
    }


    var water = new Water(400);//li的宽度

    loadImg();
    $("button").click(function () {
        loadImg();
    });

    // 添加图片数据
    $(window).resize(function () {
        clearTimeout(water.timer);
        water.init();
        water.timer = setTimeout(function () {
            $("li").each(function (index) {
                water.minTop().calc($(this).outerHeight()).move($(this));
            });
        }, 50);
    });
});

// 详情图片点击事件
function imgOnclick(url) {
    $("#full_img").attr("src", url);
    $("#full_show_img").css('display', 'block');
}

// 关闭大图
function closeFullImg() {
    $("#full_show_img").css('display', 'none');
}

function Water(width) {
    this.wLi = width;
    this.init();
}

Water.prototype = {
    init: function () {
        this.nCol = Math.floor(window.innerWidth / this.wLi);
        this.wUl = this.nCol * this.wLi;
        this.aTop = [];
        this.index = 0;
        $("ul").css("width", this.wUl);
        return this;
    },
    add: function (url) {
        this.li = $("<li><img src='" + serviceUrl + url + "' onclick='imgOnclick(\"" + serviceUrl + url + "\") '></li>");
        $("ul").append(this.li);
        return this;
    },
    calc: function (height) {
        if (this.index < this.nCol) {
            this.aTop.push(height);
            this.top = 0;
            this.left = this.wLi * this.index;
        } else {
            this.aTop[this.col] += height;
            this.left = this.wLi * this.col;
        }
        this.index++;
        return this;
    },
    minTop: function () {
        this.col = 0;
        this.top = this.aTop[this.col];
        for (var i = 1; i < this.aTop.length; i++) {
            if (this.top > this.aTop[i]) {
                this.top = this.aTop[i]
                this.col = i;
            }
        }
        return this;
    },
    move: function (li) {
        li.animate({"left": this.left, "top": this.top, "opacity": 100}, 500);
        return this
    }
};


