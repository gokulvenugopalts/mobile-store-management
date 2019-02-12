/**
 * 
 */
function getOperList()
{
	document.getElementById("opersystemstyle").disabled = false;
	var url = 'AddRegisterController';
	var val="";
	var param = "AddRegisterController="+val;
	var xmlHttp;
	var l =document.getElementById("opersystemstyle").options.length;
	for(i=0;i<l;i++)
	{
		document.getElementById("opersystemstyle").remove(0);
	}
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttp.open("post",'AddRegisterController', true);
	xmlHttp.send();
	xmlHttp.onreadystatechange = function()
	{
		
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
		{
			var res = xmlHttp.responseText;
			var data = res.split("-");
			var arr;
			var opt;
			for(i = 0;i<data.length-1;i++)
			{
				arr = data[i].split(":");
				/*opt = new Option(arr[1],arr[0]);*/
				opt = document.createElement("OPTION");
				opt.text = arr[1];
				opt.value = arr[0];
				opt.name = arr[1];
				document.getElementById("opersystemstyle").options.add(opt);
			}
		}
	}
	
	var res = xmlHttp.responseText;
}
