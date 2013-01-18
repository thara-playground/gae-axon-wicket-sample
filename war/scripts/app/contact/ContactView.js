define([
  "debug",
  "common/inherit",
  "app/contact/ContactAddressView",
  "app/contact/api/ContactApi",
  "text!app/contact/tmpl/content.html",
  "text!app/contact/tmpl/contactEntry.html"
],function(debug, inherit, ContactAddressView, api, contentHTML, entryHTML) {

	var ContactView = inherit(
		Object,
		function(){
			this.name = "ContactView";
			debug.assert(typeof this.$wrapper != "undefined");

			this.$wrapper.html(contentHTML);
			
			var addressView = this.addressView = new ContactAddressView({
				contactView : this,
				$wrapper : $("div#address_wrapper")
			});
			
			var self = this;
			
			var $form = this.$form = $("form[name='contact']");
			
			var $selectedId = this.$selectedId = $("input#selected_identifier");
			var $contactName = $("input#current_contact_name");
			
			var $selectedContact = $("li.contact_name").live("click", function(){
				var id = $(this).children("input[name='identifier']").val();
				$selectedId.val(id);
				var name = $(this).children("input[name='contact_name']").val();
				$contactName.val(name);
				addressView.loadList({
					contactId : id
				});
			});
			
			$("input[name='edit_contact']").click(function(){
				var id = $selectedId.val();
				var name = $contactName.val();
				api.editContact({
					id : id,
					name : name,
					callback : function(){
						self.loadContactList();
					}
				});
			});
			
			$("input[name='delete_contact']").click(function(){
				var id = $selectedId.val();
				api.deleteContact({
					id : id,
					callback : function(){
						$contactName.val("");
						$selectedId.val("");
						self.loadContactList();
					}
				});
			});
			
			$("input[name='unselected']").click(function(){
				$contactName.val("");
			});
			
			var $createContact = $("input[name='create_contact']").click(function(){
				self.operationEnabled(false);
				api.createContact({
					name : $contactName.val(),
					callback : function(data){
						self.loadContactList(data);
						self.operationEnabled(true);
					}
				});
			});
			
			$("input[name='reload_list']").click(function(){
				self.loadContactList();
			});
			
			this.operationEnabled = function(enabled){
				$createContact.attr("disabled", enabled ? "" : "disabled");
			};
			
			this.addressView.init();
		},
		{
			init : function(){
				this.loadContactList();
			},
			
			loadContactList : function(){
				$(".contact_entries").empty();
				api.loadContactList({
					callback : function(data){
						$.tmpl(entryHTML, data).appendTo(".contact_entries");
					}
				});
			},
			
			selectedId : function() {
				return this.$selectedId.val();
			}
		}
	);
	
	return ContactView;
});