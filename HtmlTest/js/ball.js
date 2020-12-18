var counter = 0;

function Enlarge(){
	

	var img = document.getElementById("football");
    var currWidth = img.clientWidth;
	if(counter == 5){
			img.style.width = "6%";
			counter = 0;
        } else{
            img.style.width = (currWidth + 10) + "px";
            counter++;
        }  
}

