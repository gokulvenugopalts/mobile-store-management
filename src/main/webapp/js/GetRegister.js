/**
 * 
 */
function getRegisterList(place)
{
	/*var url = 'ViewRegisterController';
	var val=document.getElementById("searchnamestyle").value;
	var param = "CountryStyle="+val;
		if(window.XMLHttpRequest)
		{
			xmlHttp = new XMLHttpRequest();
		}
		else if(window.ActiveXObject)
		{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.open("POST", 'ViewRegisterController', true);
		xmlHttp.send(param);
	xmlHttp.onreadystatechange = function()
	{
		
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
		{
			var l =document.getElementById("CountryStyle").options.length;
			for(i=0;i<l;i++)
				{
				documentgetElementById("CountryStyle").remove(0);
				}
			 document.getElementById("CountryDropStyle").innerHTML=""; 
			var res = xmlHttp.responseText;
			var data = res.split("-");
			var arr;
			var opt;
			opt = document.createElement("OPTION");
			for(i = 0;i<data.length-1;i++)
			{
				arr = data[i];
				 opt = new Option(arr);
				document.getElementByid("CountryDropStyle").options.add(opt); 
				opt = document.createElement("OPTION");
				opt.text = arr;
				document.getElementById("CountryStyle").options.add(opt);
			}
		}
	}
		
	
	 xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
	var res = xmlHttp.responseText;*/
	
	var url = document.getElementById("searchstyle");
	if(url == "Search by unique name and cost")
	{
		
	}
	else if(url == "Search by Cost")
	{
		
	}
	else if(url == "Search by name")
	{
		
	}
	else
	{
		window.alert("Please choose a valid choice.");
	}
}
function getRegisterListByName()
{
	var url = 'ViewRegisterController';
	var val=document.getElementById("searchnamestyle").value;
	var param = "searchnamestyle="+val;
		if(window.XMLHttpRequest)
		{
			xmlHttp = new XMLHttpRequest();
		}
		else if(window.ActiveXObject)
		{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.open("POST", 'ViewRegisterController', true);
		xmlHttp.send(param);
	xmlHttp.onreadystatechange = function()
	{
		
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
		{
			var l =document.getElementById("CountryStyle").options.length;
			for(i=0;i<l;i++)
				{
				documentgetElementById("CountryStyle").remove(0);
				}
			 document.getElementById("CountryDropStyle").innerHTML=""; 
			var res = xmlHttp.responseText;
			var data = res.split("-");
			var arr;
			var opt;
			opt = document.createElement("OPTION");
			for(i = 0;i<data.length-1;i++)
			{
				arr = data[i];
				 opt = new Option(arr);
				document.getElementByid("CountryDropStyle").options.add(opt); 
				opt = document.createElement("OPTION");
				opt.text = arr;
				document.getElementById("CountryStyle").options.add(opt);
			}
		}
	}
		
	
	 /*xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); */
	var res = xmlHttp.responseText;
}