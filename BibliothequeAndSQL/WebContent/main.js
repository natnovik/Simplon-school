/*function sayHello(name){
    alert('hello : ' + name);
}
sayHello('Welcome to my first dynamic page'); */


/* --------------------------------VALIDATION--------------------------*/
   function validate()
    {
        let fName = document.myForm.fname.value;
        let fSurname = document.myForm.lname.value;
        
        if(fname=="" && lname=="")
        {
            alert("First and last name cannot be emtpy");
            return false;
        }
    }

/* --------------------------------OPEN POP UP WINDOW------------------*/
document.getElementById(`popupFind`).addEventListener("click", function(){
	document.querySelector(".formFind").style.display="flex";
});

document.getElementById(`popupCreate`).addEventListener("click", function(){
	document.querySelector(".formCreate").style.display="flex";
});

document.getElementById(`popupModify`).addEventListener("click", function(){
	document.querySelector(".formModify").style.display="flex";
});

/* --------------------------------CLOSE POP UP WINDOW------------------*/
document.querySelector(".closeFind").addEventListener("click", function(){
		document.querySelector(".formFind").style.display="none"
});

document.querySelector(".closeCreate").addEventListener("click", function(){	
		document.querySelector(".formCreate").style.display="none"
});
document.querySelector(".closeModify").addEventListener("click", function(){
		document.querySelector(".formModify").style.display="none"	
});

let note =document.getElementById(`note`);

	 document.getElementById(`popupFind`).addEventListener("onmouseover", function(){
		if(note.style.visibility == 'hidden'){
			note.style.visibility = 'visible';
		
		}else{
			note.style.visibility == 'hidden';
		}	
	});

/*
document.querySelector(".bi-x-circle-fill").addEventListener("click", function(){
	if(document.querySelector(".formFind").style.display="flex"){
		document.querySelector(".formFind").style.display="none";	
		
	}else if (document.querySelector(".formCreate").style.display="flex"){
		(document.querySelector(".formCreate").style.display="none");
		
	}else{
		document.querySelector(".formModify").style.display="none";
	}	
});*/

