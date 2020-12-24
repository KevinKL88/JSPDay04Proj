let timer1;
/*$("#d_name").on("input",function () {
    if (timer1){
        clearTimeout(timer);
    }
    timer1 = setTimeout(function () {
        $.get("/checkDogName.do?dname=" + $("#d_name").val(), function (data) {
            $("#nameTips").html(data);
        });
    }, 1000);
})*/
function checkDogName(){
    var dname = $("#d_name").val();
    $.ajax({
        //目标url
        "url":"/checkDogName.do",
        //请求类型
        "type": "GET",
        //传递参数
        "data":"dname="+dname,
        //请求成功后的回调函数
        "success":function (data) {
            //console.log(typeof data);  //String
            //eval()方法，自动判断字符串类型并转换
            var flag = eval(data);
            //console.log(typeof flag);  //boolean
            if (flag){
                $("#nameTips").html("<p style='color: green'>name is available</p>");
            }else {
                $("#nameTips").html("<p style='color: red'>name already exists</p>");
            }
        }
    });
}