define([
  "app/common/inherit"
], function(inherit) {
	var ajax = {};
	
	var observe = function(name, observers, arg){
		if (!observers) return;
		
		function apply(o) {
			if (o.name) o[name](arg);
		}
		
		if ($.isArray(observers)) {
			observers.forEach(apply);
		}else {
			apply(observers);
		}
	};
	
	var Processor = inherit(
		Object,
		function(){
			this.name = "Processor";
			var observers = this.observers;
			
			var self = this;
			var opts = {};
			for (var p in self) {
				opts[p] = self[p];
			}
			
			this.ajaxOpts = $.extend({
				async : false,
				cache : false,
				complete : function(xhr, st){
					observe("complete", observers, {xhr : xhr, textStatus : st});
				},
				beforeSend : function(xhr){
					observe("beforeSend", observers, {xhr : xhr});
				},
				success : function(data, dataType){
					self.success(data, dataType);
				},
				error : function(xhr, st, e){
					observe("error", observers, {xhr : xhr, textStatus : st, errorThrown : e});
				}
			}, opts);
		},
		{
			_buildAjaxOpts : function(param) {
				var opts = {};
				var ajaxOpts = this.ajaxOpts;
				for (var p in ajaxOpts) {
					opts[p] = ajaxOpts[p];
				}
				return $.extend(opts, param);
			},
			
			process : function(param) {
				$.ajax(this._buildAjaxOpts(param));
			},
			
			success : function(data, dataType){
				throw new Error("Please override : success");
			}
		}
	);
	
	ajax.Processor = Processor;
	
	return ajax;
});