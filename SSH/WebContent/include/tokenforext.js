// 移动Struts2 中的s:token标签生成的input元素到extjs生成的form元素中
Ext.onReady(function() {
			$("#token input").each(function() {
						$(this).insertAfter($("form").children().last());
					});
		});
