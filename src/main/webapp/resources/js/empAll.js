/**
 * 
 */

//alert("load전에 수행된다.");
//이벤트속성에 이벤트가 발생했을때 수행할 로직을 넣는다.
//이벤트핸들러(리스너)-함수 
window.onload = function(){
	//alert("load후에 수행된다.");
	var btnObj = document.querySelector("#search1");
	btnObj.onclick = s_search;  //callback함수이다. 
};

function s_search() {
	    //"100점"->Number("100점")->NaN
	    //"100점"->parseInt("100점")->100
		var a = parseInt(document.getElementById("sal").value);
		var salaries = document.querySelectorAll("td:nth-child(4)");
		for (var i=0; i < salaries.length; i++) {
			var b = salaries[i].textContent;  //innerHTML  <td><h1>5000</h1></td>
			if (parseInt(b) >= a) {
				//salaries[i].parentElement.style.backgroundColor = "beige";
				salaries[i].style.backgroundColor = "beige";
			}else{
				//salaries[i].parentElement.style.backgroundColor = "white";
				salaries[i].style.backgroundColor = "white";
			}
		}
}





