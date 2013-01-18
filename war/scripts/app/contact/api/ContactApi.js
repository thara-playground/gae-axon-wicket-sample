define([
  "debug",
  "common/util",
  "common/ajax",
  "common/inherit",
],function(debug, util, ajax, inherit) {

	var contactURL = util.getServicePath("contact");
	
	var ContactApi = inherit(
		Object,
		function(){
			this.name = "ContactApi";
			
			this.listModel = new ajax.Processor({
				type : "GET",
				dataType : "json",
				url : contactURL
			});
			
			this.createModel = new ajax.Processor({
				type : "PUT",
				dataType : "text",
				url : contactURL
			});
			
			this.editModel = new ajax.Processor({
				type : "POST",
				dataType : "text"				
			});
			
			this.deleteModel = new ajax.Processor({
				type : "DELETE",
				dataType : "text"
			});
		},
		{
			loadContactList : function(param) {
				debug.assert(typeof param.callback != "undefined");
				this.listModel.process({
					success : param.callback
				});
			},
			
			createContact : function(param) {
				debug.assert(typeof param.name != "undefined");
				debug.assert(typeof param.callback != "undefined");
				
				this.createModel.process({
					data : {
						newContactName : param.name
					},
					success : param.callback
				});
			},
			
			editContact : function(param) {
				debug.assert(typeof param.id != "undefined");
				debug.assert(typeof param.name != "undefined");
				debug.assert(typeof param.callback != "undefined");

				this.editModel.process({
					url : contactURL + "/" + param.id,
					data : {
						newContactName : param.name
					},
					success : param.callback
				});
			},
			
			deleteContact : function(param) {
				debug.assert(typeof param.id != "undefined");
				debug.assert(typeof param.callback != "undefined");
				
				this.deleteModel.process({
					url : contactURL + "/" + param.id,
					success : param.callback
				});
			}
		}
	);
	
	return new ContactApi();
});