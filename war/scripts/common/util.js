define([
	"debug",
	"constant",
	"jquery/jquery.json-2.2.min"
], function(debug, constant) {

	var util = {};
	
	util.getRealPath = function(val){
		return constant.context + "/" + val;
	};
	
	util.getServicePath = function(val){
		return constant.context + "/service/" + val;
	};
	
	var toHash = util.toHash = function(h) {
		var p = {};
		$(h).each(function(i, v) {
			p[v.name] = v.value;
		});
		return p;		
	};
	
	var form2Hash = util.form2Hash = function($form) {
		debug.assert(typeof $form.serializeArray != "undefined");
		return toHash($form.serializeArray());
	};
	
	util.form2JSON = function($form) {
		return $.toJSON(form2Hash($form));
	};
	
	util.hash2JSON = function(hash) {
		return $.toJSON(hash);
	};
	
	
	return util;
});