$(
    function () {
        init();

        function init() {
            eventBind();
            uploaderInit();

            function uploaderInit() {

                var target = $("#target");
                var avatarUpload = $('#avatarUpload');
                var settings = {
                    'auto': true,
                    'multi': false,
                    'uploadLimit': 1,
                    'buttonText': '上传图片',
                    'height': 32,
                    'width': 100,
                    'removeCompleted': true,
                    'swf': '/searchAnswer/js/build/uploadify.swf',
                    'uploader': 'modifyUserMoidfyHeader',
                    'fileTypeExts': '*.gif; *.jpg; *.jpeg; *.png;',
                    'fileDesc': 'Web Image Files(.JPG,.GIF,.PNG)',
                    'fileSizeLimit': '2048KB',
                    fileObjName: 'file',
                    'folder': '/searchAnswer/uploads',
                    'onUploadSuccess': function (file, data, response) {
                        var msg = $.parseJSON(data);
                        // avatarUpload.uploadify(settings);
                        if (msg.success == true) {
                            $('#avatar').attr("src", "/searchAnswer" + msg.data);
                            target.attr("src", "/searchAnswer" + msg.data);
                            target.parent().show();

                            avatarUpload.uploadify('destroy');
                            avatarUpload.uploadify(settings);

                            showMsgTip("修改头像成功");

                        } else {
                            showMsgTip("修改头像失败");
                        }
                    }
                };
                avatarUpload.uploadify(settings);
            }

            function eventBind() {

                $('#modal').modal({
                    show: false
                });

                $(document).on('click', '#avatarUpload', function () {
                    $('#uploadImg').click();
                });

                $(document).on('change', '#uploadImg', function (res) {

                });
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
