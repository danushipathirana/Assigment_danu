function isValidFormSeller()
{
	if($.trim($("#txtSellermName").val())=="")
	{ return "enter Seller name"; }
	return "true/false";
}

//--items   save/update
$(document).on("click","#btnSave",function()
{
			var result = isValidFormSeller();
			if(result=="true")
				{ $("#formSeller").submit(); }
			
			else
				{ $("#divStsMsgSeller").html(result); }
				
});

//--edit
$(document).on("click","#btnEdit",function()
{
	$("#hidMode").val(update);
	$("#hidID").val($(this).attr("param"));
	$("#txtSellerName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#txtSellerDesc").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtSellerAddr").val($(this).closest("tr").find('td:eq(3)').text());
	$("#txtSellerPhone").val($(this).closest("tr").find('td:eq(4)').text());
});
//--Remove
$(document).on("click","#btnRemove", function()
{
	$("#hidMode").val("remove");
	$("#hidID").val($(this).attr("param"));
	var res = confirm("are you sure?");
		if(res == true){
			$("#formSeller").submit();
		}


});
