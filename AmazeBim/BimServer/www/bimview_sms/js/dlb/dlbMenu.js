
var dlbMenuEvent = {};
(function ($) {
	window.dlbMenuEvent = {};
    var defaluts = {
        data:[
            {name:'上传模型',id:1,pId:0, onClick:function(){
        		poid = $('.project').attr('poid');
        		Global.bimServerApi.call("Bimsie1ServiceInterface", "getProjectByPoid", {poid:poid}, function(project){
        			var div = $("<div class=\"modal fade\">");
        			$(document.body).append(div);
        			div.load(Global.baseDir + "checkin.html", function(){
        				new Checkin($(this), project, function(){
        					window.location.reload();
        				});
        			}).modal({keyboard:true});
        		});
            }},
            /*{name:'下载模型',id:2,pId:0, onClick:function(){
				poid = $('.project').attr('poid');
				var list = [];
				parent.navigator.projecttree.gatherRoidList(parent.navigator.projecttree.selectedNode, list);
				list.push(parent.projects[0].lastRevisionId);
				var div = $("<div class=\"modal fade\">");
				$(document.body).append(div);
					
					var params = {
						downloadType: "downloadRevisions",
						roids: list
					};
				
					div.load(Global.baseDir + "download.html", function(){
						new Download($(this), params);
					}).modal({keyboard:true, show: true});
            }},*/
            /*{name:'空间管理',id:3,pId:0, onClick:null},
            {name:'建筑管理',id:4,pId:3, onClick:function(){jzMenu()}},*/
            {name:'企业管理',id:5,pId:0, onClick:function(){qyMenu()}}
        ]
    };

    $.fn.extend({
        "dlbMenu": function (options) {
            var opts = $.extend({}, defaluts, options);
            var headerHtml = '<div class="dlbMenu-header"><div class="dlbMenu-remove-ico"></div><div class="dlbMenu-cross-ico"></div></div>';
            var ul = $('<ul class="dlbMenu-list"></ul>');
            var tableHtml = '<div class="dlbMenu-subBox"><table class="dlbMenu-subMenu" cellpadding="0" cellspacing="0"></table></div>';
            var tableHeader = '<tr  onclick="dlbMenuEvent.event{{index}}()"><td class="subMenu-headLeft"></td><td class="subMenu-headName">{{name}}</td><td class="subMenu-headRight"></td></tr>'
            var tableBody = '<tr  onclick="dlbMenuEvent.event{{index}}()"><td class="subMenu-left"></td><td class="subMenu-name">{{name}}</td><td class="subMenu-right"></td></tr>';
            var tableEnd = '<tr><td class="subMenu-endLeft"></td><td class="subMenu-endR"></td><td class="subMenu-endRight"></td></tr>';
            var arr = '<span class="dlbMenu-arrow"></span>';
            var menuItems = {};
            this.each(function () {
                var $this = $(this);
                $.each(opts.data,function(index,data){
                	window.dlbMenuEvent['event'+(index)] = data.onClick;
                    if(data.pId==0){
                    	if($.isFunction(data.onClick)){
                    		var liHtml = '<li onclick="dlbMenuEvent.event'+(index)+'()" id="dlbMenuLi'+data.id+'"><div class="dlbMenu-last"><div class="dlbMenu-font">'+data.name+'</div></div></li>'
                    	}else{
                    		var liHtml = '<li id="dlbMenuLi'+data.id+'"><div class="dlbMenu-last"><div class="dlbMenu-font">'+data.name+'</div></div></li>'
                    	}
                        ul.append(liHtml);
                    }else{
                        menuItems[data.pId] = $.isArray(menuItems[data.pId]) ? menuItems[data.pId] : [];
                        menuItems[data.pId].push({id:data.id,name:data.name,index:index})
                    }
                });
                
                $this.append($(headerHtml));
                $this.append(ul);
                
                for(var key in menuItems){
                    var liBox = $('#dlbMenuLi'+key);
                    liBox.find('.dlbMenu-font').append($(arr));
                    liBox.append(tableHtml);
                    if(menuItems[key].length==1){
                        liBox.find('table').html(tableHeader.replace('{{name}}',menuItems[key][0].name).replace('{{index}}',menuItems[key][0].index)+tableEnd);
                    }else if(menuItems[key].length==2){
                        liBox.find('table').html(tableHeader.replace('{{name}}',menuItems[key][0].name).replace('{{index}}',menuItems[key][0].index)+ tableBody.replace('{{index}}',menuItems[key][1].index).replace('{{name}}',menuItems[key][1].name) +tableEnd);
                    }if(menuItems[key].length>2){
                        liBox.find('table').html(tableHeader.replace('{{name}}',menuItems[key][0].name).replace('{{index}}',menuItems[key][0].index));
                        $.each(menuItems[key],function(i,dd){
                            liBox.find('table').append($(tableBody.replace('{{index}}',dd.index).replace('{{name}}',dd.name)));
                        });
                        liBox.find('table').append($(tableEnd));
                    }
                }
                

                $('.dlbMenu li').each(function(index){
                	$(this).css("top",-(parseFloat(index) * 9) );
                });
                
            });
        }
    });

})(window.jQuery);