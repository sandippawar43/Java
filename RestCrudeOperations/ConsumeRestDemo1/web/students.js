$(document).ready(function() {
    display();
    $("#btn").click(function() {
        addstudent();
    })
})

function display() {

    var url = "http://localhost:8085/REstDemo1/rest/student/list";
    $.get(url, function(resp) {

        $("#tbldata").empty();
        $.each(resp, function(i, d) {
            $("#tbldata").append("<tr><td>" + d.rno + "</td><td>" + d.name + "</td><td>" + d.address + "</td><td>" + d.mobile + "</td><td><a href='#' onclick='Edit(" + d.rno + ")'>Edit</a></td><td><a href='#' onclick='Delete(" + d.rno + ")'>Delete</a></td></tr>")

        })
    })



}

function addstudent() {
    var rno = $("#txtrno").val();
    var name = $("#txtname").val();
    var address = $("#txtaddress").val();
    var mobile = $("#txtmob").val();
    if ($("#btn").val() == "Submit")
    {
        var url = "http://localhost:8085/REstDemo1/rest/student/add/" + rno + "/" + name + "/" + address + "/" + mobile;
        $.get(url, function(resp) {

            if (resp == "1")
            {
                alert("Record inserted successfully");
                cleardata();
                display();
            }
            else
            {
                alert("Error ! ");

            }


        })
    }
    if ($("#btn").val() == "Save")
    {
        var url = "http://localhost:8085/REstDemo1/rest/student/edit/" + rno + "/" + name + "/" + address + "/" + mobile;
        $.get(url, function(resp) {

            if (resp == "1")
            {
                alert("Record Updated successfully");
                $("#btn").val("Submit");
                $("#txtrno").removeAttr("disabled");
                cleardata();
                display();
            }
            else
            {
                alert("Error ! ");

            }


        });
    }
}

function Edit(rno)
{
    var url = "http://localhost:8085/REstDemo1/rest/student/list/" + rno;

    $.getJSON(url, function(d) {
        // $.each(resp,function(i,d){
        $("#txtrno").val(d.rno);
        $("#txtrno").attr("disabled", "disabled");
        $("#txtname").val(d.name);
        $("#txtaddress").val(d.address);
        $("#txtmob").val(d.mobile);
        $("#btn").val("Save");
        //  })

    })

}
function Delete(rno)
{
    var url = "http://localhost:8085/REstDemo1/rest/student/delete/" + rno;
    $.get(url, function(resp) {

        if (resp == "1")
        {
            alert("Record Deleted successfully");
//$("#btn").val("Submit");
//$("#txtrno").removeAttr("disabled");
            cleardata();
            display();
        }
        else
        {
            alert("Error ! ");

        }
    })
}

function cleardata() {
    $("#txtrno").val("");
    $("#txtname").val("");
    $("#txtaddress").val("");
    $("#txtmob").val("");
}

