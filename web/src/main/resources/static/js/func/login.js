$(
    function () {

        init();

        function init() {
            modalConentInit();
            addValidatorMethod();
            pageEventBind();

            var selectModel = 0;

            function modalConentInit() {
                $('#modal-message').text("注册成功!");
                ;
            }

            function pageEventBind() {
                $('#tri-login').click(function () {
                        if (selectModel == 1) {
                            $(this).parent().addClass('active');
                            $('#tri-register').parent().removeClass('active');
                            $('#login').addClass('active').addClass('in');
                            $('#register').removeClass('active').removeClass('in');
                            $('#login-email').focus();
                            selectModel = 0;
                        }
                    }
                );

                $('#tri-register').click(function () {
                        if (selectModel == 0) {
                            $(this).parent().addClass('active');
                            $('#tri-login').parent().removeClass('active');
                            $('#register').addClass('active').addClass('in');
                            $('#login').removeClass('active').removeClass('in');
                            $('#register-email').focus();
                            selectModel = 1;
                        }
                    }
                );

                $('#modal').on('hide.bs.modal', function () {
                    window.location.href = "question/list";
                });

                $("#register").validate({
                    submitHandler: function (form) {
                        $.post('userRegist', $('#register').serializeArray(), function (res) {
                            if (res.success == true) {
                                $('#modal').modal();
                                setTimeout(function () {
                                    $('#modal').modal('hide')
                                }, 1500);
                            } else {
                                var errorHtml = '<label id="register-email-error" class="error" for="register-email">用户名已存在!</label>';
                                $('#register-info').html(errorHtml).show();
                            }
                        });
                    },
                    rules: {
                        username: {
                            required: true,
                            rangelength: [6, 30],
                            usernameValidate: true
                        },
                        password: {
                            required: true,
                            rangelength: [6, 20]
                        },
                        apassword: {
                            required: true,
                            rangelength: [6, 20],
                            passwordValidate: true
                        }
                    },
                    messages: {
                        username: {
                            required: "请输入用户名",
                            rangelength: "请输入6到30位长度之间的用户名"
                        },
                        password: {
                            required: "请输入密码",
                            rangelength: "请输入6到20位长度之间的密码",
                        },
                        apassword: {
                            required: "请输入确认密码",
                            rangelength: "请输入6到20位长度之间的密码",
                        }
                    },
                    errorPlacement: function (error, element) {   // 错误信息位置设置方法
                        $('#register-info').html(error).show();
                    },
                    success: function (label) {
                        $('#register-info').hide();
                    }
                });

                $("#login").validate({
                    submitHandler: function (form) {
                        $.post('userLogin', $('#login').serializeArray(), function (res) {
                            if (res.success == true) {
                                window.location.href = "question/list";
                            } else {
                                var errorHtml = '<label id="register-email-error" class="error" for="register-email">用户名名或密码错误!</label>';
                                $('#login-info').html(errorHtml).show();
                            }
                        });
                    },
                    rules: {
                        username: {
                            required: true,
                            usernameValidate: true
                        },
                        password: {
                            required: true
                        }
                    },
                    messages: {
                        username: {
                            required: "请输入用户名"
                        },
                        password: {
                            required: "请输入密码"
                        }
                    },
                    errorPlacement: function (error, element) {   // 错误信息位置设置方法
                        $('#login-info').html(error).show();
                    },
                    success: function (label) {
                        $('#login-info').hide();
                    }
                });
            }

            function addValidatorMethod() {
                jQuery.validator.addMethod("passwordValidate", function (value, element, param) {
                    return this.optional(element) || (value == $('#register-password').val());
                }, $.validator.format("确认密码需与密码相同"));

                jQuery.validator.addMethod("usernameValidate", function (value, element, param) {
                    var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
                    return this.optional(element) || !pattern.test(value);
                }, $.validator.format("用户名不能包含中文字符"));
            }


        }


    }
);