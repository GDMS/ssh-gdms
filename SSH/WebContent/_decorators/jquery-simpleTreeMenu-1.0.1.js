/* SimpleTreeMenu */

(function($) {

	var methods = {
		
		init: function() {
			var $this = $(this);
	    	return this.each(function() {
	    		if ($this.hasClass("simpleTreeMenu")) {
	    			// Already done...
	    		}
	    		else {
					$this.hide();
					$(this).addClass("simpleTreeMenu");
					$this.children("li").each(function() {
						methods.buildNode($(this));
					});	
					$(this).show();	
				}
	    	});		
		},
		
		buildNode: function($li) {
			if ($li.children("ul").length > 0) {
				$li.children("ul").hide();
				$li.addClass("Node").click(function(event) {
					var $t = $(this);
					if ($t.hasClass("expanded")) {
						$t.removeClass("expanded");
						$t.children("ul").hide();
					} else {
						$t.addClass("expanded");
						$t.children("ul").show();
					}
					event.stopPropagation();
				});    
				$li.children("ul").children("li").each(function() {
					methods.buildNode($(this));
				});
			} else {
				$li.addClass("Leaf").click(function(event) {
					event.stopPropagation();
				});
				return;
			}		
		}
		
	};
	
	$.fn.simpleTreeMenu = function(method) {
	    if (methods[method]) {
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
	    } else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
	    } else {
			$.error('Method ' +  method + ' does not exist on jQuery.simpleTreeMenu');
	    }    	
	};
	
})(jQuery);


			
			
	