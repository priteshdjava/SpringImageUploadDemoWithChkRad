var bGender;
var imageFile;
var customerinfo = {
    init: function() { 
      //initial level functionality when load ...

    },
    save: function() { 
        //add fetch data from form and set to grid..button add/edit click
    	debugger;
    	
    	customerinfo.image();
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
	  
	  var files = [];
	  var form = $('#form')[0];
	  var oMyForm = new FormData(form);
      oMyForm.append("CustomField","This is some extra field");
     $
        .ajax({
        	/*dataType : 'json',*/
            url : "upload",
            data : oMyForm,
            type : "POST",
            enctype: 'multipart/form-data',
            cache: false,
          contentType: false,
            processData: false,
            
            success : function(result) {
            	imageFile=result;
            	var bDocument=new Array();
            	var bName=$("#bName").val();
            	var	bGender=customerinfo.radioval();
            	var  bDocument=customerinfo.checkboxval();
            	var bAdd=$("#bAdd").val();
            		
            	
            	/*var json=JSON.stringify(data);*/
            	$.ajax({
        			url : "save",
        			type : "POST",
        			enctype: 'multipart/form-data',
        			data :"bName=" + bName + "&bGender=" + bGender+ "&bDocument=" + bDocument + "&bAdd=" +bAdd+ "&imageFile="+imageFile,
        			success : function(data) {
        				alert("success");
        			}
        		});
            },
            
        });
     /*$("#form")[0].reset();*/
    
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


