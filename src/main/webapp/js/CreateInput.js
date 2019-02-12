/**
 * 
 */
function checkCost()
{
	var cost = document.getElementById("searchcoststyle");
	if(cost.value >= 0)
	{
		return true;
	}
	else
	{
		window.alert("Please enter a valid cost");
		return false;
	}
}
function checkName()
{
	var name = document.getElementById("searchnamestyle").value;
	var nameRegex = /^[a-z A-Z]+$/;
	if(nameRegex.test(name))
	{
		return true;
	}
	else
	{
		window.alert("Enter a valid name.");
		return false;
	}
}
