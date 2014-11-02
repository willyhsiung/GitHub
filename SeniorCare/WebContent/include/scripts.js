//$Id: scripts.js,v 1.2 2014/09/24 18:55:51 jdurso Exp $
function goTo(list){
    var selection = list.options[list.selectedIndex].value;
    if (selection != "None"){
      location.href = selection;
    }
}

var is_regexp = (window.RegExp) ? true : false;

function fetch_object(idname) // get an element by id
{
		if (document.getElementById) //Internet Explorer 5+ & FireFox
		{
		    return document.getElementById(idname);
		}
		else if (document.all) //Internet Explorer 4
		{
		    return document.all[idname];
		}
		else if (document.layers) //Netscape
		{
		    return document.layers[idname];
		}
}


function switch_view(link) //switches between combined and split views in portData form
{
        if (!is_regexp) return false;
        switch (link.title)
        {
        	case "view split layout":
        		{
        			showHide('MDISDN', 'on');
        			showHide('Messages', 'off');
        			var linksArr = ["on","off"];
        			showHideLinks(linksArr);
        			swapLinks();
        		}
        	break;
        	case "view combined layout":
		       	{
		       		showHide('MDISDN', 'on');
		       		showHide('Messages', 'on');
		        	var linksArr = ["off","off"];
		        	showHideLinks(linksArr);
		        	swapLinks();
		        }
		    break;
       		case "View Message History":
       			{
       				showHide('MDISDN', 'off');
       				showHide('Messages', 'on');
        			var linksArr = ["off","on"];
        			showHideLinks(linksArr);
       			}
       		break;
       		case "View MSISDN List":
        		{
        			showHide('MDISDN', 'on');
        			showHide('Messages', 'off');
        			var linksArr = ["on","off"];
        			showHideLinks(linksArr);
       			}
       		break;
	       	case "alternate view":
       			{
       				showHide('MDISDN', 'on');
       				swapLinks();
       			}
       		break;
       		case "primary view":
       			{
       				showHide('MDISDN', 'off');
       				swapLinks();
       			}
       		break;
       	}
        return false;
}

function enableFields() {
	   
	   if (getElementByName('portingUMC').value != "GUI") {
		   getElementByName('portingURL').disabled      = false;
		   getElementByName('portingLogon').disabled      = false;
		   getElementByName('portingPassword').disabled      = false;
	   } else {
		   getElementByName('portingURL').disabled      = true;
		   getElementByName('portingLogon').disabled      = true;
		   getElementByName('portingPassword').disabled      = true;
	   }
	   
	   if (getElementByName('broadcastUMC').value != "GUI") {
		   getElementByName('broadcastURL').disabled      = false;
		   getElementByName('broadcastLogon').disabled      = false;
		   getElementByName('broadcastPassword').disabled      = false;
	   } else {
		   getElementByName('broadcastURL').disabled      = true;
		   getElementByName('broadcastLogon').disabled      = true;
		   getElementByName('broadcastPassword').disabled      = true;
	   }
} 

function swapLinks() // related to function switch_view
{
		var hdnLink, vsblLink, tempTitle, tempText;
		for (c=0; c<document.links.length; c++)
		{
			if (document.links[c].id == "hidden") hdnLink = document.links[c];
			if (document.links[c].id == "visible") vsblLink = document.links[c];

		}

		tempTitle = hdnLink.title;
		tempText = hdnLink.innerHTML;

		hdnLink.title = vsblLink.title;
		hdnLink.innerHTML = vsblLink.innerHTML;

		vsblLink.title = tempTitle;
		vsblLink.innerHTML = tempText;

		return false;
}

function showHide (objid, onOff) // related to function switch_view
{
  if (!is_regexp) return false;

        obj = fetch_object(objid.toString());

        if (!obj) return false;

		if (onOff == "on")
		    obj.style.display = "";
		    else
		    	obj.style.display = "none";
}

