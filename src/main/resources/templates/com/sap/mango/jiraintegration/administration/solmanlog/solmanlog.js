function spGetLog() {
    $.get(AJS.params.baseURL + '/plugins/servlet/getLog', function(data,status) {
            console.log("data: ", data);
            console.log("status: ", status);

            document.getElementById('log-content').innerText = data;
        }
    )
}

AJS.$(document).ready(function () {
    spGetLog();
});