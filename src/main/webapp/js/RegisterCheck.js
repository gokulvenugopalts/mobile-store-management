/**
 * 
 */
function check()
{
		var name = document.getElementById("namestyle").value;
		var id = document.getElementById("opersystemstyle").selectedIndex;
		var oper = document.getElementById("opersystemstyle").options[id].value;
		var modelname = document.getElementById("modelnamestyle").value;
		var modelcost = document.getElementById("modelcoststyle").value;
		var addDataRegex = /^[a-zA-Z ]+$/;
		if(addDataRegex.test(name))
		{
			addDataRegex = /^[0-9]+$/;
			if(addDataRegex.test(oper) && oper != 0)
			{
				addDataRegex = /^[a-zA-Z0-9 ]+$/;
				if(addDataRegex.test(modelname))
				{
					addDataRegex = /^[0-9]+$/;
					if(addDataRegex.test(modelcost) && modelcost > 0)
					{
						return true;
					}
					else
					{
						window.alert("Please enter a valid model cost.");
						return false;
					}
				}
				else
				{
					window.alert("Please enter a valid model name.");
					return false;
				}
			}
			else
			{
				window.alert("Please choose an operating system.");
				return false;
			}
		}
		else
		{
			window.alert("Please enter a valid name.");
			return false;
		}
}