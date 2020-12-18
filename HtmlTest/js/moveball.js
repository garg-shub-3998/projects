document.onkeydown = detectKey;
function detectKey(e) {
    var posLeft = document.getElementById('football').offsetLeft;
    var posTop = document.getElementById('football').offsetTop;
    var posRight = document.getElementById('football').offsetRight;
    var posBottom = document.getElementById('football').offsetBottom;
    e = e || window.event;
    if (e.keyCode == '38') {
        // up arrow
        document.getElementById('football').style.marginTop  = (posTop-10)+"px";
    }
    else if (e.keyCode == '40') {
        // down arrow
        document.getElementById('football').style.marginTop  = (posTop+10)+"px";
    }
    else if (e.keyCode == '37') {
       // left arrow
        document.getElementById('football').style.marginLeft  = (posLeft-10)+"px";
    }
    else if (e.keyCode == '39') {
       // right arrow
        document.getElementById('football').style.marginLeft  = (posLeft+10)+"px";
    }
}