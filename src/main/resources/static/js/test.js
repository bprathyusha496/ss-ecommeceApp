
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
	function formValidation(){

    var firstname=document.forms["regform"]["firstName"].value;
    var lastname=document.forms["regform"]["lastName"].value;
    var email=document.forms["regform"]["email"];
    var pwd=document.forms["regform"]["password"];
   
    var pattern =/^[A-Za-z]+$/;
   
    var mailformat =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var pwdpattern=/^[a-zA-Z0-9!@#\$%\^\&*_=+-]{6,12}$/g;
    if(!firstname.match(pattern) || (firstname=="")){
	//document.forms("firstnameError").innerHTML = "Not a valid e-mail address";
         alert("please fill the correct pattern of firstname");
        
         return false;
        }
     if(!lastname.match(pattern)||(lastName=="")){
        alert("please fill the correct pattern of lastname");
        return false;
    }
    if((!email.value.match(mailformat))|| email.value.length <= 0 ) {    
        alert("Please give me proper mail-id");     
        return false;
    }
    
   if(!pwd.value.match(pwdpattern)||(password=="")){

         alert("please fill the correct pattern of password")
         return false;

      }
      
    }
    function formValidation1(){
	
	var email=document.forms["regform"]["email"];
    var pwd=document.forms["regform"]["password"];
    
    var mailformat =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var pwdpattern=/^[a-zA-Z0-9!@#\$%\^\&*_=+-]{6,12}$/g;
    
     if((!email.value.match(mailformat))|| email.value.length <= 0 ) {    
        alert("Please give me proper mail-id");     
        return false;
    }
    
   if(!pwd.value.match(pwdpattern)||(password=="")){

         alert("please fill the correct pattern of password")
         return false;

      }
}
    
    
    
    
    /*function formValidation(){
	
	 var firstNamee=document.regform.firstName;
	
	var pattern =/^[A-Za-z]+$/;
	
	if(firstNamee.value.length==0){
         alert("please fill the correct pattern of firstName");
        
         return false;
        }
        else
        
        {
	true;

	}
	
	
	
/*function validateForm()
    {
    var firstName = checkfirstname();
    var email = checkEmail();
   
    
    
    // Validate the fill in of First Name
    function checkfirstname(){
    var firstName=document.forms["regform"]["firstName"].value;
    if (firstName==null || firstName=="")
    {
    document.getElementById("firstnameError").innerHTML = "Not a valid e-mail address";
    return false;
    }
    else{
    return true;
}

function checkEmail()
    {
    // code for email validation starts here
    var Email=document.forms["regform"]["email"].value;
    var atpos=Email.indexOf("@");
    var dotpos=Email.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=Email.length)
    {
    var error=document.forms["regform"]["emailError"].innerHtml="Not a valid e-mail address";
    return false;
    }
    else {
    return true;
    }
}
	}*/
    
    
    
    
    
    