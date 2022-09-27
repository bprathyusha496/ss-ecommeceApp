
function change( el )
{
    if ( el.value === "Open Curtain" )
        el.value = "Close Curtain";
    else
        el.value = "Open Curtain";
}

function validateFormforAddress()                                 
         { 
	
              var firstname=document.forms["regform1"]["firstName"];
	          var lastname=document.forms["regform1"]["lastName"];
	          var phone=document.forms["regform1"]["phoneNumber"];
              var email=document.forms["regform1"]["email"];
              var add=document.forms["regform1"]["Address"];
              var cardnumber=document.forms["regform1"]["cardNumber"];
              var MonthAndYear=document.forms["regform1"]["monthAndYear"];
              var cvvnum=document.forms["regform1"]["cvvCode"];
              var cardname=document.forms["regform1"]["cardName"];
              var amount=document.forms["regform1"]["total"];
             
             
            //  var total=parseFloat($("#total"));
              var pattern="(?:0[1-9]|1[0-2])/[0-9]{2}";
             
            if (firstname.value=="" ||firstname.value==null||(!firstname.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('erroraddname').innerHTML="Please enter a valid name";
                 document.getElementById('erroraddname') .style.color="Red"; 
                 firstname.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroraddname').innerHTML="";  
                 
             }
             
              if (lastname.value=="" ||lastname.value==null||(!lastname.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('erroraddname1').innerHTML="Please enter a valid name";
                 document.getElementById('erroraddname1') .style.color="Red"; 
                 lastname.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroraddname1').innerHTML="";  
                 
             }
            if(phone.value==""||phone.value.length!=10){
            document.getElementById('errorphn').innerHTML="Please enter valid Phonenumber";
            document.getElementById('errorphn').style.color="Red";
            phone.focus();
            return false;
            
        }
        else{
            document.getElementById('errorphn').innerHTML="";
        }
             
             if (email.value=="" ||email.value==null||(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))){ 
                 document.getElementById('erroremail1').innerHTML="Please enter ur valid email";
                 document.getElementById('erroremail1') .style.color="Red"; 
                 email.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroremail1').innerHTML="";  
                 
        }
        if (add.value=="" ||add.value==null){ 
                 document.getElementById('erroradd1').innerHTML="Please enter Address";
                 document.getElementById('erroradd1') .style.color="Red"; 
                 add.focus(); 
                 return false; 
             }else{
                 document.getElementById('erroradd1').innerHTML="";  
                 
             }
             
            if(cardnumber.value==""||cardnumber.value.length!=12){
            document.getElementById('errorcard').innerHTML="Please enter valid cardnumber";
            document.getElementById('errorcard').style.color="Red";
            cardnumber.focus();
            return false;
            
        }
        else{
            document.getElementById('errorcard').innerHTML="";
        }
        
        if (MonthAndYear.value=="" ||MonthAndYear.value==null ||(!MonthAndYear.value.match(pattern))){ 
                 document.getElementById('errordate').innerHTML="Please enter monthandyear";
                 document.getElementById('errordate') .style.color="Red"; 
                 MonthAndYear.focus(); 
                 return false; 
             }else{
                 document.getElementById('errordate').innerHTML="";  
                 
             }
        if (cvvnum.value==""||cvvnum.value.length!=3){ 
                 document.getElementById('errorcvv').innerHTML="Please enter cvv";
                 document.getElementById('errorcvv') .style.color="Red"; 
                 cvvnum.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorcvv').innerHTML="";  
                 
             }
        if (cardname.value=="" ||cardname.value==null||(!cardname.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('errorcardname').innerHTML="Please enter a valid name";
                 document.getElementById('errorcardname') .style.color="Red"; 
                 cardname.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorcardname').innerHTML="";  
                 
             }
             
        if (amount.value=="" ||amount.value==null || (!amount==total)){ 
         console.log(total);
                 document.getElementById('errortotal').innerHTML="Please enter a valid amount";
                 document.getElementById('errortotal') .style.color="Red"; 
                 amount.focus(); 
                 return false; 
             }else{
                 document.getElementById('errortotal').innerHTML="";  
                 
             }
             
        <h2>The window.print() Method</h2>
        }
            
            
            
     