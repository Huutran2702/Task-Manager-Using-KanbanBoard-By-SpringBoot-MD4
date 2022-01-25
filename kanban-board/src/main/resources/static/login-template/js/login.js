class User {
    constructor(fullName,email, password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

}

$('#frm-login').validate({
        rules: {

            email: {
                required: true,
                minlength: 10,
                maxlength:30,
                email: true
            },
            password: {
                required: true,
                validatePassword:true

            }
        },

        messages: {

            email: {
                required: "* Email bắt buộc nhập",
                minlength: "* Email nhiều hơn hoặc bằng 10 ký tự",
                maxlength:"* Email tối đa 30 ký tự",
                email: "* Email không đúng định dạng"
            },
            password: {
                required: "* Password bắt buộc nhập",
            }
        }
    }

)

$.validator.addMethod("validatePassword", function (value, element) {
    return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
}, "Hãy nhập mật khẩu từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");

// Validate frontend form signup
$('#frm-signup').validate({
        rules: {
            fullName: {
                required: true,
                minlength: 2
            },

            email: {
                required: true,
                minlength: 10,
                maxlength:30,
                email: true
            },
            password: {
                required: true,
                validatePassword: true

            },
            re_password: {
                equalTo: "#passwordSignup"

            }
        },

        messages: {
            fullName: {
                required: "* User name bắt buộc nhập",
                minlength:"* User name nhiều hơn hoặc bằng 2 ký tự"
            },
            email: {
                required: "* Email bắt buộc nhập",
                minlength: "* Email nhiều hơn hoặc bằng 10 ký tự",
                maxlength:"* Email tối đa 30 ký tự",
                email: "* Email không đúng định dạng"
            },
            password: {
                required: "* Password bắt buộc nhập",
            },
            re_password: {
                equalTo: "* Re-password không khớp"

            }
        }
    }
)


$('.close').on('click',function () {
    $(this).parent().hide();
})
$(".messages-server").fadeTo(5000, 500).fadeOut(1000, function () {
    $(".messages-server").css("height", 0);
    $(".messages-server").empty();
});





