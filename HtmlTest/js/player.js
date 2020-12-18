// decides which player is playing
var p3 = 0;
var p2 = 0;
var p1 = 0;

// tells goal by each player
var gp3 = 0;
var gp2 = 0;
var gp1 = 0;




function Player1(){
	player1 = document.getElementById("player11");

	player1.style.backgroundColor = "red";
	player2.style.backgroundColor = "#e4f00a";	
	player3.style.backgroundColor = "#e4f00a";	
    p1 = 1;
    p2 = 0;
    p3 = 0;
}



function Player2(){
	player2 = document.getElementById("player22");

	player2.style.backgroundColor = "red";
	player1.style.backgroundColor = "#e4f00a";	
	player3.style.backgroundColor = "#e4f00a";	
    p2 = 1;
    p1 = 0;
    p3 = 0;
}


function Player3(){
	player3 = document.getElementById("player33");

	player3.style.backgroundColor = "red";
	player2.style.backgroundColor = "#e4f00a";	
	player1.style.backgroundColor = "#e4f00a";	
    p3 = 1;
    p2 = 0;
    p1 = 0;
}


function Goal(){
	if(p1 == 1){
		gp1++;
		document.getElementById("p1").innerHTML = gp1;
	}else if(p2 == 1){
		gp2++;
		document.getElementById("p2").innerHTML = gp2;
	}else if(p3 == 1){
		gp3++;
		document.getElementById("p3").innerHTML = gp3;
	}
}

function NameChange1(){
	var name = prompt("Enter a new Name for player","Player1");
	document.getElementById("name1").innerHTML = name;
}
function NameChange2(){
	var name = prompt("Enter a new Name for player","Player2");
	document.getElementById("name2").innerHTML = name;
}
function NameChange3(){
	var name = prompt("Enter a new Name for player","Player3");
	document.getElementById("name3").innerHTML = name;
}