function showHideLinks (linksArr) // related to function switch_view
{
	if (document.layers)  //Netscape
            {
		var obj = [document.layers['view_msg'], document.layers['view_MDISDN']];
		visible = 'show';
  		hidden = 'hide';
            }
        else if (document.all || document.getElementById)  //Internet Explorer & FireFox
            {
    		var obj = [document.all('view_msg').style, document.all('view_MDISDN').style];
    		visible = 'visible';
  		hidden = 'hidden';
            }

        if (!obj) return false;

		for (c=0; c<linksArr.length; c++)
		{
                    if (linksArr[c] == "on")
		    	obj[c].visibility = visible;
		    else
		    	obj[c].visibility  = hidden;
		}

}

function checkAll(formobj, setto) //Select/Deselect All checkboxes
{
        for (var i =0; i < formobj.elements.length; i++)
        {
                var elm = formobj.elements[i];
                if (elm.type == "checkbox")
                {
                  if(elm.disabled == false){
                    elm.checked = setto;
                  }
                }
        }
        return false;
}

function setCheckAll()
{
        var formobj = document.forms[1];
        for (var i =0; i < formobj.elements.length; i++)
        {
                var elm = formobj.elements[i];
                if (elm.type == "checkbox" && elm.checked == false && elm.id != 'allbox')
                {
                        fetch_object('allbox').checked = false;
                        return false;
                }
        }
        fetch_object('allbox').checked = true;
}

function setOptions(ctype) { //used in newPort form
	if (ctype=='Consumer') {
		fetch_object('custtype-consumer-label').style.color='#336';
		fetch_object('custtype-corporate-label').style.color='#BBB';
		fetch_object('reglabel').style.color='#BBB';
		fetch_object('personlabel').style.color='#BBB';
		fetch_object('phonelabel').style.color='#BBB';
		getElementByName('regNumber').disabled=true;
		getElementByName('contactPerson').disabled=true;
		getElementByName('contactPhone').disabled=true;
                getElementByName('consumer').checked=true;
	} else {
		fetch_object('custtype-consumer-label').style.color='#BBB';
		fetch_object('custtype-corporate-label').style.color='#336';
		fetch_object('reglabel').style.color='#336';
		fetch_object('personlabel').style.color='#336';
		fetch_object('phonelabel').style.color='#336';
		getElementByName('regNumber').disabled=false;
		getElementByName('contactPerson').disabled=false;
		getElementByName('contactPhone').disabled=false;
	}
}

function getElementByName (elmntName)
{
    var obj = document.getElementsByName(elmntName)[0];
    
                if ((obj.type != null & obj.type == 'radio' & obj.value == elmntName) || (obj.name == elmntName))
                {
                    return obj;
                }
	return false;
}

function checkButton(formName,buttonValue){
    document.forms[formName].buttonPressed.value ="true";
    document.forms[formName].buttonName.value=buttonValue;
    document.forms[formName].submit();
}

function tableColor(tableName){
      var tbl = fetch_object(tableName);
      var lastRow = tbl.rows.length;
   	  for (var c=1; c < lastRow; c++){
   	  	tbl.rows[c].className = ((c%2 == 0) ? "even" : "odd");
   	  }
      return false;
}

//////////////////////Table Sorting Code////////////////////////
var SORT_COLUMN_INDEX;

function ts_getInnerText(el) {
	if (typeof el == "string") return el;
	if (typeof el == "undefined") { return el };
	if (el.innerText) return el.innerText;	//Not needed but it is faster
	var str = "";

	var cs = el.childNodes;
	var l = cs.length;
	for (var i = 0; i < l; i++) {
		switch (cs[i].nodeType) {
			case 1: //ELEMENT_NODE
				str += ts_getInnerText(cs[i]);
				break;
			case 3:	//TEXT_NODE
				str += cs[i].nodeValue;
				break;
		}
	}
	return str;
}

function resortTable(lnk,clid,formName,fieldName){

  document.forms[formName].orderbyField.value=fieldName;
  document.forms[formName].orderbyCol.value=clid;

  document.forms[formName].submit();

}

