function Submit() {
    console.log($('#user').val(),$('#password').val());

    var jsonData={
        "userId":4,
        "userName":$('#user').val(),
        "passWord":$('#password').val(),
        "realName":"d"
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8889/user/enterUser",
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function () {
            alert('Bingo!')
        },
        error: function () {
            alert("Bad！");
            submitted = false;
        }
    });
}


function Query() {
    console.log($('#userId').val());
    $.ajax({
        type: "GET",
        url: "http://localhost:8889/user/getUser/"+$('#userId').val(),
        success: function (data) {
            alert(data.userId+" "+data.userName +" "+data.passWord+" "+data.realName)
            alert("Bingo!")
        },
        error: function () {
            alert("Bad");
        }
    });

}

//注册功能测试时，需要改一下用户名（相同用户名不能再注册）
function SignUp() {
    console.log($('#userId').val());
    var jsonData={
        "userName":$('#user').val(),
        "passWord":$('#password').val(),
        "realName":$('#realName').val()
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8889/user/addUser",
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function () {
            alert("Bingo!")
        },
        error: function () {
            alert("Bad");
        }
    });

}