var bGender;
var customerinfo = {
    init: function() { 
      //initial level functionality when load ...

    },
    save: function() { 
        //add fetch data from form and set to grid..button add/edit click
    	var bDocument=new Array();
    /*	debugger;*/
    	/* $("input[type='button']").click(function(){
    		 bGender= $("input[name='bGender']:checked").val();
    		 alert("you are a :  ----"+bGender);
    	 }); 
    	  $("#button").click(function(){
    	    	var bDocument=[];
    	    	
    	        $.each($("input[name='bDocument']:checked"), function(){            
    	        	bDocument.push($(this).val());
    	        	
    	        });
    	        alert("My favourite sports are: " + bDocument.join(", "));
    	    });*/
    	var bName=$("#bName").val();
    	var	bGender=customerinfo.radioval();
    	var  bDocument=customerinfo.checkboxval();
    	var bAdd=$("#bAdd").val();
    	
    	$.ajax({
			type : "POST",
			url : "save",
			data : "bName=" + bName + "&bGender=" + bGender+ "&bDocument=" + bDocument + "&bAdd=" +bAdd,
			success : function(data) {
				alert("success");
			}
		});
    	
    },
    edit: function(ele) { 
        //grid edit buttion click event...and set data to form

    },
    
    remove: function(ele) {
        //delete data from grid ajax call
    },
    set: function(obj) { 
        //set record to grid...

    },
    get: function(ele) { 
        //get record from grid...[ele means its delete or edit cell..]
    },
    clear: function(ele) { //reset form data
       
    },
   
    gather: function() {
        //gathere return object when need
        
    },
    populate: function(objVal) {
        //its show data grid data
    },
  image: function() {
      //image upload  
	  debugger;
	  var path=$('input[type=file]').val();
	  var form = document.forms[0];
	 /* var file = $('[name="file"]');*/
	  var formdata=new FormData();
	  formdata.append("file",file.files[0]);
	  alert(file);
	  
	  $.ajax({
          url: 'upload',
          type: "POST",
          data: "path=" +path,
          enctype: 'multipart/form-data',
          success:function(data)
          {
        	  alert(success);
          }
          
	  });
	  
    },
    radioval:function()
    {
    	if(document.getElementById("bGender1").checked)
    	{
    		bGender=$("#bGender1").val();
    		/*alert(bGender);*/
    		return bGender;
    	}
    	else if(document.getElementById("bGender2").checked)
    		{
		    		bGender=$("#bGender2").val();
		    		alert(bGender);
		    		return bGender;
    		}
    },
    checkboxval:function()
    {
    	var checkbox=document.getElementsByName("bDocument");
    	var len=checkbox.length;
    	/*alert(len);*/
    	var bDocument=[];
    	for(var i=0;i<len;i++)
    		{
    				if(checkbox[i].checked)
    					{
    						/*alert($(checkbox[i]).val());*/
    						bDocument.push($(checkbox[i]).val());
    						
    					}
    		}
    	return bDocument;	
    }
    
    
    
}

