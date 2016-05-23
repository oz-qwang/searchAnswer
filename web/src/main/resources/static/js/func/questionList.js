$(
    function () {

        init();

        function init() {
            eventBind();

            function eventBind() {
                $('#loadMore').click(function () {
                        var me = $(this);
                        $.post('findMoreQuestion', {pageNum: me.attr('data'), title: me.val()}, function (res) {
                            var source = Handlebars.compile($("#questionTemplate").html());
                            var html = source(res);
                            $('#water-fall').append(html);

                            if (res.hasMore) {
                                me.attr('data', res.nextPageNum);
                            } else {
                                me.hide();
                            }
                        });
                    }
                );
            }
        }
    }
);