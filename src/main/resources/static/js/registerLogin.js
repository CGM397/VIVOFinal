var confirmCode = "";
//test the correction of the format of the mail address
var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
var flag = false;

function sendMail() {
    confirmCode = "";
    if(flag){
        swal("获取验证码失败","获取频繁，请稍后再试","error");
        return;
    }
    var customerMail = document.getElementById("customerMail").value;
    if(customerMail === ""){
        alert("请输入您的邮箱!");
        return;
    }else if(!reg.test(customerMail)){
        alert("邮箱格式不正确，请重新输入!");
        return;
    }
    flag = true;
    $.ajax({
        type: "POST",
        url: "/registerLogin/sendMail",
        data: {
            customerMail : customerMail
        },
        success: function (result) {
            if(result.length === 6)
                confirmCode = result;
            else
                alert("该邮箱已被注册，请输入另一个邮箱!");
            flag = false;
        },
        error: function () {
            alert("sendMail : error!");
            flag = false;
        }
    });
}

function customerRegister() {
    var customerMail = document.getElementById("customerMail").value;
    var customerPassword = document.getElementById("customerPassword").value;
    var repeatPassword = document.getElementById("customerPasswordConfirm").value;
    var customerName = document.getElementById("customerName").value;
    var phoneNumber = document.getElementById("phoneNumber").value;

    if(customerMail === "" || customerPassword === "" || repeatPassword === "" ||
        customerName === "" || phoneNumber === ""){
        alert("请将注册信息填写完整!");
        return;
    }else if(customerPassword !== repeatPassword){
        alert("两次密码输入不一致!");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/registerLogin/customerRegister",
        data: {
            customerMail : customerMail,
            customerPassword : customerPassword,
            customerName : customerName,
            phoneNumber : phoneNumber
        },
        success: function (result) {
            if(result){
                swal({
                    title: "注册成功",
                    text: "欢迎使用本系统！",
                    type: "success"
                },function () {
                    window.location.href = "/login";
                });
            }
            else
                alert("注册失败!");
        },
        error: function () {
            alert("register : error!");
        }
    });
}

function restaurantRegister() {
    var restaurantName = document.getElementById("restaurantName").value;
    var restaurantPassword = document.getElementById("restaurantPassword").value;
    var passwordConfirm = document.getElementById("restaurantPasswordConfirm").value;

    if(restaurantName === "" || restaurantPassword === "" || passwordConfirm === "") {
        alert("请将注册信息填写完整!");
        return;
    }else if(restaurantPassword !== passwordConfirm) {
        alert("两次密码输入不一致!");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/registerLogin/restaurantRegister",
        data: {
            restaurantName : restaurantName,
            restaurantPassword : restaurantPassword
        },
        success: function (result) {
            if(result.length === 7){
                swal({
                    title: "注册成功",
                    text: "您的登录码: " + result,
                    type: "success"
                },function () {
                    window.location.href = "/login";
                });
            }
            else
                swal("注册失败", "注册失败！", "error");
        },
        error: function () {
            alert("register : error!");
        }
    });
}

function login() {
    var identityList = document.getElementById("selectList");
    var index = identityList.selectedIndex;
    var identity = identityList[index].text;
    if(identity === "请选择登录身份"){
        alert("请选择登录身份!");
        return;
    }
    var account = document.getElementById("customerMail").value;
    var password = document.getElementById("customerPassword").value;
    $.ajax({
        type: "POST",
        url: "/registerLogin/login",
        data: {
            identity : identity,
            account : account,
            password : password
        },
        success: function (result) {
            if(result === "success"){
                swal({
                    title: "登录成功",
                    text: "亲爱的用户，欢迎您！",
                    type: "success"
                },function () {
                    if(identity === "顾客"){
                        localStorage.setItem("customerMail", account);
                        alert("success");
                        //window.location.href = "/customer-home";
                    }else if(identity === "餐厅"){
                        localStorage.setItem("restaurantId", account);
                        alert("success");
                        //window.location.href = "/restaurant-home";
                    }else if(identity === "经理"){
                        alert("success");
                        //window.location.href = "/admin-checkModification";
                    }
                });
            }
            else if(result === "wrong_password")
                swal("登录失败", "账号或者密码错误！", "error");
            else if(result === "not_active")
                swal("登录失败", "账号已注销！", "error");
        },
        error: function () {
            alert("login : error!");
        }
    });
}

function logout() {
    $.ajax({
        type: "POST",
        url: "/registerLogin/logout",
        data: {},
        success: function (result) {
            if(result){
                swal({
                    title: "登出成功",
                    text: "欢迎再次使用本系统！",
                    type: "success"
                },function () {
                    window.location.href = "/login";
                });
            }else
                swal("登出失败", "登出失败！", "error");
        },
        error: function () {
            alert("login : error!");
        }
    });
}