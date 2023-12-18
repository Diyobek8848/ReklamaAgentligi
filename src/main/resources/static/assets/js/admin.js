$(document).ready(function (){
    $("#adminkirish").click(function (){
        if($("#password").val()!="" && $("#login").val()!=""){
            var logg={};
            logg.email=$("#login").val();
            logg.password=$("#password").val();
            var umumiy=JSON.stringify(logg)
            $.ajax({
                url: '/reklama/check',
                type: 'POST',
                data: umumiy,
                contentType: 'application/json;charset=utf-8',
                success: function (habar, ogoh, sts) {
                    if (sts.status == "200") {
                        alert(habar)
                        document.cookie = "Auth="+habar
                        window.location.href="/reklama/all"
                    }
                    if (sts.status == "208") {
                        alert("Response Error")
                    }
                },
                error: function (xato) {
                    alert("Ajax error")
                }
            })

        }
        else {
            alert("Maydonni to'ldiring")
        }

    })
})