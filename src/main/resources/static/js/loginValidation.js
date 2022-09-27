function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function validateFormforRegi()                                 
         { 
	        var firstname=document.forms["regform"]["firstName"];
	         var lastname=document.forms["regform"]["lastName"];
            var email=document.forms["regform"]["email"];
            var pwd=document.forms["regform"]["password"];
             
             
             if (firstname.value=="" ||firstname.value==null||(!firstname.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('errorregname').innerHTML="Please enter a valid Firstname";
                 document.getElementById('errorregname') .style.color="Red"; 
                 firstname.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorregname').innerHTML="";  
                 
             }
             
              if (lastname.value=="" ||lastname.value==null||(!lastname.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('errorregname1').innerHTML="Please enter a valid Lastname";
                 document.getElementById('errorregname1') .style.color="Red"; 
                 lastname.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorregname1').innerHTML="";  
                 
             }
             
             if (email.value=="" ||email.value==null||(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))){ 
                 document.getElementById('erroremail').innerHTML="Please enter ur valid email";
                 document.getElementById('erroremail') .style.color="Red"; 
                 email.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroremail').innerHTML="";  
                 
        }
        if (pwd.value=="" ||pwd.value==null||(!pwd.value.match(/^[a-zA-Z0-9!@#\$%\^\&*_=+-]{6,12}$/g))){ 
                 document.getElementById('errorpass').innerHTML="Please enter ur valid password";
                 document.getElementById('errorpass') .style.color="Red"; 
                 pwd.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorpass').innerHTML="";  
                 
        }     
        
      }
      function validateFormforlogin() {
	
	var email=document.forms["regform"]["email"];
            var pwd=document.forms["regform"]["password"];
	
      if (email.value=="" ||email.value==null){ 
                 document.getElementById('erroremail').innerHTML="Please enter ur valid email";
                 document.getElementById('erroremail') .style.color="Red"; 
                 email.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroremail').innerHTML="";  
                 
        }
        if (pwd.value=="" ||pwd.value==null){ 
                 document.getElementById('errorpass').innerHTML="Please enter ur valid email";
                 document.getElementById('errorpass') .style.color="Red"; 
                 pwd.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorpass').innerHTML="";  
                 
        }     
      }
      
      