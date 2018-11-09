// user
var userBoolean = false;
var passwordBoolean = false;
var parconfirmBoolean = false;
var emaileBoolean = false;
var mobileBoolean = false;
$(function () {
    $('#userName').blur(function () {
        var userName = $("#userName").val();
        if ((/^[a-z0-9_-]{6,14}$/).test($("#userName").val())) {
            $.ajax({
                url: '/checkYhMch.do',
                type: 'post',
                data: {
                    "userName": userName,
                },
                success: function (data) {
                    if (data == "yes") {
                        userBoolean = true;
                        $('#userNameTip').html("当前账号可以使用").css("color", "green");
                    } else {
                        $('#userNameTip').html("账号已存在").css("color", "red");
                        userBoolean = false;
                    }
                }
            })
        } else {
            $('#userNameTip').html("当前账号不符合规范").css("color", "red");
            userBoolean = false;
        }
    });
    // password
    $('#pwd').blur(function () {
        if ((/^[a-z0-9_-]{6,16}$/).test($("#pwd").val())) {
            $('#pwdTip').html("此密码可用").css("color", "green");
            passwordBoolean = true;
        } else {
            $('#pwdTip').html("请提高密码安全度").css("color", "red");
            passwordBoolean = false;
        }
    });


    // password_confirm
    $('#pwd2').blur(function () {
        if (($("#pwd").val()) == ($("#pwd2").val())) {
            $('#pwd2Tip').html("两次密码输入一致").css("color", "green");
            parconfirmBoolean = true;
        } else {
            $('#pwd2Tip').html("两次密码输不一致").css("color", "red");
            parconfirmBoolean = false;
        }
    });

    // Email
    $('#email').blur(function () {
        if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($("#email").val())) {
            $('#emailTip').html("✔").css("color", "green");
            emaileBoolean = true;
        } else {
            $('#emailTip').html("×").css("color", "red");
            emaileBoolean = false;
        }
    });

    // Mobile
    $('#mobile').blur(function () {
        if ((/^1[34578]\d{9}$/).test($("#mobile").val())) {
            $('#mobileTip').html("✔").css("color", "green");
            mobileBoolean = true;
        } else {
            $('#mobileTip').html("请输入正确手机号").css("color", "red");
            mobileBoolean = false;
        }
    });

    // click
    $('#subButton').click(function () {
        var isChecked = $("#ck").prop("checked");
        console.log(isChecked);
        if (userBoolean == true && passwordBoolean == true && parconfirmBoolean == true && emaileBoolean == true && mobileBoolean == true) {
            if (isChecked) {
                $("#registForm").submit();
            } else {
                $('#checkTip').html("请认真阅读用户注册协议").css("color", "red");
            }
        } else {
            alert("请完善信息");
        }
    })
})
