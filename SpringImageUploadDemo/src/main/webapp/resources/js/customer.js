var bGender;
var imageFile;
var customerinfo = {
    init: function() { 
      //initial level functionality when load ...

    },
    save: function(path) { 
        //add fetch data from form and set to grid..button add/edit click
    	customerinfo.image();
    	customerinfo.set();
    },
    edit: function(ele) { 
        //grid edit buttion click event...and set data to form

    },
    
    remove: function(ele) {
        //delete data from grid ajax call
    },
    set: function() { 
        //set record to grid...
    	$.ajax({

			type : "GET",
			url : "view",
			success : function(data) {
				var obj=JSON.parse(data);
			$("#listOfCutomer").empty();
				var header="";
				var cutomerlist="";
				
				header = "<tr>";
				header += "<th colspan=7>Cutomer List </th>"
				header += "</tr>";
				header += "<tr>";
				header += "<th> Cutomer ID </th>";
				header += "<th> Cutomer Name </th>";
				header += "<th> Cutomer Gender </th>";
				header += "<th> Cutomer Document </th>";
				header += "<th> Cutomer Comment </th>";
				header += "<th> Cutomer Profile </th>";
			/*	header += "<th colspan=2>Operation</th>";*/
				
				$("#listOfCutomer").append(header);
				/*var path2=path+"/resources/Upload_Image";*/
				/*alert(path2);*/
				for(var i=0;i<obj.length;i++)
					{
					var tag="";
					cutomerlist = "<tr>";
					cutomerlist += "<td>" + obj[i].bId + "</td> ";
					cutomerlist += "<td>" + obj[i].bName + "</td> ";
					cutomerlist += "<td>" + obj[i].bGender + "</td> ";
					cutomerlist += "<td>" + obj[i].bDocument + "</td> ";
					cutomerlist += "<td>" + obj[i].bAdd + "</td> ";
					/*cutomerlist += "<td> <img src=/SpringImageUploadDemo/resources/Upload_Image/"+obj[i].buploadImage+"/></td> "; */
					cutomerlist += "<td> <img src="+appcontext+"/resources/Upload_Image/"+obj[i].buploadImage+"/></td> "; 
						//+obj[i].buploadImage+" /></td> ";
					/*cutomerlist += "<td>"+ <% out.write(request.getContextPath()); %>/resources/Upload_Image </td> ";
*/					/*cutomerlist += "<td>" + obj[i].buploadImage + "</td> ";*/
				/*	cutomerlist += "<td>" + "<a href=javascript:studentinfo.edit("
							+ obj[i].id + ")>Edit</a>" + "</td>";
					cutomerlist += "<td>" + "<a href=javascript:studentinfo.del("
							+ obj[i].id + ")>Delete</a>" + "</td>";*/
					cutomerlist += "</tr>";
					$("#listOfCutomer").append(cutomerlist);
					$("#listOfCutomer").append(tag);
					
					}
				
			}
    	});
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
    /* customerinfo.set(obj);*/
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
		    		/*alert(bGender);*/
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