function ts_resortTable(lnk,clid,type) {
    // get the span
    var span;
    for (var ci=0;ci<lnk.childNodes.length;ci++) {
        if (lnk.childNodes[ci].tagName && lnk.childNodes[ci].tagName.toLowerCase() == 'span') span = lnk.childNodes[ci];
    }

    var td = lnk.parentNode;
    var column = clid || td.cellIndex;
    var table = getParent(td,'TABLE');

    // Work out a type for the column
    if (table.rows.length <= 1) return;

    var itm = ts_getInnerText(table.rows[1].cells[column]);
    if (type == "string"){
    	sortfn = ts_sort_caseinsensitive;
    }
    else if(type == "date"){
    	sortfn = ts_sort_date; //yyyy-mm-dd hh:mm:ss
    }
    else{
    	sortfn = ts_sort_numeric;
    }

    SORT_COLUMN_INDEX = column;
    var firstRow = new Array();
    var newRows = new Array();
    for (i=0;i<table.rows[0].length;i++) { firstRow[i] = table.rows[0][i]; }
    for (j=1;j<table.rows.length;j++) { newRows[j-1] = table.rows[j]; }

    newRows.sort(sortfn);
    if (span.getAttribute("sortdir") == 'down' || (clid == '1' && span.getAttribute("sortdir") == null)) {
        ARROW = '&nbsp;<img src="' + getElementByName('sortAscending').src +'" border="0">';
        newRows.reverse();
        span.setAttribute('sortdir','up');
    } else {
        ARROW = '&nbsp;<img src="' + getElementByName('sortDescending').src +'" border="0">';
        span.setAttribute('sortdir','down');
    }

    lnk.className = "ts2";
    for (i=0;i<newRows.length;i++) table.tBodies[0].appendChild(newRows[i]);

    // Delete any other arrows there may be showing
    var allspans = document.getElementsByTagName("span");
    for (var ci=0;ci<allspans.length;ci++) {
        if ((allspans[ci].className == 'sortarrow') && (allspans[ci] != span)) {
            if (getParent(allspans[ci],"table") == getParent(lnk,"table")) { // in the same table as us?
                allspans[ci].innerHTML = '&nbsp;<img src="' + getElementByName('sortOff').src +'" border="0">';
                allspans[ci].setAttribute('sortdir','');
            }
        }
    }

    var allLinks = document.links;
    for (var ci=0;ci<allLinks.length;ci++) {
        if ((allLinks[ci].className != '') && (allLinks[ci] != lnk) &&
        	(getParent(allLinks[ci],"table") == getParent(lnk,"table"))) {
                allLinks[ci].className = 'ts1';
            }
        }

    span.innerHTML = ARROW;
    tableColor(getParent(lnk,"table").id);

    return false;
}

function getParent(el, pTagName) {
	if (el == null) return null;
	else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())	// Gecko bug, supposed to be uppercase
		return el;
	else
		return getParent(el.parentNode, pTagName);
}
function ts_sort_date(a,b) {
    aa = ts_getInnerText(a.cells[SORT_COLUMN_INDEX]);
    bb = ts_getInnerText(b.cells[SORT_COLUMN_INDEX]);

    dt1 = aa.replace("-","");
    dt1 = aa.replace(":","");
    dt1 = aa.replace(" ","");

    dt2 = bb.replace("-","");
    dt2 = bb.replace(":","");
    dt2 = bb.replace(" ","");


    if (dt1==dt2) return 0;
    if (dt1<dt2) return -1;
    return 1;
}


function ts_sort_numeric(a,b) {
    aa = parseFloat(ts_getInnerText(a.cells[SORT_COLUMN_INDEX]));
    if (isNaN(aa)) aa = 0;
    bb = parseFloat(ts_getInnerText(b.cells[SORT_COLUMN_INDEX]));
    if (isNaN(bb)) bb = 0;
    return aa-bb;
}

function ts_sort_caseinsensitive(a,b) {
    aa = ts_getInnerText(a.cells[SORT_COLUMN_INDEX]).toLowerCase();
    bb = ts_getInnerText(b.cells[SORT_COLUMN_INDEX]).toLowerCase();
    if (aa==bb) return 0;

    if (bb == "" || aa < bb)
    {
        return -1;
    }
//    if (aa < bb) return -1;

    return 1;
}
/////////////////////////////End of Sorting Code///////////////////////

