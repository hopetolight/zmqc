/**
 * 动态获取根目录路径
 * @author; ChenBo
 * @datetime: 2019/5/10:22:47
 */
const BASE_PATH = /*[[@{/}]]*/ '';
const CONTEXT_PATH = /*[[ ${#httpServletRequest.getContextPath()} ]]*/ '';


layui.config({
   base: BASE_PATH + '/static/common/lib/'
}).extend({
    treeSelect: 'treeSelect/treeSelect',
    xmSelect: 'xmSelect/xm-select',
    dtree: 'dtree/dtree',
    notice: 'layuinotice/notice'
});

layui.use(['notice'],function () {
    let notice = layui.notice;
    // 初始化配置，同一样式只需要配置一次，非必须初始化，有默认配置
    notice.options = {
        closeButton:true,//显示关闭按钮
        debug:false,//启用debug

        /* toast-top-center
            toast-bottom-center
            toast-top-full-width
            toast-bottom-full-width
            toast-top-left
            toast-top-right
            toast-bottom-right
            toast-bottom-left
        */
        positionClass:"toast-top-right",//弹出的位置,
        showDuration:"300",//显示的时间
        hideDuration:"1000",//消失的时间
        timeOut:"2000",//停留的时间
        extendedTimeOut:"1000",//控制时间
        showEasing:"swing",//显示时的动画缓冲方式
        hideEasing:"linear",//消失时的动画缓冲方式
        iconClass: 'toast-info', // 自定义图标，有内置，如不需要则传空 支持layui内置图标/自定义iconfont类名
        onclick: null, // 点击关闭回调
    };
});


/**
 * 时间格格式化
 * @author; ChenBo
 * @datetime: 2019/6/6
 */
Date.prototype.format = function (fmt) {
    let o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "H+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

const common = {
    /**
     * 获取输入框内字符个数 一个汉字，一个字母，一个字符都算一个计数
     */
    wordCount:function(value){
        //中文字数统计
        let  chinaCount = (value.replace(/[\u4e00-\u9fa5]/g,"")).length;
        //非汉字的个数
        let characterCount = value.length-chinaCount;
        return chinaCount + characterCount;
    }
};