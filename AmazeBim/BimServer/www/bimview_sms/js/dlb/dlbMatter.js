window.qyMenu = function(){
 	$("#dialogBoxCompany").css('zIndex',++Global.data.zIndex).load(Global.baseDir + "dialogCompany.html", function(){
		$("#dialogBoxCompany").show();
		new DialogCompany();
	});
};
window.jzMenu = function(){
 	$("#dialogBox").css('zIndex',++Global.data.zIndex).load(Global.baseDir + "dialogBuilding.html", function(){
		$("#dialogBox").show();
		new DialogBuilding();
	});
};