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
				customerinfo.showtable(obj);
			}
    	});
    },
    get: function(bId) { 
        //get record from grid...[ele means its delete or edit cell..]
    	debugger;
    	$
		.ajax({

			type : "POST",
			url : "get",
			data : "id=" + bId,
			success : function(data) {
				var obj = JSON.parse(data);
				/*alert(obj);*/
				alert(obj.bDocument);
				var button = "";
				/*alert("success");*/
			/*	alert(obj.bName);*/
				/*alert(obj.bGender);*/
				$("#bId").val(obj.bId);
				$("#bName").val(obj.bName);
				
				if(obj.bGender == 'Male'){
				$("#bGender1").val(obj.bGender).prop("checked",true);
				}else { 
					$("#bGender2").val(obj.bGender).prop("checked",true);  
					
				}
				var document=[];
				var str=obj.bDocument;
				document=str.split(",");
				/*alert(document);*/
				if(document[0] == 'Aadhar Card')
					{
							$("#bDocument1").val(document[0]).prop("checked",true);
					}if(document[1] == 'PAN Card')
						{
							$("#bDocument2").val(document[1]).prop("checked",true);
						}
					if((document[2] == 'Election Card'))
						{
							$("#bDocument3").val(document[2]).prop("checked",true);
						}
					alert(obj.buploadImage);
				$("#filed").val(obj.buploadImage);
				$("#bAdd").val(obj.bAdd);
				button = "<tr>";
				button += "<td align=justify><input type=button id=button2 value=Edit  onclick=studentinfo.saveEdit()></td>";
				button += "</tr>";
				$("#button").replaceWith(button);

			}
		});
    	
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
    		return bGender;
    	}
    	else if(document.getElementById("bGender2").checked)
    		{
		    		bGender=$("#bGender2").val();
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
    },
    showtable:function(obj)
    {
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
		header += "<th colspan=2>Operation</th>";
		
		$("#listOfCutomer").append(header);
		for(var i=0;i<obj.length;i++)
			{
			var tag="";
			cutomerlist = "<tr>";
			cutomerlist += "<td>" + obj[i].bId + "</td> ";
			cutomerlist += "<td>" + obj[i].bName + "</td> ";
			cutomerlist += "<td>" + obj[i].bGender + "</td> ";
			cutomerlist += "<td>" + obj[i].bDocument + "</td> ";
			cutomerlist += "<td>" + obj[i].bAdd + "</td> ";
			cutomerlist += "<td> <img src="+appcontext+"/resources/Upload_Image/"+obj[i].buploadImage+" height=42 width=42/></td> "; 
			cutomerlist += "<td>" + "<a href=javascript:customerinfo.get("
			+ obj[i].bId + ")>Edit</a>" + "</td>";
			cutomerlist += "<td>" + "<a href=javascript:customerinfo.get("
			+ obj[i].bId + ")>Delete</a>" + "</td>";
			cutomerlist += "</tr>";
			$("#listOfCutomer").append(cutomerlist);
			$("#listOfCutomer").append(tag);
			
			}
    	}
}