function formatDateTime(field, length, dateSep, timeSep)
{
  if (!length) length = 19;

  var value = stripNonDigits(field.value);
  value = insertDelimiter(value,  4, dateSep);
  value = insertDelimiter(value,  7, dateSep);
  if (length > 10){
    value = insertDelimiter(value, 10, ' ');
    value = insertDelimiter(value, 13, timeSep);
    value = insertDelimiter(value, 16, timeSep);
  }

  if (value.length > length) value = value.substr(0, length);

  if (field.value != value) field.value = value;

}

function disenable(disen) 
{
var numberGroup = document.getElementById('numberG');

if (disen == "disable") {
numberGroup.disabled = true;
numberGroup.style.background = '#D0D0D0';
numberGroup.style.border = '1px solid #7F9DB9';
numberGroup.style.height = "22px";
numberGroup.style.width = "184px";

} else if (disen == "enable") {
numberGroup.disabled = false;
numberGroup.style.background = 'white';
numberGroup.style.border = '1px solid #7F9DB9';
numberGroup.style.height = "22px";
numberGroup.style.width = "184px";
numberGroup.focus();
}
}

// Insert a delimiter at a position
//
function insertDelimiter(value, position, delimiter)
{
  if ((value.length >= position+1) && (value.charAt(position) != delimiter))
    return value.substr(0, position) + delimiter + value.substr(position)
  else
    return value
}

// Remove non-digit characters
//
function stripNonDigits(value)
{
  var rv = ""
  for (var i=0; i<value.length; i++) {
    if (value.charAt(i).match(/\d/)) rv += value.charAt(i)

  }

  return rv;
}

function formatAlphaNumeric(field)
{
    var rv = "";
    for (var i=0; i<field.value.length; i++) {
      if (field.value.charAt(i).match(/[a-zA-Z0-9]/)) rv += field.value.charAt(i)
    }

  if (field.value != rv) field.value = rv;
}

function formatNumeric(field)
{
    var rv = "";
    for (var i=0; i<field.value.length; i++) {
      if (field.value.charAt(i).match(/\d/) && field.value.charAt(i) != " ") rv += field.value.charAt(i)
    }
    if (field.value != rv) field.value = rv;
}

function formatCurrency(field)
{
	var rv = "";
    for (var i=0; i<field.value.length; i++) {
      if ((field.value.charAt(i).match(/\d/) || field.value.charAt(i).match(/[.]/)) && field.value.charAt(i) != " ") rv += field.value.charAt(i)
    }
    if (field.value != rv) field.value = rv;
    
//  var value = stripNonDigits(field.value);
//  if (value.length < 2) {
//	  if (field.value != value) field.value = value;
//	  return value;
//  }
//  
//  value = insertDelimiter(value,  value.length-2, '.');
//
//  if (field.value != value) field.value = value;
//  
//  return value;

}

function formatNonBlankSpace(field)
{
    var rv = "";
    for (var i=0; i<field.value.length; i++) {
      if (field.value.charAt(i).match(/[a-zA-Z0-9]/) && field.value.charAt(i) != " ") rv += field.value.charAt(i)
    }
    if (field.value != rv) field.value = rv;
}

function formatNonLeadingBlankSpace(field)
{
    var rv = "";
    for (var i=0; i<field.value.length; i++) {
      if (field.value.charAt(0) != " ") rv += field.value.charAt(i)
    }
    if (field.value != rv) field.value = rv;
}

function gotoPage(field){ //paging drop down list
	field.form.isNewQuery.value = "false";
	field.form.pageNumber.value = field.selectedIndex + 1;
    field.form.submit();
}

function gotoPage(field){ //paging drop down list
    field.form.action.value = "";
	field.form.isNewQuery.value = "false";
	field.form.pageNumber.value = field.selectedIndex + 1;
    field.form.submit();
}

function checkMaxLength(field, maxLen){
  if (field.value.length > maxLen){
    var text = field.value.substr(0, maxLen);
    field.value = text;
  }
}

function logout(){
		var response = confirm("Do you really want to logout?");
		if (response == true){
		           window.location = "login.do?logoff=yes";
    		                 }

          }
          
