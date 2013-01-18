require([
  "debug","app/contact/ContactView"
], function(debug, ContactView){
	
	$(function(){
		$("body").layout({
			applyDefaultStyles : false,
			closable : false,
			resizable : false,
			north__size : 50,
			west__size : 150,
			south__size : 20
		});
		
		var $content = $("#content");
		
		$("#menu_contact").click(function(){
			$content.empty();
			var contactView = new ContactView({
				$wrapper : $content
			});
			contactView.init();
		});
	});
});