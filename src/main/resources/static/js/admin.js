function validateForm1()                                 
         { 
	
             var namee = document.forms["myForm"]["name"];  
             
             if (namee.value=="" ||namee.value==null||(!namee.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('errorname').innerHTML="Please enter a valid category name";
                 document.getElementById('errorname') .style.color="Red"; 
                 namee.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorname').innerHTML="";  
                 
             }
         }
      /////////////////////////////////////////////////////////////////////////////   
    function validateFormforprod()                                 
         { 
	
             var namee = document.forms["myForm"]["name"]; 
             var pricee=document.forms["myForm"]["price"]; 
             var desc=document.forms["myForm"]["description"]
             
             if (namee.value=="" ||namee.value==null||(!namee.value.match(/^[a-zA-Z]+$/))){ 
                 document.getElementById('errorname').innerHTML="Please enter a valid product name";
                 document.getElementById('errorname') .style.color="Red"; 
                 namee.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorname').innerHTML="";  
                 
             }

             /*if (pricee.value==""||pricee.value==null||(!pricee.value.match([0-9]))){ 
                 document.getElementById('errorname1').innerHTML="Please enter a valid product price";
                 document.getElementById('errorname1') .style.color="Red"; 
                 pricee.focus(); 
                 return false; 
             }else{
                 document.getElementById('errorname1').innerHTML="";  
                 
             }*/
      
      if (desc.value=="" ||desc.value==null){ 
                 document.getElementById('errordescname').innerHTML="Please enter a product description";
                 document.getElementById('errordescname') .style.color="Red"; 
                 desc.focus(); 
                 return false; 
             }else{
                 document.getElementById('errordescname').innerHTML="";  
                 
             }
         }     
         
         