function confirmChkDelete(formName, buttonValue){
  	
	 if (buttonValue == 'deleteUsers') {
	    var formobj = document.forms[1];
		for (var i =0; i < formobj.elements.length; i++) {
           var elm = formobj.elements[i];
           if (elm.type == "checkbox" && elm.checked == true)
           {
	      		var response = confirm("Do you really want to delete the selected users(s)?");
				if (response == true){
					document.forms[formName].deleteUsers.value='delete';
					document.forms[formName].submit();
				}
				else {
					getElementByName("deleteUsers").value = "";
				}
				break;
           }
      	 }
  	  }
}    

function confirmDelete(formName) {
	var response = confirm("Do you really want to delete " + getElementByName("userId").value + "?");
	if (response == true) {
		document.forms[formName].deleteUser.value='delete';
		document.forms[formName].submit();
	}
	else {
		getElementByName("delete").value = "";
	}
}

function handleEnterKey(e){ // attach onkeypress event listener for each input field
            var keycode;
                if (window.event) {//IE
                    keycode = window.event.keyCode;
                }else if (e) {  //FF
                    keycode = e.which;
                }else {
                    return true;
                }
                if(keycode==13){
                    window.forms[0].submitPortRequest.click();  // emulates click on defaultSubmit button
                    return false;   // stops propagating keypress event
                }
          }
          
          function countRows(){
            
        	  var tableID="dataTable";
              var rowCount = 0; 
              var rowindex=0;
              for(i=0;i<1;++i )
              {
              var tablesID=tableID+i;
              var table=document.getElementById(tablesID); 
              rowCount=table.rows.length;
              rowCount=rowCount-1;
              rowindex=rowindex+rowCount;
             }
              return rowindex;
          }
            
            function addRow(tableID,msgType,causeType) {  
            	var table = document.getElementById(tableID);    
              var rowCount = table.rows.length;  
              var row = table.insertRow(rowCount);  
             var rowsIndex=countRows();
              rowCount=rowsIndex-1;
              var cell1 = row.insertCell(0);  
              var element = document.createElement("input");  
              element.type = "hidden";  
              element.name="rejectCodeList["+rowCount+"].msg_type";
              element.value=msgType;
              cell1.appendChild(element);
                
              var cell2 = row.insertCell(1);  
              var element1 = document.createElement("input");  
              element1.type = "checkbox";  
              cell2.appendChild(element1);
   
              var cell3 = row.insertCell(2);  
              var element2 = document.createElement("input");  
              element2.type = "text";  
              element2.name="rejectCodeList["+rowCount+"].cause_id";
              element2.onkeyup = function() { formatNonBlankSpace(element2); };
              element2.maxLength = 20;
              cell3.appendChild(element2);
           
              var cell4 = row.insertCell(3);  
              var element0 = document.createElement("input");  
              element0.type = "hidden";  
              element0.name="rejectCodeList["+rowCount+"].service_type";
              element0.value="MOBILE";
              cell4.appendChild(element0);
               
              var cell5 = row.insertCell(4);  
              var element3 = document.createElement("input");  
              element3.type = "text";  
              element3.name="rejectCodeList["+rowCount+"].cause_text";
              element3.maxLength = 256
              element3.size =50
              cell5.appendChild(element3);
              var cell6 = row.insertCell(5);  
              var element4 = document.createElement("input");  
              element4.type = "hidden";  
              element4.name="rejectCodeList["+rowCount+"].cause_type";
              element4.value=causeType;
              cell6.appendChild(element4);
              //Add New Field (short_desc) Aug-10-2010
           
              var cell7 = row.insertCell(6);
              var element5 = document.createElement("input");  
              element5.type = "text";  
              element5.name="rejectCodeList["+rowCount+"].short_desc";
              element5.maxLength = 80
              cell7.appendChild(element5);
              
                          
              
              }
              
	function goToChange() {
   window.location = "changePassword.do?userName=" + getElementByName("userId").value + "&oldPassword=" + getElementByName("password").value;
   }
   
	function upperCase(field){

			 field.value = field.value.toUpperCase();
		}   