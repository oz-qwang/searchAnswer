$(
    function () {
        init();

        function init() {
            eventBind();

            function eventBind() {
                $('#commentAnswer').click(function () {
                        var me = $(this)
                        $.post('../questionAnswer/comment', {
                            answer: $('#input-comment').val(),
                            questionId: me.attr('data')
                        }, function (res) {
                            if (res.success) {
                                var source = Handlebars.compile($("#questionAnswerTemplate").html());
                                var html = source(res.data);
                                $(html).insertBefore($('#comments li:first'));

                                showMsgTip("回复成功");
                                $('#input-comment').val("");
                            }
                        });
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