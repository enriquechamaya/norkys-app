$(document).ready(function(){
    const isLogged =  $("#info-user span").html();
    if(isLogged === 'null'){
        $("#info-user").hide();
    }else{
        $("#info-user").show();
    }
});