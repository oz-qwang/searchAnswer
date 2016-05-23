$(
    function () {
        init();

        function init() {
            eventBind();

            function eventBind() {
                $('#publishBtn').click(function () {
                        var content = $('#content').val();
                        var title = $('#title').val();
                        if (title.trim().length == 0) {
                            showMsgTip("请填写标题");
                        } else if (title.length > 200) {
                            showMsgTip("标题长度不能超过200");
                        } else if (content.trim().length == 0) {
                            showMsgTip("请填写内容");
                        } else if (content.length > 2000) {
                            showMsgTip("内容长度不能超过2000");
                        } else {
                            $.post('publish', $('#publishForm').serializeArray(), function (res) {
                                if (res.success == true) {
                                    showMsgTip("发布成功", function () {
                                        location.href = "list";
                                    });
                                } else {
                                    showMsgTip("发布失败");
                                }
                            });
                        }

                    }
                );
            }
        }

        function showMsgTip(msg, callback) {
            $('#modal-message').text(msg);
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