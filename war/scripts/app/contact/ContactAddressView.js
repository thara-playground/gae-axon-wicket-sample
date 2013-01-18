define([
  "debug",
  "common/inherit",
  "common/util",
  "app/contact/AddressGrid",
  "app/contact/api/ContactAddressApi"
],function(debug, inherit, util, AddressGrid, api) {

	var ContactAddressView = inherit(
		Object,
		function(){
			this.name = "ContactAddressView";
			debug.assert(typeof this.contactView != "undefined");
			debug.assert(typeof this.$wrapper != "undefined");
			
			var self = this;
			
			var contactView = this.contactView;
			
			var $form = $("form[name='addressForm']");
			
			$("input[name='createAddress']").click(function(){
				var id = contactView.selectedId();
				api.createAddress({
					contactId : id,
					data : util.form2Hash($form),
					callback : function(){
						self.loadList();
					}
				});
			});
			
			$("input[name='deleteAddress']").click(function(){
				var id = contactView.selectedId();
				var addressType = $("select[name='addressType']").val();
				api.deleteAddress({
					contactId : id,
					addressType : addressType,
					callback : function() {
						self.loadList();
					}
				});
			});
			this.grid = new AddressGrid(); 
		},
		{
			init : function() {
			},
			loadList : function(param) {
				var contactId = param ? param.contactId : this.contactId; 
				debug.assert(typeof contactId != "undefined");
			
				this.contactId = contactId;
				this.grid.reload({
					contactId : contactId
				});
			}
		}
	);
	
	return ContactAddressView;
});