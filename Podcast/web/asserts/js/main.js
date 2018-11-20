

var status = 0;
function Play(music,id) {
    var audio = $("#"+id);
    if(status == 0 || status == 2)
    {
        if(status == 0) audio.attr("src", music);
        audio[0].play();
        $("#play").attr("class","glyphicon glyphicon-pause aligned")
        status = 1;
    } else if(status == 1) {
        audio[0].pause();
        $("#play").attr("class","glyphicon glyphicon-play aligned")
        status = 2;
    }
}
function Stop(music,id) {
    var audio = $("#"+id);
    audio.attr("src", '');
    $("#play").attr("class","glyphicon glyphicon-play aligned")
    status = 0;
}
function Restart(music,id) {
    var audio = $("#"+id);
    audio.prop("currentTime",0)
}
function VolumeUp(music,id) {
    var audio = $("#"+id);
    var volume = $("#"+id).prop("volume")+0.1;
    if(volume > 1) volume = 1;
    $("#"+id).prop("volume",volume);
}
function VolumeDown(music,id) {
    var audio = $("#"+id);
    var volume = $("#"+id).prop("volume")-0.1;
    if(volume < 0) volume = 0;
    $("#"+id).prop("volume",volume);
}
function Forward5(music,id) {
    var audio = $("#"+id);
    audio.prop("currentTime",audio.prop("currentTime")+5);
}
function Backward5(music,id) {
    var audio = $("#"+id);
    audio.prop("currentTime",audio.prop("currentTime")-5);
}
function Forward1(music,id) {
    var audio = $("#"+id);
    audio.prop("currentTime",audio.prop("currentTime")+1);
}
function Backward1(music,id) {
    var audio = $("#"+id);
    audio.prop("currentTime",audio.prop("currentTime")-1);
}
