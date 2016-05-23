$(
    function () {

        init();

        function init() {
            eventBind();
            
            function eventBind() {
                
                $('#modal').modal({
                    show: false
                });

                $('#modifyEnterBtn').click(function () {

                    if ($("#password-current").val() == "") {
                        showMsgTip("请输入原密码");
                    } else if ($("#password-new").val() == "") {
                        showMsgTip("请输入新密码");
                    } else if ($("#password-repeat").val() == "") {
                        showMsgTip("请输入确认密码");
                    } else if ($('#password-new').val() != $('#password-repeat').val()) {
                        showMsgTip("确认密码不一致");
                    } else {
                        $.post('moidfyPassword', $('#modifyPasswordForm').serializeArray(), function (res) {
                            if (res.success == true) {
                                showMsgTip(res.data, function () {
                                    location.href = "userMain";
                                });
                            } else {
                                showMsgTip(res.data);

                            }
                        });

                    }
                });
            }
        }

        function setModalMessage(msg) {
            $('#modal-message').text(msg);
        }

        function showMsgTip(msg, callback) {
            setModalMessage(msg);
            $('#modal').modal('show');

            setTimeout(function () {
                $('#modal').modal('hide');
                if (callback) {
                    callback();
                }
            }, 1500);

        }
    }
);