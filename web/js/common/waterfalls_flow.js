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
    add: function (url, irType) {
        this.li = $("<li><img src='" + serviceUrl + url + "' onclick='imgOnclick(" + irType + ") '></li>");
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