// �ƶ�Struts2 �е�s:token��ǩ���ɵ�inputԪ�ص�extjs���ɵ�formԪ����
Ext.onReady(function() {
			$("#token input").each(function() {
						$(this).insertAfter($("form").children().last());
					});
		});
