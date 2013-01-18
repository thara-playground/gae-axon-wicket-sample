define([
  "debug",
  "common/util",
  "common/ajax",
  "common/inherit"
],function(debug, util, ajax, inherit) {

	var contactURL = util.getServicePath("contact/");
	
	function getAddressURL(contactId) {
		return contactURL + contactId + "/address";
	}
	
	var ContactAddressApi = inherit(
		Object,
		function(){
			this.name = "ContactAddressApi";
			
			this.listModel = new ajax.Processor({
				type : "GET",
				dataType : "json"
			});
			
			this.createModel = new ajax.Processor({
				type : "PUT",
				dataType : "json",
				contentType : "application/json",
				processData : false
			});
			
			this.deleteModel = new ajax.Processor({
				type : "DELETE",
				dataType : "json"
			});
			
			this.getAddressURL = getAddressURL;
		},
		{
			createAddress : function(param) {
				debug.assert(typeof param.contactId != "undefined");
				debug.assert(typeof param.data != "undefined");
				debug.assert(typeof param.callback != "undefined");
				
				this.createModel.process({
					url : getAddressURL(param.contactId),
					data : $.toJSON(param.data),
					success : param.callback
				});
			},
			
			deleteAddress : function(param) {
				debug.assert(typeof param.contactId != "undefined");
				debug.assert(typeof param.addressType != "undefined");
				debug.assert(typeof param.callback != "undefined");
				
				this.deleteModel.process({
					url : getAddressURL(param.contactId) + "/" + param.addressType,
					success : param.callback
				});
			}
		}
	);
	
	return new ContactAddressApi();
});